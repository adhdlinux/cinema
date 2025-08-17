package androidx.core.app;

import android.app.SharedElementCallback;
import androidx.core.app.ActivityCompat;
import androidx.core.app.SharedElementCallback;

public final /* synthetic */ class f implements SharedElementCallback.OnSharedElementsReadyListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ SharedElementCallback.OnSharedElementsReadyListener f2475a;

    public /* synthetic */ f(SharedElementCallback.OnSharedElementsReadyListener onSharedElementsReadyListener) {
        this.f2475a = onSharedElementsReadyListener;
    }

    public final void onSharedElementsReady() {
        ActivityCompat.Api23Impl.a(this.f2475a);
    }
}
