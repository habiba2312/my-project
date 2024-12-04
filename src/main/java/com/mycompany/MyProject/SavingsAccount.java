/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.myproject;

/**
 *
 * @author dell
 */
public class SavingsAccount extends BankAccount {
    private static final double MINIMUM_BALANCE = 100;

    public SavingsAccount(String accountNumber, String accountHolderName, double deposite) {
        super(accountNumber, accountHolderName, deposite);
    }

    @Override
    public void withdraw(double amount) throws InsufficientFundsException {
        if (getBalance() - amount < MINIMUM_BALANCE) {
            throw new InsufficientFundsException("Withdrawa under minimum required balance of " + MINIMUM_BALANCE);
        } else {
            super.withdraw(amount);
        }
    }
    public void applyInterest() {
        double interestRate = 0.04;  
        double interest = getBalance() * interestRate;
        deposit(interest);
        Transaction("Interest applied: " + interest);
    }

    private void Transaction(String string) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

}

