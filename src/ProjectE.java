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

	public static long inputLong() {
		long input = in.nextLong();
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
		CreateAccount user = new CreateAccount();
		user.createAccount();
		user.details();
		// user.createUser();
	}

	public static void clscr() {
		//System.out.print("\033[H\033[2J");
		//System.out.flush();  
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

class CreateAccount extends Member {
	void createAccount() {
		Action.clscr();
		System.out.print("Enter First Name: ");
		String fname = Action.inputStr();

		Action.clscr();
		System.out.print("Enter Second Name: ");
		String sname = Action.inputStr();

		name = fname + " " + sname;

		Action.clscr();
		System.out.print("Enter age: ");
		age = Action.inputInt();

		Action.clscr();
		System.out.println("1. Male");
		System.out.println("2. Female");
		System.out.println("3. Other");
		System.out.print("Enter gender: ");
		switch (Action.inputInt()) {
			case 1:
				gender = "Male";
				break;
			case 2:
				gender = "Female";
				break;
			case 3:
				gender = "Other";
				break;
			default:
				System.out.println("Invalid Input, try Again");
		}

		Action.clscr();
		System.out.print("Enter email: ");
		email = Action.inputStr();

		Action.clscr();
		System.out.print("Enter Mobile Number: ");
		mobileNumber = Action.inputLong();

		Action.clscr();
		System.out.print("Enter Username: ");
		username = Action.inputStr();

		Action.clscr();
		System.out.print("Enter Password: ");
		String password = Action.inputStr();

		Action.clscr();
		System.out.print("Enter Re-enter Password: ");
		String confPassword = Action.inputStr();
	}

	void details() {
		System.out.println("#######################\n");
		System.out.println("Name   : " + name);
		System.out.println("Age    : " + age);
		System.out.println("gender : " + gender);
		System.out.println("Mobile : " + mobileNumber);
		System.out.println("Email  : " + email + "\n");
		System.out.println("#######################");
	}
}
class Database{
	
}

class Member {
	int eliteID;
	String name;
	int age;
	String gender;
	String email;
	long mobileNumber;
	String username;
	private String password;

	String accountType = "Saving Account";
	private long accountNumber;
	private int accountLevel = 0;
	private int accountBal = 0;

	void generateAcoountNumber() {
		this.accountNumber = 111l;
	}

	void setPassword(String password) {
		this.password = password;
	}
}

class User extends Member {
	User(int eliteID, String name, int age, String gender, String email, long mobileNumber, String username,
			String password) {
		this.eliteID = eliteID;
		this.name = name;
		this.age = age;
		this.gender = gender;
		this.email = email;
		this.mobileNumber = mobileNumber;
		this.username = username;
		setPassword(password);
		generateAcoountNumber();
	}

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
		Action.clscr();
		Home.menu();
	}

}
