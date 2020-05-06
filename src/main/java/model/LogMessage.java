package model;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

@Document (collection = "logs")
public class LogMessage {
    @Id
    private ObjectId _id;
    private Date date;
    private int logType;

    public int getLogType() {
        return logType;
    }

    public void setLogType(int logType) {
        this.logType = logType;
    }

    private String message;

    public LogMessage(Date date, int logType, String message) {
        this._id = new ObjectId();
        this.date = date;
        this.logType = logType;
        this.message = message;
    }

    public ObjectId get_id() {
        return _id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return "Date : " + this.getDate() + " | Action : " + getMessage();
    }
}
