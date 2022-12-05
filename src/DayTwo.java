public class DayTwo {

    // Opponent: A = Rock, B = Paper, C = Scissors
    // Response: X = Rock, Y = Paper, Z = Scissors
    // Points: 1 for Rock, 2 for Paper, 3 for Scissors + 0 for lose, 3 for draw, 6 vor win
    public static void solve() {
        String[] inputDayTwo = ReadInput.getText("DayTwo");

        int points = 0;

        for (String comp : inputDayTwo) {
            switch (comp.charAt(0)) {
                case 'A' -> {
                    switch (comp.charAt(2)) {
                        case 'X' -> points += 4;
                        case 'Y' -> points += 8;
                        case 'Z' -> points += 3;
                        default -> System.out.println("Dataset corrupted.");
                    }
                }
                case 'B' -> {
                    switch (comp.charAt(2)) {
                        case 'X' -> points += 1;
                        case 'Y' -> points += 5;
                        case 'Z' -> points += 9;
                        default -> System.out.println("Dataset corrupted.");
                    }
                }
                case 'C' -> {
                    switch (comp.charAt(2)) {
                        case 'X' -> points += 7;
                        case 'Y' -> points += 2;
                        case 'Z' -> points += 6;
                        default -> System.out.println("Dataset corrupted.");
                    }
                }
                default -> System.out.println("Dataset corrupted.");
            }
        }

        System.out.println("Your points with this trustworthy guide: " + points);
    }
}
