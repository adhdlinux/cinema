package com.google.android.exoplayer2.drm;

import com.google.android.exoplayer2.drm.DrmSessionEventListener;
import com.google.android.exoplayer2.util.Consumer;

public final /* synthetic */ class d implements Consumer {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Exception f24117a;

    public /* synthetic */ d(Exception exc) {
        this.f24117a = exc;
    }

    public final void accept(Object obj) {
        ((DrmSessionEventListener.EventDispatcher) obj).l(this.f24117a);
    }
}
