package backend.controller;

import backend.model.Keystroke;
import backend.model.Session;
import backend.repository.KeystrokeRepository;
import backend.repository.SessionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;

@Controller
public class KeystrokeController {

    @Autowired
    private KeystrokeRepository keystrokeRepository;

    @Autowired
    private SessionRepository sessionRepository;

    @MessageMapping("/keystroke")
    @SendTo("/topic/keystrokes")
    public Keystroke handleKeystroke(Keystroke keystroke) {

        System.out.println("Received keystroke: " + keystroke);

        if (keystroke == null || keystroke.getSession() == null || 
            keystroke.getSession().getSessionId() == null) {
            throw new RuntimeException("Keystroke or its session information is missing");
        }

        Session session = sessionRepository.findById(keystroke.getSession().getSessionId())
                .orElseThrow(() -> new RuntimeException("Session not found"));


        Keystroke newKeystroke = new Keystroke(session, keystroke.getText(), keystroke.getAction());
        keystrokeRepository.save(newKeystroke);

        return newKeystroke; 
    }

}
