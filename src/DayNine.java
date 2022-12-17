public class DayNine {
    public static void solve() {
        String[] input = ReadInput.getText("DayNine");

        System.out.println("Part 1: " + partOne(input));
    }

    private static int partOne(String[] input) {
        String[][] moves = new String[input.length * 2][input.length * 2];
        boolean[][] visited = new boolean[input.length * 2][input.length * 2];

        int headX = input.length;
        int headY = input.length;
        int tailX = input.length;
        int tailY = input.length;

        moves[headX][headY] = "H";
        visited[tailX][tailY] = true;

        for (String line : input) {
            int bounds = Integer.parseInt(String.valueOf(line.charAt(2)));
            switch (line.charAt(0)) {
                case 'U' -> {
                    for (int i = 1; i <= bounds; i++) {
                        moves[headX][headY] = "#";
                        headX--;
                        if (headX != tailX && headY != tailY) {
                            tailX = headX + 1;
                            tailY = headY;
                        }
                    }
                }
                case 'R' -> {
                    for (int i = 1; i <= bounds; i++) {
                        moves[headX][headY] = "#";
                        headY++;
                        if (headX != tailX && headY != tailY) {
                            tailX = headX;
                            tailY = headY - 1;
                        }
                    }
                }
                case 'D' -> {
                    for (int i = 1; i <= bounds; i++) {
                        moves[headX][headY] = "#";
                        headX++;
                        if (headX != tailX && headY != tailY) {
                            tailX = headX - 1;
                            tailY = headY;
                        }
                    }
                }
                case 'L' -> {
                    for (int i = 1; i <= bounds; i++) {
                        moves[headX][headY] = "#";
                        headY--;
                        if (headX != tailX && headY != tailY) {
                            tailX = headX;
                            tailY = headY + 1;
                        }
                    }
                }
                default -> System.out.println("Dataset corrupted");
            }
            moves[tailX][tailY] = "T";
            moves[headX][headY] = "H";
            visited[tailX][tailY] = true;
        }
        int count = 0;
        for (boolean[] visit : visited) {
            for (boolean visit2 : visit) {
                if (visit2) {
                    count++;
                }
            }
        }
        return count;
    }
}
