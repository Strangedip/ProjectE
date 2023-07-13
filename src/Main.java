import java.util.Scanner;


class Action {
	public static int inputInt() {
		Scanner in = new Scanner(System.in);
		int input = in.nextInt();
		in.close();
		return input;
	}
	public static String inputStr() {
		Scanner in = new Scanner(System.in);
		String input = in.next();
		in.close();
		return input;
	}
	public static void login(){
		Login obj=new Login();
		obj.login();
	}
}

class Login{
	String username;
	String password;
	Scanner in=new Scanner(System.in);
	public void login(){
		System.out.println("Enter Username: ");
		username=Action.inputStr();
		System.out.println("Enter Password : ");
		password=Action.inputStr();
		check(username, password);
	}
	
	void check(String username,String password){
		// take user creds from database based username 
		String orgUsername="admin";
		String orgPassword="admin";
		if (username==orgUsername && password==orgPassword){
			System.out.println("Logged in");
			// user home page class or object
		}
		else if(username==orgUsername ){
			System.out.println("Incorrect Password, please try again");
			login();
			//retain username method
		}
		else{
			System.out.println("Incorrect Username and Password, please try again");		
			System.out.println("Enter Q to go to Home");
			System.out.println("Enter any other key to login again");
			if (Action.inputInt()==1){
			login();
			}
			else{
				Home.menu();
			}
		}
	}
}

class Members {

}

class Home {
	public static void menu() {
		System.out.println("1) User Login");
		System.out.println("2) Create new account");
		System.out.println("3) Admin Login");

		int userInput = Action.inputInt();
		switch (userInput) {
			case 1:
				Action.login();
				break;
			default:
				System.out.println("Invalid Input");
				break;
		}
	}

}

public class Main {

	public static void main(String[] args) {
		Home.menu();
	}

}
