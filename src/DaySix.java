public class DaySix {
    public static void solve() {
        String[] input = ReadInput.getText("DaySix");

        System.out.println("How many characters need to be processed before the first start-of-packet marker is detected?");
        System.out.println("Answer part 1: " + occurence(input, 4));
        System.out.println("Answer part 2: " + occurence(input, 14));
    }

    private static int occurence(String[] input, int distinct) {
        String s = input[0];
        for (int i = 0; i < s.length(); i++) {
            if (s.substring(i, i + distinct).chars().distinct().count() == distinct)
            {
                return i + distinct;
            }
        }
        return 0;
    }
}
