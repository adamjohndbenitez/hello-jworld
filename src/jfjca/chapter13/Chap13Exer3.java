package jfjca.chapter13;/* Write a method that accepts a String as input and count the number of spaces in the string from start to until it finds an 'x', or if there is no 'x' in the string, till end */
import java.util.Scanner;

class Chap13Exer3 {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    System.out.print("Input string => ");

    String input = sc.nextLine();
    sc.close();
    System.out.println("Entered => " + input);
    int spaceCount = countSpacesTerminateX(input);

    System.out.println("Counted spaces until x => " + spaceCount);
  }

  static int countSpacesTerminateX(String input) {
    char[] chars = input.toCharArray();
    int i = 0, count = 0;
    while (i < chars.length) {
      if (chars[i] == ' ') {
        count += 1;
      } else if (chars[i] == 'x') { 
        break; 
      }
      i++;
    }
    return count;
  }
}