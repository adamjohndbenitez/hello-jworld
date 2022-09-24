package jfjca.chapter14;/* Invoke the countVowels method from an in a loop and print its return value for each command line argument. Observe what happens in the following situtations: there is no command line argument, there are multiple arguments, but the first argument contains an 'x', (Use String's toCharArray method to get an array of characters from the String. */
//import exercises.Chap14Exer1;

//compile: javac Chap14Exer2.java
//run: java Chap14Exer2
class Chap14Exer2 {
  public static void main(String[] args) throws Exception {
    Chap14Exer1 c = new Chap14Exer1();
    int count = c.countVowels(new char[]{'a', 'x', 'i', 'o', 'u'});//working
    //int count = c.countVowels(args[0].toCharArray());//not working
    System.out.println("Total vowels found: " + count);
    //System.out.println("args[0]: " + args[0]);//displays "args[0]: leah" java Chap14Exer2 leah
  }
}