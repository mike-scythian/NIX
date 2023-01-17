package nix.lessons;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Iterator;

public class RangeWithStepTest {
    private static RangeWithStep<Long> rangeWithStepLong;
    private static RangeWithStep<Float> rangeWithStepFloat;
    private static Iterator<Long> longIterator;
    private static Iterator<Float> floatIterator;


    @BeforeAll
    static void init() {
        rangeWithStepLong = new RangeWithStep<>(0L, 100L, 1L);
        rangeWithStepFloat = new RangeWithStep<>(0.0f, 50.0f, 0.5f);
        longIterator = rangeWithStepLong.iterator();
        floatIterator = rangeWithStepFloat.iterator();
    }

    @Test
    void shouldRangeWithStepIsIterableInForEach() {
        int counter = 0;
        long[] excepted = new long[rangeWithStepLong.getEnd().intValue()];

        for (int i = 0; i < excepted.length; i++)
            excepted[i] = i;

        for (Long el : rangeWithStepLong) {
            assertEquals(excepted[counter], el);
            counter++;
        }
        assertEquals(rangeWithStepLong.getEnd().intValue(), counter);
    }

    @Test
    void shouldRangeIsIterableInWhileLoop() {
        int counter = 0;
        float[] excepted = new float[rangeWithStepFloat.getEnd().intValue() * 2];

        for (int i = 0; i < excepted.length; i++)
            excepted[i] = i * 0.5f;

        while (floatIterator.hasNext()) {
            assertEquals(excepted[counter], floatIterator.next());
            counter++;
        }
        assertEquals(rangeWithStepFloat.getEnd().intValue() * 2, counter);
    }

}
