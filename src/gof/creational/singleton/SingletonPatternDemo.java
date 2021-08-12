package gof.creational.singleton;

public class SingletonPatternDemo {
    public static void main(String[] args) {
        // Illegal construct compile time.
        // Error: The constructor SingleObject() is not visible.
//         SingleObject object = new SingleObject();

        // Get the only object available.
        SingleObject object = SingleObject.getInstance();

        // Show the message.
        object.showMessage();
    }
}
