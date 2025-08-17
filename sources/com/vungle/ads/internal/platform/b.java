package com.vungle.ads.internal.platform;

import androidx.core.util.Consumer;

public final /* synthetic */ class b implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ AndroidPlatform f37903b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ Consumer f37904c;

    public /* synthetic */ b(AndroidPlatform androidPlatform, Consumer consumer) {
        this.f37903b = androidPlatform;
        this.f37904c = consumer;
    }

    public final void run() {
        AndroidPlatform.m195getUserAgentLazy$lambda0(this.f37903b, this.f37904c);
    }
}
