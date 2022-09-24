package jfjca.chapter12;

import java.lang.Math;

/* Define a few double and int variables.
   Initialize them with positive as well
   as negative values. Assign the values
   of the double variables to the int
   variable after rounding them with the
   round, ceil, and floor methods.
   Observe which assignments require
   a cast and which do not. */
class Chap12Exer1 {
  static double dPos = 1.0;
  static double dNeg = -1.0;
  static int iPos = 0;
  static int iNeg = 0;

  public static void main(String[] args) {
    //rounding double into integers
    //iPos = Math.round(dPos);
    //iNeg = Math.round(dNeg);
    iPos = (int) Math.round(dPos);
    iNeg = (int) Math.round(dNeg);

    System.out.println("Round + Double to Integer: " + iPos);
    System.out.println("Round - Double to Integer: " + iNeg);
    /* ^Without cast
Chap12Exer1.java:18: error: incompatible types: possible lossy conversion from long to int
    iPos = Math.round(dPos);
                     ^
Chap12Exer1.java:19: error: incompatible types: possible lossy conversion from long to int
    iNeg = Math.round(dNeg);
                     ^
2 errors */
    /* ^With cast
Positive Integer: 1
Negative Integer: -1 */

    //-------
    //Ceiling double to integer
    //iPos = Math.ceil(dPos);
    //iNeg = Math.ceil(dNeg);
    iPos = (int) Math.ceil(dPos);
    iNeg = (int) Math.ceil(dNeg);

    System.out.println("Ceil + Double to Integer: " + iPos);
    System.out.println("Ceil - Double to Integer: " + iNeg);
    /* ^ Chap12Exer1.java:34: error: incompatible types: possible lossy conversion from double to int
    iPos = Math.ceil(dPos);
                    ^
Chap12Exer1.java:35: error: incompatible types: possible lossy conversion from double to int
    iNeg = Math.ceil(dNeg);
                    ^
2 errors*/
    /* ^With cast
Positive Integer: 1
Negative Integer: -1 */

    //-------
    //Flooring double to integer
    //iPos = Math.floor(dPos);
    //iNeg = Math.floor(dNeg);
    iPos = (int) Math.floor(dPos);
    iNeg = (int) Math.floor(dNeg);

    System.out.println("Floor + Double to Integer: " + iPos);
    System.out.println("Floor - Double to Integer: " + iNeg);
    /* Chap12Exer1.java:49: error: incompatible types: possible lossy conversion from double to int
    iPos = Math.floor(dPos);
                     ^
Chap12Exer1.java:50: error: incompatible types: possible lossy conversion from double to int
    iNeg = Math.floor(dNeg);
                     ^
2 errors */
  }
}