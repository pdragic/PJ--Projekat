package rs.ac.singidunum.pj.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import rs.ac.singidunum.pj.entity.Players;

@Repository
public interface PlayersRepository extends JpaRepository<Players, Long> {
}