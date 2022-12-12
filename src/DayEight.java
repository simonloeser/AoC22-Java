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
        boolean[][] vis = new boolean[rows][cols];
        // Iterate over array rows to find visible trees from the sides
        for (int row = 0; row < rows; row++) {
            int lastNode = -1;
            // Visible from the right side
            for (int col = cols - 1; col >= 0; col--) {
                if (layout[row][col] > lastNode) {
                    vis[row][col] = true;
                    lastNode = layout[row][col];
                }
            }

            // Visible from the left side
            lastNode = -1;
            for (int col = 0; col < cols; col++) {
                if (layout[row][col] > lastNode) {
                    vis[row][col] = true;
                    lastNode = layout[row][col];
                }
            }


        }

        // Iterate over array cols to find visible trees from the top and bottom
        for (int col = 0; col < cols; col++) {
            int lastNode = -1;
            // Visible from the bottom side
            for (int row = rows - 1; row >= 0; row--) {
                if (layout[row][col] > lastNode) {
                    vis[row][col] = true;
                    lastNode = layout[row][col];
                }
            }

            lastNode = -1;
            // Visible from the top side
            for (int row = 0; row < rows; row++) {
                if (layout[row][col] > lastNode) {
                    vis[row][col] = true;
                    lastNode = layout[row][col];
                }
            }
        }
        int visibleTrees = 0;
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                if (vis[row][col]) {
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
