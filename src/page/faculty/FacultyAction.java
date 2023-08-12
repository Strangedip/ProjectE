package page.faculty;

import java.util.Scanner;

import user.School;
import user.User;
import util.Actions;
import util.Msg;

public class FacultyAction {
    public static void studentList(User faculty) {
        for (User user : User.userList) {
            if (user.position.equals("Student")) {
                Msg.border();
                System.out.println("Elite ID : " + user.eliteID);
                System.out.println("Name     : " + user.name);
                System.out.println("Mobile   : " + user.mobileNumber);
                System.out.println("Email    : " + user.email);
            }
        }
        Msg.border();
        Actions.hold();
        Faculty.homePage(faculty);
    }
    
    public static void viewTaskList(User faculty) {
        School.viewTaskList();
        Actions.hold();
        Faculty.homePage(faculty);
    }
    public static void studentInfo(User faculty) {
        System.out.println("Enter the Elite ID -> ");
        Scanner in = new Scanner(System.in);
        User student = null;
        int eliteId = in.nextInt();
        for (User user : User.userList) {
            if (user.position.equals("Student")) {
                if (user.eliteID == eliteId) {
                    student = user;
                }
            }
        }
        if (student == null) {
            System.out.println("No Student exist with Elite ID : " + eliteId);
            Actions.hold();
            Faculty.homePage(faculty);
        } else {
            student.details();
            Actions.hold();
            Faculty.homePage(faculty);
        }
    }
}
