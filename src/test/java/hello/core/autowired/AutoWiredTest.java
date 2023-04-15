package hello.core.autowired;

import hello.core.domain.member.Member;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.lang.Nullable;

import java.util.Optional;

public class AutoWiredTest {

    @Test
    public void AutoWiredOption() {
        ApplicationContext ac = new AnnotationConfigApplicationContext(TestBean.class);

    }

    static class TestBean {
        //원래 없는 빈으로 테스₩
        @Autowired(required = false)
        public void setNOBean1(Member noBean1) {
            System.out.println("noBean1 = " + noBean1);
        }

        // 호출읜 되는데 Null로 들어온다.
        @Autowired
        public void setNOBean2(@Nullable Member noBean2) {
            System.out.println("noBean2 = " + noBean2);
        }

        //빈이 없으면 Optional.empty로 들어온다.
        @Autowired
        public void setNOBean3(Optional<Member> noBean3) {
            System.out.println("noBean3 = " + noBean3);
        }
    }
}
//noBean2 = null
//noBean3 = Optional.empty 로 뜬다.