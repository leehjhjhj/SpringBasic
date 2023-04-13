package singleton;

import hello.core.AppConfig;
import hello.core.domain.member.MemberService;
import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.junit.jupiter.api.DisplayName;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import static org.assertj.core.api.Assertions.*;

public class SingleTonTest {
    @Test
    @DisplayName("스프링 없는 순수한 DI 컨테이너")
    public void pureContainer() {
        AppConfig appConfig = new AppConfig();
        //1 호출할 때 마다 객체 생성
        MemberService memberService1 = appConfig.memberService();
        MemberService memberService2 = appConfig.memberService();
        //촘조 값 다른 것을 확인
        System.out.println("memberService1 = " + memberService1);
        System.out.println("memberService2 = " + memberService2);

        // 멤버 서비스1 은 멤버 서비스 2와 다르다.
        assertThat(memberService1).isNotEqualTo(memberService2);
    }

    @Test // 같은 객체 인스턴스 반환
    @DisplayName("싱글톤 패턴을 적용한 객체 사용")
    public void singletonServiceTest() {
        SingletonService getInstance1 = SingletonService.getInstance();
        SingletonService getInstance2 = SingletonService.getInstance();
        System.out.println("getInstance1 = " + getInstance1);
        System.out.println("getInstance2 = " + getInstance2);

        assertThat(getInstance1).isSameAs(getInstance2);
    }

    @Test
    @DisplayName("스프링 컨테이너와 싱글톤")
    public void springContainer() {
        //AppConfig appConfig = new AppConfig();
        AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);
        MemberService memberService1 = ac.getBean("memberService", MemberService.class);
        MemberService memberService2 = ac.getBean("memberService", MemberService.class);

        //촘조 값 다른 것을 확인
        System.out.println("memberService1 = " + memberService1);
        System.out.println("memberService2 = " + memberService2);

        // 멤버 서비스1 은 멤버 서비스 2와 다르다.
        assertThat(memberService1).isSameAs(memberService2);
    }
}
