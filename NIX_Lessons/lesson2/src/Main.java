import java.util.Random;

public class Main {
    public static void main(String[] args) {

        //System.out.println("Hello world!");

        var luckyNumber = new Random().nextInt(10) + 1;

        System.out.println("Your lucky number today is ... " + luckyNumber);
    }
}