package nix.lessons;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Iterator;

public class RangeTest {

    private static Range<Integer> rangeInt;
    private static Range<Double> rangeDouble;
    private static Iterator<Integer> intIterator;
    private static Iterator<Double> doubleIterator;


    @BeforeAll
    static void init() {
        rangeInt = new Range<>(0, 100);
        rangeDouble = new Range<>(0.0, 50.0);
        intIterator = rangeInt.iterator();
        doubleIterator = rangeDouble.iterator();
    }

    @Test
    void shouldRangeIsIterableInForEach() {
        int counter = 0;
        int[] excepted = new int[rangeInt.getEnd().intValue()];

        for (int i = 0; i < excepted.length; i++)
            excepted[i] = i;

        for (Integer el : rangeInt) {
            assertEquals(excepted[counter], el);
            counter++;
        }
        assertEquals(rangeInt.getEnd().intValue(), counter);
    }

    @Test
    void shouldRangeIsIterableInWhileLoop() {
        int counter = 0;
        double[] excepted = new double[rangeDouble.getEnd().intValue() * 2];

        for (int i = 0; i < excepted.length; i++)
            excepted[i] = i * 0.5;

        while (doubleIterator.hasNext()) {
            assertEquals(excepted[counter], doubleIterator.next());
            counter++;
        }
        assertEquals(rangeDouble.getEnd().intValue() * 2, counter);
    }
}
