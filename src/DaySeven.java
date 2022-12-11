import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static java.lang.Long.parseLong;

public class DaySeven {
    private final static Map<String, Directory> directories = new HashMap<>();
    private record File(String name, long size) {}
    private record Directory(String directoryName, List<File> files) {}
    public static void solve() {
        String[] input = ReadInput.getText("DaySeven");
        System.out.println("Part 1: " + partOne(input));
        System.out.println("Part 2: " + partTwo(input));
    }

    private static long partOne(String[] input) {
        processInput(input);

        return directories.values()
                .stream()
                .map(DaySeven::getTotalSize)
                .filter(totalSize -> totalSize <= 100_000L)
                .reduce(Long::sum)
                .orElseThrow();
    }

    private static long partTwo(String[] input) {
        directories.clear();

        processInput(input);

        long rootSize = getTotalSize(directories.get("/"));
        long freeSpace = 70_000_000L - rootSize;
        long necessarySpace = 30_000_000L - freeSpace;

        return directories.values()
                .stream()
                .filter(directory -> !directory.directoryName().equals(""))
                .map(DaySeven::getTotalSize)
                .filter(size -> size >= necessarySpace)
                .min(Long::compareTo)
                .orElseThrow();
    }

    private static long getTotalSize(Directory directory) {
        List<File> files = directory.files();
        long totalSize = 0L;
        for (File file : files) {
            // Recursion shit
            totalSize += file.size() != -1L ? file.size() : getTotalSize(directories.get(file.name()));
        }
        return totalSize;
    }

    private static void processInput(String[] lines) {
        Directory rootDirectory = new Directory("", new ArrayList<>());
        directories.put("/", rootDirectory);
        Directory currentDirectory = rootDirectory;
        for (String line : lines) {
            if (line.startsWith("$ cd")) {
                currentDirectory = changeDirectory(currentDirectory, line);
            } else if (!line.startsWith("$ ls")) {
                // Add a file
                if (line.startsWith("dir")) {
                    String directoryName = line.substring(4);
                    Directory directory = new Directory("%s/%s".formatted(currentDirectory.directoryName(), directoryName), new ArrayList<>());
                    String path = "%s/%s".formatted(currentDirectory.directoryName(), directoryName);
                    directories.put(path, directory);
                    currentDirectory.files().add(new File(path, -1));
                } else {
                    String[] fileInfo = line.split(" ");
                    currentDirectory.files().add(new File(fileInfo[1], parseLong(fileInfo[0])));
                }
            }
        }
    }

    private static Directory changeDirectory(Directory currentDirectory, String line) {
        String inputDirectory = line.substring(5);
        if (inputDirectory.equals("/")) {
            return directories.get("/");
        }
        if (inputDirectory.equals("..")) {
            Directory directory = directories.get(currentDirectory.directoryName().substring(0, currentDirectory.directoryName().lastIndexOf('/')));
            return directory == null ? directories.get("/") : directory;
        }
        return directories.get("%s/%s".formatted(currentDirectory.directoryName(), inputDirectory));
    }
}
