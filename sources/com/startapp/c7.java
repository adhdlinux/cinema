package com.startapp;

import android.content.Context;
import com.startapp.sdk.adsbase.StartAppSDKInternal;

public final class c7 implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Context f34287a;

    public c7(Context context) {
        this.f34287a = context;
    }

    public void run() {
        synchronized (StartAppSDKInternal.f36219b) {
            StartAppSDKInternal.a(this.f34287a);
        }
    }
}
