package com.google.android.material.button;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.AttributeSet;
import android.util.Log;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.appcompat.widget.AppCompatButton;
import androidx.core.graphics.drawable.DrawableCompat;
import androidx.core.view.ViewCompat;
import androidx.core.widget.TextViewCompat;
import com.google.android.material.R$attr;
import com.google.android.material.R$style;
import com.google.android.material.R$styleable;
import com.google.android.material.internal.ThemeEnforcement;
import com.google.android.material.internal.ViewUtils;
import com.google.android.material.resources.MaterialResources;

public class MaterialButton extends AppCompatButton {

    /* renamed from: e  reason: collision with root package name */
    private final MaterialButtonHelper f29637e;

    /* renamed from: f  reason: collision with root package name */
    private int f29638f;

    /* renamed from: g  reason: collision with root package name */
    private PorterDuff.Mode f29639g;

    /* renamed from: h  reason: collision with root package name */
    private ColorStateList f29640h;

    /* renamed from: i  reason: collision with root package name */
    private Drawable f29641i;

    /* renamed from: j  reason: collision with root package name */
    private int f29642j;

    /* renamed from: k  reason: collision with root package name */
    private int f29643k;

    /* renamed from: l  reason: collision with root package name */
    private int f29644l;

    public MaterialButton(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R$attr.materialButtonStyle);
    }

    private boolean a() {
        return ViewCompat.D(this) == 1;
    }

    private boolean b() {
        MaterialButtonHelper materialButtonHelper = this.f29637e;
        return materialButtonHelper != null && !materialButtonHelper.i();
    }

    private void c() {
        Drawable drawable = this.f29641i;
        if (drawable != null) {
            Drawable mutate = drawable.mutate();
            this.f29641i = mutate;
            DrawableCompat.o(mutate, this.f29640h);
            PorterDuff.Mode mode = this.f29639g;
            if (mode != null) {
                DrawableCompat.p(this.f29641i, mode);
            }
            int i2 = this.f29642j;
            if (i2 == 0) {
                i2 = this.f29641i.getIntrinsicWidth();
            }
            int i3 = this.f29642j;
            if (i3 == 0) {
                i3 = this.f29641i.getIntrinsicHeight();
            }
            Drawable drawable2 = this.f29641i;
            int i4 = this.f29643k;
            drawable2.setBounds(i4, 0, i2 + i4, i3);
        }
        TextViewCompat.j(this, this.f29641i, (Drawable) null, (Drawable) null, (Drawable) null);
    }

    public ColorStateList getBackgroundTintList() {
        return getSupportBackgroundTintList();
    }

    public PorterDuff.Mode getBackgroundTintMode() {
        return getSupportBackgroundTintMode();
    }

    public int getCornerRadius() {
        if (b()) {
            return this.f29637e.c();
        }
        return 0;
    }

    public Drawable getIcon() {
        return this.f29641i;
    }

    public int getIconGravity() {
        return this.f29644l;
    }

    public int getIconPadding() {
        return this.f29638f;
    }

    public int getIconSize() {
        return this.f29642j;
    }

    public ColorStateList getIconTint() {
        return this.f29640h;
    }

    public PorterDuff.Mode getIconTintMode() {
        return this.f29639g;
    }

    public ColorStateList getRippleColor() {
        if (b()) {
            return this.f29637e.d();
        }
        return null;
    }

    public ColorStateList getStrokeColor() {
        if (b()) {
            return this.f29637e.e();
        }
        return null;
    }

    public int getStrokeWidth() {
        if (b()) {
            return this.f29637e.f();
        }
        return 0;
    }

    public ColorStateList getSupportBackgroundTintList() {
        if (b()) {
            return this.f29637e.g();
        }
        return super.getSupportBackgroundTintList();
    }

    public PorterDuff.Mode getSupportBackgroundTintMode() {
        if (b()) {
            return this.f29637e.h();
        }
        return super.getSupportBackgroundTintMode();
    }

    /* access modifiers changed from: protected */
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
    }

    /* access modifiers changed from: protected */
    public void onLayout(boolean z2, int i2, int i3, int i4, int i5) {
        MaterialButtonHelper materialButtonHelper;
        super.onLayout(z2, i2, i3, i4, i5);
        if (Build.VERSION.SDK_INT == 21 && (materialButtonHelper = this.f29637e) != null) {
            materialButtonHelper.u(i5 - i3, i4 - i2);
        }
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i2, int i3) {
        super.onMeasure(i2, i3);
        if (this.f29641i != null && this.f29644l == 2) {
            int measureText = (int) getPaint().measureText(getText().toString());
            int i4 = this.f29642j;
            if (i4 == 0) {
                i4 = this.f29641i.getIntrinsicWidth();
            }
            int measuredWidth = (((((getMeasuredWidth() - measureText) - ViewCompat.H(this)) - i4) - this.f29638f) - ViewCompat.I(this)) / 2;
            if (a()) {
                measuredWidth = -measuredWidth;
            }
            if (this.f29643k != measuredWidth) {
                this.f29643k = measuredWidth;
                c();
            }
        }
    }

    public void setBackground(Drawable drawable) {
        setBackgroundDrawable(drawable);
    }

    public void setBackgroundColor(int i2) {
        if (b()) {
            this.f29637e.k(i2);
        } else {
            super.setBackgroundColor(i2);
        }
    }

    public void setBackgroundDrawable(Drawable drawable) {
        if (!b()) {
            super.setBackgroundDrawable(drawable);
        } else if (drawable != getBackground()) {
            Log.i("MaterialButton", "Setting a custom background is not supported.");
            this.f29637e.l();
            super.setBackgroundDrawable(drawable);
        } else {
            getBackground().setState(drawable.getState());
        }
    }

    public void setBackgroundResource(int i2) {
        Drawable drawable;
        if (i2 != 0) {
            drawable = AppCompatResources.b(getContext(), i2);
        } else {
            drawable = null;
        }
        setBackgroundDrawable(drawable);
    }

    public void setBackgroundTintList(ColorStateList colorStateList) {
        setSupportBackgroundTintList(colorStateList);
    }

    public void setBackgroundTintMode(PorterDuff.Mode mode) {
        setSupportBackgroundTintMode(mode);
    }

    public void setCornerRadius(int i2) {
        if (b()) {
            this.f29637e.m(i2);
        }
    }

    public void setCornerRadiusResource(int i2) {
        if (b()) {
            setCornerRadius(getResources().getDimensionPixelSize(i2));
        }
    }

    public void setIcon(Drawable drawable) {
        if (this.f29641i != drawable) {
            this.f29641i = drawable;
            c();
        }
    }

    public void setIconGravity(int i2) {
        this.f29644l = i2;
    }

    public void setIconPadding(int i2) {
        if (this.f29638f != i2) {
            this.f29638f = i2;
            setCompoundDrawablePadding(i2);
        }
    }

    public void setIconResource(int i2) {
        Drawable drawable;
        if (i2 != 0) {
            drawable = AppCompatResources.b(getContext(), i2);
        } else {
            drawable = null;
        }
        setIcon(drawable);
    }

    public void setIconSize(int i2) {
        if (i2 < 0) {
            throw new IllegalArgumentException("iconSize cannot be less than 0");
        } else if (this.f29642j != i2) {
            this.f29642j = i2;
            c();
        }
    }

    public void setIconTint(ColorStateList colorStateList) {
        if (this.f29640h != colorStateList) {
            this.f29640h = colorStateList;
            c();
        }
    }

    public void setIconTintMode(PorterDuff.Mode mode) {
        if (this.f29639g != mode) {
            this.f29639g = mode;
            c();
        }
    }

    public void setIconTintResource(int i2) {
        setIconTint(AppCompatResources.a(getContext(), i2));
    }

    /* access modifiers changed from: package-private */
    public void setInternalBackground(Drawable drawable) {
        super.setBackgroundDrawable(drawable);
    }

    public void setRippleColor(ColorStateList colorStateList) {
        if (b()) {
            this.f29637e.n(colorStateList);
        }
    }

    public void setRippleColorResource(int i2) {
        if (b()) {
            setRippleColor(AppCompatResources.a(getContext(), i2));
        }
    }

    public void setStrokeColor(ColorStateList colorStateList) {
        if (b()) {
            this.f29637e.o(colorStateList);
        }
    }

    public void setStrokeColorResource(int i2) {
        if (b()) {
            setStrokeColor(AppCompatResources.a(getContext(), i2));
        }
    }

    public void setStrokeWidth(int i2) {
        if (b()) {
            this.f29637e.p(i2);
        }
    }

    public void setStrokeWidthResource(int i2) {
        if (b()) {
            setStrokeWidth(getResources().getDimensionPixelSize(i2));
        }
    }

    public void setSupportBackgroundTintList(ColorStateList colorStateList) {
        if (b()) {
            this.f29637e.q(colorStateList);
        } else if (this.f29637e != null) {
            super.setSupportBackgroundTintList(colorStateList);
        }
    }

    public void setSupportBackgroundTintMode(PorterDuff.Mode mode) {
        if (b()) {
            this.f29637e.r(mode);
        } else if (this.f29637e != null) {
            super.setSupportBackgroundTintMode(mode);
        }
    }

    public MaterialButton(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        TypedArray h2 = ThemeEnforcement.h(context, attributeSet, R$styleable.N1, i2, R$style.Widget_MaterialComponents_Button, new int[0]);
        this.f29638f = h2.getDimensionPixelSize(R$styleable.X1, 0);
        this.f29639g = ViewUtils.b(h2.getInt(R$styleable.a2, -1), PorterDuff.Mode.SRC_IN);
        this.f29640h = MaterialResources.a(getContext(), h2, R$styleable.Z1);
        this.f29641i = MaterialResources.b(getContext(), h2, R$styleable.V1);
        this.f29644l = h2.getInteger(R$styleable.W1, 1);
        this.f29642j = h2.getDimensionPixelSize(R$styleable.Y1, 0);
        MaterialButtonHelper materialButtonHelper = new MaterialButtonHelper(this);
        this.f29637e = materialButtonHelper;
        materialButtonHelper.j(h2);
        h2.recycle();
        setCompoundDrawablePadding(this.f29638f);
        c();
    }
}
