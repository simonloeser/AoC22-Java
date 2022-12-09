import java.util.Arrays;

public class DayThree {
    public static void solve() {
        String[] input = ReadInput.getText("DayThree");
        String priority = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";

        System.out.println("Part 1 - sum of doubled items: " + partOne(input, priority));
        System.out.println("Part 2 - sum of badge priorities: " + partTwo(input, priority));
    }

    private static int partOne(String[] input, String priority) {
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

    private static int partTwo(String[] input, String priority) {
        int sum = 0;
        int count = 0;
        boolean done = false;
        String first = "";
        String second = "";
        for (String line : input) {
            switch (count) {
                case 0 -> first = line;
                case 1 -> second = line;
                case 2 -> {
                    for (int i = 0; i < first.length(); i++) {
                        for (int j = 0; j < second.length(); j++) {
                            for (int k = 0; k < line.length(); k++) {
                                if (first.charAt(i) == second.charAt(j) && second.charAt(j) == line.charAt(k)) {
                                    sum += priority.indexOf(line.charAt(k)) + 1;
                                    done = true;
                                    break;
                                }
                            }
                            if (done) {
                                break;
                            }
                        }
                        if (done) {
                            done = false;
                            break;
                        }
                    }
                    count = -1;
                }
                default -> System.out.println("Failure");
            }
            count++;
        }
        return sum;
    }
}
