package org.example.clone_topcv.DTO;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.example.clone_topcv.enums.UserTypeEnum;
import org.jetbrains.annotations.NotNull;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UserTypeRequest {
    private String userTypeEnum;

    public UserTypeRequest setUserTypeEnum(@NotNull String userTypeName) {
        this.userTypeEnum = userTypeName.toUpperCase();
        return this;
    }
}
