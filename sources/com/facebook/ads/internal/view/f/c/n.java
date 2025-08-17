package com.facebook.ads.internal.view.f.c;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.view.View;
import com.facebook.ads.internal.j.f;
import com.facebook.ads.internal.view.f.a;
import com.facebook.ads.internal.view.f.a.b;
import com.facebook.ads.internal.view.f.b.c;
import com.facebook.ads.internal.view.f.b.o;

public class n extends View implements b {

    /* renamed from: a  reason: collision with root package name */
    private final Paint f21465a;

    /* renamed from: b  reason: collision with root package name */
    private final Rect f21466b;
    /* access modifiers changed from: private */

    /* renamed from: c  reason: collision with root package name */
    public float f21467c;

    /* renamed from: d  reason: collision with root package name */
    private final o f21468d = new o() {
        public void a(com.facebook.ads.internal.view.f.b.n nVar) {
            if (n.this.f21470f != null) {
                int duration = n.this.f21470f.getDuration();
                if (duration > 0) {
                    n nVar2 = n.this;
                    float unused = nVar2.f21467c = ((float) nVar2.f21470f.getCurrentPositionInMillis()) / ((float) duration);
                } else {
                    float unused2 = n.this.f21467c = 0.0f;
                }
                n.this.postInvalidate();
            }
        }
    };

    /* renamed from: e  reason: collision with root package name */
    private final c f21469e = new c() {
        public void a(com.facebook.ads.internal.view.f.b.b bVar) {
            if (n.this.f21470f != null) {
                float unused = n.this.f21467c = 0.0f;
                n.this.postInvalidate();
            }
        }
    };
    /* access modifiers changed from: private */

    /* renamed from: f  reason: collision with root package name */
    public a f21470f;

    public n(Context context) {
        super(context);
        Paint paint = new Paint();
        this.f21465a = paint;
        paint.setStyle(Paint.Style.FILL);
        paint.setColor(-9528840);
        this.f21466b = new Rect();
    }

    public void a(a aVar) {
        this.f21470f = aVar;
        aVar.getEventBus().a((T[]) new f[]{this.f21468d, this.f21469e});
    }

    public void b(a aVar) {
        aVar.getEventBus().b((T[]) new f[]{this.f21469e, this.f21468d});
        this.f21470f = null;
    }

    public void draw(Canvas canvas) {
        this.f21466b.set(0, 0, (int) (((float) getWidth()) * this.f21467c), getHeight());
        canvas.drawRect(this.f21466b, this.f21465a);
        super.draw(canvas);
    }
}
