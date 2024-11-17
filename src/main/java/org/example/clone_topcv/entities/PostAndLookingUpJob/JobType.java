package org.example.clone_topcv.entities.PostAndLookingUpJob;

import jakarta.persistence.*;
import lombok.*;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Builder
@Table(name = "job_type")
public class JobType {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "job_type_id")
    private int jobTypeId;

    @Column(name = "job_type_name", nullable = false)
    private String jobTypeName;

    @OneToMany(mappedBy = "jobType", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Set<JobPost> jobPosts = new HashSet<>();
}
