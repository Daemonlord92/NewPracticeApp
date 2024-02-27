package myclass;

import java.util.ArrayList;

public interface IBankSystem {
    public void withdraw(float amount, String from, String to) throws Exception;
    public void deposit(float amount, String to) throws Exception;
    public void viewAccountBalance();
    public void getTransactions(ArrayList<Transaction> transactions);
}
