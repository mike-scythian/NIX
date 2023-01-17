package nix.lessons;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

import java.time.LocalDate;
import java.util.*;

public class CarTest {
    private static List<Car> carList;

    @BeforeAll
    static void init() {
        carList = List.of(
                new Car(LocalDate.of(2012, 1, 20), 3.2),
                new Car(LocalDate.of(2006, 10, 1), 2.8),
                new Car(LocalDate.of(2021, 2, 10), 3.0),
                new Car(LocalDate.of(2003, 8, 10), 2.0),
                new Car(LocalDate.of(2003, 8, 16), 2.5),
                new Car(LocalDate.of(2012, 1, 20), 3.2));
    }

    @Test
    void shouldCompareTwoCars() {
        Car car1 = carList.get(0);
        Car car2 = carList.get(1);

        assertThat(car1.compareTo(car2)).isPositive();
    }

    @Test
    void shouldDefaultOrderedListCreated() {
        List<Car> orderedCarList = new ArrayList<>(carList);
        Collections.sort(orderedCarList);

        assertThat(orderedCarList)
                .isSortedAccordingTo(Comparator.comparing(Car::getYearOfManufacture));
    }

    @Test
    void shouldCreateTreeSetWithCustomComparator() {
        Comparator<Car> carComparator = Comparator.comparing(Car::getEngineCapacity);
        Set<Car> carTreeSet = new TreeSet<>(carComparator);

        carTreeSet.addAll(carList);

        assertThat(carTreeSet.stream().toList())
                .isSortedAccordingTo(carComparator);
    }
}
