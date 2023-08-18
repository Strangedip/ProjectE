package page.admin;

import java.util.Scanner;

import page.student.Task;
import user.School;
import user.TaskRequest;
import user.User;
import util.Actions;
import util.Msg;

public class AdminAction {
    public static void studentList(User admin) {
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
        AdminPage.homePage(admin);
    }

    public static void viewAllUsers() {
        for (User user : School.userList) {
            user.details();
        }
        Msg.border();
    }

    public static void resetUser(User admin) {
        System.out.print("Enter User EliteID : ");
        Scanner in = new Scanner(System.in);
        try {
            int currentEliteID = in.nextInt();
            System.out.println("Are your Sure you want Reset User Stats from System? (y/n)");
            switch (in.next()) {
                case "y":
                    for (User user : School.userList) {
                        if (user.eliteID == currentEliteID) {
                            Msg.success();
                            System.out.println("User Stat has been reset");
                            user.reset();
                            return;
                        }
                    }
                    System.out.println("No Such User found");
                    break;
                case "n":
                    AdminPage.homePage(admin);
                    break;
                default:
                    Msg.error();
                    System.out.println("Enter valid Option");
                    AdminPage.homePage(admin);
                    break;
            }

        } catch (Exception e) {
            System.out.println("Invalid Input");
            AdminPage.homePage(admin);
        }
    }

    public static void removeUser(User admin) {
        System.out.print("Enter User EliteID : ");
        Scanner in = new Scanner(System.in);
        try {
            int currentEliteID = in.nextInt();
            System.out.println("Are your Sure you want to remove user from System? (y/n)");
            switch (in.next()) {
                case "y":
                    for (int i = 0; i < School.userList.size(); i++) {
                        if (School.userList.get(i).eliteID == currentEliteID) {
                            System.out.println(
                                    "User " + School.userList.get(i).eliteID + " has been removed from System");
                            School.userList.remove(i);
                            return;
                        }
                    }
                    System.out.println("No Such User found");
                    break;
                case "n":
                    AdminPage.homePage(admin);
                default:
                    Msg.error();
                    System.out.println("Enter valid Option");
                    AdminPage.homePage(admin);
                    break;
            }

            // for (User user : School.userList) {
            // if (user.eliteID == currentEliteID) {
            // Msg.success();
            // System.out.println("User has been removed from System");
            // user = null;
            // System.out.println(School.userList);
            // return;
            // }
            // }

        } catch (Exception e) {
            System.out.println("Invalid Input");
            AdminPage.homePage(admin);
        }
    }

    public static void addNewTask(User admin) {
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
            AdminPage.homePage(admin);
        } catch (Exception e) {
            Msg.error();
            System.out.println("Invalid Input!");
            addNewTask(admin);
        }
    }

    public static void viewTaskList(User admin) {
        School.viewTaskList();
        Actions.hold();
        AdminPage.homePage(admin);
    }

    public static void verifyTask(User admin) {
        viewTaskRequestList(admin);
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
                verifyTask(admin);
            } else {
                changeTaskRequestStatus(admin, currentTr);
            }
        } catch (Exception e) {
            Msg.error();
            System.out.println("Invalid Task Request ID : ");
            verifyTask(admin);
        }
    }

    public static void changeTaskRequestStatus(User admin, TaskRequest tr) {
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
                        "Task Request ID " + tr.requestId
                                + " has been Approved and removed from Task Request List and Student Task List");
                tr.task.taskStatus = "Closed";
                removeTaskRequest(tr);
                tr.user.taskList.remove(tr.task);
                tr.user.setAccountBal(tr.user.getAccountBal() + tr.task.taskReward);
                System.out.println("Student has been rewarded with " + tr.task.taskReward + " Elite Points");
                Actions.hold();
                AdminPage.homePage(admin);
                break;
            case "b":
                Msg.success();
                System.out.println("Task Request ID " + tr.requestId
                        + " has been Rejected and removed from Task Request List and Student Task List");
                removeTaskRequest(tr);
                tr.user.taskList.remove(tr.task);
                Actions.hold();
                AdminPage.homePage(admin);
                break;
            case "c":
                AdminPage.homePage(admin);
                break;
            default:
                Msg.error();
                System.out.println("Invalid Input");
                changeTaskRequestStatus(admin, tr);
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

    public static void viewTaskRequestList(User admin) {
        if (School.taskRequestList.isEmpty()) {
            System.out.println("There are no Task Verification Request.");
            Actions.hold();
            AdminPage.homePage(admin);
        } else {
            for (TaskRequest tr : School.taskRequestList) {
                tr.details();
            }
        }
    }

    public static void studentInfo(User admin) {
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
            AdminPage.homePage(admin);
        } else {
            student.profile();
            Actions.hold();
            AdminPage.homePage(admin);
        }
    }
}
