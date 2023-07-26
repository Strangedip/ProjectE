package main;

import java.util.Scanner;

import page.Task;
import user.School;

public class Test {
    static Scanner in = new Scanner(System.in);
    String s;

    public static void main(String[] args) {
        // School obj=new School();
        System.out.println("+++++++++++++");
        School.viewTaskList();
        // creating random tasks for students
        School.taskList.add(new Task(11, "Open", "I am Better", "Be in top 5 in upcoming exam", 50));
        School.taskList.add(new Task(12, "Open", "School Dev", "Design and Build school website UI", 100));
        School.taskList
                .add(new Task(13, "Closed", "Cleaning Master", "Take resposibility of cleaning your class for 1 month",
                        25));
        School.taskList.add(new Task(14, "Open", "Brainer", "Get A+ in Quick Test", 20));
        System.out.println("+++++++++++++");
        School.viewTaskList();
        for (Task task : School.taskList) {
            if (task.taskID == 11) {
                task.taskStatus = "Closed";
            }
        }
        System.out.println("+++++++++++++");
        School.viewTaskList();

    }

}