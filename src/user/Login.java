package user;

import main.Home;
import util.Action;

public class Login {
	public void login() {
		Action.clscr();
		System.out.print("Enter Username:");
		String username = Action.inputStr();
		System.out.print("Enter Password :");
		String password = Action.inputStr();

		check(username, password);
	}

	void check(String username, String password) {
		// ****take user creds from database based username
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

		} else {
			Action.clscr();
			System.out.println("Incorrect Username and Password, please try again");
			System.out.println("Enter 1 to go to Home");
			System.out.println("Enter 0 to login again");
			switch (Action.inputInt()) {
				case 1:
					Home.menu();
					break;
				case 0:
					login();
					break;
				default:
					Action.clscr();
					System.out.println("invalid Input");
			}
		}
	}
}
