package tdd.basball;

import java.util.List;

class BaseBallPlayer {
    // todo 중복 체크
    int play(int ...numbers) {
        List<Integer> randomNumbers = UniqueNumberGenerator.generate();
        int count = 0;
        for(int number : numbers){
            if(randomNumbers.contains(number)){
                count ++;
            }
        }
        return count;
    }

}
