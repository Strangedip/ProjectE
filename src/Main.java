import java.util.Scanner;

class Action {
	public static int inputInt() {
		Scanner in = new Scanner(System.in);
		int input = in.nextInt();
		in.close();
		return input;
	}
}

class Members {

}

class Home {
	public void menu() {
		System.out.println("menu");
		int userInput=Action.inputInt();
		switch (userInput) {
			case 1:
				System.out.println("one selected");
				break;
			default:
				System.out.println("default");
				break;
		}


	}

}

public class Main {

	public static void main(String[] args) {
		Home home = new Home();
		home.menu();
	}

}
