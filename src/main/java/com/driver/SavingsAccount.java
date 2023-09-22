package com.driver;

public class SavingsAccount extends BankAccount{
    double rate;
    double maxWithdrawalLimit;


    public SavingsAccount(String name, double balance, double maxWithdrawalLimit, double rate) {
        // minimum balance is 0 by default
        super(name, balance, 0);
        this.maxWithdrawalLimit = maxWithdrawalLimit;
        this.rate = rate;

    }

    public double getRate() {
        return rate;
    }

    public double getMaxWithdrawalLimit() {
        return maxWithdrawalLimit;
    }


    public void withdraw(double amount) throws Exception {
        try {
            if(amount > getBalance()){
                throw new InsufficientBalanceException("Insufficient Balance");
            }
            if(amount > this.maxWithdrawalLimit){
                throw new WithdrawLimitException("Maximum Withdraw Limit Exceed");
            }
        }
        catch (InsufficientBalanceException e){
            System.out.println(e.getMessage());
        }
        catch (WithdrawLimitException e){
            System.out.println(e.getMessage());
        }

       double remBalance = getBalance() - amount;
        setBalance(remBalance);
        // Might throw the following errors:
        // 1. "Maximum Withdraw Limit Exceed" : If the amount exceeds maximum withdrawal limit
        // 2. "Insufficient Balance" : If the amount exceeds balance

    }

    public double getSimpleInterest(int years){
        // Return the final amount considering that bank gives simple interest on current amount
        double Interest = (getBalance() * rate * years) / 100.0;
//        setBalance(getBalance() + Interest);
        return getBalance() + Interest;
    }

    public double getCompoundInterest(int times, int years){
        // Return the final amount considering that bank gives compound interest on current amount given times per year
        double compoundInterest = 0.0;
        compoundInterest = Math.pow(((100.0+rate/times)/100.0),(times*years)*1.0)*getBalance();
//        setBalance(getBalance() + compoundInterest);
        return compoundInterest;
    }

}
