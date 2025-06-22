package Model;

import java.util.ArrayList;
import java.util.List;

public class eWalletSys {
    private final String name="EraaSoft Wallet System";
    private static List<Account>accounts=new ArrayList<>();

    public String getName() {
        return name;
    }

    public  static List<Account> getAccounts() {
        return accounts;
    }

    public void setAccounts(List<Account> accounts) {
        this.accounts = accounts;
    }
}
