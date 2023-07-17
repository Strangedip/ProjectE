package util;

public class Msg {
    public static void otherOptions() {
        System.out.println("Enter 0 for Main Menu");
        System.out.println("Enter -1 for previous Menu");
        System.out.println("Enter -2 to exit program");
    }

    public static void thankyou() {
        System.out.println("-----------------------------------------");
        System.out.println("|         THANK YOU FOR USING           |");
        System.out.println("-----------------------------------------");
    }

    public static void welcome() {
        System.out.println("* * * * * * * * * * * * * * * * * * * * *");
        System.out.println("*                Welcome                *");
        System.out.println("* * * * * * * * * * * * * * * * * * * * *");
    }

    public static void createAccount() {
        System.out.println("-----------------------------------------");
        System.out.println("|          Create New Account           |");
        System.out.println("-----------------------------------------");
    }

    public static void error() {
        System.out.println("          -_-  _| ERROR |_  -_-          ");
        border();
    }

    public static void success() {
        System.out.println("-----------------------------------------");
        System.out.println("|                Success!               |");
        System.out.println("-----------------------------------------");
    }

    public static void border() {
        System.out.println("=========================================");
    }

}
