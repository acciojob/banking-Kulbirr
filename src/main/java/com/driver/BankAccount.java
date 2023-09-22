package com.driver;

public class BankAccount {

    private String name;
    private double balance;
    private double minBalance;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public double getMinBalance() {
        return minBalance;
    }

    public void setMinBalance(double minBalance) {
        this.minBalance = minBalance;
    }


    public BankAccount(String name, double balance, double minBalance) {
        this.name = name;
        this.balance = balance;
        this.minBalance = minBalance;
    }

    public String generateAccountNumber(int digits, int sum) throws Exception{
        //Each digit of an account number can lie between 0 and 9 (both inclusive)
        //Generate account number having given number of 'digits' such that the sum of digits is equal to 'sum'
        //If it is not possible, throw "Account Number can not be generated" exception
        if (sum > 9 * digits || sum < digits) {
            throw new Exception("Account Number can not be generated");
        }

        // Generate the account number
        StringBuilder accountNumber = new StringBuilder(digits);

        for (int i = 0; i < digits; i++) {
            int maxDigitValue = Math.min(9, sum - (digits - i - 1));
            int digit = (int) (Math.random() * (maxDigitValue + 1)); // Generate a random digit
            accountNumber.append(digit);
            sum -= digit;
        }

        return accountNumber.toString();
    }

    public void deposit(double amount) {
        //add amount to balance
        this.balance += amount;
//        setBalance(newBal);
    }

    public void withdraw(double amount) throws Exception {
        // Remember to throw "Insufficient Balance" exception, if the remaining amount would be less than minimum balance
        double remBalance = balance - amount;
        try {
            if(remBalance < this.minBalance){
                throw new InsufficientBalanceException("Insufficient Balance");
            }
        }
        catch (InsufficientBalanceException e){
            System.out.println(e.getMessage());
        }
        this.balance -= amount;
//        setBalance(remBalance);
    }

}