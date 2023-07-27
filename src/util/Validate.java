package util;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

import main.Home;
import page.Page;
import user.Login;
import user.User;

// Implementing class for TakeInput interface
public class Validate implements TakeInput {

    // public void checkCredential(String username, String password) {
    // User currentUser = getUser(username);
    // try {
    // // if password is matching with users password allow login
    // if (currentUser.password.equals(password)) {
    // Msg.border();
    // Msg.loggedIn();
    // Page.homePage(currentUser);
    // }
    // // password incorrect, login again
    // else {
    // Msg.error();
    // System.out.println("Incorrect Password, please try again");

    // }
    // } catch (Exception e) {
    // Msg.error();
    // System.out.println("Incorrect Username and Password, please try again");
    // System.out.println("Enter 0 for Main menu");
    // System.out.println("Enter 1 to try again");
    // System.out.println("Enter any other to exit");
    // System.out.print("Enter Choice ->");
    // try {
    // switch (Action.inputInt()) {
    // case 0:
    // Home.menu();
    // break;
    // case 1:
    // Login.checkCredential();
    // break;
    // default:
    // Msg.thankyou();
    // System.exit(0);
    // }

    // } catch (Exception e1) {
    // Msg.thankyou();
    // System.exit(0);
    // }
    // }
    // }

    public User getUser(String un) {
        for (User user : User.userList) {
            if (user.username == un) {
                return user;
            }
        }
        return null;
    }

    public String position() {
        Msg.border();
        System.out.println("1.Visitor");
        System.out.println("2.Student");
        System.out.println("3.Faculty");
        System.out.print("Enter Current Position Accurately : ");
        Scanner in = new Scanner(System.in);
        try {
            switch (in.nextInt()) {
                case 1:
                    return "Student";
                case 2:
                    return "Faculty";
                case 3:
                    return "Visitor";
                default:
                    Msg.error();
                    System.out.println("Invalid Option");
                    return position();
            }
        } catch (Exception e) {
            Msg.error();
            System.out.println("Invalid Input!");
            return position();
        }
    }

    // to check name format (should only have alphabets)
    public String fullName() {
        Msg.border();
        System.out.print("Enter First Name: ");
        String fname = Action.inputStr();
        if (allAlpha(fname)) {
            Msg.error();
            System.out.println("Name should contain only alphabets");
            return fullName();
        }

        Msg.border();
        System.out.print("Enter Last Name: ");
        String sname = Action.inputStr();
        if (allAlpha(sname)) {
            Msg.error();
            System.out.println("Name should contain only alphabets");
            return fullName();
        }
        return fname + " " + sname;
    }

    // checking for numbers & characters in String (return true if present)
    boolean allAlpha(String a) {
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
        if (markChar || markNumber) {
            return true;
        } else {
            return false;
        }
    }

    // age input and validation above 5 below 150 (no negative age allowed)
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

    // gender input with recursion if invalid input provided
    public String gender() {
        try {
            Scanner in = new Scanner(System.in);
            Msg.border();
            System.out.println("1. Male");
            System.out.println("2. Female");
            System.out.println("3. Other");
            System.out.print("Enter gender: ");
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

    // email validation (checks for '@' and '.com' String in passed String)
    public String email() {
        Scanner in = new Scanner(System.in);
        Msg.border();
        System.out.print("Enter email: ");
        String email = in.next();
        if (email.contains(".com") && (validEmail(email))) {
            return email;
        } else {
            Msg.error();
            System.out.println("Inavlid Email Format, Try again");
            return email();
        }
    }

    public boolean validEmail(String email) {
        char[] charEmail = email.toCharArray();
        int countAt = 0;
        for (char i : charEmail) {
            if (i == '@') {
                if (countAt < 1) {
                    countAt++;
                } else {
                    return false;
                }
            }
        }
        return true;
    }

    // mobile number input n validation for long size of 10 digits
    public long mobileNumber() {
        Msg.border();
        System.out.print("Enter Mobile Number: +91 ");
        Scanner in = new Scanner(System.in);
        try {
            long num = in.nextLong();
            if (fixedNumberSize(num, 10)) {
                return num;
            } else {
                Msg.error();
                System.out.println("Invalid Mobile Number , Please enter valid Number (10 digits)");
                return mobileNumber();
            }
        } catch (InputMismatchException e) {
            Msg.error();
            System.out.println("Invalid Input, try Again");
            return mobileNumber();
        }
    }

    boolean usernameExist(String un) {
        for (User user : User.userList) {
            if (user.username.equals(un)) {
                return false;
            }
        }
        return true;
    }

    // input username & validate (should not contain character and length should be
    // atleast 4)
    public String username() {
        Msg.border();
        Scanner in = new Scanner(System.in);
        String username;
        System.out.print("Create Username : ");
        try {
            username = in.next();
            if (!usernameExist(username)) {
                Msg.error();
                System.out.println("Username Already Exist, Try different one");
                return username();
            } 
            //if username does not exist allow username for next validations
            else {
                if (validStringSize(username, 4)) {
                    if (validateUsername(username)) {
                        return username;
                    } else {
                        System.out.println("No Characters allowed in Username, Try again");
                        return username();
                    }
                } else {
                    Msg.error();
                    System.out.println("Username should be of atleat 4 characters");
                    return username();
                }
            }
        } catch (Exception e) {
            Msg.error();
            System.out.println("Something went wrong!");
            return username();
        }
    }

    // validating username if not containing characters return true
    public boolean validateUsername(String un) {
        char[] arr = un.toCharArray();
        for (char c : arr) {
            if (Resource.symbolArrayContains(c)) {
                return false;
            }
        }
        return true;
    }

    // input & validate password for size atleast and in format
    public String psw() {
        Scanner in = new Scanner(System.in);
        Msg.border();
        System.out.print("Create Password: ");
        String password = in.next();
        if (validStringSize(password, 6)) {
            if (validatePass(password)) {
                return password;
            } else {
                Msg.error();
                System.out.println("Please Enter valid Password in format");
                System.out.println("Password must contain following :");
                System.out.println("Character, Number and Alphabet (both Uppercase and Lowercase)'");
                return psw();
            }
        } else {
            Msg.error();
            System.out.println("Please Enter valid Password in format");
            System.out.println("Password should be atleast 6 character long");
            return psw();
        }

    }

    // validating password (shoud contain atleast 1 char, num, upper, lower )
    boolean validatePass(String password) {
        // converting given string into array of characters to iterate through it
        char[] psw = password.toCharArray();
        boolean markAlphaU = false;
        boolean markAlphaL = false;
        boolean markNumber = false;
        boolean markChar = false;

        // checking for presence of each
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
        // if all present return true else false
        if (markAlphaU && markAlphaL && markChar && markNumber) {
            return true;
        } else {
            return false;
        }
    }

    // input and validate confirm password with formal argument as entered password
    // String
    public String confirmPassword(String psw) {
        Scanner in = new Scanner(System.in);
        System.out.print("Confirm Password: ");
        String cnf = in.next();
        // if same as entered password return password
        if (psw.equals(cnf)) {
            return cnf;
        } else {
            Msg.error();
            System.out.println("Enter the same Password");
            return confirmPassword(psw);
        }
    }

    public boolean checkCurrentPassword(String psw) {
        Scanner in = new Scanner(System.in);
        Msg.border();
        System.out.print("Enter Current Password: ");
        String cnf = in.next();
        // if same as entered password return password
        if (psw.equals(cnf)) {
            return true;
        } else {
            Msg.error();
            System.out.println("Incorrect current Password");
            return checkCurrentPassword(psw);
        }
    }

    // validate a String for size, return true if String size is greater than size
    // given
    public boolean validStringSize(String str, int size) {
        if (str.length() >= size) {
            return true;
        }
        return false;
    }

    // check for long for the digits count (return true if digit count == size)
    public boolean fixedNumberSize(long num, int size) {
        int digits = (int) Math.log10(num);
        if (digits + 1 == size) {
            return true;
        } else {
            return false;
        }
    }

}

// Resources class for all resources such as character array
class Resource {

    // creating char array and return true if presence of char ch is found
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
