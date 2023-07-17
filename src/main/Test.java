package main;

import java.util.Scanner;

import util.Msg;

public class Test {
    static Scanner in = new Scanner(System.in);

    public static void main(String[] args) {
        int a = in.nextInt();
        switch (a) {
            case 1:
                System.out.println("case1");
                break;
            case 2:
                System.out.println("case2");
        }

    }

}