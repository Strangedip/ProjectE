package page.faculty;

import java.util.Scanner;

import page.student.Task;
import user.School;
import user.User;
import util.Actions;
import util.Msg;

public class FacultyAction {
    public static void studentList(User faculty) {
        for (User user : School.userList) {
            if (user.position.equals("Student")) {
                Msg.border();
                System.out.println("Elite ID : " + user.eliteID);
                System.out.println("Name     : " + user.name);
                System.out.println("Mobile   : " + user.mobileNumber);
                System.out.println("Email    : " + user.email);
            }
        }
        Msg.border();
        Actions.hold();
        Faculty.homePage(faculty);
    }

    public static void addNewTask(User faculty) {
        try {
            Scanner in = new Scanner(System.in);
            System.out.print("Enter task Name : ");
            String taskName = in.next();
            System.out.print("Enter Task Description (in 30 words): ");
            String taskDesc = in.nextLine();
            taskDesc = in.nextLine();
            System.out.print("Enter Reward Points : ");
            int reward = in.nextInt();
            Task lastTask= School.taskList.get(School.taskList.size()-1);
            int id= lastTask.taskID+1;
            Task newTask= new Task(id, "Open", taskName, taskDesc, reward);
            System.out.println("Task Added Successfully!");
            Actions.hold();
            Faculty.homePage(faculty);
        } catch (Exception e) {
            Msg.error();
            System.out.println("Invalid Input!");
            addNewTask(faculty);
        }
    }

    public static void viewTaskList(User faculty) {
        School.viewTaskList();
        Actions.hold();
        Faculty.homePage(faculty);
    }

    public static void verifyTask(User faculty){
        // need new structure
        System.out.println("need new structure");
        Faculty.homePage(faculty);
    }

    public static void studentInfo(User faculty) {
        System.out.println("Enter the Elite ID -> ");
        Scanner in = new Scanner(System.in);
        User student = null;
        int eliteId = in.nextInt();
        for (User user : School.userList) {
            if (user.position.equals("Student")) {
                if (user.eliteID == eliteId) {
                    student = user;
                }
            }
        }
        if (student == null) {
            System.out.println("No Student exist with Elite ID : " + eliteId);
            Actions.hold();
            Faculty.homePage(faculty);
        } else {
            student.details();
            Actions.hold();
            Faculty.homePage(faculty);
        }
    }
}
