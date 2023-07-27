package util;

// TakeInput interface while creating new account 
public interface TakeInput {

    // public void checkCredential(String username, String password);

    public String position();

    public String fullName();

    public int age();

    public String gender();

    public long mobileNumber();

    public String email();

    public String username();

    public String psw();

    public String confirmPassword(String psw);

    public boolean checkCurrentPassword(String psw);

}
