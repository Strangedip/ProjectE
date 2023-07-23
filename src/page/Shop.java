package page;

import java.util.Scanner;

import main.Home;
import user.User;
import util.Action;
import util.Msg;

abstract class ShopItem {
    public String name;
    public int price;

    abstract public void desc();
}

class Item1 extends ShopItem {
    Item1() {
        name = "HP firefly 15 Laptop";
        price = 2000;
    }

    public void desc() {

        System.out.println("11. " + name);
        System.out.println("Price : " + price);
        System.out.println();
    }
}

class Item2 extends ShopItem {
    Item2() {
        name = "A4 size Notebook (set of 6)";
        price = 25;
    }

    public void desc() {
        System.out.println("12. " + name);
        System.out.println("Price : " + price);
        System.out.println();
    }
}

class Item3 extends ShopItem {
    Item3() {
        name = "Common Lab Kit";
        price = 40;
    }

    public void desc() {
        System.out.println("13. " + name);
        System.out.println("Price : " + price);
        System.out.println();
    }
}

public class Shop implements PageTemplate {
    ShopItem item1 = new Item1();
    ShopItem item2 = new Item2();
    ShopItem item3 = new Item3();

    // shop page
    public void page(User user) {
        Msg.newSection();
        Msg.shopPageHeader();
        shopMenu();
    }

    public void shopMenu() {
        item1.desc();
        item2.desc();
        item3.desc();
    }

    public void buyOptions(User user) {
        Msg.border();
        System.out.println("1.Reward Hunt   2.Home   3.Shop   4.Account Details");
        Msg.border();
        System.out.print("Enter Choice -> ");
        try {
            switch (Action.inputInt()) {
                case 1:
                    System.out.println("Redirecting you to Hunt Page");
                    Page.hunt(user);
                    break;
                case 2:
                    System.out.println("Redirecting you to Home Page");
                    Page.homePage(user);
                    break;
                case 3:
                    System.out.println("Redirecting you to Shop Page");
                    Page.shop(user);
                    break;
                case 4:
                    System.out.println("Redirecting you to Account Details Page");
                    Page.accountInfo(user);
                    break;
                default:
                    System.out.println("Invalid Input");
                    buyOptions(user);
            }
        } catch (Exception e) {
            System.out.println("invalid input");
            buyOptions(user);
        }
    }

    public void buy(User user, ShopItem item) {
        Msg.border();
        System.out.println("You are about to buy " + item.name);
        System.out.println("Buy this item for " + item.price + " Elite Point");
        Msg.border();
        System.out.print("Enter 'y' to buy or 'n' to go back to Shop -> ");
        String choice = Action.inputStr();
        switch (choice) {
            case "y":
                if (user.getAccountBal() >= item.price) {
                    Msg.success();
                    // debiting amount from account
                    user.setAccountBal(user.getAccountBal() - item.price);
                    System.out.println("you baught " + item.name);
                    System.out.println(item.price + " Elite Points has been Deducted from your Elite Account");
                    buyOptions(user);
                } else {
                    Msg.error();
                    System.out.println("Insufficiant Elite Points");
                    System.out.println("Please visit Hunt page to earn Elite Point");
                    buyOptions(user);
                }
                break;
            case "n":
                System.out.println("Redirecting you to Shop Page");
                Page.shop(user);
                break;
            default:
                System.out.println("invalid Input");
                buy(user, item);
                break;
        }
    }

    // options available at every page
    public void pageOptions() {
        Msg.border();
        System.out.println("1.View Profile    2.Home page        3.Reward Hunt");
        System.out.println("4.Update Profile  5.Account Details  6.Log out");
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
                    Page.homePage(user);
                    break;
                case 3:
                    Page.hunt(user);
                    break;
                case 4:
                    Page.updateProfile(user);
                    break;
                case 5:
                    Page.accountInfo(user);
                    break;
                case 6:
                    Msg.loggedOut();
                    Home.menu(user);
                    break;
                case 11:
                    buy(user, item1);
                    break;
                case 12:
                    buy(user, item2);
                    break;
                case 13:
                    buy(user, item3);
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
