package androidx.appcompat.widget;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import androidx.appcompat.R$attr;
import androidx.appcompat.R$drawable;
import androidx.appcompat.R$id;
import androidx.appcompat.R$string;
import androidx.appcompat.R$styleable;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.appcompat.view.menu.ActionMenuItem;
import androidx.appcompat.view.menu.MenuBuilder;
import androidx.appcompat.view.menu.MenuPresenter;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.ViewCompat;
import androidx.core.view.ViewPropertyAnimatorCompat;
import androidx.core.view.ViewPropertyAnimatorListenerAdapter;

public class ToolbarWidgetWrapper implements DecorToolbar {

    /* renamed from: a  reason: collision with root package name */
    Toolbar f1504a;

    /* renamed from: b  reason: collision with root package name */
    private int f1505b;

    /* renamed from: c  reason: collision with root package name */
    private View f1506c;

    /* renamed from: d  reason: collision with root package name */
    private View f1507d;

    /* renamed from: e  reason: collision with root package name */
    private Drawable f1508e;

    /* renamed from: f  reason: collision with root package name */
    private Drawable f1509f;

    /* renamed from: g  reason: collision with root package name */
    private Drawable f1510g;

    /* renamed from: h  reason: collision with root package name */
    private boolean f1511h;

    /* renamed from: i  reason: collision with root package name */
    CharSequence f1512i;

    /* renamed from: j  reason: collision with root package name */
    private CharSequence f1513j;

    /* renamed from: k  reason: collision with root package name */
    private CharSequence f1514k;

    /* renamed from: l  reason: collision with root package name */
    Window.Callback f1515l;

    /* renamed from: m  reason: collision with root package name */
    boolean f1516m;

    /* renamed from: n  reason: collision with root package name */
    private ActionMenuPresenter f1517n;

    /* renamed from: o  reason: collision with root package name */
    private int f1518o;

    /* renamed from: p  reason: collision with root package name */
    private int f1519p;

    /* renamed from: q  reason: collision with root package name */
    private Drawable f1520q;

    public ToolbarWidgetWrapper(Toolbar toolbar, boolean z2) {
        this(toolbar, z2, R$string.f214a, R$drawable.f153n);
    }

    private int B() {
        if (this.f1504a.getNavigationIcon() == null) {
            return 11;
        }
        this.f1520q = this.f1504a.getNavigationIcon();
        return 15;
    }

    private void G(CharSequence charSequence) {
        this.f1512i = charSequence;
        if ((this.f1505b & 8) != 0) {
            this.f1504a.setTitle(charSequence);
            if (this.f1511h) {
                ViewCompat.u0(this.f1504a.getRootView(), charSequence);
            }
        }
    }

    private void H() {
        if ((this.f1505b & 4) == 0) {
            return;
        }
        if (TextUtils.isEmpty(this.f1514k)) {
            this.f1504a.setNavigationContentDescription(this.f1519p);
        } else {
            this.f1504a.setNavigationContentDescription(this.f1514k);
        }
    }

    private void I() {
        if ((this.f1505b & 4) != 0) {
            Toolbar toolbar = this.f1504a;
            Drawable drawable = this.f1510g;
            if (drawable == null) {
                drawable = this.f1520q;
            }
            toolbar.setNavigationIcon(drawable);
            return;
        }
        this.f1504a.setNavigationIcon((Drawable) null);
    }

    private void J() {
        Drawable drawable;
        int i2 = this.f1505b;
        if ((i2 & 2) == 0) {
            drawable = null;
        } else if ((i2 & 1) != 0) {
            drawable = this.f1509f;
            if (drawable == null) {
                drawable = this.f1508e;
            }
        } else {
            drawable = this.f1508e;
        }
        this.f1504a.setLogo(drawable);
    }

    public void A(Drawable drawable) {
        this.f1510g = drawable;
        I();
    }

    public void C(View view) {
        View view2 = this.f1507d;
        if (!(view2 == null || (this.f1505b & 16) == 0)) {
            this.f1504a.removeView(view2);
        }
        this.f1507d = view;
        if (view != null && (this.f1505b & 16) != 0) {
            this.f1504a.addView(view);
        }
    }

    public void D(int i2) {
        if (i2 != this.f1519p) {
            this.f1519p = i2;
            if (TextUtils.isEmpty(this.f1504a.getNavigationContentDescription())) {
                p(this.f1519p);
            }
        }
    }

    public void E(Drawable drawable) {
        this.f1509f = drawable;
        J();
    }

    public void F(CharSequence charSequence) {
        this.f1514k = charSequence;
        H();
    }

    public boolean a() {
        return this.f1504a.d();
    }

    public boolean b() {
        return this.f1504a.w();
    }

    public boolean c() {
        return this.f1504a.Q();
    }

    public void collapseActionView() {
        this.f1504a.e();
    }

    public void d(Menu menu, MenuPresenter.Callback callback) {
        if (this.f1517n == null) {
            ActionMenuPresenter actionMenuPresenter = new ActionMenuPresenter(this.f1504a.getContext());
            this.f1517n = actionMenuPresenter;
            actionMenuPresenter.s(R$id.f172g);
        }
        this.f1517n.c(callback);
        this.f1504a.K((MenuBuilder) menu, this.f1517n);
    }

    public boolean e() {
        return this.f1504a.B();
    }

    public void f() {
        this.f1516m = true;
    }

    public boolean g() {
        return this.f1504a.A();
    }

    public Context getContext() {
        return this.f1504a.getContext();
    }

    public CharSequence getTitle() {
        return this.f1504a.getTitle();
    }

    public boolean h() {
        return this.f1504a.v();
    }

    public void i(int i2) {
        View view;
        int i3 = this.f1505b ^ i2;
        this.f1505b = i2;
        if (i3 != 0) {
            if ((i3 & 4) != 0) {
                if ((i2 & 4) != 0) {
                    H();
                }
                I();
            }
            if ((i3 & 3) != 0) {
                J();
            }
            if ((i3 & 8) != 0) {
                if ((i2 & 8) != 0) {
                    this.f1504a.setTitle(this.f1512i);
                    this.f1504a.setSubtitle(this.f1513j);
                } else {
                    this.f1504a.setTitle((CharSequence) null);
                    this.f1504a.setSubtitle((CharSequence) null);
                }
            }
            if ((i3 & 16) != 0 && (view = this.f1507d) != null) {
                if ((i2 & 16) != 0) {
                    this.f1504a.addView(view);
                } else {
                    this.f1504a.removeView(view);
                }
            }
        }
    }

    public void j(CharSequence charSequence) {
        this.f1513j = charSequence;
        if ((this.f1505b & 8) != 0) {
            this.f1504a.setSubtitle(charSequence);
        }
    }

    public Menu k() {
        return this.f1504a.getMenu();
    }

    public int l() {
        return this.f1518o;
    }

    public ViewPropertyAnimatorCompat m(final int i2, long j2) {
        float f2;
        ViewPropertyAnimatorCompat d2 = ViewCompat.d(this.f1504a);
        if (i2 == 0) {
            f2 = 1.0f;
        } else {
            f2 = 0.0f;
        }
        return d2.b(f2).f(j2).h(new ViewPropertyAnimatorListenerAdapter() {

            /* renamed from: a  reason: collision with root package name */
            private boolean f1523a = false;

            public void a(View view) {
                this.f1523a = true;
            }

            public void b(View view) {
                if (!this.f1523a) {
                    ToolbarWidgetWrapper.this.f1504a.setVisibility(i2);
                }
            }

            public void c(View view) {
                ToolbarWidgetWrapper.this.f1504a.setVisibility(0);
            }
        });
    }

    public ViewGroup n() {
        return this.f1504a;
    }

    public void o(boolean z2) {
    }

    public void p(int i2) {
        F(i2 == 0 ? null : getContext().getString(i2));
    }

    public void q() {
        Log.i("ToolbarWidgetWrapper", "Progress display unsupported");
    }

    public void r(boolean z2) {
        this.f1504a.setCollapsible(z2);
    }

    public void s() {
        this.f1504a.f();
    }

    public void setIcon(int i2) {
        setIcon(i2 != 0 ? AppCompatResources.b(getContext(), i2) : null);
    }

    public void setTitle(CharSequence charSequence) {
        this.f1511h = true;
        G(charSequence);
    }

    public void setWindowCallback(Window.Callback callback) {
        this.f1515l = callback;
    }

    public void setWindowTitle(CharSequence charSequence) {
        if (!this.f1511h) {
            G(charSequence);
        }
    }

    public void t(ScrollingTabContainerView scrollingTabContainerView) {
        Toolbar toolbar;
        View view = this.f1506c;
        if (view != null && view.getParent() == (toolbar = this.f1504a)) {
            toolbar.removeView(this.f1506c);
        }
        this.f1506c = scrollingTabContainerView;
        if (scrollingTabContainerView != null && this.f1518o == 2) {
            this.f1504a.addView(scrollingTabContainerView, 0);
            Toolbar.LayoutParams layoutParams = (Toolbar.LayoutParams) this.f1506c.getLayoutParams();
            layoutParams.width = -2;
            layoutParams.height = -2;
            layoutParams.f306a = 8388691;
            scrollingTabContainerView.setAllowCollapse(true);
        }
    }

    public void u(int i2) {
        E(i2 != 0 ? AppCompatResources.b(getContext(), i2) : null);
    }

    public void v(int i2) {
        A(i2 != 0 ? AppCompatResources.b(getContext(), i2) : null);
    }

    public void w(MenuPresenter.Callback callback, MenuBuilder.Callback callback2) {
        this.f1504a.L(callback, callback2);
    }

    public void x(int i2) {
        this.f1504a.setVisibility(i2);
    }

    public int y() {
        return this.f1505b;
    }

    public void z() {
        Log.i("ToolbarWidgetWrapper", "Progress display unsupported");
    }

    public ToolbarWidgetWrapper(Toolbar toolbar, boolean z2, int i2, int i3) {
        Drawable drawable;
        this.f1518o = 0;
        this.f1519p = 0;
        this.f1504a = toolbar;
        this.f1512i = toolbar.getTitle();
        this.f1513j = toolbar.getSubtitle();
        this.f1511h = this.f1512i != null;
        this.f1510g = toolbar.getNavigationIcon();
        TintTypedArray v2 = TintTypedArray.v(toolbar.getContext(), (AttributeSet) null, R$styleable.f235a, R$attr.f92c, 0);
        this.f1520q = v2.g(R$styleable.f268l);
        if (z2) {
            CharSequence p2 = v2.p(R$styleable.f286r);
            if (!TextUtils.isEmpty(p2)) {
                setTitle(p2);
            }
            CharSequence p3 = v2.p(R$styleable.f280p);
            if (!TextUtils.isEmpty(p3)) {
                j(p3);
            }
            Drawable g2 = v2.g(R$styleable.f274n);
            if (g2 != null) {
                E(g2);
            }
            Drawable g3 = v2.g(R$styleable.f271m);
            if (g3 != null) {
                setIcon(g3);
            }
            if (this.f1510g == null && (drawable = this.f1520q) != null) {
                A(drawable);
            }
            i(v2.k(R$styleable.f256h, 0));
            int n2 = v2.n(R$styleable.f253g, 0);
            if (n2 != 0) {
                C(LayoutInflater.from(this.f1504a.getContext()).inflate(n2, this.f1504a, false));
                i(this.f1505b | 16);
            }
            int m2 = v2.m(R$styleable.f262j, 0);
            if (m2 > 0) {
                ViewGroup.LayoutParams layoutParams = this.f1504a.getLayoutParams();
                layoutParams.height = m2;
                this.f1504a.setLayoutParams(layoutParams);
            }
            int e2 = v2.e(R$styleable.f250f, -1);
            int e3 = v2.e(R$styleable.f247e, -1);
            if (e2 >= 0 || e3 >= 0) {
                this.f1504a.J(Math.max(e2, 0), Math.max(e3, 0));
            }
            int n3 = v2.n(R$styleable.f289s, 0);
            if (n3 != 0) {
                Toolbar toolbar2 = this.f1504a;
                toolbar2.N(toolbar2.getContext(), n3);
            }
            int n4 = v2.n(R$styleable.f283q, 0);
            if (n4 != 0) {
                Toolbar toolbar3 = this.f1504a;
                toolbar3.M(toolbar3.getContext(), n4);
            }
            int n5 = v2.n(R$styleable.f277o, 0);
            if (n5 != 0) {
                this.f1504a.setPopupTheme(n5);
            }
        } else {
            this.f1505b = B();
        }
        v2.w();
        D(i2);
        this.f1514k = this.f1504a.getNavigationContentDescription();
        this.f1504a.setNavigationOnClickListener(new View.OnClickListener() {

            /* renamed from: b  reason: collision with root package name */
            final ActionMenuItem f1521b;

            {
                this.f1521b = new ActionMenuItem(ToolbarWidgetWrapper.this.f1504a.getContext(), 0, 16908332, 0, 0, ToolbarWidgetWrapper.this.f1512i);
            }

            public void onClick(View view) {
                ToolbarWidgetWrapper toolbarWidgetWrapper = ToolbarWidgetWrapper.this;
                Window.Callback callback = toolbarWidgetWrapper.f1515l;
                if (callback != null && toolbarWidgetWrapper.f1516m) {
                    callback.onMenuItemSelected(0, this.f1521b);
                }
            }
        });
    }

    public void setIcon(Drawable drawable) {
        this.f1508e = drawable;
        J();
    }
}
