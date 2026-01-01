package MiniProject1;

import java.io.*;
import java.util.Scanner;

abstract class BankAccount{

    private final int accountNo;
    private String name;
    protected double balance;

    BankAccount(int accountNo,String name,double balance){
        this.accountNo = accountNo;
        this.name = name;
        this.balance = balance;
    }

    public int getAccountNo(){
        return accountNo;
    }

    public String getName(){
        return name;
    }

    public double getBalance(){
        return balance;
    }

    void deposit(double amount){
        if(amount <= 0){
            System.out.println("Invalid Amount");
            return;
        }
        balance += amount;
    }

    void deposit(double amount,String note){
        deposit(amount);
        System.out.println(note);
    }

    void withdraw(double amount){
        if(amount > balance){
            System.out.println("Insufficient Balance");
            return;
        }
        balance -= amount;
    }

    void showAccount(){
        System.out.println(accountNo + " " + name + " " + balance);
    }

    String toFileString(){
        return accountNo + "," + name + "," + balance + "," + getClass().getSimpleName();
    }
}

class SavingsAccount extends BankAccount{
    SavingsAccount(int accNo, String name, double balance){
        super(accNo, name, balance);
    }
}

class CurrentAccount extends BankAccount{
    CurrentAccount(int accountNo, String name, double balance){
        super(accountNo, name, balance);
    }
}

class BankFile{
    static void save(BankAccount acc){
        try{
            FileWriter fw = new FileWriter("bank.txt");
            fw.write(acc.toFileString());
            fw.close();
        }
        catch(Exception e){
            System.out.println("File Write Error");
        }
    }

    static BankAccount load(){
        try{
            BufferedReader br = new BufferedReader(new FileReader("bank.txt"));
            String line = br.readLine();
            br.close();

            if(line == null){
                return null;
            }

            String[] data = line.split(",");
            int accNo = Integer.parseInt(data[0]);
            String name = data[1];
            double balance = Double.parseDouble(data[2]);
            String type = data[3];

            if(type.equals("SavingsAccount")){
                return new SavingsAccount(accNo,name,balance);
            }

            return new CurrentAccount(accNo,name,balance);

        }
        catch(Exception e){
            return null;
        }
    }
}

public class BankManagementSystem{

    public static void main(String[] args){

        Scanner sc = new Scanner(System.in);
        BankAccount account = null;

        System.out.println("1.Create Savings\n 2.Create Current");
        int type = sc.nextInt();

        System.out.print("Enter AccNo Name Balance: ");
        int accNo = sc.nextInt();
        String name = sc.next();
        double bal = sc.nextDouble();

        if(type == 1){
            account = new SavingsAccount(accNo,name,bal);
        }
        else if(type == 2){
            account = new CurrentAccount(accNo,name,bal);
        }

        BankFile.save(account);

        BankAccount acc = BankFile.load();

        System.out.println("1.Deposit 2.Withdraw 3.Balance 4.Details");
        int choice = sc.nextInt();

        if(choice == 1){
            acc.deposit(sc.nextDouble(),"Deposited");
        }
        else if(choice == 2){
            acc.withdraw(sc.nextDouble());
        }
        else if(choice == 3){
            System.out.println("Balance = " + acc.getBalance());
        }
        else if(choice == 4){
            acc.showAccount();
        }

        BankFile.save(acc);
        sc.close();
    }
}

