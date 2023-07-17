package user;

import page.Page;
import util.Action;
import util.Msg;
import util.TakeInput;
import util.Validate;

public class Login {
	public static void loginUser() {
		TakeInput validate = new Validate();
		Msg.border();
		System.out.print("Enter Username:");
		String username = Action.inputStr();
		System.out.print("Enter Password :");
		String password = Action.inputStr();

		validate.userCreds(username, password);
	}

	public static void loginUser(User user) {
		TakeInput validate = new Validate();
		Msg.border();
		System.out.print("Enter Username:");
		String username = Action.inputStr();
		System.out.print("Enter Password :");
		String password = Action.inputStr();
		validate.userCreds(username, password, user);

		// if(username.equals(user.username) && password.equals(user.password)){
		// Msg.success();
		// Page.homePage(user);
		// }

		// validate.userCreds(username, password);
	}

	public static void loginAdmin() {
		TakeInput validate = new Validate();
		Msg.border();
		System.out.print("Enter Username:");
		String username = Action.inputStr();
		System.out.print("Enter Password :");
		String password = Action.inputStr();

		// validate.adminCreds(username, password);
	}
}
