package page.faculty;

import page.admin.AdminPage;
import user.User;
import util.Actions;
import util.Msg;
import util.TakeInput;
import util.Validate;

public class UpdateProfile {
    // page for updating profile
    public static void page(User user) {
        Msg.newSection();
        Msg.updateProfilePageHeader();
        UpdateProfile currentUser = new UpdateProfile();
        currentUser.update(user);
        Actions.hold();
        if (user.position.equals("Faculty")) {
            Faculty.homePage(user);
        } else if (user.position.equals("Admin")) {
            AdminPage.homePage(user);
        }
    }

    void update(User user) {
        System.out.println();
        System.out.println("10.Main Menu        11.Change Name      12.Change Gender");
        System.out.println("13.Change Age       14.Change Number    15.Change Email");
        System.out.println("16.Change Username  17.Change Password");
        pageInput(user);
    }

    // upcasting 100% abstraction
    TakeInput validate = new Validate();

    public void changeName(User user) {
        user.name = validate.fullName();
        Msg.success();
        System.out.println("Your Name has been Updated to : " + user.name);
        Msg.border();

    }

    public void changeGender(User user) {
        user.gender = validate.gender();
        System.out.println("Your Gender has been Updated to : " + user.gender);
        Msg.border();

    }

    public void changeAge(User user) {
        user.age = validate.age();
        System.out.println("Your Age has been Updated to : " + user.age);
        Msg.border();

    }

    public void changeNumber(User user) {
        user.mobileNumber = validate.mobileNumber();
        System.out.println("Your Mobile Number has been Updated to : " + user.mobileNumber);
        Msg.border();

    }

    public void changeEmail(User user) {
        user.email = validate.email();
        System.out.println("Your Email has been Updated to : " + user.email);
        Msg.border();

    }

    public void changeUsername(User user) {
        user.username = validate.username();
        Msg.success();
        System.out.println("Your Username has been Updated to : " + user.username);
        Msg.border();

    }

    public void changePassword(User user) {
        if (validate.checkCurrentPassword(user.password)) {
            user.password = validate.confirmPassword(validate.psw());
        }
        System.out.println("Your Password has been Updated ");
        Msg.border();

    }

    // input for pageOptions
    public void pageInput(User user) {
        Msg.border();
        System.out.print("Enter Choice -> ");
        try {
            switch (Actions.inputInt()) {
                case 10:
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
