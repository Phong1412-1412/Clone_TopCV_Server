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
@Table(name = "education_detail")
public class EducationDetail {
    @Id
    @Column(name = "user_id", nullable = false)
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID userId;

    private String certificateDegreeName;
    private String major;
    private String instituteUniversityName; //tên trường đại học viện
    private LocalDate startingDate;
    private LocalDate completionDate;
    private double GPA;

    @OneToOne
    @MapsId
    @JoinColumn(name = "user_id")
    private SeeKerProfile seekerProfile;

}
