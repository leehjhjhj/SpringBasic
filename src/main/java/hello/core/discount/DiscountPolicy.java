package hello.core.discount;

import hello.core.domain.member.Member;

public interface DiscountPolicy {
    int discount(Member member, int price);
}
