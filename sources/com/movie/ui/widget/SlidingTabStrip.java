package com.movie.ui.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import com.movie.ui.widget.SlidingTabLayout;

class SlidingTabStrip extends LinearLayout {

    /* renamed from: b  reason: collision with root package name */
    private final int f33665b;

    /* renamed from: c  reason: collision with root package name */
    private final Paint f33666c;

    /* renamed from: d  reason: collision with root package name */
    private final SimpleTabColorizer f33667d;

    /* renamed from: e  reason: collision with root package name */
    private int f33668e;

    /* renamed from: f  reason: collision with root package name */
    private float f33669f;

    /* renamed from: g  reason: collision with root package name */
    private SlidingTabLayout.TabColorizer f33670g;

    private static class SimpleTabColorizer implements SlidingTabLayout.TabColorizer {

        /* renamed from: a  reason: collision with root package name */
        private int[] f33671a;

        private SimpleTabColorizer() {
        }

        public final int a(int i2) {
            int[] iArr = this.f33671a;
            return iArr[i2 % iArr.length];
        }

        /* access modifiers changed from: package-private */
        public void b(int... iArr) {
            this.f33671a = iArr;
        }
    }

    SlidingTabStrip(Context context) {
        this(context, (AttributeSet) null);
    }

    private static int a(int i2, int i3, float f2) {
        float f3 = 1.0f - f2;
        return Color.rgb((int) ((((float) Color.red(i2)) * f2) + (((float) Color.red(i3)) * f3)), (int) ((((float) Color.green(i2)) * f2) + (((float) Color.green(i3)) * f3)), (int) ((((float) Color.blue(i2)) * f2) + (((float) Color.blue(i3)) * f3)));
    }

    /* access modifiers changed from: package-private */
    public void b(int i2, float f2) {
        this.f33668e = i2;
        this.f33669f = f2;
        invalidate();
    }

    /* access modifiers changed from: package-private */
    public void c(SlidingTabLayout.TabColorizer tabColorizer) {
        this.f33670g = tabColorizer;
        invalidate();
    }

    /* access modifiers changed from: package-private */
    public void d(int... iArr) {
        this.f33670g = null;
        this.f33667d.b(iArr);
        invalidate();
    }

    /* access modifiers changed from: protected */
    public void onDraw(Canvas canvas) {
        int height = getHeight();
        int childCount = getChildCount();
        SlidingTabLayout.TabColorizer tabColorizer = this.f33670g;
        if (tabColorizer == null) {
            tabColorizer = this.f33667d;
        }
        if (childCount > 0) {
            View childAt = getChildAt(this.f33668e);
            int left = childAt.getLeft();
            int right = childAt.getRight();
            int a2 = tabColorizer.a(this.f33668e);
            if (this.f33669f > 0.0f && this.f33668e < getChildCount() - 1) {
                int a3 = tabColorizer.a(this.f33668e + 1);
                if (a2 != a3) {
                    a2 = a(a3, a2, this.f33669f);
                }
                View childAt2 = getChildAt(this.f33668e + 1);
                float left2 = this.f33669f * ((float) childAt2.getLeft());
                float f2 = this.f33669f;
                left = (int) (left2 + ((1.0f - f2) * ((float) left)));
                right = (int) ((f2 * ((float) childAt2.getRight())) + ((1.0f - this.f33669f) * ((float) right)));
            }
            this.f33666c.setColor(a2);
            canvas.drawRect((float) left, (float) (height - this.f33665b), (float) right, (float) height, this.f33666c);
        }
    }

    SlidingTabStrip(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        setWillNotDraw(false);
        float f2 = getResources().getDisplayMetrics().density;
        SimpleTabColorizer simpleTabColorizer = new SimpleTabColorizer();
        this.f33667d = simpleTabColorizer;
        simpleTabColorizer.b(-13388315);
        this.f33665b = (int) (f2 * 2.0f);
        this.f33666c = new Paint();
    }
}
