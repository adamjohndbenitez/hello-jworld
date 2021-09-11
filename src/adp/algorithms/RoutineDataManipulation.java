package adp.algorithms;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * The Collections class provides five algorithms for doing routine data manipulation
 * on List objects, all of which are pretty straightforward:
 */
public class RoutineDataManipulation {
    public static void main(String[] args) {
        args = new String[]{"tina", "leah", "melvin", "adam"};
        System.out.println("Current List of Args:");
        Arrays.stream(args).forEach(System.out::println);
        // reverse — reverses the order of the elements in a List.
        Collections.reverse(Arrays.asList(args));
        displayList(args,"Reverse Algorithm:");
        // fill — overwrites every element in a List with the specified value. This operation is useful for reinitializing a List.
        Collections.fill(Arrays.asList(args),"natsu");
        displayList(args,"Fill Algorithm:");
        // copy — takes two arguments, a destination List and a source List,
        // and copies the elements of the source into the destination, overwriting its contents.
        // The destination List must be at least as long as the source.
        // If it is longer, the remaining elements in the destination List are unaffected.
        List<String> sourceList = new ArrayList<>(Arrays.asList("happy", "carla", "lily", "fro", "Lector"));
//        List<String> destinationList = new ArrayList<>(sourceList.size() + 10);
        List<String> destinationList = new ArrayList<>(Arrays.asList(new String[sourceList.size()])); // So initialize an array String w/ sourceList size then convert into ArrayList - Arrays.asList() then put it in initial capacity.
        Collections.copy(destinationList, sourceList);
        displayList(destinationList.toArray(new String[sourceList.size()]),"Copy Algorithm:");
        // swap — swaps the elements at the specified positions in a List.
        Collections.swap(destinationList, 0,destinationList.size()-1);
        displayList(destinationList.toArray(new String[sourceList.size()]),"Swap Algorithm:");
        // addAll — adds all the specified elements to a Collection. The elements to be added may be specified individually or as an array.
        Collections.addAll(destinationList, args);
        displayList(destinationList.toArray(new String[sourceList.size() + args.length]),"AddAll Algorithm:");
    }

    private static void displayList(String[] args, String algo) {
        System.out.println(algo);
        for (String s :
             args) {
            System.out.println("- " + s);
        }
    }
}
