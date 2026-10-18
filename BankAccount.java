public class BankAccount {
    String name;
    double money;
    // Constructor
    public BankAccount(String name, double money) {
        this.name = name;
        this.money = money;
    }
    // Add money
    public void addMoney(int amount) {
        if (amount > 0) {
            money += amount;
            System.out.println("Money added successfully!");
        } else {
            System.out.println("Invalid amount!");
        }
    }
    // Transfer money
    public void transfer(BankAccount other, int amount) {
        if (amount > 0 && amount <= money) {
            money -= amount;
            other.money += amount;
            System.out.println("Transfer successful!");
        } else {
            System.out.println("Invalid amount!");
        }
    }
}