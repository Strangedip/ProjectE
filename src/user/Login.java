package user;

import main.Home;
import util.Action;
import util.Msg;

public class Login {
	public void login() {
		Msg.border();
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
			Msg.border();
			System.out.println("Logged in");
			// user home page class or object

		} else if (username.equals(orgUsername)) {
			Msg.border();
			System.out.println("Incorrect Password, please try again");
			login();

		} else {
			Msg.border();
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
					Msg.border();
					System.out.println("invalid Input");
			}
		}
	}
}
