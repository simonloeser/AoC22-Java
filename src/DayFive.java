import java.util.ArrayList;

public class DayFive {
    public static void solve() {
        String[] input = ReadInput.getText("DayFour");

        System.out.println("After the rearrangement procedure completes, what crate ends up on top of each stack?");
        System.out.println("Answer: " + partOne(input));
    }

    private static String partOne(String[] input) {
        ArrayList<String> start = new ArrayList<>();
        boolean startFinished = false;
        for (String line : input) {
            if (line.equals("")) {
                startFinished = true;
                // TODO: Fill stacks
            } else {
                if (!startFinished) {
                    start.add(line);
                    continue;
                }
                // TODO: Make moves
            }
        }
        return "";
    }

    private static String partTwo(String[] input) {
        return "";
    }
}
