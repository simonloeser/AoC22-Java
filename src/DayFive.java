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
        ArrayList<Stack<String>> stackList = new ArrayList<>();
        boolean startFinished = false;
        for (String line : input) {
            if (line.equals("") && !startFinished) {
                startFinished = true;

                String s = startConfigList.get(startConfigList.size() - 1).trim();
                int stacks = Integer.parseInt(s.substring(s.lastIndexOf(" ") + 1));
                startConfigList.remove(startConfigList.size() - 1);

                // Fill stacks and save them
                for (int i = 0; i < stacks; i++) {
                    Stack<String> newStack = new Stack<>();
                    for (int j = 0; j < startConfigList.size(); j++) {
                        int item = startConfigList.size() - 1 - j;
                        if (startConfigList.get(item).startsWith("[")) {
                            newStack.push(String.valueOf(startConfigList.get(item).charAt(1)));
                            System.out.println(newStack);
                        }
                        if (startConfigList.get(item).length() >= 4) {
                            startConfigList.set(item, startConfigList.get(item).substring(4));
                        }
                    }
                    stackList.add(newStack);
                }
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
