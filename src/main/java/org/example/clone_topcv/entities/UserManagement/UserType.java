package org.example.clone_topcv.entities.UserManagement;

import org.example.clone_topcv.enums.UserTypeEnum;
import jakarta.persistence.*;
import lombok.*;

import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "user_type")
public class UserType {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "user_type_id", nullable = false, updatable = false)
    private int userTypeId;

    @Column(name= "user_type_name" , nullable = false, unique = true)
    @Enumerated(EnumType.STRING)
    private UserTypeEnum userTypeName;

    @OneToMany(mappedBy = "userType")
    public Set<UserAccount> userAccounts = new HashSet<>();
}
