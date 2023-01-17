package nix.lessons;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.time.DayOfWeek;
import java.time.LocalDate;

import static org.assertj.core.api.Assertions.*;
import static org.mockito.Mockito.*;

public class FuctionalInterfacesTest {
    
    private static FunctionalInterfaces fi;
    
    @BeforeAll
    static void init(){
        fi = new FunctionalInterfaces();
    }
    
    @Test
    void shouldGetTrueWithPrimeNumber(){
        
        assertThat(fi.predicateIsPrime(7)).isTrue();
    }
    @Test
    void shouldGetFalseWithPrimeNumber(){

        assertThat(fi.predicateIsPrime(8)).isFalse();
    }

    @Test
    void shouldRandomNumberPrint(){

        FunctionalInterfaces mockFi = mock(FunctionalInterfaces.class);

        doNothing().when(mockFi).consumerRandomGenerate(isA(Double.class));
        mockFi.consumerRandomGenerate(10.0);
        verify(mockFi,times(1)).consumerRandomGenerate(10.0);
    }

    @Test
    void shouldGetWhatDayIsToday(){

        assertThat(fi.supplierGetDay())
                .isIn(DayOfWeek.values())
                .isEqualTo(LocalDate.now().getDayOfWeek());
    }

    @Test
    void shouldRoundDoubleToLong(){

        assertThat(fi.functionRoundDoubleToLong(10.467)).isEqualTo(11L);
    }

    @Test
    void shouldGetFibonacciNumber(){

        assertThat(fi.unaryOperatorFibo(10)).isEqualTo(55);
    }
    
}
