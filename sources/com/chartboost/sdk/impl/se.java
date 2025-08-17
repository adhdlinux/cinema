package com.chartboost.sdk.impl;

import android.text.TextUtils;
import android.util.Log;

public abstract class se {
    public static void a(String str) {
        if (zd.f19139a.booleanValue() && !TextUtils.isEmpty(str)) {
            Log.i("OMIDLIB", str);
        }
    }

    public static void a(String str, Exception exc) {
        if ((zd.f19139a.booleanValue() && !TextUtils.isEmpty(str)) || exc != null) {
            Log.e("OMIDLIB", str, exc);
        }
    }
}
