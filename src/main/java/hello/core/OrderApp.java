package hello.core;

import hello.core.member.Grade;
import hello.core.member.Member;
import hello.core.member.MemberService;
import hello.core.member.MemberServiceImpl;
import hello.core.order.Order;
import hello.core.order.OrderService;
import hello.core.order.OrderServiceImpl;

public class OrderApp {
    //psvm
    public static void main(String[] args) {

        //appConfig 통해 개발
        AppConfig appConfig = new AppConfig();
        MemberService memberService = appConfig.memberService();
        OrderService orderService = appConfig.orderService();

        //데이터 작성.
        Long memberId = 1L;
        Member member = new Member(memberId, "memberA", Grade.VIP);
        //join으로 db에 넣어놓음
        memberService.join(member);

        //orderService 객체 생성
        Order order = orderService.createOrder(memberId,"itemA", 10000);

        //이미 order에서 toString() 박아넣었기 때문에 그냥 출력해도 문제없음 ~
        System.out.println("order = "+ order);
        //할인정책 적용 -> 9000 출력
        System.out.println("order.calculatePrice = " + order.calculatePrice());
    }
}
