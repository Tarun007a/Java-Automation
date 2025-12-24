package Assisment1;

import java.util.Scanner;

class BankAccount{
    String name;
    int accountNumber;
    double balance;

    void createAccount(String n, int accNo, double bal){
        name = n;
        accountNumber = accNo;
        balance = bal;
    }

    void deposit(double amount){
        if (amount <= 0) {
            System.out.println("Invalid deposit amount");
            return;
        }
        balance = balance + amount;
        System.out.println("Amount deposited");
    }

    void withdraw(double amount){
        if (amount <= 0 || amount > balance){
            System.out.println("Invalid amount");
            return;
        }
        balance = balance - amount;
        System.out.println("Amount withdrawn");
    }

    void showBalance(){
        System.out.println("Balance = " + balance);
    }

    void displayDetails() {
        System.out.println("Account Holder Name: " + name);
        System.out.println("Account Number: " + accountNumber);
        System.out.println("Balance: " + balance);
    }
}

class BankManagement {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        BankAccount account = new BankAccount();
        int choice;

        do {
            System.out.println("1.Create Account 2.Deposit 3.Withdraw 4.Balance 5.Details 6.Exit");
            System.out.print("Enter choice: ");
            choice = sc.nextInt();

            if (choice == 1) {
                System.out.print("Enter name: ");
                sc.nextLine();
                String name = sc.nextLine();

                System.out.print("Enter account number: ");
                int accNo = sc.nextInt();

                System.out.print("Enter initial balance: ");
                double bal = sc.nextDouble();

                account.createAccount(name, accNo, bal);
            }
            else if (choice == 2){
                System.out.print("Enter deposit amount: ");
                account.deposit(sc.nextDouble());
            }
            else if (choice == 3){
                System.out.print("Enter withdrawal amount: ");
                    account.withdraw(sc.nextDouble());
            }
            else if (choice == 4){
                account.showBalance();
            }
            else if (choice == 5){
                account.displayDetails();
            }
            else if (choice == 6){
                System.out.println("Program exited");
            }
            else {
                System.out.println("Invalid choice");
            }
        } while (choice != 6);
    }
}
