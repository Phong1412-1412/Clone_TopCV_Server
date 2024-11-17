package org.example.clone_topcv.entities.JobSeekerProfile;

import jakarta.persistence.*;
import lombok.*;
import org.example.clone_topcv.entities.UserManagement.UserAccount;

import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Builder
@Table(name = "seeker_profile")
public class SeeKerProfile {
    @Id
    @Column(name = "user_id", nullable = false)
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID userId;

    private String firstName;
    private String lastName;
    private BigDecimal currentSalary;

    @OneToOne
    @MapsId
    @JoinColumn(name = "user_id")
    private UserAccount userAccount;

    @OneToOne(mappedBy = "seekerProfile", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @PrimaryKeyJoinColumn
    private EducationDetail educationDetail;

    @OneToMany(mappedBy = "seekerProfile", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @PrimaryKeyJoinColumn
    private Set<ExperienceDetail> experienceDetails = new HashSet<>();

//    @ManyToMany
//    @JoinTable(
//            name = "seeker_profile_set", // Tên bảng trung gian
//            joinColumns = @JoinColumn(name = "user_id"),// Khóa ngoại đến bảng seekerProfile
//            inverseJoinColumns = @JoinColumn(name = "skill_set_id") // Khóa ngoại đến bảng skillSet
//    )
//    private Set<SkillSet> skillSets = new HashSet<>();

    @OneToMany(mappedBy = "seekerProfile", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @PrimaryKeyJoinColumn
    private Set<SeekerSkillSet> seekerSkillSets = new HashSet<>();

}
