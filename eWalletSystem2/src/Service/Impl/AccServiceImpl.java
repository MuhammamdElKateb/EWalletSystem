package Service.Impl;

import Model.Account;
import Service.AccService;
import Model.eWalletSys;
import java.util.List;

public class AccServiceImpl implements AccService {


    @Override
    public boolean signUp(Account account) {
        if (checkIfAccountExists(account) != -1) {
            return false;
        }
        eWalletSys.getAccounts().add(account);
        return true;
    }

    @Override
    public boolean login(Account account) {
        List<Account>accounts=eWalletSys.getAccounts();
        for (Account acc:accounts) {
            if(acc.getName().equals(account.getName()) && acc.getPassword().equals(account.getPassword())) {
                return true;
            }
        }
        return false;
    }

    @Override
    public int checkIfAccountExists(Account account) {
        List<Account> accounts=eWalletSys.getAccounts();
        for(int i=0;i<accounts.size();i++){
            if(accounts.get(i).getName().equals(account.getName())){
                return i;
            }
        }
        return -1;
    }

    @Override
    public boolean deposit(Account account, double money) {
        int accountIndex=checkIfAccountExists(account);
        if(accountIndex==-1){
            return false;
        }
        eWalletSys.getAccounts().get(accountIndex).setBalance(eWalletSys.getAccounts().get(accountIndex).getBalance()+money);
        return true;
    }

    @Override
    public int withDraw(Account account, double money) {
        int accountIndex=checkIfAccountExists(account);
        if(accountIndex==-1){
            return 1;
        }else if(!(eWalletSys.getAccounts().get(accountIndex).getBalance()>=money)){
            return 2;
        }
        eWalletSys.getAccounts().get(accountIndex).setBalance(eWalletSys.getAccounts().get(accountIndex).getBalance()-money);
        return 3;
    }

    @Override
    public int transfer(Account account, Account accountTo, double money) {
        int accountIndex=checkIfAccountExists(account);
        if(accountIndex==-1){
            return 1;
        }
        int accountToIndex=checkIfAccountExists(accountTo);
         if(accountToIndex==-1){
            return 2;
        }
         if(!(eWalletSys.getAccounts().get(accountIndex).getBalance()>=money)){
             return 3;
         }
         eWalletSys.getAccounts().get(accountIndex).setBalance(eWalletSys.getAccounts().get(accountIndex).getBalance()-money);
         eWalletSys.getAccounts().get(accountToIndex).setBalance(eWalletSys.getAccounts().get(accountToIndex).getBalance()+money);
        return 4;
    }

    @Override
    public Account getAccount(Account account) {
        int accountIndex=checkIfAccountExists(account);
        if(accountIndex==-1){
            return null;
        }
        return eWalletSys.getAccounts().get(accountIndex);
    }
}
