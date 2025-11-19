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
```

---

## System Design Diagram
You can view the high-level class design and relationships here:

Excalidraw Diagram:
https://excalidraw.com/#json=LEpT-GBJNC9L2pdB8-ZG4,DPwwg1xItZCfBlXQMYifxA

---

## Features Implemented

### Cash & Stock Transactions  
Supports deposits and withdrawals for cash and stock.
Stock operations are done in integer units.
Stock is fixed to ACME at $5 per unit, as per the requirements.

### Transaction History  
All transactions in the session are recorded and retrievable.
History is presented in the order transactions were entered 

### Balance Computation  
Balance formula:  
```
cashBalance = totalCashDeposits – totalCashWithdrawals
stockBalance = (unitsDeposited – unitsWithdrawn) * 5
totalBalance = cashBalance + stockBalance
```

### Transactional Logic  
TransactionalAccount centralizes the logic for applying transactions and updating balances.
Uses TransactionType to categorize cash versus stock operations.

### Input Validation & Error Handling
- UI validates numeric inputs using `scanner.hasNextDouble()`.
- Prevents invalid operations such as:
  - Negative amounts
  - Fractional stock units
  - Overdrafts (cash or stock)

### Interactive Console Menu  
All user interaction is implemented in `UserInterface.java`.

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