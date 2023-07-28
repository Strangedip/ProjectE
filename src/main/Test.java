package main;


public class Test {

    public static void main(String[] args) {
        solution(25, 2500);
        
    }

    public static void solution(int x, int y) {
        if(x>y*10){
            System.out.println("spam");
        }
        else{
            System.out.println("genuine");
        }
    }

}