package com.google.android.exoplayer2.audio;

import com.google.android.exoplayer2.audio.AudioRendererEventListener;

public final /* synthetic */ class j implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ AudioRendererEventListener.EventDispatcher f23915b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ String f23916c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ long f23917d;

    /* renamed from: e  reason: collision with root package name */
    public final /* synthetic */ long f23918e;

    public /* synthetic */ j(AudioRendererEventListener.EventDispatcher eventDispatcher, String str, long j2, long j3) {
        this.f23915b = eventDispatcher;
        this.f23916c = str;
        this.f23917d = j2;
        this.f23918e = j3;
    }

    public final void run() {
        this.f23915b.t(this.f23916c, this.f23917d, this.f23918e);
    }
}
