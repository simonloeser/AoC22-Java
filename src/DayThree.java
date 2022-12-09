import java.util.Arrays;

public class DayThree {
    public static void solve() {
        String[] input = ReadInput.getText("DayThree");
        String priority = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";

        System.out.println("Part 1 - sum of doubled items: " + partOne(input, priority));
    }

    public static int partOne(String[] input, String priority) {
        final int[] sum = {0};
        final boolean[] done = {false};
        Arrays.stream(input).forEach(line -> {
            String second = line.substring(line.length() / 2);
            for (int i = 0; i < line.length() / 2; i++) {
                for (int j = 0; j < second.length(); j++) {
                    if (line.charAt(i) == second.charAt(j)) {
                        sum[0] += priority.indexOf(line.charAt(i)) + 1;
                        done[0] = true;
                        break;
                    }
                }
                if (done[0]) {
                    done[0] = false;
                    break;
                }
            }
        });
        return sum[0];
    }
}
