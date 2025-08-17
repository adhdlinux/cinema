package com.google.android.exoplayer2.ui;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;

public final class AspectRatioFrameLayout extends FrameLayout {

    /* renamed from: b  reason: collision with root package name */
    private final AspectRatioUpdateDispatcher f27830b;

    /* renamed from: c  reason: collision with root package name */
    private float f27831c;

    /* renamed from: d  reason: collision with root package name */
    private int f27832d = 0;

    public interface AspectRatioListener {
    }

    private final class AspectRatioUpdateDispatcher implements Runnable {

        /* renamed from: b  reason: collision with root package name */
        private float f27833b;

        /* renamed from: c  reason: collision with root package name */
        private float f27834c;

        /* renamed from: d  reason: collision with root package name */
        private boolean f27835d;

        /* renamed from: e  reason: collision with root package name */
        private boolean f27836e;

        private AspectRatioUpdateDispatcher() {
        }

        public void a(float f2, float f3, boolean z2) {
            this.f27833b = f2;
            this.f27834c = f3;
            this.f27835d = z2;
            if (!this.f27836e) {
                this.f27836e = true;
                AspectRatioFrameLayout.this.post(this);
            }
        }

        public void run() {
            this.f27836e = false;
            AspectRatioListener unused = AspectRatioFrameLayout.this.getClass();
        }
    }

    public AspectRatioFrameLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = context.getTheme().obtainStyledAttributes(attributeSet, R$styleable.f28028a, 0, 0);
            try {
                this.f27832d = obtainStyledAttributes.getInt(R$styleable.f28030b, 0);
            } finally {
                obtainStyledAttributes.recycle();
            }
        }
        this.f27830b = new AspectRatioUpdateDispatcher();
    }

    public int getResizeMode() {
        return this.f27832d;
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i2, int i3) {
        float f2;
        float f3;
        super.onMeasure(i2, i3);
        if (this.f27831c > 0.0f) {
            int measuredWidth = getMeasuredWidth();
            int measuredHeight = getMeasuredHeight();
            float f4 = (float) measuredWidth;
            float f5 = (float) measuredHeight;
            float f6 = f4 / f5;
            float f7 = (this.f27831c / f6) - 1.0f;
            if (Math.abs(f7) <= 0.01f) {
                this.f27830b.a(this.f27831c, f6, false);
                return;
            }
            int i4 = this.f27832d;
            if (i4 != 0) {
                if (i4 == 1) {
                    f3 = this.f27831c;
                } else if (i4 != 2) {
                    if (i4 == 4) {
                        if (f7 > 0.0f) {
                            f2 = this.f27831c;
                        } else {
                            f3 = this.f27831c;
                        }
                    }
                    this.f27830b.a(this.f27831c, f6, true);
                    super.onMeasure(View.MeasureSpec.makeMeasureSpec(measuredWidth, 1073741824), View.MeasureSpec.makeMeasureSpec(measuredHeight, 1073741824));
                } else {
                    f2 = this.f27831c;
                }
                measuredHeight = (int) (f4 / f3);
                this.f27830b.a(this.f27831c, f6, true);
                super.onMeasure(View.MeasureSpec.makeMeasureSpec(measuredWidth, 1073741824), View.MeasureSpec.makeMeasureSpec(measuredHeight, 1073741824));
            } else if (f7 > 0.0f) {
                f3 = this.f27831c;
                measuredHeight = (int) (f4 / f3);
                this.f27830b.a(this.f27831c, f6, true);
                super.onMeasure(View.MeasureSpec.makeMeasureSpec(measuredWidth, 1073741824), View.MeasureSpec.makeMeasureSpec(measuredHeight, 1073741824));
            } else {
                f2 = this.f27831c;
            }
            measuredWidth = (int) (f5 * f2);
            this.f27830b.a(this.f27831c, f6, true);
            super.onMeasure(View.MeasureSpec.makeMeasureSpec(measuredWidth, 1073741824), View.MeasureSpec.makeMeasureSpec(measuredHeight, 1073741824));
        }
    }

    public void setAspectRatio(float f2) {
        if (this.f27831c != f2) {
            this.f27831c = f2;
            requestLayout();
        }
    }

    public void setAspectRatioListener(AspectRatioListener aspectRatioListener) {
    }

    public void setResizeMode(int i2) {
        if (this.f27832d != i2) {
            this.f27832d = i2;
            requestLayout();
        }
    }
}
