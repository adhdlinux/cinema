package androidx.fragment.app;

import android.content.Context;
import android.content.res.Configuration;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import androidx.core.util.Preconditions;
import androidx.lifecycle.ViewModelStoreOwner;

public class FragmentController {

    /* renamed from: a  reason: collision with root package name */
    private final FragmentHostCallback<?> f3397a;

    private FragmentController(FragmentHostCallback<?> fragmentHostCallback) {
        this.f3397a = fragmentHostCallback;
    }

    public static FragmentController b(FragmentHostCallback<?> fragmentHostCallback) {
        return new FragmentController((FragmentHostCallback) Preconditions.h(fragmentHostCallback, "callbacks == null"));
    }

    public void a(Fragment fragment) {
        FragmentHostCallback<?> fragmentHostCallback = this.f3397a;
        fragmentHostCallback.f3403f.l(fragmentHostCallback, fragmentHostCallback, fragment);
    }

    public void c() {
        this.f3397a.f3403f.z();
    }

    public void d(Configuration configuration) {
        this.f3397a.f3403f.B(configuration);
    }

    public boolean e(MenuItem menuItem) {
        return this.f3397a.f3403f.C(menuItem);
    }

    public void f() {
        this.f3397a.f3403f.D();
    }

    public boolean g(Menu menu, MenuInflater menuInflater) {
        return this.f3397a.f3403f.E(menu, menuInflater);
    }

    public void h() {
        this.f3397a.f3403f.F();
    }

    public void i() {
        this.f3397a.f3403f.H();
    }

    public void j(boolean z2) {
        this.f3397a.f3403f.I(z2);
    }

    public boolean k(MenuItem menuItem) {
        return this.f3397a.f3403f.K(menuItem);
    }

    public void l(Menu menu) {
        this.f3397a.f3403f.L(menu);
    }

    public void m() {
        this.f3397a.f3403f.N();
    }

    public void n(boolean z2) {
        this.f3397a.f3403f.O(z2);
    }

    public boolean o(Menu menu) {
        return this.f3397a.f3403f.P(menu);
    }

    public void p() {
        this.f3397a.f3403f.R();
    }

    public void q() {
        this.f3397a.f3403f.S();
    }

    public void r() {
        this.f3397a.f3403f.U();
    }

    public boolean s() {
        return this.f3397a.f3403f.b0(true);
    }

    public FragmentManager t() {
        return this.f3397a.f3403f;
    }

    public void u() {
        this.f3397a.f3403f.U0();
    }

    public View v(View view, String str, Context context, AttributeSet attributeSet) {
        return this.f3397a.f3403f.v0().onCreateView(view, str, context, attributeSet);
    }

    public void w(Parcelable parcelable) {
        FragmentHostCallback<?> fragmentHostCallback = this.f3397a;
        if (fragmentHostCallback instanceof ViewModelStoreOwner) {
            fragmentHostCallback.f3403f.k1(parcelable);
            return;
        }
        throw new IllegalStateException("Your FragmentHostCallback must implement ViewModelStoreOwner to call restoreSaveState(). Call restoreAllState()  if you're still using retainNestedNonConfig().");
    }

    public Parcelable x() {
        return this.f3397a.f3403f.m1();
    }
}
