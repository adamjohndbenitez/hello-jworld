package adp.algorithms;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * The sort algorithm reorders a List so that its elements are in ascending order according to an ordering relationship.
 * natural ordering - Comparable implementations provide a natural ordering for a class, which allows objects of that class to be sorted automatically.
 *
 * sort operation uses a slightly optimized merge sort algorithm that is fast and stable:
 * - Fast: It is guaranteed to run in n log(n) time and runs substantially faster on nearly sorted lists.
 *   Empirical tests showed it to be as fast as a highly optimized quicksort.
 *   A quicksort is generally considered to be faster than a merge sort but isn't stable and
 *   doesn't guarantee n log(n) performance.
 * - Stable: It doesn't reorder equal elements. This is important if you sort the same list repeatedly on
 *   different attributes. If a user of a mail program sorts the inbox by mailing date and then sorts it by sender,
 *   the user naturally expects that the now-contiguous list of messages from a given sender will (still)
 *   be sorted by mailing date. This is guaranteed only if the second sort was stable.
 */
public class Sort {
    public static void main(String[] args) {
        args = new String[]{"tina", "leah", "melvin", "adam"};
        List<String> list = Arrays.asList(args);
        Collections.sort(list);
        System.out.println(list);
    }
}
