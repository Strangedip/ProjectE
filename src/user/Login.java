package user;

import main.Home;
import page.Page;
import util.Action;
import util.Msg;
import util.TakeInput;
import util.Validate;

//Login class cntaining all login methods
public class Login {
	//login for start user
	public static void loginUser() {
		// upcasting (creating interface reference and creating object of Validate implementing class)
		TakeInput validate = new Validate();
		Msg.newSection();
		System.out.println("                USER LOGIN                 ");
		Msg.border();
		System.out.print("Enter Username : ");
		String username = Action.inputStr();
		System.out.print("Enter Password : ");
		String password = Action.inputStr();

		//validate from start user check method
		validate.userCreds(username, password);
	}

	public static void loginUser(User user) {
		// upcasting (creating interface reference and creating object of Validate implementing class)
		TakeInput validate = new Validate();
		Msg.newSection();
		System.out.println("                USER LOGIN                 ");
		Msg.border();
		System.out.print("Enter Username : ");
		String username = Action.inputStr();
		System.out.print("Enter Password : ");
		String password = Action.inputStr();

		//validate from newcly created user check method
		validate.userCreds(username, password, user);

		// if(username.equals(user.username) && password.equals(user.password)){
		// Msg.success();
		// Page.homePage(user);
		// }

		// validate.userCreds(username, password);
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

		// currently admin cred are static, rest are same as userCreds method
		String adminUsername = Admin.admin1.username;
		String adminPassword = Admin.admin1.password;

		if (username.equals(adminUsername) && password.equals(adminPassword)) {
			Msg.success();
			Msg.loggedIn();
			Page.homePage(Admin.admin1);
		} else if (username.equals(adminUsername)) {
			Msg.error();
			System.out.println("Incorrect Password, please try again");
			Login.loginUser(Admin.admin1);

		} else {
			Msg.error();
			System.out.println("Incorrect Username and Password, please try again");
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
						Login.loginUser(Admin.admin1);
						break;
					default:
						System.exit(0);
				}

			} catch (Exception e) {
				System.exit(0);
			}
		}
	}

	// TakeInput validate = new Validate();
	// validate.adminCreds(username, password);
}
