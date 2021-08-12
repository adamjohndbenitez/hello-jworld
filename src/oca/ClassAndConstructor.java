package oca;

/**
 * 1 - Create a new class including a main method
 * 2 - Use the private modifier
 * 3 - Describe the relationship between an object and its members
 * 4 - Describe the difference between a class variable, an instance variable, and a local variable
 * 5 - Develop code that creates an object's default constructor and modifies the object's fields
 * 6 - Use constructors with and without parameters
 * 7 - Develop code that overloads constructors
 */
public class ClassAndConstructor {
    // 2 - Use the private modifier field.
    private String str = "welcome!";

    // 1 - Create a new class including a main method.
    public static void main(String[] args) {
        System.out.println("Hello World");

        // Local Variable
        int localVar = 1; // Local variables are declared in methods, constructors, or blocks. Local variables are created when the method, constructor or block is entered and the variable will be destroyed once it exits the method, constructor, or block.
        System.out.println("Local Variable : " + localVar);

        ClassAndConstructor obj1 = new ClassAndConstructor(); // need to create instance of an object to access instance variable.
        System.out.println("Instance Variable : " + obj1.instanceVar);

        System.out.println("Class Variable : " + ClassAndConstructor.classVar); // static field or class variable can be directly/explicitly access through class object.

        ClassAndConstructor obj2 = new ClassAndConstructor(4, 5, "Hey! and Welcome!");
        System.out.println("Instance Variable : " + obj2.instanceVar);
        System.out.println("Class Variable : " + ClassAndConstructor.classVar); // static field or class variable can be directly/explicitly access through class object.
        System.out.println("String Value : " + obj2.getStr());

        ClassAndConstructor obj3 = new ClassAndConstructor("Hello! and Welcome!");
        System.out.println("String Value : " + obj3.getStr());
    }

    // 2 - Use the private modifier method.
    private String welcomeMsg() {
        return str + "into Java world";
    }

    // 3 - Describe the relationship between an object and its members?
    /*
        Software objects are conceptually similar to real-world objects:
        they too consist of state(fields) and related behavior(methods).

        Methods operate on an object's internal state and serve as the
        primary mechanism for object-to-object communication.
        Hiding internal state and requiring all interaction to be performed
        through an object's methods is known as data encapsulation —
        a fundamental principle of object-oriented programming.
     */

    // NOTE: benefits of Bundling code into individual software objects
    /*
    1. Modularity: The source code for an object can be written and maintained independently of the source code for other objects. Once created, an object can be easily passed around inside the system.
    2. Information-hiding: By interacting only with an object's methods, the details of its internal implementation remain hidden from the outside world.
    3. Code re-use: If an object already exists (perhaps written by another software developer), you can use that object in your program. This allows specialists to implement/test/debug complex, task-specific objects, which you can then trust to run in your own code.
    4. Pluggability and debugging ease: If a particular object turns out to be problematic, you can simply remove it from your application and plug in a different object as its replacement. This is analogous to fixing mechanical problems in the real world. If a bolt breaks, you replace it, not the entire machine.
     */

    // 4 - Describe the difference between a class variable, an instance variable, and a local variable
    int instanceVar = 2; // Instance variables are declared in a class, but outside a method. When space is allocated for an object in the heap, a slot for each instance variable value is created. Instance variables hold values that must be referenced by more than one method, constructor or block, or essential parts of an object's state that must be present throughout the class.
    static int classVar = 3; // Class variables also known as static variables are declared with the static keyword in a class, but outside a method, constructor or a block. There would only be one copy of each class variable per class, regardless of how many objects are created from it.

    // 6 - Use constructors with and without parameters.
    public ClassAndConstructor() {}

    // 5 - Develop code that creates an object's default constructor and modifies the object's fields.
    public ClassAndConstructor(int instanceVar, int classVar, String str) {
        this.instanceVar = instanceVar;
        this.classVar = classVar;
        this.str = str;
    }

    public String getStr() {
        return str;
    }

    // 7 - Develop code that overloads constructors
    public ClassAndConstructor(String str) {
        this.str = str;
    }
}
