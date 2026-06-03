package rs.ac.singidunum.pj.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import rs.ac.singidunum.pj.entity.Teams;
import rs.ac.singidunum.pj.repo.TeamsRepository;

import java.util.List;

@RestController
@RequestMapping("/api/teams")
@CrossOrigin(origins = "*")
public class TeamsController {

    @Autowired
    private TeamsRepository teamsRepository;

    // GET sve timove
    @GetMapping
    public List<Teams> getAll() {
        return teamsRepository.findAll()
                .stream()
                .filter(t -> t.getDeletedAt() == null)
                .collect(java.util.stream.Collectors.toList());
    }

    // GET jedan tim po ID-u
    @GetMapping("/{id}")
    public Teams getById(@PathVariable Long id) {
        return teamsRepository.findById(id).orElse(null);
    }

    // POST dodaj tim
    @PostMapping
    public Teams create(@RequestBody Teams team) {
        return teamsRepository.save(team);
    }

    // PUT izmijeni tim
    @PutMapping("/{id}")
    public Teams update(@PathVariable Long id, @RequestBody Teams team) {
        team.setId(id);
        return teamsRepository.save(team);
    }

    // DELETE obrisi tim
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        Teams team = teamsRepository.findById(id).orElse(null);
        if (team != null) {
            team.setDeletedAt(java.time.LocalDateTime.now());
            teamsRepository.save(team);
        }
    }
}