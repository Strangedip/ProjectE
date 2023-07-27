package page;

import java.util.Scanner;

import main.Home;
import user.User;
import util.Action;
import util.Msg;
import util.TakeInput;
import util.Validate;

public class UpdateProfile implements PageTemplate {
    // page for updating profile
    public void page(User user) {
        Msg.newSection();
        Msg.updateProfilePageHeader();
        update(user);
    }

    void update(User user) {
        System.out.println();
        System.out.println("11.Change Name      12.Change Gender    13.Change Age");
        System.out.println("14.Change Number    15.Change Email");
        System.out.println("16.Change Username  17.Change Password");
    }

    // options available at every page
    public void pageOptions() {
        Msg.border();
        System.out.println("1.View Profile    2.Shopping         3.Reward Hunt");
        System.out.println("4.Home Page       5.Account Details  6.Log out");
    }

    //upcasting 100% abstraction
    TakeInput validate=new Validate();

    public void changeName(User user) {
        user.name=validate.fullName();
        Msg.success();
        System.out.println("Your Name has been Updated to : "+user.name);
        Msg.border();
        Action.hold();
        Page.updateProfile(user);
    }

    public void changeGender(User user) {
        user.gender=validate.gender();
        System.out.println("Your Gender has been Updated to : "+user.gender);
        Msg.border();
        Action.hold();
        Page.updateProfile(user);
    }

    public void changeAge(User user) {
        user.age=validate.age();
        System.out.println("Your Age has been Updated to : "+user.age);
        Msg.border();
        Action.hold();
        Page.updateProfile(user);

    }

    public void changeNumber(User user) {
        user.mobileNumber=validate.mobileNumber();
        System.out.println("Your Mobile Number has been Updated to : "+user.mobileNumber);
        Msg.border();
        Action.hold();
        Page.updateProfile(user);
    }

    public void changeEmail(User user) {
        user.email=validate.email();
        System.out.println("Your Email has been Updated to : "+user.email);
        Msg.border();
        Action.hold();
        Page.updateProfile(user);

    }

    public void changeUsername(User user) {
        user.username=validate.username();
        Msg.success();
        System.out.println("Your Username has been Updated to : "+user.username);
        Msg.border();
        Action.hold();
        Page.updateProfile(user);

    }

    public void changePassword(User user) {
        if(validate.checkCurrentPassword(user.password)){
            user.password=validate.confirmPassword(validate.psw());
        }
        System.out.println("Your Password has been Updated ");
        Msg.border();
        Action.hold();
        Page.updateProfile(user);

    }

    // input for pageOptions
    public void pageInput(User user) {
        Msg.border();
        System.out.print("Enter Choice -> ");
        Scanner in = new Scanner(System.in);
        try {
            switch (in.nextInt()) {
                case 1:
                    Page.profilePage(user);
                    break;
                case 2:
                    Page.shop(user);
                    break;
                case 3:
                    Page.hunt(user);
                    break;
                case 4:
                    Page.homePage(user);
                    break;
                case 5:
                    Page.accountInfo(user);
                    break;
                case 6:
                    Msg.loggedOut();
                    Home.menu();
                    break;
                case 11:
                    changeName(user);
                    break;
                case 12:
                    changeGender(user);
                    break;
                case 13:
                    changeAge(user);
                    break;
                case 14:
                    changeNumber(user);
                    break;
                case 15:
                    changeEmail(user);
                    break;
                case 16:
                    changeUsername(user);
                    break;
                case 17:
                    changePassword(user);
                    break;
                default:
                    System.out.println("Invalid Option");
                    pageInput(user);
            }
        } catch (Exception e) {
            System.out.println("Invalid Input");
            pageInput(user);
        }
    }

}
