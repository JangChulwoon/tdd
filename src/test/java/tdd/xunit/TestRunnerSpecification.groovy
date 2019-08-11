package tdd.xunit

import spock.lang.Specification

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

}
