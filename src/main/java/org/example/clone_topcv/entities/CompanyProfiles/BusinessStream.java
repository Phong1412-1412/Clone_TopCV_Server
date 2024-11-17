package org.example.clone_topcv.entities.CompanyProfiles;

import jakarta.persistence.*;
import lombok.*;

import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Builder
@Table(name = "business_stream")
public class BusinessStream {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "business_stream_id", nullable = false, updatable = false)
    private UUID businessStreamId;

    @Column(name = "business_stream_name", nullable = false)
    private String businessStreamName;

    @OneToMany(mappedBy = "businessStream")
    Set<Company> companies = new HashSet<>();
}
