package main;

import java.util.Arrays;

public class Test {

    public static void main(String[] args) {
        int[] a= {0,1,8,6,5,4,3,2,7};
        sort(a);
        System.out.println(Arrays.toString(a));   
    }

    public static void sort(int[] a) {
        int i=0;
        while(i<a.length){
            System.out.println(i);
            System.out.println(a[i]+" "+a[a[i]]);
            if(a[i]!=i){
                int temp=a[a[i]];
                a[a[i]]=a[i];
                a[i]=temp;
            }
            else{
                i++;
            }
        }
    }

}