package androidx.appcompat.view.menu;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;
import androidx.core.internal.view.SupportSubMenu;

class SubMenuWrapperICS extends MenuWrapperICS implements SubMenu {

    /* renamed from: e  reason: collision with root package name */
    private final SupportSubMenu f952e;

    SubMenuWrapperICS(Context context, SupportSubMenu supportSubMenu) {
        super(context, supportSubMenu);
        this.f952e = supportSubMenu;
    }

    public void clearHeader() {
        this.f952e.clearHeader();
    }

    public MenuItem getItem() {
        return c(this.f952e.getItem());
    }

    public SubMenu setHeaderIcon(int i2) {
        this.f952e.setHeaderIcon(i2);
        return this;
    }

    public SubMenu setHeaderTitle(int i2) {
        this.f952e.setHeaderTitle(i2);
        return this;
    }

    public SubMenu setHeaderView(View view) {
        this.f952e.setHeaderView(view);
        return this;
    }

    public SubMenu setIcon(int i2) {
        this.f952e.setIcon(i2);
        return this;
    }

    public SubMenu setHeaderIcon(Drawable drawable) {
        this.f952e.setHeaderIcon(drawable);
        return this;
    }

    public SubMenu setHeaderTitle(CharSequence charSequence) {
        this.f952e.setHeaderTitle(charSequence);
        return this;
    }

    public SubMenu setIcon(Drawable drawable) {
        this.f952e.setIcon(drawable);
        return this;
    }
}
