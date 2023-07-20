package page;


import user.User;
import util.Msg;

//Home Page class containing format and action of home page 
public class HomePage {

    // home page Page details method
    public static void page(User user) {
        Msg.header();
        user.details();
        Page.homePageOptions();
        Page.pageInput(user);
    }

}
