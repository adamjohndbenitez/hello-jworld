package ocp.annotations;

import java.util.Arrays;
import java.util.List;

/**
 * Example Class
 * @author Adam John Benitez
 * @version 1.0.*
 */
public class Some {
    @X
    public void a(){}
    @Y
    public void b(){}

    @SafeVarargs
    public final void some (List<String>... values) { // the ... is a var-arg
        // Object[] objectArray = values;
        // objectArray[0] = Arrays.asList(1,2,3);
        for (List<String> value: values) {
            value.stream().forEach(v -> System.out.print(v));
            System.out.println("---");
        }
    }
    /* Var-args and Heap Pollutions
        Incorret use of var-args with generic can lead to heap pollution.
        - var-arg is essentially an array, so it can be assigned to an arrray of objects (array are covariant).
        - arrray of objects allow adding of elements that arer not of a type expected by a generic declaration.
        - ClassCastException may occur when trying to get elements from the collection.
        Annotation @SafeVarargs supprersses heap-pollution warning when using var-args.
        - ensure that your code does not product actual heap poluttion.
        - annotated method must be private orr final to maintain type safety guarantee */

    @SuppressWarnings("unchecked")
    public static void main(String[] args) {
        Some s = new Some();
        s.some(Arrays.asList("A", "B", "C"),Arrays.asList("X","Y","Z"));
    }
}
