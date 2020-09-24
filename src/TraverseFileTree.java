import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;

public class TraverseFileTree {
    public static void main(String[] args) {
        Path fileTreePath = FileSystems.getDefault().getPath("e:");
        readFileTree(fileTreePath);
    }

    private static void readFileTree(Path path) {
        try {
            Files.walkFileTree(path, new ReadFiles());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
