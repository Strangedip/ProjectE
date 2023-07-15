package main;

import util.Action;

public class Home {
    public static void menu() {
        Action.clscr();
        System.out.println("1) User Login");
        System.out.println("2) Create new account");
        System.out.println("3) Admin Login");
        Action.clscr();
        System.out.print("Enter you Choice --> ");
        int userInput = Action.inputInt();
        switch (userInput) {
            case 1:
                Action.login();
                break;
            case 2:
                Action.createAccount();
                break;
            case 3:
                Action.adminLogin();
                break;
            default:
                Action.clscr();
                System.out.println("Invalid Input");
                break;
        }
    }

}