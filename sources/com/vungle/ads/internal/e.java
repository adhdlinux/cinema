package com.vungle.ads.internal;

import com.vungle.ads.VungleError;

public final /* synthetic */ class e implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ VungleInitializer f37851b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ VungleError f37852c;

    public /* synthetic */ e(VungleInitializer vungleInitializer, VungleError vungleError) {
        this.f37851b = vungleInitializer;
        this.f37852c = vungleError;
    }

    public final void run() {
        VungleInitializer.m162onInitError$lambda12(this.f37851b, this.f37852c);
    }
}
