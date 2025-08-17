package androidx.appcompat.view.menu;

import android.content.Context;
import android.graphics.Point;
import android.graphics.Rect;
import android.view.Display;
import android.view.View;
import android.widget.PopupWindow;
import androidx.appcompat.view.menu.MenuPresenter;
import androidx.core.view.GravityCompat;
import androidx.core.view.ViewCompat;

public class MenuPopupHelper {

    /* renamed from: a  reason: collision with root package name */
    private final Context f915a;

    /* renamed from: b  reason: collision with root package name */
    private final MenuBuilder f916b;

    /* renamed from: c  reason: collision with root package name */
    private final boolean f917c;

    /* renamed from: d  reason: collision with root package name */
    private final int f918d;

    /* renamed from: e  reason: collision with root package name */
    private final int f919e;

    /* renamed from: f  reason: collision with root package name */
    private View f920f;

    /* renamed from: g  reason: collision with root package name */
    private int f921g;

    /* renamed from: h  reason: collision with root package name */
    private boolean f922h;

    /* renamed from: i  reason: collision with root package name */
    private MenuPresenter.Callback f923i;

    /* renamed from: j  reason: collision with root package name */
    private MenuPopup f924j;

    /* renamed from: k  reason: collision with root package name */
    private PopupWindow.OnDismissListener f925k;

    /* renamed from: l  reason: collision with root package name */
    private final PopupWindow.OnDismissListener f926l;

    static class Api17Impl {
        private Api17Impl() {
        }

        static void a(Display display, Point point) {
            display.getRealSize(point);
        }
    }

    public MenuPopupHelper(Context context, MenuBuilder menuBuilder, View view, boolean z2, int i2) {
        this(context, menuBuilder, view, z2, i2, 0);
    }

    /* JADX WARNING: type inference failed for: r0v7, types: [androidx.appcompat.view.menu.MenuPopup, androidx.appcompat.view.menu.MenuPresenter] */
    /* JADX WARNING: type inference failed for: r7v1, types: [androidx.appcompat.view.menu.StandardMenuPopup] */
    /* JADX WARNING: type inference failed for: r1v13, types: [androidx.appcompat.view.menu.CascadingMenuPopup] */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private androidx.appcompat.view.menu.MenuPopup a() {
        /*
            r14 = this;
            android.content.Context r0 = r14.f915a
            java.lang.String r1 = "window"
            java.lang.Object r0 = r0.getSystemService(r1)
            android.view.WindowManager r0 = (android.view.WindowManager) r0
            android.view.Display r0 = r0.getDefaultDisplay()
            android.graphics.Point r1 = new android.graphics.Point
            r1.<init>()
            androidx.appcompat.view.menu.MenuPopupHelper.Api17Impl.a(r0, r1)
            int r0 = r1.x
            int r1 = r1.y
            int r0 = java.lang.Math.min(r0, r1)
            android.content.Context r1 = r14.f915a
            android.content.res.Resources r1 = r1.getResources()
            int r2 = androidx.appcompat.R$dimen.f127c
            int r1 = r1.getDimensionPixelSize(r2)
            if (r0 < r1) goto L_0x002e
            r0 = 1
            goto L_0x002f
        L_0x002e:
            r0 = 0
        L_0x002f:
            if (r0 == 0) goto L_0x0042
            androidx.appcompat.view.menu.CascadingMenuPopup r0 = new androidx.appcompat.view.menu.CascadingMenuPopup
            android.content.Context r2 = r14.f915a
            android.view.View r3 = r14.f920f
            int r4 = r14.f918d
            int r5 = r14.f919e
            boolean r6 = r14.f917c
            r1 = r0
            r1.<init>(r2, r3, r4, r5, r6)
            goto L_0x0054
        L_0x0042:
            androidx.appcompat.view.menu.StandardMenuPopup r0 = new androidx.appcompat.view.menu.StandardMenuPopup
            android.content.Context r8 = r14.f915a
            androidx.appcompat.view.menu.MenuBuilder r9 = r14.f916b
            android.view.View r10 = r14.f920f
            int r11 = r14.f918d
            int r12 = r14.f919e
            boolean r13 = r14.f917c
            r7 = r0
            r7.<init>(r8, r9, r10, r11, r12, r13)
        L_0x0054:
            androidx.appcompat.view.menu.MenuBuilder r1 = r14.f916b
            r0.f(r1)
            android.widget.PopupWindow$OnDismissListener r1 = r14.f926l
            r0.u(r1)
            android.view.View r1 = r14.f920f
            r0.p(r1)
            androidx.appcompat.view.menu.MenuPresenter$Callback r1 = r14.f923i
            r0.c(r1)
            boolean r1 = r14.f922h
            r0.r(r1)
            int r1 = r14.f921g
            r0.s(r1)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.view.menu.MenuPopupHelper.a():androidx.appcompat.view.menu.MenuPopup");
    }

    private void l(int i2, int i3, boolean z2, boolean z3) {
        MenuPopup c2 = c();
        c2.v(z3);
        if (z2) {
            if ((GravityCompat.b(this.f921g, ViewCompat.D(this.f920f)) & 7) == 5) {
                i2 -= this.f920f.getWidth();
            }
            c2.t(i2);
            c2.w(i3);
            int i4 = (int) ((this.f915a.getResources().getDisplayMetrics().density * 48.0f) / 2.0f);
            c2.q(new Rect(i2 - i4, i3 - i4, i2 + i4, i3 + i4));
        }
        c2.show();
    }

    public void b() {
        if (d()) {
            this.f924j.dismiss();
        }
    }

    public MenuPopup c() {
        if (this.f924j == null) {
            this.f924j = a();
        }
        return this.f924j;
    }

    public boolean d() {
        MenuPopup menuPopup = this.f924j;
        return menuPopup != null && menuPopup.isShowing();
    }

    /* access modifiers changed from: protected */
    public void e() {
        this.f924j = null;
        PopupWindow.OnDismissListener onDismissListener = this.f925k;
        if (onDismissListener != null) {
            onDismissListener.onDismiss();
        }
    }

    public void f(View view) {
        this.f920f = view;
    }

    public void g(boolean z2) {
        this.f922h = z2;
        MenuPopup menuPopup = this.f924j;
        if (menuPopup != null) {
            menuPopup.r(z2);
        }
    }

    public void h(int i2) {
        this.f921g = i2;
    }

    public void i(PopupWindow.OnDismissListener onDismissListener) {
        this.f925k = onDismissListener;
    }

    public void j(MenuPresenter.Callback callback) {
        this.f923i = callback;
        MenuPopup menuPopup = this.f924j;
        if (menuPopup != null) {
            menuPopup.c(callback);
        }
    }

    public void k() {
        if (!m()) {
            throw new IllegalStateException("MenuPopupHelper cannot be used without an anchor");
        }
    }

    public boolean m() {
        if (d()) {
            return true;
        }
        if (this.f920f == null) {
            return false;
        }
        l(0, 0, false, false);
        return true;
    }

    public boolean n(int i2, int i3) {
        if (d()) {
            return true;
        }
        if (this.f920f == null) {
            return false;
        }
        l(i2, i3, true, true);
        return true;
    }

    public MenuPopupHelper(Context context, MenuBuilder menuBuilder, View view, boolean z2, int i2, int i3) {
        this.f921g = 8388611;
        this.f926l = new PopupWindow.OnDismissListener() {
            public void onDismiss() {
                MenuPopupHelper.this.e();
            }
        };
        this.f915a = context;
        this.f916b = menuBuilder;
        this.f920f = view;
        this.f917c = z2;
        this.f918d = i2;
        this.f919e = i3;
    }
}
