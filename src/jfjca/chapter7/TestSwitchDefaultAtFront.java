package jfjca.chapter7;

public class TestSwitchDefaultAtFront {
    public static void main(String[] args) {
         int i = 0;
         switch (args[0]) {
             default: i=i+3;
             case "2": i=i+2;
             case "0": break;
             case "1": i=i+1;
         }
         System.out.println("i is " + i);
    }
}