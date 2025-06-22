package Service;

import Model.Account;

public interface AccService {
    boolean signUp(Account account);
    boolean login(Account account);
    int checkIfAccountExists(Account account);
    boolean deposit(Account account, double money);
    int withDraw(Account account, double money);
    int transfer(Account account, Account accountTo, double money);
    Account getAccount(Account account);
}

