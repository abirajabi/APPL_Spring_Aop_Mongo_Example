package aspect;

import com.sun.tools.javac.Main;
import main.MainUtils;
import model.LogMessage;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;
import utility.MongoUtils;

import java.util.Date;

@Aspect
@Component
public class LoggingAspect {
    @Pointcut("execution(public void utility.MongoUtils.insertBook(..))")
    public void insertNewBook(){}

    @AfterReturning("insertNewBook()")
    public void sendAcknowledgement(){
        System.out.println("Data successfully inserted!");
        System.out.println("Inserting log document");
    }

    @AfterReturning("execution(public void utility.MongoUtils.insertLog(..))")
    public void sendLogAcknowledgement(){
        System.out.println("Action logged!");
    }

    @Before("execution(* utility.MongoUtils.getAllBook())")
    public void sendFetchingMessage(){
        System.out.println("Fetching all books in collection");
    }

    @AfterReturning("execution(* utility.MongoUtils.getAllBook())")
    public void sendFetchingAcknowledgement(){
        System.out.println("All of the books fetched");
    }

    @Before("execution(* utility.MongoUtils..getAllLogs())")
    public void sendLogFetchingMessage(){
        System.out.println("Fetching all logs in collection");
    }

    @AfterReturning("execution(* utility.MongoUtils.getAllLogs())")
    public void sendLogFetchingAcknowledgement(){
        System.out.println("All of the logs fetched");
    }
}
