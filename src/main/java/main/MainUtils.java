package main;

import model.Book;
import model.LogMessage;
import model.Writer;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import utility.MongoUtils;

import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class MainUtils {

    private ApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");
    public MongoUtils mongoUtils = (MongoUtils) context.getBean("mongoUtils");

    private static final int EXIT = 0;
    private static final int INSERT_NEW_BOOK = 1;
    private static final int READ_BOOK_DATA = 2;
    private static final int READ_LOG_DATA = 3;

    public void execute() {
        while (true) {
            int userChoice = actionMenu();
            switch (userChoice){
                case INSERT_NEW_BOOK : {
                    performInsertBook();
                } break;
                case READ_BOOK_DATA : {
                    fetchBookData();
                } break;
                case READ_LOG_DATA : {
                    fetchLogData();
                } break;
                case EXIT : {
                    System.out.println("Exiting program ...");
                    System.exit(0);
                }
                default : {
                    System.out.println("Option doesn't exist");
                } break;
            }
        }
    }

    private int actionMenu(){
        Scanner keyboard = new Scanner(System.in);
        System.out.println("\n==================================");
        System.out.println("Pilihan aksi yang dapat dilakukan");
        System.out.println("1. Insert Data (Buku)");
        System.out.println("2. Read Data (Buku)");
        System.out.println("3. Read Data Log");
        System.out.println("0. Exit Program");

        System.out.print("Pilihan Anda : ");
        int choice = keyboard.nextInt();
        return choice;
    }

    private Book getNewBook(){
        String bookTitle, writerName, writerEmail;
        int releasedYear;

        Scanner keyboard = new Scanner((System.in));
        System.out.print("Masukkan judul buku : ");
        bookTitle = keyboard.nextLine();

        System.out.print("Masukkan nama penulis buku : ");
        writerName = keyboard.nextLine();

        System.out.print("Masukkan email penulis buku : ");
        writerEmail = keyboard.nextLine();

        System.out.print("Masukkan tahun terbit : ");
        releasedYear = keyboard.nextInt();

        Book newBook = new Book(bookTitle, releasedYear, new Writer(writerName, writerEmail));
        return newBook;
    }


    private void performInsertBook(){
        Book newBook = getNewBook();
        mongoUtils.insertBook(newBook);
        mongoUtils.insertLog(new LogMessage(new Date(), INSERT_NEW_BOOK,
                "Client inserting a book. Title : " + newBook.getBookTitle() +
                " ReleasedYear: " + newBook.getReleasedYear() + " Writer name : " + newBook.getWriter().getWriterName()));
    }

    private void fetchLogData(){
        mongoUtils.insertLog(new LogMessage(new Date(), READ_LOG_DATA, "Client fetching log data."));
        List<LogMessage> logMessageList = mongoUtils.getAllLogs();
        for (LogMessage log : logMessageList){
            System.out.println(log.toString());
        }
    }

    private void fetchBookData(){
        mongoUtils.insertLog(new LogMessage(new Date(), READ_BOOK_DATA, "Client fetching book data."));
        List<Book> bookList = mongoUtils.getAllBook();
        for (Book book : bookList){
            System.out.println(book.toString());
        }
    }
}
