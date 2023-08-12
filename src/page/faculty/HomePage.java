package page.faculty;

import main.Home;
import page.student.Profile;
import user.User;
import util.Actions;
import util.Msg;

public class HomePage implements PageTemplate {
    public void page(User user) {
        Msg.newSection();
        Msg.homePageHeader();
        System.out.println(" Teacher or Faculty page here");
    }

    public void pageOptions() {
        Msg.border();
        System.out.println("1.Student Details   2.List of Students    3.Logout");
        System.out.println("4.Task List         5.Add New Task        6.Task Verification");
        System.out.println("7.Your Profile      8.Account Details     9.Update Profile");
    }

    public void pageInput(User user) {
        Msg.border();
        System.out.println("Enter your choice -> ");
        switch (Actions.inputStr()) {
            case "1":
                FacultyAction.studentInfo(user);
                break;
            case "2":
                FacultyAction.studentList(user);
                break;
            case "3":
                Msg.loggedOut();
                Home.menu();
                break;
            case "4":

                break;
            case "5":
                break;
            case "6":
                break;
            case "7":
                break;
            case "8":
                break;
            case "9":
                break;
            default:
                System.out.println("Invali Option, Try Again");
                pageInput(user);
        }
    }
}
