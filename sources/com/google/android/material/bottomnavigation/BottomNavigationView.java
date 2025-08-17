package com.google.android.material.bottomnavigation;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.FrameLayout;
import androidx.appcompat.view.SupportMenuInflater;
import androidx.appcompat.view.menu.MenuBuilder;
import androidx.appcompat.widget.TintTypedArray;
import androidx.core.view.ViewCompat;
import androidx.customview.view.AbsSavedState;
import com.google.android.material.R$dimen;
import com.google.android.material.R$style;
import com.google.android.material.R$styleable;
import com.google.android.material.internal.ThemeEnforcement;

public class BottomNavigationView extends FrameLayout {

    /* renamed from: b  reason: collision with root package name */
    private final MenuBuilder f29588b;

    /* renamed from: c  reason: collision with root package name */
    private final BottomNavigationMenuView f29589c;

    /* renamed from: d  reason: collision with root package name */
    private final BottomNavigationPresenter f29590d;

    /* renamed from: e  reason: collision with root package name */
    private MenuInflater f29591e;

    public interface OnNavigationItemReselectedListener {
    }

    public interface OnNavigationItemSelectedListener {
    }

    static class SavedState extends AbsSavedState {
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
        Bundle f29593d;

        public SavedState(Parcelable parcelable) {
            super(parcelable);
        }

        private void c(Parcel parcel, ClassLoader classLoader) {
            this.f29593d = parcel.readBundle(classLoader);
        }

        public void writeToParcel(Parcel parcel, int i2) {
            super.writeToParcel(parcel, i2);
            parcel.writeBundle(this.f29593d);
        }

        public SavedState(Parcel parcel, ClassLoader classLoader) {
            super(parcel, classLoader);
            c(parcel, classLoader);
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public BottomNavigationView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        BottomNavigationPresenter bottomNavigationPresenter = new BottomNavigationPresenter();
        this.f29590d = bottomNavigationPresenter;
        BottomNavigationMenu bottomNavigationMenu = new BottomNavigationMenu(context);
        this.f29588b = bottomNavigationMenu;
        BottomNavigationMenuView bottomNavigationMenuView = new BottomNavigationMenuView(context);
        this.f29589c = bottomNavigationMenuView;
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
        layoutParams.gravity = 17;
        bottomNavigationMenuView.setLayoutParams(layoutParams);
        bottomNavigationPresenter.f(bottomNavigationMenuView);
        bottomNavigationPresenter.l(1);
        bottomNavigationMenuView.setPresenter(bottomNavigationPresenter);
        bottomNavigationMenu.b(bottomNavigationPresenter);
        bottomNavigationPresenter.k(getContext(), bottomNavigationMenu);
        int[] iArr = R$styleable.D;
        int i3 = R$style.Widget_Design_BottomNavigationView;
        int i4 = R$styleable.K;
        int i5 = R$styleable.J;
        TintTypedArray i6 = ThemeEnforcement.i(context, attributeSet, iArr, i2, i3, i4, i5);
        int i7 = R$styleable.I;
        if (i6.s(i7)) {
            bottomNavigationMenuView.setIconTintList(i6.c(i7));
        } else {
            bottomNavigationMenuView.setIconTintList(bottomNavigationMenuView.e(16842808));
        }
        setItemIconSize(i6.f(R$styleable.H, getResources().getDimensionPixelSize(R$dimen.design_bottom_navigation_icon_size)));
        if (i6.s(i4)) {
            setItemTextAppearanceInactive(i6.n(i4, 0));
        }
        if (i6.s(i5)) {
            setItemTextAppearanceActive(i6.n(i5, 0));
        }
        int i8 = R$styleable.L;
        if (i6.s(i8)) {
            setItemTextColor(i6.c(i8));
        }
        int i9 = R$styleable.E;
        if (i6.s(i9)) {
            ViewCompat.z0(this, (float) i6.f(i9, 0));
        }
        setLabelVisibilityMode(i6.l(R$styleable.M, -1));
        setItemHorizontalTranslationEnabled(i6.a(R$styleable.G, true));
        bottomNavigationMenuView.setItemBackgroundRes(i6.n(R$styleable.F, 0));
        int i10 = R$styleable.N;
        if (i6.s(i10)) {
            c(i6.n(i10, 0));
        }
        i6.w();
        addView(bottomNavigationMenuView, layoutParams);
        bottomNavigationMenu.V(new MenuBuilder.Callback() {
            public boolean a(MenuBuilder menuBuilder, MenuItem menuItem) {
                OnNavigationItemReselectedListener unused = BottomNavigationView.this.getClass();
                OnNavigationItemSelectedListener unused2 = BottomNavigationView.this.getClass();
                return false;
            }

            public void b(MenuBuilder menuBuilder) {
            }
        });
    }

    private MenuInflater getMenuInflater() {
        if (this.f29591e == null) {
            this.f29591e = new SupportMenuInflater(getContext());
        }
        return this.f29591e;
    }

    public void c(int i2) {
        this.f29590d.m(true);
        getMenuInflater().inflate(i2, this.f29588b);
        this.f29590d.m(false);
        this.f29590d.h(true);
    }

    public Drawable getItemBackground() {
        return this.f29589c.getItemBackground();
    }

    @Deprecated
    public int getItemBackgroundResource() {
        return this.f29589c.getItemBackgroundRes();
    }

    public int getItemIconSize() {
        return this.f29589c.getItemIconSize();
    }

    public ColorStateList getItemIconTintList() {
        return this.f29589c.getIconTintList();
    }

    public int getItemTextAppearanceActive() {
        return this.f29589c.getItemTextAppearanceActive();
    }

    public int getItemTextAppearanceInactive() {
        return this.f29589c.getItemTextAppearanceInactive();
    }

    public ColorStateList getItemTextColor() {
        return this.f29589c.getItemTextColor();
    }

    public int getLabelVisibilityMode() {
        return this.f29589c.getLabelVisibilityMode();
    }

    public int getMaxItemCount() {
        return 5;
    }

    public Menu getMenu() {
        return this.f29588b;
    }

    public int getSelectedItemId() {
        return this.f29589c.getSelectedItemId();
    }

    /* access modifiers changed from: protected */
    public void onRestoreInstanceState(Parcelable parcelable) {
        if (!(parcelable instanceof SavedState)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.b());
        this.f29588b.S(savedState.f29593d);
    }

    /* access modifiers changed from: protected */
    public Parcelable onSaveInstanceState() {
        SavedState savedState = new SavedState(super.onSaveInstanceState());
        Bundle bundle = new Bundle();
        savedState.f29593d = bundle;
        this.f29588b.U(bundle);
        return savedState;
    }

    public void setItemBackground(Drawable drawable) {
        this.f29589c.setItemBackground(drawable);
    }

    public void setItemBackgroundResource(int i2) {
        this.f29589c.setItemBackgroundRes(i2);
    }

    public void setItemHorizontalTranslationEnabled(boolean z2) {
        if (this.f29589c.f() != z2) {
            this.f29589c.setItemHorizontalTranslationEnabled(z2);
            this.f29590d.h(false);
        }
    }

    public void setItemIconSize(int i2) {
        this.f29589c.setItemIconSize(i2);
    }

    public void setItemIconSizeRes(int i2) {
        setItemIconSize(getResources().getDimensionPixelSize(i2));
    }

    public void setItemIconTintList(ColorStateList colorStateList) {
        this.f29589c.setIconTintList(colorStateList);
    }

    public void setItemTextAppearanceActive(int i2) {
        this.f29589c.setItemTextAppearanceActive(i2);
    }

    public void setItemTextAppearanceInactive(int i2) {
        this.f29589c.setItemTextAppearanceInactive(i2);
    }

    public void setItemTextColor(ColorStateList colorStateList) {
        this.f29589c.setItemTextColor(colorStateList);
    }

    public void setLabelVisibilityMode(int i2) {
        if (this.f29589c.getLabelVisibilityMode() != i2) {
            this.f29589c.setLabelVisibilityMode(i2);
            this.f29590d.h(false);
        }
    }

    public void setOnNavigationItemReselectedListener(OnNavigationItemReselectedListener onNavigationItemReselectedListener) {
    }

    public void setOnNavigationItemSelectedListener(OnNavigationItemSelectedListener onNavigationItemSelectedListener) {
    }

    public void setSelectedItemId(int i2) {
        MenuItem findItem = this.f29588b.findItem(i2);
        if (findItem != null && !this.f29588b.O(findItem, this.f29590d, 0)) {
            findItem.setChecked(true);
        }
    }
}
