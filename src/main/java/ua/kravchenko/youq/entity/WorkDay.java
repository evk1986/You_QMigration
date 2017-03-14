package ua.kravchenko.youq.entity;

import org.hibernate.envers.Audited;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by Егор on 09.03.2017.
 */
@Entity
@Audited
@EntityListeners(AuditingEntityListener.class)
public class WorkDay implements Serializable {
    @Id
    @GeneratedValue
    private int id;

    @Column
    private String start;

    @Column
    private String end;

    public WorkDay() {
    }

    public WorkDay(String start, String end) {
        this.start = start;
        this.end = end;
    }

    public String getStart() {
        return start;
    }

    public String getEnd() {
        return end;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setStart(String start) {
        this.start = start;
    }

    public void setEnd(String end) {
        this.end = end;
    }

    @Override
    public String toString() {
        return "WorkDay{" +
                "id=" + id +
                ", start='" + start + '\'' +
                ", end='" + end + '\'' +
                '}';
    }


}
