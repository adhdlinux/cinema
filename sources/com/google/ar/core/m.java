package com.google.ar.core;

import com.google.ar.core.ArCoreApk;
import java.util.function.Consumer;

final /* synthetic */ class m implements Consumer {

    /* renamed from: a  reason: collision with root package name */
    private final /* synthetic */ long f30342a;

    /* renamed from: b  reason: collision with root package name */
    private final /* synthetic */ long f30343b;

    /* synthetic */ m(long j2, long j3) {
        this.f30342a = j2;
        this.f30343b = j3;
    }

    public final /* synthetic */ void accept(Object obj) {
        ArCoreApkJniAdapter.nativeInvokeAvailabilityCallback(this.f30342a, this.f30343b, ((ArCoreApk.Availability) obj).nativeCode);
    }
}
