package com.extension;

import io.reactivex.functions.Function;
import kotlin.jvm.functions.Function1;

public final /* synthetic */ class f implements Function {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Function1 f19386b;

    public /* synthetic */ f(Function1 function1) {
        this.f19386b = function1;
    }

    public final Object apply(Object obj) {
        return CinemaWorker.t(this.f19386b, obj);
    }
}
