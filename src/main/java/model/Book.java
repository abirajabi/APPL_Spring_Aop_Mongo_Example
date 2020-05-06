package model;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "book")
public class Book {
    @Id
    private ObjectId _id;
    private String bookTitle;
    private int releasedYear;
    private Writer writer;      //consider only one writer

    public Book(){}

    public Book(String bookTitle, int releasedYear, Writer writer) {
        this._id = new ObjectId();
        this.bookTitle = bookTitle;
        this.releasedYear = releasedYear;
        this.writer = writer;
    }

    public ObjectId get_id() {
        return _id;
    }

    public String getBookTitle() {
        return bookTitle;
    }

    public void setBookTitle(String bookTitle) {
        this.bookTitle = bookTitle;
    }

    public int getReleasedYear() {
        return releasedYear;
    }

    public void setReleasedYear(int releasedYear) {
        this.releasedYear = releasedYear;
    }

    public Writer getWriter() {
        return writer;
    }

    public void setWriter(Writer writer) {
        this.writer = writer;
    }

    @Override
    public String toString() {
        return "\nBook title : " + getBookTitle() + "\nReleased year : " + getReleasedYear() + "\nWriter name: " +
                getWriter().getWriterName() + "\nWriter email : " + getWriter().getWriterEmail();
    }

}
