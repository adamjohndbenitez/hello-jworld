package adp.algorithms;

import java.io.File;
import java.io.IOException;
import java.util.*;

/**
 * Suppose you want to print out the anagram groups from our earlier example in reverse order of size — largest anagram group first.
 * The second form of sort takes a Comparator in addition to a List and sorts the elements with the Comparator.
 *
 * the code sorts this List, using a Comparator that expects List instances, and implements reverse size-ordering.
 * Finally, the code iterates through the sorted List, printing its elements (the anagram groups).
 */
public class ReverseSortComparator {
    public static void main(String[] args) {
        int minGroupSize = Integer.parseInt("8");

        // Read words from file and put into simulated multimap
        Map<String, List<String>> m = new HashMap<String, List<String>>();
//        Map<String, List<String>> m = new HashMap<>(); // Explicit type argument String, List<String> can be replaced with <>
        try {
            Scanner s = new Scanner(new File("/Users/abenitez/aj/hello-jworld/src/adp/dictionary.txt"));
            while (s.hasNext()) {
                String word = s.next();
                String alpha = alphabetize(word);

                List<String> l = m.get(alpha);
                if (l == null) m.put(alpha, l = new ArrayList<String>());
//                List<String> l = m.computeIfAbsent(alpha, k -> new ArrayList<>()); // m.put() replace with computeIfAbsent(). and replace with <>.
                l.add(word);
            }
        } catch (IOException e) {
            System.err.println(e);
            System.exit(1);
        }

        // Make a List of all permutation groups above size threshold
        List<List<String>> winners = new ArrayList<List<String>>(); // Replace with <> or omit explicit type.
//        List<List<String>> winners = new ArrayList<>();
        for (List<String> l : m.values())
            if (l.size() >= minGroupSize)
                winners.add(l);

        // Sort permutation groups according to size
        Collections.sort(winners, new Comparator<List<String>>() {
//        winners.sort(new Comparator<List<String>>() {  // Collections.sort replace with List.sort().
            public int compare(List<String> o1, List<String> o2) {
                return o2.size() - o1.size();
            }
        });
        // Replace with lambda.
//        winners.sort((o1, o2) -> o2.size() - o1.size());

        // Print permutation groups
        for (List<String> l : winners ) {
            System.out.println(l.size() + ": " + l);
        }
    }

    private static String alphabetize(String s) {
        char[] a = s.toCharArray();
        Arrays.sort(a);
        return new String(a);
    }
}
