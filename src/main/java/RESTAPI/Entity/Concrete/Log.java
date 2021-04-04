package RESTAPI.Entity.Concrete;

import RESTAPI.Entity.Abstract.IEntity;
import org.springframework.stereotype.Component;

import javax.persistence.*;
import java.util.Date;

/**
 * @author İbrahim Başar YARGICI
 * @date 25.03.2021
 * <p>
 * This class is the representation of Log table in entity form.
 */
@Entity
@Component
@Table(name = "log")
public class Log implements IEntity {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "createdtime")
    private Date createdTime;

    @Column(name = "method")
    private String method;

    @Column(name = "timetaken")
    private String timeTaken;

    @Column(name = "timestamp")
    private String timestamp;

    public Log() {
    }

    public Log(Date createdTime, String method, String timeTaken, String timestamp) {
        this.createdTime = createdTime;
        this.method = method;
        this.timeTaken = timeTaken;
        this.timestamp = timestamp;
    }


    // region getters and setters
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

    public Date getCreatedTime() {
        return createdTime;
    }

    public void setCreatedTime(Date createdTime) {
        this.createdTime = createdTime;
    }
    // endregion
}
