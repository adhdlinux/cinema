package com.google.android.exoplayer2.mediacodec;

public final /* synthetic */ class d implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ AsynchronousMediaCodecCallback f25346b;

    public /* synthetic */ d(AsynchronousMediaCodecCallback asynchronousMediaCodecCallback) {
        this.f25346b = asynchronousMediaCodecCallback;
    }

    public final void run() {
        this.f25346b.m();
    }
}
