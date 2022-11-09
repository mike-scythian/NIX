package nix.lessons;

import nix.lessons.exceptions.StackIsEmptyException;
import nix.lessons.exceptions.StackOverFlowException;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.*;

public class AppTest
{
    private static MyStack stackInt;
    private static MyStack stackString;

    @BeforeAll
    static void init(){

        stackInt = new MyStack<Integer>();
        stackString = new MyStack<String>(3);

    }

    @AfterEach
    void clear(){

        while(!stackInt.isEmpty()){
            stackInt.getElement();
        }
        while(!stackString.isEmpty()){
            stackString.getElement();
        }
    }

    @Test
    void shouldBeEmpty(){

        assertThat(stackInt.isEmpty()).isTrue();
        stackInt.add(100);
        assertThat(stackInt.isEmpty()).isFalse();
    }

    @Test
    void shouldBeFull(){

        stackString.add("stack");
        stackString.add("is");
        stackString.add("full");

        assertThat(stackString.isFull()).isTrue();
        assertThat(stackInt.isFull()).isFalse();

    }

    @Test
    void shouldToAdd(){

        stackString.add("stack");
        stackString.add("is");
        stackString.add("full");

        //stack is full. Can't add element
        assertThat(stackString.add("Over")).isFalse();

        //checking of throwing StackOverFlowException

        assertThatThrownBy(()->{throw new StackOverFlowException();})
               .isInstanceOf(StackOverFlowException.class)
               .hasMessageContaining("Stack is full");

        //Element added
        assertThat(stackInt.add(100)).isTrue();
    }
    @Test
    void shouldBeElementOut(){

        //stack is empty
        assertThat(stackInt.getElement()).isNull();

        //checking of throwing StackOverFlowException

        assertThatThrownBy(()->{throw new StackIsEmptyException();})
                .isInstanceOf(StackIsEmptyException.class)
                .hasMessageContaining("Stack is empty");

        //element getting is successfully
        stackInt.add(1);
        assertThat(stackInt.getElement()).isEqualTo(Integer.valueOf(1));
    }

    @Test
    void shouldGetTopElement(){

     stackString.add("First");
     stackString.add("Second");

     assertThat(stackString.showTop()).isEqualTo("Second");
    }
}
