package backend.service;

import backend.model.Keystroke; 
import backend.repository.KeystrokeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class KeystrokeService { 

    private final KeystrokeRepository keystrokeRepository; 

    @Autowired
    public KeystrokeService(KeystrokeRepository keystrokeRepository) { 
        this.keystrokeRepository = keystrokeRepository; 
    }

    public Keystroke saveKeystroke(Keystroke keystroke) { 
        return keystrokeRepository.save(keystroke); 
    }

    public List<Keystroke> getAllKeystrokes() {
        return keystrokeRepository.findAll();
    }
}
