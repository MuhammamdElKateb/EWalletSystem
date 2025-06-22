package Service.Impl;

import Model.Account;
import Service.AccService;
import Service.AppService;
import Service.ValidationService;

import java.util.Objects;
import java.util.Scanner;

public class AppServiceImpl implements AppService {
    private ValidationService validationService=new VaildationServiceImpl();
    private AccService accService=new AccServiceImpl();
    @Override
    public void startApp() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Welcome to EraaSoft eWaller=t System");
        System.out.println("What would you like to do?");
        int counter =5;
        while(!(counter==0)){
            System.out.println("1/login");
            System.out.println("2/signUp");
            System.out.println("3/exit");
            int choice = sc.nextInt();
            switch(choice) {
                case 1:
                    login();
                    break;
                case 2:
                    signUp();
                    break;
                case 3:
                    System.exit(0);
                    break;
                default:
                    counter--;
                    System.out.println("Wrong choice");
                    break;
            }if(counter==0){
                System.out.println("Try again later :(");
            }

        }



    }
    public void login() {
        Account account = validationService.validateLoginAccount();
        if(Objects.isNull(account)){
            return;
        }
        boolean isAccountValid=accService.login(account);
        if(isAccountValid){
            System.out.println("Login successful");
            AppServiceImpl appService=new AppServiceImpl();
            appService.functionsMenu(account);
        }
        System.out.println("Incorrect username or password");
    }
    public void signUp() {
        Account account = validationService.validateCreateAccount();
        if(Objects.isNull(account)){
            return;
        }
        boolean isAccountValid=accService.signUp(account);
        if(isAccountValid){
            System.out.println("Account Created successful");
        }
        System.out.println("There is an account with that username ");
    }
    public void functionsMenu(Account account) {
        Scanner sc = new Scanner(System.in);
        System.out.println("====Welcome====");
        System.out.println("What Do You Want to do?");
        int counter = 5;
        while (counter != 0) {
            System.out.println("1/Deposit");
            System.out.println("2/Withdraw");
            System.out.println("3/Transfer");
            System.out.println("4/Show Account Details");
            System.out.println("5/Logout");
            System.out.println("6/Exit");
            int choice = sc.nextInt();
            switch (choice) {
                case 1:
                    deposit(account);
                    break;
                case 2:
                    withdraw(account);
                    break;
                case 3:

                    transferMoney(account);
                    break;
                case 4:
                    showAccDetails(account);
                    break;
                case 5:
                    startApp();
                    break;
                case 6:
                    System.exit(0);
                    break;
                default:
                    counter--;
                    System.out.println("Invalid Choice");
            }
            if (counter == 0) {
                System.out.println("Try Again Later");
                startApp();
            }
        }
    }
    public void deposit(Account account) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter deposit amount");
        double money=sc.nextDouble();
        boolean isDepositValid=accService.deposit(account,money);
        if(isDepositValid){
            System.out.println("Deposit successful");
        }else{
            System.out.println("Deposit failed");
        }
    }
    public void withdraw(Account account) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter withdraw amount");
        double money=sc.nextDouble();
        int withdrawSuccess = accService.withDraw(account, money);
        if(withdrawSuccess==3){
            System.out.println("Withdraw successful");
        }else if(withdrawSuccess==2){
            System.out.println("Not enough money");
        }else{
            System.out.println("Account not exists");
        }
    }
    public void transferMoney(Account account) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter transfer amount");
        double money=sc.nextDouble();
        System.out.println("To who?");
        String toUserName=sc.next();
        Account toAccount = new Account();
        toAccount.setName(toUserName);
        int transferSuccess=accService.transfer(account,toAccount,money);
        if(transferSuccess==4){
            System.out.println("Transfer successful");
        }else if(transferSuccess==3) {
            System.out.println("Not enough money");
        }else if(transferSuccess==2){
            System.out.println("Account You Want To Transfer To Not Exists");
        }
        else{
            System.out.println("Account not exists");
        }
    }
    public void showAccDetails(Account account) {
         account= accService.getAccount(account);
         if(Objects.isNull(account)){
             return;
         }
         System.out.println("Name: "+account.getName());
         System.out.println("Password: "+account.getPassword());
         System.out.println("Balance: "+account.getBalance());
         System.out.println("Phone Number: "+account.getPhoneNumber());

    }
}
