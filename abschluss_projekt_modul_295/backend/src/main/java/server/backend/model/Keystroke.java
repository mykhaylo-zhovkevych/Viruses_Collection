package backend.model;

import jakarta.persistence.*;
import java.util.Date;

@Entity
public class Keystroke {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long keystrokeId;

    @ManyToOne
    @JoinColumn(name = "session_id", nullable = false)
    private Session session;

    @Lob
    @Column(columnDefinition = "MEDIUMTEXT")
    private String text; 

    @Lob
    @Column(columnDefinition = "MEDIUMTEXT")
    private String action; 

    @Column(nullable = false)
    private Date sentDate; 

    public Keystroke() {
        this.sentDate = new Date(); 
    }

    public Keystroke(Session session, String text, String action) {
        this.session = session;
        this.text = text;
        this.action = action;
        this.sentDate = new Date();
    }

    public Long getKeystrokeId() {
        return keystrokeId;
    }

    public Session getSession() {
        return session;
    }

    public void setSession(Session session) {
        this.session = session;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }

    public Date getSentDate() {
        return sentDate;
    }

    public Long getSessionId() {
        return session != null ? session.getSessionId() : null;
    }

    @Override
    public String toString() {
        return "Keystroke{" +
                "id=" + keystrokeId +
                ", session=" + (session != null ? session.getSessionId() : "null") +
                ", text='" + text + '\'' +
                ", action='" + action + '\'' +
                '}';
    }
}
