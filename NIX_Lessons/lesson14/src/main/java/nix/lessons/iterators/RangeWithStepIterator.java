package nix.lessons.iterators;

import java.util.Iterator;

public class RangeWithStepIterator<T extends Number> extends RangeIterator<T> implements Iterator<T> {
    private T step;

    public RangeWithStepIterator(T start, T end, T step) {
        super(start, end);
        this.step = step;
    }

    @Override
    public T next() {

        var innerStart = super.getStart();
        switch (super.getStart().getClass().getName()) {
            case "java.lang.Integer" -> {
                var buff = super.getStart().intValue();
                buff = Integer.sum(super.getStart().intValue(), step.intValue());
                super.setStart((T) (Integer.valueOf(buff)));
            }
            case "java.lang.Long" -> {
                var buff = super.getStart().longValue();
                buff = Long.sum(super.getStart().longValue(), step.longValue());
                super.setStart((T) (Long.valueOf(buff)));
            }
            case "java.lang.Float" -> {
                var buff = super.getStart().floatValue();
                buff = Float.sum(super.getStart().floatValue(), step.floatValue());
                super.setStart((T) (Float.valueOf(buff)));
            }
            case "java.lang.Double" -> {
                var buff = super.getStart().doubleValue();
                buff = Double.sum(super.getStart().doubleValue(), step.doubleValue());
                super.setStart((T) (Double.valueOf(buff)));
            }
            default -> {
                return null;
            }
        }
        return innerStart;
    }
}
