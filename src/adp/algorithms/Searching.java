package adp.algorithms;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * The binarySearch algorithm searches for a specified element in a sorted List.
 * The sort algorithm can be used to sort the List prior to calling binarySearch.
 *
 */
public class Searching {
    public static void main(String[] args) {
        args = new String[]{"tina", "leah", "melvin", "adam"};
        String key = "adam";
        int pos = Collections.binarySearch(Arrays.asList(args), key);
        List<String> l = new ArrayList<>();
        if (pos < 0)
            l.add(-pos-1, key); // (-(insertion point) - 1); in this case, if pos = -1; (-(-1) - 1) = 0
            // where the insertion point is the point at which the value would be inserted into the List,
            // or the index of the first element greater than the value or list.size()
            // if all elements in the List are less than the specified value.
        /*
        NOTE: This admittedly ugly formula guarantees that the return value will be >= 0 if and
              only if the search key is found. It's basically a hack to combine a boolean (found) and an integer (index)
              into a single int return value.
        Evaluation:
              pos = -1
              -(-1)-1 = 0
              -(-1) = 1
              (-(-1) - 1) = 0

              pos-1 = -2
              (-1)-1 = -2
         */
        l.forEach(System.out::println);
    }
}
