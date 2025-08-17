package com.google.android.exoplayer2.drm;

import com.google.android.exoplayer2.drm.DefaultDrmSessionManager;

public final /* synthetic */ class f implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ DefaultDrmSessionManager.PreacquiredSessionReference f24118b;

    public /* synthetic */ f(DefaultDrmSessionManager.PreacquiredSessionReference preacquiredSessionReference) {
        this.f24118b = preacquiredSessionReference;
    }

    public final void run() {
        this.f24118b.e();
    }
}
