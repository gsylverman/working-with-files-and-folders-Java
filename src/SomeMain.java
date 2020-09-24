import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;

public class SomeMain {
    public static void main(String[] args) {
        Path pathdir2 = FileSystems.getDefault().getPath("e:");
        try {
            Files.walkFileTree(pathdir2, new PrintFileName());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
