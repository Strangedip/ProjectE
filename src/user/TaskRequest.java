package user;

import page.student.Task;

public class TaskRequest {
    public int requestId;
    public User user;
    public Task task;

    public TaskRequest(User user, Task task) {
        this.user = user;
        this.task = task;
        String tempId = user.eliteID + "" + task.taskID;
        this.requestId = Integer.valueOf(tempId);
        School.taskRequestList.add(this);
    }

    public void details() {
        System.out.println("Requested ID    : " + this.requestId);
        System.out.println("Student EliteID : " + this.user.eliteID);
        System.out.println("Student Name    : " + this.user.name);
        System.out.println("Task Name       : " + this.task.taskName);
        System.out.println("Task Reward     : " + this.task.taskReward);
        System.out.println();
    }
}
