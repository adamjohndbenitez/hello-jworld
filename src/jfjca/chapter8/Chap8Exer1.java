package jfjca.chapter8;

public class Chap8Exer1 {
  public static void main(String[] args) {
    int size = 10;
    int[] arr = new int[]{1,2,3,4,5,6,7,8,9,10};
    int total = 0;
    for (int i = 0; i < size; i++) {
      total += arr[i];
    }

    int j = 0;
    int sum = 0;
    while (j < size) {
      sum += arr[j];
      j++;
    }

    System.out.println("total : " + total);
    System.out.println("sum : " + sum);
  }
}