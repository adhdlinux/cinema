package com.google.android.exoplayer2.drm;

import android.media.MediaDrm;
import com.google.android.exoplayer2.drm.ExoMediaDrm;

public final /* synthetic */ class v implements MediaDrm.OnEventListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ FrameworkMediaDrm f24136a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ ExoMediaDrm.OnEventListener f24137b;

    public /* synthetic */ v(FrameworkMediaDrm frameworkMediaDrm, ExoMediaDrm.OnEventListener onEventListener) {
        this.f24136a = frameworkMediaDrm;
        this.f24137b = onEventListener;
    }

    public final void onEvent(MediaDrm mediaDrm, byte[] bArr, int i2, int i3, byte[] bArr2) {
        this.f24136a.z(this.f24137b, mediaDrm, bArr, i2, i3, bArr2);
    }
}
