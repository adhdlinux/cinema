package com.unity3d.services.core.domain;

import com.unity3d.services.core.domain.task.InitializationException;
import kotlin.Result;
import kotlin.jvm.internal.Intrinsics;

public final class ResultExtensionsKt {
    public static final /* synthetic */ <E extends Exception> E getCustomExceptionOrNull(Object obj) {
        E e2 = Result.e(obj);
        Intrinsics.l(3, "E");
        if (e2 instanceof Exception) {
            return (Exception) e2;
        }
        return null;
    }

    public static final /* synthetic */ <E extends Exception> E getCustomExceptionOrThrow(Object obj) {
        E e2 = Result.e(obj);
        Intrinsics.l(3, "E");
        if (e2 instanceof Exception) {
            return (Exception) e2;
        }
        throw new IllegalArgumentException("Wrong Exception type found");
    }

    public static final InitializationException getInitializationExceptionOrNull(Object obj) {
        Throwable e2 = Result.e(obj);
        if (e2 instanceof InitializationException) {
            return (InitializationException) e2;
        }
        return null;
    }

    public static final InitializationException getInitializationExceptionOrThrow(Object obj) {
        Throwable e2 = Result.e(obj);
        if (e2 instanceof InitializationException) {
            return (InitializationException) e2;
        }
        throw new IllegalArgumentException("Wrong Exception type found");
    }
}
