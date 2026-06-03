package rs.ac.singidunum.pj.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDateTime;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Data
@NoArgsConstructor
@Entity
@Table(name = "teams")
public class Teams {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "teams_id")
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String sport;

    private String city;
    private String league;

    @Column(name = "created_at")
    private LocalDateTime createdAt;

    @Column(name = "updated_at")
    private LocalDateTime updatedAt;

    @JsonIgnore
    @Column(name = "deleted_at")
    private LocalDateTime deletedAt;

    @JsonIgnore
    @OneToMany(mappedBy = "team")
    private List<Players> players;
}
