package hello.core;
import hello.core.member.Grade;
import hello.core.member.Member;
import hello.core.member.MemberService;
import hello.core.member.MemberServiceImpl;

public class MemberApp {

    //psvm + enter 단축키
    public static void main(String[] args) {

        //Appconfig를 이용하여 개발 -> appconfig에서 memberserviceImpl을 받는다. -> 인터페이스에만 의존
        AppConfig appConfig = new AppConfig();
        //MemberService memberService = new MemberServiceImpl();
        MemberService memberService = appConfig.memberService();


        //ctrl+alt+v
        Member member = new Member(1L, "memberA", Grade.VIP);
        memberService.join(member);

        //동일성 검사
        Member findMember = memberService.findMember(1L);
        //sout+tab
        System.out.println("new member = " + member.getName());
        System.out.println("find Member = " + findMember.getName());



    }
}
