package page.student;


import main.Home;
import user.User;
import util.Actions;
import util.Msg;

public class UserTask implements PageTemplate {

    public void page(User user) {
        Msg.newSection();
        Msg.taskPageHeader();
        taskList(user);
    }

    public void taskList(User user) {

        //check if task list is empty
        if (user.taskList.isEmpty()) {
            System.out.println("No task assigned yet, Visit Hunt page to get tasks");
        } 
        // else print all taks description in list
        else {
            for (Task task : user.taskList) {
                task.taskDesc();
            }
        }
        Msg.border();
        System.out.println("If you have completed any task please visit Hunt office or faculty for rewards");
        
    }

    public void pageOptions() {
        Msg.border();
        System.out.println("1.Reward Hunt     2.Shopping         3.Home page");
        System.out.println("4.Update Profile  5.Account Details  6.Log out");
    }

    public void pageInput(User user) {
        Msg.border();
        System.out.print("Enter Choice -> ");
        try {
            switch (Actions.inputInt()) {
                case 1:
                    Page.hunt(user);
                    break;
                case 2:
                    Page.shop(user);
                    break;
                case 3:
                    Page.homePage(user);
                    break;
                case 4:
                    Page.updateProfile(user);
                    break;
                case 5:
                    Page.accountInfo(user);
                    break;
                case 6:
                    Msg.loggedOut();
                    Home.menu();
                    break;
                default:
                    System.out.println("Invalid Option");
                    pageInput(user);
            }
        } catch (Exception e) {
            System.out.println("Invalid Input");
            pageInput(user);
        }
    }
}
