package androidx.media3.ui;

import android.view.SurfaceView;
import androidx.media3.ui.PlayerView;

public final /* synthetic */ class s implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ PlayerView.SurfaceSyncGroupCompatV34 f10201b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ SurfaceView f10202c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ Runnable f10203d;

    public /* synthetic */ s(PlayerView.SurfaceSyncGroupCompatV34 surfaceSyncGroupCompatV34, SurfaceView surfaceView, Runnable runnable) {
        this.f10201b = surfaceSyncGroupCompatV34;
        this.f10202c = surfaceView;
        this.f10203d = runnable;
    }

    public final void run() {
        this.f10201b.d(this.f10202c, this.f10203d);
    }
}
