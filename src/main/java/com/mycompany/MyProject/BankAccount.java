/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.myproject;

import java.util.ArrayList;
import java.util.List;

public class BankAccount implements Reportable {
    private String accountNumber;
    private String accountHolderName;
    private double balance;
    private List<String> transactions;
    private Object Transaction;

    public BankAccount(String accountNumber, String accountHolderName, double deposite) {
        this.accountNumber = accountNumber;
        this.accountHolderName = accountHolderName;
        this.balance = deposite;
        this.transactions = new ArrayList<>();
       this.transactions.add("Account balance is: " + deposite);
       
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }
    public String getAccountNumber() {
        return accountNumber;
    }

   
    public void setAccountHolderName(String accountHolderName) {
        this.accountHolderName = accountHolderName;
    }
     public String getAccountHolderName() {
        return accountHolderName;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }
    public double getBalance() {
        return balance;
    }
    public List<String> getTransactions() {
        return transactions;
    }
    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
        }else {
            System.out.println("Invalid deposit amount.");
        }
    }

    public void withdraw(double amount) throws InsufficientFundsException {
        if (amount > balance) {
            throw new InsufficientFundsException("Insufficient funds for withdrawal.");
        } else {
            balance -= amount;
            
        }
    }
     
    public void displayAccountDetails() {
        System.out.println("AccountNumber is: " + accountNumber);
        System.out.println("AccountHolder is: " + accountHolderName);
        System.out.println("Current Balance is: " + balance);
    }

    public void viewTransactionHistory() {
        System.out.println("Transaction History for Account: " + accountNumber);
        for (String transaction : transactions) {
            System.out.println(transaction);
        }
    }
    public void generateAccountSummary() {
        System.out.println("Account Summary for " + accountHolderName);
        displayAccountDetails();
        viewTransactionHistory();
    }

}
