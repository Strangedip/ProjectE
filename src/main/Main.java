package main;

import page.student.Task;
import user.Admin;
import user.School;
import user.User;

public class Main {

	public static Task task1 = new Task(11, "Open", "Topper", "Be in top 5 in upcoming exam", 50);
	public static Task task2 = new Task(12, "Open", "School Dev", "Design and Build school website UI", 150);
	public static Task task3 = new Task(13, "Closed", "Cleaning Master",
			"Take resposibility of cleaning your class for 1 month", 25);
	public static Task task4 = new Task(14, "Open", "Brainer", "Get A+ in Quick Test", 20);

	public static void main(String[] args) {
		// Default user
		new User();

		// Admin User
		new Admin("Admin", "Sandip Gupta", 20, "Male", "test@test.com", 9987978402L, "admin",
				"admin", 9999);

		// Faculty User
		new User("Faculty", "Sandip Gupta", 20, "Male", "test@test.com", 9987978402L, "fac",
				"fac");

		// Student User
		new User("Student", "Sandip Gupta", 20, "Male", "test@test.com", 9987978402L, "stud",
				"stud");

		School.taskList.add(task1);
		School.taskList.add(task2);
		School.taskList.add(task3);
		School.taskList.add(task4);

		// calling home menu
		Home.menu();
	}

}