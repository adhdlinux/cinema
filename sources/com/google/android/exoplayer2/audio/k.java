package com.google.android.exoplayer2.audio;

import com.google.android.exoplayer2.audio.AudioRendererEventListener;

public final /* synthetic */ class k implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ AudioRendererEventListener.EventDispatcher f23919b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ boolean f23920c;

    public /* synthetic */ k(AudioRendererEventListener.EventDispatcher eventDispatcher, boolean z2) {
        this.f23919b = eventDispatcher;
        this.f23920c = z2;
    }

    public final void run() {
        this.f23919b.z(this.f23920c);
    }
}
