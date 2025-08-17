package com.google.android.material.internal;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.Gravity;
import androidx.appcompat.widget.LinearLayoutCompat;
import com.google.android.material.R$styleable;

public class ForegroundLinearLayout extends LinearLayoutCompat {

    /* renamed from: q  reason: collision with root package name */
    private Drawable f29862q;

    /* renamed from: r  reason: collision with root package name */
    private final Rect f29863r;

    /* renamed from: s  reason: collision with root package name */
    private final Rect f29864s;

    /* renamed from: t  reason: collision with root package name */
    private int f29865t;

    /* renamed from: u  reason: collision with root package name */
    protected boolean f29866u;

    /* renamed from: v  reason: collision with root package name */
    boolean f29867v;

    public ForegroundLinearLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public void draw(Canvas canvas) {
        super.draw(canvas);
        Drawable drawable = this.f29862q;
        if (drawable != null) {
            if (this.f29867v) {
                this.f29867v = false;
                Rect rect = this.f29863r;
                Rect rect2 = this.f29864s;
                int right = getRight() - getLeft();
                int bottom = getBottom() - getTop();
                if (this.f29866u) {
                    rect.set(0, 0, right, bottom);
                } else {
                    rect.set(getPaddingLeft(), getPaddingTop(), right - getPaddingRight(), bottom - getPaddingBottom());
                }
                Gravity.apply(this.f29865t, drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight(), rect, rect2);
                drawable.setBounds(rect2);
            }
            drawable.draw(canvas);
        }
    }

    @TargetApi(21)
    public void drawableHotspotChanged(float f2, float f3) {
        super.drawableHotspotChanged(f2, f3);
        Drawable drawable = this.f29862q;
        if (drawable != null) {
            drawable.setHotspot(f2, f3);
        }
    }

    /* access modifiers changed from: protected */
    public void drawableStateChanged() {
        super.drawableStateChanged();
        Drawable drawable = this.f29862q;
        if (drawable != null && drawable.isStateful()) {
            this.f29862q.setState(getDrawableState());
        }
    }

    public Drawable getForeground() {
        return this.f29862q;
    }

    public int getForegroundGravity() {
        return this.f29865t;
    }

    public void jumpDrawablesToCurrentState() {
        super.jumpDrawablesToCurrentState();
        Drawable drawable = this.f29862q;
        if (drawable != null) {
            drawable.jumpToCurrentState();
        }
    }

    /* access modifiers changed from: protected */
    public void onLayout(boolean z2, int i2, int i3, int i4, int i5) {
        super.onLayout(z2, i2, i3, i4, i5);
        this.f29867v = z2 | this.f29867v;
    }

    /* access modifiers changed from: protected */
    public void onSizeChanged(int i2, int i3, int i4, int i5) {
        super.onSizeChanged(i2, i3, i4, i5);
        this.f29867v = true;
    }

    public void setForeground(Drawable drawable) {
        Drawable drawable2 = this.f29862q;
        if (drawable2 != drawable) {
            if (drawable2 != null) {
                drawable2.setCallback((Drawable.Callback) null);
                unscheduleDrawable(this.f29862q);
            }
            this.f29862q = drawable;
            if (drawable != null) {
                setWillNotDraw(false);
                drawable.setCallback(this);
                if (drawable.isStateful()) {
                    drawable.setState(getDrawableState());
                }
                if (this.f29865t == 119) {
                    drawable.getPadding(new Rect());
                }
            } else {
                setWillNotDraw(true);
            }
            requestLayout();
            invalidate();
        }
    }

    public void setForegroundGravity(int i2) {
        if (this.f29865t != i2) {
            if ((8388615 & i2) == 0) {
                i2 |= 8388611;
            }
            if ((i2 & 112) == 0) {
                i2 |= 48;
            }
            this.f29865t = i2;
            if (i2 == 119 && this.f29862q != null) {
                this.f29862q.getPadding(new Rect());
            }
            requestLayout();
        }
    }

    /* access modifiers changed from: protected */
    public boolean verifyDrawable(Drawable drawable) {
        return super.verifyDrawable(drawable) || drawable == this.f29862q;
    }

    public ForegroundLinearLayout(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.f29863r = new Rect();
        this.f29864s = new Rect();
        this.f29865t = 119;
        this.f29866u = true;
        this.f29867v = false;
        TypedArray h2 = ThemeEnforcement.h(context, attributeSet, R$styleable.G1, i2, 0, new int[0]);
        this.f29865t = h2.getInt(R$styleable.I1, this.f29865t);
        Drawable drawable = h2.getDrawable(R$styleable.H1);
        if (drawable != null) {
            setForeground(drawable);
        }
        this.f29866u = h2.getBoolean(R$styleable.J1, true);
        h2.recycle();
    }
}
