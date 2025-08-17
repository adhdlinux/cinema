package com.google.android.exoplayer2.source.rtsp;

import com.google.android.exoplayer2.source.rtsp.RtspMessageChannel;
import java.util.List;

public final /* synthetic */ class g implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ RtspMessageChannel.Sender f26976b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ byte[] f26977c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ List f26978d;

    public /* synthetic */ g(RtspMessageChannel.Sender sender, byte[] bArr, List list) {
        this.f26976b = sender;
        this.f26977c = bArr;
        this.f26978d = list;
    }

    public final void run() {
        this.f26976b.f(this.f26977c, this.f26978d);
    }
}
