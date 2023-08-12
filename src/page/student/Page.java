package page.student;

import user.User;

// page class containing all page calling methods
public class Page {
    // profile page shows details of the user
    public static void profilePage(User user) {
        PageTemplate profile = new Profile();
        profile.page(user);
        profile.pageOptions();
        profile.pageInput(user);

    }
    public static void userTasks(User user) {
        PageTemplate tasks = new UserTask();
        tasks.page(user);
        tasks.pageOptions();
        tasks.pageInput(user);

    }

    // calling all homepage method for home page
    public static void homePage(User user) {
        PageTemplate home = new HomePage();
        home.page(user);
        home.pageOptions();
        home.pageInput(user);
    }

    // calling all shop methods for shop page
    public static void shop(User user) {
        PageTemplate shop = new Shop();
        shop.page(user);
        shop.pageOptions();
        shop.pageInput(user);
    }

    public static void accountInfo(User user) {
        PageTemplate accountDetails = new AccountDetails();
        accountDetails.page(user);
        accountDetails.pageOptions();
        accountDetails.pageInput(user);

    }

    public static void hunt(User user) {
        PageTemplate hunt = new Hunt();
        hunt.page(user);
        hunt.pageOptions();
        hunt.pageInput(user);
    }

    public static void updateProfile(User user) {
        PageTemplate updateProfile = new UpdateProfile();
        updateProfile.page(user);
        updateProfile.pageOptions();
        updateProfile.pageInput(user);
    }

}
