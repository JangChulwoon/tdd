package tdd.xunit.exception;

public class TestFailError extends RuntimeException {

    public TestFailError(String message) {
        super(message);
    }

    public TestFailError(String message, Throwable cause) {
        super(message, cause);
    }
}
