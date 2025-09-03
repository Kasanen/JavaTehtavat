package Task2.library;

import Task2.library.model.Book;
import Task2.library.model.LibraryMember;
import Task2.library.system.Library;

public class Main {

    public static void main(String[] args) {
        Library library = new Library();

        Book book1 = new Book("1984", "George Orwell", 1949);
        Book book2 = new Book("Brave New World", "Aldous Huxley", 1932);

        LibraryMember member1 = new LibraryMember("Alice", 1);
        LibraryMember member2 = new LibraryMember("Bob", 2);

        library.addBook(book1);
        library.addBook(book2);
        library.addMember(member1);
        library.addMember(member2);

        library.borrowBook(member1, book1);

        library.borrowBook(member2, book1);

        library.returnBook(member1, book1);

        library.borrowBook(member2, book1);
    }
}
