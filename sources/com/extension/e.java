package com.extension;

import io.reactivex.functions.Function;
import kotlin.jvm.functions.Function1;

public final /* synthetic */ class e implements Function {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Function1 f19385b;

    public /* synthetic */ e(Function1 function1) {
        this.f19385b = function1;
    }

    public final Object apply(Object obj) {
        return CinemaWorker.s(this.f19385b, obj);
    }
}
