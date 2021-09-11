package adp.algorithms;

import java.util.*;

/**
 * opposite of what sort does, destroying any trace of order that may have been present in a List.
 * randomly permutes the specified list using the specified source of randomness.
 * it's fair (all permutations occur with equal likelihood, assuming an unbiased source of randomness)
 *  and fast (requiring exactly list.size()-1 swaps).
 *
 *  For example, it could be used to shuffle a List of Card objects representing a deck.
 *  Also, it's useful for generating test cases.
 */
public class Shuffle {
    public static void main(String[] args) {
        args = new String[]{"tina", "leah", "melvin", "adam"};
//        for (String a : args)
//            list.add(a);
//        list.addAll(Arrays.asList(args)); // Iteration can be replaced with bulk 'Collection.addAll' call
        List<String> list = new ArrayList<>(Arrays.asList(args)); // 'addAll()' call can be replaced with parametrized constructor call
        Collections.shuffle(list, new Random());
        System.out.println(list);
    }
}
