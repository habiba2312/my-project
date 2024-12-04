/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.myproject;
import java.util.Scanner;
public class MyProject {
    private static BankAccount currentAccount;

    public static void main(String[] args) {
         Scanner scanner = new Scanner(System.in);
        boolean exit = false;

        while (!exit) {
            System.out.println("---- Bank Menu ----");
            System.out.println("1. Create Account");
            System.out.println("2. Withdraw");
            System.out.println("3. Deposit");
            System.out.println("4. Check Balance");
            System.out.println("5. View Transaction History");
            System.out.println("6. Exit");
            System.out.print("Choose an option: ");

            int choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    createAccount(scanner);
                    break;
                case 2:
                    withdraw(scanner);
                    break;
                case 3:
                    deposit(scanner);
                    break;
                case 4:
                    checkBalance();
                    break;
                case 5:
                    viewTransactionHistory();
                    break;
                case 6:
                    exit = true;
                    System.out.println("Exiting");
                    break;
                default:
                    System.out.println("Invalid option");
            }
        }
        scanner.close();
    }

    private static void createAccount(Scanner scanner) {
        System.out.print("Enter account number: ");
        String accountNumber = scanner.next();
        System.out.print("Enter account holder name: ");
        String name = scanner.next();
        System.out.print("Enter deposit: ");
        double deposit = scanner.nextDouble();

        currentAccount = new BankAccount(accountNumber, name, deposit);
        System.out.println("Account created successfully!");
    }

    private static void deposit(Scanner scanner) {
        if (currentAccount == null) {
            System.out.println("No account found.Please create an account ");
            return;
        }
        System.out.print("Enter deposit amount: ");
        double amount = scanner.nextDouble();
        currentAccount.deposit(amount);
    }

    private static void withdraw(Scanner scanner) {
        if (currentAccount == null) {
            System.out.println("No account found. Please create an account.");
            return;
        }
        System.out.print("Enter withdrawal amount: ");
        double amount = scanner.nextDouble();
        try {
            currentAccount.withdraw(amount);
        } catch (InsufficientFundsException e) {
            System.out.println(e.getMessage());
        }
    }

    private static void checkBalance() {
        if (currentAccount != null) {
            System.out.println("Current balance: " + currentAccount.getBalance());
        } else {
            System.out.println("No account found. Please create an account.");
        }
    }

    private static void viewTransactionHistory() {
        if (currentAccount != null) {
            currentAccount.viewTransactionHistory();
        } else {
            System.out.println("No account found. Please create an account .");
        }
    }
}
    

