package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.ContextThemeWrapper;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.window.OnBackInvokedCallback;
import android.window.OnBackInvokedDispatcher;
import androidx.activity.g;
import androidx.appcompat.R$attr;
import androidx.appcompat.R$styleable;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.appcompat.view.CollapsibleActionView;
import androidx.appcompat.view.SupportMenuInflater;
import androidx.appcompat.view.menu.MenuBuilder;
import androidx.appcompat.view.menu.MenuItemImpl;
import androidx.appcompat.view.menu.MenuPresenter;
import androidx.appcompat.view.menu.SubMenuBuilder;
import androidx.appcompat.widget.ActionMenuView;
import androidx.core.view.GravityCompat;
import androidx.core.view.MarginLayoutParamsCompat;
import androidx.core.view.MenuHostHelper;
import androidx.core.view.ViewCompat;
import androidx.customview.view.AbsSavedState;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;

public class Toolbar extends ViewGroup {
    private ColorStateList A;
    private ColorStateList B;
    private boolean C;
    private boolean D;
    private final ArrayList<View> E;
    private final ArrayList<View> F;
    private final int[] G;
    final MenuHostHelper H;
    private ArrayList<MenuItem> I;
    OnMenuItemClickListener J;
    private final ActionMenuView.OnMenuItemClickListener K;
    private ToolbarWidgetWrapper L;
    private ActionMenuPresenter M;
    private ExpandedActionViewMenuPresenter N;
    private MenuPresenter.Callback O;
    MenuBuilder.Callback P;
    private boolean Q;
    private OnBackInvokedCallback R;
    private OnBackInvokedDispatcher S;
    private boolean T;
    private final Runnable U;

    /* renamed from: b  reason: collision with root package name */
    ActionMenuView f1469b;

    /* renamed from: c  reason: collision with root package name */
    private TextView f1470c;

    /* renamed from: d  reason: collision with root package name */
    private TextView f1471d;

    /* renamed from: e  reason: collision with root package name */
    private ImageButton f1472e;

    /* renamed from: f  reason: collision with root package name */
    private ImageView f1473f;

    /* renamed from: g  reason: collision with root package name */
    private Drawable f1474g;

    /* renamed from: h  reason: collision with root package name */
    private CharSequence f1475h;

    /* renamed from: i  reason: collision with root package name */
    ImageButton f1476i;

    /* renamed from: j  reason: collision with root package name */
    View f1477j;

    /* renamed from: k  reason: collision with root package name */
    private Context f1478k;

    /* renamed from: l  reason: collision with root package name */
    private int f1479l;

    /* renamed from: m  reason: collision with root package name */
    private int f1480m;

    /* renamed from: n  reason: collision with root package name */
    private int f1481n;

    /* renamed from: o  reason: collision with root package name */
    int f1482o;

    /* renamed from: p  reason: collision with root package name */
    private int f1483p;

    /* renamed from: q  reason: collision with root package name */
    private int f1484q;

    /* renamed from: r  reason: collision with root package name */
    private int f1485r;

    /* renamed from: s  reason: collision with root package name */
    private int f1486s;

    /* renamed from: t  reason: collision with root package name */
    private int f1487t;

    /* renamed from: u  reason: collision with root package name */
    private RtlSpacingHelper f1488u;

    /* renamed from: v  reason: collision with root package name */
    private int f1489v;

    /* renamed from: w  reason: collision with root package name */
    private int f1490w;

    /* renamed from: x  reason: collision with root package name */
    private int f1491x;

    /* renamed from: y  reason: collision with root package name */
    private CharSequence f1492y;

    /* renamed from: z  reason: collision with root package name */
    private CharSequence f1493z;

    static class Api33Impl {
        private Api33Impl() {
        }

        static OnBackInvokedDispatcher a(View view) {
            return view.findOnBackInvokedDispatcher();
        }

        static OnBackInvokedCallback b(Runnable runnable) {
            Objects.requireNonNull(runnable);
            return new g(runnable);
        }

        static void c(Object obj, Object obj2) {
            ((OnBackInvokedDispatcher) obj).registerOnBackInvokedCallback(1000000, (OnBackInvokedCallback) obj2);
        }

        static void d(Object obj, Object obj2) {
            ((OnBackInvokedDispatcher) obj).unregisterOnBackInvokedCallback((OnBackInvokedCallback) obj2);
        }
    }

    private class ExpandedActionViewMenuPresenter implements MenuPresenter {

        /* renamed from: b  reason: collision with root package name */
        MenuBuilder f1498b;

        /* renamed from: c  reason: collision with root package name */
        MenuItemImpl f1499c;

        ExpandedActionViewMenuPresenter() {
        }

        public void a(MenuBuilder menuBuilder, boolean z2) {
        }

        public boolean b(MenuBuilder menuBuilder, MenuItemImpl menuItemImpl) {
            Toolbar.this.g();
            ViewParent parent = Toolbar.this.f1476i.getParent();
            Toolbar toolbar = Toolbar.this;
            if (parent != toolbar) {
                if (parent instanceof ViewGroup) {
                    ((ViewGroup) parent).removeView(toolbar.f1476i);
                }
                Toolbar toolbar2 = Toolbar.this;
                toolbar2.addView(toolbar2.f1476i);
            }
            Toolbar.this.f1477j = menuItemImpl.getActionView();
            this.f1499c = menuItemImpl;
            ViewParent parent2 = Toolbar.this.f1477j.getParent();
            Toolbar toolbar3 = Toolbar.this;
            if (parent2 != toolbar3) {
                if (parent2 instanceof ViewGroup) {
                    ((ViewGroup) parent2).removeView(toolbar3.f1477j);
                }
                LayoutParams m2 = Toolbar.this.generateDefaultLayoutParams();
                Toolbar toolbar4 = Toolbar.this;
                m2.f306a = (toolbar4.f1482o & 112) | 8388611;
                m2.f1501b = 2;
                toolbar4.f1477j.setLayoutParams(m2);
                Toolbar toolbar5 = Toolbar.this;
                toolbar5.addView(toolbar5.f1477j);
            }
            Toolbar.this.I();
            Toolbar.this.requestLayout();
            menuItemImpl.r(true);
            View view = Toolbar.this.f1477j;
            if (view instanceof CollapsibleActionView) {
                ((CollapsibleActionView) view).onActionViewExpanded();
            }
            Toolbar.this.R();
            return true;
        }

        public void d(Parcelable parcelable) {
        }

        public boolean e(SubMenuBuilder subMenuBuilder) {
            return false;
        }

        public Parcelable g() {
            return null;
        }

        public int getId() {
            return 0;
        }

        public void h(boolean z2) {
            if (this.f1499c != null) {
                MenuBuilder menuBuilder = this.f1498b;
                boolean z3 = false;
                if (menuBuilder != null) {
                    int size = menuBuilder.size();
                    int i2 = 0;
                    while (true) {
                        if (i2 >= size) {
                            break;
                        } else if (this.f1498b.getItem(i2) == this.f1499c) {
                            z3 = true;
                            break;
                        } else {
                            i2++;
                        }
                    }
                }
                if (!z3) {
                    j(this.f1498b, this.f1499c);
                }
            }
        }

        public boolean i() {
            return false;
        }

        public boolean j(MenuBuilder menuBuilder, MenuItemImpl menuItemImpl) {
            View view = Toolbar.this.f1477j;
            if (view instanceof CollapsibleActionView) {
                ((CollapsibleActionView) view).onActionViewCollapsed();
            }
            Toolbar toolbar = Toolbar.this;
            toolbar.removeView(toolbar.f1477j);
            Toolbar toolbar2 = Toolbar.this;
            toolbar2.removeView(toolbar2.f1476i);
            Toolbar toolbar3 = Toolbar.this;
            toolbar3.f1477j = null;
            toolbar3.a();
            this.f1499c = null;
            Toolbar.this.requestLayout();
            menuItemImpl.r(false);
            Toolbar.this.R();
            return true;
        }

        public void k(Context context, MenuBuilder menuBuilder) {
            MenuItemImpl menuItemImpl;
            MenuBuilder menuBuilder2 = this.f1498b;
            if (!(menuBuilder2 == null || (menuItemImpl = this.f1499c) == null)) {
                menuBuilder2.f(menuItemImpl);
            }
            this.f1498b = menuBuilder;
        }
    }

    public interface OnMenuItemClickListener {
        boolean onMenuItemClick(MenuItem menuItem);
    }

    public Toolbar(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R$attr.U);
    }

    private int C(View view, int i2, int[] iArr, int i3) {
        LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
        int i4 = layoutParams.leftMargin - iArr[0];
        int max = i2 + Math.max(0, i4);
        iArr[0] = Math.max(0, -i4);
        int q2 = q(view, i3);
        int measuredWidth = view.getMeasuredWidth();
        view.layout(max, q2, max + measuredWidth, view.getMeasuredHeight() + q2);
        return max + measuredWidth + layoutParams.rightMargin;
    }

    private int D(View view, int i2, int[] iArr, int i3) {
        LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
        int i4 = layoutParams.rightMargin - iArr[1];
        int max = i2 - Math.max(0, i4);
        iArr[1] = Math.max(0, -i4);
        int q2 = q(view, i3);
        int measuredWidth = view.getMeasuredWidth();
        view.layout(max - measuredWidth, q2, max, view.getMeasuredHeight() + q2);
        return max - (measuredWidth + layoutParams.leftMargin);
    }

    private int E(View view, int i2, int i3, int i4, int i5, int[] iArr) {
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) view.getLayoutParams();
        int i6 = marginLayoutParams.leftMargin - iArr[0];
        int i7 = marginLayoutParams.rightMargin - iArr[1];
        int max = Math.max(0, i6) + Math.max(0, i7);
        iArr[0] = Math.max(0, -i6);
        iArr[1] = Math.max(0, -i7);
        view.measure(ViewGroup.getChildMeasureSpec(i2, getPaddingLeft() + getPaddingRight() + max + i3, marginLayoutParams.width), ViewGroup.getChildMeasureSpec(i4, getPaddingTop() + getPaddingBottom() + marginLayoutParams.topMargin + marginLayoutParams.bottomMargin + i5, marginLayoutParams.height));
        return view.getMeasuredWidth() + max;
    }

    private void F(View view, int i2, int i3, int i4, int i5, int i6) {
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) view.getLayoutParams();
        int childMeasureSpec = ViewGroup.getChildMeasureSpec(i2, getPaddingLeft() + getPaddingRight() + marginLayoutParams.leftMargin + marginLayoutParams.rightMargin + i3, marginLayoutParams.width);
        int childMeasureSpec2 = ViewGroup.getChildMeasureSpec(i4, getPaddingTop() + getPaddingBottom() + marginLayoutParams.topMargin + marginLayoutParams.bottomMargin + i5, marginLayoutParams.height);
        int mode = View.MeasureSpec.getMode(childMeasureSpec2);
        if (mode != 1073741824 && i6 >= 0) {
            if (mode != 0) {
                i6 = Math.min(View.MeasureSpec.getSize(childMeasureSpec2), i6);
            }
            childMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(i6, 1073741824);
        }
        view.measure(childMeasureSpec, childMeasureSpec2);
    }

    private void G() {
        Menu menu = getMenu();
        ArrayList<MenuItem> currentMenuItems = getCurrentMenuItems();
        this.H.h(menu, getMenuInflater());
        ArrayList<MenuItem> currentMenuItems2 = getCurrentMenuItems();
        currentMenuItems2.removeAll(currentMenuItems);
        this.I = currentMenuItems2;
    }

    private void H() {
        removeCallbacks(this.U);
        post(this.U);
    }

    private boolean O() {
        if (!this.Q) {
            return false;
        }
        int childCount = getChildCount();
        for (int i2 = 0; i2 < childCount; i2++) {
            View childAt = getChildAt(i2);
            if (P(childAt) && childAt.getMeasuredWidth() > 0 && childAt.getMeasuredHeight() > 0) {
                return false;
            }
        }
        return true;
    }

    private boolean P(View view) {
        return (view == null || view.getParent() != this || view.getVisibility() == 8) ? false : true;
    }

    private void b(List<View> list, int i2) {
        boolean z2;
        if (ViewCompat.D(this) == 1) {
            z2 = true;
        } else {
            z2 = false;
        }
        int childCount = getChildCount();
        int b2 = GravityCompat.b(i2, ViewCompat.D(this));
        list.clear();
        if (z2) {
            for (int i3 = childCount - 1; i3 >= 0; i3--) {
                View childAt = getChildAt(i3);
                LayoutParams layoutParams = (LayoutParams) childAt.getLayoutParams();
                if (layoutParams.f1501b == 0 && P(childAt) && p(layoutParams.f306a) == b2) {
                    list.add(childAt);
                }
            }
            return;
        }
        for (int i4 = 0; i4 < childCount; i4++) {
            View childAt2 = getChildAt(i4);
            LayoutParams layoutParams2 = (LayoutParams) childAt2.getLayoutParams();
            if (layoutParams2.f1501b == 0 && P(childAt2) && p(layoutParams2.f306a) == b2) {
                list.add(childAt2);
            }
        }
    }

    private void c(View view, boolean z2) {
        LayoutParams layoutParams;
        ViewGroup.LayoutParams layoutParams2 = view.getLayoutParams();
        if (layoutParams2 == null) {
            layoutParams = generateDefaultLayoutParams();
        } else if (!checkLayoutParams(layoutParams2)) {
            layoutParams = generateLayoutParams(layoutParams2);
        } else {
            layoutParams = (LayoutParams) layoutParams2;
        }
        layoutParams.f1501b = 1;
        if (!z2 || this.f1477j == null) {
            addView(view, layoutParams);
            return;
        }
        view.setLayoutParams(layoutParams);
        this.F.add(view);
    }

    private ArrayList<MenuItem> getCurrentMenuItems() {
        ArrayList<MenuItem> arrayList = new ArrayList<>();
        Menu menu = getMenu();
        for (int i2 = 0; i2 < menu.size(); i2++) {
            arrayList.add(menu.getItem(i2));
        }
        return arrayList;
    }

    private MenuInflater getMenuInflater() {
        return new SupportMenuInflater(getContext());
    }

    private void h() {
        if (this.f1488u == null) {
            this.f1488u = new RtlSpacingHelper();
        }
    }

    private void i() {
        if (this.f1473f == null) {
            this.f1473f = new AppCompatImageView(getContext());
        }
    }

    private void j() {
        k();
        if (this.f1469b.L() == null) {
            MenuBuilder menuBuilder = (MenuBuilder) this.f1469b.getMenu();
            if (this.N == null) {
                this.N = new ExpandedActionViewMenuPresenter();
            }
            this.f1469b.setExpandedActionViewsExclusive(true);
            menuBuilder.c(this.N, this.f1478k);
            R();
        }
    }

    private void k() {
        if (this.f1469b == null) {
            ActionMenuView actionMenuView = new ActionMenuView(getContext());
            this.f1469b = actionMenuView;
            actionMenuView.setPopupTheme(this.f1479l);
            this.f1469b.setOnMenuItemClickListener(this.K);
            this.f1469b.M(this.O, new MenuBuilder.Callback() {
                public boolean a(MenuBuilder menuBuilder, MenuItem menuItem) {
                    MenuBuilder.Callback callback = Toolbar.this.P;
                    if (callback == null || !callback.a(menuBuilder, menuItem)) {
                        return false;
                    }
                    return true;
                }

                public void b(MenuBuilder menuBuilder) {
                    if (!Toolbar.this.f1469b.H()) {
                        Toolbar.this.H.k(menuBuilder);
                    }
                    MenuBuilder.Callback callback = Toolbar.this.P;
                    if (callback != null) {
                        callback.b(menuBuilder);
                    }
                }
            });
            LayoutParams m2 = generateDefaultLayoutParams();
            m2.f306a = (this.f1482o & 112) | 8388613;
            this.f1469b.setLayoutParams(m2);
            c(this.f1469b, false);
        }
    }

    private void l() {
        if (this.f1472e == null) {
            this.f1472e = new AppCompatImageButton(getContext(), (AttributeSet) null, R$attr.T);
            LayoutParams m2 = generateDefaultLayoutParams();
            m2.f306a = (this.f1482o & 112) | 8388611;
            this.f1472e.setLayoutParams(m2);
        }
    }

    private int p(int i2) {
        int D2 = ViewCompat.D(this);
        int b2 = GravityCompat.b(i2, D2) & 7;
        if (b2 == 1 || b2 == 3 || b2 == 5) {
            return b2;
        }
        if (D2 == 1) {
            return 5;
        }
        return 3;
    }

    private int q(View view, int i2) {
        int i3;
        LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
        int measuredHeight = view.getMeasuredHeight();
        if (i2 > 0) {
            i3 = (measuredHeight - i2) / 2;
        } else {
            i3 = 0;
        }
        int r2 = r(layoutParams.f306a);
        if (r2 == 48) {
            return getPaddingTop() - i3;
        }
        if (r2 == 80) {
            return (((getHeight() - getPaddingBottom()) - measuredHeight) - layoutParams.bottomMargin) - i3;
        }
        int paddingTop = getPaddingTop();
        int paddingBottom = getPaddingBottom();
        int height = getHeight();
        int i4 = (((height - paddingTop) - paddingBottom) - measuredHeight) / 2;
        int i5 = layoutParams.topMargin;
        if (i4 < i5) {
            i4 = i5;
        } else {
            int i6 = (((height - paddingBottom) - measuredHeight) - i4) - paddingTop;
            int i7 = layoutParams.bottomMargin;
            if (i6 < i7) {
                i4 = Math.max(0, i4 - (i7 - i6));
            }
        }
        return paddingTop + i4;
    }

    private int r(int i2) {
        int i3 = i2 & 112;
        return (i3 == 16 || i3 == 48 || i3 == 80) ? i3 : this.f1491x & 112;
    }

    private int s(View view) {
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) view.getLayoutParams();
        return MarginLayoutParamsCompat.b(marginLayoutParams) + MarginLayoutParamsCompat.a(marginLayoutParams);
    }

    private int t(View view) {
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) view.getLayoutParams();
        return marginLayoutParams.topMargin + marginLayoutParams.bottomMargin;
    }

    private int u(List<View> list, int[] iArr) {
        int i2 = iArr[0];
        int i3 = iArr[1];
        int size = list.size();
        int i4 = 0;
        int i5 = 0;
        while (i4 < size) {
            View view = list.get(i4);
            LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
            int i6 = layoutParams.leftMargin - i2;
            int i7 = layoutParams.rightMargin - i3;
            int max = Math.max(0, i6);
            int max2 = Math.max(0, i7);
            int max3 = Math.max(0, -i6);
            int max4 = Math.max(0, -i7);
            i5 += max + view.getMeasuredWidth() + max2;
            i4++;
            i3 = max4;
            i2 = max3;
        }
        return i5;
    }

    private boolean z(View view) {
        return view.getParent() == this || this.F.contains(view);
    }

    public boolean A() {
        ActionMenuView actionMenuView = this.f1469b;
        return actionMenuView != null && actionMenuView.G();
    }

    public boolean B() {
        ActionMenuView actionMenuView = this.f1469b;
        return actionMenuView != null && actionMenuView.H();
    }

    /* access modifiers changed from: package-private */
    public void I() {
        for (int childCount = getChildCount() - 1; childCount >= 0; childCount--) {
            View childAt = getChildAt(childCount);
            if (!(((LayoutParams) childAt.getLayoutParams()).f1501b == 2 || childAt == this.f1469b)) {
                removeViewAt(childCount);
                this.F.add(childAt);
            }
        }
    }

    public void J(int i2, int i3) {
        h();
        this.f1488u.g(i2, i3);
    }

    public void K(MenuBuilder menuBuilder, ActionMenuPresenter actionMenuPresenter) {
        if (menuBuilder != null || this.f1469b != null) {
            k();
            MenuBuilder L2 = this.f1469b.L();
            if (L2 != menuBuilder) {
                if (L2 != null) {
                    L2.Q(this.M);
                    L2.Q(this.N);
                }
                if (this.N == null) {
                    this.N = new ExpandedActionViewMenuPresenter();
                }
                actionMenuPresenter.J(true);
                if (menuBuilder != null) {
                    menuBuilder.c(actionMenuPresenter, this.f1478k);
                    menuBuilder.c(this.N, this.f1478k);
                } else {
                    actionMenuPresenter.k(this.f1478k, (MenuBuilder) null);
                    this.N.k(this.f1478k, (MenuBuilder) null);
                    actionMenuPresenter.h(true);
                    this.N.h(true);
                }
                this.f1469b.setPopupTheme(this.f1479l);
                this.f1469b.setPresenter(actionMenuPresenter);
                this.M = actionMenuPresenter;
                R();
            }
        }
    }

    public void L(MenuPresenter.Callback callback, MenuBuilder.Callback callback2) {
        this.O = callback;
        this.P = callback2;
        ActionMenuView actionMenuView = this.f1469b;
        if (actionMenuView != null) {
            actionMenuView.M(callback, callback2);
        }
    }

    public void M(Context context, int i2) {
        this.f1481n = i2;
        TextView textView = this.f1471d;
        if (textView != null) {
            textView.setTextAppearance(context, i2);
        }
    }

    public void N(Context context, int i2) {
        this.f1480m = i2;
        TextView textView = this.f1470c;
        if (textView != null) {
            textView.setTextAppearance(context, i2);
        }
    }

    public boolean Q() {
        ActionMenuView actionMenuView = this.f1469b;
        return actionMenuView != null && actionMenuView.N();
    }

    /* access modifiers changed from: package-private */
    public void R() {
        boolean z2;
        OnBackInvokedDispatcher onBackInvokedDispatcher;
        if (Build.VERSION.SDK_INT >= 33) {
            OnBackInvokedDispatcher a2 = Api33Impl.a(this);
            if (!v() || a2 == null || !ViewCompat.U(this) || !this.T) {
                z2 = false;
            } else {
                z2 = true;
            }
            if (z2 && this.S == null) {
                if (this.R == null) {
                    this.R = Api33Impl.b(new e1(this));
                }
                Api33Impl.c(a2, this.R);
                this.S = a2;
            } else if (!z2 && (onBackInvokedDispatcher = this.S) != null) {
                Api33Impl.d(onBackInvokedDispatcher, this.R);
                this.S = null;
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void a() {
        for (int size = this.F.size() - 1; size >= 0; size--) {
            addView(this.F.get(size));
        }
        this.F.clear();
    }

    /* access modifiers changed from: protected */
    public boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return super.checkLayoutParams(layoutParams) && (layoutParams instanceof LayoutParams);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:2:0x0006, code lost:
        r0 = r1.f1469b;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean d() {
        /*
            r1 = this;
            int r0 = r1.getVisibility()
            if (r0 != 0) goto L_0x0012
            androidx.appcompat.widget.ActionMenuView r0 = r1.f1469b
            if (r0 == 0) goto L_0x0012
            boolean r0 = r0.I()
            if (r0 == 0) goto L_0x0012
            r0 = 1
            goto L_0x0013
        L_0x0012:
            r0 = 0
        L_0x0013:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.widget.Toolbar.d():boolean");
    }

    public void e() {
        MenuItemImpl menuItemImpl;
        ExpandedActionViewMenuPresenter expandedActionViewMenuPresenter = this.N;
        if (expandedActionViewMenuPresenter == null) {
            menuItemImpl = null;
        } else {
            menuItemImpl = expandedActionViewMenuPresenter.f1499c;
        }
        if (menuItemImpl != null) {
            menuItemImpl.collapseActionView();
        }
    }

    public void f() {
        ActionMenuView actionMenuView = this.f1469b;
        if (actionMenuView != null) {
            actionMenuView.z();
        }
    }

    /* access modifiers changed from: package-private */
    public void g() {
        if (this.f1476i == null) {
            AppCompatImageButton appCompatImageButton = new AppCompatImageButton(getContext(), (AttributeSet) null, R$attr.T);
            this.f1476i = appCompatImageButton;
            appCompatImageButton.setImageDrawable(this.f1474g);
            this.f1476i.setContentDescription(this.f1475h);
            LayoutParams m2 = generateDefaultLayoutParams();
            m2.f306a = (this.f1482o & 112) | 8388611;
            m2.f1501b = 2;
            this.f1476i.setLayoutParams(m2);
            this.f1476i.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Toolbar.this.e();
                }
            });
        }
    }

    public CharSequence getCollapseContentDescription() {
        ImageButton imageButton = this.f1476i;
        if (imageButton != null) {
            return imageButton.getContentDescription();
        }
        return null;
    }

    public Drawable getCollapseIcon() {
        ImageButton imageButton = this.f1476i;
        if (imageButton != null) {
            return imageButton.getDrawable();
        }
        return null;
    }

    public int getContentInsetEnd() {
        RtlSpacingHelper rtlSpacingHelper = this.f1488u;
        if (rtlSpacingHelper != null) {
            return rtlSpacingHelper.a();
        }
        return 0;
    }

    public int getContentInsetEndWithActions() {
        int i2 = this.f1490w;
        if (i2 != Integer.MIN_VALUE) {
            return i2;
        }
        return getContentInsetEnd();
    }

    public int getContentInsetLeft() {
        RtlSpacingHelper rtlSpacingHelper = this.f1488u;
        if (rtlSpacingHelper != null) {
            return rtlSpacingHelper.b();
        }
        return 0;
    }

    public int getContentInsetRight() {
        RtlSpacingHelper rtlSpacingHelper = this.f1488u;
        if (rtlSpacingHelper != null) {
            return rtlSpacingHelper.c();
        }
        return 0;
    }

    public int getContentInsetStart() {
        RtlSpacingHelper rtlSpacingHelper = this.f1488u;
        if (rtlSpacingHelper != null) {
            return rtlSpacingHelper.d();
        }
        return 0;
    }

    public int getContentInsetStartWithNavigation() {
        int i2 = this.f1489v;
        if (i2 != Integer.MIN_VALUE) {
            return i2;
        }
        return getContentInsetStart();
    }

    public int getCurrentContentInsetEnd() {
        boolean z2;
        MenuBuilder L2;
        ActionMenuView actionMenuView = this.f1469b;
        if (actionMenuView == null || (L2 = actionMenuView.L()) == null || !L2.hasVisibleItems()) {
            z2 = false;
        } else {
            z2 = true;
        }
        if (z2) {
            return Math.max(getContentInsetEnd(), Math.max(this.f1490w, 0));
        }
        return getContentInsetEnd();
    }

    public int getCurrentContentInsetLeft() {
        if (ViewCompat.D(this) == 1) {
            return getCurrentContentInsetEnd();
        }
        return getCurrentContentInsetStart();
    }

    public int getCurrentContentInsetRight() {
        if (ViewCompat.D(this) == 1) {
            return getCurrentContentInsetStart();
        }
        return getCurrentContentInsetEnd();
    }

    public int getCurrentContentInsetStart() {
        if (getNavigationIcon() != null) {
            return Math.max(getContentInsetStart(), Math.max(this.f1489v, 0));
        }
        return getContentInsetStart();
    }

    public Drawable getLogo() {
        ImageView imageView = this.f1473f;
        if (imageView != null) {
            return imageView.getDrawable();
        }
        return null;
    }

    public CharSequence getLogoDescription() {
        ImageView imageView = this.f1473f;
        if (imageView != null) {
            return imageView.getContentDescription();
        }
        return null;
    }

    public Menu getMenu() {
        j();
        return this.f1469b.getMenu();
    }

    /* access modifiers changed from: package-private */
    public View getNavButtonView() {
        return this.f1472e;
    }

    public CharSequence getNavigationContentDescription() {
        ImageButton imageButton = this.f1472e;
        if (imageButton != null) {
            return imageButton.getContentDescription();
        }
        return null;
    }

    public Drawable getNavigationIcon() {
        ImageButton imageButton = this.f1472e;
        if (imageButton != null) {
            return imageButton.getDrawable();
        }
        return null;
    }

    /* access modifiers changed from: package-private */
    public ActionMenuPresenter getOuterActionMenuPresenter() {
        return this.M;
    }

    public Drawable getOverflowIcon() {
        j();
        return this.f1469b.getOverflowIcon();
    }

    /* access modifiers changed from: package-private */
    public Context getPopupContext() {
        return this.f1478k;
    }

    public int getPopupTheme() {
        return this.f1479l;
    }

    public CharSequence getSubtitle() {
        return this.f1493z;
    }

    /* access modifiers changed from: package-private */
    public final TextView getSubtitleTextView() {
        return this.f1471d;
    }

    public CharSequence getTitle() {
        return this.f1492y;
    }

    public int getTitleMarginBottom() {
        return this.f1487t;
    }

    public int getTitleMarginEnd() {
        return this.f1485r;
    }

    public int getTitleMarginStart() {
        return this.f1484q;
    }

    public int getTitleMarginTop() {
        return this.f1486s;
    }

    /* access modifiers changed from: package-private */
    public final TextView getTitleTextView() {
        return this.f1470c;
    }

    public DecorToolbar getWrapper() {
        if (this.L == null) {
            this.L = new ToolbarWidgetWrapper(this, true);
        }
        return this.L;
    }

    /* access modifiers changed from: protected */
    /* renamed from: m */
    public LayoutParams generateDefaultLayoutParams() {
        return new LayoutParams(-2, -2);
    }

    /* renamed from: n */
    public LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return new LayoutParams(getContext(), attributeSet);
    }

    /* access modifiers changed from: protected */
    /* renamed from: o */
    public LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        if (layoutParams instanceof LayoutParams) {
            return new LayoutParams((LayoutParams) layoutParams);
        }
        if (layoutParams instanceof ActionBar.LayoutParams) {
            return new LayoutParams((ActionBar.LayoutParams) layoutParams);
        }
        if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
            return new LayoutParams((ViewGroup.MarginLayoutParams) layoutParams);
        }
        return new LayoutParams(layoutParams);
    }

    /* access modifiers changed from: protected */
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        R();
    }

    /* access modifiers changed from: protected */
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        removeCallbacks(this.U);
        R();
    }

    public boolean onHoverEvent(MotionEvent motionEvent) {
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 9) {
            this.D = false;
        }
        if (!this.D) {
            boolean onHoverEvent = super.onHoverEvent(motionEvent);
            if (actionMasked == 9 && !onHoverEvent) {
                this.D = true;
            }
        }
        if (actionMasked == 10 || actionMasked == 3) {
            this.D = false;
        }
        return true;
    }

    /* access modifiers changed from: protected */
    /* JADX WARNING: Removed duplicated region for block: B:102:0x029f A[LOOP:0: B:101:0x029d->B:102:0x029f, LOOP_END] */
    /* JADX WARNING: Removed duplicated region for block: B:105:0x02c1 A[LOOP:1: B:104:0x02bf->B:105:0x02c1, LOOP_END] */
    /* JADX WARNING: Removed duplicated region for block: B:108:0x02eb  */
    /* JADX WARNING: Removed duplicated region for block: B:113:0x02fa A[LOOP:2: B:112:0x02f8->B:113:0x02fa, LOOP_END] */
    /* JADX WARNING: Removed duplicated region for block: B:17:0x005f  */
    /* JADX WARNING: Removed duplicated region for block: B:22:0x0076  */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x00b3  */
    /* JADX WARNING: Removed duplicated region for block: B:32:0x00ca  */
    /* JADX WARNING: Removed duplicated region for block: B:37:0x00e7  */
    /* JADX WARNING: Removed duplicated region for block: B:38:0x0100  */
    /* JADX WARNING: Removed duplicated region for block: B:40:0x0105  */
    /* JADX WARNING: Removed duplicated region for block: B:41:0x011d  */
    /* JADX WARNING: Removed duplicated region for block: B:47:0x012d  */
    /* JADX WARNING: Removed duplicated region for block: B:48:0x0130  */
    /* JADX WARNING: Removed duplicated region for block: B:50:0x0134  */
    /* JADX WARNING: Removed duplicated region for block: B:51:0x0137  */
    /* JADX WARNING: Removed duplicated region for block: B:63:0x0168  */
    /* JADX WARNING: Removed duplicated region for block: B:73:0x01a6  */
    /* JADX WARNING: Removed duplicated region for block: B:75:0x01b7  */
    /* JADX WARNING: Removed duplicated region for block: B:88:0x0227  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onLayout(boolean r20, int r21, int r22, int r23, int r24) {
        /*
            r19 = this;
            r0 = r19
            int r1 = androidx.core.view.ViewCompat.D(r19)
            r2 = 0
            r3 = 1
            if (r1 != r3) goto L_0x000c
            r1 = 1
            goto L_0x000d
        L_0x000c:
            r1 = 0
        L_0x000d:
            int r4 = r19.getWidth()
            int r5 = r19.getHeight()
            int r6 = r19.getPaddingLeft()
            int r7 = r19.getPaddingRight()
            int r8 = r19.getPaddingTop()
            int r9 = r19.getPaddingBottom()
            int r10 = r4 - r7
            int[] r11 = r0.G
            r11[r3] = r2
            r11[r2] = r2
            int r12 = androidx.core.view.ViewCompat.E(r19)
            if (r12 < 0) goto L_0x003a
            int r13 = r24 - r22
            int r12 = java.lang.Math.min(r12, r13)
            goto L_0x003b
        L_0x003a:
            r12 = 0
        L_0x003b:
            android.widget.ImageButton r13 = r0.f1472e
            boolean r13 = r0.P(r13)
            if (r13 == 0) goto L_0x0055
            if (r1 == 0) goto L_0x004e
            android.widget.ImageButton r13 = r0.f1472e
            int r13 = r0.D(r13, r10, r11, r12)
            r14 = r13
            r13 = r6
            goto L_0x0057
        L_0x004e:
            android.widget.ImageButton r13 = r0.f1472e
            int r13 = r0.C(r13, r6, r11, r12)
            goto L_0x0056
        L_0x0055:
            r13 = r6
        L_0x0056:
            r14 = r10
        L_0x0057:
            android.widget.ImageButton r15 = r0.f1476i
            boolean r15 = r0.P(r15)
            if (r15 == 0) goto L_0x006e
            if (r1 == 0) goto L_0x0068
            android.widget.ImageButton r15 = r0.f1476i
            int r14 = r0.D(r15, r14, r11, r12)
            goto L_0x006e
        L_0x0068:
            android.widget.ImageButton r15 = r0.f1476i
            int r13 = r0.C(r15, r13, r11, r12)
        L_0x006e:
            androidx.appcompat.widget.ActionMenuView r15 = r0.f1469b
            boolean r15 = r0.P(r15)
            if (r15 == 0) goto L_0x0085
            if (r1 == 0) goto L_0x007f
            androidx.appcompat.widget.ActionMenuView r15 = r0.f1469b
            int r13 = r0.C(r15, r13, r11, r12)
            goto L_0x0085
        L_0x007f:
            androidx.appcompat.widget.ActionMenuView r15 = r0.f1469b
            int r14 = r0.D(r15, r14, r11, r12)
        L_0x0085:
            int r15 = r19.getCurrentContentInsetLeft()
            int r16 = r19.getCurrentContentInsetRight()
            int r3 = r15 - r13
            int r3 = java.lang.Math.max(r2, r3)
            r11[r2] = r3
            int r3 = r10 - r14
            int r3 = r16 - r3
            int r3 = java.lang.Math.max(r2, r3)
            r17 = 1
            r11[r17] = r3
            int r3 = java.lang.Math.max(r13, r15)
            int r10 = r10 - r16
            int r10 = java.lang.Math.min(r14, r10)
            android.view.View r13 = r0.f1477j
            boolean r13 = r0.P(r13)
            if (r13 == 0) goto L_0x00c2
            if (r1 == 0) goto L_0x00bc
            android.view.View r13 = r0.f1477j
            int r10 = r0.D(r13, r10, r11, r12)
            goto L_0x00c2
        L_0x00bc:
            android.view.View r13 = r0.f1477j
            int r3 = r0.C(r13, r3, r11, r12)
        L_0x00c2:
            android.widget.ImageView r13 = r0.f1473f
            boolean r13 = r0.P(r13)
            if (r13 == 0) goto L_0x00d9
            if (r1 == 0) goto L_0x00d3
            android.widget.ImageView r13 = r0.f1473f
            int r10 = r0.D(r13, r10, r11, r12)
            goto L_0x00d9
        L_0x00d3:
            android.widget.ImageView r13 = r0.f1473f
            int r3 = r0.C(r13, r3, r11, r12)
        L_0x00d9:
            android.widget.TextView r13 = r0.f1470c
            boolean r13 = r0.P(r13)
            android.widget.TextView r14 = r0.f1471d
            boolean r14 = r0.P(r14)
            if (r13 == 0) goto L_0x0100
            android.widget.TextView r15 = r0.f1470c
            android.view.ViewGroup$LayoutParams r15 = r15.getLayoutParams()
            androidx.appcompat.widget.Toolbar$LayoutParams r15 = (androidx.appcompat.widget.Toolbar.LayoutParams) r15
            int r2 = r15.topMargin
            r23 = r7
            android.widget.TextView r7 = r0.f1470c
            int r7 = r7.getMeasuredHeight()
            int r2 = r2 + r7
            int r7 = r15.bottomMargin
            int r2 = r2 + r7
            r7 = 0
            int r2 = r2 + r7
            goto L_0x0103
        L_0x0100:
            r23 = r7
            r2 = 0
        L_0x0103:
            if (r14 == 0) goto L_0x011d
            android.widget.TextView r7 = r0.f1471d
            android.view.ViewGroup$LayoutParams r7 = r7.getLayoutParams()
            androidx.appcompat.widget.Toolbar$LayoutParams r7 = (androidx.appcompat.widget.Toolbar.LayoutParams) r7
            int r15 = r7.topMargin
            r16 = r4
            android.widget.TextView r4 = r0.f1471d
            int r4 = r4.getMeasuredHeight()
            int r15 = r15 + r4
            int r4 = r7.bottomMargin
            int r15 = r15 + r4
            int r2 = r2 + r15
            goto L_0x011f
        L_0x011d:
            r16 = r4
        L_0x011f:
            if (r13 != 0) goto L_0x012b
            if (r14 == 0) goto L_0x0124
            goto L_0x012b
        L_0x0124:
            r18 = r6
            r22 = r12
        L_0x0128:
            r1 = 0
            goto L_0x0290
        L_0x012b:
            if (r13 == 0) goto L_0x0130
            android.widget.TextView r4 = r0.f1470c
            goto L_0x0132
        L_0x0130:
            android.widget.TextView r4 = r0.f1471d
        L_0x0132:
            if (r14 == 0) goto L_0x0137
            android.widget.TextView r7 = r0.f1471d
            goto L_0x0139
        L_0x0137:
            android.widget.TextView r7 = r0.f1470c
        L_0x0139:
            android.view.ViewGroup$LayoutParams r4 = r4.getLayoutParams()
            androidx.appcompat.widget.Toolbar$LayoutParams r4 = (androidx.appcompat.widget.Toolbar.LayoutParams) r4
            android.view.ViewGroup$LayoutParams r7 = r7.getLayoutParams()
            androidx.appcompat.widget.Toolbar$LayoutParams r7 = (androidx.appcompat.widget.Toolbar.LayoutParams) r7
            if (r13 == 0) goto L_0x014f
            android.widget.TextView r15 = r0.f1470c
            int r15 = r15.getMeasuredWidth()
            if (r15 > 0) goto L_0x0159
        L_0x014f:
            if (r14 == 0) goto L_0x015c
            android.widget.TextView r15 = r0.f1471d
            int r15 = r15.getMeasuredWidth()
            if (r15 <= 0) goto L_0x015c
        L_0x0159:
            r17 = 1
            goto L_0x015e
        L_0x015c:
            r17 = 0
        L_0x015e:
            int r15 = r0.f1491x
            r15 = r15 & 112(0x70, float:1.57E-43)
            r18 = r6
            r6 = 48
            if (r15 == r6) goto L_0x01a6
            r6 = 80
            if (r15 == r6) goto L_0x0198
            int r6 = r5 - r8
            int r6 = r6 - r9
            int r6 = r6 - r2
            int r6 = r6 / 2
            int r15 = r4.topMargin
            r22 = r12
            int r12 = r0.f1486s
            r24 = r3
            int r3 = r15 + r12
            if (r6 >= r3) goto L_0x0181
            int r6 = r15 + r12
            goto L_0x0196
        L_0x0181:
            int r5 = r5 - r9
            int r5 = r5 - r2
            int r5 = r5 - r6
            int r5 = r5 - r8
            int r2 = r4.bottomMargin
            int r3 = r0.f1487t
            int r2 = r2 + r3
            if (r5 >= r2) goto L_0x0196
            int r2 = r7.bottomMargin
            int r2 = r2 + r3
            int r2 = r2 - r5
            int r6 = r6 - r2
            r2 = 0
            int r6 = java.lang.Math.max(r2, r6)
        L_0x0196:
            int r8 = r8 + r6
            goto L_0x01b5
        L_0x0198:
            r24 = r3
            r22 = r12
            int r5 = r5 - r9
            int r3 = r7.bottomMargin
            int r5 = r5 - r3
            int r3 = r0.f1487t
            int r5 = r5 - r3
            int r8 = r5 - r2
            goto L_0x01b5
        L_0x01a6:
            r24 = r3
            r22 = r12
            int r2 = r19.getPaddingTop()
            int r3 = r4.topMargin
            int r2 = r2 + r3
            int r3 = r0.f1486s
            int r8 = r2 + r3
        L_0x01b5:
            if (r1 == 0) goto L_0x0227
            if (r17 == 0) goto L_0x01bc
            int r1 = r0.f1484q
            goto L_0x01bd
        L_0x01bc:
            r1 = 0
        L_0x01bd:
            r2 = 1
            r3 = r11[r2]
            int r1 = r1 - r3
            r3 = 0
            int r4 = java.lang.Math.max(r3, r1)
            int r10 = r10 - r4
            int r1 = -r1
            int r1 = java.lang.Math.max(r3, r1)
            r11[r2] = r1
            if (r13 == 0) goto L_0x01f4
            android.widget.TextView r1 = r0.f1470c
            android.view.ViewGroup$LayoutParams r1 = r1.getLayoutParams()
            androidx.appcompat.widget.Toolbar$LayoutParams r1 = (androidx.appcompat.widget.Toolbar.LayoutParams) r1
            android.widget.TextView r2 = r0.f1470c
            int r2 = r2.getMeasuredWidth()
            int r2 = r10 - r2
            android.widget.TextView r3 = r0.f1470c
            int r3 = r3.getMeasuredHeight()
            int r3 = r3 + r8
            android.widget.TextView r4 = r0.f1470c
            r4.layout(r2, r8, r10, r3)
            int r4 = r0.f1485r
            int r2 = r2 - r4
            int r1 = r1.bottomMargin
            int r8 = r3 + r1
            goto L_0x01f5
        L_0x01f4:
            r2 = r10
        L_0x01f5:
            if (r14 == 0) goto L_0x021b
            android.widget.TextView r1 = r0.f1471d
            android.view.ViewGroup$LayoutParams r1 = r1.getLayoutParams()
            androidx.appcompat.widget.Toolbar$LayoutParams r1 = (androidx.appcompat.widget.Toolbar.LayoutParams) r1
            int r1 = r1.topMargin
            int r8 = r8 + r1
            android.widget.TextView r1 = r0.f1471d
            int r1 = r1.getMeasuredWidth()
            int r1 = r10 - r1
            android.widget.TextView r3 = r0.f1471d
            int r3 = r3.getMeasuredHeight()
            int r3 = r3 + r8
            android.widget.TextView r4 = r0.f1471d
            r4.layout(r1, r8, r10, r3)
            int r1 = r0.f1485r
            int r1 = r10 - r1
            goto L_0x021c
        L_0x021b:
            r1 = r10
        L_0x021c:
            if (r17 == 0) goto L_0x0223
            int r1 = java.lang.Math.min(r2, r1)
            r10 = r1
        L_0x0223:
            r3 = r24
            goto L_0x0128
        L_0x0227:
            if (r17 == 0) goto L_0x022d
            int r7 = r0.f1484q
            r1 = 0
            goto L_0x022f
        L_0x022d:
            r1 = 0
            r7 = 0
        L_0x022f:
            r2 = r11[r1]
            int r7 = r7 - r2
            int r2 = java.lang.Math.max(r1, r7)
            int r3 = r24 + r2
            int r2 = -r7
            int r2 = java.lang.Math.max(r1, r2)
            r11[r1] = r2
            if (r13 == 0) goto L_0x0264
            android.widget.TextView r2 = r0.f1470c
            android.view.ViewGroup$LayoutParams r2 = r2.getLayoutParams()
            androidx.appcompat.widget.Toolbar$LayoutParams r2 = (androidx.appcompat.widget.Toolbar.LayoutParams) r2
            android.widget.TextView r4 = r0.f1470c
            int r4 = r4.getMeasuredWidth()
            int r4 = r4 + r3
            android.widget.TextView r5 = r0.f1470c
            int r5 = r5.getMeasuredHeight()
            int r5 = r5 + r8
            android.widget.TextView r6 = r0.f1470c
            r6.layout(r3, r8, r4, r5)
            int r6 = r0.f1485r
            int r4 = r4 + r6
            int r2 = r2.bottomMargin
            int r8 = r5 + r2
            goto L_0x0265
        L_0x0264:
            r4 = r3
        L_0x0265:
            if (r14 == 0) goto L_0x0289
            android.widget.TextView r2 = r0.f1471d
            android.view.ViewGroup$LayoutParams r2 = r2.getLayoutParams()
            androidx.appcompat.widget.Toolbar$LayoutParams r2 = (androidx.appcompat.widget.Toolbar.LayoutParams) r2
            int r2 = r2.topMargin
            int r8 = r8 + r2
            android.widget.TextView r2 = r0.f1471d
            int r2 = r2.getMeasuredWidth()
            int r2 = r2 + r3
            android.widget.TextView r5 = r0.f1471d
            int r5 = r5.getMeasuredHeight()
            int r5 = r5 + r8
            android.widget.TextView r6 = r0.f1471d
            r6.layout(r3, r8, r2, r5)
            int r5 = r0.f1485r
            int r2 = r2 + r5
            goto L_0x028a
        L_0x0289:
            r2 = r3
        L_0x028a:
            if (r17 == 0) goto L_0x0290
            int r3 = java.lang.Math.max(r4, r2)
        L_0x0290:
            java.util.ArrayList<android.view.View> r2 = r0.E
            r4 = 3
            r0.b(r2, r4)
            java.util.ArrayList<android.view.View> r2 = r0.E
            int r2 = r2.size()
            r7 = 0
        L_0x029d:
            if (r7 >= r2) goto L_0x02b0
            java.util.ArrayList<android.view.View> r4 = r0.E
            java.lang.Object r4 = r4.get(r7)
            android.view.View r4 = (android.view.View) r4
            r12 = r22
            int r3 = r0.C(r4, r3, r11, r12)
            int r7 = r7 + 1
            goto L_0x029d
        L_0x02b0:
            r12 = r22
            java.util.ArrayList<android.view.View> r2 = r0.E
            r4 = 5
            r0.b(r2, r4)
            java.util.ArrayList<android.view.View> r2 = r0.E
            int r2 = r2.size()
            r7 = 0
        L_0x02bf:
            if (r7 >= r2) goto L_0x02d0
            java.util.ArrayList<android.view.View> r4 = r0.E
            java.lang.Object r4 = r4.get(r7)
            android.view.View r4 = (android.view.View) r4
            int r10 = r0.D(r4, r10, r11, r12)
            int r7 = r7 + 1
            goto L_0x02bf
        L_0x02d0:
            java.util.ArrayList<android.view.View> r2 = r0.E
            r4 = 1
            r0.b(r2, r4)
            java.util.ArrayList<android.view.View> r2 = r0.E
            int r2 = r0.u(r2, r11)
            int r4 = r16 - r18
            int r4 = r4 - r23
            int r4 = r4 / 2
            int r6 = r18 + r4
            int r4 = r2 / 2
            int r6 = r6 - r4
            int r2 = r2 + r6
            if (r6 >= r3) goto L_0x02eb
            goto L_0x02f2
        L_0x02eb:
            if (r2 <= r10) goto L_0x02f1
            int r2 = r2 - r10
            int r3 = r6 - r2
            goto L_0x02f2
        L_0x02f1:
            r3 = r6
        L_0x02f2:
            java.util.ArrayList<android.view.View> r2 = r0.E
            int r2 = r2.size()
        L_0x02f8:
            if (r1 >= r2) goto L_0x0309
            java.util.ArrayList<android.view.View> r4 = r0.E
            java.lang.Object r4 = r4.get(r1)
            android.view.View r4 = (android.view.View) r4
            int r3 = r0.C(r4, r3, r11, r12)
            int r1 = r1 + 1
            goto L_0x02f8
        L_0x0309:
            java.util.ArrayList<android.view.View> r1 = r0.E
            r1.clear()
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.widget.Toolbar.onLayout(boolean, int, int, int, int):void");
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i2, int i3) {
        int i4;
        int i5;
        int i6;
        int i7;
        int i8;
        int i9;
        int i10;
        int[] iArr = this.G;
        char b2 = ViewUtils.b(this);
        int i11 = 0;
        char c2 = b2 ^ 1;
        if (P(this.f1472e)) {
            F(this.f1472e, i2, 0, i3, 0, this.f1483p);
            i6 = this.f1472e.getMeasuredWidth() + s(this.f1472e);
            i5 = Math.max(0, this.f1472e.getMeasuredHeight() + t(this.f1472e));
            i4 = View.combineMeasuredStates(0, this.f1472e.getMeasuredState());
        } else {
            i6 = 0;
            i5 = 0;
            i4 = 0;
        }
        if (P(this.f1476i)) {
            F(this.f1476i, i2, 0, i3, 0, this.f1483p);
            i6 = this.f1476i.getMeasuredWidth() + s(this.f1476i);
            i5 = Math.max(i5, this.f1476i.getMeasuredHeight() + t(this.f1476i));
            i4 = View.combineMeasuredStates(i4, this.f1476i.getMeasuredState());
        }
        int currentContentInsetStart = getCurrentContentInsetStart();
        int max = 0 + Math.max(currentContentInsetStart, i6);
        iArr[b2] = Math.max(0, currentContentInsetStart - i6);
        if (P(this.f1469b)) {
            F(this.f1469b, i2, max, i3, 0, this.f1483p);
            i7 = this.f1469b.getMeasuredWidth() + s(this.f1469b);
            i5 = Math.max(i5, this.f1469b.getMeasuredHeight() + t(this.f1469b));
            i4 = View.combineMeasuredStates(i4, this.f1469b.getMeasuredState());
        } else {
            i7 = 0;
        }
        int currentContentInsetEnd = getCurrentContentInsetEnd();
        int max2 = max + Math.max(currentContentInsetEnd, i7);
        iArr[c2] = Math.max(0, currentContentInsetEnd - i7);
        if (P(this.f1477j)) {
            max2 += E(this.f1477j, i2, max2, i3, 0, iArr);
            i5 = Math.max(i5, this.f1477j.getMeasuredHeight() + t(this.f1477j));
            i4 = View.combineMeasuredStates(i4, this.f1477j.getMeasuredState());
        }
        if (P(this.f1473f)) {
            max2 += E(this.f1473f, i2, max2, i3, 0, iArr);
            i5 = Math.max(i5, this.f1473f.getMeasuredHeight() + t(this.f1473f));
            i4 = View.combineMeasuredStates(i4, this.f1473f.getMeasuredState());
        }
        int childCount = getChildCount();
        for (int i12 = 0; i12 < childCount; i12++) {
            View childAt = getChildAt(i12);
            if (((LayoutParams) childAt.getLayoutParams()).f1501b == 0 && P(childAt)) {
                max2 += E(childAt, i2, max2, i3, 0, iArr);
                i5 = Math.max(i5, childAt.getMeasuredHeight() + t(childAt));
                i4 = View.combineMeasuredStates(i4, childAt.getMeasuredState());
            }
        }
        int i13 = this.f1486s + this.f1487t;
        int i14 = this.f1484q + this.f1485r;
        if (P(this.f1470c)) {
            E(this.f1470c, i2, max2 + i14, i3, i13, iArr);
            int measuredWidth = this.f1470c.getMeasuredWidth() + s(this.f1470c);
            i8 = this.f1470c.getMeasuredHeight() + t(this.f1470c);
            i10 = View.combineMeasuredStates(i4, this.f1470c.getMeasuredState());
            i9 = measuredWidth;
        } else {
            i10 = i4;
            i9 = 0;
            i8 = 0;
        }
        if (P(this.f1471d)) {
            int i15 = i8 + i13;
            i9 = Math.max(i9, E(this.f1471d, i2, max2 + i14, i3, i15, iArr));
            i8 += this.f1471d.getMeasuredHeight() + t(this.f1471d);
            i10 = View.combineMeasuredStates(i10, this.f1471d.getMeasuredState());
        } else {
            int i16 = i10;
        }
        int max3 = Math.max(i5, i8);
        int paddingLeft = max2 + i9 + getPaddingLeft() + getPaddingRight();
        int paddingTop = max3 + getPaddingTop() + getPaddingBottom();
        int resolveSizeAndState = View.resolveSizeAndState(Math.max(paddingLeft, getSuggestedMinimumWidth()), i2, -16777216 & i10);
        int resolveSizeAndState2 = View.resolveSizeAndState(Math.max(paddingTop, getSuggestedMinimumHeight()), i3, i10 << 16);
        if (!O()) {
            i11 = resolveSizeAndState2;
        }
        setMeasuredDimension(resolveSizeAndState, i11);
    }

    /* access modifiers changed from: protected */
    public void onRestoreInstanceState(Parcelable parcelable) {
        MenuBuilder menuBuilder;
        MenuItem findItem;
        if (!(parcelable instanceof SavedState)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.b());
        ActionMenuView actionMenuView = this.f1469b;
        if (actionMenuView != null) {
            menuBuilder = actionMenuView.L();
        } else {
            menuBuilder = null;
        }
        int i2 = savedState.f1502d;
        if (!(i2 == 0 || this.N == null || menuBuilder == null || (findItem = menuBuilder.findItem(i2)) == null)) {
            findItem.expandActionView();
        }
        if (savedState.f1503e) {
            H();
        }
    }

    public void onRtlPropertiesChanged(int i2) {
        super.onRtlPropertiesChanged(i2);
        h();
        RtlSpacingHelper rtlSpacingHelper = this.f1488u;
        boolean z2 = true;
        if (i2 != 1) {
            z2 = false;
        }
        rtlSpacingHelper.f(z2);
    }

    /* access modifiers changed from: protected */
    public Parcelable onSaveInstanceState() {
        MenuItemImpl menuItemImpl;
        SavedState savedState = new SavedState(super.onSaveInstanceState());
        ExpandedActionViewMenuPresenter expandedActionViewMenuPresenter = this.N;
        if (!(expandedActionViewMenuPresenter == null || (menuItemImpl = expandedActionViewMenuPresenter.f1499c) == null)) {
            savedState.f1502d = menuItemImpl.getItemId();
        }
        savedState.f1503e = B();
        return savedState;
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 0) {
            this.C = false;
        }
        if (!this.C) {
            boolean onTouchEvent = super.onTouchEvent(motionEvent);
            if (actionMasked == 0 && !onTouchEvent) {
                this.C = true;
            }
        }
        if (actionMasked == 1 || actionMasked == 3) {
            this.C = false;
        }
        return true;
    }

    public void setBackInvokedCallbackEnabled(boolean z2) {
        if (this.T != z2) {
            this.T = z2;
            R();
        }
    }

    public void setCollapseContentDescription(int i2) {
        setCollapseContentDescription(i2 != 0 ? getContext().getText(i2) : null);
    }

    public void setCollapseIcon(int i2) {
        setCollapseIcon(AppCompatResources.b(getContext(), i2));
    }

    public void setCollapsible(boolean z2) {
        this.Q = z2;
        requestLayout();
    }

    public void setContentInsetEndWithActions(int i2) {
        if (i2 < 0) {
            i2 = Integer.MIN_VALUE;
        }
        if (i2 != this.f1490w) {
            this.f1490w = i2;
            if (getNavigationIcon() != null) {
                requestLayout();
            }
        }
    }

    public void setContentInsetStartWithNavigation(int i2) {
        if (i2 < 0) {
            i2 = Integer.MIN_VALUE;
        }
        if (i2 != this.f1489v) {
            this.f1489v = i2;
            if (getNavigationIcon() != null) {
                requestLayout();
            }
        }
    }

    public void setLogo(int i2) {
        setLogo(AppCompatResources.b(getContext(), i2));
    }

    public void setLogoDescription(int i2) {
        setLogoDescription(getContext().getText(i2));
    }

    public void setNavigationContentDescription(int i2) {
        setNavigationContentDescription(i2 != 0 ? getContext().getText(i2) : null);
    }

    public void setNavigationIcon(int i2) {
        setNavigationIcon(AppCompatResources.b(getContext(), i2));
    }

    public void setNavigationOnClickListener(View.OnClickListener onClickListener) {
        l();
        this.f1472e.setOnClickListener(onClickListener);
    }

    public void setOnMenuItemClickListener(OnMenuItemClickListener onMenuItemClickListener) {
        this.J = onMenuItemClickListener;
    }

    public void setOverflowIcon(Drawable drawable) {
        j();
        this.f1469b.setOverflowIcon(drawable);
    }

    public void setPopupTheme(int i2) {
        if (this.f1479l != i2) {
            this.f1479l = i2;
            if (i2 == 0) {
                this.f1478k = getContext();
            } else {
                this.f1478k = new ContextThemeWrapper(getContext(), i2);
            }
        }
    }

    public void setSubtitle(int i2) {
        setSubtitle(getContext().getText(i2));
    }

    public void setSubtitleTextColor(int i2) {
        setSubtitleTextColor(ColorStateList.valueOf(i2));
    }

    public void setTitle(int i2) {
        setTitle(getContext().getText(i2));
    }

    public void setTitleMarginBottom(int i2) {
        this.f1487t = i2;
        requestLayout();
    }

    public void setTitleMarginEnd(int i2) {
        this.f1485r = i2;
        requestLayout();
    }

    public void setTitleMarginStart(int i2) {
        this.f1484q = i2;
        requestLayout();
    }

    public void setTitleMarginTop(int i2) {
        this.f1486s = i2;
        requestLayout();
    }

    public void setTitleTextColor(int i2) {
        setTitleTextColor(ColorStateList.valueOf(i2));
    }

    public boolean v() {
        ExpandedActionViewMenuPresenter expandedActionViewMenuPresenter = this.N;
        return (expandedActionViewMenuPresenter == null || expandedActionViewMenuPresenter.f1499c == null) ? false : true;
    }

    public boolean w() {
        ActionMenuView actionMenuView = this.f1469b;
        return actionMenuView != null && actionMenuView.F();
    }

    public void x(int i2) {
        getMenuInflater().inflate(i2, getMenu());
    }

    public void y() {
        Iterator<MenuItem> it2 = this.I.iterator();
        while (it2.hasNext()) {
            getMenu().removeItem(it2.next().getItemId());
        }
        G();
    }

    public static class LayoutParams extends ActionBar.LayoutParams {

        /* renamed from: b  reason: collision with root package name */
        int f1501b = 0;

        public LayoutParams(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
        }

        /* access modifiers changed from: package-private */
        public void a(ViewGroup.MarginLayoutParams marginLayoutParams) {
            this.leftMargin = marginLayoutParams.leftMargin;
            this.topMargin = marginLayoutParams.topMargin;
            this.rightMargin = marginLayoutParams.rightMargin;
            this.bottomMargin = marginLayoutParams.bottomMargin;
        }

        public LayoutParams(int i2, int i3) {
            super(i2, i3);
            this.f306a = 8388627;
        }

        public LayoutParams(LayoutParams layoutParams) {
            super((ActionBar.LayoutParams) layoutParams);
            this.f1501b = layoutParams.f1501b;
        }

        public LayoutParams(ActionBar.LayoutParams layoutParams) {
            super(layoutParams);
        }

        public LayoutParams(ViewGroup.MarginLayoutParams marginLayoutParams) {
            super((ViewGroup.LayoutParams) marginLayoutParams);
            a(marginLayoutParams);
        }

        public LayoutParams(ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
        }
    }

    public Toolbar(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.f1491x = 8388627;
        this.E = new ArrayList<>();
        this.F = new ArrayList<>();
        this.G = new int[2];
        this.H = new MenuHostHelper(new d1(this));
        this.I = new ArrayList<>();
        this.K = new ActionMenuView.OnMenuItemClickListener() {
            public boolean onMenuItemClick(MenuItem menuItem) {
                if (Toolbar.this.H.j(menuItem)) {
                    return true;
                }
                OnMenuItemClickListener onMenuItemClickListener = Toolbar.this.J;
                if (onMenuItemClickListener != null) {
                    return onMenuItemClickListener.onMenuItemClick(menuItem);
                }
                return false;
            }
        };
        this.U = new Runnable() {
            public void run() {
                Toolbar.this.Q();
            }
        };
        Context context2 = getContext();
        int[] iArr = R$styleable.t3;
        TintTypedArray v2 = TintTypedArray.v(context2, attributeSet, iArr, i2, 0);
        ViewCompat.p0(this, context, iArr, attributeSet, v2.r(), i2, 0);
        this.f1480m = v2.n(R$styleable.V3, 0);
        this.f1481n = v2.n(R$styleable.M3, 0);
        this.f1491x = v2.l(R$styleable.u3, this.f1491x);
        this.f1482o = v2.l(R$styleable.v3, 48);
        int e2 = v2.e(R$styleable.P3, 0);
        int i3 = R$styleable.U3;
        e2 = v2.s(i3) ? v2.e(i3, e2) : e2;
        this.f1487t = e2;
        this.f1486s = e2;
        this.f1485r = e2;
        this.f1484q = e2;
        int e3 = v2.e(R$styleable.S3, -1);
        if (e3 >= 0) {
            this.f1484q = e3;
        }
        int e4 = v2.e(R$styleable.R3, -1);
        if (e4 >= 0) {
            this.f1485r = e4;
        }
        int e5 = v2.e(R$styleable.T3, -1);
        if (e5 >= 0) {
            this.f1486s = e5;
        }
        int e6 = v2.e(R$styleable.Q3, -1);
        if (e6 >= 0) {
            this.f1487t = e6;
        }
        this.f1483p = v2.f(R$styleable.G3, -1);
        int e7 = v2.e(R$styleable.C3, Integer.MIN_VALUE);
        int e8 = v2.e(R$styleable.y3, Integer.MIN_VALUE);
        int f2 = v2.f(R$styleable.A3, 0);
        int f3 = v2.f(R$styleable.B3, 0);
        h();
        this.f1488u.e(f2, f3);
        if (!(e7 == Integer.MIN_VALUE && e8 == Integer.MIN_VALUE)) {
            this.f1488u.g(e7, e8);
        }
        this.f1489v = v2.e(R$styleable.D3, Integer.MIN_VALUE);
        this.f1490w = v2.e(R$styleable.z3, Integer.MIN_VALUE);
        this.f1474g = v2.g(R$styleable.x3);
        this.f1475h = v2.p(R$styleable.w3);
        CharSequence p2 = v2.p(R$styleable.O3);
        if (!TextUtils.isEmpty(p2)) {
            setTitle(p2);
        }
        CharSequence p3 = v2.p(R$styleable.L3);
        if (!TextUtils.isEmpty(p3)) {
            setSubtitle(p3);
        }
        this.f1478k = getContext();
        setPopupTheme(v2.n(R$styleable.K3, 0));
        Drawable g2 = v2.g(R$styleable.J3);
        if (g2 != null) {
            setNavigationIcon(g2);
        }
        CharSequence p4 = v2.p(R$styleable.I3);
        if (!TextUtils.isEmpty(p4)) {
            setNavigationContentDescription(p4);
        }
        Drawable g3 = v2.g(R$styleable.E3);
        if (g3 != null) {
            setLogo(g3);
        }
        CharSequence p5 = v2.p(R$styleable.F3);
        if (!TextUtils.isEmpty(p5)) {
            setLogoDescription(p5);
        }
        int i4 = R$styleable.W3;
        if (v2.s(i4)) {
            setTitleTextColor(v2.c(i4));
        }
        int i5 = R$styleable.N3;
        if (v2.s(i5)) {
            setSubtitleTextColor(v2.c(i5));
        }
        int i6 = R$styleable.H3;
        if (v2.s(i6)) {
            x(v2.n(i6, 0));
        }
        v2.w();
    }

    public void setCollapseContentDescription(CharSequence charSequence) {
        if (!TextUtils.isEmpty(charSequence)) {
            g();
        }
        ImageButton imageButton = this.f1476i;
        if (imageButton != null) {
            imageButton.setContentDescription(charSequence);
        }
    }

    public void setCollapseIcon(Drawable drawable) {
        if (drawable != null) {
            g();
            this.f1476i.setImageDrawable(drawable);
            return;
        }
        ImageButton imageButton = this.f1476i;
        if (imageButton != null) {
            imageButton.setImageDrawable(this.f1474g);
        }
    }

    public void setLogo(Drawable drawable) {
        if (drawable != null) {
            i();
            if (!z(this.f1473f)) {
                c(this.f1473f, true);
            }
        } else {
            ImageView imageView = this.f1473f;
            if (imageView != null && z(imageView)) {
                removeView(this.f1473f);
                this.F.remove(this.f1473f);
            }
        }
        ImageView imageView2 = this.f1473f;
        if (imageView2 != null) {
            imageView2.setImageDrawable(drawable);
        }
    }

    public void setLogoDescription(CharSequence charSequence) {
        if (!TextUtils.isEmpty(charSequence)) {
            i();
        }
        ImageView imageView = this.f1473f;
        if (imageView != null) {
            imageView.setContentDescription(charSequence);
        }
    }

    public void setNavigationContentDescription(CharSequence charSequence) {
        if (!TextUtils.isEmpty(charSequence)) {
            l();
        }
        ImageButton imageButton = this.f1472e;
        if (imageButton != null) {
            imageButton.setContentDescription(charSequence);
            TooltipCompat.a(this.f1472e, charSequence);
        }
    }

    public void setNavigationIcon(Drawable drawable) {
        if (drawable != null) {
            l();
            if (!z(this.f1472e)) {
                c(this.f1472e, true);
            }
        } else {
            ImageButton imageButton = this.f1472e;
            if (imageButton != null && z(imageButton)) {
                removeView(this.f1472e);
                this.F.remove(this.f1472e);
            }
        }
        ImageButton imageButton2 = this.f1472e;
        if (imageButton2 != null) {
            imageButton2.setImageDrawable(drawable);
        }
    }

    public void setSubtitle(CharSequence charSequence) {
        if (!TextUtils.isEmpty(charSequence)) {
            if (this.f1471d == null) {
                Context context = getContext();
                AppCompatTextView appCompatTextView = new AppCompatTextView(context);
                this.f1471d = appCompatTextView;
                appCompatTextView.setSingleLine();
                this.f1471d.setEllipsize(TextUtils.TruncateAt.END);
                int i2 = this.f1481n;
                if (i2 != 0) {
                    this.f1471d.setTextAppearance(context, i2);
                }
                ColorStateList colorStateList = this.B;
                if (colorStateList != null) {
                    this.f1471d.setTextColor(colorStateList);
                }
            }
            if (!z(this.f1471d)) {
                c(this.f1471d, true);
            }
        } else {
            TextView textView = this.f1471d;
            if (textView != null && z(textView)) {
                removeView(this.f1471d);
                this.F.remove(this.f1471d);
            }
        }
        TextView textView2 = this.f1471d;
        if (textView2 != null) {
            textView2.setText(charSequence);
        }
        this.f1493z = charSequence;
    }

    public void setSubtitleTextColor(ColorStateList colorStateList) {
        this.B = colorStateList;
        TextView textView = this.f1471d;
        if (textView != null) {
            textView.setTextColor(colorStateList);
        }
    }

    public void setTitle(CharSequence charSequence) {
        if (!TextUtils.isEmpty(charSequence)) {
            if (this.f1470c == null) {
                Context context = getContext();
                AppCompatTextView appCompatTextView = new AppCompatTextView(context);
                this.f1470c = appCompatTextView;
                appCompatTextView.setSingleLine();
                this.f1470c.setEllipsize(TextUtils.TruncateAt.END);
                int i2 = this.f1480m;
                if (i2 != 0) {
                    this.f1470c.setTextAppearance(context, i2);
                }
                ColorStateList colorStateList = this.A;
                if (colorStateList != null) {
                    this.f1470c.setTextColor(colorStateList);
                }
            }
            if (!z(this.f1470c)) {
                c(this.f1470c, true);
            }
        } else {
            TextView textView = this.f1470c;
            if (textView != null && z(textView)) {
                removeView(this.f1470c);
                this.F.remove(this.f1470c);
            }
        }
        TextView textView2 = this.f1470c;
        if (textView2 != null) {
            textView2.setText(charSequence);
        }
        this.f1492y = charSequence;
    }

    public void setTitleTextColor(ColorStateList colorStateList) {
        this.A = colorStateList;
        TextView textView = this.f1470c;
        if (textView != null) {
            textView.setTextColor(colorStateList);
        }
    }

    public static class SavedState extends AbsSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = new Parcelable.ClassLoaderCreator<SavedState>() {
            /* renamed from: a */
            public SavedState createFromParcel(Parcel parcel) {
                return new SavedState(parcel, (ClassLoader) null);
            }

            /* renamed from: b */
            public SavedState createFromParcel(Parcel parcel, ClassLoader classLoader) {
                return new SavedState(parcel, classLoader);
            }

            /* renamed from: c */
            public SavedState[] newArray(int i2) {
                return new SavedState[i2];
            }
        };

        /* renamed from: d  reason: collision with root package name */
        int f1502d;

        /* renamed from: e  reason: collision with root package name */
        boolean f1503e;

        public SavedState(Parcel parcel, ClassLoader classLoader) {
            super(parcel, classLoader);
            this.f1502d = parcel.readInt();
            this.f1503e = parcel.readInt() != 0;
        }

        public void writeToParcel(Parcel parcel, int i2) {
            super.writeToParcel(parcel, i2);
            parcel.writeInt(this.f1502d);
            parcel.writeInt(this.f1503e ? 1 : 0);
        }

        public SavedState(Parcelable parcelable) {
            super(parcelable);
        }
    }
}
