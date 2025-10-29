package activities;
import java.util.Scanner;

public class SwapMethod {
    public static void main(String[] args) {
        Scanner x = new Scanner(System.in);

        System.out.print("Enter first number: ");
        int a = x.nextInt();
        System.out.print("Enter second number: ");
        int b = x.nextInt();
        System.out.print("Enter third number: ");
        int c = x.nextInt();

        System.out.println();
        System.out.println("Before swapping: ");
        System.out.println("a = " + a + ", b = " + b + ", c = " + c);

        int highest = getHighest(a, b, c);
        int lowest = getLowest(a, b, c);
        System.out.println("Highest = " + highest);
        System.out.println("Lowest = " + lowest);
        swapValues(a, b, c);
        x.close();
    }

    public static int getHighest(int a, int b, int c) {
        int max = a;
        if (b > max) {
            max = b;
        }
        if (c > max) {
            max = c;
        }
        return max;
    }

    public static int getLowest(int a, int b, int c) {
        int min = a;
        if (b < min) {
            min = b;
        }
        if (c < min) {
            min = c;
        }
        return min;
    }

    public static void swapValues(int a, int b, int c) {
        int high = getHighest(a, b, c);
        int low = getLowest(a, b, c);

        if (a == high) {
            a = low;
        }
        else if (a == low) {
            a = high;
        }

        if (b == high) {
            b = low;
        }
        else if (b == low) {
            b = high;
        }

        if (c == high) {
            c = low;
        }
        else if (c == low) {
            c = high;
        }

        System.out.println();
        System.out.println("After swapping");
        System.out.println("a = " + a + ", b = " + b + ", c = " + c);
    }
}