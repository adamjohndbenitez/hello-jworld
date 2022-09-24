package jfjca.chapter8;

/* try print reverse order */
public class Chap8Exer6 {
  public static void main(String[] args) {
    String[] strs = new String[]{"Adam", "John", "D", "Benitez"};
    for (String s : strs) {
      System.out.println(s);
    }

    for (int i = strs.length-1; i >= 0; i--)  {
      System.out.println(strs[i]);
    }
  }
}