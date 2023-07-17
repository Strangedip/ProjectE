package util;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

import main.Home;
import user.Login;

public class Validate implements TakeInput {
    public String fullName() {
        Msg.createAccount();
        System.out.print("Enter First Name: ");
        String fname = Action.inputStr();

        Msg.border();
        System.out.print("Enter Last Name: ");
        String sname = Action.inputStr();

        return fname + " " + sname;
    }

    public void userPass(String username, String password) {
        // ****take user creds from database based username
        String orgUsername = "user";
        String orgPassword = "pass";

        if (username.equals(orgUsername) && password.equals(orgPassword)) {
            Msg.border();
            System.out.println("Logged in");
            // user home page class or object

        } else if (username.equals(orgUsername)) {
            Msg.error();
            System.out.println("Incorrect Password, please try again");
            Login.login();

        } else {
            Msg.error();
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
                    Msg.error();
                    System.out.println("invalid Input, Try again");

            }
        }
    }

    public void username(String un) {

    }

    public String email() {
        Scanner in = new Scanner(System.in);
        Msg.border();
        System.out.print("Enter email: ");
        String email = in.next();
        if (email.contains(".com") && email.contains("@")) {
            return email;
        } else {
            Msg.error();
            System.out.println("Inavlid Email Format, Try again");
            return email();
        }
    }

    public int age() {
        Scanner in = new Scanner(System.in);
        Msg.border();
        System.out.print("Enter age: ");
        int age = in.nextInt();
        if (age < 1 || age > 150) {
            Msg.error();
            System.out.println("Invalid Age Input, Try Again");
            return age();
        } else if (age < 5) {
            Msg.error();
            System.out.println("Age should be above 5 years");
            return age();
        } else {
            return age;
        }

    }

    public String psw() {
        Scanner in = new Scanner(System.in);
        Msg.border();
        System.out.println("Password must contain characters, numbers and alphabets");
        System.out.print("Create Password: ");
        String password = in.next();
        if (iteratePass(password)) {
            return password;
        } else {
            Msg.error();
            System.out.println("Please Enter valid Password in format");
            return psw();
        }

    }

    boolean iteratePass(String password) {
        char[] psw = password.toCharArray();
        boolean markAlpha = false;
        boolean markNumber = false;
        boolean markChar = false;
        ArrayList<Character> symbols = new ArrayList<Character>();
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
        symbols.add(' ');

        for (char i : psw) {

            if (i >= 'A' && i <= 'z') {
                markAlpha = true;
            }
            if (i >= '0' && i <= '9') {
                markNumber = true;
            }
            if (symbols.contains(i)) {
                markChar = true;
            }
        }
        if (markAlpha && markChar && markNumber) {
            return true;
        } else {
            return false;
        }
    }

    public String confirmPassword(String psw) {
        Scanner in = new Scanner(System.in);
        System.out.print("Confirm Password: ");
        String cnf = in.next();
        if (psw.equals(cnf)) {
            return cnf;
        } else {
            Msg.error();
            System.out.println("Enter the same Password");
            return confirmPassword(psw);
        }
    }

    public long mobileNumber() {
        Msg.border();
        System.out.print("Enter Mobile Number: +91 ");
        Scanner in = new Scanner(System.in);
        try {
            long num = in.nextLong();
            int digits = (int) Math.log10(num);
            if (digits == 9) {
                return num;

            } else {
                Msg.error();
                System.out.println("Invalid Mobile Number, Please enter valid Number");
                return mobileNumber();
            }
        } catch (InputMismatchException e) {
            Msg.error();
            System.out.println("Invalid Input, try Again");
            return mobileNumber();
        }
    }

    public String gender() {
        try {
            Scanner in = new Scanner(System.in);
            Msg.border();
            System.out.println("1. Male");
            System.out.println("2. Female");
            System.out.println("3. Other");
            System.out.println("Enter gender: ");
            int input = in.nextInt();
            switch (input) {
                case 1:
                    return "Male";
                case 2:
                    return "Female";
                case 3:
                    return "Other";
                default:
                    Msg.error();
                    System.out.println("Invalid option, try Again");
                    return gender();
            }
        } catch (Exception e) {
            Msg.error();
            System.out.println("Invalid Input, try Again");
            return gender();

        }
    }
}
