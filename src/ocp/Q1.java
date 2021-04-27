package ocp;

public class Q1 {
    public static void main(String[] args) {
        for (int i = 0; i < 5; i++) {
            System.out.println(++i);
        }
        // A -- Wrong, post increment and pre increment is combined. not allowed.
//        for (int j = 0; j < 5;) { //no counter
//            System.out.println(++j++); //error
//        }
        // B -- Wrong, skip lesser than 5 and looping infinitely.
        for (int k = 0; ; k++) {
            if (k < 5) continue;
            System.out.println(++k);
        }
        // C -- Wrong, incrementing the counter occurs end of the for loop but does it at the beginning.
//        int l = 0; //unreachable statement
//        while (l < 5) {
//            l++; //counter must be at the end
//            System.out.println(++l);
//        }
        // D -- Correct, closest to given.
//        int m = 0;
//        while (m < 5) {
//            m++;
//            System.out.println(++m);
//        }
    }
}
