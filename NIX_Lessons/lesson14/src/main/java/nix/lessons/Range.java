package nix.lessons;

import nix.lessons.iterators.RangeIterator;

import java.util.Iterator;

public class Range<T extends Number> implements Iterable<T> {
    private T start;
    private T end;

    public Range(T start, T end) {
        this.start = start;
        this.end = end;
    }

    public T getEnd() {
        return end;
    }

    public T getStart() {
        return start;
    }

    @Override
    public RangeIterator<T> iterator() {
        return new RangeIterator<>(start, end);
    }
}
