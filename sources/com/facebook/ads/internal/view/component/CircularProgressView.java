package com.facebook.ads.internal.view.component;

import android.animation.ObjectAnimator;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.view.View;
import android.view.animation.LinearInterpolator;
import androidx.annotation.Keep;

public class CircularProgressView extends View {

    /* renamed from: a  reason: collision with root package name */
    private final float f21035a;

    /* renamed from: b  reason: collision with root package name */
    private final RectF f21036b = new RectF();

    /* renamed from: c  reason: collision with root package name */
    private final Paint f21037c;

    /* renamed from: d  reason: collision with root package name */
    private final Paint f21038d;

    /* renamed from: e  reason: collision with root package name */
    private float f21039e = 0.0f;

    public CircularProgressView(Context context) {
        super(context);
        float f2 = Resources.getSystem().getDisplayMetrics().density * 3.0f;
        this.f21035a = f2;
        Paint paint = new Paint(1);
        this.f21037c = paint;
        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeWidth(f2);
        Paint paint2 = new Paint(1);
        this.f21038d = paint2;
        paint2.setStyle(Paint.Style.STROKE);
        paint2.setStrokeWidth(f2);
    }

    public void a(int i2, int i3) {
        this.f21037c.setColor(i2);
        this.f21038d.setColor(i3);
    }

    @Keep
    public float getProgress() {
        return this.f21039e;
    }

    /* access modifiers changed from: protected */
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawArc(this.f21036b, 0.0f, 360.0f, false, this.f21037c);
        canvas.drawArc(this.f21036b, -90.0f, (this.f21039e * 360.0f) / 100.0f, false, this.f21038d);
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i2, int i3) {
        int min = Math.min(View.getDefaultSize(getSuggestedMinimumHeight(), i3), View.getDefaultSize(getSuggestedMinimumWidth(), i2));
        setMeasuredDimension(min, min);
        float f2 = (float) min;
        this.f21036b.set((this.f21035a / 2.0f) + 0.0f + ((float) getPaddingLeft()), (this.f21035a / 2.0f) + 0.0f + ((float) getPaddingTop()), (f2 - (this.f21035a / 2.0f)) - ((float) getPaddingRight()), (f2 - (this.f21035a / 2.0f)) - ((float) getPaddingBottom()));
    }

    @Keep
    public void setProgress(float f2) {
        this.f21039e = Math.min(f2, 100.0f);
        postInvalidate();
    }

    public void setProgressWithAnimation(float f2) {
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this, "progress", new float[]{f2});
        ofFloat.setDuration(400);
        ofFloat.setInterpolator(new LinearInterpolator());
        ofFloat.start();
    }
}
