package com.startapp;

import android.content.Context;
import com.startapp.sdk.adsbase.SDKAdPreferences;
import com.startapp.sdk.adsbase.StartAppSDKInternal;

public class d7 implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Context f34348a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ String f34349b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ String f34350c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ SDKAdPreferences f34351d;

    /* renamed from: e  reason: collision with root package name */
    public final /* synthetic */ boolean f34352e;

    /* renamed from: f  reason: collision with root package name */
    public final /* synthetic */ StartAppSDKInternal f34353f;

    public d7(StartAppSDKInternal startAppSDKInternal, Context context, String str, String str2, SDKAdPreferences sDKAdPreferences, boolean z2) {
        this.f34353f = startAppSDKInternal;
        this.f34348a = context;
        this.f34349b = str;
        this.f34350c = str2;
        this.f34351d = sDKAdPreferences;
        this.f34352e = z2;
    }

    public void run() {
        synchronized (StartAppSDKInternal.f36219b) {
            StartAppSDKInternal.a(this.f34353f, this.f34348a, this.f34349b, this.f34350c, this.f34351d, this.f34352e);
        }
    }
}
