package com.facebook.ads.internal.view.f.c;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.view.View;
import android.widget.ImageView;
import com.facebook.ads.internal.q.b.c;
import com.facebook.ads.internal.view.f.a;
import com.facebook.ads.internal.view.f.a.b;
import com.facebook.ads.internal.view.f.b.v;
import com.facebook.ads.internal.view.f.b.w;

public class f extends ImageView implements b {

    /* renamed from: a  reason: collision with root package name */
    private static final int f21396a = ((int) (Resources.getSystem().getDisplayMetrics().density * 4.0f));

    /* renamed from: b  reason: collision with root package name */
    private final Paint f21397b;
    /* access modifiers changed from: private */

    /* renamed from: c  reason: collision with root package name */
    public a f21398c;

    /* renamed from: d  reason: collision with root package name */
    private final w f21399d = new w() {
        public void a(v vVar) {
            f.this.a();
        }
    };

    public f(Context context) {
        super(context);
        Paint paint = new Paint();
        this.f21397b = paint;
        paint.setColor(-1728053248);
        setColorFilter(-1);
        int i2 = f21396a;
        setPadding(i2, i2, i2, i2);
        c();
        setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                a aVar;
                float f2;
                if (f.this.f21398c != null) {
                    if (f.this.b()) {
                        aVar = f.this.f21398c;
                        f2 = 1.0f;
                    } else {
                        aVar = f.this.f21398c;
                        f2 = 0.0f;
                    }
                    aVar.setVolume(f2);
                    f.this.a();
                }
            }
        });
    }

    /* access modifiers changed from: private */
    public boolean b() {
        a aVar = this.f21398c;
        return aVar != null && aVar.getVolume() == 0.0f;
    }

    private void c() {
        setImageBitmap(c.a(com.facebook.ads.internal.q.b.b.SOUND_ON));
    }

    private void d() {
        setImageBitmap(c.a(com.facebook.ads.internal.q.b.b.SOUND_OFF));
    }

    public final void a() {
        if (this.f21398c != null) {
            if (b()) {
                d();
            } else {
                c();
            }
        }
    }

    public void a(a aVar) {
        this.f21398c = aVar;
        if (aVar != null) {
            aVar.getEventBus().a(this.f21399d);
        }
    }

    public void b(a aVar) {
        a aVar2 = this.f21398c;
        if (aVar2 != null) {
            aVar2.getEventBus().b(this.f21399d);
        }
        this.f21398c = null;
    }

    /* access modifiers changed from: protected */
    public void onDraw(Canvas canvas) {
        int width = getWidth() / 2;
        int height = getHeight() / 2;
        canvas.drawCircle((float) width, (float) height, (float) Math.min(width, height), this.f21397b);
        super.onDraw(canvas);
    }
}
