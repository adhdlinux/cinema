package com.google.android.material.internal;

import android.content.Context;
import android.view.SubMenu;
import androidx.appcompat.view.menu.MenuBuilder;
import androidx.appcompat.view.menu.MenuItemImpl;

public class NavigationMenu extends MenuBuilder {
    public NavigationMenu(Context context) {
        super(context);
    }

    public SubMenu addSubMenu(int i2, int i3, int i4, CharSequence charSequence) {
        MenuItemImpl menuItemImpl = (MenuItemImpl) a(i2, i3, i4, charSequence);
        NavigationSubMenu navigationSubMenu = new NavigationSubMenu(w(), this, menuItemImpl);
        menuItemImpl.x(navigationSubMenu);
        return navigationSubMenu;
    }
}
