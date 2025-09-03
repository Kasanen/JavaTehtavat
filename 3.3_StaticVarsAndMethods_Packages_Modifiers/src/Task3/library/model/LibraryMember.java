package Task3.library.model;

import java.util.ArrayList;
import java.util.List;

public class LibraryMember {

    private String name;
    private int memberID;
    private ArrayList<Book> borrowedBooks;
    protected List<Book> reservedBooks;

    public LibraryMember(String name, int memberID) {
        this.name = name;
        this.memberID = memberID;
        this.borrowedBooks = new ArrayList<>();
        this.reservedBooks = new ArrayList<>();
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

    public void reserveBook(Book book) {
        reservedBooks.add(book);
    }

    public void cancelReservation(Book book) {
        reservedBooks.remove(book);
    }

    public void displayReservedBooks(){
        for (Book book : reservedBooks) {
            System.out.println(book.getTitle());
        }
    }
}
