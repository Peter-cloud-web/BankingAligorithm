package com.company;

import java.util.Scanner;

public class BankClient {
    //This class is responsible for I/O according to the single responsibility rule
    private int current = -1;
    private Scanner scanner = new Scanner(System.in);
    private boolean done = false;
    private Bank bank = new Bank();

    public void run() {
            scanner = new Scanner(System.in);
            while(!done){
                System.out.println("Enter Command(0 = Quit,1 = New, 2 = Select, 3 = Deposit, 4 = Loan, 5 = Show, 6 = Interest)");
                int cmd = scanner.nextInt();
                processCommand(cmd);
            }
            scanner.close();

    }
    private void processCommand(int cmd) {
        if (cmd == 0) quit();
        else if (cmd == 1) newAccount();
        else if (cmd == 2) select();
        else if (cmd == 3) deposit();
        else if (cmd == 4) authorizeLoan();
        else if (cmd == 5) showAll();
        else if (cmd == 6) addInterest();
        else
            System.out.println("illegal command");
    }
    private void quit() {
        done = true;
        System.out.println("Goodbye");
    }
    private void newAccount(){
        current = bank.newAccount();
        System.out.println("Your new account number is " + current);

    }
    private void select(){
        System.out.println("Enter acct#:");
        current = scanner.nextInt();
        int balance = bank.getBalance(current);
        System.out.println("The balance of account " + current + " is " + balance);
    }
    private void deposit(){
        System.out.println("Enter deposit amount:");
        int amt = scanner.nextInt();
        bank.deposit(current,amt);
    }
    private void authorizeLoan() {
        System.out.print("Enter loan amt: ");
        int loanamt = scanner.nextInt();
        if (bank.authorizeLoan(current, loanamt))
            System.out.println("Your loan is approved");
        else
            System.out.println("Your loan is denied");
    }
    private void showAll() {
        System.out.println(bank.toString());
    }
    private void addInterest() {
        bank.addInterest();
    }



}
