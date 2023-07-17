package main;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.InputMismatchException;

import util.Msg;

public class Test {
    static Scanner in=new Scanner(System.in);
    public static void main(String[] args) {
        System.out.println(mobileNumber());
    }

    static long mobileNumber(){
    try {
            Msg.border();
            System.out.print("Enter Mobile Number: ");
            long num = in.nextLong();
            int digits=(int)Math.log10(num);
            System.out.println(digits+1);
            if (digits+1==10) {
                return num;

            } else {
                System.out.println("Invalid Input, try Again");
                return mobileNumber();
            }
        } catch (Exception e) {
            System.out.println("Invalid Input, try Again");
    }
    return mobileNumber();
}
}