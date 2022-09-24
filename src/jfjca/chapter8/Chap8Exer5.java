package jfjca.chapter8;

public class Chap8Exer5 {
  public static void main(String[] args) {
    String[] chars = new String[4];
    char cha = 97;
    for (String s : chars)  {
      s = "" + cha;
      cha++;
    }
  }
}