package androidx.media3.exoplayer.video.spherical;

import android.graphics.SurfaceTexture;

public final /* synthetic */ class a implements SurfaceTexture.OnFrameAvailableListener {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ SceneRenderer f7878b;

    public /* synthetic */ a(SceneRenderer sceneRenderer) {
        this.f7878b = sceneRenderer;
    }

    public final void onFrameAvailable(SurfaceTexture surfaceTexture) {
        this.f7878b.g(surfaceTexture);
    }
}
