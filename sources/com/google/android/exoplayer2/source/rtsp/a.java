package com.google.android.exoplayer2.source.rtsp;

public final /* synthetic */ class a implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ RtpDataLoadable f26968b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ String f26969c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ RtpDataChannel f26970d;

    public /* synthetic */ a(RtpDataLoadable rtpDataLoadable, String str, RtpDataChannel rtpDataChannel) {
        this.f26968b = rtpDataLoadable;
        this.f26969c = str;
        this.f26970d = rtpDataChannel;
    }

    public final void run() {
        this.f26968b.d(this.f26969c, this.f26970d);
    }
}
