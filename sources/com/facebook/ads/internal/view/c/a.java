package com.facebook.ads.internal.view.c;

import android.content.ActivityNotFoundException;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.graphics.Typeface;
import android.net.Uri;
import android.util.Log;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.facebook.ads.internal.a.b;
import com.facebook.ads.internal.m.c;
import com.facebook.ads.internal.q.a.x;
import java.util.HashMap;

public class a extends RelativeLayout {
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with root package name */
    public final String f20945a;
    /* access modifiers changed from: private */

    /* renamed from: b  reason: collision with root package name */
    public com.facebook.ads.internal.view.f.a f20946b;

    /* renamed from: c  reason: collision with root package name */
    private final Paint f20947c;

    /* renamed from: d  reason: collision with root package name */
    private final RectF f20948d = new RectF();

    public a(Context context, String str, String str2, int i2, com.facebook.ads.internal.view.f.a aVar, final c cVar, final String str3) {
        super(context);
        this.f20945a = str;
        this.f20946b = aVar;
        TextView textView = new TextView(context);
        textView.setTextColor(-1);
        textView.setTextSize(16.0f);
        textView.setText(str2);
        textView.setTypeface(Typeface.defaultFromStyle(1));
        setGravity(17);
        addView(textView);
        Paint paint = new Paint();
        this.f20947c = paint;
        paint.setStyle(Paint.Style.FILL);
        paint.setColor(i2);
        x.a((View) this, 0);
        setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                String str;
                String str2;
                Class<a> cls = a.class;
                try {
                    Uri parse = Uri.parse(a.this.f20945a);
                    a.this.f20946b.getEventBus().a(new com.facebook.ads.internal.view.f.b.a(parse));
                    b a2 = com.facebook.ads.internal.a.c.a(a.this.getContext(), cVar, str3, parse, new HashMap());
                    if (a2 != null) {
                        a2.b();
                    }
                } catch (ActivityNotFoundException e2) {
                    e = e2;
                    str = String.valueOf(cls);
                    str2 = "Error while opening " + a.this.f20945a;
                    Log.e(str, str2, e);
                } catch (Exception e3) {
                    e = e3;
                    str = String.valueOf(cls);
                    str2 = "Error executing action";
                    Log.e(str, str2, e);
                }
            }
        });
    }

    /* access modifiers changed from: protected */
    public void onDraw(Canvas canvas) {
        float f2 = getContext().getResources().getDisplayMetrics().density;
        this.f20948d.set(0.0f, 0.0f, (float) getWidth(), (float) getHeight());
        float f3 = f2 * 10.0f;
        canvas.drawRoundRect(this.f20948d, f3, f3, this.f20947c);
        super.onDraw(canvas);
    }
}
