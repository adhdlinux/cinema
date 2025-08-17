package com.google.android.exoplayer2.scheduler;

import com.google.android.exoplayer2.scheduler.RequirementsWatcher;

public final /* synthetic */ class c implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ RequirementsWatcher.NetworkCallback f25685b;

    public /* synthetic */ c(RequirementsWatcher.NetworkCallback networkCallback) {
        this.f25685b = networkCallback;
    }

    public final void run() {
        this.f25685b.c();
    }
}
