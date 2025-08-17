package com.google.android.exoplayer2.util;

import com.google.android.exoplayer2.util.ListenerSet;
import java.util.concurrent.CopyOnWriteArraySet;

public final /* synthetic */ class b implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ CopyOnWriteArraySet f28824b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ int f28825c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ ListenerSet.Event f28826d;

    public /* synthetic */ b(CopyOnWriteArraySet copyOnWriteArraySet, int i2, ListenerSet.Event event) {
        this.f28824b = copyOnWriteArraySet;
        this.f28825c = i2;
        this.f28826d = event;
    }

    public final void run() {
        ListenerSet.h(this.f28824b, this.f28825c, this.f28826d);
    }
}
