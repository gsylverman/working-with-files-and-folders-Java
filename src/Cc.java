import java.io.IOException;
import java.nio.file.DirectoryStream;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;

public class Cc {
    public static void main(String[] args) {
        Path dirPath = FileSystems.getDefault().getPath("folderThree", "Dir1");
        DirectoryStream.Filter<Path> filter = new DirectoryStream.Filter<Path>() {
            @Override
            public boolean accept(Path entry) throws IOException {
                return Files.isRegularFile(entry);
            }
        };
        readDirectory(dirPath, filter);
    }

    private static void readDirectory(Path path, DirectoryStream.Filter<Path> filter) {
        try (DirectoryStream<Path> directoryStream = Files.newDirectoryStream(path, filter)){
            for (Path item : directoryStream) {
                System.out.println(item.getFileName());
            }
        }catch (IOException e) {
            e.printStackTrace();
        }

    }
}
