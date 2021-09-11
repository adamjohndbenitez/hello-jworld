package adp.algorithms;

import java.util.Arrays;
import java.util.Collections;

/**
 * The frequency and disjoint algorithms test some aspect of the composition of one or more Collections:
 */
public class Composition {
    public static void main(String[] args) {
        args = new String[]{"tina", "leah", "melvin", "adam"};
        // frequency — counts the number of times the specified element occurs in the specified collection
        int frequency = Collections.frequency(Arrays.asList(args), "adam");
        System.out.println("frequency : " + frequency);
        // disjoint — determines whether two Collections are disjoint; that is, whether they contain no elements in common
        String[] args1 = new String[]{"natsu", "lucy", "gray", "erza"};
        boolean disjoint = Collections.disjoint(Arrays.asList(args), Arrays.asList(args1));
        System.out.println("disjoint : " + disjoint + " (Returns true if the two specified collections have no elements in common.)");

    }
}
