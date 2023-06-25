package hello.core;
import hello.core.member.Grade;
import hello.core.member.Member;
import hello.core.member.MemberService;
import hello.core.member.MemberServiceImpl;

public class MemberApp {

    //psvm + enter 단축키
    public static void main(String[] args) {
        MemberService memberService = new MemberServiceImpl();
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
