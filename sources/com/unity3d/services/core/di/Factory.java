package com.unity3d.services.core.di;

import kotlin.Lazy;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

final class Factory<T> implements Lazy<T> {
    private final Function0<T> initializer;

    public Factory(Function0<? extends T> function0) {
        Intrinsics.f(function0, "initializer");
        this.initializer = function0;
    }

    public T getValue() {
        return this.initializer.invoke();
    }

    public boolean isInitialized() {
        return false;
    }
}
