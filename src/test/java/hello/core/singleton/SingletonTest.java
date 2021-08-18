package hello.core.singleton;

import hello.core.AppConfig;
import hello.core.member.MemberService;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class SingletonTest {

    /**
     * New instance of memberService being created everytime the request is made
     * Which is not efficient (The AppConfig that I made initially, not using spring built in)
     */
    @Test
    @DisplayName("Create DI container that doesn't exist in Spring")
    void pureContainer() {
        AppConfig appConfig = new AppConfig();
        // -- Testing Factors --

        // 1. call: object created everytime called
        MemberService memberService1 = appConfig.memberService();
        MemberService memberService2 = appConfig.memberService();

        // Check that reference types are different
        System.out.println("memberService1 = " + memberService1);
        System.out.println("memberService2 = " + memberService2);

        // memberService1 != memberService2
        Assertions.assertThat(memberService1).isNotSameAs(memberService2);
    }

    @Test
    @DisplayName("Test out service created in singleton design")
    void singletonServiceTest() {
        SingletonService instance1 = SingletonService.getInstance();
        SingletonService instance2 = SingletonService.getInstance();

        // new objects are not created everytime we call for an instance
        Assertions.assertThat(instance1).isSameAs(instance2);
    }

    @Test
    @DisplayName("Singleton Container Test")
    void springContainer() {
        ApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);
        // -- Testing Factors --

        // 1. call: object created everytime called
        MemberService memberService1 = ac.getBean("memberService", MemberService.class);
        MemberService memberService2 = ac.getBean("memberService", MemberService.class);

        // Check that reference types are different
        System.out.println("memberService1 = " + memberService1);
        System.out.println("memberService2 = " + memberService2);

        // memberService1 != memberService2
        Assertions.assertThat(memberService1).isSameAs(memberService2);
    }
}
