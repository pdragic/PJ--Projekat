package rs.ac.singidunum.pj.model;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class TeamsModel {

    private Long id;
    private String name;
    private String sport;
    private String city;
    private String league;
}