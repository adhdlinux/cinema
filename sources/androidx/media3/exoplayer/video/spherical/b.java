package androidx.media3.exoplayer.video.spherical;

import android.graphics.SurfaceTexture;

public final /* synthetic */ class b implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ SphericalGLSurfaceView f7879b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ SurfaceTexture f7880c;

    public /* synthetic */ b(SphericalGLSurfaceView sphericalGLSurfaceView, SurfaceTexture surfaceTexture) {
        this.f7879b = sphericalGLSurfaceView;
        this.f7880c = surfaceTexture;
    }

    public final void run() {
        this.f7879b.f(this.f7880c);
    }
}
