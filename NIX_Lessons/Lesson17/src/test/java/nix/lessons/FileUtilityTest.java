package nix.lessons;

import nix.lessons.dto.Person;
import nix.lessons.dto.Sex;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.*;


import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class FileUtilityTest {

    private static List<Person> testList;
    private static Path directory;
    private static Path dataFile;
    private static Path imageFile;
    @BeforeAll
    static void init(){
        testList = List.of(
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

        directory = Path.of("output");
        dataFile = Path.of(directory + "/result.csv");
        imageFile = Path.of("image.jpg");
    }

    @AfterEach
    void clearProjectDirectory(){

        try {
            Files.deleteIfExists(imageFile);
            Files.deleteIfExists(dataFile);
            Files.deleteIfExists(directory);
        }catch (IOException ioE){
            ioE.printStackTrace();
        }
    }

    @Test
    void shouldDirectoryAndFileExist(){

        FileUtility.writeToCSV(testList,dataFile);

        assertThat(Files.exists(dataFile.getParent())).isTrue();
        assertThat(Files.exists(dataFile)).isTrue();
    }

    @Test
    void checkDataIntoDataFile(){

        FileUtility.writeToCSV(testList,dataFile);

        try(Reader input = Files.newBufferedReader(dataFile)){
            CSVParser parser = new CSVParser(input, CSVFormat.DEFAULT);
            int index = 0;
            for(CSVRecord rec : parser){

                if(!rec.get(0).equals("NAME")) {
                    String[] stringFromCVS = rec.get(0).split(",");
                    Person person = new Person(stringFromCVS[0],
                            Integer.parseInt(stringFromCVS[1]),
                            Sex.fromString(stringFromCVS[2]));

                    assertThat(person).isEqualTo(testList.get(index++));
                }
            }
        }catch (IOException ioE){
            ioE.printStackTrace();
        }
    }

    @Test
    void shouldImageExists(){
        File testFile =  FileUtility.downloadImage("https://www.washingtonian.com/wp-content/uploads/2018/12/20181212SM152-HDR-scaled-994x710.jpg",imageFile);

        assertThat(Files.exists(testFile.toPath())).isTrue();
    }

    @Test
    void checkImageExtension(){

        assertThat(com.google.common.io.Files.getFileExtension(imageFile.toString())).isEqualTo("jpg");
    }

}
