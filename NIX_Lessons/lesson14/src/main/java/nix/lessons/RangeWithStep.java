package nix.lessons;

import nix.lessons.iterators.RangeWithStepIterator;


public class RangeWithStep<T extends Number> extends Range<T> implements Iterable<T> {
    private T step;

    public RangeWithStep(T start, T end, T step) {
        super(start, end);
        this.step = step;
    }

    @Override
    public RangeWithStepIterator<T> iterator() {
        return new RangeWithStepIterator<>(super.getStart(), super.getEnd(), step);
    }
}
