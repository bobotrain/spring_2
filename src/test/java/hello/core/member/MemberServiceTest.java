package hello.core.member;

import hello.core.AppConfig;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class MemberServiceTest {

    MemberService memberService;

    @BeforeEach //test실행전에 반드시 먼저 실행되는 어노테이션
    public void beforeEach() {
        AppConfig appConfig = new AppConfig();
        memberService = appConfig.memberService();
    }


    @Test
    public void join() {
        //given
        Member member = new Member(1L,"memberA", Grade.VIP);

        //when
        memberService.join(member);
        Member findMember = memberService.findMember(1L);

        //then  -> junit assertion사용 -> member가 findemember와 같을 시, true 반환 -> testcode 통과
        Assertions.assertThat(member).isEqualTo(findMember);
    }
}
