package hello.core.member;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class MemberServiceImpl implements MemberService{

    // private final MemberRepository memberRepository = new MemoryMemberRepository();
    // MemberRepository 인터페이스 타입의 참조변수에 구현 클래스의 객체를 대입.

    private final MemberRepository memberRepository;

    @Autowired
    public MemberServiceImpl(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    @Override
    public void join(Member member) {
        memberRepository.save(member); //다형성으로 인해 MemoryMemberRepository 클래스의 오버라이드된 save메서드가 호출된다.
    }

    @Override
    public Member findMember(Long memberId) {
        return memberRepository.findById(memberId);
    }

    //테스트 용도
    public MemberRepository getMemberRepository() {
        return memberRepository;
    }
}
