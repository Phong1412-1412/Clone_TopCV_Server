package org.example.clone_topcv.entities.JobSeekerProfile;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Builder
@Table(name = "experience_detail")
public class ExperienceDetail {
    @Id
    @Column(name = "user_id", nullable = false)
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID userId;

    private boolean isCurrentJob;
    private LocalDate startDate;
    private LocalDate endDate;
    private String jobTitle;
    private String companyName;
    private String jobLocation;
    private String jobDescription;

    @ManyToOne
    @MapsId
    @JoinColumn(name = "user_id")
    private SeeKerProfile seekerProfile;
}
