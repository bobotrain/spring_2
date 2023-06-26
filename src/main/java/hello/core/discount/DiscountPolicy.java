package hello.core.discount;

import hello.core.member.Member;

public interface DiscountPolicy {

    //f2 오류난 곳으로 바로 이동
    //@return 할인 대상 금액
    int discount(Member member, int price);
}
