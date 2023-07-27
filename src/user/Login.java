package user;

import java.util.Currency;

import main.Home;
import page.Page;
import util.Action;
import util.Msg;
import util.TakeInput;
import util.Validate;

//Login class cntaining all login methods
public class Login {
	// login for start user
	public static void checkCredential() {
		// upcasting (creating interface reference and creating object of Validate
		// implementing class)
		// TakeInput validate = new Validate();
		Msg.newSection();
		System.out.println("                USER LOGIN                 ");
		Msg.border();
		System.out.print("Enter Username : ");
		String username = Action.inputStr();
		System.out.print("Enter Password : ");
		String password = Action.inputStr();

		// validate from start user check method
		// validate.checkCredential(username, password);

		// currently user cred
		User currentUser = null;
		boolean exist = false;
		for (User user : User.userList) {
			if (!user.postion.equals("Admin")) {
				if (user.username.equals(username)) {
					currentUser = user;
					exist = true;
				}
			}
		}
		try {
			if (exist) {
				if (password.equals(currentUser.password)) {
					Msg.success();
					Msg.loggedIn();
					Page.homePage(currentUser);
				} else {
					Msg.error();
					System.out.println("Incorrect Password, please try again");
					Login.loginAdmin();
				}
			} else {
				Msg.error();
				userLoginOptions();
			}
		} catch (Exception e) {
			Msg.error();
			adminLoginOptions();

		}

	}

	public static void userLoginOptions() {
		System.out.println("Invalid Username and Password, please try again");
		System.out.println("Enter 0 for Main menu");
		System.out.println("Enter 1 to try again");
		System.out.println("Enter any other to exit");
		System.out.print("Enter Choice ->");
		try {
			switch (Action.inputInt()) {
				case 0:
					Home.menu();
					break;
				case 1:
					Login.checkCredential();
					break;
				default:
					System.exit(0);
			}

		} catch (Exception e1) {
			System.exit(0);
		}
	}
	public static void adminLoginOptions() {
		System.out.println("Invalid Username and Password, please try again");
		System.out.println("Enter 0 for Main menu");
		System.out.println("Enter 1 to try again");
		System.out.println("Enter any other to exit");
		System.out.print("Enter Choice ->");
		try {
			switch (Action.inputInt()) {
				case 0:
					Home.menu();
					break;
				case 1:
					Login.loginAdmin();
					break;
				default:
					System.exit(0);
			}

		} catch (Exception e1) {
			System.exit(0);
		}
	}

	// method for admin login
	public static void loginAdmin() {
		Msg.newSection();
		System.out.println("                ADMIN LOGIN                ");
		Msg.border();
		System.out.print("Enter Username : ");
		String username = Action.inputStr();
		System.out.print("Enter Password : ");
		String password = Action.inputStr();

		// current admin cred
		User admin = null;
		boolean exist = false;
		for (User user : User.userList) {
			if (user.postion.equals("Admin")) {
				if (user.username.equals(username)) {
					admin = user;
					exist = true;
				}
			}
		}
		try {
			if (exist) {
				if (password.equals(admin.password)) {
					Msg.success();
					Msg.loggedIn();
					Page.homePage(admin);
				} else {
					Msg.error();
					System.out.println("Incorrect Password, please try again");
					Login.loginAdmin();
				}
			}
		} catch (Exception e) {
			Msg.error();
			System.out.println("Invalid Username and Password, please try again");
			System.out.println("Enter 0 for Main menu");
			System.out.println("Enter 1 to try again");
			System.out.println("Enter any other to exit");
			System.out.print("Enter Choice ->");
			try {
				switch (Action.inputInt()) {
					case 0:
						Home.menu();
						break;
					case 1:
						Login.loginAdmin();
						break;
					default:
						System.exit(0);
				}

			} catch (Exception e1) {
				System.exit(0);
			}
		}
	}
}
