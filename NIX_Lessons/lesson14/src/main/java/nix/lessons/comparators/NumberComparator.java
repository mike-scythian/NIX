package nix.lessons.comparators;

import java.util.Comparator;

public class NumberComparator<T extends Number> implements Comparator<T> {
    private T number1;
    private T number2;

    public NumberComparator(T a, T b) {
        this.number1 = a;
        this.number2 = b;
    }

    @Override
    public int compare(T t, T t1) {
        switch (number1.getClass().getName()) {
            case "java.lang.Integer" -> {
                return Integer.compare(number1.intValue(), number2.intValue());
            }
            case "java.lang.Long" -> {
                return Long.compare(number1.longValue(), number2.longValue());
            }
            case "java.lang.Float" -> {
                return Float.compare(number1.floatValue(), number2.floatValue());
            }
            case "java.lang.Double" -> {
                return Double.compare(number1.doubleValue(), number2.doubleValue());
            }
            default -> {
                return 0;
            }
        }
    }
}