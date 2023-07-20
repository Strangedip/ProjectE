package page;

import java.util.Scanner;

import user.User;
import util.Msg;

//Home Page class containing format and action of home page 
public class HomePage {
    public static void page(User user) {
        Msg.header();
        user.details();
        Page.homePageOptions();
        Page.pageInput(user);
    }

}
