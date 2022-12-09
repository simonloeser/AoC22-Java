public class DayThree {
    public static void solve() {
        String[] input = ReadInput.getText("DayThree");
        String priority = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";

        System.out.println("Part 1 - sum of doubled items: " + partOne(input, priority));
    }

    public static int partOne(String[] input, String priority) {
        int sum = 0;
        boolean done = false;
        for (String line : input) {
            String second = line.substring(line.length() / 2);
            for (int i = 0; i < second.length(); i++) {
                for (int j = 0; j < second.length(); j++) {
                    if (line.charAt(i) == second.charAt(j)) {
                        sum += priority.indexOf(line.charAt(i) + 1);
                        done = true;
                        break;
                    }
                }
                if (done) {
                    done = false;
                    break;
                }
            }
        }
        return sum;
    }
}
