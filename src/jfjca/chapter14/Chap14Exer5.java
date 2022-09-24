package jfjca.chapter14;/* Modify countVowels method to throw an IllegalArgumentException if it is passed a null. */
//import exercises.Chap14Exer1;

class Chap14Exer5 {
  public static void main(String[] args) {
    Chap14Exer1 ex1 = new Chap14Exer1();
    try {
      ex1.countVowels(null);
    } catch (Exception e) { 
      e.printStackTrace();
      throw new IllegalArgumentException("must not pass a null on method countVowels(). error-msg:[" + e.getMessage() + "]");
    }
  }
}

/* Testing...

C:\Users\adamj\jfjca\chapter14>javac Chap14Exer5.java

C:\Users\adamj\jfjca\chapter14>java Chap14Exer5
java.lang.NullPointerException
        at exercises.Chap14Exer1.countVowels(Chap14Exer1.java:15)
        at exercises.Chap14Exer1.countVowels(Chap14Exer1.java:33)
        at Chap14Exer5.main(Chap14Exer5.java:8)
Exception in thread "main" java.lang.IllegalArgumentException: must not pass a null on method countVowels(). error-msg:[null]
        at Chap14Exer5.main(Chap14Exer5.java:11)
 */