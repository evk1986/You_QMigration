package ua.kravchenko.youq.entity;

import org.hibernate.envers.Audited;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.io.Serializable;

import static org.hibernate.envers.RelationTargetAuditMode.NOT_AUDITED;

/**
 * Created by Егор on 09.03.2017.
 */
@Entity
@Audited(targetAuditMode = NOT_AUDITED)
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


    public static WorkDay workDayCreate() {
        return new WorkDay();
    }
}
