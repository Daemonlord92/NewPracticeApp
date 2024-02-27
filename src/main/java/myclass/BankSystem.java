package myclass;

import lombok.Data;
import lombok.Getter;

import java.util.ArrayList;

@Data
@Getter
public class BankSystem implements IBankSystem{
    private float checkingAccount;
    private float savingAccount;
    private float creditAccount;
    private boolean isCheckingLocked = false;
    private boolean isSavingLocked = false;
    private boolean isCreditLocked = false;
    private ArrayList<Transaction> checkingTransactions = new ArrayList<Transaction>();
    private  ArrayList<Transaction> savingTransactions = new ArrayList<Transaction>();
    private ArrayList<Transaction> creditTransactions = new ArrayList<Transaction>();

    public BankSystem(float startCheckingAmount,
                      float startSavingAmount,
                      float startCreditAmount) {
        Transaction newChecking = new Transaction();
        Transaction newSaving = new Transaction();
        Transaction newCredit = new Transaction();
        newChecking.setTransactionId(0);
        newChecking.setTransactionAmount(startCheckingAmount);
        newChecking.setTransactionFrom("New Account Setup");
        newChecking.setTransactionTo("Checking Account");
        newSaving.setTransactionId(0);
        newSaving.setTransactionAmount(startSavingAmount);
        newSaving.setTransactionFrom("New Account Setup");
        newSaving.setTransactionTo("Saving Account");
        newCredit.setTransactionId(0);
        newCredit.setTransactionAmount(startCreditAmount);
        newCredit.setTransactionFrom("NewAccountSetup");
        newCredit.setTransactionTo("Credit Account");
        checkingTransactions.add(newChecking);
        savingTransactions.add(newSaving);
        creditTransactions.add(newCredit);
        checkingAccount = startCheckingAmount;
        savingAccount = startSavingAmount;
        creditAccount = startCreditAmount;
    }

    @Override
    public void withdraw(float amount, String from, String to) throws Exception {
        Transaction newTransaction = new Transaction();

        switch (from.toLowerCase()){
            case "checking":
                if (!isCheckingLocked) {
                    newTransaction.setTransactionId(checkingTransactions.get(checkingTransactions.size()-1).getTransactionId() + 1);
                    newTransaction.setTransactionFrom("Checking Account");
                    newTransaction.setTransactionAmount(amount);
                    checkingAccount -= amount;
                    break;
                } else {
                    throw new Exception("Account Locked!");
                }
            case "saving":
                if (!isSavingLocked) {
                    newTransaction.setTransactionId(savingTransactions.get(savingTransactions.size()-1).getTransactionId() + 1);
                    newTransaction.setTransactionFrom("Saving Account");
                    newTransaction.setTransactionAmount(amount);
                    savingAccount -= amount;
                    break;
                } else {
                    throw new Exception("Account Locked!");
                }
            case "credit":
                if(!isCreditLocked) {
                    newTransaction.setTransactionId(creditTransactions.get(creditTransactions.size() - 1).getTransactionId() + 1);
                    newTransaction.setTransactionFrom("Credit Account");
                    newTransaction.setTransactionAmount(amount);
                    creditAccount -= amount;
                    break;
                } else {
                    throw new Exception("Account Locked!");
                }
        }

        switch (to.toLowerCase()) {
            case "checking":
                newTransaction.setTransactionTo("Checking Account");
                checkingTransactions.add(newTransaction);
                checkingAccount = checkingAccount - amount;
                break;
            case "saving":
                newTransaction.setTransactionTo("Saving Account");
                savingTransactions.add(newTransaction);
                savingAccount = savingAccount - amount;
                break;
            case "credit":
                newTransaction.setTransactionTo("Credit Account");
                creditTransactions.add(newTransaction);
                creditAccount = creditAccount - amount;
                break;
        }
    }

    @Override
    public void deposit(float amount, String to) throws Exception {
        Transaction newTransaction = new Transaction();
        newTransaction.setTransactionFrom("Deposit");
        switch (to.toLowerCase()) {
            case "checking":
                if (!isCheckingLocked) {
                    newTransaction.setTransactionTo("Checking Account");
                    checkingTransactions.add(newTransaction);
                    checkingAccount = checkingAccount + amount;
                    break;
                } else {
                    throw new Exception("Account Locked!");
                }
            case "saving":
                if (!isSavingLocked) {
                    newTransaction.setTransactionTo("Saving Account");
                    savingTransactions.add(newTransaction);
                    savingAccount = savingAccount + amount;
                    break;
                } else {
                    throw new Exception("Account Locked!");
                }
            case "credit":
                if(!isCreditLocked) {
                    newTransaction.setTransactionTo("Credit Account");
                    creditTransactions.add(newTransaction);
                    creditAccount = creditAccount + amount;
                    break;
                } else {
                    throw new Exception("Account Locked!");
                }
        }
    }

    @Override
    public void viewAccountBalance() {
        System.out.println("Checking: " + checkingAccount);
        System.out.println("Saving: " + savingAccount);
        System.out.println("Credit: " + creditAccount);
    }

    @Override
    public void getTransactions(ArrayList<Transaction> transactions) {
        for (Transaction transaction : transactions) {
            System.out.println(transaction.toString());
        }
    }
}
