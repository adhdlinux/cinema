package com.google.android.exoplayer2.util;

import com.google.android.exoplayer2.util.NetworkTypeObserver;

public final /* synthetic */ class c implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ NetworkTypeObserver f28827b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ NetworkTypeObserver.Listener f28828c;

    public /* synthetic */ c(NetworkTypeObserver networkTypeObserver, NetworkTypeObserver.Listener listener) {
        this.f28827b = networkTypeObserver;
        this.f28828c = listener;
    }

    public final void run() {
        this.f28827b.h(this.f28828c);
    }
}
