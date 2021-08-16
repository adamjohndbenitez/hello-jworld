package oca;

public class UsingLoopingStatements {
    public static void main(String[] args) {
        // Describe looping statements = continually executes a block of statements while a particular condition is true

        // Use a for loop including an enhanced for loop
        forLoopDemo();
        enhanceForDemo();

        // Use a while loop
        whileDemo();

        // Use a do- while loop = do-while evaluates its expression at the bottom of the loop instead of the top.
        // Therefore, the statements within the do block are always executed at least once
        doWhileDemo();

        // Compare and contrast the for, while, and do-while loops
        /*
        The while and do-while statements continually execute a block of statements while a particular condition is true.
        The difference between do-while and while is that do-while evaluates its expression at the bottom of the loop instead of the top.
        Therefore, the statements within the do block are always executed at least once. The for statement provides a compact way to iterate over a range of values. It has two forms, one of which was designed for looping through collections and arrays.
         */

        // Develop code that uses break and continue (branching statements)
        breakDemo();
        breakWithLabelDemo();
        continueDemo();
    }

    private static void forLoopDemo() {
        for (int i=1; i<11; i++) {
            System.out.println("Count is: " + i);
        }
    }

    // warning can't stop if invoke.
    private static void infiniteForLoop() {
        for ( ; ; ) {
            System.out.println("Infinity and beyond");
        }
    }

    private static void enhanceForDemo() {
        int[] numbers =
                {1,2,3,4,5,6,7,8,9,10};
        for (int item : numbers) {
            System.out.println("Count is: " + item);
        }
    }

    private static void whileDemo() {
        int count = 1;
        while (count < 11) {
            System.out.println("Count is: " + count);
            count++;
        }
    }

    private static void doWhileDemo() {
        int count = 1;
        do {
            System.out.println("Count is: " + count);
            count++;
        } while (count < 11);
    }

    // The break statement has two forms: labeled and unlabeled.
    private static void breakDemo() {
        int[] arrayOfInts =
                { 32, 87, 3, 589,
                        12, 1076, 2000,
                        8, 622, 127 };
        int searchfor = 12;

        int i;
        boolean foundIt = false;

        for (i = 0; i < arrayOfInts.length; i++) {
            if (arrayOfInts[i] == searchfor) {
                foundIt = true;
                break;
            }
        }

        if (foundIt) {
            System.out.println("Found " + searchfor + " at index " + i);
        } else {
            System.out.println(searchfor + " not in the array");
        }
    }

    private static void breakWithLabelDemo() {
        int[][] arrayOfInts = {
                { 32, 87, 3, 589 },
                { 12, 1076, 2000, 8 },
                { 622, 127, 77, 955 }
        };
        int searchfor = 12;

        int i;
        int j = 0;
        boolean foundIt = false;

        search: // When the value is found, a labeled break terminates the outer for loop (labeled "search")
        for (i = 0; i < arrayOfInts.length; i++) {
            for (j = 0; j < arrayOfInts[i].length;
                 j++) {
                if (arrayOfInts[i][j] == searchfor) {
                    foundIt = true;
                    break search;
                }
            }
        }

        if (foundIt) {
            System.out.println("Found " + searchfor + " at " + i + ", " + j);
        } else {
            System.out.println(searchfor + " not in the array");
        }
    }

    // The continue statement skips the current iteration.
    private static void continueDemo() {

        String searchMe = "peter piper picked a " + "peck of pickled peppers";
        int max = searchMe.length();
        int numPs = 0;

        for (int i = 0; i < max; i++) {
            // interested only in p's
            if (searchMe.charAt(i) != 'p')
                continue;

            // process p's
            numPs++;
        }
        System.out.println("Found " + numPs + " p's in the string.");
    }

    private static void continueWithLabelDemo() {
        String searchMe = "Look for a substring in me";
        String substring = "sub";
        boolean foundIt = false;

        int max = searchMe.length() -
                substring.length();

        test: //uses the labeled form of continue to skip an iteration in the outer loop.
        for (int i = 0; i <= max; i++) {
            int n = substring.length();
            int j = i;
            int k = 0;
            while (n-- != 0) {
                if (searchMe.charAt(j++) != substring.charAt(k++)) {
                    continue test;
                }
            }
            foundIt = true;
            break test;
        }
        System.out.println(foundIt ? "Found it" : "Didn't find it");
    }

    private static int returnValue() {
        return 1;
    }

    private static void returnNoValue() {
        return;
    }
}
