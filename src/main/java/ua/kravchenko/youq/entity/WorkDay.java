package ua.kravchenko.youq.entity;

import org.hibernate.envers.Audited;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import static org.hibernate.envers.RelationTargetAuditMode.NOT_AUDITED;

/**
 * Created by Егор on 09.03.2017.
 */
@Entity
@Audited(targetAuditMode = NOT_AUDITED)
public class WorkDay {
    @Id
    @GeneratedValue
    private int id;
    @Column
    private String start;
    @Column
    private String end;

    public WorkDay() {
    }

    public WorkDay(String name, String start, String end) {
        this.start = start;
        this.end = end;
    }

    public String getStart() {
        return start;
    }

    public String getEnd() {
        return end;
    }

    @org.jetbrains.annotations.Contract(" -> !null")
    public static WorkDay WorkDayCreate() {
        return new WorkDay();
    }
}
