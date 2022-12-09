public class DayFour {
    public static void solve() {
        String[] input = ReadInput.getText("DayFour");

        int countPartOne = 0;
        int countPartTwo = 0;
        for (String line : input) {
            String first = line.substring(0, line.indexOf(","));
            String second = line.substring(line.indexOf(",") + 1);

            int firstNum = Integer.parseInt(first.substring(0, first.indexOf("-")));
            int secondNum = Integer.parseInt(first.substring(first.indexOf("-") + 1));
            int thirdNum = Integer.parseInt(second.substring(0, second.indexOf("-")));
            int fourthNum = Integer.parseInt(second.substring((second.indexOf("-") + 1)));

            // Part 1
            if (firstNum >= thirdNum && secondNum <= fourthNum || thirdNum >= firstNum && fourthNum <= secondNum) {
                countPartOne++;
            }

            // Part 2
            if (firstNum >= thirdNum && firstNum <= fourthNum || secondNum >= thirdNum && secondNum <= fourthNum ||
                    thirdNum >= firstNum && thirdNum <= secondNum || fourthNum >= firstNum && fourthNum <= secondNum) {
                countPartTwo++;
            }
        }

        System.out.println("In how many assignment pairs does one range fully contain the other?");
        System.out.println("Answer: " + countPartOne);

        System.out.println("\nIn how many assignment pairs do the ranges overlap?");
        System.out.println("Answer: " + countPartTwo);
    }
}
