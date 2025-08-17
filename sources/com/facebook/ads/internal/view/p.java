package com.facebook.ads.internal.view;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.widget.TextView;

public class p extends TextView {

    /* renamed from: a  reason: collision with root package name */
    private int f21706a;

    /* renamed from: b  reason: collision with root package name */
    private float f21707b;

    /* renamed from: c  reason: collision with root package name */
    private float f21708c = 8.0f;

    public p(Context context, int i2) {
        super(context);
        setMaxLines(i2);
        setEllipsize(TextUtils.TruncateAt.END);
    }

    /* access modifiers changed from: protected */
    public void onLayout(boolean z2, int i2, int i3, int i4, int i5) {
        super.setMaxLines(this.f21706a + 1);
        super.setTextSize(this.f21707b);
        int i6 = i4 - i2;
        int i7 = i5 - i3;
        measure(View.MeasureSpec.makeMeasureSpec(i6, 1073741824), View.MeasureSpec.makeMeasureSpec(i7, 0));
        if (getMeasuredHeight() > i7) {
            float f2 = this.f21707b;
            while (f2 > this.f21708c) {
                f2 -= 0.5f;
                super.setTextSize(f2);
                measure(View.MeasureSpec.makeMeasureSpec(i6, 1073741824), 0);
                if (getMeasuredHeight() <= i7 && getLineCount() <= this.f21706a) {
                    break;
                }
            }
        }
        super.setMaxLines(this.f21706a);
        setMeasuredDimension(i6, i7);
        super.onLayout(z2, i2, i3, i4, i5);
    }

    public void setMaxLines(int i2) {
        this.f21706a = i2;
        super.setMaxLines(i2);
    }

    public void setMinTextSize(float f2) {
        this.f21708c = f2;
    }

    public void setTextSize(float f2) {
        this.f21707b = f2;
        super.setTextSize(f2);
    }
}
