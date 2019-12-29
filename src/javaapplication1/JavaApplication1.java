/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication1;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Johnny
 */
public class JavaApplication1 {

    public static void main(String[] args){ 
        BookFactory factory = BookFactory.getInstance();
        Library l = new Library();
        
        Book b1 = factory.createBook(12345L, "Game of Thrones");
        Book b2 = factory.createBook(12346L, "A Song of Ice And Fire");
        
        l.addBook(b1);
        l.addBook(b2);
        
        l.printBooks();
    }
}

class Library {
    List<Book> books;
    public Library(){
        books = new ArrayList<>();
    }
    
    public boolean addBook(Book b){ 
        return books.add(b);
    }
    
    public void printBooks(){
        books.forEach(b->{
            System.out.println(String.format("ID: %d, ISBN: %d, NAME: %s", b.getId(), b.getIsbn(), b.getName()));
        });
    }
}

class BookFactory {
    static BookFactory INSTANCE;
    static int id = 0;
    private BookFactory(){}
    
    public static BookFactory getInstance(){
        if(INSTANCE==null){
            return new BookFactory();
        } else {
            return INSTANCE;
        }
    }
    
    public Book createBook(long isbn, String name) {
        // do some validation on the isbn and name 
        Book b = new Book(id, isbn, name);
        id+=1;
        return b;
    }
}

class Book { 
    private int id;
    private long isbn;
    private String name;

    public Book(int id, long isbn, String name){
        this.id = id;
        this.isbn = isbn;
        this.name = name;
    }
    
    /**
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * @return the isbn
     */
    public long getIsbn() {
        return isbn;
    }

    /**
     * @param isbn the isbn to set
     */
    public void setIsbn(long isbn) {
        this.isbn = isbn;
    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }
}