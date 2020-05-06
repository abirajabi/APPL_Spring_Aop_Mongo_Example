package utility;

import com.mongodb.BasicDBList;
import com.mongodb.BasicDBObject;
import model.Book;
import model.LogMessage;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.MongoTemplate;

import java.io.IOException;
import java.util.List;

public class MongoUtils {
    private MongoOperations mongo;

    public MongoUtils (MongoTemplate template) {
        this.mongo = template;
    }

    public void insertBook(Book newBook) {
        try {
            mongo.insert(newBook);
        } catch (Exception e){
            e.getMessage();
        }
    }

    public void insertLog(LogMessage log){
        try {
            mongo.insert(log);
        } catch (Exception e) {
            e.getMessage();
        }
    }

    public List<Book> getAllBook() {
        return mongo.findAll(Book.class);
    }

    public List<LogMessage> getAllLogs() {
        return mongo.findAll(LogMessage.class);
    }
}
