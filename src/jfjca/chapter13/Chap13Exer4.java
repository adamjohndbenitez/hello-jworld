package jfjca.chapter13;/* Write code to determine whether the toString and substring methods of String class return an interned string or not. Confirm your results by checking the JavaDoc API descritions of these methods. */

class Chap13Exer4 {
  public static void main(String[] args) {
    String name = new String("Adam John Diaz Benitez");

    String toString = name.toString();
    System.out.println("new String(\"Adam John Diaz Benitez\") is an interned to OR pulled from string pool name.toString() => " + (name == toString));
    String substring = name.substring(5, 9);
    System.out.println("substring is an interned to OR pulled from string pool name.substring(5, 9) => " + (substring == "John"));

    String internJohn = substring.intern();
    System.out.println("substring return a new object from heap space but internJohn's string is got from string pool OR pulled from string pool => " + (internJohn == "John"));

    
  }
}