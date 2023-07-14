import java.util.Scanner;

class Action {
	public static int inputInt() {
		Scanner in = new Scanner(System.in);
		int input = in.nextInt();
		return input;
	}
	public static String inputStr() {
		Scanner in = new Scanner(System.in);
		String input = in.next();
		return input;
	}
	public static void login(){
		Login obj=new Login();
		obj.login();
	}
	public static void clscr() {
		System.out.print("\033[H\033[2J");
		System.out.flush();  
	}
}
public class Test {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
		Action.clscr();
        System.out.print("ENter nea: ");
        String input= Action.inputStr();
        
		Action.clscr();
        System.out.print("ENter nea: ");
        input= Action.inputStr();
        System.out.println(input);
		in.close();
    }
}
