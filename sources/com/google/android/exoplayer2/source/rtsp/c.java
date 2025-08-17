package com.google.android.exoplayer2.source.rtsp;

import com.google.android.exoplayer2.source.rtsp.RtspClient;
import java.util.List;

public final /* synthetic */ class c implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ RtspClient.MessageListener f26971b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ List f26972c;

    public /* synthetic */ c(RtspClient.MessageListener messageListener, List list) {
        this.f26971b = messageListener;
        this.f26972c = list;
    }

    public final void run() {
        this.f26971b.h(this.f26972c);
    }
}
