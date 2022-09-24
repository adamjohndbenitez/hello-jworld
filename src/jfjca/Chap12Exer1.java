package jfjca;/* Define a few double and int variables. Initialize them with positive as well as negative values. Assign the values of the double variables to the int variables after rounding them with the round, ceil, and floor methods. Observe which assignments require a cast and which do not */
import java.lang.Math;

class Chap12Exer1 {
  public static void main(String[] args) {
    int i = 1;
    double d = 1.5;
    int i2 = -1;
    double d2 = -1.5;

    int ii = Math.round(i);
    System.out.println("ii: " + ii);
    int ii2 = Math.round(i2);
    System.out.println("i2: " + ii2);
    int iii = (int) Math.ceil(i); //need to cast to int
    System.out.println("iii: " + iii);
//    int iii2 = (int) Math.ceil();
    /* Error:(17, 20) java: method ceil in class java.lang.Math cannot be applied to given types;
  required: double
  found: no arguments
  reason: actual and formal argument lists differ in length */
    System.out.println("ii2: " + ii2);

    double dd = Math.round(d);
    System.out.println("dd: " + dd);
    double dd2 = Math.round(dd);
    System.out.println("dd2: " + dd2);
    double ddd = Math.ceil(d);
    System.out.println("dd: " + ddd);
    double ddd2 = Math.ceil(ddd);
    System.out.println("dd2: " + ddd2);
  }
}