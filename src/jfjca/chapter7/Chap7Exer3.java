package jfjca.chapter7;

import java.util.Scanner;

class Chap7Exer3 {
  public static void main(String[] args) {
  Scanner sc = new Scanner(System.in);
  System.out.print("Input a number : ");
  int input = sc.nextInt();
  
  if (input % 2 == 0) {
    System.out.println("Even");
  } else if (input % 3 == 0) {
    System.out.println("Three");
  } else if (input % 5 == 0) {
    System.out.println("Five");
  } else {
    System.out.println("Unknown");
  }

  if (input % 2 == 0) {
    System.out.print("2");
  }
  if (input % 3 == 0) {
      System.out.print("3"); 
  }
  if (input % 5 == 0) {
      System.out.print("5"); 
  }
}
}