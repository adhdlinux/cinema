package com.google.android.exoplayer2;

import android.util.Pair;
import com.google.android.exoplayer2.MediaSourceList;
import com.google.android.exoplayer2.source.LoadEventInfo;
import com.google.android.exoplayer2.source.MediaLoadData;

public final /* synthetic */ class h1 implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ MediaSourceList.ForwardingEventListener f25183b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ Pair f25184c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ LoadEventInfo f25185d;

    /* renamed from: e  reason: collision with root package name */
    public final /* synthetic */ MediaLoadData f25186e;

    public /* synthetic */ h1(MediaSourceList.ForwardingEventListener forwardingEventListener, Pair pair, LoadEventInfo loadEventInfo, MediaLoadData mediaLoadData) {
        this.f25183b = forwardingEventListener;
        this.f25184c = pair;
        this.f25185d = loadEventInfo;
        this.f25186e = mediaLoadData;
    }

    public final void run() {
        this.f25183b.g0(this.f25184c, this.f25185d, this.f25186e);
    }
}
