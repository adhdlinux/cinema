package com.facebook.ads.internal.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.view.View;
import android.widget.RelativeLayout;
import com.facebook.ads.internal.q.a.x;

public class d extends View {

    /* renamed from: a  reason: collision with root package name */
    private Paint f21140a;

    /* renamed from: b  reason: collision with root package name */
    private Paint f21141b;

    /* renamed from: c  reason: collision with root package name */
    private Paint f21142c;

    /* renamed from: d  reason: collision with root package name */
    private int f21143d;

    /* renamed from: e  reason: collision with root package name */
    private boolean f21144e;

    public d(Context context) {
        this(context, 60, true);
    }

    public d(Context context, int i2, boolean z2) {
        super(context);
        this.f21143d = i2;
        this.f21144e = z2;
        if (z2) {
            Paint paint = new Paint();
            this.f21140a = paint;
            paint.setColor(-3355444);
            this.f21140a.setStyle(Paint.Style.STROKE);
            this.f21140a.setStrokeWidth(3.0f);
            this.f21140a.setAntiAlias(true);
            Paint paint2 = new Paint();
            this.f21141b = paint2;
            paint2.setColor(-1287371708);
            this.f21141b.setStyle(Paint.Style.FILL);
            this.f21141b.setAntiAlias(true);
            Paint paint3 = new Paint();
            this.f21142c = paint3;
            paint3.setColor(-1);
            this.f21142c.setStyle(Paint.Style.STROKE);
            this.f21142c.setStrokeWidth(6.0f);
            this.f21142c.setAntiAlias(true);
        }
        a();
    }

    private void a() {
        float f2 = x.f20694b;
        int i2 = this.f21143d;
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams((int) (((float) i2) * f2), (int) (((float) i2) * f2));
        layoutParams.addRule(10);
        layoutParams.addRule(11);
        setLayoutParams(layoutParams);
    }

    /* access modifiers changed from: protected */
    public void onDraw(Canvas canvas) {
        if (this.f21144e) {
            boolean isHardwareAccelerated = canvas.isHardwareAccelerated();
            int min = Math.min(canvas.getWidth(), canvas.getHeight());
            int i2 = min / 2;
            int i3 = (i2 * 2) / 3;
            float f2 = (float) i2;
            canvas.drawCircle(f2, f2, (float) i3, this.f21140a);
            canvas.drawCircle(f2, f2, (float) (i3 - 2), this.f21141b);
            int i4 = min / 3;
            float f3 = (float) i4;
            float f4 = (float) (i4 * 2);
            Canvas canvas2 = canvas;
            float f5 = f3;
            float f6 = f4;
            canvas2.drawLine(f3, f5, f4, f6, this.f21142c);
            canvas2.drawLine(f4, f5, f3, f6, this.f21142c);
        }
        super.onDraw(canvas);
    }
}
