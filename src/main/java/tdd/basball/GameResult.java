package tdd.basball;

class GameResult {
    private long chanceCount;
    private long ballCount;
    private long strikeCount;


    public static GameResult makeResult(long strikeCount, long ballCount, int chanceCount) {
        GameResult result = new GameResult();

        result.strikeCount = strikeCount;
        result.ballCount = ballCount;
        result.chanceCount = chanceCount;

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

}
