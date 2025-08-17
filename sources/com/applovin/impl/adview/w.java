package com.applovin.impl.adview;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import com.applovin.impl.adview.i;

@SuppressLint({"ViewConstructor"})
public final class w extends i {

    /* renamed from: c  reason: collision with root package name */
    private static final Paint f14139c = new Paint(1);

    /* renamed from: d  reason: collision with root package name */
    private static final Paint f14140d = new Paint(1);

    /* renamed from: e  reason: collision with root package name */
    private static final Paint f14141e = new Paint(1);

    public w(Context context) {
        super(context);
        f14139c.setColor(-1);
        f14140d.setColor(-16777216);
        Paint paint = f14141e;
        paint.setColor(-1);
        paint.setStyle(Paint.Style.STROKE);
    }

    /* access modifiers changed from: protected */
    public float getCenter() {
        return getSize() / 2.0f;
    }

    /* access modifiers changed from: protected */
    public float getCrossOffset() {
        return this.f14063a * 10.0f;
    }

    /* access modifiers changed from: protected */
    public float getInnerCircleOffset() {
        return this.f14063a * 2.0f;
    }

    /* access modifiers changed from: protected */
    public float getInnerCircleRadius() {
        return getCenter() - getInnerCircleOffset();
    }

    /* access modifiers changed from: protected */
    public float getStrokeWidth() {
        return this.f14063a * 3.0f;
    }

    public i.a getStyle() {
        return i.a.WHITE_ON_BLACK;
    }

    /* access modifiers changed from: protected */
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        float center = getCenter();
        canvas.drawCircle(center, center, center, f14139c);
        canvas.drawCircle(center, center, getInnerCircleRadius(), f14140d);
        float crossOffset = getCrossOffset();
        float size = getSize() - crossOffset;
        Paint paint = f14141e;
        paint.setStrokeWidth(getStrokeWidth());
        Canvas canvas2 = canvas;
        float f2 = crossOffset;
        float f3 = size;
        Paint paint2 = paint;
        canvas2.drawLine(f2, crossOffset, f3, size, paint2);
        canvas2.drawLine(f2, size, f3, crossOffset, paint2);
    }
}
