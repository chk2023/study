package hello.core.discount;

import hello.core.member.Grade;
import hello.core.member.Member;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class RateDiscountPolicyTest {

    //RateDiscountPolicy가 10% 할인이 되는 지 테스트. 즉, 만든 메서드가 잘 작동하는 지 테스트.

    RateDiscountPolicy discountPolicy = new RateDiscountPolicy();

    @Test
    @DisplayName("VIP는 10% 할인이 적용되어야 한다.")
    void vip_o() {
        //given
        Member member = new Member(1L, "memberVIP", Grade.VIP); //위에 생성한 discountpolicy 객체가 작동하는 지 보기 위해 멤버 생성.
        //when
        int discount = discountPolicy.discount(member, 10000); //생성한 멤버를 대입.
        //then
        assertThat(discount).isEqualTo(1000); //10000원일 때 할인금액이 1000원인가?
    }

    @Test
    //실패 테스트도 만들어야 한다.
    @DisplayName("VIP가 아니면 할인이 적용되지 않아야 한다.")
    void vip_x() {
        //given
        Member member = new Member(2L, "memberBASIC", Grade.BASIC);
        //when
        int discount = discountPolicy.discount(member, 10000);
        //then
        assertThat(discount).isEqualTo(0);
    }
}
