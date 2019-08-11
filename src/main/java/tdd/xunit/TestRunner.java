package tdd.xunit;


import lombok.Getter;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/*
 고민거리
 Runner 의 exception 과 testcase 의 Exception 을 어떻게 나눌 것인가 ?
 */
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
            wasRun = true;
        } catch (ReflectiveOperationException e) {
            wasRun = false;
        }
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

    private void runTestMethod(Object targetObject) {
        Method[] methods = targetClass.getDeclaredMethods();
        for (Method method : methods) {
            String methodName = method.getName();
            if (methodName.startsWith("test")) {
                try {
                    method.invoke(targetObject);
                } catch (IllegalAccessException e) {
                    e.printStackTrace(); // todo log 로 변경
                } catch (InvocationTargetException e) {
                    e.printStackTrace();
                }
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
