package com.unity3d.services.core.di;

import com.google.android.gms.ads.RequestConfiguration;
import kotlin.Lazy;
import kotlin.LazyThreadSafetyMode;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;

public final class ServiceComponentKt {
    public static final /* synthetic */ <T> T get(ServiceComponent serviceComponent, String str) {
        Intrinsics.f(serviceComponent, "<this>");
        Intrinsics.f(str, "named");
        IServicesRegistry registry = serviceComponent.getServiceProvider().getRegistry();
        Intrinsics.l(4, RequestConfiguration.MAX_AD_CONTENT_RATING_T);
        return registry.getService(str, Reflection.b(Object.class));
    }

    public static /* synthetic */ Object get$default(ServiceComponent serviceComponent, String str, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str = "";
        }
        Intrinsics.f(serviceComponent, "<this>");
        Intrinsics.f(str, "named");
        IServicesRegistry registry = serviceComponent.getServiceProvider().getRegistry();
        Intrinsics.l(4, RequestConfiguration.MAX_AD_CONTENT_RATING_T);
        return registry.getService(str, Reflection.b(Object.class));
    }

    public static final /* synthetic */ <T> Lazy<T> inject(ServiceComponent serviceComponent, String str, LazyThreadSafetyMode lazyThreadSafetyMode) {
        Intrinsics.f(serviceComponent, "<this>");
        Intrinsics.f(str, "named");
        Intrinsics.f(lazyThreadSafetyMode, "mode");
        Intrinsics.k();
        return LazyKt__LazyJVMKt.a(lazyThreadSafetyMode, new ServiceComponentKt$inject$1(serviceComponent, str));
    }

    public static /* synthetic */ Lazy inject$default(ServiceComponent serviceComponent, String str, LazyThreadSafetyMode lazyThreadSafetyMode, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str = "";
        }
        if ((i2 & 2) != 0) {
            lazyThreadSafetyMode = LazyThreadSafetyMode.NONE;
        }
        Intrinsics.f(serviceComponent, "<this>");
        Intrinsics.f(str, "named");
        Intrinsics.f(lazyThreadSafetyMode, "mode");
        Intrinsics.k();
        return LazyKt__LazyJVMKt.a(lazyThreadSafetyMode, new ServiceComponentKt$inject$1(serviceComponent, str));
    }
}
