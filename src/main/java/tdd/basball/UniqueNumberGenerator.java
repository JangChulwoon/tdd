package tdd.basball;

import java.util.List;
import java.util.Random;

import static java.util.stream.Collectors.toList;

class UniqueNumberGenerator {

    private static final int ORIGIN = 1;
    private static final int BOUND = 10;
    private static final Random random = new Random();

    private UniqueNumberGenerator() {
    }

    static List<Integer> generate() {
        return random.ints(ORIGIN,BOUND)
                .distinct()
                .limit(4)
                .boxed()
                .collect(toList());
    }
}
