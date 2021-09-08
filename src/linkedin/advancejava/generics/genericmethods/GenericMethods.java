package linkedin.advancejava.generics.genericmethods;

import java.util.ArrayList;
import java.util.List;

/**
 * Generic Methods - are methods tthat allow you to create a new type parameter just for that method.
 * This is useful if you are writing a method but wnat to be flexible about about the type of objects you can pass in.
 *
 */
public class GenericMethods {
    static Character[] charArray = {'h','e','l','l','o'};
    static Integer[] intArray = {1,2,3,4,5};
    static Boolean[] boolArray = {true, false, true};

    /**
     *
     * THE PROBLEM: using this approach - using objects means that I lose type safety.
     * Iterates through all of the objects in an array and adds them to a list.
     * I want to be able to pass any of these arrays and lists of any types into the method,
     * even though they have different types.
     * Making the arguments of the array to list method object types.
     * NOTE: Object is a parent type of all other object types.
     * @param array
     * @param list
     * @return
     */
    static List arrayToList(Object[] array, List<Object> list) {
        for (Object obj : array) {
            list.add(obj);
        }
        return list;
    }

    /**
     * THE SOLUTION: Make tthe array to list method a generic method.
     * 1 - create a new ttype variable, which I will call T
     * 2 - Put it in an angle brackets, right before the return type of the method
     * <p>
     * This type variable only has local scope, which means I can only use it inside this particular method.
     * I can use it in the method signature, and inside the body of the method, but not outside the method.
     * So we can specify that the return of the array to list method is a list of my new type T.
     * <p>
     * 3 - replace the object type with type T, Inside method signature (method name and the parameter list)
     * 4 - replace the object type with type T, Inside the for-loop in the method.
     * Because T is a generic type, it doesn't matter what I use as long as it is the same type every time I use it.
     * The type of the array list can also be a super type of the element type of the array.
     * @param array
     * @param list
     * @return
     */
    static <T> List<T> arrayToListCorrect(T[] array, List<T> list) {
        for (T obj : array) {
            list.add(obj);
        }
        return list;
    }

    public static void main(String[] args) {
        List<Character> charList = arrayToList(charArray, new ArrayList<>());
        List<Boolean> boolList = arrayToList(boolArray, new ArrayList<>());
        List<Integer> intList = arrayToList(intArray, new ArrayList<>());
        // Then try to printline list.
        System.out.println(intList.get(0)); // ERROR => no compile errors, but runtime error - throw ClassCastException

        // Change type of intList to String.
        List<String> intList1 = arrayToList(intArray, new ArrayList<>()); // ERROR => no compile errors, dangerous silently error in runtime.
//        List<String> intList2 = arrayToListCorrect(intArray, new ArrayList<>()); // SAFER ERROR => compile errors, saying -
        /*
        Required type:List<String>
        Provided:List<Integer>
        no instance(s) of type variable(s) exist so that Integer conforms to String inference variable T has incompatible bounds: equality constraints: String lower bounds: Integer
         */

        // But put back Integer instead of String.
        List<Integer> intList3 = arrayToListCorrect(intArray, new ArrayList<>()); // WORKS w/o any errors.
    }
}
