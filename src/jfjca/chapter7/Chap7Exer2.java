package jfjca.chapter7;

import java.util.Scanner;

class Chap7Exer2 {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    System.out.println("Input a number btwn 0-5 : ");
    int input = sc.nextInt();
    int sum = 0;
    switch(input) {
      case 0: sum += 0;
      case 1: sum += 1;
      case 2: sum += 2;
      case 3: sum += 3;
      case 4: sum += 4;
      case 5: sum += 5;
      sum += input;
    }
    System.out.println("total = " + sum);
  }
}