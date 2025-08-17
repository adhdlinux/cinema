package com.google.android.exoplayer2;

import com.google.android.exoplayer2.AudioFocusManager;

public final /* synthetic */ class a implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ AudioFocusManager.AudioFocusListener f23550b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ int f23551c;

    public /* synthetic */ a(AudioFocusManager.AudioFocusListener audioFocusListener, int i2) {
        this.f23550b = audioFocusListener;
        this.f23551c = i2;
    }

    public final void run() {
        this.f23550b.b(this.f23551c);
    }
}
