package Assisment2;

import java.util.Scanner;

import java.util.Scanner;

interface Banking{
    void deposit(double amount);
    void withdraw(double amount);
    double getBalance();
}

interface Customer{
    void showCustomer();
}

class InsufficientBalanceException extends RuntimeException{
    InsufficientBalanceException(String msg){
        super(msg);
    }
}

class BankAccount implements Banking,Customer{

    private int accNo;
    private String name;
    private double balance;

    BankAccount(int accNo,String name,double balance){
        this.accNo = accNo;
        this.name = name;
        this.balance = balance;
    }

    public void deposit(double amount){
        if(amount <= 0){
            throw new IllegalArgumentException("Invalid Amount");
        }
        balance += amount;
    }

    public void withdraw(double amount){
        if(amount > balance){
            throw new InsufficientBalanceException("Insufficient Balance");
        }
        balance -= amount;
    }

    public double getBalance(){
        return balance;
    }

    public void showCustomer(){
        System.out.println(accNo + " " + name + " " + balance);
    }

    public static void main(String[] args){

        try{
            BankAccount b = new BankAccount(101,"Tarun",5000);
            b.deposit(2000);
            b.withdraw(1000);
            b.showCustomer();
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
    }
}
