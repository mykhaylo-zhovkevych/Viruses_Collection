package backend.controller;

import backend.model.Session;
import backend.model.User;
import backend.service.SessionService;
import backend.repository.UserRepository; 
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import jakarta.servlet.http.HttpSession;

@RestController
public class SessionController {

    @Autowired
    private SessionService sessionService;

    @Autowired
    private UserRepository userRepository; 

    @GetMapping("/createSession")
    public ResponseEntity<Object> createSession(@RequestParam Long userId) {
        try {
            User user = userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("User not found"));

            Session session = new Session(user);
            sessionService.saveSession(session);

            return ResponseEntity.ok(user.getUserId());
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("User not found");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Error creating session: " + e.getMessage());
        }
    }

    @GetMapping("/getSession")
    public Long getSession(HttpSession session) {
        return (Long) session.getAttribute("userId"); 
    }
}
