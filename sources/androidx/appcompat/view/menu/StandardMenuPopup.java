package androidx.appcompat.view.menu;

import android.content.Context;
import android.content.res.Resources;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.view.Gravity;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.FrameLayout;
import android.widget.ListView;
import android.widget.PopupWindow;
import android.widget.TextView;
import androidx.appcompat.R$dimen;
import androidx.appcompat.R$layout;
import androidx.appcompat.view.menu.MenuPresenter;
import androidx.appcompat.widget.MenuPopupWindow;
import androidx.core.view.ViewCompat;

final class StandardMenuPopup extends MenuPopup implements PopupWindow.OnDismissListener, View.OnKeyListener {

    /* renamed from: w  reason: collision with root package name */
    private static final int f929w = R$layout.f206o;

    /* renamed from: c  reason: collision with root package name */
    private final Context f930c;

    /* renamed from: d  reason: collision with root package name */
    private final MenuBuilder f931d;

    /* renamed from: e  reason: collision with root package name */
    private final MenuAdapter f932e;

    /* renamed from: f  reason: collision with root package name */
    private final boolean f933f;

    /* renamed from: g  reason: collision with root package name */
    private final int f934g;

    /* renamed from: h  reason: collision with root package name */
    private final int f935h;

    /* renamed from: i  reason: collision with root package name */
    private final int f936i;

    /* renamed from: j  reason: collision with root package name */
    final MenuPopupWindow f937j;

    /* renamed from: k  reason: collision with root package name */
    final ViewTreeObserver.OnGlobalLayoutListener f938k = new ViewTreeObserver.OnGlobalLayoutListener() {
        public void onGlobalLayout() {
            if (StandardMenuPopup.this.isShowing() && !StandardMenuPopup.this.f937j.v()) {
                View view = StandardMenuPopup.this.f942o;
                if (view == null || !view.isShown()) {
                    StandardMenuPopup.this.dismiss();
                } else {
                    StandardMenuPopup.this.f937j.show();
                }
            }
        }
    };

    /* renamed from: l  reason: collision with root package name */
    private final View.OnAttachStateChangeListener f939l = new View.OnAttachStateChangeListener() {
        public void onViewAttachedToWindow(View view) {
        }

        public void onViewDetachedFromWindow(View view) {
            ViewTreeObserver viewTreeObserver = StandardMenuPopup.this.f944q;
            if (viewTreeObserver != null) {
                if (!viewTreeObserver.isAlive()) {
                    StandardMenuPopup.this.f944q = view.getViewTreeObserver();
                }
                StandardMenuPopup standardMenuPopup = StandardMenuPopup.this;
                standardMenuPopup.f944q.removeGlobalOnLayoutListener(standardMenuPopup.f938k);
            }
            view.removeOnAttachStateChangeListener(this);
        }
    };

    /* renamed from: m  reason: collision with root package name */
    private PopupWindow.OnDismissListener f940m;

    /* renamed from: n  reason: collision with root package name */
    private View f941n;

    /* renamed from: o  reason: collision with root package name */
    View f942o;

    /* renamed from: p  reason: collision with root package name */
    private MenuPresenter.Callback f943p;

    /* renamed from: q  reason: collision with root package name */
    ViewTreeObserver f944q;

    /* renamed from: r  reason: collision with root package name */
    private boolean f945r;

    /* renamed from: s  reason: collision with root package name */
    private boolean f946s;

    /* renamed from: t  reason: collision with root package name */
    private int f947t;

    /* renamed from: u  reason: collision with root package name */
    private int f948u = 0;

    /* renamed from: v  reason: collision with root package name */
    private boolean f949v;

    public StandardMenuPopup(Context context, MenuBuilder menuBuilder, View view, int i2, int i3, boolean z2) {
        this.f930c = context;
        this.f931d = menuBuilder;
        this.f933f = z2;
        this.f932e = new MenuAdapter(menuBuilder, LayoutInflater.from(context), z2, f929w);
        this.f935h = i2;
        this.f936i = i3;
        Resources resources = context.getResources();
        this.f934g = Math.max(resources.getDisplayMetrics().widthPixels / 2, resources.getDimensionPixelSize(R$dimen.f128d));
        this.f941n = view;
        this.f937j = new MenuPopupWindow(context, (AttributeSet) null, i2, i3);
        menuBuilder.c(this, context);
    }

    private boolean z() {
        View view;
        boolean z2;
        if (isShowing()) {
            return true;
        }
        if (this.f945r || (view = this.f941n) == null) {
            return false;
        }
        this.f942o = view;
        this.f937j.E(this);
        this.f937j.F(this);
        this.f937j.D(true);
        View view2 = this.f942o;
        if (this.f944q == null) {
            z2 = true;
        } else {
            z2 = false;
        }
        ViewTreeObserver viewTreeObserver = view2.getViewTreeObserver();
        this.f944q = viewTreeObserver;
        if (z2) {
            viewTreeObserver.addOnGlobalLayoutListener(this.f938k);
        }
        view2.addOnAttachStateChangeListener(this.f939l);
        this.f937j.x(view2);
        this.f937j.A(this.f948u);
        if (!this.f946s) {
            this.f947t = MenuPopup.o(this.f932e, (ViewGroup) null, this.f930c, this.f934g);
            this.f946s = true;
        }
        this.f937j.z(this.f947t);
        this.f937j.C(2);
        this.f937j.B(m());
        this.f937j.show();
        ListView n2 = this.f937j.n();
        n2.setOnKeyListener(this);
        if (this.f949v && this.f931d.z() != null) {
            FrameLayout frameLayout = (FrameLayout) LayoutInflater.from(this.f930c).inflate(R$layout.f205n, n2, false);
            TextView textView = (TextView) frameLayout.findViewById(16908310);
            if (textView != null) {
                textView.setText(this.f931d.z());
            }
            frameLayout.setEnabled(false);
            n2.addHeaderView(frameLayout, (Object) null, false);
        }
        this.f937j.l(this.f932e);
        this.f937j.show();
        return true;
    }

    public void a(MenuBuilder menuBuilder, boolean z2) {
        if (menuBuilder == this.f931d) {
            dismiss();
            MenuPresenter.Callback callback = this.f943p;
            if (callback != null) {
                callback.a(menuBuilder, z2);
            }
        }
    }

    public void c(MenuPresenter.Callback callback) {
        this.f943p = callback;
    }

    public void d(Parcelable parcelable) {
    }

    public void dismiss() {
        if (isShowing()) {
            this.f937j.dismiss();
        }
    }

    public boolean e(SubMenuBuilder subMenuBuilder) {
        if (subMenuBuilder.hasVisibleItems()) {
            MenuPopupHelper menuPopupHelper = new MenuPopupHelper(this.f930c, subMenuBuilder, this.f942o, this.f933f, this.f935h, this.f936i);
            menuPopupHelper.j(this.f943p);
            menuPopupHelper.g(MenuPopup.x(subMenuBuilder));
            menuPopupHelper.i(this.f940m);
            this.f940m = null;
            this.f931d.e(false);
            int c2 = this.f937j.c();
            int k2 = this.f937j.k();
            if ((Gravity.getAbsoluteGravity(this.f948u, ViewCompat.D(this.f941n)) & 7) == 5) {
                c2 += this.f941n.getWidth();
            }
            if (menuPopupHelper.n(c2, k2)) {
                MenuPresenter.Callback callback = this.f943p;
                if (callback == null) {
                    return true;
                }
                callback.b(subMenuBuilder);
                return true;
            }
        }
        return false;
    }

    public void f(MenuBuilder menuBuilder) {
    }

    public Parcelable g() {
        return null;
    }

    public void h(boolean z2) {
        this.f946s = false;
        MenuAdapter menuAdapter = this.f932e;
        if (menuAdapter != null) {
            menuAdapter.notifyDataSetChanged();
        }
    }

    public boolean i() {
        return false;
    }

    public boolean isShowing() {
        return !this.f945r && this.f937j.isShowing();
    }

    public ListView n() {
        return this.f937j.n();
    }

    public void onDismiss() {
        this.f945r = true;
        this.f931d.close();
        ViewTreeObserver viewTreeObserver = this.f944q;
        if (viewTreeObserver != null) {
            if (!viewTreeObserver.isAlive()) {
                this.f944q = this.f942o.getViewTreeObserver();
            }
            this.f944q.removeGlobalOnLayoutListener(this.f938k);
            this.f944q = null;
        }
        this.f942o.removeOnAttachStateChangeListener(this.f939l);
        PopupWindow.OnDismissListener onDismissListener = this.f940m;
        if (onDismissListener != null) {
            onDismissListener.onDismiss();
        }
    }

    public boolean onKey(View view, int i2, KeyEvent keyEvent) {
        if (keyEvent.getAction() != 1 || i2 != 82) {
            return false;
        }
        dismiss();
        return true;
    }

    public void p(View view) {
        this.f941n = view;
    }

    public void r(boolean z2) {
        this.f932e.d(z2);
    }

    public void s(int i2) {
        this.f948u = i2;
    }

    public void show() {
        if (!z()) {
            throw new IllegalStateException("StandardMenuPopup cannot be used without an anchor");
        }
    }

    public void t(int i2) {
        this.f937j.d(i2);
    }

    public void u(PopupWindow.OnDismissListener onDismissListener) {
        this.f940m = onDismissListener;
    }

    public void v(boolean z2) {
        this.f949v = z2;
    }

    public void w(int i2) {
        this.f937j.h(i2);
    }
}
