package model;

import java.util.ArrayList;

public class LibraryMember {

    private String name;
    private int memberID;
    private ArrayList<Book> borrowedBooks;

    public LibraryMember(String name, int memberID) {
        this.name = name;
        this.memberID = memberID;
        this.borrowedBooks = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getMemberID() {
        return memberID;
    }

    public void setMemberID(int memberID) {
        this.memberID = memberID;
    }

    public ArrayList<Book> getBorrowedBooks() {
        return borrowedBooks;
    }

    public void addBorrowedBook(Book book) {
        borrowedBooks.add(book);
    }

    public boolean removeBorrowedBook(Book book) {
        return borrowedBooks.remove(book);
    }
}
