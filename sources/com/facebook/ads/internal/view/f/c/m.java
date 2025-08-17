package com.facebook.ads.internal.view.f.c;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.view.View;
import android.widget.Button;
import com.facebook.ads.internal.q.a.x;

public class m extends Button {

    /* renamed from: a  reason: collision with root package name */
    private final Path f21458a;

    /* renamed from: b  reason: collision with root package name */
    private final Path f21459b;

    /* renamed from: c  reason: collision with root package name */
    private final Paint f21460c;

    /* renamed from: d  reason: collision with root package name */
    private final Path f21461d;

    /* renamed from: e  reason: collision with root package name */
    private boolean f21462e;

    public m(Context context) {
        this(context, false);
    }

    public m(Context context, boolean z2) {
        super(context);
        this.f21462e = false;
        this.f21458a = new Path();
        this.f21459b = new Path();
        this.f21461d = new Path();
        this.f21460c = new Paint(z2) {

            /* renamed from: a  reason: collision with root package name */
            final /* synthetic */ boolean f21463a;

            {
                this.f21463a = r2;
                setStyle(Paint.Style.FILL_AND_STROKE);
                setStrokeCap(Paint.Cap.ROUND);
                setStrokeWidth(3.0f);
                setAntiAlias(true);
                setColor(r2 ? -1 : -10066330);
            }
        };
        setClickable(true);
        x.a((View) this, 0);
    }

    /* access modifiers changed from: protected */
    public void onDraw(Canvas canvas) {
        Path path;
        boolean isHardwareAccelerated = canvas.isHardwareAccelerated();
        float max = ((float) Math.max(canvas.getWidth(), canvas.getHeight())) / 100.0f;
        if (this.f21462e) {
            this.f21461d.rewind();
            float f2 = 26.5f * max;
            float f3 = 15.5f * max;
            this.f21461d.moveTo(f2, f3);
            this.f21461d.lineTo(f2, 84.5f * max);
            this.f21461d.lineTo(90.0f * max, max * 50.0f);
            this.f21461d.lineTo(f2, f3);
            this.f21461d.close();
            path = this.f21461d;
        } else {
            this.f21458a.rewind();
            float f4 = 29.0f * max;
            float f5 = 21.0f * max;
            this.f21458a.moveTo(f4, f5);
            float f6 = 79.0f * max;
            this.f21458a.lineTo(f4, f6);
            float f7 = 45.0f * max;
            this.f21458a.lineTo(f7, f6);
            this.f21458a.lineTo(f7, f5);
            this.f21458a.lineTo(f4, f5);
            this.f21458a.close();
            this.f21459b.rewind();
            float f8 = 55.0f * max;
            this.f21459b.moveTo(f8, f5);
            this.f21459b.lineTo(f8, f6);
            float f9 = max * 71.0f;
            this.f21459b.lineTo(f9, f6);
            this.f21459b.lineTo(f9, f5);
            this.f21459b.lineTo(f8, f5);
            this.f21459b.close();
            canvas.drawPath(this.f21458a, this.f21460c);
            path = this.f21459b;
        }
        canvas.drawPath(path, this.f21460c);
        super.onDraw(canvas);
    }

    public void setChecked(boolean z2) {
        this.f21462e = z2;
        refreshDrawableState();
        invalidate();
    }
}
