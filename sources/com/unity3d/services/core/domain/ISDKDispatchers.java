package com.unity3d.services.core.domain;

import kotlinx.coroutines.CoroutineDispatcher;

public interface ISDKDispatchers {
    CoroutineDispatcher getDefault();

    CoroutineDispatcher getIo();

    CoroutineDispatcher getMain();
}
