package com.utils;

import com.facebook.react.uimanager.ViewProps;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Job;

public final class CoroutinesKt {
    public static final Job a(CoroutineScope coroutineScope, CoroutineContext coroutineContext, CoroutineStart coroutineStart, Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object> function2) {
        Intrinsics.f(coroutineScope, "<this>");
        Intrinsics.f(coroutineContext, "context");
        Intrinsics.f(coroutineStart, ViewProps.START);
        Intrinsics.f(function2, "block");
        return BuildersKt.a(coroutineScope, coroutineContext, coroutineStart, new CoroutinesKt$launchSafe$obj$1(function2, (Continuation<? super CoroutinesKt$launchSafe$obj$1>) null));
    }

    public static /* synthetic */ Job b(CoroutineScope coroutineScope, CoroutineContext coroutineContext, CoroutineStart coroutineStart, Function2 function2, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            coroutineContext = EmptyCoroutineContext.f40358b;
        }
        if ((i2 & 2) != 0) {
            coroutineStart = CoroutineStart.DEFAULT;
        }
        return a(coroutineScope, coroutineContext, coroutineStart, function2);
    }
}
