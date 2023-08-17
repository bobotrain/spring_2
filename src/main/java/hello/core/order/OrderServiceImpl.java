package hello.core.order;

import hello.core.discount.DiscountPolicy;
import hello.core.discount.FixDiscountPolicy;
import hello.core.discount.RateDiscountPolicy;
import hello.core.member.Member;
import hello.core.member.MemberRepository;
import hello.core.member.MemoryMemberRepository;

public class OrderServiceImpl implements OrderService {

    private final MemberRepository memberRepository;


    //아래처럼 하면 dip의존 위배 -> 인터페이스만 의존하게 만들어야 한다.
    //고정할인금액
    //private final DiscountPolicy discountPolicy = new FixDiscountPolicy();
    //정률할인금액
    //private final DiscountPolicy discountPolicy = new RateDiscountPolicy();

    //인터페이스만 의존할 수 있도록 변경
    private final DiscountPolicy discountPolicy;

    //final은 반드시 생성자를 통해 할당하여야 한다.
    public OrderServiceImpl(MemberRepository memberRepository, DiscountPolicy discountPolicy) {
        this.memberRepository = memberRepository;
        this.discountPolicy = discountPolicy;
    }

    //alt + shift + enter
    @Override
    public Order createOrder(Long memberId, String itemName, int itemPrice) {
        Member member = memberRepository.findById(memberId);
        //할인정책 discountPolicy라는 객체에게 알아서일임. 너가 알아서해~
        //객체화 매우 잘 된 케이스
        int discountPrice = discountPolicy.discount(member, itemPrice);

        return new Order(memberId, itemName, itemPrice, discountPrice);
    }

    //테스트 용도
    public MemberRepository getMemberRepository() {
        return memberRepository;
    }

}
