package util;

public class Msg {
    public static void welcome() {
        System.out.println("* * * * * * * * * * * * * * * * * * * * *");
        System.out.println("*                Welcome                *");
        System.out.println("* * * * * * * * * * * * * * * * * * * * *");
    }
    public static void createAccount(){
        System.out.println("-----------------------------------------");
        System.out.println("|          Create New Account           |");
        System.out.println("-----------------------------------------");
    }
    
    public static void error() {
        System.out.println("         -_-   _| ERROR |_   -_-        ");
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
