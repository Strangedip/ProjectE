import java.util.*;

class Action {
	static Scanner in = new Scanner(System.in);

	public static int inputInt() {
		int input = in.nextInt();
		return input;
	}

	public static String inputStr() {
		String input = in.next();
		return input;
	}

	public static void login() {
		Login obj = new Login();
		obj.login();
	}

	public static void adminLogin() {
		System.out.println("Admin login here");
	}

	public static void createAccount() {
		System.out.println("Create new acc here");
	}

	public static void clscr(){
		System.out.print("\033[H\033[2J");
	}
}

class Login {
	public void login() {
		System.out.print("Enter Username:");
		String username = Action.inputStr();
		System.out.print("Enter Password :");
		String password = Action.inputStr();

		check(username, password);
	}

	void check(String username, String password) {
		// take user creds from database based username
		String orgUsername = "user";
		String orgPassword = "pass";

		if (username.equals(orgUsername) && password.equals(orgPassword)) {
			Action.clscr();
			System.out.println("Logged in");
			// user home page class or object
		} else if (username.equals(orgUsername)) {
			Action.clscr();
			System.out.println("Incorrect Password, please try again");
			login();
			// retain username method
		} else {
			Action.clscr();
			System.out.println("Incorrect Username and Password, please try again");
			System.out.println("Enter 1 to go to Home");
			System.out.println("Enter 0 to login again");
			switch (Action.inputInt()) {
				case 1:
					Action.clscr();
					Home.menu();
					break;
				case 0:
					Action.clscr();
					login();
					break;
				default:
					Action.clscr();
					System.out.println("invalid Input");
			}
		}
	}
}

class Members {

}

class Home {
	public static void menu() {
		Action.clscr();
		System.out.println("1) User Login");
		System.out.println("2) Create new account");
		System.out.println("3) Admin Login");

		int userInput = Action.inputInt();
		switch (userInput) {
			case 1:
				Action.clscr();
				Action.login();
				break;
			case 2:
				Action.clscr();
				Action.createAccount();
				break;
			case 3:
				Action.clscr();
				Action.adminLogin();
				break;

			default:
				Action.clscr();
				System.out.println("Invalid Input");
				break;
		}
	}

}

public class ProjectE {

	public static void main(String[] args) {
		Home.menu();
	}

}
