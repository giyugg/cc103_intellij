package activities;
import java.util.Scanner;

public class StudentsForLoop {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        System.out.print("Enter # of Students: ");
        int studNum = scan.nextInt();
        scan.nextLine();

        System.out.print("Enter # of Subjects: ");
        int subjNum = scan.nextInt();
        scan.nextLine();

        System.out.println("--------------------------------");
        System.out.println("Enter Subject Names:");
        for (int subjCtr = 0; subjCtr < subjNum; subjCtr++) {
            System.out.print((subjCtr + 1) + ". ");
            String subjName = scan.nextLine();
        }
        System.out.println("--------------------------------");

        int totalPassed = 0;
        int totalFailed = 0;

        for (int ctr = 0; ctr < studNum; ctr++) {
            System.out.print("Enter Name of Student " + (ctr + 1) + ": ");
            String studName = scan.nextLine();

            int totalGrade = 0;

            for (int gradectr = 0; gradectr < subjNum; gradectr++) {
                System.out.print("Grade #" +  (gradectr + 1) + ": ");
                int studGrade = scan.nextInt();
                totalGrade += studGrade;
                scan.nextLine();
            } // nested for

            double average = (double) totalGrade / subjNum;
            System.out.println("Average : " + average);

            if (average > 100 || average < 0) {
                System.out.println("Invalid average. The average must be 0-100. Not counted.");
            } else if (average >= 75) {
                totalPassed++;
            } else {
                totalFailed++;
            }

            System.out.println(""); // for new line
        } // main `for`

        System.out.println("Grade Summary:");
        System.out.println("Passed: " + totalPassed);
        System.out.println("Failed: " + totalFailed);

        System.out.println("\nGrade Chart:");

        System.out.print("Passed: ");
        for (int i = 0; i < totalPassed; i++) {
            System.out.print("*");
        }
        System.out.println();
        System.out.print("Failed: ");
        for (int i = 0; i < totalFailed; i++) {
            System.out.print("*");
        }
        scan.close();
    }
}