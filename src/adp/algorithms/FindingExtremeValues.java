package adp.algorithms;

import java.util.Arrays;
import java.util.Collections;

/**
 * The min and the max algorithms return, respectively,
 * the minimum and maximum element contained in a specified Collection.
 */
public class FindingExtremeValues {
    public static void main(String[] args) {
        args = new String[]{"tina", "leah", "melvin", "adam"};
        String min = Collections.min(Arrays.asList(args));
        System.out.println("Min : " + min);
        String max = Collections.max(Arrays.asList(args));
        System.out.println("Max : " + min);
    }
}
