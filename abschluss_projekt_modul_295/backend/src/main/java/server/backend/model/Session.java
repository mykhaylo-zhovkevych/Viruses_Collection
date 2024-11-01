package backend.model;

import jakarta.persistence.*;
import java.util.Date;

@Entity
public class Session {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long sessionId;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @Column(nullable = false)
    private Date startTime; 

    @Column
    private Date endTime; 

    public Session() {
        this.startTime = new Date(); 
        this.endTime = null; 
    }

    public Session(User user) {
        this.user = user;
        this.startTime = new Date();
        this.endTime = null; 
    }

 
    public Long getSessionId() {
        return sessionId;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Date getStartTime() {
        return startTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }
}
