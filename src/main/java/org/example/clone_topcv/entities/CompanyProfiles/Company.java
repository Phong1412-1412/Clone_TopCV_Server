package org.example.clone_topcv.entities.CompanyProfiles;

import jakarta.persistence.*;
import lombok.*;
import org.example.clone_topcv.entities.PostAndLookingUpJob.JobPost;

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
@Table(name = "company")
public class Company {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "company_id", nullable = false, updatable = false)
    private UUID companyId;

    private String companyName;
    private String profileDescription;
    private LocalDate establishmentDate; //Ngày thành lập
    private String companyWebsite;

    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "business_stream_id")
    private BusinessStream businessStream;

    @OneToMany(mappedBy = "company")
    Set<CompanyImage> companyImages = new HashSet<>();

    @OneToMany(mappedBy = "company", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Set<JobPost> jobPosts = new HashSet<>();
}
