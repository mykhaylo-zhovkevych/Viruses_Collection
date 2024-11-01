package backend;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import backend.repository.UserRepository;
import backend.model.User;
import backend.model.UserRole;    

@SpringBootApplication
public class BackendApplication implements CommandLineRunner {

    @Autowired
    private UserRepository userRepository;

    public static void main(String[] args) {
        SpringApplication.run(BackendApplication.class, args);
    }

    @Override
    public void run(String... args) {
        initializeDefaultUser();
    }

    private void initializeDefaultUser() {
        if (!userRepository.existsByUsername("adminUser")) {
            User adminUser = new User();
            adminUser.setUsername("adminUser");
            adminUser.setRole(UserRole.ADMIN); 
            userRepository.save(adminUser);
            System.out.println("Admin user created with ID: " + adminUser.getUserId());
        } else {
            System.out.println("Admin user already exists.");
        }
    }    
}
