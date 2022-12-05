import java.util.Arrays;
import java.util.stream.IntStream;

public class DayOne {
    public static void solve() {
        String[] inputDayOne = ReadInput.getText("DayOne");

        int[] highestCalories = new int[3];
        int tmp = 0;

        for (String line : inputDayOne) {
            if (line.equals("")) {
                if (tmp > highestCalories[0]) {
                    highestCalories[0] = tmp;
                }
                tmp = 0;
                Arrays.sort(highestCalories);
            } else {
                tmp += Integer.parseInt(line);
            }
        }

        System.out.println("Highest calories: " + highestCalories[2]);
        System.out.println("Calories of the top 3 elves: " + IntStream.of(highestCalories).sum());
    }
}
