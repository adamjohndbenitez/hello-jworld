package jfjca.chapter14;/* Ensure that your main method prints the number of vowels in the other command line arguments even if one arguments contains an 'x' */

class Chap14Exer3 {
  public static void main(String[] args) {
    int count;
    for (int i = 0; i < args.length; i++) {
      count = 0;
      char[] c = args[i].toCharArray();
      for (int j = 0; j < c.length; j++) {
        switch (c[j]) {
          case 'a':
          case 'e':
          case 'i':
          case 'o':
          case 'u':
            count++;
          default: continue;
        }
      }
      System.out.printf("#%d argument - [%s] - number of vowels - %d \n", i, args[i], count);
    }
  }
}

/* 
Testing...

C:\Users\adamj\jfjca\chapter14>javac Chap14Exer3.java

C:\Users\adamj\jfjca\chapter14>java Chap14Exer3 leah and adam john
#0 argument - [leah] - number of vowels - 2
#1 argument - [and] - number of vowels - 1
#2 argument - [adam] - number of vowels - 2
#3 argument - [john] - number of vowels - 1
 */