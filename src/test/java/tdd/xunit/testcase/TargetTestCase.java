package tdd.xunit.testcase;

import tdd.xunit.TestCase;

public class TargetTestCase extends TestCase {

    @Override
    public void setup() {
        System.out.println("setup");
    }

    @Override
    public void teardown() {
        System.out.println("teardown");
    }

    public void testPrint() {
        System.out.println("!");
    }


}
