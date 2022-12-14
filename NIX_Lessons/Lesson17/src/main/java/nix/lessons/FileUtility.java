package nix.lessons;

import nix.lessons.dto.Person;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVPrinter;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.*;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.Optional;

public class FileUtility {

    public static Optional<File> writeToCSV(List<Person> listPerson, Path path) {

        if (Files.notExists(path.getParent())) {
            try {
                Files.createDirectories(path.getParent());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        String[] headers = {"NAME", "AGE", "SEX"};

        try (CSVPrinter csvWriter = new CSVPrinter(new FileWriter(path.toFile()),
                CSVFormat.DEFAULT.withHeader(headers))) {

            csvWriter.printRecords(listPerson);
            return Optional.of(path.toFile());
        } catch (IOException e) {
            e.printStackTrace();
            return Optional.empty();
        }
    }

    public static File downloadImage(String urlString, Path imagePath) {

        try {
            BufferedImage picture = ImageIO.read(new URL(urlString));
            if (Files.notExists(imagePath))
                ImageIO.write(picture, "jpg", Files.createFile(imagePath).toFile());
        } catch (IOException ioE) {
            ioE.printStackTrace();
        }
        return imagePath.toFile();
    }
}
