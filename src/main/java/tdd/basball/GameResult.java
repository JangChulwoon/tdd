package tdd.basball;

class GameResult {
    private int chanceCount;
    private int ballCount;
    private int strikeCount;

    private boolean isSuccess;

    public GameResult(int chanceCount, int ballCount, int strikeCount, boolean isSuccess) {
        this.chanceCount = chanceCount;
        this.ballCount = ballCount;
        this.strikeCount = strikeCount;
        this.isSuccess = isSuccess;
    }

    public int getChanceCount() {
        return chanceCount;
    }

    public int getBallCount() {
        return ballCount;
    }

    public int getStrikeCount() {
        return strikeCount;
    }

    public boolean isSuccess() {
        return isSuccess;
    }
}
