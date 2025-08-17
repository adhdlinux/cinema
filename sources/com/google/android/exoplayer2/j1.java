package com.google.android.exoplayer2;

import android.util.Pair;
import com.google.android.exoplayer2.MediaSourceList;

public final /* synthetic */ class j1 implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ MediaSourceList.ForwardingEventListener f25194b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ Pair f25195c;

    public /* synthetic */ j1(MediaSourceList.ForwardingEventListener forwardingEventListener, Pair pair) {
        this.f25194b = forwardingEventListener;
        this.f25195c = pair;
    }

    public final void run() {
        this.f25194b.Z(this.f25195c);
    }
}
