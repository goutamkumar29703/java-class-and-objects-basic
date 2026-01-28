package main;

import models.Car;
import database.CarDAO;
import java.util.List;
import java.util.Scanner;


public class CarRentalSystem {
    
    
    private static Scanner scanner = new Scanner(System.in);
    
    
    private static CarDAO carDAO = new CarDAO();
    
    
    public static void main(String[] args) {
        
        System.out.println("╔════════════════════════════════════════╗");
        System.out.println("║   WELCOME TO CAR RENTAL SYSTEM         ║");
        System.out.println("╚════════════════════════════════════════╝");
        
        boolean running = true;
        
       
        while (running) {
            displayMainMenu();
            
            int choice = getUserChoice();
            
            switch (choice) {
                case 1:
                    filterAndViewInventory();
                    break;
                    
                case 2:
                    rentCar();
                    break;
                    
                case 3:
                    returnCarAndBill();
                    break;
                    
                case 4:
                    System.out.println("\n✓ Thank you for using Car Rental System!");
                    System.out.println("  Goodbye! 👋");
                    running = false;
                    break;
                    
                default:
                    System.out.println("\n✗ Invalid choice! Please enter 1-4.");
            }
        }
        
        scanner.close();
    }
    
   
    private static void displayMainMenu() {
        System.out.println("\n========================================");
        System.out.println("           MAIN MENU");
        System.out.println("========================================");
        System.out.println("1. View Available Cars (Filter by Category)");
        System.out.println("2. Rent a Car");
        System.out.println("3. Return a Car & Get Bill");
        System.out.println("4. Exit");
        System.out.println("========================================");
        System.out.print("Enter your choice (1-4): ");
    }
    
    
    private static int getUserChoice() {
        try {
            return Integer.parseInt(scanner.nextLine());
        } catch (NumberFormatException e) {
            return -1;
        }
    }
    
   
    private static void filterAndViewInventory() {
        System.out.println("\n========================================");
        System.out.println("     FILTER CARS BY CATEGORY");
        System.out.println("========================================");
        System.out.println("1. SUV");
        System.out.println("2. Sedan");
        System.out.println("3. Hatchback");
        System.out.println("========================================");
        System.out.print("Enter category choice (1-3): ");
        
        int categoryChoice = getUserChoice();
        String category = "";
        
        
        switch (categoryChoice) {
            case 1:
                category = "SUV";
                break;
            case 2:
                category = "Sedan";
                break;
            case 3:
                category = "Hatchback";
                break;
            default:
                System.out.println("✗ Invalid category choice!");
                return;
        }
        
        System.out.println("\nFetching available " + category + " cars...\n");
        List<Car> cars = carDAO.getAvailableCarsByCategory(category);
        
        
        if (cars.isEmpty()) {
            System.out.println("✗ Sorry! No " + category + " cars available right now.");
        } else {
            System.out.println("✓ Found " + cars.size() + " available " + category + " car(s):\n");
            for (Car car : cars) {
                car.displayCarInfo();
            }
        }
    }
    
   
    private static void rentCar() {
        System.out.println("\n========================================");
        System.out.println("          RENT A CAR");
        System.out.println("========================================");
        System.out.print("Enter plate number of car to rent: ");
        String plateNo = scanner.nextLine().trim();
        
       
        Car car = carDAO.getCarByPlateNo(plateNo);
        
        if (car == null) {
            System.out.println("✗ Car with plate number '" + plateNo + "' not found!");
            return;
        }
        
        if (!car.getStatus().equals("Available")) {
            System.out.println("✗ Sorry! This car is already rented.");
            return;
        }
        

        System.out.println("\nCar Details:");
        car.displayCarInfo();
        
       
        System.out.print("\nConfirm rental? (yes/no): ");
        String confirm = scanner.nextLine().trim().toLowerCase();
        
        if (confirm.equals("yes") || confirm.equals("y")) {
            
            boolean success = carDAO.rentCar(plateNo);
            
            if (success) {
                System.out.println("\n✓ SUCCESS! Car rented successfully.");
                System.out.println("  Please remember the plate number: " + plateNo);
                System.out.println("  Daily rate: ₹" + car.getRatePerDay());
            }
        } else {
            System.out.println("✗ Rental cancelled.");
        }
    }
    
   
    private static void returnCarAndBill() {
        System.out.println("\n========================================");
        System.out.println("      RETURN CAR & GET BILL");
        System.out.println("========================================");
        System.out.print("Enter plate number of car to return: ");
        String plateNo = scanner.nextLine().trim();
        
        
        Car car = carDAO.getCarByPlateNo(plateNo);
        
        if (car == null) {
            System.out.println("✗ Car with plate number '" + plateNo + "' not found!");
            return;
        }
        
        if (!car.getStatus().equals("Rented")) {
            System.out.println("✗ This car is not currently rented!");
            return;
        }
        
       
        System.out.print("How many days was the car rented? ");
        int days = 0;
        
        try {
            days = Integer.parseInt(scanner.nextLine());
            
            if (days <= 0) {
                System.out.println("✗ Invalid number of days!");
                return;
            }
            
        } catch (NumberFormatException e) {
            System.out.println("✗ Please enter a valid number!");
            return;
        }
        
        
        double ratePerDay = car.getRatePerDay();
        double totalBill = days * ratePerDay;
        
        
        System.out.println("\n========================================");
        System.out.println("          RENTAL BILL");
        System.out.println("========================================");
        System.out.println("Car Model: " + car.getModel());
        System.out.println("Plate Number: " + plateNo);
        System.out.println("Category: " + car.getCategory());
        System.out.println("----------------------------------------");
        System.out.println("Rate per Day: ₹" + ratePerDay);
        System.out.println("Number of Days: " + days);
        System.out.println("----------------------------------------");
        System.out.println("TOTAL BILL: ₹" + totalBill);
        System.out.println("========================================");
        
        
        boolean success = carDAO.returnCar(plateNo);
        
        if (success) {
            System.out.println("✓ Car returned successfully!");
            System.out.println("  Thank you for your business! 🚗");
        }
    }
}
