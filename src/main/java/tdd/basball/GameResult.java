package tdd.basball;

class GameResult {
    private static final int NUMBER_COUNT = 4;
    private long chanceCount;
    private long ballCount;
    private long strikeCount;

    private boolean isSuccess;

    static GameResult init(){
        GameResult result = new GameResult();
        result.chanceCount = 4;
        return result;
    }

    public GameResult makeResult(long matchCount){
        if(this.chanceCount == 0) {
            throw new RuntimeException("Don't have chance !!");
        }

        this.strikeCount = matchCount;
        this.ballCount = NUMBER_COUNT - matchCount;
        this.chanceCount --;

        return new GameResult(chanceCount, ballCount, strikeCount, strikeCount == 4);
    }
    private GameResult() {
    }

    private GameResult(long chanceCount, long ballCount, long strikeCount, boolean isSuccess) {
        this.chanceCount = chanceCount;
        this.ballCount = ballCount;
        this.strikeCount = strikeCount;
        this.isSuccess = isSuccess;
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
