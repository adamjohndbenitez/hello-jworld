package jfjca;/* Generate 10 random double values between 1 and 10 (both including) using Math.random() and the Random class. */
import java.lang.Math;
import java.util.Random;
class Chap12Exer3 {
  static int[] items = new int[]{1,2,3};
  static Random rand = new Random();
  public static void main(String[] args) {
    
    System.out.println("random: " + getRandArrayElement()); 	
  }

   public static int getRandArrayElement(){
        return items[rand.nextInt(items.length)];
    }
}