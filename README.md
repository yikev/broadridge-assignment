# Broadridge Coding Assignment — Acme Financial Services

This repository contains my implementation of the **Transactional Account Application** for the Broadridge Associate Software Engineer interview process.

The goal of this assignment is to extend the existing cash‑only account system to support:

- **Cash transactions**
- **Stock transactions** (default ACME stock at $5/unit)
- **In‑memory transaction history**
- **Accurate balance calculation** (cash and stock value)
- **Session‑based state** (no persistence)

---

## 📁 Project Structure

```
src/
  main/
    java/
      com/
        acme/
          account/
            Account.java
            BasicAccount.java
            TransactionalAccount.java
            TransactionType.java
          application/
            UserInterface.java
  test/
    java/
```

---

## System Design Diagram
You can view the high-level class design and relationships here:

Excalidraw Diagram:
https://excalidraw.com/#json=vfB0vZvs08X8ww2q8F9TH,U0nkUHKjEaJgQMznI533Ng

---

## Features Implemented

### Cash & Stock Transactions  
Supports deposits and withdrawals for cash and stock.

### Transaction History  
All transactions in the session are recorded and retrievable.

### Balance Computation  
Balance formula:  
```
cashBalance = totalCashDeposits – totalCashWithdrawals
stockBalance = (unitsDeposited – unitsWithdrawn) * 5
totalBalance = cashBalance + stockBalance
```

### AccountService / Transactional Logic  
Centralized logic for processing transactions and updating balances.

### Input‑driven Menu  
Interactive UI through `UserInterface.java`.

---

## Testing
A `test` directory is provided for adding JUnit tests if desired.

---

## How to Run

From the project root:

```
cd src/main/java
javac com/acme/**/**/*.java
java com.acme.application.UserInterface
```

---

## Notes
- No external storage is used. All state resets when the app closes.
- Only the default ACME stock at $5/unit is supported.
- Additional transaction types or stock types are out of scope.

---

## Requirements Document
Included in the repository under:  
`Requirements Document.docx`

---

## Thank You
If you're reviewing this as part of the Broadridge hiring process, thank you for your time!