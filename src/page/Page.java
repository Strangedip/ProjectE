package page;

import user.User;

// page class containing all page calling methods
public class Page {
    // profile page shows details of the user
    public static void profilePage(User user) {
        user.details();
    }

    // calling all homepage method for home page
    public static void homePage(User user) {
        PageTemplate home=new HomePage();
        home.page(user);
        home.pageOptions();
        home.pageInput(user);
    }

    //calling all shop methods for shop page
    public static void shop(User user) {
        PageTemplate shop =new Shop();
        shop.page(user);
        shop.pageOptions();
        shop.pageInput(user);
    }

    public static void accountInfo() {

    }

    public static void hunt() {

    }

    public static void updateAccountDetails() {

    }

}
