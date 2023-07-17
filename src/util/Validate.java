package util;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

import main.Home;
import user.Login;

public class Validate implements TakeInput {
    public void userCreds(String username, String password) {
        // ****take user creds from database based username
        String orgUsername = "user";
        String orgPassword = "pass";

        if (username.equals(orgUsername) && password.equals(orgPassword)) {
            Msg.border();
            Msg.success();
            System.out.println("Logged in");
            // user home page class or object

        } else if (username.equals(orgUsername)) {
            Msg.error();
            System.out.println("Incorrect Password, please try again");
            Login.loginUser();

        } else {
            Msg.error();
            System.out.println("Incorrect Username and Password, please try again");
            System.out.println("Enter 0 for Main menu");
            System.out.println("Enter 1 to try again");
            System.out.println("Enter any other to exit");
            System.out.print("Enter Choice ->");
            try {
                switch (Action.inputInt()) {
                    case 0:
                        Home.menu();
                        break;
                    case 1:
                        Login.loginUser();
                        break;
                    default:
                        System.exit(0);
                }

            } catch (Exception e) {
                System.exit(0);
            }
        }
    }

    public String fullName() {
        Msg.border();
        System.out.print("Enter First Name: ");
        String fname = Action.inputStr();
        if (onlyAlpha(fname)) {
            Msg.error();
            System.out.println("Name should contain only alphabets");
            return fullName();
        }

        Msg.border();
        System.out.print("Enter Last Name: ");
        String sname = Action.inputStr();
        if (onlyAlpha(sname)) {
            Msg.error();
            System.out.println("Name should contain only alphabets");
            return fullName();
        }
        return fname + " " + sname;
    }

    boolean onlyAlpha(String a) {
        char[] arr = a.toCharArray();
        boolean markNumber = false;
        boolean markChar = false;

        for (char i : arr) {
            if (i >= '0' && i <= '9') {
                markNumber = true;
            }
            if (Resource.symbolArrayContains(i)) {
                markChar = true;
            }
        }
        if (markChar) {
            return true;
        } else if (markNumber) {
            return true;
        } else {
            return false;
        }
    }

    public int age() {
        Scanner in = new Scanner(System.in);
        Msg.border();
        System.out.print("Enter age: ");
        try {
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
        } catch (Exception e) {
            Msg.error();
            System.out.println("Invalid Input!");
            return age();
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
            System.out.println("Invalid Input!");
            return gender();
        }
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

    public long mobileNumber() {
        Msg.border();
        System.out.print("Enter Mobile Number: +91 ");
        Scanner in = new Scanner(System.in);
        try {
            long num = in.nextLong();
            int digits = (int) Math.log10(num);
            if (digits + 1 == 10) {
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

    public String username() {
        try {
            Scanner in = new Scanner(System.in);
            String username;
            System.out.print("Create Username : ");
            username = in.next();
            return username;
        } catch (Exception e) {
            Msg.error();
            System.out.println("Something went wrong!");
            return username();
        }
    }

    public String psw() {
        Scanner in = new Scanner(System.in);
        Msg.border();
        System.out.print("Create Password: ");
        String password = in.next();
        if (iteratePass(password)) {
            return password;
        } else {
            Msg.error();
            System.out.println("Please Enter valid Password in format");
            System.out.println("Password must contain following :");
            System.out.println("Character, Number and Alphabet (both Uppercase and Lowercase)'");
            return psw();
        }

    }

    boolean iteratePass(String password) {
        char[] psw = password.toCharArray();
        boolean markAlphaU = false;
        boolean markAlphaL = false;
        boolean markNumber = false;
        boolean markChar = false;

        for (char i : psw) {

            if (i >= 'A' && i <= 'Z') {
                markAlphaU = true;
            }
            if (i >= 'a' && i <= 'z') {
                markAlphaL = true;
            }
            if (i >= '0' && i <= '9') {
                markNumber = true;
            }
            if (Resource.symbolArrayContains(i)) {
                markChar = true;
            }
        }
        if (markAlphaU && markAlphaL && markChar && markNumber) {
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

}

class Resource {

    public static boolean symbolArrayContains(char ch) {
        ArrayList<Character> symbols = new ArrayList<Character>();
        symbols.add('~');
        symbols.add('`');
        symbols.add('{');
        symbols.add('[');
        symbols.add('\'');
        symbols.add('}');
        symbols.add(']');
        symbols.add('|');
        symbols.add('\\');
        symbols.add(':');
        symbols.add(';');
        symbols.add('"');
        symbols.add('<');
        symbols.add(',');
        symbols.add('>');
        symbols.add('.');
        symbols.add('?');
        symbols.add('/');
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
        if (symbols.contains(ch)) {
            return true;
        } else {
            return false;
        }
    }

}
