package com.facebook.ads.internal.view;

import android.content.Context;
import android.view.View;
import com.facebook.ads.internal.view.f.a;

public class t extends a {
    public t(Context context) {
        super(context);
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i2, int i3) {
        if (View.MeasureSpec.getMode(i2) == 1073741824) {
            i3 = i2;
        } else if (View.MeasureSpec.getMode(i3) == 1073741824) {
            i2 = i3;
        }
        super.onMeasure(i2, i3);
    }
}
