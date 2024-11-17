package org.example.clone_topcv.entities.PostAndLookingUpJob;

import jakarta.persistence.*;
import lombok.*;
import org.example.clone_topcv.entities.JobSeekerProfile.SkillSet;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Builder
@Table(name = "job_post_skill_set")
public class JobPostSkillSet {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "skill_set_id", nullable = false, updatable = false)
    private int SkillSetId;

    private int skill_level;

    @ManyToOne
    @MapsId
    @JoinColumn(name = "skill_set_id")
    private SkillSet skillSet;

    @ManyToOne
    @MapsId
    @JoinColumn(name = "job_post_id")
    private JobPost jobPost;
}
