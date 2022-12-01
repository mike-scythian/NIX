package nix.lessons.iterators;

import nix.lessons.comparators.NumberComparator;

import java.util.Iterator;

public class RangeIterator<T extends Number> implements Iterator<T> {

    private final String INTEGER_CLASS_NAME = Integer.class.getName();
    private final String LONG_CLASS_NAME = Long.class.getName();
    private final String FLOAT_CLASS_NAME = Float.class.getName();
    private final String DOUBLE_CLASS_NAME = Double.class.getName();

    private T start;
    private T end;

    public RangeIterator(T start, T end) {
        this.start = start;
        this.end = end;
    }

    @Override
    public boolean hasNext() {
        if (new NumberComparator<>(start, end).compare(start, end) > 0)
            return false;
        return !start.equals(end);
    }

    @Override
    public T next() {
        var innerStart = start;

        if (start.getClass().getName().equals(INTEGER_CLASS_NAME)) {
            var buff = start.intValue();
            buff = Integer.sum(start.intValue(), 1);
            start = (T) (Integer.valueOf(buff));
        } else if (start.getClass().getName().equals(LONG_CLASS_NAME)) {
            var buff = start.longValue();
            buff = Long.sum(start.longValue(), 1L);
            start = (T) (Long.valueOf(buff));
        } else if (start.getClass().getName().equals(FLOAT_CLASS_NAME)) {
            var buff = start.floatValue();
            buff = Float.sum(start.floatValue(), 0.5f);
            start = (T) (Float.valueOf(buff));
        } else if (start.getClass().getName().equals(DOUBLE_CLASS_NAME)) {
            var buff = start.doubleValue();
            buff = Double.sum(start.doubleValue(), 0.5);
            start = (T) (Double.valueOf(buff));
        }
        return innerStart;
    }

    public T getStart() {
        return start;
    }

    public void setStart(T start) {
        this.start = start;
    }


}
