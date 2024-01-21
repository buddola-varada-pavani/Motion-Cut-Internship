import java.util.Scanner;

public class ExpenseTracker {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double[] expenses = new double[10]; // Adjust the size as needed
        int expenseCount = 0;

        while (true) {
            System.out.println("1. Add Expense\n2. View Expenses\n3. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    if (expenseCount < expenses.length) {
                        System.out.print("Enter the expense amount: ");
                        double amount = scanner.nextDouble();
                        expenses[expenseCount++] = amount;
                        System.out.println("Expense added successfully!");
                    } else {
                        System.out.println("Expense limit reached. Cannot add more expenses.");
                    }
                    break;
                case 2:
                    System.out.println("Expenses:");
                    for (int i = 0; i < expenseCount; i++) {
                        System.out.println("Expense " + (i + 1) + ": $" + expenses[i]);
                    }
                    break;
                case 3:
                    System.out.println("Exiting Expense Tracker. Have a good day!");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid choice. Please enter a valid option.");
            }
        }
    }
}
