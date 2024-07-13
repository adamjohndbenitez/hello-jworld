package jfjca.chapter11;
/* Create a method name method1 in
   TestClass that accepts a Student
   object  and updates the static
   as well as instance fields of
   this object. Pass the same 
   Student object to another method
   named method2 and print the values.
   Assign a new Student object to 
   the Student variable of method2
   and set it fields to the different
   values. AFter return back to method1
   print the values again. Explain output*/

/* Create another method name add in the same
   class that can accept any number of int values
   but returns a String containing concatenation
   of all those values. What can you do to resolve
   compilation error due to the presence of the
   two methods with same signature? Invoke these
   methods from the main method of this class. */

class Chap11Exer2 {

    public static void main(String[] args) {
        Student student = new Student();
        method1(student);
        method2(student);

    }

    static void method1(Student student) {
        student.setField1("new value for field1");
    }

    static void method2(Student student) {
        System.out.println("Student Field #1" + student.getField1());
        System.out.println("Student Field #3" + student.getField3());
        System.out.println("Student Field #4" + student.getField4());
    }

}