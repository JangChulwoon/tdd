package tdd.basball;

class GameResult {
    //private static final int GAME_COUNT = 9;
    private long chanceCount;
    private long ballCount;
    private long strikeCount;

    private boolean isSuccess;

    static GameResult init(){
        GameResult result = new GameResult();
        result.chanceCount = 4;
        return result;
    }

    public static GameResult makeResult(long strikeCount, long ballCount){
        GameResult result = new GameResult();

       /* TODO chance count 를 어떻게 구현할래 ?
        if(result.chanceCount == 0) {
            throw new RuntimeException("Don't have chance !!");
        }
*/
        result.strikeCount = strikeCount;
        result.ballCount = ballCount;
        result.chanceCount --;

        return result;
    }
    private GameResult() {
    }

    public long getChanceCount() {
        return chanceCount;
    }

    public long getBallCount() {
        return ballCount;
    }

    public long getStrikeCount() {
        return strikeCount;
    }

    public boolean isSuccess() {
        return isSuccess;
    }
}
