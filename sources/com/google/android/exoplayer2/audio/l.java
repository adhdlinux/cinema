package com.google.android.exoplayer2.audio;

import com.google.android.exoplayer2.audio.AudioRendererEventListener;

public final /* synthetic */ class l implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ AudioRendererEventListener.EventDispatcher f23921b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ int f23922c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ long f23923d;

    /* renamed from: e  reason: collision with root package name */
    public final /* synthetic */ long f23924e;

    public /* synthetic */ l(AudioRendererEventListener.EventDispatcher eventDispatcher, int i2, long j2, long j3) {
        this.f23921b = eventDispatcher;
        this.f23922c = i2;
        this.f23923d = j2;
        this.f23924e = j3;
    }

    public final void run() {
        this.f23921b.A(this.f23922c, this.f23923d, this.f23924e);
    }
}
