package androidx.appcompat.view.menu;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.SubMenu;
import androidx.core.internal.view.SupportMenu;

public class MenuWrapperICS extends BaseMenuWrapper implements Menu {

    /* renamed from: d  reason: collision with root package name */
    private final SupportMenu f928d;

    public MenuWrapperICS(Context context, SupportMenu supportMenu) {
        super(context);
        if (supportMenu != null) {
            this.f928d = supportMenu;
            return;
        }
        throw new IllegalArgumentException("Wrapped Object can not be null.");
    }

    public MenuItem add(CharSequence charSequence) {
        return c(this.f928d.add(charSequence));
    }

    public int addIntentOptions(int i2, int i3, int i4, ComponentName componentName, Intent[] intentArr, Intent intent, int i5, MenuItem[] menuItemArr) {
        MenuItem[] menuItemArr2;
        MenuItem[] menuItemArr3 = menuItemArr;
        if (menuItemArr3 != null) {
            menuItemArr2 = new MenuItem[menuItemArr3.length];
        } else {
            menuItemArr2 = null;
        }
        int addIntentOptions = this.f928d.addIntentOptions(i2, i3, i4, componentName, intentArr, intent, i5, menuItemArr2);
        if (menuItemArr2 != null) {
            int length = menuItemArr2.length;
            for (int i6 = 0; i6 < length; i6++) {
                menuItemArr3[i6] = c(menuItemArr2[i6]);
            }
        }
        return addIntentOptions;
    }

    public SubMenu addSubMenu(CharSequence charSequence) {
        return d(this.f928d.addSubMenu(charSequence));
    }

    public void clear() {
        e();
        this.f928d.clear();
    }

    public void close() {
        this.f928d.close();
    }

    public MenuItem findItem(int i2) {
        return c(this.f928d.findItem(i2));
    }

    public MenuItem getItem(int i2) {
        return c(this.f928d.getItem(i2));
    }

    public boolean hasVisibleItems() {
        return this.f928d.hasVisibleItems();
    }

    public boolean isShortcutKey(int i2, KeyEvent keyEvent) {
        return this.f928d.isShortcutKey(i2, keyEvent);
    }

    public boolean performIdentifierAction(int i2, int i3) {
        return this.f928d.performIdentifierAction(i2, i3);
    }

    public boolean performShortcut(int i2, KeyEvent keyEvent, int i3) {
        return this.f928d.performShortcut(i2, keyEvent, i3);
    }

    public void removeGroup(int i2) {
        f(i2);
        this.f928d.removeGroup(i2);
    }

    public void removeItem(int i2) {
        g(i2);
        this.f928d.removeItem(i2);
    }

    public void setGroupCheckable(int i2, boolean z2, boolean z3) {
        this.f928d.setGroupCheckable(i2, z2, z3);
    }

    public void setGroupEnabled(int i2, boolean z2) {
        this.f928d.setGroupEnabled(i2, z2);
    }

    public void setGroupVisible(int i2, boolean z2) {
        this.f928d.setGroupVisible(i2, z2);
    }

    public void setQwertyMode(boolean z2) {
        this.f928d.setQwertyMode(z2);
    }

    public int size() {
        return this.f928d.size();
    }

    public MenuItem add(int i2) {
        return c(this.f928d.add(i2));
    }

    public SubMenu addSubMenu(int i2) {
        return d(this.f928d.addSubMenu(i2));
    }

    public MenuItem add(int i2, int i3, int i4, CharSequence charSequence) {
        return c(this.f928d.add(i2, i3, i4, charSequence));
    }

    public SubMenu addSubMenu(int i2, int i3, int i4, CharSequence charSequence) {
        return d(this.f928d.addSubMenu(i2, i3, i4, charSequence));
    }

    public MenuItem add(int i2, int i3, int i4, int i5) {
        return c(this.f928d.add(i2, i3, i4, i5));
    }

    public SubMenu addSubMenu(int i2, int i3, int i4, int i5) {
        return d(this.f928d.addSubMenu(i2, i3, i4, i5));
    }
}
