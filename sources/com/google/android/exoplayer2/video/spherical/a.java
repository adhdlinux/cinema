package com.google.android.exoplayer2.video.spherical;

import android.graphics.SurfaceTexture;

public final /* synthetic */ class a implements SurfaceTexture.OnFrameAvailableListener {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ SceneRenderer f29052b;

    public /* synthetic */ a(SceneRenderer sceneRenderer) {
        this.f29052b = sceneRenderer;
    }

    public final void onFrameAvailable(SurfaceTexture surfaceTexture) {
        this.f29052b.g(surfaceTexture);
    }
}
