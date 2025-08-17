package com.google.android.datatransport.runtime.scheduling.jobscheduling;

import com.google.android.datatransport.runtime.TransportContext;

public final /* synthetic */ class c implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Uploader f22670b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ TransportContext f22671c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ int f22672d;

    /* renamed from: e  reason: collision with root package name */
    public final /* synthetic */ Runnable f22673e;

    public /* synthetic */ c(Uploader uploader, TransportContext transportContext, int i2, Runnable runnable) {
        this.f22670b = uploader;
        this.f22671c = transportContext;
        this.f22672d = i2;
        this.f22673e = runnable;
    }

    public final void run() {
        this.f22670b.t(this.f22671c, this.f22672d, this.f22673e);
    }
}
