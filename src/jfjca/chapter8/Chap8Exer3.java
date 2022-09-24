package jfjca.chapter8;

public class Chap8Exer3 {
  public static void main(String[] args) {
    int[] arr = new int[]{2,3,5,7,11,13,17,19,23,29};
    for (int i = 2; i < arr.length && i <= (arr[i] / 2); ++i) {
      if (arr[i] % 2 == 0) {
        System.out.println(arr[i] + " is a composite number");
      } else {
        System.out.println(arr[i] + " is a prime number");
      }
    }
  }
}