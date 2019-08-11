package tdd.xunit.testcase;

import tdd.xunit.TestCase;

public class FailTestCase extends TestCase {

    public void testFail() {
        throw new RuntimeException();
    }
}
