package com.chartboost.sdk.impl;

import android.content.Context;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.util.Log;
import com.google.android.gms.appset.AppSet;
import com.google.android.gms.tasks.Task;

public class y0 {

    /* renamed from: b  reason: collision with root package name */
    public static y0 f19027b = new y0(new Handler(Looper.getMainLooper()));

    /* renamed from: a  reason: collision with root package name */
    public final Handler f19028a;

    public y0(Handler handler) {
        this.f19028a = handler;
    }

    public static y0 b() {
        return f19027b;
    }

    public String a() {
        return Build.VERSION.RELEASE;
    }

    public Task a(Context context) {
        try {
            return AppSet.getClient(context).getAppSetIdInfo();
        } catch (Exception e2) {
            Log.e("CBAndroid", "Cannot retrieve appSetId client: " + e2);
            return null;
        }
    }

    public boolean a(CharSequence charSequence) {
        return TextUtils.isEmpty(charSequence);
    }
}
