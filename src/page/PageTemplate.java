package page;

import user.User;

public interface PageTemplate {
    public void page(User user);

    public void pageOptions();

    public void pageInput(User user);
}
