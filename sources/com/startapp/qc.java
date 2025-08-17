package com.startapp;

import com.startapp.sdk.adsbase.crashreport.ANRRemoteConfig;
import com.startapp.sdk.components.ComponentLocator;
import com.startapp.u8;

public class qc implements u8.e {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ ANRRemoteConfig f35721a;

    public qc(ComponentLocator.v vVar, ANRRemoteConfig aNRRemoteConfig) {
        this.f35721a = aNRRemoteConfig;
    }

    public long a(long j2) {
        return this.f35721a.b() - j2;
    }
}
