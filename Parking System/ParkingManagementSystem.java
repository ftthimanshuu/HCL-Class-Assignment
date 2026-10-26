import java.util.Scanner;

public class ParkingManagementSystem {
    private boolean[] lotStatus;
    private String[] lotCarMap;
    private Scanner scanner;

    public ParkingManagementSystem() {
        lotStatus = new boolean[100];
        lotCarMap = new String[100];
        scanner = new Scanner(System.in);
    }

    public void start() {
        int choice;

        do {
            System.out.println("\n--- Parking Management System ---");
            System.out.println("1. Park a car");
            System.out.println("2. View lot status");
            System.out.println("3. Remove car from lot");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");

            choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    parkCar();
                    break;
                case 2:
                    viewLotStatus();
                    break;
                case 3:
                    removeCar();
                    break;
                case 4:
                    System.out.println("Exiting program...");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        } while (choice != 4);
    }

    private void parkCar() {
        System.out.print("Enter car number: ");
        String carNumber = scanner.nextLine();

        int lotNumber;
        while (true) {
            System.out.print("Enter lot number (1-100): ");
            lotNumber = scanner.nextInt();
            scanner.nextLine();

            if (lotNumber < 1 || lotNumber > 100) {
                System.out.println("Lot number must be between 1 and 100.");
                continue;
            }

            int index = lotNumber - 1;
            if (lotStatus[index]) {
                System.out.println("This lot is already occupied. Please choose another lot.");
            } else {
                lotStatus[index] = true;
                lotCarMap[index] = carNumber;
                System.out.println("Car " + carNumber + " parked successfully in lot " + lotNumber + ".");
                break;
            }
        }
    }

    private void viewLotStatus() {
        System.out.println("\nLot Status:");
        for (int i = 0; i < 100; i++) {
            if (lotStatus[i]) {
                System.out.println("Lot " + (i + 1) + " : Occupied by " + lotCarMap[i]);
            } else {
                System.out.println("Lot " + (i + 1) + " : Free");
            }
        }
    }

    private void removeCar() {
        System.out.print("Enter car number to remove: ");
        String carNumber = scanner.nextLine();

        int lotNumber = -1;
        for (int i = 0; i < 100; i++) {
            if (lotStatus[i] && lotCarMap[i].equals(carNumber)) {
                lotNumber = i;
                break;
            }
        }

        if (lotNumber == -1) {
            System.out.println("Car not found in the parking system.");
        } else {
            lotStatus[lotNumber] = false;
            lotCarMap[lotNumber] = null;
            System.out.println("Car " + carNumber + " removed from lot " + (lotNumber + 1) + ".");
        }
    }
}
