package com.google.android.exoplayer2.audio;

import com.google.android.exoplayer2.audio.AudioRendererEventListener;

public final /* synthetic */ class h implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ AudioRendererEventListener.EventDispatcher f23911b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ Exception f23912c;

    public /* synthetic */ h(AudioRendererEventListener.EventDispatcher eventDispatcher, Exception exc) {
        this.f23911b = eventDispatcher;
        this.f23912c = exc;
    }

    public final void run() {
        this.f23911b.s(this.f23912c);
    }
}
