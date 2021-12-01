package oca.foundations.javafx.overloadingmethods;

public class PlayOverloadingMethods {
    public static void main(String[] args) {
        int myNum1 = samePlusMethodName(8, 5);
        double myNum2 = samePlusMethodName(4.3, 6.26);
        System.out.println("int: " + myNum1);
        System.out.println("double: " + myNum2);
    }

    static int samePlusMethodName(int x, int y) {
        return x + y;
    }

    static double samePlusMethodName(double x, double y) {
        return x + y;
    }
}
