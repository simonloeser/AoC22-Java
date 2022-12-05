public class DayTwo {

    // Opponent: A = Rock, B = Paper, C = Scissors
    // Response: X = Rock, Y = Paper, Z = Scissors
    // Points: 1 for Rock, 2 for Paper, 3 for Scissors + 0 for lose, 3 for draw, 6 vor win

    // The stupid goblin let me do all this work for nothing, so part 2:
    // X means you need to lose, Y draw, Z win
    public static void solve() {
        String[] inputDayTwo = ReadInput.getText("DayTwo");

        int points = 0;

        for (String comp : inputDayTwo) {
            switch (comp.charAt(0)) {
                case 'A' -> {
                    switch (comp.charAt(2)) {
                        case 'X' -> points += 3; // pick scissors
                        case 'Y' -> points += 4; // pick rock
                        case 'Z' -> points += 8; // pick paper
                        default -> System.out.println("Dataset corrupted.");
                    }
                }
                case 'B' -> {
                    switch (comp.charAt(2)) {
                        case 'X' -> points += 1; // pick rock
                        case 'Y' -> points += 5; // pick paper
                        case 'Z' -> points += 9; // pick scissors
                        default -> System.out.println("Dataset corrupted.");
                    }
                }
                case 'C' -> {
                    switch (comp.charAt(2)) {
                        case 'X' -> points += 2; // pick paper
                        case 'Y' -> points += 6; // pick scissors
                        case 'Z' -> points += 7; // pick rock
                        default -> System.out.println("Dataset corrupted.");
                    }
                }
                default -> System.out.println("Dataset corrupted.");
            }
        }

        System.out.println("Your points with this trustworthy guide: " + points);
    }
}
