package com.startapp;

import com.startapp.sdk.adsbase.remoteconfig.MetaDataRequest;

public final class ca implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ da f34299a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ MetaDataRequest.RequestReason f34300b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ boolean f34301c;

    public ca(da daVar, MetaDataRequest.RequestReason requestReason, boolean z2) {
        this.f34299a = daVar;
        this.f34300b = requestReason;
        this.f34301c = z2;
    }

    public void run() {
        this.f34299a.a(this.f34300b, this.f34301c);
    }
}
