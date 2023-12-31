package lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertThrows;

class LottoTest {
    @DisplayName("로또 번호의 개수가 6개가 넘어가면 예외가 발생한다.")
    @Test
    void createLottoByOverSize() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 6, 7)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 번호에 중복된 숫자가 있으면 예외가 발생한다.")
    @Test
    void createLottoByDuplicatedNumber() {
        // TODO: 이 테스트가 통과할 수 있게 구현 코드 작성
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 5)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void lottoNumberValidate() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Lotto(Arrays.asList(1, 2, 3, 4, 5));  // 로또 번호가 6개 미만인 경우
        });
        assertThrows(IllegalArgumentException.class, () -> {
            new Lotto(Arrays.asList(1, 2, 3, 4, 5, 5));  // 로또 번호가 중복되는 경우
        });
        assertThrows(IllegalArgumentException.class, () -> {
            new Lotto(Arrays.asList(1, 2, 3, 4, 5, 46));  // 로또 번호가 1~45 범위를 벗어나는 경우
        });
    }
}
