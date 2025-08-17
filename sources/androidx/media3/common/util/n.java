package androidx.media3.common.util;

import java.util.concurrent.ThreadFactory;

public final /* synthetic */ class n implements ThreadFactory {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ String f4737b;

    public /* synthetic */ n(String str) {
        this.f4737b = str;
    }

    public final Thread newThread(Runnable runnable) {
        return Util.L0(this.f4737b, runnable);
    }
}
