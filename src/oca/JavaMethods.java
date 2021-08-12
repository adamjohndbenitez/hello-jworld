package oca;

/**
 * 1 - Describe and create a method
 * 2 - Create and use accessor and mutator methods
 * 3 - Create overloaded methods
 * 4 - Describe a static method and demonstrate its use within a program
 */
public class JavaMethods {
    private int addend1;
    private int addend2;
    private int total = 0;

    // 3 - add an instance variable for the object ID.
    private int id;
    private String description;
    // 3 - add a class variable for the number of Bicycle objects instantiated.
    //     The use of the "static" keyword to create fields and methods that
    //     belong to the class, rather than to an instance of the class.
    //     Fields that have the static modifier in their declaration are called "static fields" or "class variables".
    private static int trackNextBicycle = 0;

    public JavaMethods(int id, String description) {
        // 3 - increment number of Bicycles
        //     and assign ID number
        this.id = ++trackNextBicycle;
        this.description = description;
    }

    // 1 - sum up 2 numbers and returns total, it can only be invoked in this class.
    private int sum(int addend1, int addend2) {
        return addend1 + addend2;
    }

    // 3 - sum of 3 numbers. overload sum method.
    private int sum(int addend1, int addend2, int addend3) {
        return addend1 + addend2 + addend3;
    }

    // 2 - add 1 to field total. Not return anything.
    public void setTotal(int addend1, int addend2) {
        this.total = sum(addend1, addend2);
    }

    // 2 - return value of field total.
    public int getTotal() {
        return this.total;
    }

}
