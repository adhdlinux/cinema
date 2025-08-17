package com.google.android.material.bottomnavigation;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import androidx.appcompat.R$attr;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.appcompat.view.menu.MenuBuilder;
import androidx.appcompat.view.menu.MenuItemImpl;
import androidx.appcompat.view.menu.MenuView;
import androidx.core.util.Pools$Pool;
import androidx.core.util.Pools$SynchronizedPool;
import androidx.core.view.ViewCompat;
import androidx.interpolator.view.animation.FastOutSlowInInterpolator;
import androidx.transition.AutoTransition;
import androidx.transition.TransitionManager;
import androidx.transition.TransitionSet;
import com.google.android.material.R$dimen;
import com.google.android.material.internal.TextScale;

public class BottomNavigationMenuView extends ViewGroup implements MenuView {
    private static final int[] A = {-16842910};

    /* renamed from: z  reason: collision with root package name */
    private static final int[] f29557z = {16842912};

    /* renamed from: b  reason: collision with root package name */
    private final TransitionSet f29558b;

    /* renamed from: c  reason: collision with root package name */
    private final int f29559c;

    /* renamed from: d  reason: collision with root package name */
    private final int f29560d;

    /* renamed from: e  reason: collision with root package name */
    private final int f29561e;

    /* renamed from: f  reason: collision with root package name */
    private final int f29562f;

    /* renamed from: g  reason: collision with root package name */
    private final int f29563g;

    /* renamed from: h  reason: collision with root package name */
    private final View.OnClickListener f29564h;

    /* renamed from: i  reason: collision with root package name */
    private final Pools$Pool<BottomNavigationItemView> f29565i;

    /* renamed from: j  reason: collision with root package name */
    private boolean f29566j;

    /* renamed from: k  reason: collision with root package name */
    private int f29567k;

    /* renamed from: l  reason: collision with root package name */
    private BottomNavigationItemView[] f29568l;

    /* renamed from: m  reason: collision with root package name */
    private int f29569m;

    /* renamed from: n  reason: collision with root package name */
    private int f29570n;

    /* renamed from: o  reason: collision with root package name */
    private ColorStateList f29571o;

    /* renamed from: p  reason: collision with root package name */
    private int f29572p;

    /* renamed from: q  reason: collision with root package name */
    private ColorStateList f29573q;

    /* renamed from: r  reason: collision with root package name */
    private final ColorStateList f29574r;

    /* renamed from: s  reason: collision with root package name */
    private int f29575s;

    /* renamed from: t  reason: collision with root package name */
    private int f29576t;

    /* renamed from: u  reason: collision with root package name */
    private Drawable f29577u;

    /* renamed from: v  reason: collision with root package name */
    private int f29578v;

    /* renamed from: w  reason: collision with root package name */
    private int[] f29579w;
    /* access modifiers changed from: private */

    /* renamed from: x  reason: collision with root package name */
    public BottomNavigationPresenter f29580x;
    /* access modifiers changed from: private */

    /* renamed from: y  reason: collision with root package name */
    public MenuBuilder f29581y;

    public BottomNavigationMenuView(Context context) {
        this(context, (AttributeSet) null);
    }

    private boolean g(int i2, int i3) {
        if (i2 == -1) {
            if (i3 > 3) {
                return true;
            }
        } else if (i2 == 0) {
            return true;
        }
        return false;
    }

    private BottomNavigationItemView getNewItem() {
        BottomNavigationItemView acquire = this.f29565i.acquire();
        if (acquire == null) {
            return new BottomNavigationItemView(getContext());
        }
        return acquire;
    }

    public void a(MenuBuilder menuBuilder) {
        this.f29581y = menuBuilder;
    }

    public void d() {
        removeAllViews();
        BottomNavigationItemView[] bottomNavigationItemViewArr = this.f29568l;
        if (bottomNavigationItemViewArr != null) {
            for (BottomNavigationItemView bottomNavigationItemView : bottomNavigationItemViewArr) {
                if (bottomNavigationItemView != null) {
                    this.f29565i.release(bottomNavigationItemView);
                }
            }
        }
        if (this.f29581y.size() == 0) {
            this.f29569m = 0;
            this.f29570n = 0;
            this.f29568l = null;
            return;
        }
        this.f29568l = new BottomNavigationItemView[this.f29581y.size()];
        boolean g2 = g(this.f29567k, this.f29581y.G().size());
        for (int i2 = 0; i2 < this.f29581y.size(); i2++) {
            this.f29580x.m(true);
            this.f29581y.getItem(i2).setCheckable(true);
            this.f29580x.m(false);
            BottomNavigationItemView newItem = getNewItem();
            this.f29568l[i2] = newItem;
            newItem.setIconTintList(this.f29571o);
            newItem.setIconSize(this.f29572p);
            newItem.setTextColor(this.f29574r);
            newItem.setTextAppearanceInactive(this.f29575s);
            newItem.setTextAppearanceActive(this.f29576t);
            newItem.setTextColor(this.f29573q);
            Drawable drawable = this.f29577u;
            if (drawable != null) {
                newItem.setItemBackground(drawable);
            } else {
                newItem.setItemBackground(this.f29578v);
            }
            newItem.setShifting(g2);
            newItem.setLabelVisibilityMode(this.f29567k);
            newItem.c((MenuItemImpl) this.f29581y.getItem(i2), 0);
            newItem.setItemPosition(i2);
            newItem.setOnClickListener(this.f29564h);
            addView(newItem);
        }
        int min = Math.min(this.f29581y.size() - 1, this.f29570n);
        this.f29570n = min;
        this.f29581y.getItem(min).setChecked(true);
    }

    public ColorStateList e(int i2) {
        TypedValue typedValue = new TypedValue();
        if (!getContext().getTheme().resolveAttribute(i2, typedValue, true)) {
            return null;
        }
        ColorStateList a2 = AppCompatResources.a(getContext(), typedValue.resourceId);
        if (!getContext().getTheme().resolveAttribute(R$attr.f114y, typedValue, true)) {
            return null;
        }
        int i3 = typedValue.data;
        int defaultColor = a2.getDefaultColor();
        int[] iArr = A;
        return new ColorStateList(new int[][]{iArr, f29557z, ViewGroup.EMPTY_STATE_SET}, new int[]{a2.getColorForState(iArr, defaultColor), i3, defaultColor});
    }

    public boolean f() {
        return this.f29566j;
    }

    public ColorStateList getIconTintList() {
        return this.f29571o;
    }

    public Drawable getItemBackground() {
        BottomNavigationItemView[] bottomNavigationItemViewArr = this.f29568l;
        if (bottomNavigationItemViewArr == null || bottomNavigationItemViewArr.length <= 0) {
            return this.f29577u;
        }
        return bottomNavigationItemViewArr[0].getBackground();
    }

    @Deprecated
    public int getItemBackgroundRes() {
        return this.f29578v;
    }

    public int getItemIconSize() {
        return this.f29572p;
    }

    public int getItemTextAppearanceActive() {
        return this.f29576t;
    }

    public int getItemTextAppearanceInactive() {
        return this.f29575s;
    }

    public ColorStateList getItemTextColor() {
        return this.f29573q;
    }

    public int getLabelVisibilityMode() {
        return this.f29567k;
    }

    public int getSelectedItemId() {
        return this.f29569m;
    }

    public int getWindowAnimations() {
        return 0;
    }

    /* access modifiers changed from: package-private */
    public void h(int i2) {
        int size = this.f29581y.size();
        for (int i3 = 0; i3 < size; i3++) {
            MenuItem item = this.f29581y.getItem(i3);
            if (i2 == item.getItemId()) {
                this.f29569m = i2;
                this.f29570n = i3;
                item.setChecked(true);
                return;
            }
        }
    }

    public void i() {
        MenuBuilder menuBuilder = this.f29581y;
        if (menuBuilder != null && this.f29568l != null) {
            int size = menuBuilder.size();
            if (size != this.f29568l.length) {
                d();
                return;
            }
            int i2 = this.f29569m;
            for (int i3 = 0; i3 < size; i3++) {
                MenuItem item = this.f29581y.getItem(i3);
                if (item.isChecked()) {
                    this.f29569m = item.getItemId();
                    this.f29570n = i3;
                }
            }
            if (i2 != this.f29569m) {
                TransitionManager.a(this, this.f29558b);
            }
            boolean g2 = g(this.f29567k, this.f29581y.G().size());
            for (int i4 = 0; i4 < size; i4++) {
                this.f29580x.m(true);
                this.f29568l[i4].setLabelVisibilityMode(this.f29567k);
                this.f29568l[i4].setShifting(g2);
                this.f29568l[i4].c((MenuItemImpl) this.f29581y.getItem(i4), 0);
                this.f29580x.m(false);
            }
        }
    }

    /* access modifiers changed from: protected */
    public void onLayout(boolean z2, int i2, int i3, int i4, int i5) {
        int childCount = getChildCount();
        int i6 = i4 - i2;
        int i7 = i5 - i3;
        int i8 = 0;
        for (int i9 = 0; i9 < childCount; i9++) {
            View childAt = getChildAt(i9);
            if (childAt.getVisibility() != 8) {
                if (ViewCompat.D(this) == 1) {
                    int i10 = i6 - i8;
                    childAt.layout(i10 - childAt.getMeasuredWidth(), 0, i10, i7);
                } else {
                    childAt.layout(i8, 0, childAt.getMeasuredWidth() + i8, i7);
                }
                i8 += childAt.getMeasuredWidth();
            }
        }
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i2, int i3) {
        int i4;
        int i5;
        int size = View.MeasureSpec.getSize(i2);
        int size2 = this.f29581y.G().size();
        int childCount = getChildCount();
        int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(this.f29563g, 1073741824);
        int i6 = 1;
        if (!g(this.f29567k, size2) || !this.f29566j) {
            if (size2 != 0) {
                i6 = size2;
            }
            int min = Math.min(size / i6, this.f29561e);
            int i7 = size - (size2 * min);
            for (int i8 = 0; i8 < childCount; i8++) {
                if (getChildAt(i8).getVisibility() != 8) {
                    int[] iArr = this.f29579w;
                    iArr[i8] = min;
                    if (i7 > 0) {
                        iArr[i8] = min + 1;
                        i7--;
                    }
                } else {
                    this.f29579w[i8] = 0;
                }
            }
        } else {
            View childAt = getChildAt(this.f29570n);
            int i9 = this.f29562f;
            if (childAt.getVisibility() != 8) {
                childAt.measure(View.MeasureSpec.makeMeasureSpec(this.f29561e, Integer.MIN_VALUE), makeMeasureSpec);
                i9 = Math.max(i9, childAt.getMeasuredWidth());
            }
            if (childAt.getVisibility() != 8) {
                i4 = 1;
            } else {
                i4 = 0;
            }
            int i10 = size2 - i4;
            int min2 = Math.min(size - (this.f29560d * i10), Math.min(i9, this.f29561e));
            int i11 = size - min2;
            if (i10 != 0) {
                i6 = i10;
            }
            int min3 = Math.min(i11 / i6, this.f29559c);
            int i12 = i11 - (i10 * min3);
            for (int i13 = 0; i13 < childCount; i13++) {
                if (getChildAt(i13).getVisibility() != 8) {
                    int[] iArr2 = this.f29579w;
                    if (i13 == this.f29570n) {
                        i5 = min2;
                    } else {
                        i5 = min3;
                    }
                    iArr2[i13] = i5;
                    if (i12 > 0) {
                        iArr2[i13] = i5 + 1;
                        i12--;
                    }
                } else {
                    this.f29579w[i13] = 0;
                }
            }
        }
        int i14 = 0;
        for (int i15 = 0; i15 < childCount; i15++) {
            View childAt2 = getChildAt(i15);
            if (childAt2.getVisibility() != 8) {
                childAt2.measure(View.MeasureSpec.makeMeasureSpec(this.f29579w[i15], 1073741824), makeMeasureSpec);
                childAt2.getLayoutParams().width = childAt2.getMeasuredWidth();
                i14 += childAt2.getMeasuredWidth();
            }
        }
        setMeasuredDimension(View.resolveSizeAndState(i14, View.MeasureSpec.makeMeasureSpec(i14, 1073741824), 0), View.resolveSizeAndState(this.f29563g, makeMeasureSpec, 0));
    }

    public void setIconTintList(ColorStateList colorStateList) {
        this.f29571o = colorStateList;
        BottomNavigationItemView[] bottomNavigationItemViewArr = this.f29568l;
        if (bottomNavigationItemViewArr != null) {
            for (BottomNavigationItemView iconTintList : bottomNavigationItemViewArr) {
                iconTintList.setIconTintList(colorStateList);
            }
        }
    }

    public void setItemBackground(Drawable drawable) {
        this.f29577u = drawable;
        BottomNavigationItemView[] bottomNavigationItemViewArr = this.f29568l;
        if (bottomNavigationItemViewArr != null) {
            for (BottomNavigationItemView itemBackground : bottomNavigationItemViewArr) {
                itemBackground.setItemBackground(drawable);
            }
        }
    }

    public void setItemBackgroundRes(int i2) {
        this.f29578v = i2;
        BottomNavigationItemView[] bottomNavigationItemViewArr = this.f29568l;
        if (bottomNavigationItemViewArr != null) {
            for (BottomNavigationItemView itemBackground : bottomNavigationItemViewArr) {
                itemBackground.setItemBackground(i2);
            }
        }
    }

    public void setItemHorizontalTranslationEnabled(boolean z2) {
        this.f29566j = z2;
    }

    public void setItemIconSize(int i2) {
        this.f29572p = i2;
        BottomNavigationItemView[] bottomNavigationItemViewArr = this.f29568l;
        if (bottomNavigationItemViewArr != null) {
            for (BottomNavigationItemView iconSize : bottomNavigationItemViewArr) {
                iconSize.setIconSize(i2);
            }
        }
    }

    public void setItemTextAppearanceActive(int i2) {
        this.f29576t = i2;
        BottomNavigationItemView[] bottomNavigationItemViewArr = this.f29568l;
        if (bottomNavigationItemViewArr != null) {
            for (BottomNavigationItemView bottomNavigationItemView : bottomNavigationItemViewArr) {
                bottomNavigationItemView.setTextAppearanceActive(i2);
                ColorStateList colorStateList = this.f29573q;
                if (colorStateList != null) {
                    bottomNavigationItemView.setTextColor(colorStateList);
                }
            }
        }
    }

    public void setItemTextAppearanceInactive(int i2) {
        this.f29575s = i2;
        BottomNavigationItemView[] bottomNavigationItemViewArr = this.f29568l;
        if (bottomNavigationItemViewArr != null) {
            for (BottomNavigationItemView bottomNavigationItemView : bottomNavigationItemViewArr) {
                bottomNavigationItemView.setTextAppearanceInactive(i2);
                ColorStateList colorStateList = this.f29573q;
                if (colorStateList != null) {
                    bottomNavigationItemView.setTextColor(colorStateList);
                }
            }
        }
    }

    public void setItemTextColor(ColorStateList colorStateList) {
        this.f29573q = colorStateList;
        BottomNavigationItemView[] bottomNavigationItemViewArr = this.f29568l;
        if (bottomNavigationItemViewArr != null) {
            for (BottomNavigationItemView textColor : bottomNavigationItemViewArr) {
                textColor.setTextColor(colorStateList);
            }
        }
    }

    public void setLabelVisibilityMode(int i2) {
        this.f29567k = i2;
    }

    public void setPresenter(BottomNavigationPresenter bottomNavigationPresenter) {
        this.f29580x = bottomNavigationPresenter;
    }

    public BottomNavigationMenuView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f29565i = new Pools$SynchronizedPool(5);
        this.f29569m = 0;
        this.f29570n = 0;
        Resources resources = getResources();
        this.f29559c = resources.getDimensionPixelSize(R$dimen.design_bottom_navigation_item_max_width);
        this.f29560d = resources.getDimensionPixelSize(R$dimen.design_bottom_navigation_item_min_width);
        this.f29561e = resources.getDimensionPixelSize(R$dimen.design_bottom_navigation_active_item_max_width);
        this.f29562f = resources.getDimensionPixelSize(R$dimen.design_bottom_navigation_active_item_min_width);
        this.f29563g = resources.getDimensionPixelSize(R$dimen.design_bottom_navigation_height);
        this.f29574r = e(16842808);
        AutoTransition autoTransition = new AutoTransition();
        this.f29558b = autoTransition;
        autoTransition.k0(0);
        autoTransition.T(115);
        autoTransition.V(new FastOutSlowInInterpolator());
        autoTransition.d0(new TextScale());
        this.f29564h = new View.OnClickListener() {
            public void onClick(View view) {
                MenuItemImpl itemData = ((BottomNavigationItemView) view).getItemData();
                if (!BottomNavigationMenuView.this.f29581y.O(itemData, BottomNavigationMenuView.this.f29580x, 0)) {
                    itemData.setChecked(true);
                }
            }
        };
        this.f29579w = new int[5];
    }
}
