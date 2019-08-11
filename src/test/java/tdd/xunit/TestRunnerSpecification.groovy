package tdd.xunit

import spock.lang.Specification
import tdd.xunit.testcase.FailTestCase
import tdd.xunit.testcase.TargetTestCase

class TestRunnerSpecification extends Specification {

/*
   // 초기 잘못된 설계
   def "테스트가 실행되었는지 확인한다."(){

        def testRunner = new TestRunner(Echo.class,"methodName","hello")

        when:
        testRunner.run()

        then:
        testRunner.wasRun
    }*/


    def "테스트가 메서드가 실행되어야한다."() {

        def testRunner = new TestRunner(TargetTestCase.class)

        when:
        testRunner.run()

        then:
        testRunner.wasRun
        testRunner.runCount == 1

    }

    def "테스트 실패"() {

        def testRunner = new TestRunner(FailTestCase.class)

        when:
        testRunner.run()

        then:
        !testRunner.wasRun
        testRunner.runCount == 0

    }

}
