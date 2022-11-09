package org.example;

public abstract class Predator {

    private String color;
    private int weight;

    @Override
    public boolean equals(Object o) {

        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Predator predator = (Predator) o;

        if (weight != predator.weight) return false;
        return color != null ? color.equals(predator.color) : predator.color == null;
    }

    @Override
    public int hashCode() {
        int result = color != null ? color.length() : 0;
        result = result + weight * 7;
        return result;
    }

    protected abstract void toSleep();
    protected abstract String toHunt();

    public String getColor() {
        return color;
    }

    public int getWeight() {
        return weight;
    }
}
