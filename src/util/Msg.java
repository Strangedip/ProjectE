package util;

// Msg class with all the message printing methods
public class Msg {
    public static void otherOptions() {
        System.out.println("Enter 0 for Main Menu");
        System.out.println("Enter -1 for previous Menu");
        System.out.println("Enter -2 to exit program");
    }
    
    public static void header() {
        System.out.println();
        System.out.println("---------------------------------------------");
        System.out.println("                ELITE SCHOOL                 ");
        System.out.println("_____________________________________________");
    }
    public static void loggedIn() {
        System.out.println();
        System.out.println("         ^_^  _| LOGGED IN |_  ^_^           ");
    }

    public static void loggedOut() {
        System.out.println();
        System.out.println("        T_T  _| LOGGED OUT |_  T_T           ");
    }

    public static void thankyou() {
        System.out.println("---------------------------------------------");
        System.out.println("|           THANK YOU FOR USING             |");
        System.out.println("---------------------------------------------");
        
    }

    public static void welcome() {
        // System.out.println("* * * * * * * * * * * * * * * * * * * * *");
        // System.out.println("*                  Welcome                  *");
        // System.out.println("* * * * * * * * * * * * * * * * * * * * *");
        
    }

    public static void createAccount() {
        System.out.println("---------------------------------------------");
        System.out.println("|            Create New Account             |");
        System.out.println("---------------------------------------------");
    }

    public static void accountCreated() {
        System.out.println("---------------------------------------------");
        System.out.println("|              Account Created              |");
        System.out.println("---------------------------------------------");
    }

    public static void error() {
        System.out.println("            -_-  _| ERROR |_  -_-            ");
        border();
    }

    public static void success() {
        System.out.println("---------------------------------------------");
        System.out.println("|                  Success!                 |");
        // System.out.println("---------------------------------------------");
        
    }

    public static void border() {
        // System.out.println("=============================================");
        System.out.println("---------------------------------------------");
    }

}
