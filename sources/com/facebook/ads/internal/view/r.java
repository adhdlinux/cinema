package com.facebook.ads.internal.view;

import android.content.Context;
import android.widget.RelativeLayout;

public class r extends RelativeLayout {

    /* renamed from: a  reason: collision with root package name */
    private int f21711a = 0;

    /* renamed from: b  reason: collision with root package name */
    private int f21712b = 0;

    public r(Context context) {
        super(context);
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i2, int i3) {
        int i4;
        super.onMeasure(i2, i3);
        if ((this.f21712b > 0 && getMeasuredWidth() > (i4 = this.f21712b)) || getMeasuredWidth() < (i4 = this.f21711a)) {
            setMeasuredDimension(i4, getMeasuredHeight());
        }
    }

    public void setMaxWidth(int i2) {
        this.f21712b = i2;
    }

    public void setMinWidth(int i2) {
        this.f21711a = i2;
    }
}
