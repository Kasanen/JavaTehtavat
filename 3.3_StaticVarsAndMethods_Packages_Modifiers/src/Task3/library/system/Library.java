package Task3.library.system;

import Task3.library.model.Book;
import Task3.library.model.LibraryMember;
import java.util.ArrayList;
import java.util.List;

public class Library {

    private List<Book> books;
    private List<LibraryMember> members;

    public Library() {
        books = new ArrayList<>();
        members = new ArrayList<>();
    }

    public void addBook(Book book) {
        books.add(book);
    }

    public void addMember(LibraryMember member) {
        members.add(member);
    }

    public void borrowBook(LibraryMember member, Book book) {
        if (books.contains(book)) {
            books.remove(book);
            member.addBorrowedBook(book);
            System.out.println(member.getName() + " borrowed " + book.getTitle());
        } else {
            System.out.println("Book not available.");
        }
    }

    public void returnBook(LibraryMember member, Book book) {
        if (member.removeBorrowedBook(book)) {
            books.add(book);
            System.out.println(member.getName() + " returned " + book.getTitle());
        } else {
            System.out.println("This member does not have this book.");
        }
    }

    public void reserveBook(LibraryMember member, Book book) {
        if (!book.isReserved()) {
            book.reserve();
            member.reserveBook(book);
            System.out.println("Book " + book.getTitle() + " is reserved by " + member.getName());
        } else {
            System.out.println("Book already reserved!");
        }
    }

    public void cancelReservation(LibraryMember member, Book book) {
        if (book.isReserved()) {
            book.reserve();
            member.cancelReservation(book);
            System.out.println("Books " + book.getTitle() + " reservation cancelled for " + member.getName());
        } else {
            System.out.println("Book is not reserved!");
        }
    }

    public void displayReserved(LibraryMember member){
        System.out.println("Reserved books by " + member.getName());
        member.displayReservedBooks();
    } 
}
