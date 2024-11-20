package org.example.clone_topcv.servives;

import org.example.clone_topcv.DTO.UserTypeRequest;
import org.example.clone_topcv.entities.UserManagement.UserType;
import org.example.clone_topcv.enums.UserTypeEnum;
import org.example.clone_topcv.exception.MessageException;
import org.example.clone_topcv.repositories.UserTypeRepository;
import org.jetbrains.annotations.NotNull;
import org.springframework.stereotype.Service;

@Service
public class UserTypeService extends AbstractGenericService<UserType, Integer, UserTypeRepository>{

    public UserTypeService(UserTypeRepository userTypeRepository) {
        super(userTypeRepository);
    }

    public UserType saveUserType(@NotNull UserTypeRequest userTypeRequest) {
        if(repository.findByUserTypeName(UserTypeEnum.valueOf(userTypeRequest.getUserTypeEnum().toUpperCase())).isPresent()) {
            throw new MessageException("User type already exists");
        }
        UserType userType = new UserType();
        userType.setUserTypeName(UserTypeEnum.valueOf(userTypeRequest.getUserTypeEnum().toUpperCase()));
        return this.save(userType); // Gọi hàm `save` của AbstractGenericService
    }
}
