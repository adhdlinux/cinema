package androidx.appcompat.view;

import android.content.Context;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import androidx.appcompat.view.ActionMode;
import androidx.appcompat.view.menu.MenuBuilder;
import androidx.appcompat.widget.ActionBarContextView;
import java.lang.ref.WeakReference;

public class StandaloneActionMode extends ActionMode implements MenuBuilder.Callback {

    /* renamed from: d  reason: collision with root package name */
    private Context f671d;

    /* renamed from: e  reason: collision with root package name */
    private ActionBarContextView f672e;

    /* renamed from: f  reason: collision with root package name */
    private ActionMode.Callback f673f;

    /* renamed from: g  reason: collision with root package name */
    private WeakReference<View> f674g;

    /* renamed from: h  reason: collision with root package name */
    private boolean f675h;

    /* renamed from: i  reason: collision with root package name */
    private boolean f676i;

    /* renamed from: j  reason: collision with root package name */
    private MenuBuilder f677j;

    public StandaloneActionMode(Context context, ActionBarContextView actionBarContextView, ActionMode.Callback callback, boolean z2) {
        this.f671d = context;
        this.f672e = actionBarContextView;
        this.f673f = callback;
        MenuBuilder W = new MenuBuilder(actionBarContextView.getContext()).W(1);
        this.f677j = W;
        W.V(this);
        this.f676i = z2;
    }

    public boolean a(MenuBuilder menuBuilder, MenuItem menuItem) {
        return this.f673f.c(this, menuItem);
    }

    public void b(MenuBuilder menuBuilder) {
        k();
        this.f672e.l();
    }

    public void c() {
        if (!this.f675h) {
            this.f675h = true;
            this.f673f.a(this);
        }
    }

    public View d() {
        WeakReference<View> weakReference = this.f674g;
        if (weakReference != null) {
            return weakReference.get();
        }
        return null;
    }

    public Menu e() {
        return this.f677j;
    }

    public MenuInflater f() {
        return new SupportMenuInflater(this.f672e.getContext());
    }

    public CharSequence g() {
        return this.f672e.getSubtitle();
    }

    public CharSequence i() {
        return this.f672e.getTitle();
    }

    public void k() {
        this.f673f.d(this, this.f677j);
    }

    public boolean l() {
        return this.f672e.j();
    }

    public void m(View view) {
        WeakReference<View> weakReference;
        this.f672e.setCustomView(view);
        if (view != null) {
            weakReference = new WeakReference<>(view);
        } else {
            weakReference = null;
        }
        this.f674g = weakReference;
    }

    public void n(int i2) {
        o(this.f671d.getString(i2));
    }

    public void o(CharSequence charSequence) {
        this.f672e.setSubtitle(charSequence);
    }

    public void q(int i2) {
        r(this.f671d.getString(i2));
    }

    public void r(CharSequence charSequence) {
        this.f672e.setTitle(charSequence);
    }

    public void s(boolean z2) {
        super.s(z2);
        this.f672e.setTitleOptional(z2);
    }
}
