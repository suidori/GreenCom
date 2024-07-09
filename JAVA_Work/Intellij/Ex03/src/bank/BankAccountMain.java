package bank;

public class BankAccountMain {
    public static void main(String[] args) {
        System.out.println("새로운 시작");

        BankAccount park = new BankAccount("박");
        BankAccount yoon = new BankAccount("윤");

        park.checkMyBalance();
        park.deposit(3000);
        park.checkMyBalance();

        yoon.checkMyBalance();
        yoon.deposit(4000);
        yoon.checkMyBalance();

        park.withdraw(1000);
        yoon.withdraw(2000);

        park.checkMyBalance();
        yoon.checkMyBalance();

        System.out.println("시스템 종료");
    }
}
