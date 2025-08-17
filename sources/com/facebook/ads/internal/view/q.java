package com.facebook.ads.internal.view;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.widget.TextView;
import com.facebook.ads.internal.q.a.x;

public class q extends TextView {

    /* renamed from: a  reason: collision with root package name */
    private float f21709a;

    /* renamed from: b  reason: collision with root package name */
    private float f21710b = 8.0f;

    public q(Context context) {
        super(context);
        super.setSingleLine();
        super.setMaxLines(1);
        this.f21709a = getTextSize() / x.f20694b;
        setEllipsize(TextUtils.TruncateAt.END);
    }

    /* access modifiers changed from: protected */
    public void onLayout(boolean z2, int i2, int i3, int i4, int i5) {
        int i6 = i4 - i2;
        int measuredHeight = getMeasuredHeight();
        int measuredWidth = getMeasuredWidth();
        for (float f2 = this.f21709a; f2 >= this.f21710b; f2 -= 0.5f) {
            super.setTextSize(f2);
            measure(0, 0);
            if (getMeasuredWidth() <= i6) {
                break;
            }
        }
        if (getMeasuredWidth() > i6) {
            measure(View.MeasureSpec.makeMeasureSpec(measuredWidth, 1073741824), View.MeasureSpec.makeMeasureSpec(measuredHeight, 1073741824));
        }
        setMeasuredDimension(measuredWidth, measuredHeight);
        super.onLayout(z2, i2, i3, i4, i5);
    }

    public void setMaxLines(int i2) {
    }

    public void setMinTextSize(float f2) {
        if (f2 <= this.f21709a) {
            this.f21710b = f2;
        }
    }

    public void setSingleLine(boolean z2) {
    }

    public void setTextSize(float f2) {
        this.f21709a = f2;
        super.setTextSize(f2);
    }
}
