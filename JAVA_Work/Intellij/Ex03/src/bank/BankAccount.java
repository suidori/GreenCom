package bank;

public class BankAccount {

    int balance = 0;
    String name ="";
    BankAccount(String n){
        name = n;
    }

    public int checkMyBalance() {
        System.out.println(name + "의 잔액 " + balance);
        return balance;
    }

    public void deposit(int amount) {
        balance += amount;
    }

    public void withdraw(int amount) {
        balance -= amount;
    }
}