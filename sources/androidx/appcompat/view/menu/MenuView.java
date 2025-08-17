package androidx.appcompat.view.menu;

public interface MenuView {

    public interface ItemView {
        void c(MenuItemImpl menuItemImpl, int i2);

        boolean d();

        MenuItemImpl getItemData();
    }

    void a(MenuBuilder menuBuilder);
}
