package util;
import java.util.Scanner;
import user.CreateAccount;
import user.Login;

public class Action {
	static Scanner in = new Scanner(System.in);

	public static int inputInt() {
		int input = in.nextInt();
		return input;
	}

	public static String inputStr() {
		String input = in.next();
		return input;
	}

	public static long inputLong() {
		long input = in.nextLong();
		return input;
	}

	public static void login() {
		Login.login();
	}

	public static void adminLogin() {
		System.out.println("Admin login here");
	}

	public static void createAccount() {
		
		CreateAccount user = new CreateAccount();
		user.createAccount();
		user.details();
		// user.createUser();
	}

	public static void clscr() {
//		System.out.println("\033[H\033[2J");
//		System.out.flush();  
	}

}