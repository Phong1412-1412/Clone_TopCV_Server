package org.example.clone_topcv.entities.JobSeekerProfile;

import jakarta.persistence.*;
import lombok.*;

import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Builder
@Table(name = "seeker_skill_set")
public class SeekerSkillSet {
    @Id
    @Column(name = "user_id", nullable = false)
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID userId;

    private int skillLevel;

    @ManyToOne
    @MapsId
    @JoinColumn(name = "user_id")
    private SeeKerProfile seekerProfile;

    @ManyToOne
    @JoinColumn(name = "skill_set_id")
    private SkillSet skillSet;
}
