package com.flask.colorpicker.slider;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.util.AttributeSet;
import android.view.View;
import com.flask.colorpicker.R$dimen;
import com.flask.colorpicker.R$styleable;

public abstract class AbsCustomSlider extends View {

    /* renamed from: b  reason: collision with root package name */
    protected Bitmap f22027b;

    /* renamed from: c  reason: collision with root package name */
    protected Canvas f22028c;

    /* renamed from: d  reason: collision with root package name */
    protected Bitmap f22029d;

    /* renamed from: e  reason: collision with root package name */
    protected Canvas f22030e;

    /* renamed from: f  reason: collision with root package name */
    protected int f22031f;

    /* renamed from: g  reason: collision with root package name */
    protected int f22032g = 20;

    /* renamed from: h  reason: collision with root package name */
    protected int f22033h = 5;

    /* renamed from: i  reason: collision with root package name */
    protected float f22034i = 1.0f;

    /* renamed from: j  reason: collision with root package name */
    protected boolean f22035j = false;

    /* renamed from: k  reason: collision with root package name */
    private boolean f22036k = false;

    public AbsCustomSlider(Context context) {
        super(context);
        e(context, (AttributeSet) null);
    }

    private void e(Context context, AttributeSet attributeSet) {
        TypedArray obtainStyledAttributes = context.getTheme().obtainStyledAttributes(attributeSet, R$styleable.f21961a, 0, 0);
        try {
            this.f22036k = obtainStyledAttributes.getBoolean(R$styleable.f21963b, this.f22036k);
        } finally {
            obtainStyledAttributes.recycle();
        }
    }

    /* access modifiers changed from: protected */
    public void a() {
        int i2;
        int i3;
        if (this.f22036k) {
            i3 = getHeight();
            i2 = getWidth();
        } else {
            i3 = getWidth();
            i2 = getHeight();
        }
        this.f22029d = Bitmap.createBitmap(Math.max(i3 - (this.f22031f * 2), 1), this.f22033h, Bitmap.Config.ARGB_8888);
        this.f22030e = new Canvas(this.f22029d);
        Bitmap bitmap = this.f22027b;
        if (bitmap == null || bitmap.getWidth() != i3 || this.f22027b.getHeight() != i2) {
            Bitmap bitmap2 = this.f22027b;
            if (bitmap2 != null) {
                bitmap2.recycle();
            }
            this.f22027b = Bitmap.createBitmap(i3, i2, Bitmap.Config.ARGB_8888);
            this.f22028c = new Canvas(this.f22027b);
        }
    }

    /* access modifiers changed from: protected */
    public abstract void b(Canvas canvas);

    /* access modifiers changed from: protected */
    public abstract void c(Canvas canvas, float f2, float f3);

    /* access modifiers changed from: protected */
    public int d(int i2) {
        return getResources().getDimensionPixelSize(i2);
    }

    /* access modifiers changed from: protected */
    public abstract void f(float f2);

    /* access modifiers changed from: protected */
    public void g() {
        this.f22032g = d(R$dimen.default_slider_handler_radius);
        this.f22033h = d(R$dimen.default_slider_bar_height);
        this.f22031f = this.f22032g;
        if (this.f22029d == null) {
            a();
        }
        b(this.f22030e);
        invalidate();
    }

    /* access modifiers changed from: protected */
    public void onDraw(Canvas canvas) {
        int i2;
        int i3;
        Canvas canvas2;
        super.onDraw(canvas);
        if (this.f22036k) {
            i3 = getHeight();
            i2 = getWidth();
            canvas.rotate(-90.0f);
            canvas.translate((float) (-i3), 0.0f);
        } else {
            i3 = getWidth();
            i2 = getHeight();
        }
        if (this.f22029d != null && (canvas2 = this.f22028c) != null) {
            canvas2.drawColor(0, PorterDuff.Mode.CLEAR);
            Canvas canvas3 = this.f22028c;
            Bitmap bitmap = this.f22029d;
            canvas3.drawBitmap(bitmap, (float) this.f22031f, (float) ((i2 - bitmap.getHeight()) / 2), (Paint) null);
            int i4 = this.f22032g;
            c(this.f22028c, ((float) i4) + (this.f22034i * ((float) (i3 - (i4 * 2)))), ((float) i2) / 2.0f);
            canvas.drawBitmap(this.f22027b, 0.0f, 0.0f, (Paint) null);
        }
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i2, int i3) {
        super.onMeasure(i2, i3);
        int mode = View.MeasureSpec.getMode(i2);
        if (mode != 0) {
            if (mode == Integer.MIN_VALUE) {
                i2 = View.MeasureSpec.getSize(i2);
            } else if (mode == 1073741824) {
                i2 = View.MeasureSpec.getSize(i2);
            } else {
                i2 = 0;
            }
        }
        int mode2 = View.MeasureSpec.getMode(i3);
        if (mode2 != 0) {
            if (mode2 == Integer.MIN_VALUE) {
                i3 = View.MeasureSpec.getSize(i3);
            } else if (mode2 == 1073741824) {
                i3 = View.MeasureSpec.getSize(i3);
            } else {
                i3 = 0;
            }
        }
        setMeasuredDimension(i2, i3);
    }

    /* access modifiers changed from: protected */
    public void onSizeChanged(int i2, int i3, int i4, int i5) {
        super.onSizeChanged(i2, i3, i4, i5);
        g();
    }

    /* JADX WARNING: Code restructure failed: missing block: B:4:0x000a, code lost:
        if (r0 != 2) goto L_0x005a;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean onTouchEvent(android.view.MotionEvent r4) {
        /*
            r3 = this;
            int r0 = r4.getAction()
            r1 = 1
            if (r0 == 0) goto L_0x0016
            if (r0 == r1) goto L_0x000d
            r2 = 2
            if (r0 == r2) goto L_0x0016
            goto L_0x005a
        L_0x000d:
            float r4 = r3.f22034i
            r3.f(r4)
            r3.invalidate()
            goto L_0x005a
        L_0x0016:
            android.graphics.Bitmap r0 = r3.f22029d
            if (r0 == 0) goto L_0x005a
            boolean r0 = r3.f22036k
            r2 = 1065353216(0x3f800000, float:1.0)
            if (r0 == 0) goto L_0x0035
            float r4 = r4.getY()
            int r0 = r3.f22031f
            float r0 = (float) r0
            float r4 = r4 - r0
            android.graphics.Bitmap r0 = r3.f22029d
            int r0 = r0.getWidth()
            float r0 = (float) r0
            float r4 = r4 / r0
            float r4 = r2 - r4
            r3.f22034i = r4
            goto L_0x0047
        L_0x0035:
            float r4 = r4.getX()
            int r0 = r3.f22031f
            float r0 = (float) r0
            float r4 = r4 - r0
            android.graphics.Bitmap r0 = r3.f22029d
            int r0 = r0.getWidth()
            float r0 = (float) r0
            float r4 = r4 / r0
            r3.f22034i = r4
        L_0x0047:
            float r4 = r3.f22034i
            float r4 = java.lang.Math.min(r4, r2)
            r0 = 0
            float r4 = java.lang.Math.max(r0, r4)
            r3.f22034i = r4
            r3.f(r4)
            r3.invalidate()
        L_0x005a:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.flask.colorpicker.slider.AbsCustomSlider.onTouchEvent(android.view.MotionEvent):boolean");
    }

    public void setOnValueChangedListener(OnValueChangedListener onValueChangedListener) {
    }

    public void setShowBorder(boolean z2) {
        this.f22035j = z2;
    }

    public AbsCustomSlider(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        e(context, attributeSet);
    }
}
