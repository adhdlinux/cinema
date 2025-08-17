package com.google.android.exoplayer2.scheduler;

import com.google.android.exoplayer2.scheduler.RequirementsWatcher;

public final /* synthetic */ class b implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ RequirementsWatcher.NetworkCallback f25684b;

    public /* synthetic */ b(RequirementsWatcher.NetworkCallback networkCallback) {
        this.f25684b = networkCallback;
    }

    public final void run() {
        this.f25684b.d();
    }
}
