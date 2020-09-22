import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;
import java.nio.file.attribute.FileTime;

public class SomeApp {
    public static void main(String[] args) {

        Path filePath = FileSystems.getDefault().getPath("someFile.txt");

        Path path = FileSystems.getDefault().getPath("someFileThatDontExist.txt");

        Path path1 = FileSystems.getDefault().getPath(".", "TestDirAndFiles\\InnerDir1\\inner1TextFile.txt");

        Path sourcePath = FileSystems.getDefault().getPath(".", "TestDirAndFiles\\InnerDir1");

//        System.out.println(sourcePath);
        Path destinationPath = FileSystems.getDefault().getPath(".", "TestDirAndFiles\\InnerDir1\\inner1RenamedTextFile.txt");
//        System.out.println(Files.exists(path1));
        Path pathx = FileSystems.getDefault().getPath("TestDirAndFiles", "InnerDir1", "newEmptyFile.txt");
        Path createDirectories = FileSystems.getDefault().getPath("TestDirAndFiles", "Folder1\\Folder2\\Folder3\\Folder4\\Folder5\\Folder6");
//        try {
//            Files.createDirectories(createDirectories);
//        }catch (IOException e) {
//            e.printStackTrace();
//        }
        Path someFile = FileSystems.getDefault().getPath("someFile.txt");
        try {
            long fileSize = Files.size(someFile);
            FileTime lastModified = Files.getLastModifiedTime(someFile);
//            System.out.println("Last modified time: " + lastModified);
//            System.out.println(fileSize);

            BasicFileAttributes basicFileAttributes = Files.readAttributes(someFile, BasicFileAttributes.class);
            System.out.println(basicFileAttributes.size());
            System.out.println(basicFileAttributes.creationTime());
            System.out.println(basicFileAttributes.lastModifiedTime());
            BasicFileAttributes basicFileAttributes1 = Files.readAttributes(someFile, BasicFileAttributes.class);
        } catch (IOException e) {
            e.printStackTrace();
            new FileWriter("das")
        }

    }

    private static void writeTextFile(Path path) {
        try (BufferedWriter bufferedWriter = Files.newBufferedWriter(path)) {
            bufferedWriter.write("Gavril");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
