package util;
import main.Home;
import user.Login;

public class Validate {
    public static void userPass(String username, String password) {
        // ****take user creds from database based username
        String orgUsername = "user";
        String orgPassword = "pass";

        if (username.equals(orgUsername) && password.equals(orgPassword)) {
            Msg.border();
            System.out.println("Logged in");
            // user home page class or object

        } else if (username.equals(orgUsername)) {
            Msg.border();
            System.out.println("Incorrect Password, please try again");
            Login.login();

        } else {
            Msg.border();
            System.out.println("Incorrect Username and Password, please try again");
            System.out.println("Enter 1 to go to Home");
            System.out.println("Enter 0 to login again");
            switch (Action.inputInt()) {
                case 1:
                    Home.menu();
                    break;
                case 0:
                    Login.login();
                    break;
                default:
                    Msg.border();
                    System.out.println("invalid Input");
            }
        }
    }
    public static void mobile(long num){

    }
    public static void username(String un){

    }
    public static void email(String email){

    }
    public static void age(String num){

    }
}
