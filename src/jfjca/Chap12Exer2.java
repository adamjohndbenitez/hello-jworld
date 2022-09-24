package jfjca;/* Generate 10 random double values between 5 and  15(excluding) using Math.random() */
import java.lang.Math;
class Chap12Exer2 {
  public static void main(String[] args) {
    int min = 5;
    int max = 15;
    double randomDoubleValues = (Math.random() * (max-min+1) + min);
    System.out.println("randomDoubleValue: " + randomDoubleValues);
  }
}