import java.io.*;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.HashMap;
import java.util.Map;

class Location<T, V> implements Serializable {
    private final T id;
    private final V description;

    public Location(T id, V description) {
        this.id = id;
        this.description = description;
    }

    public T getId() {
        return id;
    }

    public V getDescription() {
        return description;
    }
}

public class Test {
    private static Map<Integer, String> list = new HashMap<>();
    private static Map<Integer, Location> locations = new HashMap<>();

    public static void main(String[] args) {
        locations.put(1, new Location(1, "acasa"));
        locations.put(2, new Location(2, "La mare"));
        locations.put(3, new Location(3, "La munte"));
        locations.put(4, new Location(4, "La mare"));
        list.put(1, "Some data 1");
        list.put(2, "Some data 2");
        list.put(3, "Some data 3");
        list.put(4, "Some data 4");

        Path filePath = FileSystems.getDefault().getPath("someRandomFile.txt");
        Path objsFilePath = FileSystems.getDefault().getPath("nioObjectFile.dat");
        reafObjectWithNIO(objsFilePath);

    }

    private static void reafObjectWithNIO(Path objsFilePath) {
        try (ObjectInputStream objectInputStream = new ObjectInputStream(new BufferedInputStream(Files.newInputStream(objsFilePath)))) {
            boolean endOfFile = false;
            while (!endOfFile) {
                try {
                    Location temLocation = (Location) objectInputStream.readObject();
                    System.out.println(temLocation.getDescription());
                } catch (EOFException e) {
                    endOfFile = true;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    private static void writeObjectWitNIO(Path objsFilePath) {
        try (ObjectOutputStream objectOutputStream = new ObjectOutputStream(new BufferedOutputStream(Files.newOutputStream(objsFilePath)))) {
            for (Location location : locations.values()) {
                objectOutputStream.writeObject(location);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void readObjectWithIO() {
        try (ObjectInputStream objectInputStream = new ObjectInputStream(new BufferedInputStream(new FileInputStream("someObjectsFile.dat")))) {
            boolean endOfFile = false;
            while (!endOfFile) {
                try {
                    Location<Integer, String> tempLocation = (Location) objectInputStream.readObject();
                    System.out.println(tempLocation.getDescription());
                } catch (EOFException e) {
                    endOfFile = true;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    private static void writeObjectsWithIO(Map<Integer, Location> map) {
        try (ObjectOutputStream objectOutputStream = new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream("someObjectsFile.dat")))) {
            for (Location location : map.values()) {
                objectOutputStream.writeObject(location);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void readFileWithNIO(Path filePath) {
        try (BufferedReader bufferedReader = Files.newBufferedReader(filePath)) {
            String input;
            while ((input = bufferedReader.readLine()) != null) {
                System.out.println(input);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void readFileWithIO() {
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader("someRandomFile.txt"))) {
            String input;
            while ((input = bufferedReader.readLine()) != null) {
                System.out.println(input);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void writeWithIO() {
        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("someRandomFile.txt"))) {
            bufferedWriter.write("gavril");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void writeTextFileWithNIO(Path path) {
        try (BufferedWriter bufferedWriter = Files.newBufferedWriter(path)) {
            for (Integer key : list.keySet()) {
                bufferedWriter.write(key + "," + list.get(key) + "\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}


