package jfjca.chapter8;

public class Chap8Exer7 {
  public static void main(String[] args) {
    int[] a = new int[]{1,2,3,4,5};
    int[] b = new int[a.length];
    
    System.arraycopy(a, 0, b, 0, 5);
    for (int i = b.length-1; i >= 0; i--) {
      System.out.println(b[i]);
    }
  }
}