package play;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/*
* #1. Eight houses, represented as cells, are arranged in a straight line
* Each day every cell competes with its adjacent cells(neighbors)
* An integer value of 1 represent an active cell and a value of 0
* represents an inactive cell if the neighbors on both the sides of a cell
* are either active or inactive cell, the cell becomes inactive on the next day, otherwise
* the cell becomes active, The two cells on each end have a single adjacent cell, so
* assume that the unoccupied space on the opposite side is an inactive cell, Even after
* updating the cell state, consider its previous state when updating the state of other cells,
* The state information of all cells should be updated simultaneously.
*
* #2 The greatest common divisor (GCD), also called highest common factor
* (HCF) of N numbers is the largest positive integer that divides all numbers
* without giving a remainder
*
* */
public class AmazonDemo {
    private String str1;
    private String str2;
    public AmazonDemo(String str1, String str2) {
        this.str1 = str1;
        this.str2 = str2;
    }

    public AmazonDemo(String str1) {
        this.str1 = str1;
    }

    public AmazonDemo() {
    }

    public String getStr1() {
        return str1;
    }

    public void setStr1(String str1) {
        this.str1 = str1;
    }

    public String getStr2() {
        return str2;
    }

    public void setStr2(String str2) {
        this.str2 = str2;
    }

    // METHOD SIGNATURE BEGINS, THIS METHOD IS REQUIRED
    public List<Integer> cellCompete(int[] states, int days)
    {
        // WRITE YOUR CODE HERE
        int[] temp = new int[states.length];
        int day = 1;
        while (day <= days) {
            temp[0] = states[1] == 0 ? 0 : 1;
            for (int i = 1; i < states.length-1; i++) {
                if (states[i-1] == states[i+1]) temp[i] = 0;
                else temp[i] = 1;
            }
            temp[states.length-1] = states[states.length-2] == 0 ? 0 : 1;
            day++;
            states = temp; // updating temp onto state
            temp = new int[states.length]; // reset temp
        }
        return Arrays.stream(states).boxed().collect(Collectors.toList());
    }
    // METHOD SIGNATURE ENDS

    public int generalizedGCD(int num, int[] arr) {
        int gcd = 0;
        outerBreak:
        for (int i = 1; i < num; i++) {
            for (int j = 0; j < arr.length; j++) {
                if (arr[j] % i != 0) break outerBreak;
            }
            gcd = i;
        }
        return gcd;
    }
}
