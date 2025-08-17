package com.google.android.exoplayer2;

import android.util.Pair;
import com.google.android.exoplayer2.MediaSourceList;
import com.google.android.exoplayer2.source.LoadEventInfo;
import com.google.android.exoplayer2.source.MediaLoadData;

public final /* synthetic */ class m1 implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ MediaSourceList.ForwardingEventListener f25211b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ Pair f25212c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ LoadEventInfo f25213d;

    /* renamed from: e  reason: collision with root package name */
    public final /* synthetic */ MediaLoadData f25214e;

    public /* synthetic */ m1(MediaSourceList.ForwardingEventListener forwardingEventListener, Pair pair, LoadEventInfo loadEventInfo, MediaLoadData mediaLoadData) {
        this.f25211b = forwardingEventListener;
        this.f25212c = pair;
        this.f25213d = loadEventInfo;
        this.f25214e = mediaLoadData;
    }

    public final void run() {
        this.f25211b.d0(this.f25212c, this.f25213d, this.f25214e);
    }
}
