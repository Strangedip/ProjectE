package page.student;

import user.School;

public class Task {
    // creating random tasks for students
    
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
