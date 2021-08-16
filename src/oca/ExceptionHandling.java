package oca;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.EmptyStackException;
import java.util.List;
import java.util.logging.LogManager;
import java.util.logging.Logger;

/**
 * This section describes how to use the three exception handler components
 * — the try, catch, and finally blocks — to write an exception handler.
 *
 * Then, the try-with-resources statement is particularly suited
 * to situations that use Closeable resources, such as streams.
 */
public class ExceptionHandling {
    public static void main(String[] args) {
        // Use exception handling.
        ListOfNumbers listOfNumbers = new ListOfNumbers();
        try {
            listOfNumbers.writeList();
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Handle Common Exceptions Thrown.
        /*
        NOTE:
         - Before you can catch an exception, some code somewhere must throw one. Any code can throw an exception
         - All the exception classes are descendants of the Throwable class
         - You can also create your own exception classes to represent problems that can occur within the classes you write.
         - You can also create chained exceptions.
         - Throwable has two direct descendants: Error and Exception.
         - Error = hard failure in the Java virtual machine occurs throws an Error.
         - Exception = indicates that a problem occurred, but it is not a serious system problem. Most programs you write will throw and catch Exceptions as opposed to Errors.
         */
    }

    private int size = 0;
    private List<Object> objs = new ArrayList<>();
    public Object pop() {
        Object obj;

        if (size == 0) {
            throw new EmptyStackException();
            // does not contain a throws clause. EmptyStackException is not a checked exception,
            // so pop is not required to state that it might occur.
        }

        obj = objectAt(size - 1);
        setObjectAt(size - 1, null);
        size--;
        return obj;
    }

    private void setObjectAt(int i, Object o) {
        objs.set(i, o);
    }

    private Object objectAt(int i) {
        return objs.get(i);
    }
}

class ListOfNumbers {

    private List<Integer> list;
    private static final int SIZE = 10;
    public ListOfNumbers () {
        list = new ArrayList<Integer>(SIZE);
        for (int i = 0; i < SIZE; i++) {
            list.add(new Integer(i));
        }
    }

    public void writeList() throws IOException {
        // The FileWriter constructor throws IOException, which must be caught.
        PrintWriter out = null;
        try {
            System.out.println("Entered try statement");
            out = new PrintWriter(new FileWriter("OutFile.txt"));
            for (int i = 0; i < SIZE; i++) {
                // The get(int) method throws IndexOutOfBoundsException, which must be caught.
                out.println("Value at: " + i + " = " + list.get(i));
            }
            out.close();
        } catch (IndexOutOfBoundsException e) {
            System.err.println("IndexOutOfBoundsException: " + e.getMessage());
        } catch (IOException e) {
            System.err.println("Caught IOException: " + e.getMessage());
        }
        /*
        Exception handlers can do more than just print error messages or halt the program.
        They can do error recovery, prompt the user to make a decision,
        or propagate the error up to a higher-level handler using chained exceptions
         */

        // Catching More Than One Type of Exception with One Exception Handler
        // In Java SE 7 and later, a single catch block can handle more than one type of exception.
        // This feature can reduce code duplication and lessen the temptation to catch an overly broad exception.
        try {
            System.out.println("Entered try statement");
            out = new PrintWriter(new FileWriter("OutFile.txt"));
            for (int i = 0; i < SIZE; i++) {
                // The get(int) method throws IndexOutOfBoundsException, which must be caught.
                out.println("Value at: " + i + " = " + list.get(i));
            }
            out.close();
            // This poses a somewhat complicated problem because writeList's try block can exit in one of three ways.
            // The new FileWriter statement fails and throws an IOException.
            // The list.get(i) statement fails and throws an IndexOutOfBoundsException.
            // Everything succeeds and the try block exits normally.
        } catch (IOException | IndexOutOfBoundsException ex) {
            throw ex;
        } finally {
            if (out != null) {
                System.out.println("Closing PrintWriter");
                out.close();
            } else {
                System.out.println("PrintWriter not open");
            }
        }
        /*
        The finally block always executes when the try block exits.
        This ensures that the finally block is executed even if an unexpected exception occurs.
        But finally is useful for more than just exception handling —
        it allows the programmer to avoid having cleanup code accidentally bypassed by a return, continue, or break.
        Putting cleanup code in a finally block is always a good practice, even when no exceptions are anticipated.

        The runtime system always executes the statements within the finally block
        regardless of what happens within the try block. So it's the perfect place to perform cleanup.
         */

    }
    /*
    If you try to compile, the compiler prints an error message about the exception thrown by the FileWriter constructor.
    However, it does not display an error message about the exception thrown by get.
    The reason is that the exception thrown by the constructor, IOException, is a checked exception,
    and the one thrown by the get method, IndexOutOfBoundsException, is an unchecked exception.
     */
}
