import java.util.ArrayList;
import java.util.Stack;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DayFive {
    public static void solve() {
        String[] input = ReadInput.getText("DayFive");

        System.out.println("After the rearrangement procedure completes, what crate ends up on top of each stack?");
        System.out.println("Answer part 1: " + partOneAndTwoLol(input, 1));
        System.out.println("Answer part 2: " + partOneAndTwoLol(input, 2));
    }

    private static String partOneAndTwoLol(String[] input, int part) {
        ArrayList<String> startConfigList = new ArrayList<>();
        ArrayList<Stack<String>> stackList = new ArrayList<>();
        boolean startFinished = false;

        for (String line : input) {
            if (line.equals("") && !startFinished) {
                startFinished = true;

                // Extract number of needed stacks
                String s = startConfigList.get(startConfigList.size() - 1).trim();
                int stacks = Integer.parseInt(s.substring(s.lastIndexOf(" ") + 1));
                startConfigList.remove(startConfigList.size() - 1);

                // Fill stacks and save them in ArrayList
                for (int i = 0; i < stacks; i++) {
                    Stack<String> newStack = new Stack<>();
                    for (int j = 0; j < startConfigList.size(); j++) {
                        int item = startConfigList.size() - 1 - j;

                        if (startConfigList.get(item).startsWith("[")) {
                            newStack.push(String.valueOf(startConfigList.get(item).charAt(1)));
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
                // Extract moves
                Pattern p = Pattern.compile("-?\\d+");
                Matcher m = p.matcher(line);
                ArrayList<Integer> moves = new ArrayList<>();

                while (m.find()) {
                    moves.add(Integer.valueOf(m.group()));
                }

                if (part == 1) {
                    // Make moves part 1
                    for (int i = 0; i < moves.get(0); i++) {
                        stackList.get(moves.get(2) - 1).push(stackList.get(moves.get(1) - 1).pop());
                    }
                } else {
                    // Make moves part 2
                    ArrayList<String> reverse = new ArrayList<>();

                    for (int i = 0; i < moves.get(0); i++) {
                        reverse.add(stackList.get(moves.get(1) - 1).pop());
                    }

                    for (int j = 0; j < reverse.size(); j++) {
                        stackList.get(moves.get(2) - 1).push(reverse.get(reverse.size() - 1 - j));
                    }
                }
            }
        }
        StringBuilder solution = new StringBuilder();
        for (Stack<String> stack : stackList) {
            solution.append(stack.pop());
        }
        return solution.toString();
    }
}
