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

        Scanner reader = new Scanner(System.in);
        int input = reader.nextInt();
        reader.close();
        System.out.println("\n----------------------\n");

        days.get(input).run();
    }
}