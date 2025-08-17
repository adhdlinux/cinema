package com.unity3d.services.core.extensions;

import java.util.concurrent.CancellationException;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

public final class CoroutineExtensionsKt {
    public static final <R> Object runReturnSuspendCatching(Function0<? extends R> function0) {
        Object obj;
        Intrinsics.f(function0, "block");
        try {
            Result.Companion companion = Result.f40263c;
            obj = Result.b(function0.invoke());
        } catch (CancellationException e2) {
            throw e2;
        } catch (Throwable th) {
            Result.Companion companion2 = Result.f40263c;
            obj = Result.b(ResultKt.a(th));
        }
        if (Result.h(obj)) {
            return Result.b(obj);
        }
        Throwable e3 = Result.e(obj);
        if (e3 != null) {
            return Result.b(ResultKt.a(e3));
        }
        return obj;
    }

    public static final <R> Object runSuspendCatching(Function0<? extends R> function0) {
        Intrinsics.f(function0, "block");
        try {
            Result.Companion companion = Result.f40263c;
            return Result.b(function0.invoke());
        } catch (CancellationException e2) {
            throw e2;
        } catch (Throwable th) {
            Result.Companion companion2 = Result.f40263c;
            return Result.b(ResultKt.a(th));
        }
    }
}
