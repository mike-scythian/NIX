package nix.lessons;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;


@Getter
@ToString
@AllArgsConstructor
public class Person {

    private String name;
    private int age;
    private Sex sex;

    @Override
    public boolean equals(Object anotherPerson) {

        if (this == anotherPerson) return true;
        if (!(anotherPerson instanceof Person person)) return false;

        if (getAge() != person.getAge()) return false;
        if (getName() != null ? !getName().equals(person.getName()) : person.getName() != null) return false;
        return getSex() == person.getSex();
    }

    @Override
    public int hashCode() {

        return this.getAge()*31 + this.getName().length() + this.getSex().ordinal();
    }
}
