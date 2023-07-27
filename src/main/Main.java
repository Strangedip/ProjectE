package main;

import user.Admin;
import user.User;

public class Main {
	// default user
	static User defaultUser = new User();

	// admin
	static User adminUser = new Admin("Admin", "Sandip Gupta", 20, "Male", "test@test.com", 9987978402L, "admin",
			"admin", 9999);

	public static void main(String[] args) {

		// adding members
		User.addNewMember(adminUser);
		User.addNewMember(defaultUser);

		// calling home menu
		Home.menu();
	}

}