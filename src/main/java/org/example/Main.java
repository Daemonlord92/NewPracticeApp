package org.example;

import myclass.BankSystem;
import myclass.MyClass;
import myclass.PlayerClass;

import java.util.Scanner;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) throws Exception {
        System.out.println(MyClass.rollDice(100));
        System.out.println("Banking System Prototype");
        BankSystem bankSystem = new BankSystem(50000.0f, 50000.0f, 50000.0f);
        Scanner scan = new Scanner(System.in);
        String answer, from, to;
        float amount;
        while (true) {
            System.out.println("Welcome to the Banking System!");
            System.out.println("What would you like todo");
            System.out.println("1. Withdraw Funds");
            System.out.println("2. Deposit Funds");
            System.out.println("3. View Transactions");
            System.out.println("4. View Account Balances");
            System.out.println("5. Lock/Unlock Accounts");
            System.out.println("6. Exit");
            answer = scan.nextLine();
            switch (answer) {
                case "1":
                    System.out.println("Where would you like to withdraw from");
                    from = scan.nextLine();
                    System.out.println("Where would you like to deposit the money at");
                    to = scan.nextLine();
                    System.out.println("The Amount");
                    amount = scan.nextFloat();
                    try {
                        bankSystem.withdraw(amount, from, to);
                    } catch (Exception exception) {
                        System.out.println(exception.getMessage());
                    }
                    scan.nextLine();
                    break;
                case "2":
                    System.out.println("Where would you like to deposit the money to");
                    to = scan.nextLine();
                    System.out.println("The Amount");
                    amount = scan.nextFloat();
                    try {
                        bankSystem.deposit(amount, to);
                    } catch (Exception exception) {
                        System.out.println(exception.getMessage());
                    }
                    scan.nextLine();
                    break;
                case "3":
                    System.out.println("What account Transactions would you like to view?");
                    answer = scan.nextLine();
                    switch (answer.toLowerCase())
                    {
                        case "checking":
                            bankSystem.getTransactions(bankSystem.getCheckingTransactions());
                            break;
                        case "saving":
                            bankSystem.getTransactions(bankSystem.getSavingTransactions());
                            break;
                        case "credit":
                            bankSystem.getTransactions(bankSystem.getCreditTransactions());
                            break;
                    }
                    break;
                case "4":
                    bankSystem.viewAccountBalance();
                    break;
                case "5":
                    System.out.println("Which account should we lock");
                    System.out.println("1. Checking");
                    System.out.println("2. Saving");
                    System.out.println("3. Credit");
                    answer = scan.nextLine();
                    switch (answer) {
                        case "1":
                            bankSystem.setCheckingLocked(bankSystem.isCheckingLocked() ? false : true);
                            if (bankSystem.isCheckingLocked()) {
                                System.out.println("Account Successfully Locked!");
                            } else {
                                System.out.println("Account Successfully Unlocked!");
                            }
                            break;
                        case "2":
                            bankSystem.setSavingLocked(bankSystem.isSavingLocked() ? false : true);
                            if (bankSystem.isSavingLocked()) {
                                System.out.println("Account Successfully Locked!");
                            } else {
                                System.out.println("Account Successfully Unlocked!");
                            }
                            break;
                        case "3":
                            bankSystem.setCreditLocked(bankSystem.isCreditLocked() ? false : true);
                            if (bankSystem.isCreditLocked()) {
                                System.out.println("Account Successfully Locked!");
                            } else {
                                System.out.println("Account Successfully Unlocked!");
                            }
                            break;
                    }
                    break;
                case "6":
                    System.exit(0);
            }
        }
    }
}