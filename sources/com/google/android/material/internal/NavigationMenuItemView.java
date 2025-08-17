package com.google.android.material.internal;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.StateListDrawable;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.widget.CheckedTextView;
import android.widget.FrameLayout;
import androidx.appcompat.R$attr;
import androidx.appcompat.view.menu.MenuItemImpl;
import androidx.appcompat.view.menu.MenuView;
import androidx.appcompat.widget.LinearLayoutCompat;
import androidx.appcompat.widget.TooltipCompat;
import androidx.core.content.res.ResourcesCompat;
import androidx.core.graphics.drawable.DrawableCompat;
import androidx.core.view.AccessibilityDelegateCompat;
import androidx.core.view.ViewCompat;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import androidx.core.widget.TextViewCompat;
import com.google.android.material.R$dimen;
import com.google.android.material.R$drawable;
import com.google.android.material.R$id;
import com.google.android.material.R$layout;

public class NavigationMenuItemView extends ForegroundLinearLayout implements MenuView.ItemView {
    private static final int[] G = {16842912};
    private FrameLayout A;
    private MenuItemImpl B;
    private ColorStateList C;
    private boolean D;
    private Drawable E;
    private final AccessibilityDelegateCompat F;

    /* renamed from: w  reason: collision with root package name */
    private final int f29868w;

    /* renamed from: x  reason: collision with root package name */
    private boolean f29869x;

    /* renamed from: y  reason: collision with root package name */
    boolean f29870y;

    /* renamed from: z  reason: collision with root package name */
    private final CheckedTextView f29871z;

    public NavigationMenuItemView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    private StateListDrawable A() {
        TypedValue typedValue = new TypedValue();
        if (!getContext().getTheme().resolveAttribute(R$attr.f112w, typedValue, true)) {
            return null;
        }
        StateListDrawable stateListDrawable = new StateListDrawable();
        stateListDrawable.addState(G, new ColorDrawable(typedValue.data));
        stateListDrawable.addState(ViewGroup.EMPTY_STATE_SET, new ColorDrawable(0));
        return stateListDrawable;
    }

    private boolean C() {
        if (this.B.getTitle() == null && this.B.getIcon() == null && this.B.getActionView() != null) {
            return true;
        }
        return false;
    }

    private void setActionView(View view) {
        if (view != null) {
            if (this.A == null) {
                this.A = (FrameLayout) ((ViewStub) findViewById(R$id.design_menu_item_action_area_stub)).inflate();
            }
            this.A.removeAllViews();
            this.A.addView(view);
        }
    }

    private void z() {
        if (C()) {
            this.f29871z.setVisibility(8);
            FrameLayout frameLayout = this.A;
            if (frameLayout != null) {
                LinearLayoutCompat.LayoutParams layoutParams = (LinearLayoutCompat.LayoutParams) frameLayout.getLayoutParams();
                layoutParams.width = -1;
                this.A.setLayoutParams(layoutParams);
                return;
            }
            return;
        }
        this.f29871z.setVisibility(0);
        FrameLayout frameLayout2 = this.A;
        if (frameLayout2 != null) {
            LinearLayoutCompat.LayoutParams layoutParams2 = (LinearLayoutCompat.LayoutParams) frameLayout2.getLayoutParams();
            layoutParams2.width = -2;
            this.A.setLayoutParams(layoutParams2);
        }
    }

    public void B() {
        FrameLayout frameLayout = this.A;
        if (frameLayout != null) {
            frameLayout.removeAllViews();
        }
        this.f29871z.setCompoundDrawables((Drawable) null, (Drawable) null, (Drawable) null, (Drawable) null);
    }

    public void c(MenuItemImpl menuItemImpl, int i2) {
        int i3;
        this.B = menuItemImpl;
        if (menuItemImpl.isVisible()) {
            i3 = 0;
        } else {
            i3 = 8;
        }
        setVisibility(i3);
        if (getBackground() == null) {
            ViewCompat.v0(this, A());
        }
        setCheckable(menuItemImpl.isCheckable());
        setChecked(menuItemImpl.isChecked());
        setEnabled(menuItemImpl.isEnabled());
        setTitle(menuItemImpl.getTitle());
        setIcon(menuItemImpl.getIcon());
        setActionView(menuItemImpl.getActionView());
        setContentDescription(menuItemImpl.getContentDescription());
        TooltipCompat.a(this, menuItemImpl.getTooltipText());
        z();
    }

    public boolean d() {
        return false;
    }

    public MenuItemImpl getItemData() {
        return this.B;
    }

    /* access modifiers changed from: protected */
    public int[] onCreateDrawableState(int i2) {
        int[] onCreateDrawableState = super.onCreateDrawableState(i2 + 1);
        MenuItemImpl menuItemImpl = this.B;
        if (menuItemImpl != null && menuItemImpl.isCheckable() && this.B.isChecked()) {
            View.mergeDrawableStates(onCreateDrawableState, G);
        }
        return onCreateDrawableState;
    }

    public void setCheckable(boolean z2) {
        refreshDrawableState();
        if (this.f29870y != z2) {
            this.f29870y = z2;
            this.F.sendAccessibilityEvent(this.f29871z, 2048);
        }
    }

    public void setChecked(boolean z2) {
        refreshDrawableState();
        this.f29871z.setChecked(z2);
    }

    public void setHorizontalPadding(int i2) {
        setPadding(i2, 0, i2, 0);
    }

    public void setIcon(Drawable drawable) {
        if (drawable != null) {
            if (this.D) {
                Drawable.ConstantState constantState = drawable.getConstantState();
                if (constantState != null) {
                    drawable = constantState.newDrawable();
                }
                drawable = DrawableCompat.r(drawable).mutate();
                DrawableCompat.o(drawable, this.C);
            }
            int i2 = this.f29868w;
            drawable.setBounds(0, 0, i2, i2);
        } else if (this.f29869x) {
            if (this.E == null) {
                Drawable e2 = ResourcesCompat.e(getResources(), R$drawable.navigation_empty_icon, getContext().getTheme());
                this.E = e2;
                if (e2 != null) {
                    int i3 = this.f29868w;
                    e2.setBounds(0, 0, i3, i3);
                }
            }
            drawable = this.E;
        }
        TextViewCompat.j(this.f29871z, drawable, (Drawable) null, (Drawable) null, (Drawable) null);
    }

    public void setIconPadding(int i2) {
        this.f29871z.setCompoundDrawablePadding(i2);
    }

    /* access modifiers changed from: package-private */
    public void setIconTintList(ColorStateList colorStateList) {
        boolean z2;
        this.C = colorStateList;
        if (colorStateList != null) {
            z2 = true;
        } else {
            z2 = false;
        }
        this.D = z2;
        MenuItemImpl menuItemImpl = this.B;
        if (menuItemImpl != null) {
            setIcon(menuItemImpl.getIcon());
        }
    }

    public void setNeedsEmptyIcon(boolean z2) {
        this.f29869x = z2;
    }

    public void setTextAppearance(int i2) {
        TextViewCompat.o(this.f29871z, i2);
    }

    public void setTextColor(ColorStateList colorStateList) {
        this.f29871z.setTextColor(colorStateList);
    }

    public void setTitle(CharSequence charSequence) {
        this.f29871z.setText(charSequence);
    }

    public NavigationMenuItemView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        AnonymousClass1 r4 = new AccessibilityDelegateCompat() {
            public void onInitializeAccessibilityNodeInfo(View view, AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
                super.onInitializeAccessibilityNodeInfo(view, accessibilityNodeInfoCompat);
                accessibilityNodeInfoCompat.a0(NavigationMenuItemView.this.f29870y);
            }
        };
        this.F = r4;
        setOrientation(0);
        LayoutInflater.from(context).inflate(R$layout.design_navigation_menu_item, this, true);
        this.f29868w = context.getResources().getDimensionPixelSize(R$dimen.design_navigation_icon_size);
        CheckedTextView checkedTextView = (CheckedTextView) findViewById(R$id.design_menu_item_text);
        this.f29871z = checkedTextView;
        checkedTextView.setDuplicateParentStateEnabled(true);
        ViewCompat.r0(checkedTextView, r4);
    }
}
