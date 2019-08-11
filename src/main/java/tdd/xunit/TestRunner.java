package tdd.xunit;


import lombok.Getter;
import tdd.xunit.exception.TestFailError;

import java.lang.reflect.Method;

@Getter
public class TestRunner {
    public static final String SETUP = "setup";
    public static final String TEARDOWN = "teardown";
    private Class<?> targetClass;
    private int runCount = 0;
    private boolean wasRun = false;

    public TestRunner(Class<? extends TestCase> clazz) {
        this.targetClass = clazz;

    }

    public void run() {
        try {
            Object targetObject = targetClass.newInstance();
            runSetup(targetObject);
            runTestMethod(targetObject);
            runTeardown(targetObject);
        } catch (ReflectiveOperationException e) {
            fail("fail reflection", e);
        } finally {
            wasRun = true;
        }
    }

    private void fail(String message, Throwable e) {
        throw new TestFailError(message, e);
    }


    private void runSetup(Object targetObject) throws ReflectiveOperationException {
        Method[] methods = targetClass.getMethods();
        for (Method method : methods) {
            String methodName = method.getName();
            if (SETUP.equals(methodName)) {
                method.invoke(targetObject);
                return;
            }
        }
    }

    private void runTestMethod(Object targetObject) throws ReflectiveOperationException {
        Method[] methods = targetClass.getDeclaredMethods();
        for (Method method : methods) {
            String methodName = method.getName();
            if (methodName.startsWith("test")) {
                method.invoke(targetObject);
                runCount++;
            }
        }
    }

    private void runTeardown(Object targetObject) throws ReflectiveOperationException {
        Method[] methods = targetClass.getMethods();
        for (Method method : methods) {
            String methodName = method.getName();
            if (TEARDOWN.equals(methodName)) {
                method.invoke(targetObject);
                return;
            }
        }
    }


}
