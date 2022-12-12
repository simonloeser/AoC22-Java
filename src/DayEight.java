import java.util.Arrays;
import java.util.Stack;

public class DayEight {
    public static void solve() {
        String[] input = ReadInput.getText("DayEight");
        int[][] layout = new int[input[0].length()][input.length];

        // Fill 2-dimensional array from input
        for (int i = 0; i < input.length; i++) {
            for (int j = 0; j < input[i].length(); j++) {
                layout[i][j] = Integer.parseInt(String.valueOf(input[i].charAt(j)));
            }
        }
        System.out.println("Part 1: " + partOne(layout));
        System.out.println("Part 2: " + partTwo(layout));
    }

    private static int partOne(int[][] layout) {
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

    private static int partTwo(int[][] layout) {
        int rows = layout.length;
        int cols = layout[0].length;
        int[][] mult = new int[rows][cols];

        // Fill array with 1
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                mult[row][col] = 1;
            }
        }

        Stack<Integer> stack = new Stack<>();
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                while (!stack.isEmpty() && layout[row][col] >= layout[row][stack.peek()]) {
                    int i = stack.pop();
                    mult[row][i] *= col - i;
                }
                stack.push(col);
            }
            while (!stack.isEmpty()) {
                int i = stack.pop();
                mult[row][i] *= cols - i - 1;
            }

            for (var col = cols - 1; col >= 0; col--) {
                while (!stack.isEmpty() && layout[row][col] >= layout[row][stack.peek()]) {
                    int i = stack.pop();
                    mult[row][i] *= i - col;
                }
                stack.push(col);
            }
            while (!stack.isEmpty()) {
                int i = stack.pop();
                mult[row][i] *= i;
            }
        }

        for (int col = 0; col < cols; col++) {
            for (int row = 0; row < rows; row++) {
                while (!stack.isEmpty() && layout[row][col] >= layout[stack.peek()][col]) {
                    int i = stack.pop();
                    mult[i][col] *= row - i;
                }
                stack.push(row);
            }
            while (!stack.isEmpty()) {
                int i = stack.pop();
                mult[i][col] *= rows - i - 1;
            }

            for (int row = rows - 1; row >= 0; row--) {
                while (!stack.isEmpty() && layout[row][col] >= layout[stack.peek()][col]) {
                    int i = stack.pop();
                    mult[i][col] *= i - row;
                }
                stack.push(row);
            }
            while (!stack.isEmpty()) {
                int i = stack.pop();
                mult[i][col] *= i;
            }
        }

        return Arrays.stream(mult)
                .flatMapToInt(Arrays::stream)
                .max()
                .orElseThrow();
    }
}
