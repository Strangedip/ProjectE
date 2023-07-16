package main;

import java.io.Console;
import java.util.InputMismatchException;
import java.util.Scanner;
import util.Validate;

import util.Msg;

public class Test {
    public static void main(String[] args) {
        long number = Validate.mobileNumber();
        System.out.println(number);
    }
}
