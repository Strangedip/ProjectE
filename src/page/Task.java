package page;

public class Task {
    int taskID;
    String taskStatus;
    String taskName;
    String taskDetail;
    int taskReward;

    Task(int ID, String status, String name, String detail, int reward) {
        taskID = ID;
        taskStatus = status;
        taskName = name;
        taskDetail = detail;
        taskReward = reward;
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
