package com.facebook.ads.internal.view.c;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.graphics.Typeface;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.facebook.ads.internal.q.a.x;

public class b extends RelativeLayout {

    /* renamed from: a  reason: collision with root package name */
    private final Paint f21030a;

    /* renamed from: b  reason: collision with root package name */
    private final RectF f21031b = new RectF();

    public b(Context context, String str) {
        super(context);
        float f2 = context.getResources().getDisplayMetrics().density;
        TextView textView = new TextView(context);
        textView.setTextColor(-16777216);
        textView.setTextSize(16.0f);
        textView.setText(str);
        textView.setTypeface(Typeface.defaultFromStyle(1));
        setGravity(17);
        int i2 = (int) (f2 * 6.0f);
        textView.setPadding(i2, i2, i2, i2);
        addView(textView);
        Paint paint = new Paint();
        this.f21030a = paint;
        paint.setStyle(Paint.Style.FILL);
        paint.setColor(-1);
        x.a((View) this, 0);
    }

    /* access modifiers changed from: protected */
    public void onDraw(Canvas canvas) {
        float f2 = getContext().getResources().getDisplayMetrics().density;
        this.f21031b.set(0.0f, 0.0f, (float) getWidth(), (float) getHeight());
        float f3 = f2 * 10.0f;
        canvas.drawRoundRect(this.f21031b, f3, f3, this.f21030a);
        super.onDraw(canvas);
    }
}
