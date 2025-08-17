package com.google.android.exoplayer2.audio;

import com.google.android.exoplayer2.audio.AudioRendererEventListener;

public final /* synthetic */ class e implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ AudioRendererEventListener.EventDispatcher f23905b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ long f23906c;

    public /* synthetic */ e(AudioRendererEventListener.EventDispatcher eventDispatcher, long j2) {
        this.f23905b = eventDispatcher;
        this.f23906c = j2;
    }

    public final void run() {
        this.f23905b.y(this.f23906c);
    }
}
