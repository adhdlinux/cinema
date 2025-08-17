package com.google.android.exoplayer2;

import android.util.Pair;
import com.google.android.exoplayer2.MediaSourceList;
import com.google.android.exoplayer2.source.LoadEventInfo;
import com.google.android.exoplayer2.source.MediaLoadData;
import java.io.IOException;

public final /* synthetic */ class k1 implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ MediaSourceList.ForwardingEventListener f25199b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ Pair f25200c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ LoadEventInfo f25201d;

    /* renamed from: e  reason: collision with root package name */
    public final /* synthetic */ MediaLoadData f25202e;

    /* renamed from: f  reason: collision with root package name */
    public final /* synthetic */ IOException f25203f;

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ boolean f25204g;

    public /* synthetic */ k1(MediaSourceList.ForwardingEventListener forwardingEventListener, Pair pair, LoadEventInfo loadEventInfo, MediaLoadData mediaLoadData, IOException iOException, boolean z2) {
        this.f25199b = forwardingEventListener;
        this.f25200c = pair;
        this.f25201d = loadEventInfo;
        this.f25202e = mediaLoadData;
        this.f25203f = iOException;
        this.f25204g = z2;
    }

    public final void run() {
        this.f25199b.f0(this.f25200c, this.f25201d, this.f25202e, this.f25203f, this.f25204g);
    }
}
