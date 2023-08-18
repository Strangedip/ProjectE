package page.admin;

import user.User;

public class AdminPage {
    public static void homePage(User user) {
        HomePage home = new HomePage();
        home.page(user);
        home.pageOptions();
        home.pageInput(user);
    }
}