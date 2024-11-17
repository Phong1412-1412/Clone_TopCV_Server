package org.example.clone_topcv.entities.JobSeekerProfile;

import jakarta.persistence.*;
import lombok.*;
import org.example.clone_topcv.entities.PostAndLookingUpJob.JobPostSkillSet;

import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Builder
@Table(name = "skill_set")
public class SkillSet {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "skill_set_id", nullable = false, updatable = false)
    private int SkillSetId;
    @Column(name = "skill_set_name", nullable = false)
    private String skillSetName;

//    @ManyToMany(mappedBy = "skillSets")
//    private Set<SeeKerProfile> seeKerProfiles = new HashSet<SeeKerProfile>();

    @OneToMany(mappedBy = "skillSet", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Set<SeekerSkillSet> seekerSkillSets = new HashSet<>();

    @OneToMany(mappedBy = "skillSet", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @PrimaryKeyJoinColumn
    private Set<JobPostSkillSet> jobPostSkillSets = new HashSet<>();
}
