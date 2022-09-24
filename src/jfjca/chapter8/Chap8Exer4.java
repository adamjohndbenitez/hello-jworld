package jfjca.chapter8;

public class Chap8Exer4 {
  public static void main(String[] args) {
    String[] chars = new String[4];
    char cha = 97;
    for (char c = 0; c <= chars.length-1; c++) {
      chars[c] = "" + cha;
      cha++;
    }
  }
}