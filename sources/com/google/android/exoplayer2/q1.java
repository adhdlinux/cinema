package com.google.android.exoplayer2;

import android.util.Pair;
import com.google.android.exoplayer2.MediaSourceList;

public final /* synthetic */ class q1 implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ MediaSourceList.ForwardingEventListener f25651b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ Pair f25652c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ Exception f25653d;

    public /* synthetic */ q1(MediaSourceList.ForwardingEventListener forwardingEventListener, Pair pair, Exception exc) {
        this.f25651b = forwardingEventListener;
        this.f25652c = pair;
        this.f25653d = exc;
    }

    public final void run() {
        this.f25651b.b0(this.f25652c, this.f25653d);
    }
}
