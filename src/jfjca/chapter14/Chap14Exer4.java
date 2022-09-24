package jfjca.chapter14;/* Pass null to the countVowels method and observe the output */
//import exercises.Chap14Exer1;

class Chap14Exer4 {
  public static void main(String[] args) {
    Chap14Exer1 ex1 = new Chap14Exer1();
    try {
      ex1.countVowels(null);
    } catch (Exception e) { 
      e.printStackTrace();
      throw new NullPointerException("must not pass a null on method countVowels(). error-msg:[" + e.getMessage() + "]");
    }
  }
}

/*
...} catch NullPointerException npe) {... 
result to ~
C:\Users\adamj\jfjca\chapter14>javac Chap14Exer4.java
Chap14Exer4.java:7: error: unreported exception Exception; must be caught or declared to be thrown
    ex1.countVowels(null);
                   ^
1 error

...} catch Exception e) {... 
java.lang.NullPointerException
        at exercises.Chap14Exer1.countVowels(Chap14Exer1.java:15)
        at exercises.Chap14Exer1.countVowels(Chap14Exer1.java:33)
        at Chap14Exer4.main(Chap14Exer4.java:8)
Exception in thread "main" java.lang.NullPointerException: must not pass a null on method countVowels(). error-msg:[null]
        at Chap14Exer4.main(Chap14Exer4.java:11)
 */