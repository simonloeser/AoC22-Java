import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("\n  #### AoC 2022 ####\n----------------------\n");
        System.out.print("Daynumber to start: ");

        Map<Integer, Runnable> days = new HashMap<>();

        // Solutions
        days.put(1, DayOne::solve);
        days.put(2, DayTwo::solve);
        days.put(3, DayThree::solve);
        days.put(4, DayFour::solve);
        days.put(5, DayFive::solve);
        days.put(6, DaySix::solve);
        days.put(7, DaySeven::solve);
        days.put(8, DayEight::solve);
        days.put(9, DayNine::solve);

        Scanner reader = new Scanner(System.in);
        int input = reader.nextInt();
        reader.close();
        System.out.println("\n----------------------\n");

        days.get(input).run();
    }
}