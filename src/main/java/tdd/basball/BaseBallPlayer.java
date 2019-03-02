package tdd.basball;

import java.util.List;

class BaseBallPlayer {
    GameResult play(int ...numbers) {
        List<Integer> randomNumbers = UniqueNumberGenerator.generate();
        int count = 0;
        for(int number : numbers){
            if(randomNumbers.contains(number)){
                count ++;
            }
        }
        return new GameResult(3, 4 - count, count, count == 4);
    }

}
