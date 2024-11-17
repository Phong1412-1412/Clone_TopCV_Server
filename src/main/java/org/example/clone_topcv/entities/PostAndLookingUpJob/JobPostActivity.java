package org.example.clone_topcv.entities.PostAndLookingUpJob;

import jakarta.persistence.*;
import lombok.*;
import org.example.clone_topcv.entities.UserManagement.UserAccount;

import java.time.LocalDate;
import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Builder
@Table(name = "job_post_activity")
public class JobPostActivity {
    @Id
    @Column(name = "user_id", nullable = false)
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID userId;

    private LocalDate applyDate;

    @ManyToOne
    @MapsId
    @JoinColumn(name = "user_id")
    private UserAccount userAccount;

    @ManyToOne
    @MapsId
    @JoinColumn(name = "job_post_id")
    private JobPost jobPost;
}
