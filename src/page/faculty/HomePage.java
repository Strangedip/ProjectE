package page.faculty;

import main.Home;
import user.User;
import util.Actions;
import util.Msg;

public class HomePage implements PageTemplate {
    public void page(User user) {
        Msg.newSection();
        Msg.homePageHeader();
        System.out.println(" Welcome Respective Faculty!");
        System.out.println();
    }

    public void pageOptions() {
        Msg.border();
        System.out.println("1.Student Details   2.List of Students    3.Logout");
        System.out.println("4.Task List         5.Add New Task        6.Task Verification");
        System.out.println("7.Your Profile      8.Account Details     9.Update Profile");
    }

    public void pageInput(User user) {
        Msg.border();
        System.out.print("Enter your choice -> ");
        switch (Actions.inputStr()) {
            case "1":
                Msg.newSection();
                System.out.println("   ------------  Student Detail Page  ----------   ");
                System.out.println();
                FacultyAction.studentInfo(user);
                break;
            case "2":
                Msg.newSection();
                System.out.println("   -------------  Student List Page  -----------   ");
                System.out.println();
                FacultyAction.studentList(user);
                break;
            case "3":
                Msg.loggedOut();
                Home.menu();
                break;
            case "4":
                Msg.newSection();
                System.out.println("   --------------  Task List Page  -------------   ");
                System.out.println();
                FacultyAction.viewTaskList(user);
                break;
            case "5":
                Msg.newSection();
                System.out.println("   ---------------  Add New Task  --------------   ");
                System.out.println();
                FacultyAction.addNewTask(user);
                break;
            case "6":
                Msg.newSection();
                System.out.println("   ---------------  Verify Task  ---------------   ");
                System.out.println();
                FacultyAction.verifyTask(user);

                break;
            case "7":
                Msg.newSection();
                System.out.println("   ---------------  Your Profile  --------------   ");
                System.out.println();
                user.details();
                Actions.hold();
                Faculty.homePage(user);
                break;
            case "8":
                AccountDetails.page(user);
                break;
            case "9":
                UpdateProfile.page(user);
                break;
            default:
                System.out.println("Invalid Option, Try Again");
                pageInput(user);
        }
    }
}
