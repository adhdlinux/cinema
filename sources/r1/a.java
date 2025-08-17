package r1;

import java.util.concurrent.ThreadFactory;
import okhttp3.internal.Util;

public final /* synthetic */ class a implements ThreadFactory {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ String f41476b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ boolean f41477c;

    public /* synthetic */ a(String str, boolean z2) {
        this.f41476b = str;
        this.f41477c = z2;
    }

    public final Thread newThread(Runnable runnable) {
        return Util.threadFactory$lambda$1(this.f41476b, this.f41477c, runnable);
    }
}
