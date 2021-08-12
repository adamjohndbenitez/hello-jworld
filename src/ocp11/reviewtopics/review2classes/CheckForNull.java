package ocp11.reviewtopics.review2classes;

import java.util.function.Predicate;

public class CheckForNull implements Predicate {
    @Override
    public boolean test(Object o) {
        return o != null;
    }
}
