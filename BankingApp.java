import java.util.Scanner;

public class BankingApp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("=== Bank Account Setup ===");
        
        System.out.print("Enter your full name: ");
        String fullName = scanner.nextLine().trim();
        
        String upperName = fullName.toUpperCase();
        
        String firstName;
        int spaceIndex = upperName.indexOf(' ');
        if (spaceIndex != -1) {
            firstName = upperName.substring(0, spaceIndex);
        } else {
            firstName = upperName;
        }
        
        String noSpaces = fullName.replace(" ", "");
        int charCount = noSpaces.length();

        System.out.print("Enter account number (8 digits, must start with 1): ");
        String accountNumber = scanner.nextLine().trim();

        System.out.print("Enter initial balance: $");
        double balance = scanner.nextDouble();
        scanner.nextLine();

        boolean validAccount = true;

        if (accountNumber.length() != 8) {
            validAccount = false;
        } else if (accountNumber.charAt(0) != '1') {
            validAccount = false;
        } else {
            for (int i = 0; i < 8; i++) {
                if (!Character.isDigit(accountNumber.charAt(i))) {
                    validAccount = false;
                    break;
                }
            }
        }

        if (!validAccount) {
            System.out.println("Invalid Account number");
            System.out.println("Program will exit.");
            scanner.close();
            return;
        }

        System.out.println("\n=== Create your 4-digit PIN ===");
        String pin;
        boolean validPin;

        do {
            System.out.print("Enter 4-digit PIN: ");
            pin = scanner.nextLine().trim();
            
            validPin = (pin.length() == 4) && pin.matches("\\d{4}");
            
            if (!validPin) {
                System.out.println("PIN must be exactly 4 digits (0-9 only). Try again.");
            }
        } while (!validPin);

        System.out.println("\n=== Login ===");
        System.out.print("Re-enter your PIN to login: ");
        String enteredPin = scanner.nextLine().trim();

        if (!enteredPin.equals(pin)) {
            System.out.println("Incorrect PIN");
            System.out.println("Program will exit.");
            scanner.close();
            return;
        }

        System.out.println("Login Successful!");

        System.out.println("\n=== Transactions ===");

        System.out.print("Enter amount to deposit: $");
        double deposit = scanner.nextDouble();
        if (deposit > 0) {
            balance += deposit;
            System.out.printf("Deposited $%.2f. New balance: $%.2f%n", deposit, balance);
        } else {
            System.out.println("Deposit amount must be positive.");
        }

        System.out.print("Enter amount to withdraw: $");
        double withdraw = scanner.nextDouble();
        if (withdraw > 0) {
            if (withdraw <= balance) {
                balance -= withdraw;
                System.out.printf("Withdrew $%.2f. New balance: $%.2f%n", withdraw, balance);
            } else {
                System.out.println("Insufficient funds!");
            }
        } else {
            System.out.println("Withdrawal amount must be positive.");
        }

        System.out.println("\n=== ACCOUNT SUMMARY ===");
        System.out.println("---------------");
        System.out.println("Name          : " + upperName);
        System.out.println("First Name    : " + firstName);
        System.out.println("Name length (no spaces): " + charCount + " characters");
        System.out.println("Account Number: " + accountNumber);
        System.out.printf("Final Balance : $%.2f%n", balance);

        scanner.close();
    }
}