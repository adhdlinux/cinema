package com.unity3d.services.core.domain;

import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.Dispatchers;

public final class SDKDispatchers implements ISDKDispatchers {

    /* renamed from: default  reason: not valid java name */
    private final CoroutineDispatcher f1default = Dispatchers.a();

    /* renamed from: io  reason: collision with root package name */
    private final CoroutineDispatcher f37213io = Dispatchers.b();
    private final CoroutineDispatcher main = Dispatchers.c();

    public CoroutineDispatcher getDefault() {
        return this.f1default;
    }

    public CoroutineDispatcher getIo() {
        return this.f37213io;
    }

    public CoroutineDispatcher getMain() {
        return this.main;
    }
}
