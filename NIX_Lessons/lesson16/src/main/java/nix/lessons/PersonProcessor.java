package nix.lessons;

import java.util.Comparator;
import java.util.List;

public class PersonProcessor {

    public List<Person> getWomen(List<Person> persons, Integer ageLow, Integer ageHigh){

        return persons.stream()
                .filter(p -> p.getSex() == Sex.WOMAN)
                .filter(p -> (p.getAge() >= ageLow) && (p.getAge() < ageHigh))
                .sorted(Comparator.comparing(Person::getAge))
                .toList();
    }

    public double getMenAverageAge(List<Person> persons){

        return persons.stream()
                .filter(p -> p.getSex() == Sex.MAN)
                .mapToInt(Person::getAge)
                .average()
                .orElse(0.0);
    }

    public List<Person> listEmployablePersons(List<Person> persons){

        return persons.stream()
                .filter(p -> (p.getAge() < 60) && (p.getAge() >= 18))
                .filter(p -> (p.getSex() != Sex.WOMAN) || (p.getAge() < 55))
                .sorted(Comparator.comparing(Person::getAge))
                .toList();
    }

    public void printPersons(List<Person> persons){

        persons.forEach(System.out::println);
    }
}
