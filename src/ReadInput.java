import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class ReadInput {
    public static String[] getText(String day) {
        try (BufferedReader br = new BufferedReader(new FileReader("src/inputs/input" + day + ".txt"))) {
            StringBuilder sb = new StringBuilder();
            String line = br.readLine();

            while (line != null) {
                sb.append(line);
                sb.append(System.lineSeparator());
                line = br.readLine();
            }
            return sb.toString().split("\\r?\\n");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
