import java.lang.reflect.Constructor;

public class BankAccount {
    private double balance;
    private int accountID;
    private String password;

    public BankAccount(int accountID, String password) {
        this.balance = 0.0;
        this.accountID = accountID;
        this.password = password;
    }

    public double getBalance() {
        return balance;
    }

    public int getAccountID() {
        return accountID;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean deposit(double amount) {
        if (amount < 0) {
            return false;
        } else {
            balance += amount;
            return true;
        }
    }

    public boolean withdraw(double amount) {
        if (amount < 0 || (balance - amount < 0)) {
            return false;
        } else {
            balance -= amount;
            return true;
        }
    }

    public String toString() {
        return ("#" + accountID + "\t$" + balance);
    }

    public boolean authenticate(String password) {
        return this.password.equals(password);
    }

    public boolean transferTo(BankAccount other, double amount, String password) {
        if (authenticate(password)) {
            if (withdraw(amount)) {
                other.deposit(amount);
                return true;
            }
        }
        return false;
    }
}