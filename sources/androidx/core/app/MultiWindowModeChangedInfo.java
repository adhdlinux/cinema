package androidx.core.app;

import android.content.res.Configuration;

public final class MultiWindowModeChangedInfo {

    /* renamed from: a  reason: collision with root package name */
    private final boolean f2373a;

    /* renamed from: b  reason: collision with root package name */
    private final Configuration f2374b;

    public MultiWindowModeChangedInfo(boolean z2) {
        this.f2373a = z2;
        this.f2374b = null;
    }

    public MultiWindowModeChangedInfo(boolean z2, Configuration configuration) {
        this.f2373a = z2;
        this.f2374b = configuration;
    }
}
