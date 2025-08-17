package com.google.android.exoplayer2.audio;

import com.google.android.exoplayer2.audio.AudioRendererEventListener;

public final /* synthetic */ class c implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ AudioRendererEventListener.EventDispatcher f23900b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ String f23901c;

    public /* synthetic */ c(AudioRendererEventListener.EventDispatcher eventDispatcher, String str) {
        this.f23900b = eventDispatcher;
        this.f23901c = str;
    }

    public final void run() {
        this.f23900b.u(this.f23901c);
    }
}
