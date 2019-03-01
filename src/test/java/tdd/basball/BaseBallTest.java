package tdd.basball;

import org.junit.Assert;
import org.junit.Test;

public class BaseBallTest {

    /*
    4개의 숫자를 받아서, 4번 안에 일치하면 ok
     */

    @Test
    public void main(){
        BaseBallPlayer baseBallPlayer = new BaseBallPlayer();

        boolean isSuccess = baseBallPlayer.play(1,2,3,4);

        Assert.assertTrue(isSuccess);

    }
}
