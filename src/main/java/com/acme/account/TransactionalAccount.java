package com.acme.account;

import java.util.ArrayList;
import java.util.List;

/**
 * TransactionalAccount extends the basic account model to support:
 * - Cash deposits/withdrawals
 * - Stock deposits/withdrawals
 * - Transaction history
 *
 * Requirements:
 * - Stocks must be whole units
 * - No persistence
 * - Balance = cashBalance + stockBalance * STOCK_PRICE
 */
public class TransactionalAccount implements Account {

	private int totalTransactions = 1;

	private double totalCashDeposits = 0;
	private double totalCashWithdrawals = 0;

	private int totalStockDeposits = 0;
	private int totalStockWithdrawals = 0;

	private List<String> history = new ArrayList<>();
	private static final double STOCK_PRICE = 5.0;

	public TransactionalAccount() {}

	/** Records a transaction in history and prints it to console. */
	private void recordTransaction(String message) {
		history.add("Transaction #" + totalTransactions + ": " + message);
		System.out.println(message);
		totalTransactions++;
	}

	@Override
	public void deposit(double amount, TransactionType type) {

		// Deposits should be positive
		if (amount <= 0.0) {
			System.out.println("Deposit amount must be positive.");
			return;
		}
		
		if (type == TransactionType.CASH) {
			totalCashDeposits += amount;
			recordTransaction("Deposited $" + amount);
    	} else if (type == TransactionType.STOCK) {

			// Stocks must be whole-number units
			if (amount % 1 != 0) {
				System.out.println("Stock units must be a whole number.");
				return;
			}
    		int units = (int) amount;
			totalStockDeposits += units;
			recordTransaction("Deposited " + units + " stock units at price $" + STOCK_PRICE);
    	} else {
            System.out.println("Only cash or stock deposits are supported.");
        }
	}

	@Override
	public void withdraw(double amount, TransactionType type) {

		// Withdrawals must be positive
		if (amount <= 0.0) {
			System.out.println("Withdrawal amount must be positive.");
			return;
		}
		
		if (type == TransactionType.CASH) {

			double cashBalance = totalCashDeposits - totalCashWithdrawals;

			if (amount > cashBalance) {
				System.out.println("Insufficient cash balance.");
				return;
			}

			totalCashWithdrawals += amount;
			recordTransaction("Withdrew $" + amount);
			return;
		}
		
		if (type == TransactionType.STOCK) {

			// Stocks must be whole units
			if (amount % 1 != 0) {
				System.out.println("Stock units must be a whole number.");
				return;
			}

			int units = (int) amount;
			int stockBalance = totalStockDeposits - totalStockWithdrawals;
			if (units > stockBalance) {
				System.out.println("Insufficient stock balance.");
				return;
			}

			totalStockWithdrawals += units;
			recordTransaction("Withdrew " + units + " stock units at price $" + STOCK_PRICE);
			return;
		}

		System.out.println("Only cash or stock withdrawals are supported.");
		
	}

	@Override
	public double getBalance() {
		double cashBalance = totalCashDeposits - totalCashWithdrawals;
		double stockBalance = (totalStockDeposits - totalStockWithdrawals) * STOCK_PRICE;

		return cashBalance + stockBalance;
	}

	@Override
	public String getHistory() {
		StringBuilder fullHistory = new StringBuilder();

		for (int i = 0; i < history.size(); i ++ ) {
			fullHistory.append(history.get(i));
            fullHistory.append(System.lineSeparator()); 
		}
		return fullHistory.toString();
	}

}
