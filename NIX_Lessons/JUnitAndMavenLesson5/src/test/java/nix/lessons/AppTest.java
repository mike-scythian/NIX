package nix.lessons;

import junit.framework.TestCase;
import junit.framework.TestSuite;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

/**
 * Unit test for simple App.
 */
public class AppTest
    extends TestCase
{
   @Test
   public void shouldIsDrive(){

      Car auto1 = new Car(20, LocalDate.of(2020, 1 , 5), 5.7);
      Car auto2 = new Car(0, LocalDate.of(2020, 1 , 5), 5.7);
      Car auto3 = new Car(-5, LocalDate.of(2020, 1 , 5), 5.7);

      assertEquals(true, auto1.isDrive());
      assertEquals(false, auto2.isDrive());
      assertEquals(false, auto3.isDrive());
   }

   @Test
   public void shouldIsTechOk(){

      Car auto1 = new Car(20, LocalDate.of(2020, 1 , 5), 5.7);
      Car auto2 = new Car(20, LocalDate.of(2022, 1 , 5), 5.7);

      assertEquals(true, auto1.isTechOk());
      assertEquals(false, auto2.isTechOk());
   }

   @Test
   public void shouldTraveledDistance(){

      Car auto1 = new Car(20, LocalDate.of(2020, 1 , 5), 4);
      Car auto2 = new Car(0, LocalDate.of(2022, 1 , 5), 5);

      assertEquals(500d, auto1.traveledDistance());
      assertEquals(0d, auto2.traveledDistance());
   }
}
