package com.facebook.ads.internal.view.component;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Path;
import android.graphics.RectF;
import android.view.View;
import android.widget.RelativeLayout;
import com.facebook.ads.internal.q.a.x;

public class f extends RelativeLayout {

    /* renamed from: a  reason: collision with root package name */
    private static final int f21132a = ((int) (x.f20694b * 4.0f));

    /* renamed from: b  reason: collision with root package name */
    private final Path f21133b = new Path();

    /* renamed from: c  reason: collision with root package name */
    private final RectF f21134c = new RectF();

    public f(Context context) {
        super(context);
        x.a((View) this, 0);
    }

    /* access modifiers changed from: protected */
    public void onDraw(Canvas canvas) {
        this.f21134c.set(0.0f, 0.0f, (float) getWidth(), (float) getHeight());
        this.f21133b.reset();
        Path path = this.f21133b;
        RectF rectF = this.f21134c;
        int i2 = f21132a;
        path.addRoundRect(rectF, (float) i2, (float) i2, Path.Direction.CW);
        canvas.clipPath(this.f21133b);
        super.onDraw(canvas);
    }
}
