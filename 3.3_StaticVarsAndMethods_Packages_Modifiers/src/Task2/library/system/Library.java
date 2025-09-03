package Task2.library.system;

import java.util.ArrayList;
import java.util.List;

import Task2.library.model.Book;
import Task2.library.model.LibraryMember;

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
}
