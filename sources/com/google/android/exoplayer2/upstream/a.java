package com.google.android.exoplayer2.upstream;

import com.google.android.exoplayer2.upstream.BandwidthMeter;

public final /* synthetic */ class a implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ BandwidthMeter.EventListener.EventDispatcher.HandlerAndListener f28529b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ int f28530c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ long f28531d;

    /* renamed from: e  reason: collision with root package name */
    public final /* synthetic */ long f28532e;

    public /* synthetic */ a(BandwidthMeter.EventListener.EventDispatcher.HandlerAndListener handlerAndListener, int i2, long j2, long j3) {
        this.f28529b = handlerAndListener;
        this.f28530c = i2;
        this.f28531d = j2;
        this.f28532e = j3;
    }

    public final void run() {
        this.f28529b.f28316b.p(this.f28530c, this.f28531d, this.f28532e);
    }
}
