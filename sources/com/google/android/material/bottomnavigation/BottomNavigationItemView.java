package com.google.android.material.bottomnavigation;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.view.menu.MenuItemImpl;
import androidx.appcompat.view.menu.MenuView;
import androidx.appcompat.widget.TooltipCompat;
import androidx.core.content.ContextCompat;
import androidx.core.graphics.drawable.DrawableCompat;
import androidx.core.view.PointerIconCompat;
import androidx.core.view.ViewCompat;
import androidx.core.widget.TextViewCompat;
import com.google.android.material.R$dimen;
import com.google.android.material.R$drawable;
import com.google.android.material.R$id;
import com.google.android.material.R$layout;

public class BottomNavigationItemView extends FrameLayout implements MenuView.ItemView {

    /* renamed from: n  reason: collision with root package name */
    private static final int[] f29544n = {16842912};

    /* renamed from: b  reason: collision with root package name */
    private final int f29545b;

    /* renamed from: c  reason: collision with root package name */
    private float f29546c;

    /* renamed from: d  reason: collision with root package name */
    private float f29547d;

    /* renamed from: e  reason: collision with root package name */
    private float f29548e;

    /* renamed from: f  reason: collision with root package name */
    private int f29549f;

    /* renamed from: g  reason: collision with root package name */
    private boolean f29550g;

    /* renamed from: h  reason: collision with root package name */
    private ImageView f29551h;

    /* renamed from: i  reason: collision with root package name */
    private final TextView f29552i;

    /* renamed from: j  reason: collision with root package name */
    private final TextView f29553j;

    /* renamed from: k  reason: collision with root package name */
    private int f29554k;

    /* renamed from: l  reason: collision with root package name */
    private MenuItemImpl f29555l;

    /* renamed from: m  reason: collision with root package name */
    private ColorStateList f29556m;

    public BottomNavigationItemView(Context context) {
        this(context, (AttributeSet) null);
    }

    private void a(float f2, float f3) {
        this.f29546c = f2 - f3;
        this.f29547d = (f3 * 1.0f) / f2;
        this.f29548e = (f2 * 1.0f) / f3;
    }

    private void b(View view, int i2, int i3) {
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) view.getLayoutParams();
        layoutParams.topMargin = i2;
        layoutParams.gravity = i3;
        view.setLayoutParams(layoutParams);
    }

    private void e(View view, float f2, float f3, int i2) {
        view.setScaleX(f2);
        view.setScaleY(f3);
        view.setVisibility(i2);
    }

    public void c(MenuItemImpl menuItemImpl, int i2) {
        int i3;
        this.f29555l = menuItemImpl;
        setCheckable(menuItemImpl.isCheckable());
        setChecked(menuItemImpl.isChecked());
        setEnabled(menuItemImpl.isEnabled());
        setIcon(menuItemImpl.getIcon());
        setTitle(menuItemImpl.getTitle());
        setId(menuItemImpl.getItemId());
        if (!TextUtils.isEmpty(menuItemImpl.getContentDescription())) {
            setContentDescription(menuItemImpl.getContentDescription());
        }
        TooltipCompat.a(this, menuItemImpl.getTooltipText());
        if (menuItemImpl.isVisible()) {
            i3 = 0;
        } else {
            i3 = 8;
        }
        setVisibility(i3);
    }

    public boolean d() {
        return false;
    }

    public MenuItemImpl getItemData() {
        return this.f29555l;
    }

    public int getItemPosition() {
        return this.f29554k;
    }

    public int[] onCreateDrawableState(int i2) {
        int[] onCreateDrawableState = super.onCreateDrawableState(i2 + 1);
        MenuItemImpl menuItemImpl = this.f29555l;
        if (menuItemImpl != null && menuItemImpl.isCheckable() && this.f29555l.isChecked()) {
            View.mergeDrawableStates(onCreateDrawableState, f29544n);
        }
        return onCreateDrawableState;
    }

    public void setCheckable(boolean z2) {
        refreshDrawableState();
    }

    public void setChecked(boolean z2) {
        TextView textView = this.f29553j;
        textView.setPivotX((float) (textView.getWidth() / 2));
        TextView textView2 = this.f29553j;
        textView2.setPivotY((float) textView2.getBaseline());
        TextView textView3 = this.f29552i;
        textView3.setPivotX((float) (textView3.getWidth() / 2));
        TextView textView4 = this.f29552i;
        textView4.setPivotY((float) textView4.getBaseline());
        int i2 = this.f29549f;
        if (i2 != -1) {
            if (i2 == 0) {
                if (z2) {
                    b(this.f29551h, this.f29545b, 49);
                    e(this.f29553j, 1.0f, 1.0f, 0);
                } else {
                    b(this.f29551h, this.f29545b, 17);
                    e(this.f29553j, 0.5f, 0.5f, 4);
                }
                this.f29552i.setVisibility(4);
            } else if (i2 != 1) {
                if (i2 == 2) {
                    b(this.f29551h, this.f29545b, 17);
                    this.f29553j.setVisibility(8);
                    this.f29552i.setVisibility(8);
                }
            } else if (z2) {
                b(this.f29551h, (int) (((float) this.f29545b) + this.f29546c), 49);
                e(this.f29553j, 1.0f, 1.0f, 0);
                TextView textView5 = this.f29552i;
                float f2 = this.f29547d;
                e(textView5, f2, f2, 4);
            } else {
                b(this.f29551h, this.f29545b, 49);
                TextView textView6 = this.f29553j;
                float f3 = this.f29548e;
                e(textView6, f3, f3, 4);
                e(this.f29552i, 1.0f, 1.0f, 0);
            }
        } else if (this.f29550g) {
            if (z2) {
                b(this.f29551h, this.f29545b, 49);
                e(this.f29553j, 1.0f, 1.0f, 0);
            } else {
                b(this.f29551h, this.f29545b, 17);
                e(this.f29553j, 0.5f, 0.5f, 4);
            }
            this.f29552i.setVisibility(4);
        } else if (z2) {
            b(this.f29551h, (int) (((float) this.f29545b) + this.f29546c), 49);
            e(this.f29553j, 1.0f, 1.0f, 0);
            TextView textView7 = this.f29552i;
            float f4 = this.f29547d;
            e(textView7, f4, f4, 4);
        } else {
            b(this.f29551h, this.f29545b, 49);
            TextView textView8 = this.f29553j;
            float f5 = this.f29548e;
            e(textView8, f5, f5, 4);
            e(this.f29552i, 1.0f, 1.0f, 0);
        }
        refreshDrawableState();
        setSelected(z2);
    }

    public void setEnabled(boolean z2) {
        super.setEnabled(z2);
        this.f29552i.setEnabled(z2);
        this.f29553j.setEnabled(z2);
        this.f29551h.setEnabled(z2);
        if (z2) {
            ViewCompat.I0(this, PointerIconCompat.b(getContext(), 1002));
        } else {
            ViewCompat.I0(this, (PointerIconCompat) null);
        }
    }

    public void setIcon(Drawable drawable) {
        if (drawable != null) {
            Drawable.ConstantState constantState = drawable.getConstantState();
            if (constantState != null) {
                drawable = constantState.newDrawable();
            }
            drawable = DrawableCompat.r(drawable).mutate();
            DrawableCompat.o(drawable, this.f29556m);
        }
        this.f29551h.setImageDrawable(drawable);
    }

    public void setIconSize(int i2) {
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.f29551h.getLayoutParams();
        layoutParams.width = i2;
        layoutParams.height = i2;
        this.f29551h.setLayoutParams(layoutParams);
    }

    public void setIconTintList(ColorStateList colorStateList) {
        this.f29556m = colorStateList;
        MenuItemImpl menuItemImpl = this.f29555l;
        if (menuItemImpl != null) {
            setIcon(menuItemImpl.getIcon());
        }
    }

    public void setItemBackground(int i2) {
        setItemBackground(i2 == 0 ? null : ContextCompat.getDrawable(getContext(), i2));
    }

    public void setItemPosition(int i2) {
        this.f29554k = i2;
    }

    public void setLabelVisibilityMode(int i2) {
        boolean z2;
        if (this.f29549f != i2) {
            this.f29549f = i2;
            MenuItemImpl menuItemImpl = this.f29555l;
            if (menuItemImpl != null) {
                z2 = true;
            } else {
                z2 = false;
            }
            if (z2) {
                setChecked(menuItemImpl.isChecked());
            }
        }
    }

    public void setShifting(boolean z2) {
        boolean z3;
        if (this.f29550g != z2) {
            this.f29550g = z2;
            MenuItemImpl menuItemImpl = this.f29555l;
            if (menuItemImpl != null) {
                z3 = true;
            } else {
                z3 = false;
            }
            if (z3) {
                setChecked(menuItemImpl.isChecked());
            }
        }
    }

    public void setTextAppearanceActive(int i2) {
        TextViewCompat.o(this.f29553j, i2);
        a(this.f29552i.getTextSize(), this.f29553j.getTextSize());
    }

    public void setTextAppearanceInactive(int i2) {
        TextViewCompat.o(this.f29552i, i2);
        a(this.f29552i.getTextSize(), this.f29553j.getTextSize());
    }

    public void setTextColor(ColorStateList colorStateList) {
        if (colorStateList != null) {
            this.f29552i.setTextColor(colorStateList);
            this.f29553j.setTextColor(colorStateList);
        }
    }

    public void setTitle(CharSequence charSequence) {
        this.f29552i.setText(charSequence);
        this.f29553j.setText(charSequence);
        MenuItemImpl menuItemImpl = this.f29555l;
        if (menuItemImpl == null || TextUtils.isEmpty(menuItemImpl.getContentDescription())) {
            setContentDescription(charSequence);
        }
    }

    public BottomNavigationItemView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public BottomNavigationItemView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.f29554k = -1;
        Resources resources = getResources();
        LayoutInflater.from(context).inflate(R$layout.design_bottom_navigation_item, this, true);
        setBackgroundResource(R$drawable.design_bottom_navigation_item_background);
        this.f29545b = resources.getDimensionPixelSize(R$dimen.design_bottom_navigation_margin);
        this.f29551h = (ImageView) findViewById(R$id.f29320e);
        TextView textView = (TextView) findViewById(R$id.smallLabel);
        this.f29552i = textView;
        TextView textView2 = (TextView) findViewById(R$id.largeLabel);
        this.f29553j = textView2;
        ViewCompat.C0(textView, 2);
        ViewCompat.C0(textView2, 2);
        setFocusable(true);
        a(textView.getTextSize(), textView2.getTextSize());
    }

    public void setItemBackground(Drawable drawable) {
        ViewCompat.v0(this, drawable);
    }
}
