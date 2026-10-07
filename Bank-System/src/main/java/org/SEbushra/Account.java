package org.SEbushra;

public class Account {
private Integer accountNumber ;
    private String accountName;
    private int balance;

    //Builder
    public static class Builder {
        static int numberOfAccounts=0;
        private Integer  accountNumber=0 ;
        private String accountName;
        private int balance;

        public Builder setAccountNumber(){
            this.accountNumber=numberOfAccounts++;
            return this;
        }

        public Builder setAccountName(String accountName){
            this.accountName=accountName;
            return this;
        }

        public Builder setBalance(int balance){
            this.balance=balance;
            return this;
        }

        // Coupling means how much one part of the code depends on another part.
        // High coupling means that a class depends on the details of another class.
        // Low coupling means that a class can work with another class without
        // needing to know its internal details.
        // For example, Account.Builder should only be responsible for creating
        // an Account. It should not need to know that Bank uses a HashMap to store
        // accounts. This makes it easier to change the Bank without changing the Builder.

        public Account build(){
            Account account=new Account();
            account.accountNumber=accountNumber;
            account.accountName=accountName;
            account.balance=balance;
            return account;
        }

    }

    public Integer getAccountNumber(){
        return accountNumber;
    }

    public void deposit (int money){
        this.balance+=money;
    }

    public void withdraw (int money){
        if(money<=this.balance){
            this.balance-=money;
        }
        else{
            System.out.println("your balance is less than this");
        }
    }
}
