package util;

import user.User;
// TakeInput interface while creating new account 
public interface TakeInput {
    public int a=10;

    public void userCreds(String username, String password);

    public void userCreds(String username, String password, User user);

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
