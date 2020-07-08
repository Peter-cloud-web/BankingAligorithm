package com.company;

public class BankProgram {

    public static void main(String[] args) {
	// write your code here
        //This class is responsible for putting things together according to the single responsibility rule
        BankClient program = new BankClient();
        program.run();
    }
}
