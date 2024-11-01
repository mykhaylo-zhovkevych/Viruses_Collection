package backend.repository;

import backend.model.Keystroke; 
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface KeystrokeRepository extends JpaRepository<Keystroke, Long> { 
}
