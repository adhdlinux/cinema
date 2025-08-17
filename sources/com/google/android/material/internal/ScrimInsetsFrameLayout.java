package com.google.android.material.internal;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import androidx.core.view.OnApplyWindowInsetsListener;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import com.google.android.material.R$style;
import com.google.android.material.R$styleable;

public class ScrimInsetsFrameLayout extends FrameLayout {

    /* renamed from: b  reason: collision with root package name */
    Drawable f29899b;

    /* renamed from: c  reason: collision with root package name */
    Rect f29900c;

    /* renamed from: d  reason: collision with root package name */
    private Rect f29901d;

    public ScrimInsetsFrameLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    /* access modifiers changed from: protected */
    public void a(WindowInsetsCompat windowInsetsCompat) {
    }

    public void draw(Canvas canvas) {
        super.draw(canvas);
        int width = getWidth();
        int height = getHeight();
        if (this.f29900c != null && this.f29899b != null) {
            int save = canvas.save();
            canvas.translate((float) getScrollX(), (float) getScrollY());
            this.f29901d.set(0, 0, width, this.f29900c.top);
            this.f29899b.setBounds(this.f29901d);
            this.f29899b.draw(canvas);
            this.f29901d.set(0, height - this.f29900c.bottom, width, height);
            this.f29899b.setBounds(this.f29901d);
            this.f29899b.draw(canvas);
            Rect rect = this.f29901d;
            Rect rect2 = this.f29900c;
            rect.set(0, rect2.top, rect2.left, height - rect2.bottom);
            this.f29899b.setBounds(this.f29901d);
            this.f29899b.draw(canvas);
            Rect rect3 = this.f29901d;
            Rect rect4 = this.f29900c;
            rect3.set(width - rect4.right, rect4.top, width, height - rect4.bottom);
            this.f29899b.setBounds(this.f29901d);
            this.f29899b.draw(canvas);
            canvas.restoreToCount(save);
        }
    }

    /* access modifiers changed from: protected */
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        Drawable drawable = this.f29899b;
        if (drawable != null) {
            drawable.setCallback(this);
        }
    }

    /* access modifiers changed from: protected */
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        Drawable drawable = this.f29899b;
        if (drawable != null) {
            drawable.setCallback((Drawable.Callback) null);
        }
    }

    public ScrimInsetsFrameLayout(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.f29901d = new Rect();
        TypedArray h2 = ThemeEnforcement.h(context, attributeSet, R$styleable.C2, i2, R$style.Widget_Design_ScrimInsetsFrameLayout, new int[0]);
        this.f29899b = h2.getDrawable(R$styleable.D2);
        h2.recycle();
        setWillNotDraw(true);
        ViewCompat.G0(this, new OnApplyWindowInsetsListener() {
            public WindowInsetsCompat a(View view, WindowInsetsCompat windowInsetsCompat) {
                boolean z2;
                ScrimInsetsFrameLayout scrimInsetsFrameLayout = ScrimInsetsFrameLayout.this;
                if (scrimInsetsFrameLayout.f29900c == null) {
                    scrimInsetsFrameLayout.f29900c = new Rect();
                }
                ScrimInsetsFrameLayout.this.f29900c.set(windowInsetsCompat.i(), windowInsetsCompat.k(), windowInsetsCompat.j(), windowInsetsCompat.h());
                ScrimInsetsFrameLayout.this.a(windowInsetsCompat);
                ScrimInsetsFrameLayout scrimInsetsFrameLayout2 = ScrimInsetsFrameLayout.this;
                if (!windowInsetsCompat.l() || ScrimInsetsFrameLayout.this.f29899b == null) {
                    z2 = true;
                } else {
                    z2 = false;
                }
                scrimInsetsFrameLayout2.setWillNotDraw(z2);
                ViewCompat.i0(ScrimInsetsFrameLayout.this);
                return windowInsetsCompat.c();
            }
        });
    }
}
