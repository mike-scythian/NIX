package nix.lessons;

import java.time.DayOfWeek;
import java.time.LocalDate;

public class App
{
    public static void main( String[] args )
    {
        Cat cat = new Cat("white", 8,"aegean");

        DayOfWeek today = LocalDate.now().getDayOfWeek();

        for(DaysOfWeek e : DaysOfWeek.values())
            if(e.name().equals(today.name()))
                System.out.println(cat.scheduleCat(e));
    }
}
