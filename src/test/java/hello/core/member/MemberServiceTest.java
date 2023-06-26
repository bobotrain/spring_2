package hello.core.member;

import org.assertj.core.api.Assertions;
import org.junit.Test;

public class MemberServiceTest {

    MemberService memberService = new MemberServiceImpl();

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
