package pl.java.scalatech.repository.data.pitfalls;

import org.springframework.data.jpa.repository.JpaRepository;

import pl.java.scalatech.domain.pitfalls.Team;

public interface TeamRepo extends JpaRepository<Team, Long>{

}
