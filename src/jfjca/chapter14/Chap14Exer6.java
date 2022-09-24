package jfjca.chapter14;/* Modify countVowels method to return -1, if the input array is null and 0, if the input array length is less than 10. Do not use an if statement. */

class Chap14Exer6 {
  public static void main(String[] args) throws Exception {
    int count;
    int retVal; 
    for (int i = 0; i < args.length; i++) {
      count = 0;
      retVal = 0;
      char[] c = args[i].toCharArray();
      for (int j = 0; j < c.length; j++) {
        retVal = countVowels(c);
      }
      System.out.printf("#%d argument => [%s] => return value => %d \n", i, args[i], retVal);
    }
  }
  public static int countVowels(char[] vowels) throws Exception {
    return ((vowels == null && vowels.length == 0) || vowels.length > 10) ? -1 : 0;
  }
}

/* run some tests results...

C:\Users\adamj\jfjca\chapter14>javac Chap14Exer6.java

C:\Users\adamj\jfjca\chapter14>java Chap14Exer6 null 12345678901
#0 argument => [null] => return value => 0
#1 argument => [12345678901] => return value => -1
 */