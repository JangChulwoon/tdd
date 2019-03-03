package tdd.basball;

import java.util.List;
import java.util.stream.IntStream;

class BaseBallPlayer {

    public static final int BALL_LENGTH = 4;

    GameResult play(List<Integer> numbers) {

        if (invalidNumber(numbers)) {
            throw new IllegalArgumentException(String.format("중복된 숫자 및 길이가 맞지 않습니다. : %s", numbers));
        }
        List<Integer> list = UniqueNumberGenerator.generate();

        long strike = getStrikeCount(numbers, list);
        long ball = getBallCount(numbers, list);

        return GameResult.makeResult(strike, ball);
    }

    // 자리가 같지 않지만, 숫자가 있으면 ball
    private long getBallCount(List<Integer> numbers, List<Integer> list) {
        return IntStream.range(0, BALL_LENGTH)
                .filter(i -> numbers.get(i) != list.get(i))
                .map(numbers::get)
                .filter(list::contains)
                .count();
    }

    private long getStrikeCount(final List<Integer> numbers, final List<Integer> list) {
        return IntStream.range(0, BALL_LENGTH)
                .filter(i -> numbers.get(i).equals(list.get(i)))
                .count();
    }

    private boolean invalidNumber(List numbers) {
        return numbers.stream().distinct().count() != BALL_LENGTH || numbers.size() != BALL_LENGTH;
    }
}
