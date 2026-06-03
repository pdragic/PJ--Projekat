package rs.ac.singidunum.pj.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Data
@NoArgsConstructor
@Entity
@Table(name = "players")
public class Players {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "players_id")
    private Long id;

    @Column(name = "first_name", nullable = false)
    private String firstName;

    @Column(name = "last_name", nullable = false)
    private String lastName;

    @Column(nullable = false)
    private String position;

    private Integer age;
    private String height;
    private String weight;
    private String nationality;

    @Column(name = "jersey_number")
    private Integer jerseyNumber;

    @Column(name = "created_at")
    private LocalDateTime createdAt;

    @Column(name = "updated_at")
    private LocalDateTime updatedAt;

    @JsonIgnore
    @Column(name = "deleted_at")
    private LocalDateTime deletedAt;

    @ManyToOne
    @JoinColumn(name = "teams_id")
    private Teams team;
}