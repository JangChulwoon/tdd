package tdd.basball;

import java.util.List;
import java.util.Random;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

class UniqueNumberGenerator {

    private static final int BOUND = 10;
    private static final Random random = new Random();

    static List<Integer> generate() {
        return Stream.generate(() -> random.nextInt(BOUND) + 1)
                .distinct()
                .limit(4)
                .collect(toList());
    }
}
