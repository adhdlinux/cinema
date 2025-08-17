package com.google.android.material.textfield;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.view.View;

class CutoutDrawable extends GradientDrawable {

    /* renamed from: a  reason: collision with root package name */
    private final Paint f30127a = new Paint(1);

    /* renamed from: b  reason: collision with root package name */
    private final RectF f30128b;

    /* renamed from: c  reason: collision with root package name */
    private int f30129c;

    CutoutDrawable() {
        h();
        this.f30128b = new RectF();
    }

    private void b(Canvas canvas) {
        if (!i(getCallback())) {
            canvas.restoreToCount(this.f30129c);
        }
    }

    private void c(Canvas canvas) {
        Drawable.Callback callback = getCallback();
        if (i(callback)) {
            ((View) callback).setLayerType(2, (Paint) null);
        } else {
            e(canvas);
        }
    }

    private void e(Canvas canvas) {
        this.f30129c = canvas.saveLayer(0.0f, 0.0f, (float) canvas.getWidth(), (float) canvas.getHeight(), (Paint) null);
    }

    private void h() {
        this.f30127a.setStyle(Paint.Style.FILL_AND_STROKE);
        this.f30127a.setColor(-1);
        this.f30127a.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_OUT));
    }

    private boolean i(Drawable.Callback callback) {
        return callback instanceof View;
    }

    /* access modifiers changed from: package-private */
    public boolean a() {
        return !this.f30128b.isEmpty();
    }

    /* access modifiers changed from: package-private */
    public void d() {
        f(0.0f, 0.0f, 0.0f, 0.0f);
    }

    public void draw(Canvas canvas) {
        c(canvas);
        super.draw(canvas);
        canvas.drawRect(this.f30128b, this.f30127a);
        b(canvas);
    }

    /* access modifiers changed from: package-private */
    public void f(float f2, float f3, float f4, float f5) {
        RectF rectF = this.f30128b;
        if (f2 != rectF.left || f3 != rectF.top || f4 != rectF.right || f5 != rectF.bottom) {
            rectF.set(f2, f3, f4, f5);
            invalidateSelf();
        }
    }

    /* access modifiers changed from: package-private */
    public void g(RectF rectF) {
        f(rectF.left, rectF.top, rectF.right, rectF.bottom);
    }
}
