package util;

import java.lang.reflect.Member;
import java.util.Scanner;

import main.Home;
import user.CreateAccount;
import user.Login;
import user.User;
import page.Page;

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
		Login.loginUser();
	}

	public static void login(User user) {
		Login.loginUser(user);
	}

	public static void adminLogin() {
		System.out.println("Admin login here");
	}

	public static void createAccount() {

		CreateAccount newAccount = new CreateAccount();
		newAccount.createAccount();
		User user = newAccount.createUser();
		User.members.add(user);
		afterNewAccountMenu(user);
	}

	public static void afterNewAccountMenu(User user) {
		System.out.println("Enter 0 for Main menu");
		System.out.println("Enter 1 to login now");
		System.out.println("Enter Choice -> ");
		Scanner in = new Scanner(System.in);
		switch (in.nextInt()) {
			case 0:
				Home.menu(user);
				break;
			case 1:
				Login.loginUser(user);
				break;
			default:
				System.out.println("Invalid Option, Try again");
				afterNewAccountMenu(user);
		}
	}

	public static void clscr() {
		// System.out.println("\033[H\033[2J");
		// System.out.flush();
	}

}