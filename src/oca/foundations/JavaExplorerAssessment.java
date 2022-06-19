package oca.foundations;


import oca.IncorrectFileNameException;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.EmptyStackException;
import java.util.Scanner;

public class JavaExplorerAssessment extends Exception {
    public static void main(String[] args) throws IncorrectFileNameException {
        //#1. create a Clothing array to store these two items?
        Clothing item1 = new Clothing("herschel", 1);
        Clothing item2 = new Clothing("puma", 2);
        //Clothing[] items = (item1, item2);//wrong
        //Clothing items = [item1, item2];//wrong
        //Clothing[] items(item1, item2});//wrong
        Clothing[] items = {item1, item2};//correct
        for (Clothing c : items) {
            System.out.println(c);
        }

        //#2. valid statement?
        //System.out("Welcome to Duke's Choice Shop!").println;//wrong
        //System.out.println("Welcome to Duke's Choice Shop!")//wrong
        //System.out.println(Welcome to Duke's Choice Shop!);//wrong
        //System.println("Welcome to Duke's Choice Shop!");//wrong
        System.out.println("Welcome to Duke's Choice Shop!");//correct

        //#3. attempt to divide by zero?
        //int ave_price = 10/0;//Exception in thread "main" java.lang.ArithmeticException: / by zero

        /*#4. You’ve setup a Clothing class
        with a has a public double field price.
        You’ve created two instances in your program’s
        main method where item1 is a jacket and
        item2 is a shirt. You’ve also created a double
        for a tax rate in the main method.
        How would you accurately calculate the after-tax
        total for two shirts and a jacket from the main method?
         */
        double tax = 0.14;
        //double total = item2.price+item2.price+item1.price *tax; // total w/ tax: 31.92
        //int total = item2.price+item2.price+item1.price *tax;//wrong
        //int total = (item2.price*2 + item1.price)*(1+tax);//wrong
        double total = (item2.price*2 + item1.price)*(1+tax);//correct
        //double total = (item2*2 + item1*(1+tax);//wrong, Operator '*' cannot be applied to 'oca.foundations.Clothing', 'int' OR 'double'
        System.out.println("item1 price:" + item1.price);
        System.out.println("item2 price:" + item2.price);
        System.out.println("total: " + (item1.price+item2.price)); // total 42
        System.out.println("total w/ tax: " + total);

        //#5 You’ve overridden the toString method
        // in the Clothing class.
        // From which class does this method originate?

        /*
        #6 You've encapsulated the Customer class's size field.
        The related setSize method requires an integer argument.
        This argument is translated into a String, which is used to
        set the class's size String field.
        You instantiate a Customer c1. in the main method,
        which is written in another class.
        How should you set the size of customer c1 fom the main method?
         */
        Customer c1 = new Customer("AJ");
//        c1.setSize(3);
        /*
        #8 if you want to assign a name of the Customer you can just
        access field and assign value to it.
         */
        c1.name = "Pinky";
        System.out.println("name: " + c1.getName());

        /*
        #7 You have a Customer class with a public String field size.
        In you program's main method, you create a Customer instance c1.
        What is printed as a result of running this code from the main method?
         */
        int measurement = 3;
        switch (measurement) {
            case 3: c1.size = "S";
            case 6: c1.size = "M";
            case 9: c1.size = "L"; //correct ans, because there are no breaks, it doesn't stop
            break;
            default: c1.size = "X";
        }

        System.out.println(c1.size);

        /*
        #9 You're encapsulating the Clothing class's price field by writing a setPrice method.
        The price field must always be set above a certain minimum. How would you implement this method?
         */
        item1.setPrice(8.0);
        System.out.println("Price: " + item1.getPrice());

        c1.addItem(new Clothing[]{
                new Clothing("nike", 1),
                new Clothing("rebook", 2)
        });

        Arrays.asList(c1.getClothingList()).forEach(c -> System.out.println("clothing: " + c.getDescription()));

        /*
        #10 How would you loop through the Clothing array items to calculate the total price of all items after tax?
        The Clothing class has a public double field price. Assume the double variables total and tax are already declared.
         */
        /*forEach (Clothing c in items) {
            total += c.price*(1+tax);
        }*///wrong
        for (Clothing c: items) {
            total = c.price*(1+tax);
        }
        /*for (Clothing c: items[]) {
            total = total + c.price*tax;
        }*///wrong
        for (Clothing c: items) {
            total = total + c.price*(1+tax);
        }//correct

        //#11
        Clothing item3 = new Clothing("Blue Jacket", 20);

        Employee[] department = new Employee[10];
//        department[11] = new Employee();// throws Exception in thread "main" java.lang.ArrayIndexOutOfBoundsException: 11   at oca.foundations.JavaExplorerAssessment.main(JavaExplorerAssessment.java:122)
        //#12 What exception occurs when you try adding an eleventh employee to the department?

        /*
        #13
        You have a Customer class with a public String field size.
        In your program’s main method, you create a Customer instance c1.
        How could you consolidate this switch statement,
        which is used to set sizes based on an int variable measurement?
        switch(measurement){
          case 1:
             c1.size "S";
              break;
          case 2:
              c1.size = S";
              break;
          case 3:
              c1.size = S";
              break;
        }
         */
        /*switch(measurement){
            case 1, 2, 3: //wrong! enhance switch block are not supported.
                c1.size = "S";
                break;
        }*/
        /*switch(measurement){
            case 1 || 2 || case 3: // wrong, Condition '1 || 2 ||' is always 'true'
                c1.size = "S";
                break;
        }*/
        switch(measurement){
            case 1: case 2: case 3:
                c1.size = "S";
                break;
        }
        /*switch(measurement){
            case 1, case 2, case 3, // wrong! after case label ':' expected
                    c1.size = "S";
                break;
        }*/

        /* #14
        public Customer(String name, int measurement) {…}
        How would you instantiate a Customer object using this constructor?
         */
        Customer c2 = new Customer("Pinky", 3); //correct!
        //Customer c2 = new Customer("Pinky", "S", items);
        //Customer c2 = new Customer("Pinky", "S");
        //Customer c2 = new Customer("Pinky");
        //Customer c2 = new Customer();
        //Customer c2 = new Customer("Pinky", 3, items);

        /* #15
        You have an array of Clothing objects called items.
        The Clothing class has public fields for size and price.
        You create a loop to calculate the total price of items.
        How would you add an if statement to ensure an item is only added
        to the total if it’s the same size as the customer c1?
        Assume the Customer class has a public String field size.
         */
        /*for(Clothing c: items){ // Exception in thread "main" java.lang.NullPointerException
            if(c.size.equals(c1)){
                //add to total
            }
        }*/


        /*for(Clothing c: items){
            if(c.size.equals(c1.size)){ // red on equals since size is int.
                //add to total
                System.out.println("added cloth");
            }
        }*/

        /*for(Clothing c: items){
            if(c == c1)){ // not a size
                //add to total
            }
        }*/

        /*for(Clothing c: items){
            if(items[c].size.equals(c.size)){ // red on [c]
                //add to total
            }
        }*/

        // Passing Reference Data Type Arguments
        Circle circle = new Circle();
        moveCircle(circle, 1, 2);

        int size = 0;

        // throw statement
        if (size == 0) {
            throw new EmptyStackException();
        }
        // For now, all you need to remember is that you can throw only objects that inherit from the java.lang.Throwable class.
        /*
        class hierarchy of the Throwable class and its most significant subclasses.
        As you can see, Throwable has two direct descendants:
        Error and Exception.
                Object
                   |
                Throwable
            _______|_______
            |              |
            Error          Exception
              /|\          ___|_______
              ...          /|\        |
                           ...       RuntimeException (eg. NullPointerException)
                                         /|\
                                         ...
         */

        //Error Class - When a dynamic linking failure or other hard failure in the JVM Java virtual machine occurs,
        // the virtual machine throws an Error. Simple programs typically do not catch or throw Errors.

        /*
        The Java platform defines the many descendants of the Exception class. These descendants indicate various types of exceptions that can occur.
         - IllegalAccessException signals that a particular method could not be found.
         - NegativeArraySizeException indicates that a program attempted to create an array with a negative size.
         */

        /* Reason why Custom Exceptions:
            1. Business Logic Exceptions - help the application users or the developers understand what the exact problem is.
            2. Subset of Java Exceptions - specific treatment to a subset of existing Java exceptions
        */

        String filename = "1Z0-811_notes.txt";
        try (Scanner sc = new Scanner(new File(filename))) {
            if (sc.hasNextLine()) System.out.println("File next line : " + sc.nextLine());
        } catch (FileNotFoundException fnfe) { // <- classic way of handling Java "CHECKED" exceptions.
            // While the code throws FileNotFoundException,
            // "it's not clear what the exact cause is"
            // — whether the file doesn't exist
            // or the file name is invalid.
            if (!isCorrectFileName(filename)) {
                try { // if not try-catch, you can add IncorrectFileNameException in the method public static void main(String[] args) throws IncorrectFileNameException {
                    throw new IncorrectFileNameException("Incorrect filename : " + filename, fnfe); // passing e will not lose the root cause from which they occurred.
                } catch (IncorrectFileNameException incorrectFileNameException) {
                    incorrectFileNameException.printStackTrace();
                }
            }

            // we'll need a custom unchecked exception similar to the previous one,
            // as this error will only be detected during runtime.
        } catch (IllegalArgumentException iae) {
            if (!containsExtension(filename)) {
                throw new IncorrectFileNameException("Filename does not contain extension : " + filename, iae); // passing e will not lose the root cause from which they occurred.
            }
        }

        // NOTE: To create a custom exception, we have to extend the java.lang.Exception class.
        // NOTE: To create a custom unchecked exception, we need to extend the java.lang.RuntimeException class:

        // Checked = Explicit = Compile time (eg. java classic exceptions)
        // Unchecked = Implicit = Runtime ()
    }

    private static boolean containsExtension(String filename) {
        return filename.contains(".txt");
    }

    private static boolean isCorrectFileName(String filename) {
        return !filename.isEmpty(); // supposed we check if file is not exist or empty
    }

    public static void moveCircle(Circle circle, int deltaX, int deltaY) {
        // code to move origin of circle to x+deltaX, y+deltaY
        circle.setX(circle.getX() + deltaX);
        circle.setY(circle.getY() + deltaY);

        /*
        At this point, Circle(1, 2)
        the object pointed to by circle has changed
        still references the same Circle object
         */

        // code to assign a new reference to circle
        circle = new Circle(0, 0);
        System.out.println(circle.getY());
    }
}
/*
#8 If a class implements a Comparable, what method
should you override? compareTo
 */
class Customer implements Comparable {
    String name;
    String size;
    int measurement;

    public Customer(String name) {
        this.name = name;
    }

    public Customer(String name, int measurement) {
        this.name = name;
        this.measurement = measurement;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    Clothing[] clothingList;

    public void addItem(Clothing[] clothings) {
        clothingList = clothings;
    }

    public Clothing[] getClothingList() {
        return clothingList;
    }

    @Override
    public int compareTo(Object o) {
        return 0;
    }
}

class Clothing implements Comparable<Clothing> {
    /*
    #12 How would you declare the MIN_PRICE
    field of the Clothing class?
    The value of this field should never change.
    Accessing this field should not require
    you to create a Clothing instance.
     */
    // putting static will not require it to create Clothing instance just to access it.
    public static final int MIN_PRICE = 20;

    String description;
    double price;
//    String size;
    int size;

    public Clothing(String description, int size) {
        this.description = description;
        this.size = size;
    }

    public Clothing() {
    }

    /*
    #11 Clothing item1 = new Clothing("Blue Jacket", 20.9, "M");
    How would you declare the Clothing constructor?
     */
    /*public Clothing(String description,
                    double price,
                    String size) {
        this.description = description;
        this.price = price;
        this.size = size;
    }*/

    public void setDescription(String description) {
        this.description = description;
    }

    /*
    #9 You're encapsulating the Clothing class's price field by writing a setPrice method.
    The price field must always be set above a certain minimum. How would you implement this method?
     */
    public void setPrice(double price) {
//        this.price = price;
        if (price < MIN_PRICE) {
            this.price = MIN_PRICE;
        } else {
            this.price = price;
        }
    }

    public void setSize(int size) {
        this.size = size;
    }

    public String getDescription() {
        return description;
    }

    public double getPrice() {
        return price;
    }

    public int getSize() {
        return size;
    }

    @Override
    public int compareTo(Clothing o) {
        return this.description.compareTo(o.getDescription());
    }

    /*
    #13 You’ve overridden the toString method in the Clothing class.
    From which class does this method originate?
     */
    // in IntellJ, cmd + N - Override Methods, under java.lang.Object there is a toString()
    // Or ctrl + O - to select methods to Override/Implement under java.lang.Object there is a toString()
    @Override
    public String toString() {
        return super.toString();
    }
}

class Employee {
    public Employee() {
    }
}

class Circle {
    int x;
    int y;

    public Circle() {
    }

    public Circle(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }
}