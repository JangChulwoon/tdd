package tdd.basball;

import java.util.List;

class BaseBallPlayer {

    public static final int BALL_LENGTH = 4;

    GameResult play(List numbers) {

        if (invalidNumber(numbers)) {
            throw new IllegalArgumentException(String.format("중복된 숫자 및 길이가 맞지 않습니다. : %s", numbers));
        }

        List<Integer> list = UniqueNumberGenerator.generate();
        int strike = 0;
        int ball = 0;

        for (int i = 0; i < numbers.size(); ++i) {
            if (numbers.get(i) == list.get(i)) {
                strike++;
                continue;
            }

            if (list.contains(numbers.get(i))) {
                ball++;
            }
        }

        return GameResult.makeResult(strike, ball);
    }

    private boolean invalidNumber(List numbers) {
        return numbers.stream().distinct().count() != BALL_LENGTH || numbers.size() != BALL_LENGTH;
    }
}
