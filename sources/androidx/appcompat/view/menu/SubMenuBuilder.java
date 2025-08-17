package androidx.appcompat.view.menu;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.Menu;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;
import androidx.appcompat.view.menu.MenuBuilder;

public class SubMenuBuilder extends MenuBuilder implements SubMenu {
    private MenuBuilder B;
    private MenuItemImpl C;

    public SubMenuBuilder(Context context, MenuBuilder menuBuilder, MenuItemImpl menuItemImpl) {
        super(context);
        this.B = menuBuilder;
        this.C = menuItemImpl;
    }

    public MenuBuilder F() {
        return this.B.F();
    }

    public boolean H() {
        return this.B.H();
    }

    public boolean I() {
        return this.B.I();
    }

    public boolean J() {
        return this.B.J();
    }

    public void V(MenuBuilder.Callback callback) {
        this.B.V(callback);
    }

    public boolean f(MenuItemImpl menuItemImpl) {
        return this.B.f(menuItemImpl);
    }

    public MenuItem getItem() {
        return this.C;
    }

    /* access modifiers changed from: package-private */
    public boolean h(MenuBuilder menuBuilder, MenuItem menuItem) {
        if (super.h(menuBuilder, menuItem) || this.B.h(menuBuilder, menuItem)) {
            return true;
        }
        return false;
    }

    public Menu i0() {
        return this.B;
    }

    public boolean m(MenuItemImpl menuItemImpl) {
        return this.B.m(menuItemImpl);
    }

    public void setGroupDividerEnabled(boolean z2) {
        this.B.setGroupDividerEnabled(z2);
    }

    public SubMenu setHeaderIcon(Drawable drawable) {
        return (SubMenu) super.Z(drawable);
    }

    public SubMenu setHeaderTitle(CharSequence charSequence) {
        return (SubMenu) super.c0(charSequence);
    }

    public SubMenu setHeaderView(View view) {
        return (SubMenu) super.d0(view);
    }

    public SubMenu setIcon(Drawable drawable) {
        this.C.setIcon(drawable);
        return this;
    }

    public void setQwertyMode(boolean z2) {
        this.B.setQwertyMode(z2);
    }

    public String v() {
        int i2;
        MenuItemImpl menuItemImpl = this.C;
        if (menuItemImpl != null) {
            i2 = menuItemImpl.getItemId();
        } else {
            i2 = 0;
        }
        if (i2 == 0) {
            return null;
        }
        return super.v() + ":" + i2;
    }

    public SubMenu setHeaderIcon(int i2) {
        return (SubMenu) super.Y(i2);
    }

    public SubMenu setHeaderTitle(int i2) {
        return (SubMenu) super.b0(i2);
    }

    public SubMenu setIcon(int i2) {
        this.C.setIcon(i2);
        return this;
    }
}
