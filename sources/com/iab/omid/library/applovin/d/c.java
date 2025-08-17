package com.iab.omid.library.applovin.d;

import android.text.TextUtils;
import android.util.Log;
import com.iab.omid.library.applovin.a;

public final class c {
    public static void a(String str) {
        if (a.f31463a.booleanValue() && !TextUtils.isEmpty(str)) {
            Log.i("OMIDLIB", str);
        }
    }

    public static void a(String str, Exception exc) {
        if ((a.f31463a.booleanValue() && !TextUtils.isEmpty(str)) || exc != null) {
            Log.e("OMIDLIB", str, exc);
        }
    }
}
