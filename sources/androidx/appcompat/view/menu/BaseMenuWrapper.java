package androidx.appcompat.view.menu;

import android.content.Context;
import android.view.MenuItem;
import android.view.SubMenu;
import androidx.collection.SimpleArrayMap;
import androidx.core.internal.view.SupportMenuItem;
import androidx.core.internal.view.SupportSubMenu;

abstract class BaseMenuWrapper {

    /* renamed from: a  reason: collision with root package name */
    final Context f771a;

    /* renamed from: b  reason: collision with root package name */
    private SimpleArrayMap<SupportMenuItem, MenuItem> f772b;

    /* renamed from: c  reason: collision with root package name */
    private SimpleArrayMap<SupportSubMenu, SubMenu> f773c;

    BaseMenuWrapper(Context context) {
        this.f771a = context;
    }

    /* access modifiers changed from: package-private */
    public final MenuItem c(MenuItem menuItem) {
        if (!(menuItem instanceof SupportMenuItem)) {
            return menuItem;
        }
        SupportMenuItem supportMenuItem = (SupportMenuItem) menuItem;
        if (this.f772b == null) {
            this.f772b = new SimpleArrayMap<>();
        }
        MenuItem menuItem2 = this.f772b.get(supportMenuItem);
        if (menuItem2 != null) {
            return menuItem2;
        }
        MenuItemWrapperICS menuItemWrapperICS = new MenuItemWrapperICS(this.f771a, supportMenuItem);
        this.f772b.put(supportMenuItem, menuItemWrapperICS);
        return menuItemWrapperICS;
    }

    /* access modifiers changed from: package-private */
    public final SubMenu d(SubMenu subMenu) {
        if (!(subMenu instanceof SupportSubMenu)) {
            return subMenu;
        }
        SupportSubMenu supportSubMenu = (SupportSubMenu) subMenu;
        if (this.f773c == null) {
            this.f773c = new SimpleArrayMap<>();
        }
        SubMenu subMenu2 = this.f773c.get(supportSubMenu);
        if (subMenu2 != null) {
            return subMenu2;
        }
        SubMenuWrapperICS subMenuWrapperICS = new SubMenuWrapperICS(this.f771a, supportSubMenu);
        this.f773c.put(supportSubMenu, subMenuWrapperICS);
        return subMenuWrapperICS;
    }

    /* access modifiers changed from: package-private */
    public final void e() {
        SimpleArrayMap<SupportMenuItem, MenuItem> simpleArrayMap = this.f772b;
        if (simpleArrayMap != null) {
            simpleArrayMap.clear();
        }
        SimpleArrayMap<SupportSubMenu, SubMenu> simpleArrayMap2 = this.f773c;
        if (simpleArrayMap2 != null) {
            simpleArrayMap2.clear();
        }
    }

    /* access modifiers changed from: package-private */
    public final void f(int i2) {
        if (this.f772b != null) {
            int i3 = 0;
            while (i3 < this.f772b.size()) {
                if (this.f772b.j(i3).getGroupId() == i2) {
                    this.f772b.l(i3);
                    i3--;
                }
                i3++;
            }
        }
    }

    /* access modifiers changed from: package-private */
    public final void g(int i2) {
        if (this.f772b != null) {
            for (int i3 = 0; i3 < this.f772b.size(); i3++) {
                if (this.f772b.j(i3).getItemId() == i2) {
                    this.f772b.l(i3);
                    return;
                }
            }
        }
    }
}
