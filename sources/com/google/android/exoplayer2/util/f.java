package com.google.android.exoplayer2.util;

import java.util.concurrent.ThreadFactory;

public final /* synthetic */ class f implements ThreadFactory {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ String f28829b;

    public /* synthetic */ f(String str) {
        this.f28829b = str;
    }

    public final Thread newThread(Runnable runnable) {
        return Util.B0(this.f28829b, runnable);
    }
}
