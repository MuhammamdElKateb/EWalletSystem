package Service;

import Model.Account;

public interface ValidationService {
    boolean isValidUserName(String userName);
    boolean isValidPassword(String password);
    boolean isValidAge(int age);
    boolean isValidPhoneNumber(String phoneNumber);

   public Account validateCreateAccount();
   public  Account validateLoginAccount();
}
