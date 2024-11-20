package org.example.clone_topcv.entities.PostAndLookingUpJob;

import jakarta.persistence.*;
import lombok.*;
import org.example.clone_topcv.entities.CompanyProfiles.Company;
import org.springframework.context.annotation.EnableMBeanExport;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Builder
@Table(name = "job_post")
public class JobPost {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "job_post_id", nullable = false, updatable = false)
    private UUID jobPostId;

    private LocalDate createDate;
    private String jobDescription;

    private boolean is_active = true;

    @ManyToOne
    @JoinColumn(name = "company_id")
    private Company company;

    @ManyToOne
    @JoinColumn(name = "job_type_id")
    private JobType jobType;

    @ManyToOne
    @JoinColumn(name = "job_location_id")
    private JobLocaltion jobLocation;

    @OneToMany(mappedBy = "jobPost", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @PrimaryKeyJoinColumn
    private Set<JobPostActivity> jobPostActivities = new HashSet<>();

    @OneToMany(mappedBy = "jobPost", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @PrimaryKeyJoinColumn
    private Set<JobPostSkillSet> jobPostSkillSets = new HashSet<>();
}
