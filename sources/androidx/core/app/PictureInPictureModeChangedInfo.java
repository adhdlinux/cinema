package androidx.core.app;

import android.content.res.Configuration;

public final class PictureInPictureModeChangedInfo {

    /* renamed from: a  reason: collision with root package name */
    private final boolean f2456a;

    /* renamed from: b  reason: collision with root package name */
    private final Configuration f2457b;

    public PictureInPictureModeChangedInfo(boolean z2) {
        this.f2456a = z2;
        this.f2457b = null;
    }

    public PictureInPictureModeChangedInfo(boolean z2, Configuration configuration) {
        this.f2456a = z2;
        this.f2457b = configuration;
    }
}
