package tdd.basball;

import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;

import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class BaseBallTest {

    /*
    4개의 숫자를 받아서, 4번 안에 일치하면 ok
     1. 난수 생성기 (중복 x )
     */

    @Test
    public void shouldSucceedInGame() {
        BaseBallPlayer baseBallPlayer = new BaseBallPlayer();

        boolean isSuccess = baseBallPlayer.play(1, 2, 3, 4);

        Assert.assertTrue(isSuccess);
    }

    @Test
    //@Ignore
    public void shouldGenerateRandomList() {
        // (확률의 문제니까) random 수를 완벽히 test 할 수는 없음.
        //  10,000 번만 돌리자
        IntStream.iterate(0, i -> i + 1)
                .limit(10000)
                .forEach(i -> {
                    List list = UniqueNumberGenerator.generate();
                    Assert.assertTrue(isDistinctNumber(list));
                });
    }

    private boolean isDistinctNumber(List list) {
        return list.stream().distinct().count() == 4L;
    }
}
