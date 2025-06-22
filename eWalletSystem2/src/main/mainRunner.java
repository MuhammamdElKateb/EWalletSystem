package main;

import Service.AppService;
import Service.Impl.AppServiceImpl;

public class mainRunner {
    public static void main(String[] args) {
        AppService appService=new AppServiceImpl();
        appService.startApp();
    }
}
