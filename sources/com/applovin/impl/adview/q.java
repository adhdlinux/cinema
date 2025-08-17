package com.applovin.impl.adview;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import com.applovin.impl.adview.i;

@SuppressLint({"ViewConstructor"})
public final class q extends i {

    /* renamed from: c  reason: collision with root package name */
    private static final Paint f14120c = new Paint(1);

    /* renamed from: d  reason: collision with root package name */
    private static final Paint f14121d = new Paint(1);

    public q(Context context) {
        super(context);
        f14120c.setARGB(80, 0, 0, 0);
        Paint paint = f14121d;
        paint.setColor(-1);
        paint.setStyle(Paint.Style.STROKE);
    }

    public void a(int i2) {
        setViewScale(((float) i2) / 30.0f);
    }

    /* access modifiers changed from: protected */
    public float getCenter() {
        return getSize() / 2.0f;
    }

    /* access modifiers changed from: protected */
    public float getCrossOffset() {
        return this.f14063a * 8.0f;
    }

    /* access modifiers changed from: protected */
    public float getStrokeWidth() {
        return this.f14063a * 2.0f;
    }

    public i.a getStyle() {
        return i.a.WHITE_ON_TRANSPARENT;
    }

    /* access modifiers changed from: protected */
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        float center = getCenter();
        canvas.drawCircle(center, center, center, f14120c);
        float crossOffset = getCrossOffset();
        float size = getSize() - crossOffset;
        Paint paint = f14121d;
        paint.setStrokeWidth(getStrokeWidth());
        Canvas canvas2 = canvas;
        float f2 = crossOffset;
        float f3 = size;
        Paint paint2 = paint;
        canvas2.drawLine(f2, crossOffset, f3, size, paint2);
        canvas2.drawLine(f2, size, f3, crossOffset, paint2);
    }
}
