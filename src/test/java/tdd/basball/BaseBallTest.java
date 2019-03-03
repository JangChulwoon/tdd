package tdd.basball;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

import static org.hamcrest.CoreMatchers.is;
import static org.powermock.api.mockito.PowerMockito.when;

@RunWith(PowerMockRunner.class)
@PrepareForTest(UniqueNumberGenerator.class)
public class BaseBallTest {
    /*
    AssertJ 도 써보고 싶은데 ..

    4개의 숫자를 받아서, 4번 안에 일치하면 ok
     ~1. 난수 생성기 (중복 x )~
     ~2. 숫자가 일치한 수만큼 count 를 반환~
     ~3  성공 여부 / count 수 를 반환해야한다.~
     ~0. 위치가 틀리면?~

     */

    @Test
    public void shouldSucceedInGame() {
        PowerMockito.mockStatic(UniqueNumberGenerator.class);
        when(UniqueNumberGenerator.generate()).thenReturn(Arrays.asList(4, 3, 2, 0));
        BaseBallPlayer baseBallPlayer = new BaseBallPlayer();

        GameResult gameResult = baseBallPlayer.play(Arrays.asList(0,2,3,5));

        Assert.assertThat(gameResult.getStrikeCount(), is(0L));
        Assert.assertThat(gameResult.getBallCount(), is(3L));
    }


    // 예외 상황에 대한 TC
    @Test(expected = IllegalArgumentException.class)
    public void shouldThrowException() {
        BaseBallPlayer baseBallPlayer = new BaseBallPlayer();

        baseBallPlayer.play(Arrays.asList(0,3,3,4,4,1));
    }

    @Test(expected = IllegalArgumentException.class)
    public void shouldThrowIllegalExceptionForOverLength() {
        BaseBallPlayer baseBallPlayer = new BaseBallPlayer();

        baseBallPlayer.play(Arrays.asList(0,2,3,5,6));
    }


    @Test(expected = IllegalArgumentException.class)
    public void shouldThrowExceptionForDuplicatedParameter() {
        BaseBallPlayer baseBallPlayer = new BaseBallPlayer();

        baseBallPlayer.play(Arrays.asList(0,3,3,4));
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
