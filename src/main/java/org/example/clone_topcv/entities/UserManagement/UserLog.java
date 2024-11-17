package org.example.clone_topcv.entities.UserManagement;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "user_log")
public class UserLog {
    @Id
    @Column(name = "user_id", nullable = false)
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID userId;

    @Column(name="last_login_Date")
    private LocalDateTime lastLoginDate;
    @Column(name="last_job_apply_date")
    private LocalDateTime lastJobApplyDate;

    @OneToOne
    @MapsId
    @JoinColumn(name = "user_id")
    private UserAccount userAccount;
}
