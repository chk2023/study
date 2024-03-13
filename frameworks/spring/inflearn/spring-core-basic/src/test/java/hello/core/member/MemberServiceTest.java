package hello.core.member;

import hello.core.AppConfig;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class MemberServiceTest {

    //MemberService memberService = new MemberServiceImpl(memberRepository);
    MemberService memberService;

    @BeforeEach //테스트 실행 전 선실행하는 어노테이션
    public void beforeEach(){
        AppConfig appConfig = new AppConfig();
        memberService = appConfig.memberService();
    }

    @Test
    void join() {
        //given 이러한게 주어지고,
        Member member = new Member(1L, "memberA", Grade.VIP);

        //when 이렇게 했을 때,
        memberService.join(member);
        Member findMember = memberService.findMember(1L);

        //then 이렇게 된다.
        Assertions.assertThat(member).isEqualTo(findMember);

        //즉, member를 생성자를 통해 정의하고,
        //가입을 시켰을 때,
        //findMember 메서드에서 id = 1L인 데이터를 찾아 findMember에 넣어주고
        //member와 findMember가 동일한지 체크.
    }
}
