package com.google.android.material.navigation;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.FrameLayout;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.appcompat.view.SupportMenuInflater;
import androidx.appcompat.view.menu.MenuBuilder;
import androidx.appcompat.view.menu.MenuItemImpl;
import androidx.appcompat.widget.TintTypedArray;
import androidx.core.content.ContextCompat;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.customview.view.AbsSavedState;
import com.google.android.material.R$attr;
import com.google.android.material.R$style;
import com.google.android.material.R$styleable;
import com.google.android.material.internal.NavigationMenu;
import com.google.android.material.internal.NavigationMenuPresenter;
import com.google.android.material.internal.ScrimInsetsFrameLayout;
import com.google.android.material.internal.ThemeEnforcement;

public class NavigationView extends ScrimInsetsFrameLayout {

    /* renamed from: j  reason: collision with root package name */
    private static final int[] f29915j = {16842912};

    /* renamed from: k  reason: collision with root package name */
    private static final int[] f29916k = {-16842910};

    /* renamed from: e  reason: collision with root package name */
    private final NavigationMenu f29917e;

    /* renamed from: f  reason: collision with root package name */
    private final NavigationMenuPresenter f29918f;

    /* renamed from: g  reason: collision with root package name */
    OnNavigationItemSelectedListener f29919g;

    /* renamed from: h  reason: collision with root package name */
    private final int f29920h;

    /* renamed from: i  reason: collision with root package name */
    private MenuInflater f29921i;

    public interface OnNavigationItemSelectedListener {
        boolean q(MenuItem menuItem);
    }

    public NavigationView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R$attr.navigationViewStyle);
    }

    private ColorStateList b(int i2) {
        TypedValue typedValue = new TypedValue();
        if (!getContext().getTheme().resolveAttribute(i2, typedValue, true)) {
            return null;
        }
        ColorStateList a2 = AppCompatResources.a(getContext(), typedValue.resourceId);
        if (!getContext().getTheme().resolveAttribute(androidx.appcompat.R$attr.f114y, typedValue, true)) {
            return null;
        }
        int i3 = typedValue.data;
        int defaultColor = a2.getDefaultColor();
        int[] iArr = f29916k;
        return new ColorStateList(new int[][]{iArr, f29915j, FrameLayout.EMPTY_STATE_SET}, new int[]{a2.getColorForState(iArr, defaultColor), i3, defaultColor});
    }

    private MenuInflater getMenuInflater() {
        if (this.f29921i == null) {
            this.f29921i = new SupportMenuInflater(getContext());
        }
        return this.f29921i;
    }

    /* access modifiers changed from: protected */
    public void a(WindowInsetsCompat windowInsetsCompat) {
        this.f29918f.l(windowInsetsCompat);
    }

    public View c(int i2) {
        return this.f29918f.o(i2);
    }

    public View d(int i2) {
        return this.f29918f.v(i2);
    }

    public void e(int i2) {
        this.f29918f.E(true);
        getMenuInflater().inflate(i2, this.f29917e);
        this.f29918f.E(false);
        this.f29918f.h(false);
    }

    public MenuItem getCheckedItem() {
        return this.f29918f.m();
    }

    public int getHeaderCount() {
        return this.f29918f.n();
    }

    public Drawable getItemBackground() {
        return this.f29918f.p();
    }

    public int getItemHorizontalPadding() {
        return this.f29918f.q();
    }

    public int getItemIconPadding() {
        return this.f29918f.r();
    }

    public ColorStateList getItemIconTintList() {
        return this.f29918f.t();
    }

    public ColorStateList getItemTextColor() {
        return this.f29918f.s();
    }

    public Menu getMenu() {
        return this.f29917e;
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i2, int i3) {
        int mode = View.MeasureSpec.getMode(i2);
        if (mode == Integer.MIN_VALUE) {
            i2 = View.MeasureSpec.makeMeasureSpec(Math.min(View.MeasureSpec.getSize(i2), this.f29920h), 1073741824);
        } else if (mode == 0) {
            i2 = View.MeasureSpec.makeMeasureSpec(this.f29920h, 1073741824);
        }
        super.onMeasure(i2, i3);
    }

    /* access modifiers changed from: protected */
    public void onRestoreInstanceState(Parcelable parcelable) {
        if (!(parcelable instanceof SavedState)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.b());
        this.f29917e.S(savedState.f29923d);
    }

    /* access modifiers changed from: protected */
    public Parcelable onSaveInstanceState() {
        SavedState savedState = new SavedState(super.onSaveInstanceState());
        Bundle bundle = new Bundle();
        savedState.f29923d = bundle;
        this.f29917e.U(bundle);
        return savedState;
    }

    public void setCheckedItem(int i2) {
        MenuItem findItem = this.f29917e.findItem(i2);
        if (findItem != null) {
            this.f29918f.w((MenuItemImpl) findItem);
        }
    }

    public void setItemBackground(Drawable drawable) {
        this.f29918f.y(drawable);
    }

    public void setItemBackgroundResource(int i2) {
        setItemBackground(ContextCompat.getDrawable(getContext(), i2));
    }

    public void setItemHorizontalPadding(int i2) {
        this.f29918f.z(i2);
    }

    public void setItemHorizontalPaddingResource(int i2) {
        this.f29918f.z(getResources().getDimensionPixelSize(i2));
    }

    public void setItemIconPadding(int i2) {
        this.f29918f.A(i2);
    }

    public void setItemIconPaddingResource(int i2) {
        this.f29918f.A(getResources().getDimensionPixelSize(i2));
    }

    public void setItemIconTintList(ColorStateList colorStateList) {
        this.f29918f.B(colorStateList);
    }

    public void setItemTextAppearance(int i2) {
        this.f29918f.C(i2);
    }

    public void setItemTextColor(ColorStateList colorStateList) {
        this.f29918f.D(colorStateList);
    }

    public void setNavigationItemSelectedListener(OnNavigationItemSelectedListener onNavigationItemSelectedListener) {
        this.f29919g = onNavigationItemSelectedListener;
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
        public Bundle f29923d;

        public SavedState(Parcel parcel, ClassLoader classLoader) {
            super(parcel, classLoader);
            this.f29923d = parcel.readBundle(classLoader);
        }

        public void writeToParcel(Parcel parcel, int i2) {
            super.writeToParcel(parcel, i2);
            parcel.writeBundle(this.f29923d);
        }

        public SavedState(Parcelable parcelable) {
            super(parcelable);
        }
    }

    public NavigationView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        ColorStateList colorStateList;
        boolean z2;
        int i3;
        NavigationMenuPresenter navigationMenuPresenter = new NavigationMenuPresenter();
        this.f29918f = navigationMenuPresenter;
        NavigationMenu navigationMenu = new NavigationMenu(context);
        this.f29917e = navigationMenu;
        TintTypedArray i4 = ThemeEnforcement.i(context, attributeSet, R$styleable.l2, i2, R$style.Widget_Design_NavigationView, new int[0]);
        ViewCompat.v0(this, i4.g(R$styleable.m2));
        int i5 = R$styleable.p2;
        if (i4.s(i5)) {
            ViewCompat.z0(this, (float) i4.f(i5, 0));
        }
        ViewCompat.A0(this, i4.a(R$styleable.n2, false));
        this.f29920h = i4.f(R$styleable.o2, 0);
        int i6 = R$styleable.u2;
        if (i4.s(i6)) {
            colorStateList = i4.c(i6);
        } else {
            colorStateList = b(16842808);
        }
        int i7 = R$styleable.v2;
        if (i4.s(i7)) {
            i3 = i4.n(i7, 0);
            z2 = true;
        } else {
            i3 = 0;
            z2 = false;
        }
        int i8 = R$styleable.w2;
        ColorStateList c2 = i4.s(i8) ? i4.c(i8) : null;
        if (!z2 && c2 == null) {
            c2 = b(16842806);
        }
        Drawable g2 = i4.g(R$styleable.r2);
        int i9 = R$styleable.s2;
        if (i4.s(i9)) {
            navigationMenuPresenter.z(i4.f(i9, 0));
        }
        int f2 = i4.f(R$styleable.t2, 0);
        navigationMenu.V(new MenuBuilder.Callback() {
            public boolean a(MenuBuilder menuBuilder, MenuItem menuItem) {
                OnNavigationItemSelectedListener onNavigationItemSelectedListener = NavigationView.this.f29919g;
                return onNavigationItemSelectedListener != null && onNavigationItemSelectedListener.q(menuItem);
            }

            public void b(MenuBuilder menuBuilder) {
            }
        });
        navigationMenuPresenter.x(1);
        navigationMenuPresenter.k(context, navigationMenu);
        navigationMenuPresenter.B(colorStateList);
        if (z2) {
            navigationMenuPresenter.C(i3);
        }
        navigationMenuPresenter.D(c2);
        navigationMenuPresenter.y(g2);
        navigationMenuPresenter.A(f2);
        navigationMenu.b(navigationMenuPresenter);
        addView((View) navigationMenuPresenter.u(this));
        int i10 = R$styleable.x2;
        if (i4.s(i10)) {
            e(i4.n(i10, 0));
        }
        int i11 = R$styleable.q2;
        if (i4.s(i11)) {
            d(i4.n(i11, 0));
        }
        i4.w();
    }

    public void setCheckedItem(MenuItem menuItem) {
        MenuItem findItem = this.f29917e.findItem(menuItem.getItemId());
        if (findItem != null) {
            this.f29918f.w((MenuItemImpl) findItem);
            return;
        }
        throw new IllegalArgumentException("Called setCheckedItem(MenuItem) with an item that is not in the current menu.");
    }
}
