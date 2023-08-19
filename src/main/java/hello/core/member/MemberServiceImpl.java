package hello.core.member;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class MemberServiceImpl implements MemberService{

    private final MemberRepository memberRepository;

    //자동의존관계주입(Autowired) = 마치 ac.getBean(MemberRepository memberRepository) 와 같다.
    @Autowired
    //생성자 -> 여기서는 추상화에만 의존하는 껍데기만 설정 (just 생성자 주입) -> config에서 자세히 설정할 것.
    public MemberServiceImpl(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    @Override
    public void join(Member member) {
        memberRepository.save(member);
    }

    @Override
    public Member findMember(Long memberId) {
        return memberRepository.findById(memberId);
    }

    // 테스트 용도
    public MemberRepository getMemberRepository() {
        return memberRepository;
    }
}
