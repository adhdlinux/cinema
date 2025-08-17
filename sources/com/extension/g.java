package com.extension;

import io.reactivex.functions.Predicate;
import kotlin.jvm.functions.Function1;

public final /* synthetic */ class g implements Predicate {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Function1 f19387b;

    public /* synthetic */ g(Function1 function1) {
        this.f19387b = function1;
    }

    public final boolean test(Object obj) {
        return CinemaWorker.u(this.f19387b, obj);
    }
}
