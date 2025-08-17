package com.applovin.impl.adview;

import android.annotation.SuppressLint;
import android.content.Context;
import com.applovin.impl.adview.i;

@SuppressLint({"ViewConstructor"})
public final class p extends i {
    public p(Context context) {
        super(context);
    }

    public void a(int i2) {
        setViewScale(((float) i2) / 30.0f);
    }

    public i.a getStyle() {
        return i.a.INVISIBLE;
    }
}
