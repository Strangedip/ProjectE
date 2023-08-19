package page.faculty;

import page.admin.AdminPage;
import user.User;
import util.Actions;
import util.Msg;
import util.TakeInput;
import util.Validate;

public class AccountDetails {
    public static void page(User user) {
        Msg.newSection();
        Msg.accountPageHeader();
        AccountDetails current = new AccountDetails();
        current.accountInfo(user);

    }

    TakeInput validate = new Validate();

    void accountInfo(User user) {
        if (validate.checkCurrentPassword(user.password)) {
            System.out.println();
            System.out.println("Account Number : " + user.accountNumber);
            System.out.println("Account Type : " + user.accountType);
            System.out.println("Account level : " + user.accountLevel);
            System.out.println("Account Balance : " + user.getAccountBal() + " Elite Points");
            System.out.println();
            Actions.hold();
            if (user.position.equals("Faculty")) {
                Faculty.homePage(user);
            }
            else if(user.position.equals("Admin")){
                AdminPage.homePage(user);
            }
        }
    }
}
