package com.google.android.material.internal;

import android.content.res.ColorStateList;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Shader;
import android.graphics.drawable.Drawable;
import androidx.core.graphics.ColorUtils;

public class CircularBorderDrawable extends Drawable {

    /* renamed from: a  reason: collision with root package name */
    final Paint f29815a;

    /* renamed from: b  reason: collision with root package name */
    final Rect f29816b = new Rect();

    /* renamed from: c  reason: collision with root package name */
    final RectF f29817c = new RectF();

    /* renamed from: d  reason: collision with root package name */
    final CircularBorderState f29818d = new CircularBorderState();

    /* renamed from: e  reason: collision with root package name */
    float f29819e;

    /* renamed from: f  reason: collision with root package name */
    private int f29820f;

    /* renamed from: g  reason: collision with root package name */
    private int f29821g;

    /* renamed from: h  reason: collision with root package name */
    private int f29822h;

    /* renamed from: i  reason: collision with root package name */
    private int f29823i;

    /* renamed from: j  reason: collision with root package name */
    private ColorStateList f29824j;

    /* renamed from: k  reason: collision with root package name */
    private int f29825k;

    /* renamed from: l  reason: collision with root package name */
    private boolean f29826l = true;

    /* renamed from: m  reason: collision with root package name */
    private float f29827m;

    private class CircularBorderState extends Drawable.ConstantState {
        private CircularBorderState() {
        }

        public int getChangingConfigurations() {
            return 0;
        }

        public Drawable newDrawable() {
            return CircularBorderDrawable.this;
        }
    }

    public CircularBorderDrawable() {
        Paint paint = new Paint(1);
        this.f29815a = paint;
        paint.setStyle(Paint.Style.STROKE);
    }

    private Shader a() {
        Rect rect = this.f29816b;
        copyBounds(rect);
        float height = this.f29819e / ((float) rect.height());
        return new LinearGradient(0.0f, (float) rect.top, 0.0f, (float) rect.bottom, new int[]{ColorUtils.k(this.f29820f, this.f29825k), ColorUtils.k(this.f29821g, this.f29825k), ColorUtils.k(ColorUtils.p(this.f29821g, 0), this.f29825k), ColorUtils.k(ColorUtils.p(this.f29823i, 0), this.f29825k), ColorUtils.k(this.f29823i, this.f29825k), ColorUtils.k(this.f29822h, this.f29825k)}, new float[]{0.0f, height, 0.5f, 0.5f, 1.0f - height, 1.0f}, Shader.TileMode.CLAMP);
    }

    public void b(ColorStateList colorStateList) {
        if (colorStateList != null) {
            this.f29825k = colorStateList.getColorForState(getState(), this.f29825k);
        }
        this.f29824j = colorStateList;
        this.f29826l = true;
        invalidateSelf();
    }

    public void c(float f2) {
        if (this.f29819e != f2) {
            this.f29819e = f2;
            this.f29815a.setStrokeWidth(f2 * 1.3333f);
            this.f29826l = true;
            invalidateSelf();
        }
    }

    public void d(int i2, int i3, int i4, int i5) {
        this.f29820f = i2;
        this.f29821g = i3;
        this.f29822h = i4;
        this.f29823i = i5;
    }

    public void draw(Canvas canvas) {
        if (this.f29826l) {
            this.f29815a.setShader(a());
            this.f29826l = false;
        }
        float strokeWidth = this.f29815a.getStrokeWidth() / 2.0f;
        RectF rectF = this.f29817c;
        copyBounds(this.f29816b);
        rectF.set(this.f29816b);
        rectF.left += strokeWidth;
        rectF.top += strokeWidth;
        rectF.right -= strokeWidth;
        rectF.bottom -= strokeWidth;
        canvas.save();
        canvas.rotate(this.f29827m, rectF.centerX(), rectF.centerY());
        canvas.drawOval(rectF, this.f29815a);
        canvas.restore();
    }

    public final void e(float f2) {
        if (f2 != this.f29827m) {
            this.f29827m = f2;
            invalidateSelf();
        }
    }

    public Drawable.ConstantState getConstantState() {
        return this.f29818d;
    }

    public int getOpacity() {
        return this.f29819e > 0.0f ? -3 : -2;
    }

    public boolean getPadding(Rect rect) {
        int round = Math.round(this.f29819e);
        rect.set(round, round, round, round);
        return true;
    }

    public boolean isStateful() {
        ColorStateList colorStateList = this.f29824j;
        return (colorStateList != null && colorStateList.isStateful()) || super.isStateful();
    }

    /* access modifiers changed from: protected */
    public void onBoundsChange(Rect rect) {
        this.f29826l = true;
    }

    /* access modifiers changed from: protected */
    public boolean onStateChange(int[] iArr) {
        int colorForState;
        ColorStateList colorStateList = this.f29824j;
        if (!(colorStateList == null || (colorForState = colorStateList.getColorForState(iArr, this.f29825k)) == this.f29825k)) {
            this.f29826l = true;
            this.f29825k = colorForState;
        }
        if (this.f29826l) {
            invalidateSelf();
        }
        return this.f29826l;
    }

    public void setAlpha(int i2) {
        this.f29815a.setAlpha(i2);
        invalidateSelf();
    }

    public void setColorFilter(ColorFilter colorFilter) {
        this.f29815a.setColorFilter(colorFilter);
        invalidateSelf();
    }
}
