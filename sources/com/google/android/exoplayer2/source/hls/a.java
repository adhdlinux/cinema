package com.google.android.exoplayer2.source.hls;

import com.google.android.exoplayer2.source.hls.HlsSampleStreamWrapper;

public final /* synthetic */ class a implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ HlsSampleStreamWrapper.Callback f26549b;

    public /* synthetic */ a(HlsSampleStreamWrapper.Callback callback) {
        this.f26549b = callback;
    }

    public final void run() {
        this.f26549b.a();
    }
}
