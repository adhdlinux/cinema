package com.google.android.exoplayer2.drm;

import com.google.android.exoplayer2.drm.DrmSessionEventListener;

public final /* synthetic */ class h implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ DefaultDrmSession f24121b;

    public /* synthetic */ h(DefaultDrmSession defaultDrmSession) {
        this.f24121b = defaultDrmSession;
    }

    public final void run() {
        this.f24121b.g((DrmSessionEventListener.EventDispatcher) null);
    }
}
