package model;

public class Writer {
    private String writerName;
    private String writerEmail;

    public Writer(String writerName, String writerEmail) {
        this.writerName = writerName;
        this.writerEmail = writerEmail;
    }

    public String getWriterName() {
        return writerName;
    }

    public void setWriterName(String writerName) {
        this.writerName = writerName;
    }

    public String getWriterEmail() {
        return writerEmail;
    }

    public void setWriterEmail(String writerEmail) {
        this.writerEmail = writerEmail;
    }
}
