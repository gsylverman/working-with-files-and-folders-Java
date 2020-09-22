import java.io.BufferedReader;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;

public class SomeApp {
    public static void main(String[] args) {

//        Path folderThree = FileSystems.getDefault().getPath("folderThree", "Dir1\\Dir2\\Dir4");
//        Path readDirectories = FileSystems.getDefault().getPath("folderThree\\Dir1");
//
//        readDirectories();
    }

    private static void readDirectories(Path path) {

    }

    private static void createDirectories(Path path) {
        try {
            Files.createDirectories(path);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
