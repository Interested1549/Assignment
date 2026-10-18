import java.util.Scanner;

public class BankApp {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        BankAccount me = new BankAccount("Me", 500);
        BankAccount community = new BankAccount("Donate to Community", 0);
        boolean show = true;
        int choice = 0;
        while (choice != 5) {
            System.out.println("\n=== MONEY BANK ===");
            System.out.println("1. Add money");
            System.out.println("2. Donate to community");
            System.out.println("3. Show money");
            System.out.println("4. Hide/Show money");
            System.out.println("5. Exit");
            System.out.print("Choose: ");
            choice = input.nextInt();
            if (choice == 1) {
                System.out.print("Amount to add: $(pls enter int)");
                me.addMoney(input.nextInt());
            } else if (choice == 2) {
                System.out.print("Donation amount: $");
                me.transfer(community, input.nextInt());
            } else if (choice == 3) {
                if (show) {
                    System.out.println("Me: $" + me.money);
                } else {
                    System.out.println("Me: ****");
                }
            } else if (choice == 4) {
                show = !show;
                if (show) {
                    System.out.println("Money is now visible!");
                } else {
                    System.out.println("Money is now hidden!");
                }
            } else if (choice == 5) {
                System.out.println("Thank you for using Money Bank!");
            } else {
                System.out.println("Invalid choice!");
            }
        }
        input.close();
    }
}