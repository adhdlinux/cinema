package com.utils;

import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;

public final class Coroutines {

    /* renamed from: a  reason: collision with root package name */
    public static final Coroutines f37223a = new Coroutines();

    private Coroutines() {
    }

    public final <T> Job a(T t2, Function3<? super CoroutineScope, ? super T, ? super Continuation<? super Unit>, ? extends Object> function3) {
        Intrinsics.f(function3, "work");
        return CoroutinesKt.b(CoroutineScopeKt.a(Dispatchers.b()), (CoroutineContext) null, (CoroutineStart) null, new Coroutines$ioSafe$1(function3, t2, (Continuation<? super Coroutines$ioSafe$1>) null), 3, (Object) null);
    }
}
