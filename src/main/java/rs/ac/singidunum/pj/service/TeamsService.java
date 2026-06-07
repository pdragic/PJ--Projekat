package rs.ac.singidunum.pj.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import rs.ac.singidunum.pj.entity.Teams;
import rs.ac.singidunum.pj.repo.TeamsRepository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class TeamsService {

    @Autowired
    private TeamsRepository teamsRepository;

    public List<Teams> getAll() {
        return teamsRepository.findAll()
                .stream()
                .filter(t -> t.getDeletedAt() == null)
                .collect(Collectors.toList());
    }

    public Teams getById(Long id) {
        return teamsRepository.findById(id).orElse(null);
    }

    public Teams create(Teams team) {
        team.setCreatedAt(LocalDateTime.now());
        return teamsRepository.save(team);
    }

    public Teams update(Long id, Teams team) {
        Teams existing = teamsRepository.findById(id).orElse(null);
        if (existing == null)
            return null;
        existing.setName(team.getName());
        existing.setSport(team.getSport());
        existing.setCity(team.getCity());
        existing.setLeague(team.getLeague());
        existing.setUpdatedAt(LocalDateTime.now());
        return teamsRepository.save(existing);
    }

    public boolean delete(Long id) {
        Teams team = teamsRepository.findById(id).orElse(null);
        if (team == null)
            return false;
        team.setDeletedAt(LocalDateTime.now());
        teamsRepository.save(team);
        return true;
    }
}