package rs.ac.singidunum.pj.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import rs.ac.singidunum.pj.entity.Players;
import rs.ac.singidunum.pj.repo.PlayersRepository;

import java.util.List;

@RestController
@RequestMapping("/api/players")
@CrossOrigin(origins = "*")
public class PlayersController {

    @Autowired
    private PlayersRepository playersRepository;

    // GET svi igraci
    @GetMapping
    public List<Players> getAll() {
        return playersRepository.findAll();
    }

    // GET jedan igrac po ID-u
    @GetMapping("/{id}")
    public Players getById(@PathVariable Long id) {
        return playersRepository.findById(id).orElse(null);
    }

    // POST dodaj igraca
    @PostMapping
    public Players create(@RequestBody Players player) {
        return playersRepository.save(player);
    }

    // PUT izmijeni igraca
    @PutMapping("/{id}")
    public Players update(@PathVariable Long id, @RequestBody Players player) {
        player.setId(id);
        return playersRepository.save(player);
    }

    // DELETE obrisi igraca
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        playersRepository.deleteById(id);
    }
}