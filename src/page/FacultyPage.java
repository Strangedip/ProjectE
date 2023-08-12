package page;

import user.User;
import util.Action;
import util.Msg;

public class FacultyPage {
    void homePage(User user) {
        Msg.newSection();
        Msg.homePageHeader();
        System.out.println(" Teacher or Faculty page here");
    }

    void pageOptions() {
        System.out.println("1.Student Details   2.List of Students    3.Logout");
        System.out.println("4.Task List         5.Add New Task        6.Task Verification");
        System.out.println("7.Your Profile      8.Account Details     9.Update Profile");
    }

    void pageInput(User user) {
        Msg.border();
        System.out.println("Enter your choice -> ");
        switch (Action.inputStr()) {
            case "1":
                break;
            case "1":
                break;
            case "1":
                break;
            case "1":
                break;
            case "1":
                break;
            case "1":
                break;
            case "1":
                break;
            case "1":
                break;
            case "1":
                break;
            case "1":
                break;
            case "1":
                break;
            case "1":
                break;
            case "1":
                break;
            case "1":
                break;
        }
    }
}
