package backend.repository;

import backend.model.Keystroke; 
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Repository-Interface für die Verwaltung von Keystroke-Objekten.
 * Diese Schnittstelle erweitert JpaRepository und ermöglicht CRUD-Operationen für Keystroke-Entitäten.
 */
@Repository
public interface KeystrokeRepository extends JpaRepository<Keystroke, Long> { 
}
