import java.util.Scanner;

class Action {
	public static int inputInt() {
		Scanner in = new Scanner(System.in);
		int input = in.nextInt();
		in.close();
		return input;
	}
	public static String inputStr() {
		Scanner in = new Scanner(System.in);
		String input = in.next();
		in.close();
		return input;
	}
	public static void login(){
		Login obj=new Login();
		obj.login();
	}
}
public class Test {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("ENter nea: ");
        String input= Action.inputStr();
        System.out.println(input);
		in.close();
    }
}
