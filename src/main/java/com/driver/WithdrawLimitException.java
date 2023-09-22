package com.driver;

public class WithdrawLimitException extends Exception {

    public WithdrawLimitException(String message){
        super(message);
    }
}
