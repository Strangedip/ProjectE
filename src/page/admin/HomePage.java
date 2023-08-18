package page.admin;

import main.Home;
import page.faculty.AccountDetails;
import page.faculty.UpdateProfile;
import user.User;
import util.Actions;
import util.Msg;

public class HomePage {
    public void page(User user) {
        Msg.newSection();
        Msg.homePageHeader();
        System.out.println(" Admin is Here!");
        System.out.println();
    }

    public void pageOptions() {
        Msg.border();
        System.out.println(" 1.Student Details    2.List of Students    3.All User List");
        System.out.println(" 4.Task List          5.Add New Task        6.Task Verification");
        System.out.println(" 7.Reset User Stats   8.Remove User         9.Your Profile");
        System.out.println("10.Account Details   11.Update Profile     12.Logout");
    }

    public void pageInput(User user) {
        Msg.border();
        System.out.print("Enter your choice -> ");
        switch (Actions.inputStr()) {
            case "1":
                Msg.newSection();
                System.out.println("   ------------  Student Detail Page  ----------   ");
                System.out.println();
                AdminAction.studentInfo(user);
                break;
            case "2":
                Msg.newSection();
                System.out.println("   -------------  Student List Page  -----------   ");
                System.out.println();
                AdminAction.studentList(user);
                break;
            case "3":
                Msg.newSection();
                System.out.println("   ---------------  All User List  -------------   ");
                System.out.println();
                AdminAction.viewAllUsers();
                Actions.hold();
                AdminPage.homePage(user);
                break;
            case "4":
                Msg.newSection();
                System.out.println("   --------------  Task List Page  -------------   ");
                System.out.println();
                AdminAction.viewTaskList(user);
                break;
            case "5":
                Msg.newSection();
                System.out.println("   ---------------  Add New Task  --------------   ");
                System.out.println();
                AdminAction.addNewTask(user);
                break;
            case "6":
                Msg.newSection();
                System.out.println("   ---------------  Verify Task  ---------------   ");
                System.out.println();
                AdminAction.verifyTask(user);
                break;
            case "7":
                Msg.newSection();
                System.out.println("   -------------  Reset User Stat  -------------   ");
                System.out.println();
                AdminAction.resetUser(user);
                Actions.hold();
                AdminPage.homePage(user);
                break;
            case "8":
                Msg.newSection();
                System.out.println("   ---------------  Remove User  ---------------   ");
                System.out.println();
                AdminAction.removeUser(user);
                Actions.hold();
                AdminPage.homePage(user);
                break;
            case "9":
                user.profile();
                Actions.hold();
                AdminPage.homePage(user);
                break;
            case "10":
                AccountDetails.page(user);
                break;
            case "11":
                UpdateProfile.page(user);
                break;
            case "12":
                Msg.loggedOut();
                Home.menu();
                break;
            default:
                System.out.println("Invalid Option, Try Again");
                pageInput(user);
        }
    }
}
