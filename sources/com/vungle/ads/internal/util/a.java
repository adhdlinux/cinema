package com.vungle.ads.internal.util;

import android.content.Context;

public final /* synthetic */ class a implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Context f37935b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ ActivityManager f37936c;

    public /* synthetic */ a(Context context, ActivityManager activityManager) {
        this.f37935b = context;
        this.f37936c = activityManager;
    }

    public final void run() {
        ActivityManager.m222init$lambda0(this.f37935b, this.f37936c);
    }
}
