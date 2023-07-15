package user;

import util.Action;
import util.Msg;
import util.Validate;

public class Login {
	public static void login() {
		Msg.border();
		System.out.print("Enter Username:");
		String username = Action.inputStr();
		System.out.print("Enter Password :");
		String password = Action.inputStr();

		Validate.userPass(username, password);
	}
}
