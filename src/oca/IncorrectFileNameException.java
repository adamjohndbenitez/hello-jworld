package oca;

//
//public class IncorrectFileNameException extends Exception {
public class IncorrectFileNameException extends Exception {
    /**
     * Constructs a new exception with {@code errorMessage} as its detail message.
     * The cause is not initialized, and may subsequently be initialized by a
     * call to {@link #initCause}.
     */
    public IncorrectFileNameException(String errorMessage, Throwable err) { // add a java.lang.Throwable
        super(errorMessage, err);
    }
    /*
    Losing the root cause of the exception.
    To fix this, we can also add a java.lang.Throwable parameter to the constructor.
    This way, we can pass the root exception to the method call:
     */
}
