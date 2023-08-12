package main;

import user.Admin;
import user.User;

public class Main {
	// default user
	static User defaultUser = new User();

	// admin
	static User adminUser = new Admin("Admin", "Sandip Gupta", 20, "Male", "test@test.com", 9987978402L, "admin",
			"admin", 9999);
	static User facultyUser = new User("Faculty", "Sandip Gupta", 20, "Male", "test@test.com", 9987978402L, "fac",
			"fac");

	public static void main(String[] args) {

		// adding members
		User.addNewMember(adminUser);
		User.addNewMember(defaultUser);
		User.addNewMember(facultyUser);

		// calling home menu
		Home.menu();
	}

}