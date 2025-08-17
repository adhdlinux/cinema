package com.applovin.impl.adview;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import com.applovin.impl.adview.i;

@SuppressLint({"ViewConstructor"})
public final class r extends i {

    /* renamed from: c  reason: collision with root package name */
    private static final Paint f14122c = new Paint(1);

    /* renamed from: d  reason: collision with root package name */
    private static final Paint f14123d = new Paint(1);

    /* renamed from: e  reason: collision with root package name */
    private final float[] f14124e = {30.0f, 30.0f, 50.0f, 50.0f, 30.0f, 70.0f, 55.0f, 30.0f, 75.0f, 50.0f, 55.0f, 70.0f};

    /* renamed from: f  reason: collision with root package name */
    private Path f14125f;

    public r(Context context) {
        super(context);
        f14122c.setARGB(80, 0, 0, 0);
        Paint paint = f14123d;
        paint.setColor(-1);
        paint.setStyle(Paint.Style.STROKE);
    }

    private void a() {
        int i2 = 0;
        while (true) {
            float[] fArr = this.f14124e;
            if (i2 < fArr.length) {
                fArr[i2] = fArr[i2] * 0.3f * this.f14063a;
                i2++;
            } else {
                Path path = new Path();
                this.f14125f = path;
                float[] fArr2 = this.f14124e;
                path.moveTo(fArr2[0], fArr2[1]);
                Path path2 = this.f14125f;
                float[] fArr3 = this.f14124e;
                path2.lineTo(fArr3[2], fArr3[3]);
                Path path3 = this.f14125f;
                float[] fArr4 = this.f14124e;
                path3.lineTo(fArr4[4], fArr4[5]);
                Path path4 = this.f14125f;
                float[] fArr5 = this.f14124e;
                path4.moveTo(fArr5[6], fArr5[7]);
                Path path5 = this.f14125f;
                float[] fArr6 = this.f14124e;
                path5.lineTo(fArr6[8], fArr6[9]);
                Path path6 = this.f14125f;
                float[] fArr7 = this.f14124e;
                path6.lineTo(fArr7[10], fArr7[11]);
                return;
            }
        }
    }

    public void a(int i2) {
        setViewScale(((float) i2) / 30.0f);
        a();
    }

    /* access modifiers changed from: protected */
    public float getCenter() {
        return getSize() / 2.0f;
    }

    /* access modifiers changed from: protected */
    public float getStrokeWidth() {
        return this.f14063a * 2.0f;
    }

    public i.a getStyle() {
        return i.a.TRANSPARENT_SKIP;
    }

    /* access modifiers changed from: protected */
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        float center = getCenter();
        canvas.drawCircle(center, center, center, f14122c);
        Paint paint = f14123d;
        paint.setStrokeWidth(getStrokeWidth());
        canvas.drawPath(this.f14125f, paint);
    }
}
