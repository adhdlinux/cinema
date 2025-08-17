package com.vungle.ads.internal.executor;

import com.vungle.ads.internal.executor.VungleThreadPoolExecutor;
import java.util.concurrent.Callable;
import kotlin.jvm.functions.Function0;

public final /* synthetic */ class d implements Callable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Callable f37856b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ Function0 f37857c;

    public /* synthetic */ d(Callable callable, Function0 function0) {
        this.f37856b = callable;
        this.f37857c = function0;
    }

    public final Object call() {
        return VungleThreadPoolExecutor.Companion.m177getWrappedCallableWithFallback$lambda0(this.f37856b, this.f37857c);
    }
}
