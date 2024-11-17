package org.example.clone_topcv.entities.PostAndLookingUpJob;

import jakarta.persistence.*;
import lombok.*;

import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Builder
@Table(name = "job_location")
public class JobLocaltion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "job_location_id")
    private int jobLocationId;

    private String streetAddress;
    private String city;
    private String state;
    private String country;

    @OneToMany(mappedBy = "jobLocation", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Set<JobPost> jobPosts = new HashSet<>();
}
