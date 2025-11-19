package com.acme.application;

import java.util.Scanner;
import com.acme.account.TransactionalAccount;
import com.acme.account.TransactionType;
import com.acme.account.Account;

public class UserInterface {

    // Transactional Account

    private static Double readAmount(Scanner scanner, String prompt) {
        System.out.print(prompt);
        if (!scanner.hasNextDouble()) {
            System.out.println("Invalid amount. Please enter a number.");
            scanner.next();
            return null;
        }
        return scanner.nextDouble();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        Double depositAmount;
        Double withdrawAmount;

        // Create a new account with an initial balance of $1000
        Account account = new TransactionalAccount();

        while (true) {
            System.out.println("\n-- Acme Financial Menu --");
            System.out.println("1. Cash - Deposit");
            System.out.println("2. Cash - Withdraw");
            System.out.println("3. Stock - Deposit");
            System.out.println("4. Stock - Withdraw");
            System.out.println("5. Check Balance");
            System.out.println("6. Get History");
            System.out.println("7. Exit");
            System.out.print("Choose an option: ");

            if (!scanner.hasNextInt()) {
                System.out.println("Invalid amount. Please enter a number.");
                scanner.next();
                continue;
            }
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    depositAmount = readAmount(scanner, "Cash - Enter amount to deposit: ");
                    if (depositAmount != null) {
                        account.deposit(depositAmount, TransactionType.CASH);
                    }
                    break;

                case 2:
                    withdrawAmount = readAmount(scanner, "Cash - Enter amount to withdraw: ");
                    if (withdrawAmount != null) {
                        account.withdraw(withdrawAmount, TransactionType.CASH);
                    }
                    break;
                    
                case 3:
                    depositAmount = readAmount(scanner, "Stock - Enter amount to deposit: ");
                    if (depositAmount != null) {
                        account.deposit(depositAmount, TransactionType.STOCK);
                    }
                    break;

                case 4:
                    withdrawAmount = readAmount(scanner, "Stock - Enter amount to withdraw: ");
                    if (withdrawAmount != null) {
                        account.withdraw(withdrawAmount, TransactionType.STOCK);
                    }
                    break;

                case 5:
                    System.out.print("Current Balance: $" + account.getBalance());
                    break;
                    
                case 6:
                    System.out.print("Transaction History: \n" + account.getHistory());
                    break;

                case 7:
                    System.out.println("Exiting the program...");
                    scanner.close();
                    return;

                default:
                    System.out.println("Invalid choice! Please choose a valid option.");
            }
        }
    }
}