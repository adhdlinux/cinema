package androidx.appcompat.view;

import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;

public abstract class ActionMode {

    /* renamed from: b  reason: collision with root package name */
    private Object f663b;

    /* renamed from: c  reason: collision with root package name */
    private boolean f664c;

    public interface Callback {
        void a(ActionMode actionMode);

        boolean b(ActionMode actionMode, Menu menu);

        boolean c(ActionMode actionMode, MenuItem menuItem);

        boolean d(ActionMode actionMode, Menu menu);
    }

    public abstract void c();

    public abstract View d();

    public abstract Menu e();

    public abstract MenuInflater f();

    public abstract CharSequence g();

    public Object h() {
        return this.f663b;
    }

    public abstract CharSequence i();

    public boolean j() {
        return this.f664c;
    }

    public abstract void k();

    public boolean l() {
        return false;
    }

    public abstract void m(View view);

    public abstract void n(int i2);

    public abstract void o(CharSequence charSequence);

    public void p(Object obj) {
        this.f663b = obj;
    }

    public abstract void q(int i2);

    public abstract void r(CharSequence charSequence);

    public void s(boolean z2) {
        this.f664c = z2;
    }
}
