package androidx.media3.ui;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;

public final class AspectRatioFrameLayout extends FrameLayout {

    /* renamed from: b  reason: collision with root package name */
    private final AspectRatioUpdateDispatcher f9752b;

    /* renamed from: c  reason: collision with root package name */
    private float f9753c;

    /* renamed from: d  reason: collision with root package name */
    private int f9754d = 0;

    public interface AspectRatioListener {
    }

    private final class AspectRatioUpdateDispatcher implements Runnable {

        /* renamed from: b  reason: collision with root package name */
        private float f9755b;

        /* renamed from: c  reason: collision with root package name */
        private float f9756c;

        /* renamed from: d  reason: collision with root package name */
        private boolean f9757d;

        /* renamed from: e  reason: collision with root package name */
        private boolean f9758e;

        private AspectRatioUpdateDispatcher() {
        }

        public void a(float f2, float f3, boolean z2) {
            this.f9755b = f2;
            this.f9756c = f3;
            this.f9757d = z2;
            if (!this.f9758e) {
                this.f9758e = true;
                AspectRatioFrameLayout.this.post(this);
            }
        }

        public void run() {
            this.f9758e = false;
            AspectRatioListener unused = AspectRatioFrameLayout.this.getClass();
        }
    }

    public AspectRatioFrameLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = context.getTheme().obtainStyledAttributes(attributeSet, R$styleable.f10055a, 0, 0);
            try {
                this.f9754d = obtainStyledAttributes.getInt(R$styleable.f10057b, 0);
            } finally {
                obtainStyledAttributes.recycle();
            }
        }
        this.f9752b = new AspectRatioUpdateDispatcher();
    }

    public int getResizeMode() {
        return this.f9754d;
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i2, int i3) {
        float f2;
        float f3;
        super.onMeasure(i2, i3);
        if (this.f9753c > 0.0f) {
            int measuredWidth = getMeasuredWidth();
            int measuredHeight = getMeasuredHeight();
            float f4 = (float) measuredWidth;
            float f5 = (float) measuredHeight;
            float f6 = f4 / f5;
            float f7 = (this.f9753c / f6) - 1.0f;
            if (Math.abs(f7) <= 0.01f) {
                this.f9752b.a(this.f9753c, f6, false);
                return;
            }
            int i4 = this.f9754d;
            if (i4 != 0) {
                if (i4 == 1) {
                    f3 = this.f9753c;
                } else if (i4 != 2) {
                    if (i4 == 4) {
                        if (f7 > 0.0f) {
                            f2 = this.f9753c;
                        } else {
                            f3 = this.f9753c;
                        }
                    }
                    this.f9752b.a(this.f9753c, f6, true);
                    super.onMeasure(View.MeasureSpec.makeMeasureSpec(measuredWidth, 1073741824), View.MeasureSpec.makeMeasureSpec(measuredHeight, 1073741824));
                } else {
                    f2 = this.f9753c;
                }
                measuredHeight = (int) (f4 / f3);
                this.f9752b.a(this.f9753c, f6, true);
                super.onMeasure(View.MeasureSpec.makeMeasureSpec(measuredWidth, 1073741824), View.MeasureSpec.makeMeasureSpec(measuredHeight, 1073741824));
            } else if (f7 > 0.0f) {
                f3 = this.f9753c;
                measuredHeight = (int) (f4 / f3);
                this.f9752b.a(this.f9753c, f6, true);
                super.onMeasure(View.MeasureSpec.makeMeasureSpec(measuredWidth, 1073741824), View.MeasureSpec.makeMeasureSpec(measuredHeight, 1073741824));
            } else {
                f2 = this.f9753c;
            }
            measuredWidth = (int) (f5 * f2);
            this.f9752b.a(this.f9753c, f6, true);
            super.onMeasure(View.MeasureSpec.makeMeasureSpec(measuredWidth, 1073741824), View.MeasureSpec.makeMeasureSpec(measuredHeight, 1073741824));
        }
    }

    public void setAspectRatio(float f2) {
        if (this.f9753c != f2) {
            this.f9753c = f2;
            requestLayout();
        }
    }

    public void setAspectRatioListener(AspectRatioListener aspectRatioListener) {
    }

    public void setResizeMode(int i2) {
        if (this.f9754d != i2) {
            this.f9754d = i2;
            requestLayout();
        }
    }
}
