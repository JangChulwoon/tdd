package tdd.basball;

import java.util.List;
import java.util.stream.IntStream;

class BaseBallPlayer {

    private static final int BALL_LENGTH = 4;

    // 게임은 9 번만 가능
    private int chanceCount = 9;

    GameResult play(List<Integer> numbers) {

        if (invalidNumber(numbers)) {
            throw new IllegalArgumentException(String.format("중복된 숫자 및 길이가 맞지 않습니다. : %s", numbers));
        }

        if(chanceCount < 1){
            throw new GameOverException(String.format("Game Over !! %n amount of GAME COUNT : %d", chanceCount));
        }

        List<Integer> list = UniqueNumberGenerator.generate();

        long strike = getStrikeCount(numbers, list);
        long ball = getBallCount(numbers, list);

        return GameResult.makeResult(strike, ball, --chanceCount);
    }

    // 자리가 같지 않지만, 숫자가 있으면 ball. 그냥 for 문으로 둘껄 그랫나 ..?
    private long getBallCount(List<Integer> numbers, List<Integer> list) {
        return IntStream.range(0, BALL_LENGTH)
                .filter(i -> !numbers.get(i).equals(list.get(i)))
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


    class GameOverException extends RuntimeException {

        public GameOverException() {
            super();
        }

        public GameOverException(String message) {
            super(message);
        }
    }
}
