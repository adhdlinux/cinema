package androidx.media3.exoplayer.source;

import androidx.media3.exoplayer.source.MediaSourceEventListener;
import java.io.IOException;

public final /* synthetic */ class o implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ MediaSourceEventListener.EventDispatcher f7296b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ MediaSourceEventListener f7297c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ LoadEventInfo f7298d;

    /* renamed from: e  reason: collision with root package name */
    public final /* synthetic */ MediaLoadData f7299e;

    /* renamed from: f  reason: collision with root package name */
    public final /* synthetic */ IOException f7300f;

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ boolean f7301g;

    public /* synthetic */ o(MediaSourceEventListener.EventDispatcher eventDispatcher, MediaSourceEventListener mediaSourceEventListener, LoadEventInfo loadEventInfo, MediaLoadData mediaLoadData, IOException iOException, boolean z2) {
        this.f7296b = eventDispatcher;
        this.f7297c = mediaSourceEventListener;
        this.f7298d = loadEventInfo;
        this.f7299e = mediaLoadData;
        this.f7300f = iOException;
        this.f7301g = z2;
    }

    public final void run() {
        this.f7296b.m(this.f7297c, this.f7298d, this.f7299e, this.f7300f, this.f7301g);
    }
}
