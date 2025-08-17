package com.extension;

import io.reactivex.functions.Predicate;
import kotlin.jvm.functions.Function1;

public final /* synthetic */ class i implements Predicate {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Function1 f19389b;

    public /* synthetic */ i(Function1 function1) {
        this.f19389b = function1;
    }

    public final boolean test(Object obj) {
        return CinemaWorker.w(this.f19389b, obj);
    }
}
