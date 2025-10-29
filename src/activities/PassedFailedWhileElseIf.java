package activities;
import java.util.Scanner;

public class PassedFailedWhileElseIf {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int grade;
        int passed = 0, failed = 0;

        System.out.print("Enter grade (-1 to stop): ");
        grade = scan.nextInt();

        while (grade != -1) {
            if (grade < 75 && grade >= 0) {
                System.out.println("Failed");
                failed++;
            }
            else if (grade > 75 && grade <= 100) {
                System.out.println("Passed");
                passed++;
            }
            System.out.print("Enter grade (-1 to stop): ");
            grade = scan.nextInt();
        }

        System.out.println("Passed: " + passed);
        System.out.print("Failed: " + failed);
        scan.close();
    }
}