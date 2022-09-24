package jfjca.chapter11;

import jfjca.chapter11.Student;

/* Add static field to Student class.
   Access this field from another class.
   Use appropriate import statement
   to access the field directly.
   Change accessibility of the field
   and see it's impact on the code
   that tries to access it. */


class Chap11Exer1 {
  
  public static void main(String[] args) {
    //System.out.println("field1: " + Student.field1);
    //System.out.println("field1: " + Student.field1);
    //System.out.println("field2: " + Student.field2);
    //System.out.println("field3: " + Student.field3);
    //System.out.println("field4: " + Student.field4);//private field cannot invoke

    AnotherClass another = new AnotherClass();
    System.out.println("result: " + another.getResult());
  }
}
//modifier 'static' is only allowed in constant variable declarations

class AnotherClass {
  String result = Student.field1;

  String getResult() {
    System.out.println("result" + result);
    return "";
  }
}