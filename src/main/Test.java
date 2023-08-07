package main;

import java.util.Arrays;

public class Test {

    public static void main(String[] args) {
        int[] a = { 3, 1, 4, 6, 5, 8, 0, 2, 7 };
        System.out.println(Arrays.toString(a));
        cliclicSort(a);
        System.out.println(Arrays.toString(a));
    }

    public static void cliclicSort(int[] a) {
        int i = 0;
        while (i < a.length) {
            if (a[i] != i) {
                int temp = a[a[i]];
                a[a[i]] = a[i];
                a[i] = temp;
            } else {
                i++;
            }
        }
    }
}