package activities;
import java.util.Scanner;

public class LoopPatternActivity {
    public static void main(String[] args) {
        Scanner num = new Scanner(System.in);
        int start, end, sum = 0;

        System.out.println("Acuña, Kyle A.");
        System.out.println("BSIS 1B-G2");

        do {
            System.out.print("Starting Number: ");
            start = num.nextInt();
            System.out.print("Ending Number: ");
            end = num.nextInt();

            if (start > 0 && end > 0 && start <= end) { // start and end must be positive | start must be less than or equal to end after meeting the start > 0 && end > 0
                for (int a = start; a <= end; a++) {
                    sum += a;
                    for (int b = 1; b <= a; b++) {
                        System.out.print("*");
                    }
                    System.out.println();
                }
                System.out.println("Sum of Numbers: " + sum);
                break;
            }
            else {
                System.out.println("Invalid input...");
            }
        } while (true);
    }
}