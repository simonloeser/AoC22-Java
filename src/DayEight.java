public class DayEight {
    public static void solve() {
        String[] input = ReadInput.getText("DayEight");
        System.out.println("Part 1: " + partOne(input));
        System.out.println("Part 2: " + partTwo(input));
    }

    private static int partOne(String[] input) {
        int visibleTrees = input.length * 2 - 1 + input[0].length() * 2 - 4;
        int[][] layout = new int[input[0].length()][input.length];

        // Fill 2-dimensional array from input
        for (int i = 0; i < input.length; i++) {
            for (int j = 0; j < input[i].length(); j++) {
                layout[i][j] = Integer.parseInt(String.valueOf(input[i].charAt(j)));
            }
        }
        return visibleTrees;
    }

    private static String partTwo(String[] input) {
        return null;
    }
}
