package nix.lessons;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.*;

class NumberUtilsTest {

    private static List<Integer> numberList;
    private static NumberUtils numUtils;

    @BeforeAll
    static void init() {
        numberList = List.of(0, 1, 2, 3, 4, 5, 6, 7, -8, -9);
        numUtils = new NumberUtils();
    }

    @Test
    void shouldGetSum() {

        assertThat(numUtils.getSum(numberList))
                .isNotNull()
                .isEqualTo(11);
    }

    @Test
    void shouldGetDoubleOddElementsList() {

        assertThat(numUtils.multiplyOddNumbers(numberList))
                .isNotEmpty()
                .isEqualTo(List.of(0, 4, 8, 12, -16));
    }

}
