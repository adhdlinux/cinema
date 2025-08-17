package com.facebook.ads.internal.view.f.c;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.net.Uri;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.facebook.ads.internal.a.b;
import com.facebook.ads.internal.q.a.x;
import com.facebook.ads.internal.view.f.a.c;
import com.facebook.ads.internal.view.f.b.a;
import java.util.HashMap;

public class e extends c {
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with root package name */
    public final String f21389a;

    /* renamed from: b  reason: collision with root package name */
    private final TextView f21390b;
    /* access modifiers changed from: private */

    /* renamed from: c  reason: collision with root package name */
    public final com.facebook.ads.internal.m.c f21391c;
    /* access modifiers changed from: private */

    /* renamed from: d  reason: collision with root package name */
    public final String f21392d;

    /* renamed from: e  reason: collision with root package name */
    private final Paint f21393e;

    /* renamed from: f  reason: collision with root package name */
    private final RectF f21394f = new RectF();

    public e(Context context, String str, com.facebook.ads.internal.m.c cVar, String str2, String str3) {
        super(context);
        this.f21389a = str;
        this.f21391c = cVar;
        this.f21392d = str2;
        DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
        TextView textView = new TextView(getContext());
        this.f21390b = textView;
        textView.setTextColor(-3355444);
        textView.setTextSize(16.0f);
        float f2 = displayMetrics.density;
        textView.setPadding((int) (f2 * 6.0f), (int) (f2 * 4.0f), (int) (6.0f * f2), (int) (f2 * 4.0f));
        Paint paint = new Paint();
        this.f21393e = paint;
        paint.setStyle(Paint.Style.FILL);
        paint.setColor(-16777216);
        paint.setAlpha(178);
        x.a((View) this, 0);
        textView.setText(str3);
        addView(textView, new RelativeLayout.LayoutParams(-2, -2));
    }

    /* access modifiers changed from: protected */
    public void a() {
        super.a();
        this.f21390b.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                if (e.this.getVideoView() != null) {
                    Uri parse = Uri.parse(e.this.f21389a);
                    e.this.getVideoView().getEventBus().a(new a(parse));
                    b a2 = com.facebook.ads.internal.a.c.a(e.this.getContext(), e.this.f21391c, e.this.f21392d, parse, new HashMap());
                    if (a2 != null) {
                        a2.b();
                    }
                }
            }
        });
    }

    /* access modifiers changed from: protected */
    public void b() {
        this.f21390b.setOnClickListener((View.OnClickListener) null);
        super.b();
    }

    /* access modifiers changed from: protected */
    public void onDraw(Canvas canvas) {
        this.f21394f.set(0.0f, 0.0f, (float) getWidth(), (float) getHeight());
        canvas.drawRoundRect(this.f21394f, 0.0f, 0.0f, this.f21393e);
        super.onDraw(canvas);
    }
}
