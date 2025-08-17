package com.startapp;

import android.content.Context;
import com.startapp.sdk.adsbase.Ad;
import com.startapp.sdk.adsbase.adlisteners.AdDisplayListener;

public final class k7 implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ AdDisplayListener f34833a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Ad f34834b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ Context f34835c;

    public k7(AdDisplayListener adDisplayListener, Ad ad, Context context) {
        this.f34833a = adDisplayListener;
        this.f34834b = ad;
        this.f34835c = context;
    }

    public void run() {
        try {
            this.f34833a.adDisplayed(this.f34834b);
        } catch (Throwable th) {
            lb.a(this.f34835c, (Object) this.f34833a, th);
        }
    }
}
