import java.util.Scanner;

public class ParkingFeeSystemFinals {
    // for the default credentials
    static String username = "admin";
    static String password = "password123";

    // Vehicle types
    static int totalMotorcycles = 0;
    static int totalCars = 0;
    static int totalTrucks = 0;
    static double totalFeesCollected = 0;
    static long totalParkingMinutes = 0;

    static Scanner global = new Scanner(System.in);
    public static void main(String[] args) {
        if (!handleLogin()) { // calls handleLogin below
            System.out.println("Three (3) unsuccessful attempts. The program will now terminate.");
            return;
        }
        boolean exit = false; // the program will keep running because 'exit' is initially false.
        while (!exit) { // // the loop continues while 'exit' is NOT true.
            displayMenu();
            System.out.print("Enter your choice: ");
            int choice = getIntegerInput(); // gets the number input for the switch choices.

            switch (choice) {
                case 1:
                    processNewTransaction();
                    break;
                case 2:
                    generateSummary();
                    break;
                case 3:
                    handleChangeCredentials();
                    break;
                case 4:
                    displayGroupAndStatusInformation();
                    break;
                case 0:
                    System.out.println("Thank you for using the Parking Fee System! Exiting...");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.\n"); // if they choose a random numbers not feasible to the choices, error will show up.
            }
        }
        global.close();
    }

    public static boolean handleLogin() { // as mentioned in line 17, this will be the instructions what handleLogin will do.
        System.out.println("--- Welcome to the Parking Fee System ---");
        for (int loginCtr = 0; loginCtr < 3; loginCtr++) { // counter for the 3 times attempt in line 18. program will terminate after 3 unsuccessful attempts.
            System.out.print("Enter username: ");
            String usernameEntered = global.nextLine(); // user to input username

            System.out.print("Enter password: ");
            String passwordEntered = global.nextLine(); // user to input password

            if (usernameEntered.equals(username) && passwordEntered.equals(password)) {
                System.out.println("\nYou have successfully logged in! Welcome " + username);
                return true;
            } else {
                System.out.println("You have entered an invalid username or password. You only have " + (2 - loginCtr) + "attempts remaining.");
            }
        }
        return false;
    }

    public static void displayMenu() {
        System.out.println("=========================================");
        System.out.println("  Parking Fee System Menu");
        System.out.println("  Logged in as: " + username);
        System.out.println("=========================================");
        System.out.println("1. Park a New Vehicle (Add Record)");
        System.out.println("2. View Daily Summary");
        System.out.println("3. Change Username/Password");
        System.out.println("4. Group Information");
        System.out.println("0. Exit");
        System.out.println("=========================================");
    }
}