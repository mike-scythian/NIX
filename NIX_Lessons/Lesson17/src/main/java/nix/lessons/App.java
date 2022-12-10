package nix.lessons;

import nix.lessons.dto.Person;
import nix.lessons.dto.Sex;

import java.io.File;
import java.nio.file.Paths;
import java.util.List;

public class App
{
    public static void main( String[] args ) {

     List<Person> testListPerson = List.of(
                new Person("John", 40, Sex.MALE),
                new Person("Jeff", 15, Sex.MALE),
                new Person("Inga", 17, Sex.FEMALE),
                new Person("Kate", 52, Sex.FEMALE),
                new Person("Maxim", 21, Sex.OTHER),
                new Person("Pavel", 63, Sex.MALE),
                new Person("Mary", 20, Sex.FEMALE),
                new Person("Jennifer", 35, Sex.FEMALE),
                new Person("Karl", 19, Sex.MALE),
                new Person("Michael", 34, Sex.MALE));

     String imageUrl = "https://www.washingtonian.com/wp-content/uploads/2018/12/20181212SM152-HDR-scaled-994x710.jpg";

     //FileUtility.writeToCSV(testListPerson, Paths.get("output/result.csv"));
     File imgFile = FileUtility.downloadImage(imageUrl,Paths.get("image.jpg"));

    }
}
