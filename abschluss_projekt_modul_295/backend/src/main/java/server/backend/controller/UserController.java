package backend.controller;

import backend.model.User;
import backend.model.UserRole;
import backend.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * Der Controller für die Benutzerverwaltung.
 * Dieser Controller ermöglicht die Erstellung neuer Benutzer
 * über RESTful HTTP-Anfragen.
 */
@RestController
public class UserController {

    @Autowired
    private UserRepository userRepository;

    /**
     * Erstellt einen neuen Benutzer.
     *
     * Diese Methode verarbeitet POST-Anfragen an den 
     * Endpunkt "/createUser". Sie nimmt ein User-Objekt 
     * entgegen, speichert es in der Datenbank und gibt eine 
     * entsprechende Antwort zurück.
     *
     * @param user das zu erstellende User-Objekt
     * @return eine ResponseEntity mit einer Bestätigungsmeldung
     *         und dem neu erstellten Benutzer-ID oder einem Fehlerstatus
     */
    @PostMapping("/createUser")
    public ResponseEntity<String> createUser(@RequestBody User user) {
        try {
            userRepository.save(user);
            return ResponseEntity.ok("User created with ID: " + user.getUserId());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Error creating user: " + e.getMessage());
        }
    }
}
