package Service.Impl;

import Model.Account;
import Service.AppService;
import Service.ValidationService;

import java.util.Scanner;

public class VaildationServiceImpl implements ValidationService {
    Scanner sc = new Scanner(System.in);
    @Override
    public boolean isValidUserName(String userName) {
        if(userName.length()>=3&&Character.isUpperCase(userName.charAt(0))) {
            return true;
        }
        return false;
    }

    @Override
    public boolean isValidPassword(String password) {
        boolean hasUpper=false;
        boolean hasLower=false;
        boolean hasNumber=false;
        boolean hasSpecial=false;
        for(int i = 0; i < password.length(); i++) {
            if(Character.isUpperCase(password.charAt(i))) {
                hasUpper=true;
            }else if(Character.isLowerCase(password.charAt(i))) {
                hasLower=true;
            }else if(Character.isDigit(password.charAt(i))) {
                hasNumber=true;
            }else if("@_-()".contains(String.valueOf(password.charAt(i)))) {
                hasSpecial=true;
            }
        }
        if(hasUpper && hasLower && hasNumber && hasSpecial) {
            return true;
        }
        return false;
    }

    @Override
    public boolean isValidAge(int age) {
        if(age>=18&&age<=80) {
            return true;
        }
        return false;
    }

    @Override
    public boolean isValidPhoneNumber(String phoneNumber) {
        if(phoneNumber.length()==12&&phoneNumber.startsWith("2")) {
            return true;
        }
        return false;
    }

    @Override
    public  Account validateCreateAccount() {
        System.out.println("enter your username: ");
        String userName = sc.next();
        if(!isValidUserName(userName)) {
            System.out.println("invalid username");
            return null;
        }
        System.out.println("enter your password: ");
        String password = sc.next();
        if(!isValidPassword(password)) {
            System.out.println("invalid password");
            return null;
        }
        System.out.println("enter your age: ");
        int age = sc.nextInt();
        if(!isValidAge(age)) {
            System.out.println("invalid age");
            return null;
        }
        System.out.println("enter your phone number: ");
        String phoneNumber = sc.next();
        if(!isValidPhoneNumber(phoneNumber)) {
            System.out.println("invalid phone number");
            return null;
        }
        return new Account(userName, password, age, phoneNumber);
    }

    @Override
    public Account validateLoginAccount() {
        System.out.println("Please enter your username: ");
        String userName = sc.nextLine();
        if(!isValidUserName(userName)) {
            System.out.println("invalid username");
            return null;
        }
        System.out.println("Please enter your password: ");
        String password = sc.nextLine();
        if(!isValidPassword(password)) {
            System.out.println("invalid password");
            return null;
        }
        return new Account(userName, password);
    }
}
