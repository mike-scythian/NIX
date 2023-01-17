package nix.lessons;

import java.time.LocalDate;
import java.util.*;

public class App {
    public static void main(String[] args) {
        List<Car> carList = List.of(new Car(LocalDate.of(2014, 1, 25), 3.5),
                new Car(LocalDate.of(2006, 10, 1), 2.8),
                new Car(LocalDate.of(2021, 2, 10), 3.2),
                new Car(LocalDate.of(2003, 8, 10), 2.0),
                new Car(LocalDate.of(2003, 8, 16), 2.5));
        List<Car> cars = new ArrayList<>(carList);
        TreeSet<Car> carTreeSet = new TreeSet<>(Comparator.comparing(Car::getEngineCapacity));

        System.out.println("Basic list of cars");
        carList.forEach(System.out::println);

        Collections.sort(cars);

        System.out.println("After sorting");
        cars.forEach(System.out::println);

        carTreeSet.addAll(carList);

        System.out.println("Tree set of cars with comparator");
        carTreeSet.forEach(System.out::println);

        System.out.println("Range class test");
        Range<Float> r = new Range<>(0f, 100.0f);
        Iterator<Float> itRange = r.iterator();

        for (Float el : r)
          System.out.println(el.toString());

        System.out.println("RangeWithStep class test");

        RangeWithStep<Long> r1 = new RangeWithStep<>(1L, 100L, 5L);
        Iterator<Long> iter = r1.iterator();

        while (iter.hasNext()){
            System.out.println(iter.next().toString());
        }
        System.out.println("hello world");
        iter = r1.iterator();
        while(iter.hasNext()){
            System.out.println(iter.next());
        }
    }
}
