package hello.core;

import hello.core.discount.DiscountPolicy;
import hello.core.discount.FixDiscountPolicy;
import hello.core.discount.RateDiscountPolicy;
import hello.core.member.MemberRepository;
import hello.core.member.MemberService;
import hello.core.member.MemberServiceImpl;
import hello.core.member.MemoryMemberRepository;
import hello.core.order.OrderService;
import hello.core.order.OrderServiceImpl;


//애플리케이션 환경구성 다 여기서함 -> 애플리케이션의 실제 동작에 필요한 구현객체를 모두 생성한다.
//repository 적절하게 세팅하는것들.

//appConfig는 생성한 객체 인스턴스의참조(레퍼런스)를 생성자를 통해서 주입(연결) 해준다.
//ex
//MemberServiceImpl -> MemoryMemberRepository를 통해서 주입


//핵심정리 : MemberServiceImpl의 생성자를 통해서 어떤 구현객체를 주입할지는 오직 외부(AppConfig)에서 결정된다는 뜻.
//MemberServiceImpl은 이제부터 의존관계에 대한 고민은 외부에 맡기고 실행에만 집중하면 된다.
public class AppConfig {

   private MemberRepository memberRepository() {
        return new MemoryMemberRepository();
    }

    public MemberService memberService() {
        return new MemberServiceImpl(memberRepository());
    }

    public DiscountPolicy discountPolicy() {

       //여기서 간단하게 정률 할인으로 할것이냐, 고정 할인으로 할것이냐 선수교체 간단히 할 수 있음 -> 객체화 good!

       //return new FixDiscountPolicy();
       return new RateDiscountPolicy();

    }

    public OrderService orderService() {
        return new OrderServiceImpl(memberRepository(), discountPolicy());
    }



}
