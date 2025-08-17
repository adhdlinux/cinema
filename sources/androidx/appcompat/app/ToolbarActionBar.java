package androidx.appcompat.app;

import android.content.Context;
import android.content.res.Configuration;
import android.graphics.drawable.Drawable;
import android.view.KeyCharacterMap;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatDelegateImpl;
import androidx.appcompat.view.menu.MenuBuilder;
import androidx.appcompat.view.menu.MenuPresenter;
import androidx.appcompat.widget.DecorToolbar;
import androidx.appcompat.widget.Toolbar;
import androidx.appcompat.widget.ToolbarWidgetWrapper;
import androidx.core.util.Preconditions;
import androidx.core.view.ViewCompat;
import java.util.ArrayList;

class ToolbarActionBar extends ActionBar {

    /* renamed from: a  reason: collision with root package name */
    final DecorToolbar f511a;

    /* renamed from: b  reason: collision with root package name */
    final Window.Callback f512b;

    /* renamed from: c  reason: collision with root package name */
    final AppCompatDelegateImpl.ActionBarMenuCallback f513c;

    /* renamed from: d  reason: collision with root package name */
    boolean f514d;

    /* renamed from: e  reason: collision with root package name */
    private boolean f515e;

    /* renamed from: f  reason: collision with root package name */
    private boolean f516f;

    /* renamed from: g  reason: collision with root package name */
    private ArrayList<ActionBar.OnMenuVisibilityListener> f517g = new ArrayList<>();

    /* renamed from: h  reason: collision with root package name */
    private final Runnable f518h = new Runnable() {
        public void run() {
            ToolbarActionBar.this.F();
        }
    };

    /* renamed from: i  reason: collision with root package name */
    private final Toolbar.OnMenuItemClickListener f519i;

    private final class ActionMenuPresenterCallback implements MenuPresenter.Callback {

        /* renamed from: b  reason: collision with root package name */
        private boolean f522b;

        ActionMenuPresenterCallback() {
        }

        public void a(MenuBuilder menuBuilder, boolean z2) {
            if (!this.f522b) {
                this.f522b = true;
                ToolbarActionBar.this.f511a.s();
                ToolbarActionBar.this.f512b.onPanelClosed(108, menuBuilder);
                this.f522b = false;
            }
        }

        public boolean b(MenuBuilder menuBuilder) {
            ToolbarActionBar.this.f512b.onMenuOpened(108, menuBuilder);
            return true;
        }
    }

    private final class MenuBuilderCallback implements MenuBuilder.Callback {
        MenuBuilderCallback() {
        }

        public boolean a(MenuBuilder menuBuilder, MenuItem menuItem) {
            return false;
        }

        public void b(MenuBuilder menuBuilder) {
            if (ToolbarActionBar.this.f511a.e()) {
                ToolbarActionBar.this.f512b.onPanelClosed(108, menuBuilder);
            } else if (ToolbarActionBar.this.f512b.onPreparePanel(0, (View) null, menuBuilder)) {
                ToolbarActionBar.this.f512b.onMenuOpened(108, menuBuilder);
            }
        }
    }

    private class ToolbarMenuCallback implements AppCompatDelegateImpl.ActionBarMenuCallback {
        ToolbarMenuCallback() {
        }

        public boolean a(int i2) {
            if (i2 != 0) {
                return false;
            }
            ToolbarActionBar toolbarActionBar = ToolbarActionBar.this;
            if (toolbarActionBar.f514d) {
                return false;
            }
            toolbarActionBar.f511a.f();
            ToolbarActionBar.this.f514d = true;
            return false;
        }

        public View onCreatePanelView(int i2) {
            if (i2 == 0) {
                return new View(ToolbarActionBar.this.f511a.getContext());
            }
            return null;
        }
    }

    ToolbarActionBar(Toolbar toolbar, CharSequence charSequence, Window.Callback callback) {
        AnonymousClass2 r02 = new Toolbar.OnMenuItemClickListener() {
            public boolean onMenuItemClick(MenuItem menuItem) {
                return ToolbarActionBar.this.f512b.onMenuItemSelected(0, menuItem);
            }
        };
        this.f519i = r02;
        Preconditions.g(toolbar);
        ToolbarWidgetWrapper toolbarWidgetWrapper = new ToolbarWidgetWrapper(toolbar, false);
        this.f511a = toolbarWidgetWrapper;
        this.f512b = (Window.Callback) Preconditions.g(callback);
        toolbarWidgetWrapper.setWindowCallback(callback);
        toolbar.setOnMenuItemClickListener(r02);
        toolbarWidgetWrapper.setWindowTitle(charSequence);
        this.f513c = new ToolbarMenuCallback();
    }

    private Menu E() {
        if (!this.f515e) {
            this.f511a.w(new ActionMenuPresenterCallback(), new MenuBuilderCallback());
            this.f515e = true;
        }
        return this.f511a.k();
    }

    public void A(CharSequence charSequence) {
        this.f511a.j(charSequence);
    }

    public void B(CharSequence charSequence) {
        this.f511a.setTitle(charSequence);
    }

    public void C(CharSequence charSequence) {
        this.f511a.setWindowTitle(charSequence);
    }

    /* access modifiers changed from: package-private */
    public void F() {
        MenuBuilder menuBuilder;
        Menu E = E();
        if (E instanceof MenuBuilder) {
            menuBuilder = (MenuBuilder) E;
        } else {
            menuBuilder = null;
        }
        if (menuBuilder != null) {
            menuBuilder.h0();
        }
        try {
            E.clear();
            if (!this.f512b.onCreatePanelMenu(0, E) || !this.f512b.onPreparePanel(0, (View) null, E)) {
                E.clear();
            }
        } finally {
            if (menuBuilder != null) {
                menuBuilder.g0();
            }
        }
    }

    public boolean f() {
        return this.f511a.b();
    }

    public boolean g() {
        if (!this.f511a.h()) {
            return false;
        }
        this.f511a.collapseActionView();
        return true;
    }

    public void h(boolean z2) {
        if (z2 != this.f516f) {
            this.f516f = z2;
            int size = this.f517g.size();
            for (int i2 = 0; i2 < size; i2++) {
                this.f517g.get(i2).onMenuVisibilityChanged(z2);
            }
        }
    }

    public int i() {
        return this.f511a.y();
    }

    public Context j() {
        return this.f511a.getContext();
    }

    public boolean k() {
        this.f511a.n().removeCallbacks(this.f518h);
        ViewCompat.j0(this.f511a.n(), this.f518h);
        return true;
    }

    public void l(Configuration configuration) {
        super.l(configuration);
    }

    /* access modifiers changed from: package-private */
    public void m() {
        this.f511a.n().removeCallbacks(this.f518h);
    }

    public boolean n(int i2, KeyEvent keyEvent) {
        int i3;
        Menu E = E();
        if (E == null) {
            return false;
        }
        if (keyEvent != null) {
            i3 = keyEvent.getDeviceId();
        } else {
            i3 = -1;
        }
        boolean z2 = true;
        if (KeyCharacterMap.load(i3).getKeyboardType() == 1) {
            z2 = false;
        }
        E.setQwertyMode(z2);
        return E.performShortcut(i2, keyEvent, 0);
    }

    public boolean o(KeyEvent keyEvent) {
        if (keyEvent.getAction() == 1) {
            p();
        }
        return true;
    }

    public boolean p() {
        return this.f511a.c();
    }

    public void q(boolean z2) {
    }

    public void r(boolean z2) {
        s(z2 ? 4 : 0, 4);
    }

    public void s(int i2, int i3) {
        this.f511a.i((i2 & i3) | ((~i3) & this.f511a.y()));
    }

    public void t(boolean z2) {
        s(z2 ? 2 : 0, 2);
    }

    public void u(boolean z2) {
        s(z2 ? 8 : 0, 8);
    }

    public void v(int i2) {
        this.f511a.p(i2);
    }

    public void w(int i2) {
        this.f511a.v(i2);
    }

    public void x(Drawable drawable) {
        this.f511a.A(drawable);
    }

    public void y(boolean z2) {
    }

    public void z(boolean z2) {
    }
}
