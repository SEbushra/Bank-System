package org.SEbushra;

public class Main {
    static void main() {
        int balance=0;
        String accountName=null;
        Account account = new Account.Builder()
                .setAccountNumber()
                .setBalance(balance)
                .setAccountName(accountName)
                .build();


        Bank bank=Bank.getInstance();

        bank.AddAccount(account);


        Account account1 =bank.findAccount(account.getAccountNumber());

        Bank bank1=Bank.getInstance();
        Bank bank2=Bank.getInstance();

        if(bank1==bank2){
            System.out.println("Singleton is acheived");
        }

        }
    }
