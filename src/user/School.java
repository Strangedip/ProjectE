package user;

import java.util.ArrayList;

import page.Task;
import util.Msg;

public class School {
    public static ArrayList<Task> taskList=new ArrayList<>();
    // creating random tasks for students
    Task task1 = new Task(11, "Open", "I am Better", "Be in top 5 in upcoming exam", 50);
    Task task2 = new Task(12, "Open", "School Dev", "Design and Build school website UI", 100);
    Task task3 = new Task(13, "Closed", "Cleaning Master", "Take resposibility of cleaning your class for 1 month", 25);

    public static void introduction(){
        Msg.header();
        System.out.println();
        System.out.println("Elite School of India");
        System.out.println("School created to create Elites");
        System.out.println();
        System.out.println("Objective : To provide best students best facilities irrespective of their financial status");
        System.out.println("Founder : Jspiders");
        System.out.println("co-founder : Sandip Gupta");
        System.out.println();
        Msg.border();

    }
}
