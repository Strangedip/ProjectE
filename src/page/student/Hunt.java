package page.student;

import main.Home;
import user.User;
import util.Actions;
import util.Msg;

public class Hunt implements PageTemplate {
    // reward hunting page
    public void page(User user) {
        Msg.newSection();
        Msg.huntPageHeader();
        rewardHunt();
    }

    
    public void rewardHunt() {
        System.out.println("TASK for REWARD");
        System.out.println();
        Task.task1.taskDesc();
        Task.task2.taskDesc();
        Task.task3.taskDesc();
        Task.task4.taskDesc();
    }

    // options available at every page
    public void pageOptions() {
        Msg.border();
        System.out.println("1.Your Tasks      2.Shopping         3.Home page");
        System.out.println("4.Update Profile  5.Account Details  6.Log out");
    }

    public void assignTask(User user, Task task) {
        Msg.border();
        // check if the same task is already existing is the task list
        if (!user.addTask(task)) {
            System.out.println("you have already been assigned with this task Check Your Task Section");
            Actions.hold();
            Page.hunt(user);
        } else {
            System.out.print("(Optional) enter 'done' if completed else any other key -> ");
            switch (Actions.inputStr()) {
                case "done":
                    Msg.success();
                    System.out.println("Your account has been credited with " + task.taskReward + " Elite Points");
                    user.setAccountBal(user.getAccountBal() + task.taskReward);
                    System.out.println("Task ID " + task.taskID + " has been removed from ur list");
                    user.taskList.remove(task);
                    Msg.border();
                    System.out.println("Task ID " + task.taskID + " has been Closed");
                    task.taskStatus = "Closed";
                    Actions.hold();
                    Page.hunt(user);
                    break;
                default:
                    System.out.println("You have been assigned with task ID : " + task.taskID);
                    System.out.println("Please complete task as soon as possible");
                    Actions.hold();
                    Page.hunt(user);
                    break;
            }
        }

    }

    // input for pageOptions
    public void pageInput(User user) {
        Msg.border();
        System.out.print("Enter TaskID or Option -> ");
        try {
            switch (Actions.inputInt()) {
                case 1:
                    Page.userTasks(user);
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
                case 11:
                    if (Task.task1.taskStatus.equals("Open")) {
                        assignTask(user, Task.task1);
                    } else {
                        Msg.error();
                        System.out.println("Task has been closed or completed, try different one");
                        Actions.hold();
                        Page.hunt(user);
                    }
                    break;
                case 12:
                    if (Task.task2.taskStatus.equals("Open")) {
                        assignTask(user, Task.task2);
                    } else {
                        Msg.error();
                        System.out.println("Task has been closed or completed, try different one");
                        Actions.hold();
                        Page.hunt(user);
                    }
                    break;
                case 13:
                    if (Task.task3.taskStatus.equals("Open")) {
                        assignTask(user, Task.task3);
                    } else {
                        Msg.error();
                        System.out.println("Task has been closed or completed, try different one");
                        Actions.hold();
                        Page.hunt(user);
                    }
                    break;
                case 14:
                    if (Task.task4.taskStatus.equals("Open")) {
                        assignTask(user, Task.task4);
                    } else {
                        Msg.error();
                        System.out.println("Task has been closed or completed, try different one");
                        Actions.hold();
                        Page.hunt(user);
                    }
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
