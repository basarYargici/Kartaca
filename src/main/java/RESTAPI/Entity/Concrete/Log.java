package RESTAPI.Entity.Concrete;

import RESTAPI.Entity.Abstract.IEntity;
import org.springframework.stereotype.Component;

import javax.persistence.*;

/**
 * @author İbrahim Başar YARGICI
 * @date 25.03.2021
 */
@Entity
@Component
@Table(name = "log")
public class Log implements IEntity {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "method")
    private String method;

    @Column(name = "timetaken")
    private String timeTaken;

    @Column(name = "timestamp")
    private String timestamp;

    public Log() {
    }

    public Log(String method, String timeTaken, String timestamp) {
        this.method = method;
        this.timeTaken = timeTaken;
        this.timestamp = timestamp;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method;
    }

    public String getTimeTaken() {
        return timeTaken;
    }

    public void setTimeTaken(String timeTaken) {
        this.timeTaken = timeTaken;
    }

    public String getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }
}
