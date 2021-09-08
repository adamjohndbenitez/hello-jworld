package linkedin.advancejava.streams;

import java.util.ArrayList;
import java.util.List;

/**
 * Streams provide a clean and simple way to iterate over a collection in java.
 * Instead of for each loops, Streams allow functional programming techniques to be used.
 * This streams are not to be confused on input and output streams which are something completely different.
 */
public class Main {
    public static void main(String[] args) {
        List<BookLibrary> bookLibraries = new ArrayList<>();
        bookLibraries.add(new BookLibrary("JK Rowling"));

        for (BookLibrary b : bookLibraries) {
            if (b.getAuthor().startsWith("J")) {
                System.out.println(b.toString());
            }
        }
        /*
        NOTE: This is an External Iteration - is an iterator object is created - the iterator object controls the iteration process
        <p>
        There are a few issues with External Iteration:
         1st - Hard to write parallel iterations.
         2ndly - Requires boilerplate codes to write.
         3rdly - Sometimes, it is difficult to read meaning cuz if you have lots of for-loops especially if there are lots of nested for loopos.
                 it can be difficult or time consuming to work out what exactly the iteration does.
         Finally - Hard to abstract away from behavior. In the for-each loop, what you are doing is fused with how you are doing it.
                   there is not much abstraction between the code an implementation.
        SOLUTION TO ISSUES: Streams provide a solution to these issues. Streams work differently to for loops.
                            They use internal iteration instead of external iteration. I could rewrite my forEach loop to use a stream.
                            to iterate over the colleection of books.
         */
        bookLibraries.stream().filter(bookLibrary -> bookLibrary.getAuthor().startsWith("J")).forEach(System.out::println);
        // Fist method - stream() object - an interface that contains a sequence of elements from tthe collection we called the method on. so in this case it contains book objects from the books list.
        // Next is the - filter() method - Streams have two differrent types of methods [1] lazy methods and [2] eager methods. In this case, this is a lazy method
        // Finally is the - forEach() method - the eager method which  prints out all of the objects in the stream.

        /*
        ForLoop vs Stream
        ForLoop - repeatedly checks condition then print, then move to next.
        Stream - filter item then add into stream, not print yet, waits til end, then prints out that stream with added items.
         */
        bookLibraries.stream()
                .filter(bookLibrary -> bookLibrary.getAuthor().startsWith("J"))
                .filter(bookLibrary -> bookLibrary.getAuthor().endsWith("g"))
                // can add more filters here.
                .forEach(System.out::println);
        /*
        If I wanted to add more filters, I would just chain them to end of the first one.
        This is much simpler to read than a forEach loop.
        Where I would need to add a new nested if statement for each condition.
        It is also more computationally efficient to use this approach.
        These are the main advantages of using streams.
         */
    }

    static class BookLibrary {
        String author;

        public BookLibrary(String author) {
            this.author = author;
        }

        public String getAuthor() {
            return author;
        }

        @Override
        public String toString() {
            return "Book{" +
                    "author='" + author + '\'' +
                    '}';
        }
    }
}
