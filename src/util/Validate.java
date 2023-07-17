package util;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

import main.Home;
import user.Login;

public class Validate {
    static Scanner in =new Scanner(System.in);
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
    
    public static void username(String un){

    }
    public static void email(String email){

    }
    public static void age(String num){

    }
    public static String psw() {
        Msg.border();
        System.out.println("Password must contain characters, numbers and alphabets");
        System.out.print("Enter Password: ");
        String password = in.next();        
        if (iteratePass(password)){
            return password;
        }
        else{
            System.out.println("Please Enter valid Password in format");
            return psw();
        }

    }
    static boolean iteratePass(String password){
        char[] psw=password.toCharArray();
        boolean markAlpha=false;
        boolean markNumber=false;
        boolean markChar=false;
        ArrayList<Character> symbols= new ArrayList<Character>();
        symbols.add('!');
        symbols.add('@');
        symbols.add('#');
        symbols.add('$');
        symbols.add('^');
        symbols.add('&');
        symbols.add('*');
        symbols.add('(');
        symbols.add(')');
        symbols.add('_');
        symbols.add('-');
        symbols.add('+');
        symbols.add('=');

        for(char i : psw){

            if(i>='A' && i<='z'){
                markAlpha=true;
            }
            if(i>='0' && i<='9' ){
                markNumber=true;
            }
            if(symbols.contains(i)){
                markChar=true;
            }
        }
        if(markAlpha && markChar && markNumber){
            return true;
        }
        else{
            return false;
        }        
    }
    public static String confirmPassword(String psw){
        System.out.println("Confirm Password: ");
        String cnf=in.next();
        if (psw.equals(cnf)){
            return cnf;
        }
        else{
            return confirmPassword(psw);
        }
    }

    public static long mobileNumber() {
        try {
            Msg.border();
            System.out.print("Enter Mobile Number: ");
            long num = in.nextLong();
            int digits=(int)Math.log10(num);
            if (digits==9) {
                return num;

            } else {
                System.out.println("Invalid Mobile Number, Please enter valid Number");
                return mobileNumber();
            }
        } catch (InputMismatchException e) {
            System.out.println("Invalid Input, try Again");
            return mobileNumber();
        }
    }

    public static String gender() {
        Msg.border();
        System.out.println("1. Male");
        System.out.println("2. Female");
        System.out.println("3. Other");
        System.out.print("Enter gender: ");
        switch (Action.inputInt()) {
            case 1:
                return "Male";
            case 2:
                return "Female";
            case 3:
                return "Other";
            default:
                System.out.println("Invalid Input, try Again");
                return gender();
        }
    }

    public static void email() {

    }
}
