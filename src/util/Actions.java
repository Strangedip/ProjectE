package util;

import java.util.Scanner;

import main.Home;
import page.faculty.Faculty;
import user.CreateAccount;
import user.Login;
import user.User;

// Action class containing all user action methods
public class Actions {

	public static void hold() {
		System.out.print("Enter any key to continue -> ");
		switch (Actions.inputStr()) {
		}
	}

	// to take int input
	public static int inputInt() {
		Scanner in = new Scanner(System.in);

		int input = in.nextInt();
		return input;
	}

	// to take String input
	public static String inputStr() {
		Scanner in = new Scanner(System.in);

		String input = in.next();
		return input;
	}

	// to take Long as input
	public static long inputLong() {
		Scanner in = new Scanner(System.in);

		long input = in.nextLong();
		return input;
	}

	// Userlogin without formal argument (default user) **since no DB used
	public static void login() {
		Login.checkCredential();
	}

	// Adminlogin without formal argument (precreated admin accounts)
	public static void adminLogin() {
		Login.loginAdmin();
	}

	// action to create new account
	public static void createAccount() {

		// new CreateAccount Object created for new user
		CreateAccount newAccount = new CreateAccount();

		// calling creation method
		newAccount.createAccount();

		// creating new User ref with details stored inside CreateAccount obj
		User user = newAccount.createUser();

		Msg.accountCreated();
		// aftermath for the newly created user
		afterNewAccountMenu();
	}

	// method to run after new account has been created with formal argument as User
	// obj
	public static void afterNewAccountMenu() {
		System.out.println("Enter 0 for Main menu");
		System.out.println("Enter 1 to login now");
		System.out.print("Enter Choice -> ");
		try {
			switch (Actions.inputInt()) {
				case 0:
					Home.menu();
					break;
				case 1:
					// calling login User
					Login.checkCredential();
					break;
				default:
					System.out.println("Invalid Option, Try again");
					afterNewAccountMenu();
			}
		} catch (Exception e) {
			System.out.println("Invalid Input, Try again");
			afterNewAccountMenu();
		}
	}

	// clear screen optional (not working)
	public static void clscr() {
		// System.out.println("\033[H\033[2J");
		// System.out.flush();
	}

}