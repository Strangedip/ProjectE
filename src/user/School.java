package user;

import java.util.ArrayList;
import java.util.HashSet;

import main.Home;
import page.Task;
import util.Action;
import util.Msg;

public class School {
    public static ArrayList<Task> taskList = new ArrayList<>();

    public static void viewTaskList() {
        for (Task task : taskList) {
            taskDesc(task);
        }

    }

    public static void schoolIntro() {
        Msg.border();
        System.out.println("Our Members");
        for (User user : User.userList) {
            System.out.println();
            System.out.println("Elite ID : " + user.eliteID);
            System.out.println("Name     : " + user.name);
            System.out.println("Position : " + user.position);
        }
        Action.hold();
        Home.menu();
    }

    public static void taskDesc(Task task) {
        System.out.println();
        System.out.println("Task ID : " + task.taskID);
        System.out.println("Status : " + task.taskStatus);
        System.out.println("Task Name : " + task.taskName);
        System.out.println("Task Details : " + task.taskDetail);
        System.out.println("Task Reward : " + task.taskReward);
        System.out.println();
    }

    public static void introduction() {
        Msg.header();
        System.out.println();
        System.out.println("Elite School of India");
        System.out.println("School created to create Elites");
        System.out.println();
        System.out
                .println("Objective : To provide best students best facilities irrespective of their financial status");
        System.out.println("Founder : Jspiders");
        System.out.println("co-founder : Sandip Gupta");
        System.out.println();
        Msg.border();
        System.out.print("enter 'm' to see out members or any other key to go back -> ");
        switch (Action.inputStr()) {
            case "m":

            default:
                Home.menu();
                break;
        }
    }

}
