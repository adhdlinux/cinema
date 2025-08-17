package androidx.emoji2.text;

import java.util.concurrent.ThreadFactory;

public final /* synthetic */ class a implements ThreadFactory {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ String f3136b;

    public /* synthetic */ a(String str) {
        this.f3136b = str;
    }

    public final Thread newThread(Runnable runnable) {
        return ConcurrencyHelpers.c(this.f3136b, runnable);
    }
}
