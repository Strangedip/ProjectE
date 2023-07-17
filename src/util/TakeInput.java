package util;

import java.util.InputMismatchException;
import java.util.Scanner;

public class TakeInput {
    public static void psw() {

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
