package jfjca.chapter7;

import java.util.Scanner;

class Chap7Exer1 {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    System.out.print("Pls input number : ");    
    int input = sc.nextInt();
    String result = isOddOrEven(input);
    System.out.println("input is " + result);
  }
  private static String isOddOrEven(int input) {
    return (input % 2 == 0) ? "even" : "odd";
  }
}