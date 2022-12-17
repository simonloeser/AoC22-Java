public class DayNine {
    public static void solve() {
        String[] input = ReadInput.getText("DayNine");

        System.out.println("Part 1: " + partOne(input));
    }

    private static int partOne(String[] input) {
        String[][] moves = new String[input.length / 5][input.length / 5];
        boolean[][] visited = new boolean[input.length / 5][input.length / 5];

        for (int i = 0; i < moves.length; i++) {
            for (int j = 0; j < moves[0].length; j++) {
                moves[i][j] = ".";
            }
        }

        int headX = moves.length / 2;
        int headY = moves[0].length / 2;
        int tailX = moves.length / 2;
        int tailY = moves[0].length / 2;

        moves[headX][headY] = "H";
        visited[tailX][tailY] = true;

        for (String line : input) {
            int bounds = Integer.parseInt(String.valueOf(line.charAt(2)));
            switch (line.charAt(0)) {
                case 'U' -> {
                    for (int i = 1; i <= bounds; i++) {
                        moves[headX][headY] = "#";
                        moves[tailX][tailY] = "#";
                        headX--;
                        if (headX != tailX && headY != tailY) {
                            tailX = headX + 1;
                            tailY = headY;
                        }
                        visited[tailX][tailY] = true;
                    }
                }
                case 'R' -> {
                    for (int i = 1; i <= bounds; i++) {
                        moves[headX][headY] = "#";
                        moves[tailX][tailY] = "#";
                        headY++;
                        if (headX != tailX && headY != tailY) {
                            tailX = headX;
                            tailY = headY - 1;
                        }
                        visited[tailX][tailY] = true;
                    }
                }
                case 'D' -> {
                    for (int i = 1; i <= bounds; i++) {
                        moves[headX][headY] = "#";
                        moves[tailX][tailY] = "#";
                        headX++;
                        if (headX != tailX && headY != tailY) {
                            tailX = headX - 1;
                            tailY = headY;
                        }
                        visited[tailX][tailY] = true;
                    }
                }
                case 'L' -> {
                    for (int i = 1; i <= bounds; i++) {
                        moves[headX][headY] = "#";
                        moves[tailX][tailY] = "#";
                        headY--;
                        if (headX != tailX && headY != tailY) {
                            tailX = headX;
                            tailY = headY + 1;
                        }
                        visited[tailX][tailY] = true;
                    }
                }
                default -> System.out.println("Dataset corrupted");
            }
            moves[tailX][tailY] = "T";
            moves[headX][headY] = "H";
        }
        /*for (String[] move1 : moves) {
            for (String move2 : move1) {
                System.out.print(move2);
            }
            System.out.println();
        }*/
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
