import java.io.File;
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
        // Method reference
        DirectoryStream.Filter<Path> filter = Files::isRegularFile;

        //with Lambda
//        DirectoryStream.Filter<Path> filter = (Path entry) -> Files.isRegularFile(entry);

        // Regular implemented method
//        DirectoryStream.Filter<Path> filter =
//                new DirectoryStream.Filter<Path>() {
//                    @Override
//                    public boolean accept(Path entry) throws IOException {
//                        return (Files.isRegularFile(entry));
//                    }
//                };

        //second param is for filter directory content ex: "*.dat" or we can replace with our implementation in accept method from DirectoryStream.Filter<Path> interface
        try (DirectoryStream<Path> contents = Files.newDirectoryStream(path, filter)) {
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
