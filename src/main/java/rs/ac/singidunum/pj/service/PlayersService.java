package rs.ac.singidunum.pj.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import rs.ac.singidunum.pj.entity.Players;
import rs.ac.singidunum.pj.repo.PlayersRepository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class PlayersService {

    @Autowired
    private PlayersRepository playersRepository;

    public List<Players> getAll() {
        return playersRepository.findAll()
                .stream()
                .filter(p -> p.getDeletedAt() == null)
                .collect(Collectors.toList());
    }

    public Players getById(Long id) {
        return playersRepository.findById(id).orElse(null);
    }

    public Players create(Players player) {
        player.setCreatedAt(LocalDateTime.now());
        return playersRepository.save(player);
    }

    public Players update(Long id, Players player) {
        Players existing = playersRepository.findById(id).orElse(null);
        if (existing == null) return null;
        existing.setFirstName(player.getFirstName());
        existing.setLastName(player.getLastName());
        existing.setPosition(player.getPosition());
        existing.setAge(player.getAge());
        existing.setHeight(player.getHeight());
        existing.setWeight(player.getWeight());
        existing.setNationality(player.getNationality());
        existing.setJerseyNumber(player.getJerseyNumber());
        existing.setTeam(player.getTeam());
        existing.setUpdatedAt(LocalDateTime.now());
        return playersRepository.save(existing);
    }

    public boolean delete(Long id) {
        Players player = playersRepository.findById(id).orElse(null);
        if (player == null) return false;
        player.setDeletedAt(LocalDateTime.now());
        playersRepository.save(player);
        return true;
    }
}