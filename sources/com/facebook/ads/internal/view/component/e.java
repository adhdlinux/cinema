package com.facebook.ads.internal.view.component;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Path;
import android.graphics.RectF;
import android.widget.ImageView;
import com.facebook.ads.internal.q.a.x;

public class e extends ImageView {

    /* renamed from: a  reason: collision with root package name */
    private static final int f21127a = ((int) (x.f20694b * 8.0f));

    /* renamed from: b  reason: collision with root package name */
    private final Path f21128b = new Path();

    /* renamed from: c  reason: collision with root package name */
    private final RectF f21129c = new RectF();

    /* renamed from: d  reason: collision with root package name */
    private int f21130d = f21127a;

    /* renamed from: e  reason: collision with root package name */
    private boolean f21131e = false;

    public e(Context context) {
        super(context);
    }

    /* access modifiers changed from: protected */
    public void onDraw(Canvas canvas) {
        this.f21129c.set(0.0f, 0.0f, (float) getWidth(), (float) getHeight());
        this.f21128b.reset();
        float min = (float) (this.f21131e ? Math.min(getWidth(), getHeight()) / 2 : this.f21130d);
        this.f21128b.addRoundRect(this.f21129c, min, min, Path.Direction.CW);
        canvas.clipPath(this.f21128b);
        super.onDraw(canvas);
    }

    public void setFullCircleCorners(boolean z2) {
        this.f21131e = z2;
    }

    public void setRadius(int i2) {
        this.f21130d = (int) (((float) i2) * x.f20694b);
    }
}
