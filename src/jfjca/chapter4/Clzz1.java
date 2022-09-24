package jfjca.chapter4;
public class Clzz1 {
    public static int i = 0;
    /*C:\Users\adamj\jfjca\chapter4>javac -d . Clzz1.java Clzz2.java
Clzz2.java:5: error: i is not public in Clzz1; cannot be accessed from outside package
        System.out.println("Clzz1.i "+Clzz1.i);
                                           ^
1 error*/

    /*static {
        int i = 0;
    };
    {
        int i2 = 0;
    };*/
    /*C:\Users\adamj\jfjca\chapter4>javac -d . Clzz1.java Clzz2.java
Clzz2.java:5: error: cannot find symbol
        System.out.println("Clzz1.i "+Clzz1.i);
                                           ^
  symbol:   variable i
  location: class Clzz1
1 error*/
}