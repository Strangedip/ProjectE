package user;

import java.util.HashSet;

import page.Task;
import util.Msg;

public class School {
    public static HashSet<Task> taskList = new HashSet<>();
    public static void viewTaskList() {
        for (Task task : taskList) {
            taskDesc(task);
        }

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

    }
}
