package jfjca.chapter14;/* Create a method int sum(int[] values, int start, int end) that throws an IllegalArgumentException when passed an array of length 0, a NullPointerException when passed a null, and ArrayIndexOutOfBoundsException when start and end do not fall within the range of the given array. It should return the sum of the values in the array from start to end but must throw Exception when sum is 0. */

class Chap14Exer7 {
  public static void main(String[] args) throws Exception {
    int[] values = new int[]{1,2,3,4,5,6,7,8,9,10};
    System.out.println("Total => " + sum(values, 4, 6));
  }
  static int sum(int[] values, int start, int end) throws Exception {
    if (values.length == 0) throw new IllegalArgumentException("Passed an array of length 0");
    if (values == null) throw new NullPointerException("Passed a null");
    if ((values.length < start && 0 > start) && (values.length < end && 0 > end)) throw new ArrayIndexOutOfBoundsException("Start and End do not foall within the range of the given array");

    int total = 0;
    for (int i = start; i < end; i++) {
      total += values[i];
    }

    if (total == 0) throw new Exception("sum is 0");

    return total;
  }
}