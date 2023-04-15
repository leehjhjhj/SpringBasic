package hello.core.order;

import hello.core.discount.FixDiscountPolicy;
import hello.core.domain.member.Grade;
import hello.core.domain.member.Member;
import hello.core.domain.member.MemberRepository;
import hello.core.domain.member.MemoryMemberRepository;
import org.assertj.core.api.Assertions;
import org.junit.Test;

import static org.junit.Assert.*;

public class OrderServiceImplTest {
    @Test
    public void createOrder() {
        MemberRepository memberRepository = new MemoryMemberRepository();
        memberRepository.save(new Member(1L, "memberA", Grade.VIP));
        OrderServiceImpl orderService = new OrderServiceImpl(new MemoryMemberRepository(), new FixDiscountPolicy());
        Order order = orderService.createOrder(1L, "itemA", 10000);
        Assertions.assertThat(order.getDiscountPrice()).isEqualTo(1000);
    }
}