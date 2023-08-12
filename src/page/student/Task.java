package page.student;

import user.School;

public class Task {
    // creating random tasks for students
    static Task task1 = new Task(11, "Open", "Topper", "Be in top 5 in upcoming exam", 50);
    static Task task2 = new Task(12, "Open", "School Dev", "Design and Build school website UI", 150);
    static Task task3 = new Task(13, "Closed", "Cleaning Master",
            "Take resposibility of cleaning your class for 1 month", 25);
    static Task task4 = new Task(14, "Open", "Brainer", "Get A+ in Quick Test", 20);

    public int taskID;
    public String taskStatus;
    public String taskName;
    public String taskDetail;
    public int taskReward;

    public Task(int ID, String status, String name, String detail, int reward) {
        taskID = ID;
        taskStatus = status;
        taskName = name;
        taskDetail = detail;
        taskReward = reward;
        School.taskList.add(this);
    }

    public void taskDesc() {
        System.out.println("Task ID : " + taskID);
        System.out.println("Status : " + taskStatus);
        System.out.println("Task Name : " + taskName);
        System.out.println("Task Details : " + taskDetail);
        System.out.println("Task Reward : " + taskReward);
        System.out.println();
    }

}
