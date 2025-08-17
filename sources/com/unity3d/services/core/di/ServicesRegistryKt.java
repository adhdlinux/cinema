package com.unity3d.services.core.di;

import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

public final class ServicesRegistryKt {
    public static final ServicesRegistry registry(Function1<? super ServicesRegistry, Unit> function1) {
        Intrinsics.f(function1, "registry");
        ServicesRegistry servicesRegistry = new ServicesRegistry();
        function1.invoke(servicesRegistry);
        return servicesRegistry;
    }
}
