package page;

import user.User;

//basic template for a page
public interface PageTemplate {
    public void page(User user);

    public void pageOptions();

    public void pageInput(User user);
}
