package com.facebook.ads.internal.view.a;

import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.ClipDrawable;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.util.AttributeSet;
import android.widget.ProgressBar;
import com.facebook.imageutils.JfifUtil;

@TargetApi(19)
public class b extends ProgressBar {

    /* renamed from: a  reason: collision with root package name */
    private static final int f20834a = Color.argb(26, 0, 0, 0);

    /* renamed from: b  reason: collision with root package name */
    private static final int f20835b = Color.rgb(88, 144, JfifUtil.MARKER_FIRST_BYTE);

    /* renamed from: c  reason: collision with root package name */
    private Rect f20836c;

    /* renamed from: d  reason: collision with root package name */
    private Paint f20837d;

    public b(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        a();
    }

    private void a() {
        setIndeterminate(false);
        setMax(100);
        setProgressDrawable(b());
        this.f20836c = new Rect();
        Paint paint = new Paint();
        this.f20837d = paint;
        paint.setStyle(Paint.Style.FILL);
        this.f20837d.setColor(f20834a);
    }

    private Drawable b() {
        return new LayerDrawable(new Drawable[]{new ColorDrawable(0), new ClipDrawable(new ColorDrawable(f20835b), 3, 1)});
    }

    /* access modifiers changed from: protected */
    public synchronized void onDraw(Canvas canvas) {
        canvas.drawRect(this.f20836c, this.f20837d);
        super.onDraw(canvas);
    }

    /* access modifiers changed from: protected */
    public synchronized void onMeasure(int i2, int i3) {
        super.onMeasure(i2, i3);
        this.f20836c.set(0, 0, getMeasuredWidth(), 2);
    }

    public synchronized void setProgress(int i2) {
        super.setProgress(i2 == 100 ? 0 : Math.max(i2, 5));
    }
}
