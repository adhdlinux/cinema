package com.unity3d.services.core.di;

import kotlin.Lazy;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

public final class ServiceFactoryKt {
    public static final <T> Lazy<T> factoryOf(Function0<? extends T> function0) {
        Intrinsics.f(function0, "initializer");
        return new Factory(function0);
    }
}
