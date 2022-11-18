package nix.lessons;

import nix.lessons.exceptions.StackIsEmptyException;
import nix.lessons.exceptions.StackOverFlowException;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

public class MyStackTest {

    private static MyStack stackInt;
    private static MyStack stackString;

    @BeforeAll
    static void init() {

        stackInt = new MyStack<Integer>();
        stackString = new MyStack<String>(3);

    }

    @AfterEach
    void clear() {

        while (!stackInt.isEmpty()) {
            stackInt.get();
        }
        while (!stackString.isEmpty()) {
            stackString.get();
        }
    }

    @Test
    void shouldBeEmpty() {

        assertThat(stackInt.isEmpty()).isTrue();
        stackInt.add(100);
        assertThat(stackInt.isEmpty()).isFalse();
    }

    @Test
    void shouldThrowStackIsEmptyException() {

        assertThatThrownBy(() -> {
            stackString.getElement();
        })
                .isInstanceOf(StackIsEmptyException.class)
                .hasMessageContaining("Stack is empty");
    }

    @Test
    void shouldBeFull() {

        stackString.add("stack");
        stackString.add("is");
        stackString.add("full");

        assertThat(stackString.isFull()).isTrue();
        assertThat(stackInt.isFull()).isFalse();

    }

    @Test
    void shouldThrowStackOverFlowException() {

        stackString.add("stack");
        stackString.add("is");
        stackString.add("full");

        assertThatThrownBy(() -> {
            stackString.addElement("overflow");
        })
                .isInstanceOf(StackOverFlowException.class)
                .hasMessageContaining("Stack is full");
    }

    @Test
    void shouldAdd() {

        assertThat(stackInt.add(100)).isTrue();
    }

    @Test
    void shouldBeElementOut() {

        stackInt.add(1);

        assertThat(stackInt.get()).isEqualTo(Integer.valueOf(1));
        assertThat(stackInt.isEmpty()).isTrue();
    }

    @Test
    void shouldGetTopElement() {

        stackString.add("First");
        stackString.add("Second");

        assertThat(stackString.showTop()).isEqualTo("Second");
    }

    @Test
    void shouldGetOptional() {

        stackInt.add(10);

        assertThat(stackInt.getOptional()).hasValue(Integer.valueOf(10));
    }

    @Test
    void shouldGetEmptyOptional() {

        assertAll("Returned empty Optional",
                () -> assertThat(stackInt.getOptional()).isEmpty(),
                () -> assertThat(stackInt.getOptional().isEmpty()).isTrue());
    }
}
