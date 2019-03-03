package tdd.basball;

import java.util.List;

class BaseBallPlayer {
    GameResult play(int... numbers) {
        List<Integer> list =  UniqueNumberGenerator.generate();
        int strike = 0;
        int ball = 0;

        // todo 같은 숫자를 넣을 수 있나 ?
        for(int i = 0; i < numbers.length; ++i){
            if(numbers[i] == list.get(i)){
                strike ++;
                continue;
            }

            if(list.contains(numbers[i])){
                ball ++;
            }
        }

        return GameResult.makeResult(strike,ball);
    }
}
