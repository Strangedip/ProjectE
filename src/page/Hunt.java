package page;

import java.util.Scanner;

import main.Home;
import user.User;
import util.Action;
import util.Msg;

public class Hunt implements PageTemplate {
    // reward hunting page
    public void page(User user) {
        Msg.newSection();
        Msg.huntPageHeader();
        rewardHunt();
    }

    // creating random tasks for students
    Task task1 = new Task(11, "Open", "I am Better", "Be in top 5 in upcoming exam", 50);
    Task task2 = new Task(12, "Open", "School Dev", "Design and Build school website UI", 100);
    Task task3 = new Task(13, "Closed", "Cleaning Master", "Take resposibility of cleaning your class for 1 month", 25);

    public void rewardHunt() {
        System.out.println("TASK for REWARD");
        System.out.println();
        task1.taskDesc();
        task2.taskDesc();
        task3.taskDesc();
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
        boolean exists = false;
        for (Task taskObj : user.tasks) {
            if (taskObj.taskID == task.taskID) {
                exists = true;
            }
        }
        if (exists) {
            System.out.println("you have already been assigned with this task Check Your Task");
        } else {
            System.out.print("(Optional) enter 'done' if completed else any other key -> ");
            switch (Action.inputStr()) {
                case "done":
                    Msg.success();
                    System.out.println("Your account has been credited with " + task.taskReward + " Elite Points");
                    user.setAccountBal(user.getAccountBal() + task.taskReward);
                    System.out.println("Task ID " + task.taskID + " has been removed from ur list");
                    Action.hold();
                    Page.hunt(user);
                    break;
                default:
                    user.tasks.add(task);
                    System.out.println("You have been assigned with task ID : " + task.taskID);
                    System.out.println("Please complete task as soon as possible");
                    Action.hold();
                    Page.hunt(user);
                    break;
            }
        }

    }

    // input for pageOptions
    public void pageInput(User user) {
        Msg.border();
        System.out.print("Enter TaskID or Option -> ");
        Scanner in = new Scanner(System.in);
        try {
            switch (in.nextInt()) {
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
                    Home.menu(user);
                    break;
                case 11:
                    if (task1.taskStatus.equals("Open")) {
                        assignTask(user, task1);
                    } else {
                        Msg.error();
                        System.out.println("Task has been closed or completed, try different one");
                        Action.hold();
                        Page.hunt(user);
                    }
                    break;
                case 12:
                    if (task2.taskStatus.equals("Open")) {
                        assignTask(user, task2);
                    } else {
                        Msg.error();
                        System.out.println("Task has been closed or completed, try different one");
                        Action.hold();
                        Page.hunt(user);
                    }
                    break;
                case 13:
                    if (task3.taskStatus.equals("Open")) {
                        assignTask(user, task3);
                    } else {
                        Msg.error();
                        System.out.println("Task has been closed or completed, try different one");
                        Action.hold();
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
