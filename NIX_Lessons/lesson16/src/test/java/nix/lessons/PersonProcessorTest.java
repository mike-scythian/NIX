package nix.lessons;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;
import java.util.List;

class PersonProcessorTest {

    private static List<Person> testListPerson;
    private static PersonProcessor personProcessor;

    @BeforeAll
    static void init(){

        testListPerson = List.of(
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

        personProcessor = new PersonProcessor();
    }

    @Test
    void shouldGetWomenFromEighteenToSixty(){

        List<Person> women = List.of(
                new Person("Kate", 52, Sex.WOMAN),
                new Person("Mary", 20, Sex.WOMAN),
                new Person("Jennifer", 35, Sex.WOMAN));

        List<Person> testedList = personProcessor.getWomen(testListPerson,18,60);

        assertThat(testedList.size()).isEqualTo(women.size());
        assertThat(personProcessor.getWomen(testListPerson, 18, 60))
                .containsExactlyInAnyOrderElementsOf(women);
    }

    @Test
    void shouldGetMenAverageAge(){

        assertThat(personProcessor.getMenAverageAge(testListPerson)).isEqualTo(32.0);
    }

    @Test
    void shouldGetListEmployablePersons(){

        List<Person> employablePersons = personProcessor.listEmployablePersons(testListPerson);

        assertThat(employablePersons.size()).isEqualTo(7);
        assertThat(employablePersons).doesNotContain(
                new Person("Jeff", 15, Sex.MAN),
                new Person("Inga", 17, Sex.WOMAN),
                new Person("Pavel", 63, Sex.MAN));

    }
}
