package tdd.basball;

import java.util.Arrays;

class BaseBallPlayer {
    GameResult play(int... numbers) {
        GameResult gameResult = GameResult.init();
        long matchCount = Arrays.stream(numbers)
                .filter(UniqueNumberGenerator.generate()::contains)
                .count();
        return gameResult.makeResult(matchCount);
    }

}
