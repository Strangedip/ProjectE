package page.faculty;

import java.util.Scanner;

import page.student.Task;
import user.School;
import user.TaskRequest;
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
            Task lastTask = School.taskList.get(School.taskList.size() - 1);
            int id = lastTask.taskID + 1;
            Task newTask = new Task(id, "Open", taskName, taskDesc, reward);
            System.out.println("Task " + newTask.taskID + " has been added successfully!");
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

    public static void verifyTask(User faculty) {
        viewTaskRequestList(faculty);
        Msg.border();
        Scanner in = new Scanner(System.in);
        System.out.print("Enter Task Request ID to verify : ");
        try {
            int currentRequestId = in.nextInt();
            TaskRequest currentTr = null;
            for (TaskRequest tr : School.taskRequestList) {
                if (tr.requestId == currentRequestId) {
                    currentTr = tr;
                }
            }
            if (currentTr == null) {
                Msg.error();
                System.out.println("Invalid Task Request ID : ");
                verifyTask(faculty);
            } else {
                changeTaskRequestStatus(faculty, currentTr);
            }
        } catch (Exception e) {
            Msg.error();
            System.out.println("Invalid Task Request ID : ");
            verifyTask(faculty);
        }
    }

    public static void changeTaskRequestStatus(User faculty, TaskRequest tr) {
        Scanner in = new Scanner(System.in);
        Msg.border();
        System.out.println("a. Approve Request");
        System.out.println("b. Reject Request");
        System.out.println("c. Main Menu");
        System.out.print("Enter your choice : ");
        switch (in.next()) {
            case "a":
                Msg.success();
                System.out.println(
                        "Task Request ID " + tr.requestId + " has been Approved and removed from Task Request List and Student Task List");
                tr.task.taskStatus = "Closed";
                removeTaskRequest(tr);
                tr.user.taskList.remove(tr.task);
                tr.user.setAccountBal(tr.user.getAccountBal() + tr.task.taskReward);
                System.out.println("Student has been rewarded with " + tr.task.taskReward + " Elite Points");
                Actions.hold();
                Faculty.homePage(faculty);
                break;
            case "b":
                Msg.success();
                System.out.println("Task Request ID " + tr.requestId + " has been Rejected and removed from Task Request List and Student Task List");
                removeTaskRequest(tr);
                tr.user.taskList.remove(tr.task);
                Actions.hold();
                Faculty.homePage(faculty);
                break;
            case "c":
                Faculty.homePage(faculty);
                break;
            default:
                Msg.error();
                System.out.println("Invalid Input");
                changeTaskRequestStatus(faculty, tr);
                break;
        }
    }

    public static void removeTaskRequest(TaskRequest currentTr) {
        for (int i = 0; i < School.taskRequestList.size(); i++) {
            if (School.taskRequestList.get(i).requestId == currentTr.requestId) {
                School.taskRequestList.remove(i);
            }
        }
    }

    public static void viewTaskRequestList(User faculty) {
        if (School.taskRequestList.isEmpty()) {
            System.out.println("There are no Task Verification Request.");
            Actions.hold();
            Faculty.homePage(faculty);
        } else {
            for (TaskRequest tr : School.taskRequestList) {
                tr.details();
            }
        }
    }

    public static void studentInfo(User faculty) {
        System.out.print("Enter the Elite ID -> ");
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
            student.profile();
            Actions.hold();
            Faculty.homePage(faculty);
        }
    }
}
