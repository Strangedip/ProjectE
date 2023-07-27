package util;

import java.util.Scanner;

import main.Home;
import user.CreateAccount;
import user.Login;
import user.School;
import user.User;

// Action class containing all user action methods
public class Action {
	static Scanner in = new Scanner(System.in);

	public static void hold() {
		System.out.print("Enter any key to continue -> ");
		switch (Action.inputStr()) {
		}
	}

	// to take int input
	public static int inputInt() {
		int input = in.nextInt();
		return input;
	}

	// to take String input
	public static String inputStr() {
		String input = in.next();
		return input;
	}

	// to take Long as input
	public static long inputLong() {
		long input = in.nextLong();
		return input;
	}

	public static void schoolIntro() {
		School.introduction();
		System.out.print("enter any key to go back -> ");
		switch (Action.inputStr()) {
			default:
				Home.menu();
				break;
		}
	}

	public static void schoolIntro(User user) {
		School.introduction();
		System.out.print("enter any key to go back -> ");
		switch (Action.inputStr()) {
			default:
				Home.menu();
				break;
		}
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
		// adding that newly created user into members ArrayList
		if (!User.addNewMember(user)) {
			Msg.error();
			System.out.println("Account already Exist, Please Login");
			afterNewAccountMenu();
		}
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
		Scanner in = new Scanner(System.in);
		try {
			switch (in.nextInt()) {
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