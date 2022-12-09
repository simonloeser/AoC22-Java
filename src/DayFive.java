import java.util.ArrayList;
import java.util.Stack;

public class DayFive {
    public static void solve() {
        String[] input = ReadInput.getText("DayFive");

        System.out.println("After the rearrangement procedure completes, what crate ends up on top of each stack?");
        System.out.println("Answer: " + partOne(input));
    }

    private static String partOne(String[] input) {
        ArrayList<String> startConfigList = new ArrayList<>();
        ArrayList<Stack<String>> stackList= new ArrayList<>();
        boolean startFinished = false;
        for (String line : input) {
            if (line.equals("") && !startFinished) {
                startFinished = true;

                String s = startConfigList.get(startConfigList.size() - 1).trim();
                int stacks = Integer.parseInt(s.substring(s.lastIndexOf(" ") + 1));

                // Fill list with needed number of stacks
                for (int i = 0; i < stacks; i++) {
                    stackList.add(new Stack<>());
                }
                // TODO: Fill stacks
            } else {
                if (!startFinished) {
                    startConfigList.add(line);
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
