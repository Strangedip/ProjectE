package util;

public interface TakeInput {
    public void userCreds(String username, String password);

    public String fullName();
    
    public int age();

    public String gender();
    
    public long mobileNumber();

    public String email();

    public String username();

    public String psw();

    public String confirmPassword(String psw);
}
