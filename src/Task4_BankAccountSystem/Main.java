package Task4_BankAccountSystem;

public class Main{
    public static void main(String[] args) {
        BankAccount acc1 = new BankAccount("101", "Priya", 1000);
        acc1.deposit(500);
        System.out.println("Deposit Test: " + (acc1.getBalance() == 1500 ? "Passed" : "Failed"));

        BankAccount acc2 = new BankAccount("102", "Hari", 1000);
        acc2.withdraw(300);
        System.out.println("Withdraw Test: " + (acc2.getBalance() == 700 ? "Passed" : "Failed"));

        BankAccount acc3 = new BankAccount("103", "Ram", 500);
        try {
            acc3.withdraw(600);
            System.out.println("Overdraw Test: Failed");
        } catch (IllegalArgumentException e) {
            System.out.println("Overdraw Test: " + (e.getMessage().equals("Insufficient balance") ? "Passed" : "Failed"));
        }

        BankAccount acc4 = new BankAccount("104", "Anu", 500);
        try {
            acc4.deposit(-100);
            System.out.println("Negative Deposit Test: Failed");
        } catch (IllegalArgumentException e) {
            System.out.println("Negative Deposit Test: " + (e.getMessage().equals("Deposit amount must be positive") ? "Passed" : "Failed"));
        }
    }
}
