package com.google.android.exoplayer2.source;

import com.google.android.exoplayer2.source.MediaSourceEventListener;
import java.io.IOException;

public final /* synthetic */ class k implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ MediaSourceEventListener.EventDispatcher f26690b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ MediaSourceEventListener f26691c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ LoadEventInfo f26692d;

    /* renamed from: e  reason: collision with root package name */
    public final /* synthetic */ MediaLoadData f26693e;

    /* renamed from: f  reason: collision with root package name */
    public final /* synthetic */ IOException f26694f;

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ boolean f26695g;

    public /* synthetic */ k(MediaSourceEventListener.EventDispatcher eventDispatcher, MediaSourceEventListener mediaSourceEventListener, LoadEventInfo loadEventInfo, MediaLoadData mediaLoadData, IOException iOException, boolean z2) {
        this.f26690b = eventDispatcher;
        this.f26691c = mediaSourceEventListener;
        this.f26692d = loadEventInfo;
        this.f26693e = mediaLoadData;
        this.f26694f = iOException;
        this.f26695g = z2;
    }

    public final void run() {
        this.f26690b.n(this.f26691c, this.f26692d, this.f26693e, this.f26694f, this.f26695g);
    }
}
