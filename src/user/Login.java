package user;

import util.Action;
import util.Msg;
import util.TakeInput;
import util.Validate;

public class Login {
	public static void login() {
		TakeInput validate=new Validate();
		Msg.border();
		System.out.print("Enter Username:");
		String username = Action.inputStr();
		System.out.print("Enter Password :");
		String password = Action.inputStr();

		validate.userPass(username, password);
	}
}
