public class DayEight {
    public static void solve() {
        String[] input = ReadInput.getText("DayEight");
        System.out.println("Part 1: " + partOne(input));
        System.out.println("Part 2: " + partTwo(input));
    }

    private static int partOne(String[] input) {
        int[][] layout = new int[input[0].length()][input.length];

        // Fill 2-dimensional array from input
        for (int i = 0; i < input.length; i++) {
            for (int j = 0; j < input[i].length(); j++) {
                layout[i][j] = Integer.parseInt(String.valueOf(input[i].charAt(j)));
            }
        }

        int rows = layout.length;
        int cols = layout[0].length;

        int visibleTrees = 0;
        // Iterate over array to find visible trees
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                boolean[] visible = {true, true, true, true};
                // Tree visible from the right
                for (int k = row + 1; k < rows - row - 1; k++) {
                    if (layout[k][col] >= layout[row][col]) {
                        visible[0] = false;
                        break;
                    }
                }

                // Tree visible from the left
                for (int k = row - 1; k >= 0; k--) {
                    if (layout[k][col] >= layout[row][col]) {
                        visible[1] = false;
                        break;
                    }
                }

                // Tree visible from the top
                for (int k = col - 1; k >= 0; k--) {
                    if (layout[row][k] >= layout[row][col]) {
                        visible[2] = false;
                        break;
                    }
                }

                // Tree visible from the bottom
                for (int k = col + 1; k < cols - col - 1; k++) {
                    if (layout[k][col] >= layout[row][col]) {
                        visible[3] = false;
                        break;
                    }
                }

                // Visible from any side?
                if (visible[0] || visible[1] || visible[2] || visible[3]) {
                    visibleTrees++;
                }
            }
        }
        return visibleTrees;
    }

    private static String partTwo(String[] input) {
        return null;
    }
}
