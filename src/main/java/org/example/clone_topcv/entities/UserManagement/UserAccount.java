package org.example.clone_topcv.entities.UserManagement;


import org.example.clone_topcv.entities.JobSeekerProfile.SeeKerProfile;
import org.example.clone_topcv.entities.PostAndLookingUpJob.JobPostActivity;
import org.example.clone_topcv.enums.Gender;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Builder
@Table(name = "user_account")
public class UserAccount {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "user_id", updatable = false, nullable = false)
    private UUID userId;

    @Column(name = "email", nullable = false)
    private String email;
    @Column(name = "password", nullable = false)
    private String password;
    @Column(name = "date_of_birth", nullable = false)
    private LocalDate dateOfBirth;
    @Column(name = "gender", nullable = false)
    private Gender gender;
    @Column(name = "is_active", nullable = false)
    private boolean isActive;
    @Column(name = "contact_number", nullable = false)
    private String contactNumber;
    @Column(name = "sms_notification_active", nullable = false)
    private boolean smsNotificationActive;
    @Column(name = "email_notification_active", nullable = false)
    private boolean emailNotificationActive;
    @Column(name = "user_image")
    private String userImage;
    @Column(name = "registration_date", nullable = false)
    private LocalDateTime registrationDate;


    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name= "user_type", nullable = false)
    private UserType userType;

    @OneToOne(mappedBy = "userAccount", cascade = CascadeType.ALL)
    @PrimaryKeyJoinColumn
    private UserLog userLog;


    @OneToOne(mappedBy = "userAccount", cascade = CascadeType.ALL)
    @PrimaryKeyJoinColumn
    private SeeKerProfile seeKerProfile;

    @OneToMany(mappedBy = "userAccount", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @PrimaryKeyJoinColumn
    private Set<JobPostActivity> jobPostActivities = new HashSet<>();
}
