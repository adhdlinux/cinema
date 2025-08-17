package androidx.appcompat.view.menu;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Rect;
import android.os.Build;
import android.os.Handler;
import android.os.Parcelable;
import android.os.SystemClock;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.FrameLayout;
import android.widget.HeaderViewListAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.PopupWindow;
import android.widget.TextView;
import androidx.appcompat.R$dimen;
import androidx.appcompat.R$layout;
import androidx.appcompat.view.menu.MenuPresenter;
import androidx.appcompat.widget.MenuItemHoverListener;
import androidx.appcompat.widget.MenuPopupWindow;
import androidx.core.view.GravityCompat;
import androidx.core.view.ViewCompat;
import java.util.ArrayList;
import java.util.List;

final class CascadingMenuPopup extends MenuPopup implements View.OnKeyListener, PopupWindow.OnDismissListener {
    private static final int C = R$layout.f198g;
    private PopupWindow.OnDismissListener A;
    boolean B;

    /* renamed from: c  reason: collision with root package name */
    private final Context f774c;

    /* renamed from: d  reason: collision with root package name */
    private final int f775d;

    /* renamed from: e  reason: collision with root package name */
    private final int f776e;

    /* renamed from: f  reason: collision with root package name */
    private final int f777f;

    /* renamed from: g  reason: collision with root package name */
    private final boolean f778g;

    /* renamed from: h  reason: collision with root package name */
    final Handler f779h;

    /* renamed from: i  reason: collision with root package name */
    private final List<MenuBuilder> f780i = new ArrayList();

    /* renamed from: j  reason: collision with root package name */
    final List<CascadingMenuInfo> f781j = new ArrayList();

    /* renamed from: k  reason: collision with root package name */
    final ViewTreeObserver.OnGlobalLayoutListener f782k = new ViewTreeObserver.OnGlobalLayoutListener() {
        public void onGlobalLayout() {
            if (CascadingMenuPopup.this.isShowing() && CascadingMenuPopup.this.f781j.size() > 0 && !CascadingMenuPopup.this.f781j.get(0).f805a.v()) {
                View view = CascadingMenuPopup.this.f788q;
                if (view == null || !view.isShown()) {
                    CascadingMenuPopup.this.dismiss();
                    return;
                }
                for (CascadingMenuInfo cascadingMenuInfo : CascadingMenuPopup.this.f781j) {
                    cascadingMenuInfo.f805a.show();
                }
            }
        }
    };

    /* renamed from: l  reason: collision with root package name */
    private final View.OnAttachStateChangeListener f783l = new View.OnAttachStateChangeListener() {
        public void onViewAttachedToWindow(View view) {
        }

        public void onViewDetachedFromWindow(View view) {
            ViewTreeObserver viewTreeObserver = CascadingMenuPopup.this.f797z;
            if (viewTreeObserver != null) {
                if (!viewTreeObserver.isAlive()) {
                    CascadingMenuPopup.this.f797z = view.getViewTreeObserver();
                }
                CascadingMenuPopup cascadingMenuPopup = CascadingMenuPopup.this;
                cascadingMenuPopup.f797z.removeGlobalOnLayoutListener(cascadingMenuPopup.f782k);
            }
            view.removeOnAttachStateChangeListener(this);
        }
    };

    /* renamed from: m  reason: collision with root package name */
    private final MenuItemHoverListener f784m = new MenuItemHoverListener() {
        public void a(final MenuBuilder menuBuilder, final MenuItem menuItem) {
            final CascadingMenuInfo cascadingMenuInfo = null;
            CascadingMenuPopup.this.f779h.removeCallbacksAndMessages((Object) null);
            int size = CascadingMenuPopup.this.f781j.size();
            int i2 = 0;
            while (true) {
                if (i2 >= size) {
                    i2 = -1;
                    break;
                } else if (menuBuilder == CascadingMenuPopup.this.f781j.get(i2).f806b) {
                    break;
                } else {
                    i2++;
                }
            }
            if (i2 != -1) {
                int i3 = i2 + 1;
                if (i3 < CascadingMenuPopup.this.f781j.size()) {
                    cascadingMenuInfo = CascadingMenuPopup.this.f781j.get(i3);
                }
                CascadingMenuPopup.this.f779h.postAtTime(new Runnable() {
                    public void run() {
                        CascadingMenuInfo cascadingMenuInfo = cascadingMenuInfo;
                        if (cascadingMenuInfo != null) {
                            CascadingMenuPopup.this.B = true;
                            cascadingMenuInfo.f806b.e(false);
                            CascadingMenuPopup.this.B = false;
                        }
                        if (menuItem.isEnabled() && menuItem.hasSubMenu()) {
                            menuBuilder.N(menuItem, 4);
                        }
                    }
                }, menuBuilder, SystemClock.uptimeMillis() + 200);
            }
        }

        public void m(MenuBuilder menuBuilder, MenuItem menuItem) {
            CascadingMenuPopup.this.f779h.removeCallbacksAndMessages(menuBuilder);
        }
    };

    /* renamed from: n  reason: collision with root package name */
    private int f785n = 0;

    /* renamed from: o  reason: collision with root package name */
    private int f786o = 0;

    /* renamed from: p  reason: collision with root package name */
    private View f787p;

    /* renamed from: q  reason: collision with root package name */
    View f788q;

    /* renamed from: r  reason: collision with root package name */
    private int f789r;

    /* renamed from: s  reason: collision with root package name */
    private boolean f790s;

    /* renamed from: t  reason: collision with root package name */
    private boolean f791t;

    /* renamed from: u  reason: collision with root package name */
    private int f792u;

    /* renamed from: v  reason: collision with root package name */
    private int f793v;

    /* renamed from: w  reason: collision with root package name */
    private boolean f794w;

    /* renamed from: x  reason: collision with root package name */
    private boolean f795x;

    /* renamed from: y  reason: collision with root package name */
    private MenuPresenter.Callback f796y;

    /* renamed from: z  reason: collision with root package name */
    ViewTreeObserver f797z;

    private static class CascadingMenuInfo {

        /* renamed from: a  reason: collision with root package name */
        public final MenuPopupWindow f805a;

        /* renamed from: b  reason: collision with root package name */
        public final MenuBuilder f806b;

        /* renamed from: c  reason: collision with root package name */
        public final int f807c;

        public CascadingMenuInfo(MenuPopupWindow menuPopupWindow, MenuBuilder menuBuilder, int i2) {
            this.f805a = menuPopupWindow;
            this.f806b = menuBuilder;
            this.f807c = i2;
        }

        public ListView a() {
            return this.f805a.n();
        }
    }

    public CascadingMenuPopup(Context context, View view, int i2, int i3, boolean z2) {
        this.f774c = context;
        this.f787p = view;
        this.f776e = i2;
        this.f777f = i3;
        this.f778g = z2;
        this.f794w = false;
        this.f789r = D();
        Resources resources = context.getResources();
        this.f775d = Math.max(resources.getDisplayMetrics().widthPixels / 2, resources.getDimensionPixelSize(R$dimen.f128d));
        this.f779h = new Handler();
    }

    private int A(MenuBuilder menuBuilder) {
        int size = this.f781j.size();
        for (int i2 = 0; i2 < size; i2++) {
            if (menuBuilder == this.f781j.get(i2).f806b) {
                return i2;
            }
        }
        return -1;
    }

    private MenuItem B(MenuBuilder menuBuilder, MenuBuilder menuBuilder2) {
        int size = menuBuilder.size();
        for (int i2 = 0; i2 < size; i2++) {
            MenuItem item = menuBuilder.getItem(i2);
            if (item.hasSubMenu() && menuBuilder2 == item.getSubMenu()) {
                return item;
            }
        }
        return null;
    }

    private View C(CascadingMenuInfo cascadingMenuInfo, MenuBuilder menuBuilder) {
        int i2;
        MenuAdapter menuAdapter;
        int firstVisiblePosition;
        MenuItem B2 = B(cascadingMenuInfo.f806b, menuBuilder);
        if (B2 == null) {
            return null;
        }
        ListView a2 = cascadingMenuInfo.a();
        ListAdapter adapter = a2.getAdapter();
        int i3 = 0;
        if (adapter instanceof HeaderViewListAdapter) {
            HeaderViewListAdapter headerViewListAdapter = (HeaderViewListAdapter) adapter;
            i2 = headerViewListAdapter.getHeadersCount();
            menuAdapter = (MenuAdapter) headerViewListAdapter.getWrappedAdapter();
        } else {
            menuAdapter = (MenuAdapter) adapter;
            i2 = 0;
        }
        int count = menuAdapter.getCount();
        while (true) {
            if (i3 >= count) {
                i3 = -1;
                break;
            } else if (B2 == menuAdapter.getItem(i3)) {
                break;
            } else {
                i3++;
            }
        }
        if (i3 != -1 && (firstVisiblePosition = (i3 + i2) - a2.getFirstVisiblePosition()) >= 0 && firstVisiblePosition < a2.getChildCount()) {
            return a2.getChildAt(firstVisiblePosition);
        }
        return null;
    }

    private int D() {
        return ViewCompat.D(this.f787p) == 1 ? 0 : 1;
    }

    private int E(int i2) {
        List<CascadingMenuInfo> list = this.f781j;
        ListView a2 = list.get(list.size() - 1).a();
        int[] iArr = new int[2];
        a2.getLocationOnScreen(iArr);
        Rect rect = new Rect();
        this.f788q.getWindowVisibleDisplayFrame(rect);
        if (this.f789r == 1) {
            if (iArr[0] + a2.getWidth() + i2 > rect.right) {
                return 0;
            }
            return 1;
        } else if (iArr[0] - i2 < 0) {
            return 1;
        } else {
            return 0;
        }
    }

    private void F(MenuBuilder menuBuilder) {
        View view;
        CascadingMenuInfo cascadingMenuInfo;
        boolean z2;
        int i2;
        int i3;
        int i4;
        LayoutInflater from = LayoutInflater.from(this.f774c);
        MenuAdapter menuAdapter = new MenuAdapter(menuBuilder, from, this.f778g, C);
        if (!isShowing() && this.f794w) {
            menuAdapter.d(true);
        } else if (isShowing()) {
            menuAdapter.d(MenuPopup.x(menuBuilder));
        }
        int o2 = MenuPopup.o(menuAdapter, (ViewGroup) null, this.f774c, this.f775d);
        MenuPopupWindow z3 = z();
        z3.l(menuAdapter);
        z3.z(o2);
        z3.A(this.f786o);
        if (this.f781j.size() > 0) {
            List<CascadingMenuInfo> list = this.f781j;
            cascadingMenuInfo = list.get(list.size() - 1);
            view = C(cascadingMenuInfo, menuBuilder);
        } else {
            cascadingMenuInfo = null;
            view = null;
        }
        if (view != null) {
            z3.O(false);
            z3.L((Object) null);
            int E = E(o2);
            if (E == 1) {
                z2 = true;
            } else {
                z2 = false;
            }
            this.f789r = E;
            if (Build.VERSION.SDK_INT >= 26) {
                z3.x(view);
                i3 = 0;
                i2 = 0;
            } else {
                int[] iArr = new int[2];
                this.f787p.getLocationOnScreen(iArr);
                int[] iArr2 = new int[2];
                view.getLocationOnScreen(iArr2);
                if ((this.f786o & 7) == 5) {
                    iArr[0] = iArr[0] + this.f787p.getWidth();
                    iArr2[0] = iArr2[0] + view.getWidth();
                }
                i2 = iArr2[0] - iArr[0];
                i3 = iArr2[1] - iArr[1];
            }
            if ((this.f786o & 5) != 5) {
                if (z2) {
                    o2 = view.getWidth();
                }
                i4 = i2 - o2;
                z3.d(i4);
                z3.G(true);
                z3.h(i3);
            } else if (!z2) {
                o2 = view.getWidth();
                i4 = i2 - o2;
                z3.d(i4);
                z3.G(true);
                z3.h(i3);
            }
            i4 = i2 + o2;
            z3.d(i4);
            z3.G(true);
            z3.h(i3);
        } else {
            if (this.f790s) {
                z3.d(this.f792u);
            }
            if (this.f791t) {
                z3.h(this.f793v);
            }
            z3.B(m());
        }
        this.f781j.add(new CascadingMenuInfo(z3, menuBuilder, this.f789r));
        z3.show();
        ListView n2 = z3.n();
        n2.setOnKeyListener(this);
        if (cascadingMenuInfo == null && this.f795x && menuBuilder.z() != null) {
            FrameLayout frameLayout = (FrameLayout) from.inflate(R$layout.f205n, n2, false);
            frameLayout.setEnabled(false);
            ((TextView) frameLayout.findViewById(16908310)).setText(menuBuilder.z());
            n2.addHeaderView(frameLayout, (Object) null, false);
            z3.show();
        }
    }

    private MenuPopupWindow z() {
        MenuPopupWindow menuPopupWindow = new MenuPopupWindow(this.f774c, (AttributeSet) null, this.f776e, this.f777f);
        menuPopupWindow.N(this.f784m);
        menuPopupWindow.F(this);
        menuPopupWindow.E(this);
        menuPopupWindow.x(this.f787p);
        menuPopupWindow.A(this.f786o);
        menuPopupWindow.D(true);
        menuPopupWindow.C(2);
        return menuPopupWindow;
    }

    public void a(MenuBuilder menuBuilder, boolean z2) {
        int A2 = A(menuBuilder);
        if (A2 >= 0) {
            int i2 = A2 + 1;
            if (i2 < this.f781j.size()) {
                this.f781j.get(i2).f806b.e(false);
            }
            CascadingMenuInfo remove = this.f781j.remove(A2);
            remove.f806b.Q(this);
            if (this.B) {
                remove.f805a.M((Object) null);
                remove.f805a.y(0);
            }
            remove.f805a.dismiss();
            int size = this.f781j.size();
            if (size > 0) {
                this.f789r = this.f781j.get(size - 1).f807c;
            } else {
                this.f789r = D();
            }
            if (size == 0) {
                dismiss();
                MenuPresenter.Callback callback = this.f796y;
                if (callback != null) {
                    callback.a(menuBuilder, true);
                }
                ViewTreeObserver viewTreeObserver = this.f797z;
                if (viewTreeObserver != null) {
                    if (viewTreeObserver.isAlive()) {
                        this.f797z.removeGlobalOnLayoutListener(this.f782k);
                    }
                    this.f797z = null;
                }
                this.f788q.removeOnAttachStateChangeListener(this.f783l);
                this.A.onDismiss();
            } else if (z2) {
                this.f781j.get(0).f806b.e(false);
            }
        }
    }

    public void c(MenuPresenter.Callback callback) {
        this.f796y = callback;
    }

    public void d(Parcelable parcelable) {
    }

    public void dismiss() {
        int size = this.f781j.size();
        if (size > 0) {
            CascadingMenuInfo[] cascadingMenuInfoArr = (CascadingMenuInfo[]) this.f781j.toArray(new CascadingMenuInfo[size]);
            for (int i2 = size - 1; i2 >= 0; i2--) {
                CascadingMenuInfo cascadingMenuInfo = cascadingMenuInfoArr[i2];
                if (cascadingMenuInfo.f805a.isShowing()) {
                    cascadingMenuInfo.f805a.dismiss();
                }
            }
        }
    }

    public boolean e(SubMenuBuilder subMenuBuilder) {
        for (CascadingMenuInfo next : this.f781j) {
            if (subMenuBuilder == next.f806b) {
                next.a().requestFocus();
                return true;
            }
        }
        if (!subMenuBuilder.hasVisibleItems()) {
            return false;
        }
        f(subMenuBuilder);
        MenuPresenter.Callback callback = this.f796y;
        if (callback != null) {
            callback.b(subMenuBuilder);
        }
        return true;
    }

    public void f(MenuBuilder menuBuilder) {
        menuBuilder.c(this, this.f774c);
        if (isShowing()) {
            F(menuBuilder);
        } else {
            this.f780i.add(menuBuilder);
        }
    }

    public Parcelable g() {
        return null;
    }

    public void h(boolean z2) {
        for (CascadingMenuInfo a2 : this.f781j) {
            MenuPopup.y(a2.a().getAdapter()).notifyDataSetChanged();
        }
    }

    public boolean i() {
        return false;
    }

    public boolean isShowing() {
        return this.f781j.size() > 0 && this.f781j.get(0).f805a.isShowing();
    }

    /* access modifiers changed from: protected */
    public boolean l() {
        return false;
    }

    public ListView n() {
        if (this.f781j.isEmpty()) {
            return null;
        }
        List<CascadingMenuInfo> list = this.f781j;
        return list.get(list.size() - 1).a();
    }

    public void onDismiss() {
        CascadingMenuInfo cascadingMenuInfo;
        int size = this.f781j.size();
        int i2 = 0;
        while (true) {
            if (i2 >= size) {
                cascadingMenuInfo = null;
                break;
            }
            cascadingMenuInfo = this.f781j.get(i2);
            if (!cascadingMenuInfo.f805a.isShowing()) {
                break;
            }
            i2++;
        }
        if (cascadingMenuInfo != null) {
            cascadingMenuInfo.f806b.e(false);
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
        if (this.f787p != view) {
            this.f787p = view;
            this.f786o = GravityCompat.b(this.f785n, ViewCompat.D(view));
        }
    }

    public void r(boolean z2) {
        this.f794w = z2;
    }

    public void s(int i2) {
        if (this.f785n != i2) {
            this.f785n = i2;
            this.f786o = GravityCompat.b(i2, ViewCompat.D(this.f787p));
        }
    }

    public void show() {
        boolean z2;
        if (!isShowing()) {
            for (MenuBuilder F : this.f780i) {
                F(F);
            }
            this.f780i.clear();
            View view = this.f787p;
            this.f788q = view;
            if (view != null) {
                if (this.f797z == null) {
                    z2 = true;
                } else {
                    z2 = false;
                }
                ViewTreeObserver viewTreeObserver = view.getViewTreeObserver();
                this.f797z = viewTreeObserver;
                if (z2) {
                    viewTreeObserver.addOnGlobalLayoutListener(this.f782k);
                }
                this.f788q.addOnAttachStateChangeListener(this.f783l);
            }
        }
    }

    public void t(int i2) {
        this.f790s = true;
        this.f792u = i2;
    }

    public void u(PopupWindow.OnDismissListener onDismissListener) {
        this.A = onDismissListener;
    }

    public void v(boolean z2) {
        this.f795x = z2;
    }

    public void w(int i2) {
        this.f791t = true;
        this.f793v = i2;
    }
}
