package util;

public interface TakeInput {
    public String fullName();
    
    public void userPass(String username, String password);

    public String email();

    public int age();

    public String psw();

    public String confirmPassword(String psw);

    public long mobileNumber();

    public String gender();
}
