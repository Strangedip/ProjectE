package page.faculty;

import user.User;

public class Faculty {
    public static void homePage(User user) {
        HomePage home = new HomePage();
        home.page(user);
        home.pageOptions();
        home.pageInput(user);
    }
}