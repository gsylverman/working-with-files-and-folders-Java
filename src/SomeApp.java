import java.io.IOException;
import java.nio.file.*;

public class SomeApp {
    public static void main(String[] args) {

//        Path folderThree = FileSystems.getDefault().getPath("folderThree", "Dir1\\Dir2\\Dir4");
//        Path readDirectories = FileSystems.getDefault().getPath("folderThree\\Dir1");

        Path directory = FileSystems.getDefault().getPath("folderThree", "Dir1");
        readDirectories(directory);
    }

    private static void readDirectories(Path path) {
        //second param is for filter directory content ex: "*.dat"
        try (DirectoryStream<Path> contents = Files.newDirectoryStream(path, "*.txt")) {
            for (Path item : contents) {
                System.out.println(item.getFileName());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void createDirectories(Path path) {
        try {
            Files.createDirectories(path);
        } catch (IOException | DirectoryIteratorException e) {
            e.printStackTrace();
        }
    }

}
