package com.extension;

import io.reactivex.functions.Function;
import kotlin.jvm.functions.Function1;

public final /* synthetic */ class b implements Function {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Function1 f19382b;

    public /* synthetic */ b(Function1 function1) {
        this.f19382b = function1;
    }

    public final Object apply(Object obj) {
        return CinemaWorker.o(this.f19382b, obj);
    }
}
