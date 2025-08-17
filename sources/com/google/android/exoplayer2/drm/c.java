package com.google.android.exoplayer2.drm;

import com.google.android.exoplayer2.drm.DrmSessionEventListener;
import com.google.android.exoplayer2.util.Consumer;

public final /* synthetic */ class c implements Consumer {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ int f24116a;

    public /* synthetic */ c(int i2) {
        this.f24116a = i2;
    }

    public final void accept(Object obj) {
        ((DrmSessionEventListener.EventDispatcher) obj).k(this.f24116a);
    }
}
