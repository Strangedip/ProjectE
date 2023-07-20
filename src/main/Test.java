package main;

import java.util.Scanner;

import user.User;
import util.TakeInput;
interface I{
    // public int a=15;
}
class C2 implements TakeInput,I{
    public void userCreds(String username, String password){}

    public void userCreds(String username, String password, User user){}

    public String fullName(){return "";}

    public int age(){return 1;}

    public String gender(){return "";}

    public long mobileNumber(){
        return 1l;
    }

    public String email(){return "";}

    public String username(){return "";}

    public String psw(){return "";}

    public String confirmPassword(String psw){
        return "";
    }
}
public class Test {
    static Scanner in = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println(TakeInput.a);
        System.out.println(C2.a);
    }

}