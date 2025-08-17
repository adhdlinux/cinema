package com.startapp;

import android.content.Context;
import com.startapp.sdk.adsbase.Ad;
import com.startapp.sdk.adsbase.adlisteners.AdDisplayListener;

public final class m7 implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ AdDisplayListener f34903a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Ad f34904b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ Context f34905c;

    public m7(AdDisplayListener adDisplayListener, Ad ad, Context context) {
        this.f34903a = adDisplayListener;
        this.f34904b = ad;
        this.f34905c = context;
    }

    public void run() {
        try {
            this.f34903a.adNotDisplayed(this.f34904b);
        } catch (Throwable th) {
            lb.a(this.f34905c, (Object) this.f34903a, th);
        }
    }
}
