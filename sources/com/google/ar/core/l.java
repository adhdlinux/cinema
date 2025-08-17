package com.google.ar.core;

import com.google.ar.core.ArCoreApk;
import java.util.function.Consumer;

final /* synthetic */ class l implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    private final /* synthetic */ Consumer f30341b;

    /* synthetic */ l(Consumer consumer) {
        this.f30341b = consumer;
    }

    public final /* synthetic */ void run() {
        Consumer consumer = this.f30341b;
        int i2 = ArCoreApkJniAdapter.f30225b;
        consumer.accept(ArCoreApk.Availability.UNKNOWN_ERROR);
    }
}
