package androidx.appcompat.widget;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.Menu;
import android.view.ViewGroup;
import android.view.Window;
import androidx.appcompat.view.menu.MenuBuilder;
import androidx.appcompat.view.menu.MenuPresenter;
import androidx.core.view.ViewPropertyAnimatorCompat;

public interface DecorToolbar {
    void A(Drawable drawable);

    boolean a();

    boolean b();

    boolean c();

    void collapseActionView();

    void d(Menu menu, MenuPresenter.Callback callback);

    boolean e();

    void f();

    boolean g();

    Context getContext();

    CharSequence getTitle();

    boolean h();

    void i(int i2);

    void j(CharSequence charSequence);

    Menu k();

    int l();

    ViewPropertyAnimatorCompat m(int i2, long j2);

    ViewGroup n();

    void o(boolean z2);

    void p(int i2);

    void q();

    void r(boolean z2);

    void s();

    void setIcon(int i2);

    void setIcon(Drawable drawable);

    void setTitle(CharSequence charSequence);

    void setWindowCallback(Window.Callback callback);

    void setWindowTitle(CharSequence charSequence);

    void t(ScrollingTabContainerView scrollingTabContainerView);

    void u(int i2);

    void v(int i2);

    void w(MenuPresenter.Callback callback, MenuBuilder.Callback callback2);

    void x(int i2);

    int y();

    void z();
}
