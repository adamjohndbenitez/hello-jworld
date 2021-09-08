package linkedin.advancejava.streams;

import java.util.ArrayList;
import java.util.List;

public class Library {
    public static void main(String[] args) {
        List<Book> books = populateLibrary();
        books.stream()
                .filter(book -> book.getAuthor().startsWith("J")) // Lazy method 1
                .filter(book -> book.getTitle().contains("e")) // Lazy method 2
                .forEach(System.out::println); // Eager method

        // Use of Parallel Streams so that multiple cores can be used at the same time to filter the elements.
        books.parallelStream()
                .filter(book -> book.getAuthor().startsWith("J")) // Lazy method 1
                .filter(book -> book.getTitle().contains("e")) // Lazy method 2
                .forEach(System.out::println); // Eager method

        // stream() vs parallelStream() diff is speed, when using very large amount of data parallelStream() is more better.
        // it is more efficient use stream() only if you only have small dataset.


    }

    static List<Book> populateLibrary() {
        List<Book> bookList = new ArrayList<>();
        bookList.add(new Book("Allice Walker", "The Color Purple"));
        bookList.add(new Book("Allice Walker", "Meridian"));
        bookList.add(new Book("Toni Morrison", "Beloved"));
        bookList.add(new Book("Toni Morrison", "Jazz"));
        bookList.add(new Book("Toni Morrison", "Paradise"));
        bookList.add(new Book("John Steinbeck", "The Grapes of Wrath"));
        bookList.add(new Book("John Steinbeck", "East of Eden"));
        bookList.add(new Book("Jane Austen", "Pride and Prejudice"));
        bookList.add(new Book("Jane Austen", "Emma"));
        return bookList;
    }
}
