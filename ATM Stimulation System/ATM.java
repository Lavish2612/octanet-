import java.util.InputMismatchException;
import java.util.Scanner;

public class ATM {
    public static void main(String[] args) {
        // Declare and initialize balance, withdraw, and deposit
        int balance = 5000, withdraw, deposit;
        // Create scanner class object to get user input
        Scanner sc = new Scanner(System.in);
        
        while (true) {
            System.out.println("**Automated Teller Machine**");
            System.out.println("1. Withdraw");
            System.out.println("2. Deposit");
            System.out.println("3. Check Balance");
            System.out.println("4. EXIT");
            System.out.print("Choose the operation you want to perform: ");
            
            int choice = 0;
            try {
                choice = sc.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter a number.");
                sc.next(); // Clear the invalid input
                continue;
            }

            switch (choice) {
                case 1:
                    System.out.print("Enter money to be withdrawn: ");
                    try {
                        withdraw = sc.nextInt();
                        if (withdraw <= 0) {
                            System.out.println("Withdrawal amount must be positive.");
                        } else if (balance >= withdraw) {
                            balance -= withdraw;
                            System.out.println("Please collect your money");
                        } else {
                            System.out.println("Insufficient Balance");
                        }
                    } catch (InputMismatchException e) {
                        System.out.println("Invalid input. Please enter a valid amount.");
                        sc.next(); // Clear the invalid input
                    }
                    System.out.println();
                    break;

                case 2:
                    System.out.print("Enter money to be deposited: ");
                    try {
                        deposit = sc.nextInt();
                        if (deposit <= 0) {
                            System.out.println("Deposit amount must be positive.");
                        } else {
                            balance += deposit;
                            System.out.println("Your money has been successfully deposited");
                        }
                    } catch (InputMismatchException e) {
                        System.out.println("Invalid input. Please enter a valid amount.");
                        sc.next(); // Clear the invalid input
                    }
                    System.out.println();
                    break;

                case 3:
                    // Displaying the total balance of the user
                    System.out.println("Balance: " + balance);
                    System.out.println();
                    break;

                case 4:
                    // Exit from the menu
                    sc.close(); // Close the scanner
                    System.out.println("Thank you for using the ATM. Goodbye!");
                    System.exit(0);

                default:
                    System.out.println("Invalid Choice");
                    System.out.println();
            }
        }
    }
}
