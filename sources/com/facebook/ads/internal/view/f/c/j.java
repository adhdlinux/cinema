package com.facebook.ads.internal.view.f.c;

import android.content.Context;
import android.graphics.BlurMaskFilter;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.view.View;
import com.facebook.ads.internal.j.f;
import com.facebook.ads.internal.view.f.a.b;
import com.facebook.ads.internal.view.f.b.c;
import com.facebook.ads.internal.view.f.b.l;
import com.facebook.ads.internal.view.f.b.m;
import com.facebook.ads.internal.view.f.b.n;
import com.facebook.ads.internal.view.f.b.o;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;

public class j extends View implements b {

    /* renamed from: a  reason: collision with root package name */
    private final Paint f21427a;

    /* renamed from: b  reason: collision with root package name */
    private final Paint f21428b;

    /* renamed from: c  reason: collision with root package name */
    private final Paint f21429c;

    /* renamed from: d  reason: collision with root package name */
    private a f21430d = a.CLOSE_BUTTON_MODE;

    /* renamed from: e  reason: collision with root package name */
    private final Paint f21431e;

    /* renamed from: f  reason: collision with root package name */
    private final RectF f21432f;
    /* access modifiers changed from: private */

    /* renamed from: g  reason: collision with root package name */
    public com.facebook.ads.internal.view.f.a f21433g;
    /* access modifiers changed from: private */

    /* renamed from: h  reason: collision with root package name */
    public int f21434h;
    /* access modifiers changed from: private */

    /* renamed from: i  reason: collision with root package name */
    public final AtomicInteger f21435i = new AtomicInteger(0);
    /* access modifiers changed from: private */

    /* renamed from: j  reason: collision with root package name */
    public final AtomicBoolean f21436j = new AtomicBoolean(false);

    /* renamed from: k  reason: collision with root package name */
    private final m f21437k = new m() {
        public void a(l lVar) {
            j.this.f21436j.set(true);
        }
    };

    /* renamed from: l  reason: collision with root package name */
    private final o f21438l = new o() {
        public void a(n nVar) {
            if (j.this.f21433g != null) {
                int c2 = j.this.f21434h;
                int duration = j.this.f21433g.getDuration();
                if (c2 <= 0) {
                    j.this.f21435i.set(0);
                } else {
                    int min = Math.min(duration, c2 * 1000);
                    if (min != 0) {
                        j.this.f21435i.set(((min - j.this.f21433g.getCurrentPositionInMillis()) * 100) / min);
                    } else {
                        return;
                    }
                }
                j.this.postInvalidate();
            }
        }
    };

    /* renamed from: m  reason: collision with root package name */
    private final c f21439m = new c() {
        public void a(com.facebook.ads.internal.view.f.b.b bVar) {
            int unused = j.this.f21434h = 0;
            j.this.f21435i.set(0);
            j.this.postInvalidate();
        }
    };

    public enum a {
        CLOSE_BUTTON_MODE,
        SKIP_BUTTON_MODE
    }

    public j(Context context, int i2, int i3) {
        super(context);
        float f2 = getResources().getDisplayMetrics().density;
        this.f21434h = i2;
        Paint paint = new Paint();
        this.f21428b = paint;
        paint.setStyle(Paint.Style.FILL);
        paint.setColor(i3);
        Paint paint2 = new Paint();
        this.f21429c = paint2;
        paint2.setColor(-1);
        paint2.setAlpha(230);
        paint2.setStyle(Paint.Style.FILL);
        paint2.setStrokeWidth(1.0f * f2);
        paint2.setAntiAlias(true);
        Paint paint3 = new Paint();
        this.f21427a = paint3;
        paint3.setColor(-16777216);
        paint3.setStyle(Paint.Style.STROKE);
        paint3.setAlpha(102);
        paint3.setStrokeWidth(1.5f * f2);
        paint3.setAntiAlias(true);
        setLayerType(1, (Paint) null);
        paint3.setMaskFilter(new BlurMaskFilter(6.0f, BlurMaskFilter.Blur.NORMAL));
        Paint paint4 = new Paint();
        this.f21431e = paint4;
        paint4.setColor(-10066330);
        paint4.setStyle(Paint.Style.STROKE);
        paint4.setStrokeWidth(f2 * 2.0f);
        paint4.setAntiAlias(true);
        this.f21432f = new RectF();
    }

    public void a(com.facebook.ads.internal.view.f.a aVar) {
        this.f21433g = aVar;
        aVar.getEventBus().a((T[]) new f[]{this.f21437k, this.f21438l, this.f21439m});
    }

    public boolean a() {
        return this.f21433g != null && (this.f21434h <= 0 || this.f21435i.get() < 0);
    }

    public void b(com.facebook.ads.internal.view.f.a aVar) {
        this.f21433g.getEventBus().b((T[]) new f[]{this.f21439m, this.f21438l, this.f21437k});
        this.f21433g = null;
    }

    public int getSkipSeconds() {
        return this.f21434h;
    }

    /* access modifiers changed from: protected */
    public void onDraw(Canvas canvas) {
        if (!this.f21436j.get()) {
            super.onDraw(canvas);
            return;
        }
        int min = Math.min((getWidth() - getPaddingLeft()) - getPaddingRight(), (getHeight() - getPaddingTop()) - getPaddingBottom());
        int i2 = min / 2;
        float f2 = (float) i2;
        canvas.drawCircle((float) (getPaddingLeft() + i2), (float) (getPaddingTop() + i2), f2, this.f21427a);
        canvas.drawCircle((float) (getPaddingLeft() + i2), (float) (getPaddingTop() + i2), f2, this.f21429c);
        if (this.f21435i.get() > 0) {
            this.f21432f.set((float) getPaddingLeft(), (float) getPaddingTop(), (float) (getWidth() - getPaddingRight()), (float) (getHeight() - getPaddingBottom()));
            canvas.drawArc(this.f21432f, -90.0f, ((float) (-(this.f21435i.get() * 360))) / 100.0f, true, this.f21428b);
        } else if (this.f21430d == a.SKIP_BUTTON_MODE) {
            int i3 = min / 4;
            int i4 = min / 3;
            Path path = new Path();
            path.moveTo((float) (getPaddingLeft() + i3), (float) (getPaddingTop() + i4));
            path.lineTo((float) (getPaddingLeft() + i2), (float) (getPaddingTop() + i2));
            int i5 = i4 * 2;
            path.lineTo((float) (getPaddingLeft() + i3), (float) (getPaddingTop() + i5));
            canvas.drawPath(path, this.f21431e);
            Path path2 = new Path();
            path2.moveTo((float) (getPaddingLeft() + i2), (float) (i4 + getPaddingTop()));
            path2.lineTo((float) ((i3 * 3) + getPaddingLeft()), (float) (getPaddingTop() + i2));
            path2.lineTo((float) (i2 + getPaddingLeft()), (float) (i5 + getPaddingTop()));
            canvas.drawPath(path2, this.f21431e);
        } else {
            int i6 = min / 3;
            int i7 = i6 * 2;
            Canvas canvas2 = canvas;
            canvas2.drawLine((float) (getPaddingLeft() + i6), (float) (getPaddingTop() + i6), (float) (getPaddingLeft() + i7), (float) (getPaddingTop() + i7), this.f21431e);
            canvas.drawLine((float) (getPaddingLeft() + i7), (float) (getPaddingTop() + i6), (float) (i6 + getPaddingLeft()), (float) (i7 + getPaddingTop()), this.f21431e);
        }
        super.onDraw(canvas);
    }

    public void setButtonMode(a aVar) {
        this.f21430d = aVar;
    }
}
