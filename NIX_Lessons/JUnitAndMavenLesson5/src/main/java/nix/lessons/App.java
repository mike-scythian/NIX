package nix.lessons;

import java.time.LocalDate;

public class App
{
    public static void main( String[] args )
    {
        Car auto = new Car(32, LocalDate.of(2020,5,20), 8.5);

        System.out.println( auto);

    }
}
