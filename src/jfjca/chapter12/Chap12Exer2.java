package jfjca.chapter12;

import java.lang.Math;//no need to be imported, its a utility class have static method.

/* Generate 10 random double values
   between 5 and 15 (excluding)
   using Math.random() */
class Chap12Exer2 {
  static double randVals;

  public static void main(String[] args) {
    randVals = Math.random() * 10;
    System.out.println("6 - 14 random doube values: " + randVals);
  }
}