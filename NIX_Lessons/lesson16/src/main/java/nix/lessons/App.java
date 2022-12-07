package nix.lessons;

import java.util.List;

public class App 
{
    public static void main( String[] args )
    {

        List<Person> listPerson = List.of(
                new Person("John", 40, Sex.MAN),
                new Person("Jeff", 15, Sex.MAN),
                new Person("Inga", 17, Sex.WOMAN),
                new Person("Kate", 52, Sex.WOMAN),
                new Person("Maxim", 21, Sex.MAN),
                new Person("Pavel", 63, Sex.MAN),
                new Person("Mary", 20, Sex.WOMAN),
                new Person("Jennifer", 35, Sex.WOMAN),
                new Person("Karl", 19, Sex.MAN),
                new Person("Michael", 34, Sex.MAN));

        PersonProcessor personProcessor = new PersonProcessor();

        System.out.println("Full person list");
        personProcessor.printPersons(listPerson);
        System.out.println("Women from 18 to 60");
        personProcessor.printPersons(personProcessor.getWomen(listPerson,18,60));
        System.out.println("Employable persons");
        personProcessor.printPersons(personProcessor.listEmployablePersons(listPerson));
        System.out.println("Average age of men");
        System.out.println(personProcessor.getMenAverageAge(listPerson));

        Person p1 = new Person("Mary", 20,Sex.WOMAN);
        Person p2 = new Person("Mary", 20,Sex.WOMAN);

        System.out.println(p1.equals(p2));
    }
}
