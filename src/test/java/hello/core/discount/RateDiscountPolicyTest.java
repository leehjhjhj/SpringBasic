package hello.core.discount;

import hello.core.domain.member.Grade;
import hello.core.domain.member.Member;
import org.assertj.core.api.Assertions;
import org.junit.Test;

import org.junit.jupiter.api.DisplayName;

import static org.assertj.core.api.Assertions.*;
import static org.junit.Assert.*;

public class RateDiscountPolicyTest {
    RateDiscountPolicy discountPolicy = new RateDiscountPolicy();

    @Test
    @DisplayName("VIP는 10% 할인이 되어야 한다")
    public void vip_o() {
        Member member = new Member(1L, "memberA", Grade.VIP);
        int discount = discountPolicy.discount(member, 10000);
        assertThat(discount).isEqualTo(1000);

    }
    @Test
    @DisplayName("VIP는 10% 할인이 되어야 한다")
    public void vip_x() {
        Member member = new Member(1L, "memberB", Grade.BASIC);
        int discount = discountPolicy.discount(member, 10000);
        assertThat(discount).isEqualTo(0);

    }
}