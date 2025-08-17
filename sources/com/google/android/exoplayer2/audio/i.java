package com.google.android.exoplayer2.audio;

import com.google.android.exoplayer2.audio.AudioRendererEventListener;

public final /* synthetic */ class i implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ AudioRendererEventListener.EventDispatcher f23913b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ Exception f23914c;

    public /* synthetic */ i(AudioRendererEventListener.EventDispatcher eventDispatcher, Exception exc) {
        this.f23913b = eventDispatcher;
        this.f23914c = exc;
    }

    public final void run() {
        this.f23913b.r(this.f23914c);
    }
}
