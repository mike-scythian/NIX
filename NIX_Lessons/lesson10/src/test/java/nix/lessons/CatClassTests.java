package nix.lessons;

import static org.assertj.core.api.Assertions.*;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;

import static org.junit.jupiter.api.Assertions.*;

public class CatClassTests {

    private static Cat kitty;

    @BeforeAll
    static void createKitty(){
        kitty = new Cat("black",6,"highlander");
    }

    @Test
    void shouldCatsEquals(){

        Cat cat = new Cat("black", 6,"highlander");

        assertTrue(kitty.equals(cat));
        assertTrue(kitty.hashCode() == cat.hashCode());
    }

    @Test
    void shouldCatsNotEquals(){

        Cat cat = new Cat("black", 6,"ragdoll");

        assertFalse(kitty.equals(cat));
        assertFalse(kitty.hashCode() == cat.hashCode());
    }

    @ParameterizedTest
    @EnumSource(DaysOfWeek.class)
    void shouldSleep(DaysOfWeek day){

        if(day.name().equals("MONDAY") || day.name().equals("WEDNESDAY") || day.name().equals("FRIDAY"))
            assertEquals("Murrrrr\nMurrrr\nMurrrrr", kitty.scheduleCat(day));

    }

    @ParameterizedTest
    @EnumSource(DaysOfWeek.class)
    void shouldHunt(DaysOfWeek day){

        if(day.name().equals("TUESDAY") || day.name().equals("THURSDAY") || day.name().equals("SATURDAY"))
            assertThat(kitty.scheduleCat(day)).isBetween("Prey", "Uhrrrr");
    }

    @ParameterizedTest
    @EnumSource(DaysOfWeek.class)
    void shouldDoesTigidyk(DaysOfWeek day){

        if(day.name().equals("SUNDAY"))
            assertEquals(kitty.scheduleCat(day), kitty.tigidykSkill(day.ordinal()));
    }

    @Test
    void shouldSuperPowerUse(){

        DaysOfWeek day = DaysOfWeek.HOLIDAY;
        assertEquals(kitty.scheduleCat(day),"I lick my super balls");
    }
}
