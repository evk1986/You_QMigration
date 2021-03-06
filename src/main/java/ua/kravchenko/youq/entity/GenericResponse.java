package ua.kravchenko.youq.entity;

import java.util.Date;

/**
 * Created by Egor on 11.01.2017.
 */
public class GenericResponse {
    private String message;
    private String error;
    private Date date;

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public GenericResponse(String message) {
        super();
        this.message = message;
    }

    public GenericResponse(String message, String error) {
        super();
        this.message = message;
        this.error = error;
    }
    public GenericResponse(){

    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }
}
