package com.extension;

import io.reactivex.functions.Predicate;
import kotlin.jvm.functions.Function1;

public final /* synthetic */ class h implements Predicate {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Function1 f19388b;

    public /* synthetic */ h(Function1 function1) {
        this.f19388b = function1;
    }

    public final boolean test(Object obj) {
        return CinemaWorker.v(this.f19388b, obj);
    }
}
