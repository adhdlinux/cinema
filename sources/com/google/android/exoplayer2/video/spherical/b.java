package com.google.android.exoplayer2.video.spherical;

import android.graphics.SurfaceTexture;

public final /* synthetic */ class b implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ SphericalGLSurfaceView f29053b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ SurfaceTexture f29054c;

    public /* synthetic */ b(SphericalGLSurfaceView sphericalGLSurfaceView, SurfaceTexture surfaceTexture) {
        this.f29053b = sphericalGLSurfaceView;
        this.f29054c = surfaceTexture;
    }

    public final void run() {
        this.f29053b.f(this.f29054c);
    }
}
