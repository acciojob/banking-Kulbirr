package com.driver;

public class SavingsAccount extends BankAccount{
    double rate;
    double maxWithdrawalLimit;

    public double getRate() {
        return rate;
    }

    public void setRate(double rate) {
        this.rate = rate;
    }

    public double getMaxWithdrawalLimit() {
        return maxWithdrawalLimit;
    }

    public void setMaxWithdrawalLimit(double maxWithdrawalLimit) {
        this.maxWithdrawalLimit = maxWithdrawalLimit;
    }

    public SavingsAccount(String name, double balance, double maxWithdrawalLimit, double rate) {
        // minimum balance is 0 by default
        super(name, balance);
        this.maxWithdrawalLimit = maxWithdrawalLimit;
        this.rate = rate;

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
        double Interest = (getBalance() * this.rate * years) / 100;
        setBalance(getBalance() + Interest);
        return getBalance();
    }

    public double getCompoundInterest(int times, int years){
        // Return the final amount considering that bank gives compound interest on current amount given times per year
        double compoundInterest = getBalance()*(1+this.rate/times)*(times*years);
        setBalance(getBalance() + compoundInterest);
        return getBalance();
    }

}
