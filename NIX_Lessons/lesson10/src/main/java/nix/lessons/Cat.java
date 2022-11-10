package nix.lessons;


import java.util.Random;

public class Cat extends Predator{

    private String breed;

    public Cat(String color, int weight, String breed) {
        super(color, weight);
        this.breed = breed;
    }

    public String getBreed() {
        return breed;
    }

    @Override
    public boolean equals(Object o) {

        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;

        Cat cat = (Cat) o;

        return breed != null ? breed.equals(cat.breed) : cat.breed == null;
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = result + breed.length()*7;
        return result;
    }
    protected String toSleep() {

        return "Murrrrr\nMurrrr\nMurrrrr";
    }

    protected String toHunt() {

        boolean huntResult = new Random().nextBoolean();

        return huntResult ? "Prey" : "Uhrrrr";
    }
    public String tigidykSkill(int number){

        String resultString = "";

        for(int i=0; i < number; i++)
            resultString += "TIGIDYK\n";

        return  resultString;
    }
    public String superPower(){

        return "I lick my super balls";
    }

    public String scheduleCat(DaysOfWeek day){

        return switch (day){
                            case MONDAY, WEDNESDAY, FRIDAY -> toSleep();
                            case TUESDAY, THURSDAY, SATURDAY -> toHunt();
                            case SUNDAY ->  tigidykSkill(day.ordinal());
                            default -> superPower();
        };

    }
}
