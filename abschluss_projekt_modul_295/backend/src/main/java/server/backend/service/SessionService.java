package backend.service;

import backend.model.Session;
import backend.repository.SessionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SessionService {

    @Autowired
    private SessionRepository sessionRepository;

    public void saveSession(Session session) {
        sessionRepository.save(session);
    }
}
