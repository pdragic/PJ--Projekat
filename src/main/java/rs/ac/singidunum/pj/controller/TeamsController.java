package rs.ac.singidunum.pj.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import rs.ac.singidunum.pj.entity.Teams;
import rs.ac.singidunum.pj.service.TeamsService;

import java.util.List;

@RestController
@RequestMapping("/api/teams")
@CrossOrigin(origins = "*")
public class TeamsController {

    @Autowired
    private TeamsService teamsService;

    @GetMapping
    public List<Teams> getAll() {
        return teamsService.getAll();
    }

    @GetMapping("/{id}")
    public Teams getById(@PathVariable Long id) {
        return teamsService.getById(id);
    }

    @PostMapping
    public Teams create(@RequestBody Teams team) {
        return teamsService.create(team);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Teams> update(@PathVariable Long id, @RequestBody Teams team) {
        Teams updated = teamsService.update(id, team);
        if (updated == null)
            return ResponseEntity.notFound().build();
        return ResponseEntity.ok(updated);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        if (!teamsService.delete(id))
            return ResponseEntity.notFound().build();
        return ResponseEntity.ok().build();
    }

    @GetMapping("/barcelona-roster")
    public ResponseEntity<String> getBarcelonaRoster() throws Exception {
        java.net.URL url = new java.net.URL(
                "https://site.api.espn.com/apis/site/v2/sports/soccer/esp.1/teams/83/roster");
        java.util.Scanner sc = new java.util.Scanner(url.openStream());
        StringBuilder sb = new StringBuilder();
        while (sc.hasNext())
            sb.append(sc.nextLine());
        return ResponseEntity.ok(sb.toString());
    }
}