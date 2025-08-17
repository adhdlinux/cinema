package androidx.appcompat.view;

import android.content.Context;
import android.view.ActionMode;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import androidx.appcompat.view.ActionMode;
import androidx.appcompat.view.menu.MenuItemWrapperICS;
import androidx.appcompat.view.menu.MenuWrapperICS;
import androidx.collection.SimpleArrayMap;
import androidx.core.internal.view.SupportMenu;
import androidx.core.internal.view.SupportMenuItem;
import java.util.ArrayList;

public class SupportActionModeWrapper extends ActionMode {

    /* renamed from: a  reason: collision with root package name */
    final Context f678a;

    /* renamed from: b  reason: collision with root package name */
    final ActionMode f679b;

    public static class CallbackWrapper implements ActionMode.Callback {

        /* renamed from: a  reason: collision with root package name */
        final ActionMode.Callback f680a;

        /* renamed from: b  reason: collision with root package name */
        final Context f681b;

        /* renamed from: c  reason: collision with root package name */
        final ArrayList<SupportActionModeWrapper> f682c = new ArrayList<>();

        /* renamed from: d  reason: collision with root package name */
        final SimpleArrayMap<Menu, Menu> f683d = new SimpleArrayMap<>();

        public CallbackWrapper(Context context, ActionMode.Callback callback) {
            this.f681b = context;
            this.f680a = callback;
        }

        private Menu f(Menu menu) {
            Menu menu2 = this.f683d.get(menu);
            if (menu2 != null) {
                return menu2;
            }
            MenuWrapperICS menuWrapperICS = new MenuWrapperICS(this.f681b, (SupportMenu) menu);
            this.f683d.put(menu, menuWrapperICS);
            return menuWrapperICS;
        }

        public void a(ActionMode actionMode) {
            this.f680a.onDestroyActionMode(e(actionMode));
        }

        public boolean b(ActionMode actionMode, Menu menu) {
            return this.f680a.onCreateActionMode(e(actionMode), f(menu));
        }

        public boolean c(ActionMode actionMode, MenuItem menuItem) {
            return this.f680a.onActionItemClicked(e(actionMode), new MenuItemWrapperICS(this.f681b, (SupportMenuItem) menuItem));
        }

        public boolean d(ActionMode actionMode, Menu menu) {
            return this.f680a.onPrepareActionMode(e(actionMode), f(menu));
        }

        public android.view.ActionMode e(ActionMode actionMode) {
            int size = this.f682c.size();
            for (int i2 = 0; i2 < size; i2++) {
                SupportActionModeWrapper supportActionModeWrapper = this.f682c.get(i2);
                if (supportActionModeWrapper != null && supportActionModeWrapper.f679b == actionMode) {
                    return supportActionModeWrapper;
                }
            }
            SupportActionModeWrapper supportActionModeWrapper2 = new SupportActionModeWrapper(this.f681b, actionMode);
            this.f682c.add(supportActionModeWrapper2);
            return supportActionModeWrapper2;
        }
    }

    public SupportActionModeWrapper(Context context, ActionMode actionMode) {
        this.f678a = context;
        this.f679b = actionMode;
    }

    public void finish() {
        this.f679b.c();
    }

    public View getCustomView() {
        return this.f679b.d();
    }

    public Menu getMenu() {
        return new MenuWrapperICS(this.f678a, (SupportMenu) this.f679b.e());
    }

    public MenuInflater getMenuInflater() {
        return this.f679b.f();
    }

    public CharSequence getSubtitle() {
        return this.f679b.g();
    }

    public Object getTag() {
        return this.f679b.h();
    }

    public CharSequence getTitle() {
        return this.f679b.i();
    }

    public boolean getTitleOptionalHint() {
        return this.f679b.j();
    }

    public void invalidate() {
        this.f679b.k();
    }

    public boolean isTitleOptional() {
        return this.f679b.l();
    }

    public void setCustomView(View view) {
        this.f679b.m(view);
    }

    public void setSubtitle(CharSequence charSequence) {
        this.f679b.o(charSequence);
    }

    public void setTag(Object obj) {
        this.f679b.p(obj);
    }

    public void setTitle(CharSequence charSequence) {
        this.f679b.r(charSequence);
    }

    public void setTitleOptionalHint(boolean z2) {
        this.f679b.s(z2);
    }

    public void setSubtitle(int i2) {
        this.f679b.n(i2);
    }

    public void setTitle(int i2) {
        this.f679b.q(i2);
    }
}
