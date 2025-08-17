package com.facebook.ads.internal.view.b;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.text.Layout;
import android.text.StaticLayout;
import android.text.TextPaint;
import android.text.TextUtils;
import com.facebook.ads.internal.r.a;
import com.facebook.imageutils.JfifUtil;
import com.vungle.ads.internal.protos.Sdk$SDKError;
import java.lang.ref.WeakReference;

public class c extends Drawable {

    /* renamed from: a  reason: collision with root package name */
    private final Paint f20917a;

    /* renamed from: b  reason: collision with root package name */
    private final Paint f20918b;

    /* renamed from: c  reason: collision with root package name */
    private final Path f20919c = new Path();

    /* renamed from: d  reason: collision with root package name */
    private final TextPaint f20920d;

    /* renamed from: e  reason: collision with root package name */
    private final Paint f20921e;

    /* renamed from: f  reason: collision with root package name */
    private int f20922f;

    /* renamed from: g  reason: collision with root package name */
    private int f20923g;

    /* renamed from: h  reason: collision with root package name */
    private String f20924h;

    /* renamed from: i  reason: collision with root package name */
    private int f20925i;
    /* access modifiers changed from: private */

    /* renamed from: j  reason: collision with root package name */
    public boolean f20926j;

    /* renamed from: k  reason: collision with root package name */
    private String f20927k;

    /* renamed from: l  reason: collision with root package name */
    private String f20928l;

    /* renamed from: m  reason: collision with root package name */
    private long f20929m;
    /* access modifiers changed from: private */

    /* renamed from: n  reason: collision with root package name */
    public final Handler f20930n;

    /* renamed from: o  reason: collision with root package name */
    private WeakReference<a> f20931o;
    /* access modifiers changed from: private */

    /* renamed from: p  reason: collision with root package name */
    public final Runnable f20932p;

    public c() {
        Paint paint = new Paint();
        this.f20917a = paint;
        Paint paint2 = new Paint();
        this.f20918b = paint2;
        TextPaint textPaint = new TextPaint();
        this.f20920d = textPaint;
        Paint paint3 = new Paint();
        this.f20921e = paint3;
        this.f20930n = new Handler();
        this.f20932p = new Runnable() {
            public void run() {
                c.this.c();
                if (c.this.f20926j) {
                    c.this.f20930n.postDelayed(c.this.f20932p, 250);
                }
            }
        };
        paint.setColor(Color.argb(127, 36, 36, 36));
        paint.setStyle(Paint.Style.FILL_AND_STROKE);
        paint2.setAntiAlias(true);
        paint2.setColor(Color.argb(191, 0, JfifUtil.MARKER_FIRST_BYTE, 0));
        paint2.setStrokeWidth(20.0f);
        paint2.setStyle(Paint.Style.STROKE);
        textPaint.setAntiAlias(true);
        textPaint.setColor(-1);
        textPaint.setStyle(Paint.Style.FILL_AND_STROKE);
        textPaint.setTextSize(30.0f);
        paint3.setColor(Color.argb(Sdk$SDKError.Reason.PLACEMENT_SLEEP_VALUE, 0, 0, 0));
        paint3.setStyle(Paint.Style.FILL_AND_STROKE);
        b();
    }

    /* access modifiers changed from: private */
    public void c() {
        String str;
        StringBuilder sb = new StringBuilder();
        if (this.f20922f <= 0) {
            if (!TextUtils.isEmpty(this.f20927k)) {
                sb.append(this.f20927k);
                sb.append(ReactEditTextInputConnectionWrapper.NEWLINE_RAW_VALUE);
            }
            if (!TextUtils.isEmpty(this.f20928l)) {
                sb.append(this.f20928l);
                sb.append(ReactEditTextInputConnectionWrapper.NEWLINE_RAW_VALUE);
            }
            sb.append("Sdk ");
            sb.append("4.99.1");
            sb.append(", Loaded ");
            if (this.f20929m > 0) {
                long max = Math.max(0, System.currentTimeMillis() - this.f20929m);
                int i2 = (int) (max / 3600000);
                long j2 = max % 3600000;
                int i3 = (int) (j2 / 60000);
                int i4 = (int) ((j2 % 60000) / 1000);
                if (i2 > 0) {
                    sb.append(i2);
                    sb.append("h ");
                }
                if (i2 > 0 || i3 > 0) {
                    sb.append(i3);
                    sb.append("m ");
                }
                sb.append(i4);
                str = "s ago";
            } else {
                str = "Unknown";
            }
            sb.append(str);
        } else {
            sb.append("Card ");
            sb.append(this.f20923g + 1);
            sb.append(" of ");
            sb.append(this.f20922f);
        }
        sb.append("\nView: ");
        WeakReference<a> weakReference = this.f20931o;
        sb.append((weakReference == null || weakReference.get() == null) ? "Viewability Checker not set" : this.f20931o.get().d());
        String sb2 = sb.toString();
        this.f20924h = sb2;
        float f2 = -2.14748365E9f;
        for (String str2 : sb2.split(ReactEditTextInputConnectionWrapper.NEWLINE_RAW_VALUE)) {
            f2 = Math.max(f2, this.f20920d.measureText(str2, 0, str2.length()));
        }
        this.f20925i = (int) (f2 + 0.5f);
        invalidateSelf();
    }

    public void a(int i2, int i3) {
        this.f20922f = i2;
        this.f20923g = i3;
        c();
    }

    public void a(long j2) {
        this.f20929m = j2;
        c();
    }

    public void a(a aVar) {
        this.f20931o = new WeakReference<>(aVar);
        c();
    }

    public void a(String str) {
        this.f20927k = str;
        c();
    }

    public void a(boolean z2) {
        this.f20926j = z2;
        if (z2) {
            this.f20930n.post(this.f20932p);
        } else {
            this.f20930n.removeCallbacks(this.f20932p);
        }
        invalidateSelf();
    }

    public boolean a() {
        return this.f20926j;
    }

    public void b() {
        this.f20922f = 0;
        this.f20923g = -1;
        this.f20924h = "Initializing...";
        this.f20925i = 100;
        this.f20927k = null;
        this.f20929m = -1;
        this.f20931o = null;
        a(false);
    }

    public void b(String str) {
        this.f20928l = str;
        c();
    }

    public void draw(Canvas canvas) {
        Canvas canvas2 = canvas;
        if (this.f20926j) {
            float width = (float) canvas.getWidth();
            float height = (float) canvas.getHeight();
            canvas.drawRect(0.0f, 0.0f, width, height, this.f20917a);
            StaticLayout staticLayout = new StaticLayout(this.f20924h, this.f20920d, this.f20925i, Layout.Alignment.ALIGN_CENTER, 1.0f, 0.0f, false);
            float f2 = width / 2.0f;
            float f3 = height / 2.0f;
            float width2 = ((float) staticLayout.getWidth()) / 2.0f;
            float height2 = ((float) staticLayout.getHeight()) / 2.0f;
            float f4 = f2 - width2;
            float f5 = f3 - height2;
            canvas.drawRect(f4 - 40.0f, f5 - 40.0f, f2 + width2 + 40.0f, f3 + height2 + 40.0f, this.f20921e);
            canvas.save();
            canvas2.translate(f4, f5);
            staticLayout.draw(canvas2);
            canvas.restore();
            this.f20919c.reset();
            this.f20919c.moveTo(0.0f, 0.0f);
            this.f20919c.lineTo(width, 0.0f);
            this.f20919c.lineTo(width, height);
            this.f20919c.lineTo(0.0f, height);
            this.f20919c.lineTo(0.0f, 0.0f);
            canvas2.drawPath(this.f20919c, this.f20918b);
        }
    }

    public int getOpacity() {
        return -3;
    }

    public void setAlpha(int i2) {
    }

    public void setColorFilter(ColorFilter colorFilter) {
    }
}
