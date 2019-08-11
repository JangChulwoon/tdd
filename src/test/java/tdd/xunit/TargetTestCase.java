package tdd.xunit;

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
