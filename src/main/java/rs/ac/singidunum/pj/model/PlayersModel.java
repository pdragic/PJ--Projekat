package rs.ac.singidunum.pj.model;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class PlayersModel {

    private Long id;
    private String firstName;
    private String lastName;
    private String position;
    private Integer age;
    private String height;
    private String weight;
    private String nationality;
    private Integer jerseyNumber;
    private Long teamsId;
}
