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

    public static boolean isValidPlateForType(String vehicleType, String plate) {
        String PatternCarAndTruck = "(?i)^[A-Z]{3} \\d{4}$"; // ABC 1234
        String PatternMotorcycle = "(?i)^\\d{3} [A-Z]{3}$";  // 123 ABC
        
        if (vehicleType.equalsIgnoreCase("Motorcycle")) {
            return plate.matches(PatternMotorcycle);
        } return plate.matches(PatternCarAndTruck);
    } 

    public static void processNewTransaction() {
        String vehicleType = getActualVehicleType();

        String plateNumber;
        while (true) {
            System.out.print("Enter Plate Number: ");
            plateNumber = global.nextLine().trim();
            if (isValidPlateForType(vehicleType, plateNumber)) {
                break;
            } System.out.println("Invalid plate number format for " + vehicleType + ". Expected format: " + (vehicleType.equalsIgnoreCase("Motorcycle") ? "123 ABC" : "ABC 1234") + ". Please try again.");
        }
        // Time in and out logic comes here.
        System.out.println("\nEnter Time-In (24-hour format)");
        int timeInHour = getTimeInput("Hour (0-23): ", 23);
        int timeInMinute = getTimeInput("Minute (0-59): ", 59);

        System.out.println("\nEnter Time-Out (24-hour format)");
        int timeOutHour, timeOutMinute;
        long durationMinutes;

        while (true) {
            timeOutHour = getTimeInput("Hour (0-23): ", 23);
            timeOutMinute = getTimeInput("Minute (0-59): ", 59);

            // Convert hours to minutes by multiplying by 60
            long inTotal = timeInHour * 60L + timeInMinute;
            long outTotal = timeOutHour * 60L + timeOutMinute;
            durationMinutes = outTotal - inTotal;

            if (durationMinutes >= 0) break;
            System.out.println("Error: Time-Out cannot be earlier than Time-In. Please enter again.");
        } double parkingFee = computeParkingFee(vehicleType, durationMinutes);

        System.out.print("\nWas the ticket lost? (yes/no): ");
        boolean isTicketLost = global.nextLine().equalsIgnoreCase("yes");
        if (isTicketLost) {
            parkingFee += 200.0;
        }

        System.out.print("Is the driver a Senior Citizen or PWD? (yes/no): ");
        boolean hasDiscount = global.nextLine().equalsIgnoreCase("yes");
        if (hasDiscount) {
            parkingFee *= 0.80; // 20% off
        }

        // For update summary
        displayReceipt(plateNumber, vehicleType, timeInHour, timeInMinute, timeOutHour, timeOutMinute, durationMinutes, parkingFee, isTicketLost, hasDiscount);
        totalFeesCollected += parkingFee;
        totalParkingMinutes += durationMinutes;
        String type = vehicleType.toLowerCase();

        if (type.equals("motorcycle")) {
            totalMotorcycles++;
        } else if (type.equals("car")) {
            totalCars++;
        } else if (type.equals("suv")) {
            totalTrucks++;
        }
    }

    public static String getActualVehicleType() {
        while (true) {
            System.out.print("Enter Vehicle Type (Motorcycle, Car, Truck): ");
            String type = global.nextLine();
            if (type.equalsIgnoreCase("Motorcycle") ||
                    type.equalsIgnoreCase("Car") ||
                    type.equalsIgnoreCase("Truck")) {
                return type;
            }
            System.out.println("Invalid vehicle type. Please try again.");
        }
    }

    public static int getTimeInput(String prompt, int max) {
        int value;
        while (true) {
            System.out.print(prompt);
            value = getIntegerInput();
            if (value >= 0 && value <= max) {
                return value;
            }
            System.out.println("Invalid input. Please enter a value between 0 and " + max + ".");
        }
    }
}