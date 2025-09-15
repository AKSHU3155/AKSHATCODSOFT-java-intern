import java.util.Scanner;

public class atmPro {

    // Class to represent Bank Account
    static class BankAccount {
        private double balance;

        // Constructor
        public BankAccount(double initialBalance) {
            this.balance = initialBalance;
        }

        // Deposit method
        public String deposit(double amount) {
            if (amount > 0) {
                balance += amount;
                return "✅ Deposited: ₹" + amount + ". Current Balance: ₹" + balance;
            } else {
                return "❌ Invalid deposit amount.";
            }
        }

        // Withdraw method
        public String withdraw(double amount) {
            if (amount <= 0) {
                return "❌ Invalid withdrawal amount.";
            } else if (amount > balance) {
                return "❌ Insufficient balance.";
            } else {
                balance -= amount;
                return "✅ Withdrawn: ₹" + amount + ". Current Balance: ₹" + balance;
            }
        }

        // Check balance method
        public String checkBalance() {
            return "💰 Current Balance: ₹" + balance;
        }
    }

    // Class to represent ATM
    static class ATM {
        private BankAccount account;
        private Scanner scanner;

        public ATM(BankAccount account) {
            this.account = account;
            this.scanner = new Scanner(System.in);
        }

        // Display ATM Menu
        public void displayMenu() {
            System.out.println("\n===== ATM MENU =====");
            System.out.println("1. Withdraw");
            System.out.println("2. Deposit");
            System.out.println("3. Check Balance");
            System.out.println("4. Exit");
            System.out.println("====================");
        }

        // Run ATM
        public void run() {
            while (true) {
                displayMenu();
                System.out.print("👉 Enter your choice: ");
                String choice = scanner.nextLine();

                switch (choice) {
                    case "1":
                        System.out.print("💵 Enter amount to withdraw: ");
                        try {
                            double amount = Double.parseDouble(scanner.nextLine());
                            System.out.println(account.withdraw(amount));
                        } catch (NumberFormatException e) {
                            System.out.println("❌ Please enter a valid number.");
                        }
                        break;

                    case "2":
                        System.out.print("💵 Enter amount to deposit: ");
                        try {
                            double amount = Double.parseDouble(scanner.nextLine());
                            System.out.println(account.deposit(amount));
                        } catch (NumberFormatException e) {
                            System.out.println("❌ Please enter a valid number.");
                        }
                        break;

                    case "3":
                        System.out.println(account.checkBalance());
                        break;

                    case "4":
                        System.out.println("👋 Thank you for using ATM. Goodbye!");
                        return;

                    default:
                        System.out.println("❌ Invalid choice. Please try again.");
                }
            }
        }
    }

    // Main method
    public static void main(String[] args) {
        BankAccount userAccount = new BankAccount(1000); // Initial balance ₹1000
        ATM atm = new ATM(userAccount);
        atm.run();
    }
}
