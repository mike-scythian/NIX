package nix.lessons;

import lombok.*;

import java.time.LocalDate;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class Car {

    private double fuelTankFullness;
    private LocalDate techDate;
    private double fuelPerHundredKm;

    public boolean isDrive(){
        return this.fuelTankFullness > 0;
    }

    public boolean isTechOk(){
        return this.techDate.until(LocalDate.now()).getYears() >= 2;
    }

    public double traveledDistance(){

        return Math.round(this.fuelTankFullness / (this.fuelPerHundredKm * 0.01));
    }

}
