package com.google.android.exoplayer2;

import android.util.Pair;
import com.google.android.exoplayer2.MediaSourceList;
import com.google.android.exoplayer2.source.LoadEventInfo;
import com.google.android.exoplayer2.source.MediaLoadData;

public final /* synthetic */ class r1 implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ MediaSourceList.ForwardingEventListener f25659b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ Pair f25660c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ LoadEventInfo f25661d;

    /* renamed from: e  reason: collision with root package name */
    public final /* synthetic */ MediaLoadData f25662e;

    public /* synthetic */ r1(MediaSourceList.ForwardingEventListener forwardingEventListener, Pair pair, LoadEventInfo loadEventInfo, MediaLoadData mediaLoadData) {
        this.f25659b = forwardingEventListener;
        this.f25660c = pair;
        this.f25661d = loadEventInfo;
        this.f25662e = mediaLoadData;
    }

    public final void run() {
        this.f25659b.e0(this.f25660c, this.f25661d, this.f25662e);
    }
}
