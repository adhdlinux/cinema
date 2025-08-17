package com.facebook.ads.internal.view.f.c;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.facebook.ads.internal.j.f;
import com.facebook.ads.internal.q.a.x;
import com.facebook.ads.internal.view.f.a.c;
import com.facebook.ads.internal.view.f.b.n;
import java.util.concurrent.atomic.AtomicBoolean;

public class i extends c {
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with root package name */
    public final a f21416a;
    /* access modifiers changed from: private */

    /* renamed from: b  reason: collision with root package name */
    public final int f21417b;
    /* access modifiers changed from: private */

    /* renamed from: c  reason: collision with root package name */
    public final String f21418c;
    /* access modifiers changed from: private */

    /* renamed from: d  reason: collision with root package name */
    public final String f21419d;
    /* access modifiers changed from: private */

    /* renamed from: e  reason: collision with root package name */
    public final AtomicBoolean f21420e;

    /* renamed from: f  reason: collision with root package name */
    private final f<n> f21421f = new f<n>() {
        public Class<n> a() {
            return n.class;
        }

        public void a(n nVar) {
            if (!i.this.f21420e.get() && i.this.getVideoView() != null) {
                int c2 = i.this.f21417b - (i.this.getVideoView().getCurrentPositionInMillis() / 1000);
                if (c2 > 0) {
                    a f2 = i.this.f21416a;
                    f2.setText(i.this.f21418c + ' ' + c2);
                    return;
                }
                i.this.f21416a.setText(i.this.f21419d);
                i.this.f21420e.set(true);
            }
        }
    };

    private static class a extends TextView {

        /* renamed from: a  reason: collision with root package name */
        private final Paint f21424a;

        /* renamed from: b  reason: collision with root package name */
        private final Paint f21425b;

        /* renamed from: c  reason: collision with root package name */
        private final RectF f21426c = new RectF();

        public a(Context context) {
            super(context);
            DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
            x.a((View) this, 0);
            setTextColor(-3355444);
            float f2 = displayMetrics.density;
            setPadding((int) (f2 * 9.0f), (int) (f2 * 5.0f), (int) (9.0f * f2), (int) (f2 * 5.0f));
            setTextSize(18.0f);
            Paint paint = new Paint();
            this.f21424a = paint;
            paint.setStyle(Paint.Style.STROKE);
            paint.setColor(-10066330);
            paint.setStrokeWidth(1.0f);
            paint.setAntiAlias(true);
            Paint paint2 = new Paint();
            this.f21425b = paint2;
            paint2.setStyle(Paint.Style.FILL);
            paint2.setColor(-1895825408);
        }

        /* access modifiers changed from: protected */
        public void onDraw(Canvas canvas) {
            if (getText().length() != 0) {
                int width = getWidth();
                int height = getHeight();
                float f2 = (float) 0;
                this.f21426c.set(f2, f2, (float) width, (float) height);
                canvas.drawRoundRect(this.f21426c, 6.0f, 6.0f, this.f21425b);
                float f3 = (float) 2;
                this.f21426c.set(f3, f3, (float) (width - 2), (float) (height - 2));
                canvas.drawRoundRect(this.f21426c, 6.0f, 6.0f, this.f21424a);
                super.onDraw(canvas);
            }
        }
    }

    public i(Context context, int i2, String str, String str2) {
        super(context);
        this.f21417b = i2;
        this.f21418c = str;
        this.f21419d = str2;
        this.f21420e = new AtomicBoolean(false);
        a aVar = new a(context);
        this.f21416a = aVar;
        aVar.setText(str + ' ' + i2);
        addView(aVar, new RelativeLayout.LayoutParams(-2, -2));
    }

    public void a() {
        super.a();
        if (getVideoView() != null) {
            getVideoView().getEventBus().a(this.f21421f);
        }
        this.f21416a.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                if (!i.this.f21420e.get()) {
                    Log.i("SkipPlugin", "User clicked skip before the ads is allowed to skip.");
                } else if (i.this.getVideoView() != null) {
                    i.this.getVideoView().e();
                }
            }
        });
    }

    public void b() {
        if (getVideoView() != null) {
            this.f21416a.setOnClickListener((View.OnClickListener) null);
            getVideoView().getEventBus().b(this.f21421f);
        }
        super.b();
    }
}
