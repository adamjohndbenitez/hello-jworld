package ocp11.reviewtopics.review2classes;

import java.util.function.Function;

public class AddThree implements Function<Long, Long> {
    @Override
    public Long apply(Long aLong) {
        return aLong + 3;
    }
}
