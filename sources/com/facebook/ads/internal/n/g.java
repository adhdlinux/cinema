package com.facebook.ads.internal.n;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.RelativeLayout;

public abstract class g extends RelativeLayout {
    public g(Context context) {
        super(context);
    }

    public g(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public g(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
    }

    public g(Context context, AttributeSet attributeSet, int i2, int i3) {
        super(context, attributeSet, i2, i3);
    }

    /* access modifiers changed from: protected */
    public abstract View getAdContentsView();
}
