package com.google.android.exoplayer2.drm;

import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.drm.DefaultDrmSessionManager;

public final /* synthetic */ class g implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ DefaultDrmSessionManager.PreacquiredSessionReference f24119b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ Format f24120c;

    public /* synthetic */ g(DefaultDrmSessionManager.PreacquiredSessionReference preacquiredSessionReference, Format format) {
        this.f24119b = preacquiredSessionReference;
        this.f24120c = format;
    }

    public final void run() {
        this.f24119b.d(this.f24120c);
    }
}
