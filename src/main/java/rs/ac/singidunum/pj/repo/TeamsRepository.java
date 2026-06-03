package rs.ac.singidunum.pj.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import rs.ac.singidunum.pj.entity.Teams;

@Repository
public interface TeamsRepository extends JpaRepository<Teams, Long> {
}