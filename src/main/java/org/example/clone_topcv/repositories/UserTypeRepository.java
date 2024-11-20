package org.example.clone_topcv.repositories;

import org.example.clone_topcv.entities.UserManagement.UserType;

import org.example.clone_topcv.enums.UserTypeEnum;
import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;


@Repository //được dùng để chỉ ra rằng lớp này chịu trách nhiệm xử lý logic liên quan đến cơ sở dữ liệu. (DAO - Data Access Object).
public interface UserTypeRepository extends JpaRepository<UserType, Integer> {
    @Query("SELECT u FROM UserType u WHERE u.userTypeName = :userTypeName")
    Optional<UserType> findByUserTypeName(@Param("userTypeName") UserTypeEnum userTypeName);
}
