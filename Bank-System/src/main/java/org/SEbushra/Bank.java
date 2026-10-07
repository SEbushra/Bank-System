package org.SEbushra;

import java.util.HashMap;
import java.util.Map;

public class Bank {
    // The bank instance is static because getInstance() is a static method.
    private static Bank bank = null;

     private  Map<Integer,Account> accountMap = new HashMap<Integer,Account>();

    private Bank() {

    }

    // A static method belongs to the class, not to a specific object,
    // so it can only access static members directly.
    // Making bank static allows getInstance() to store and return
    // the single shared Bank instance.
    public static Bank getInstance() {
        if(bank==null){
            bank = new Bank();
        }
        return bank;
    }

    public  void AddAccount(Account account){
        accountMap.put(account.getAccountNumber(),account);
    }

    public Account findAccount(Integer accountNumber){
        return accountMap.get(accountNumber);
    }

}
