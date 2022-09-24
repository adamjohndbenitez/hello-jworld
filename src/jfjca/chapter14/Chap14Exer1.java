/* Create a method countVowels that takes an array of characters as input and returns the number of vowels in the array. Furthermore, the method should throw a checked exception if the array contains the letter 'x' */
package jfjca.chapter14; //compile: javac -d . Chap14Exer1.java (-d tells compiler to create the directory structure as per the package name of the class and put the class file in the righ place)(. `after -d` tells the compiler that dot is a current directory is the target directory)

import java.lang.Exception;

public class Chap14Exer1 {
  public static void main(String[] args) throws Exception {
    int count = countVowels(new char[]
      {'a', 'e', 'i', 'o', 'u'}, "");
    System.out.println("Total vowels found: " + count);
  }
  public static int countVowels(char[] vowels, String str) throws Exception {
    int count = 0;
    int i = 0;
    while (i <= (vowels.length-1)) {
      switch (vowels[i]) {
        case 'a':
        case 'e':
        case 'i':
        case 'o':
        case 'u':
          count++;
        break;
        case 'x':
          throw new Exception("array contains x");
        default: continue;
      }
      i++;
    }
    return count;
  }
  public int countVowels(char[] vowels) throws Exception {
    return this.countVowels(vowels, "");
  }
}