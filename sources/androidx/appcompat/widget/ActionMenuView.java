package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.Configuration;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.ContextThemeWrapper;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewDebug;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityEvent;
import androidx.appcompat.view.menu.ActionMenuItemView;
import androidx.appcompat.view.menu.MenuBuilder;
import androidx.appcompat.view.menu.MenuItemImpl;
import androidx.appcompat.view.menu.MenuPresenter;
import androidx.appcompat.view.menu.MenuView;
import androidx.appcompat.widget.LinearLayoutCompat;

public class ActionMenuView extends LinearLayoutCompat implements MenuBuilder.ItemInvoker, MenuView {
    private int A;
    OnMenuItemClickListener B;

    /* renamed from: q  reason: collision with root package name */
    private MenuBuilder f1042q;

    /* renamed from: r  reason: collision with root package name */
    private Context f1043r;

    /* renamed from: s  reason: collision with root package name */
    private int f1044s;

    /* renamed from: t  reason: collision with root package name */
    private boolean f1045t;

    /* renamed from: u  reason: collision with root package name */
    private ActionMenuPresenter f1046u;

    /* renamed from: v  reason: collision with root package name */
    private MenuPresenter.Callback f1047v;

    /* renamed from: w  reason: collision with root package name */
    MenuBuilder.Callback f1048w;

    /* renamed from: x  reason: collision with root package name */
    private boolean f1049x;

    /* renamed from: y  reason: collision with root package name */
    private int f1050y;

    /* renamed from: z  reason: collision with root package name */
    private int f1051z;

    public interface ActionMenuChildView {
        boolean a();

        boolean b();
    }

    private static class ActionMenuPresenterCallback implements MenuPresenter.Callback {
        ActionMenuPresenterCallback() {
        }

        public void a(MenuBuilder menuBuilder, boolean z2) {
        }

        public boolean b(MenuBuilder menuBuilder) {
            return false;
        }
    }

    public static class LayoutParams extends LinearLayoutCompat.LayoutParams {
        @ViewDebug.ExportedProperty

        /* renamed from: a  reason: collision with root package name */
        public boolean f1052a;
        @ViewDebug.ExportedProperty

        /* renamed from: b  reason: collision with root package name */
        public int f1053b;
        @ViewDebug.ExportedProperty

        /* renamed from: c  reason: collision with root package name */
        public int f1054c;
        @ViewDebug.ExportedProperty

        /* renamed from: d  reason: collision with root package name */
        public boolean f1055d;
        @ViewDebug.ExportedProperty

        /* renamed from: e  reason: collision with root package name */
        public boolean f1056e;

        /* renamed from: f  reason: collision with root package name */
        boolean f1057f;

        public LayoutParams(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
        }

        public LayoutParams(ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
        }

        public LayoutParams(LayoutParams layoutParams) {
            super(layoutParams);
            this.f1052a = layoutParams.f1052a;
        }

        public LayoutParams(int i2, int i3) {
            super(i2, i3);
            this.f1052a = false;
        }
    }

    private class MenuBuilderCallback implements MenuBuilder.Callback {
        MenuBuilderCallback() {
        }

        public boolean a(MenuBuilder menuBuilder, MenuItem menuItem) {
            OnMenuItemClickListener onMenuItemClickListener = ActionMenuView.this.B;
            if (onMenuItemClickListener == null || !onMenuItemClickListener.onMenuItemClick(menuItem)) {
                return false;
            }
            return true;
        }

        public void b(MenuBuilder menuBuilder) {
            MenuBuilder.Callback callback = ActionMenuView.this.f1048w;
            if (callback != null) {
                callback.b(menuBuilder);
            }
        }
    }

    public interface OnMenuItemClickListener {
        boolean onMenuItemClick(MenuItem menuItem);
    }

    public ActionMenuView(Context context) {
        this(context, (AttributeSet) null);
    }

    static int J(View view, int i2, int i3, int i4, int i5) {
        ActionMenuItemView actionMenuItemView;
        boolean z2;
        int i6;
        LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
        int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(View.MeasureSpec.getSize(i4) - i5, View.MeasureSpec.getMode(i4));
        if (view instanceof ActionMenuItemView) {
            actionMenuItemView = (ActionMenuItemView) view;
        } else {
            actionMenuItemView = null;
        }
        boolean z3 = true;
        if (actionMenuItemView == null || !actionMenuItemView.e()) {
            z2 = false;
        } else {
            z2 = true;
        }
        if (i3 > 0) {
            i6 = 2;
            if (!z2 || i3 >= 2) {
                view.measure(View.MeasureSpec.makeMeasureSpec(i3 * i2, Integer.MIN_VALUE), makeMeasureSpec);
                int measuredWidth = view.getMeasuredWidth();
                int i7 = measuredWidth / i2;
                if (measuredWidth % i2 != 0) {
                    i7++;
                }
                if (!z2 || i7 >= 2) {
                    i6 = i7;
                }
                if (layoutParams.f1052a || !z2) {
                    z3 = false;
                }
                layoutParams.f1055d = z3;
                layoutParams.f1053b = i6;
                view.measure(View.MeasureSpec.makeMeasureSpec(i2 * i6, 1073741824), makeMeasureSpec);
                return i6;
            }
        }
        i6 = 0;
        z3 = false;
        layoutParams.f1055d = z3;
        layoutParams.f1053b = i6;
        view.measure(View.MeasureSpec.makeMeasureSpec(i2 * i6, 1073741824), makeMeasureSpec);
        return i6;
    }

    private void K(int i2, int i3) {
        boolean z2;
        int i4;
        boolean z3;
        int i5;
        int i6;
        boolean z4;
        boolean z5;
        int i7;
        int i8;
        boolean z6;
        int i9;
        boolean z7;
        boolean z8;
        int i10;
        int mode = View.MeasureSpec.getMode(i3);
        int size = View.MeasureSpec.getSize(i2);
        int size2 = View.MeasureSpec.getSize(i3);
        int paddingLeft = getPaddingLeft() + getPaddingRight();
        int paddingTop = getPaddingTop() + getPaddingBottom();
        int childMeasureSpec = ViewGroup.getChildMeasureSpec(i3, paddingTop, -2);
        int i11 = size - paddingLeft;
        int i12 = this.f1051z;
        int i13 = i11 / i12;
        int i14 = i11 % i12;
        if (i13 == 0) {
            setMeasuredDimension(i11, 0);
            return;
        }
        int i15 = i12 + (i14 / i13);
        int childCount = getChildCount();
        int i16 = 0;
        int i17 = 0;
        boolean z9 = false;
        int i18 = 0;
        int i19 = 0;
        int i20 = 0;
        long j2 = 0;
        while (i17 < childCount) {
            View childAt = getChildAt(i17);
            int i21 = size2;
            if (childAt.getVisibility() != 8) {
                boolean z10 = childAt instanceof ActionMenuItemView;
                int i22 = i18 + 1;
                if (z10) {
                    int i23 = this.A;
                    i9 = i22;
                    z7 = false;
                    childAt.setPadding(i23, 0, i23, 0);
                } else {
                    i9 = i22;
                    z7 = false;
                }
                LayoutParams layoutParams = (LayoutParams) childAt.getLayoutParams();
                layoutParams.f1057f = z7;
                layoutParams.f1054c = z7 ? 1 : 0;
                layoutParams.f1053b = z7;
                layoutParams.f1055d = z7;
                layoutParams.leftMargin = z7;
                layoutParams.rightMargin = z7;
                if (!z10 || !((ActionMenuItemView) childAt).e()) {
                    z8 = false;
                } else {
                    z8 = true;
                }
                layoutParams.f1056e = z8;
                if (layoutParams.f1052a) {
                    i10 = 1;
                } else {
                    i10 = i13;
                }
                int J = J(childAt, i15, i10, childMeasureSpec, paddingTop);
                i19 = Math.max(i19, J);
                if (layoutParams.f1055d) {
                    i20++;
                }
                if (layoutParams.f1052a) {
                    z9 = true;
                }
                i13 -= J;
                i16 = Math.max(i16, childAt.getMeasuredHeight());
                if (J == 1) {
                    j2 |= (long) (1 << i17);
                    i16 = i16;
                } else {
                    int i24 = i16;
                }
                i18 = i9;
            }
            i17++;
            size2 = i21;
        }
        int i25 = size2;
        if (!z9 || i18 != 2) {
            z2 = false;
        } else {
            z2 = true;
        }
        boolean z11 = false;
        while (true) {
            if (i20 <= 0 || i13 <= 0) {
                i6 = mode;
                i4 = i11;
                z3 = z11;
                i5 = i16;
            } else {
                int i26 = 0;
                int i27 = 0;
                int i28 = Integer.MAX_VALUE;
                long j3 = 0;
                while (i27 < childCount) {
                    boolean z12 = z11;
                    LayoutParams layoutParams2 = (LayoutParams) getChildAt(i27).getLayoutParams();
                    int i29 = i16;
                    if (layoutParams2.f1055d) {
                        int i30 = layoutParams2.f1053b;
                        if (i30 < i28) {
                            j3 = 1 << i27;
                            i28 = i30;
                            i26 = 1;
                        } else if (i30 == i28) {
                            i26++;
                            j3 |= 1 << i27;
                        }
                    }
                    i27++;
                    i16 = i29;
                    z11 = z12;
                }
                z3 = z11;
                i5 = i16;
                j2 |= j3;
                if (i26 > i13) {
                    i6 = mode;
                    i4 = i11;
                    break;
                }
                int i31 = i28 + 1;
                int i32 = 0;
                while (i32 < childCount) {
                    View childAt2 = getChildAt(i32);
                    LayoutParams layoutParams3 = (LayoutParams) childAt2.getLayoutParams();
                    int i33 = i11;
                    int i34 = mode;
                    long j4 = (long) (1 << i32);
                    if ((j3 & j4) == 0) {
                        if (layoutParams3.f1053b == i31) {
                            j2 |= j4;
                        }
                        z6 = z2;
                    } else {
                        if (!z2 || !layoutParams3.f1056e || i13 != 1) {
                            z6 = z2;
                        } else {
                            int i35 = this.A;
                            z6 = z2;
                            childAt2.setPadding(i35 + i15, 0, i35, 0);
                        }
                        layoutParams3.f1053b++;
                        layoutParams3.f1057f = true;
                        i13--;
                    }
                    i32++;
                    mode = i34;
                    i11 = i33;
                    z2 = z6;
                }
                i16 = i5;
                z11 = true;
            }
        }
        if (z9 || i18 != 1) {
            z4 = false;
        } else {
            z4 = true;
        }
        if (i13 <= 0 || j2 == 0 || (i13 >= i18 - 1 && !z4 && i19 <= 1)) {
            z5 = z3;
        } else {
            float bitCount = (float) Long.bitCount(j2);
            if (!z4) {
                if ((j2 & 1) != 0 && !((LayoutParams) getChildAt(0).getLayoutParams()).f1056e) {
                    bitCount -= 0.5f;
                }
                int i36 = childCount - 1;
                if ((j2 & ((long) (1 << i36))) != 0 && !((LayoutParams) getChildAt(i36).getLayoutParams()).f1056e) {
                    bitCount -= 0.5f;
                }
            }
            if (bitCount > 0.0f) {
                i8 = (int) (((float) (i13 * i15)) / bitCount);
            } else {
                i8 = 0;
            }
            z5 = z3;
            for (int i37 = 0; i37 < childCount; i37++) {
                if ((j2 & ((long) (1 << i37))) != 0) {
                    View childAt3 = getChildAt(i37);
                    LayoutParams layoutParams4 = (LayoutParams) childAt3.getLayoutParams();
                    if (childAt3 instanceof ActionMenuItemView) {
                        layoutParams4.f1054c = i8;
                        layoutParams4.f1057f = true;
                        if (i37 == 0 && !layoutParams4.f1056e) {
                            layoutParams4.leftMargin = (-i8) / 2;
                        }
                    } else if (layoutParams4.f1052a) {
                        layoutParams4.f1054c = i8;
                        layoutParams4.f1057f = true;
                        layoutParams4.rightMargin = (-i8) / 2;
                    } else {
                        if (i37 != 0) {
                            layoutParams4.leftMargin = i8 / 2;
                        }
                        if (i37 != childCount - 1) {
                            layoutParams4.rightMargin = i8 / 2;
                        }
                    }
                    z5 = true;
                }
            }
        }
        if (z5) {
            for (int i38 = 0; i38 < childCount; i38++) {
                View childAt4 = getChildAt(i38);
                LayoutParams layoutParams5 = (LayoutParams) childAt4.getLayoutParams();
                if (layoutParams5.f1057f) {
                    childAt4.measure(View.MeasureSpec.makeMeasureSpec((layoutParams5.f1053b * i15) + layoutParams5.f1054c, 1073741824), childMeasureSpec);
                }
            }
        }
        if (i6 != 1073741824) {
            i7 = i5;
        } else {
            i7 = i25;
        }
        setMeasuredDimension(i4, i7);
    }

    /* access modifiers changed from: protected */
    /* renamed from: A */
    public LayoutParams k() {
        LayoutParams layoutParams = new LayoutParams(-2, -2);
        layoutParams.gravity = 16;
        return layoutParams;
    }

    /* renamed from: B */
    public LayoutParams l(AttributeSet attributeSet) {
        return new LayoutParams(getContext(), attributeSet);
    }

    /* access modifiers changed from: protected */
    /* renamed from: C */
    public LayoutParams m(ViewGroup.LayoutParams layoutParams) {
        LayoutParams layoutParams2;
        if (layoutParams == null) {
            return k();
        }
        if (layoutParams instanceof LayoutParams) {
            layoutParams2 = new LayoutParams((LayoutParams) layoutParams);
        } else {
            layoutParams2 = new LayoutParams(layoutParams);
        }
        if (layoutParams2.gravity <= 0) {
            layoutParams2.gravity = 16;
        }
        return layoutParams2;
    }

    public LayoutParams D() {
        LayoutParams A2 = k();
        A2.f1052a = true;
        return A2;
    }

    /* access modifiers changed from: protected */
    public boolean E(int i2) {
        boolean z2 = false;
        if (i2 == 0) {
            return false;
        }
        View childAt = getChildAt(i2 - 1);
        View childAt2 = getChildAt(i2);
        if (i2 < getChildCount() && (childAt instanceof ActionMenuChildView)) {
            z2 = false | ((ActionMenuChildView) childAt).a();
        }
        if (i2 <= 0 || !(childAt2 instanceof ActionMenuChildView)) {
            return z2;
        }
        return z2 | ((ActionMenuChildView) childAt2).b();
    }

    public boolean F() {
        ActionMenuPresenter actionMenuPresenter = this.f1046u;
        return actionMenuPresenter != null && actionMenuPresenter.E();
    }

    public boolean G() {
        ActionMenuPresenter actionMenuPresenter = this.f1046u;
        return actionMenuPresenter != null && actionMenuPresenter.G();
    }

    public boolean H() {
        ActionMenuPresenter actionMenuPresenter = this.f1046u;
        return actionMenuPresenter != null && actionMenuPresenter.H();
    }

    public boolean I() {
        return this.f1045t;
    }

    public MenuBuilder L() {
        return this.f1042q;
    }

    public void M(MenuPresenter.Callback callback, MenuBuilder.Callback callback2) {
        this.f1047v = callback;
        this.f1048w = callback2;
    }

    public boolean N() {
        ActionMenuPresenter actionMenuPresenter = this.f1046u;
        return actionMenuPresenter != null && actionMenuPresenter.N();
    }

    public void a(MenuBuilder menuBuilder) {
        this.f1042q = menuBuilder;
    }

    public boolean b(MenuItemImpl menuItemImpl) {
        return this.f1042q.N(menuItemImpl, 0);
    }

    /* access modifiers changed from: protected */
    public boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return layoutParams instanceof LayoutParams;
    }

    public boolean dispatchPopulateAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        return false;
    }

    public Menu getMenu() {
        if (this.f1042q == null) {
            Context context = getContext();
            MenuBuilder menuBuilder = new MenuBuilder(context);
            this.f1042q = menuBuilder;
            menuBuilder.V(new MenuBuilderCallback());
            ActionMenuPresenter actionMenuPresenter = new ActionMenuPresenter(context);
            this.f1046u = actionMenuPresenter;
            actionMenuPresenter.M(true);
            ActionMenuPresenter actionMenuPresenter2 = this.f1046u;
            MenuPresenter.Callback callback = this.f1047v;
            if (callback == null) {
                callback = new ActionMenuPresenterCallback();
            }
            actionMenuPresenter2.c(callback);
            this.f1042q.c(this.f1046u, this.f1043r);
            this.f1046u.K(this);
        }
        return this.f1042q;
    }

    public Drawable getOverflowIcon() {
        getMenu();
        return this.f1046u.D();
    }

    public int getPopupTheme() {
        return this.f1044s;
    }

    public int getWindowAnimations() {
        return 0;
    }

    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        ActionMenuPresenter actionMenuPresenter = this.f1046u;
        if (actionMenuPresenter != null) {
            actionMenuPresenter.h(false);
            if (this.f1046u.H()) {
                this.f1046u.E();
                this.f1046u.N();
            }
        }
    }

    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        z();
    }

    /* access modifiers changed from: protected */
    public void onLayout(boolean z2, int i2, int i3, int i4, int i5) {
        int i6;
        int i7;
        int i8;
        if (!this.f1049x) {
            super.onLayout(z2, i2, i3, i4, i5);
            return;
        }
        int childCount = getChildCount();
        int i9 = (i5 - i3) / 2;
        int dividerWidth = getDividerWidth();
        int i10 = i4 - i2;
        int paddingRight = (i10 - getPaddingRight()) - getPaddingLeft();
        boolean b2 = ViewUtils.b(this);
        int i11 = 0;
        int i12 = 0;
        for (int i13 = 0; i13 < childCount; i13++) {
            View childAt = getChildAt(i13);
            if (childAt.getVisibility() != 8) {
                LayoutParams layoutParams = (LayoutParams) childAt.getLayoutParams();
                if (layoutParams.f1052a) {
                    int measuredWidth = childAt.getMeasuredWidth();
                    if (E(i13)) {
                        measuredWidth += dividerWidth;
                    }
                    int measuredHeight = childAt.getMeasuredHeight();
                    if (b2) {
                        i7 = getPaddingLeft() + layoutParams.leftMargin;
                        i8 = i7 + measuredWidth;
                    } else {
                        i8 = (getWidth() - getPaddingRight()) - layoutParams.rightMargin;
                        i7 = i8 - measuredWidth;
                    }
                    int i14 = i9 - (measuredHeight / 2);
                    childAt.layout(i7, i14, i8, measuredHeight + i14);
                    paddingRight -= measuredWidth;
                    i11 = 1;
                } else {
                    paddingRight -= (childAt.getMeasuredWidth() + layoutParams.leftMargin) + layoutParams.rightMargin;
                    E(i13);
                    i12++;
                }
            }
        }
        if (childCount == 1 && i11 == 0) {
            View childAt2 = getChildAt(0);
            int measuredWidth2 = childAt2.getMeasuredWidth();
            int measuredHeight2 = childAt2.getMeasuredHeight();
            int i15 = (i10 / 2) - (measuredWidth2 / 2);
            int i16 = i9 - (measuredHeight2 / 2);
            childAt2.layout(i15, i16, measuredWidth2 + i15, measuredHeight2 + i16);
            return;
        }
        int i17 = i12 - (i11 ^ 1);
        if (i17 > 0) {
            i6 = paddingRight / i17;
        } else {
            i6 = 0;
        }
        int max = Math.max(0, i6);
        if (b2) {
            int width = getWidth() - getPaddingRight();
            for (int i18 = 0; i18 < childCount; i18++) {
                View childAt3 = getChildAt(i18);
                LayoutParams layoutParams2 = (LayoutParams) childAt3.getLayoutParams();
                if (childAt3.getVisibility() != 8 && !layoutParams2.f1052a) {
                    int i19 = width - layoutParams2.rightMargin;
                    int measuredWidth3 = childAt3.getMeasuredWidth();
                    int measuredHeight3 = childAt3.getMeasuredHeight();
                    int i20 = i9 - (measuredHeight3 / 2);
                    childAt3.layout(i19 - measuredWidth3, i20, i19, measuredHeight3 + i20);
                    width = i19 - ((measuredWidth3 + layoutParams2.leftMargin) + max);
                }
            }
            return;
        }
        int paddingLeft = getPaddingLeft();
        for (int i21 = 0; i21 < childCount; i21++) {
            View childAt4 = getChildAt(i21);
            LayoutParams layoutParams3 = (LayoutParams) childAt4.getLayoutParams();
            if (childAt4.getVisibility() != 8 && !layoutParams3.f1052a) {
                int i22 = paddingLeft + layoutParams3.leftMargin;
                int measuredWidth4 = childAt4.getMeasuredWidth();
                int measuredHeight4 = childAt4.getMeasuredHeight();
                int i23 = i9 - (measuredHeight4 / 2);
                childAt4.layout(i22, i23, i22 + measuredWidth4, measuredHeight4 + i23);
                paddingLeft = i22 + measuredWidth4 + layoutParams3.rightMargin + max;
            }
        }
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i2, int i3) {
        boolean z2;
        MenuBuilder menuBuilder;
        boolean z3 = this.f1049x;
        if (View.MeasureSpec.getMode(i2) == 1073741824) {
            z2 = true;
        } else {
            z2 = false;
        }
        this.f1049x = z2;
        if (z3 != z2) {
            this.f1050y = 0;
        }
        int size = View.MeasureSpec.getSize(i2);
        if (!(!this.f1049x || (menuBuilder = this.f1042q) == null || size == this.f1050y)) {
            this.f1050y = size;
            menuBuilder.M(true);
        }
        int childCount = getChildCount();
        if (!this.f1049x || childCount <= 0) {
            for (int i4 = 0; i4 < childCount; i4++) {
                LayoutParams layoutParams = (LayoutParams) getChildAt(i4).getLayoutParams();
                layoutParams.rightMargin = 0;
                layoutParams.leftMargin = 0;
            }
            super.onMeasure(i2, i3);
            return;
        }
        K(i2, i3);
    }

    public void setExpandedActionViewsExclusive(boolean z2) {
        this.f1046u.J(z2);
    }

    public void setOnMenuItemClickListener(OnMenuItemClickListener onMenuItemClickListener) {
        this.B = onMenuItemClickListener;
    }

    public void setOverflowIcon(Drawable drawable) {
        getMenu();
        this.f1046u.L(drawable);
    }

    public void setOverflowReserved(boolean z2) {
        this.f1045t = z2;
    }

    public void setPopupTheme(int i2) {
        if (this.f1044s != i2) {
            this.f1044s = i2;
            if (i2 == 0) {
                this.f1043r = getContext();
            } else {
                this.f1043r = new ContextThemeWrapper(getContext(), i2);
            }
        }
    }

    public void setPresenter(ActionMenuPresenter actionMenuPresenter) {
        this.f1046u = actionMenuPresenter;
        actionMenuPresenter.K(this);
    }

    public void z() {
        ActionMenuPresenter actionMenuPresenter = this.f1046u;
        if (actionMenuPresenter != null) {
            actionMenuPresenter.B();
        }
    }

    public ActionMenuView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        setBaselineAligned(false);
        float f2 = context.getResources().getDisplayMetrics().density;
        this.f1051z = (int) (56.0f * f2);
        this.A = (int) (f2 * 4.0f);
        this.f1043r = context;
        this.f1044s = 0;
    }
}
