package com.extension;

import io.reactivex.functions.Predicate;
import kotlin.jvm.functions.Function1;

public final /* synthetic */ class a implements Predicate {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Function1 f19381b;

    public /* synthetic */ a(Function1 function1) {
        this.f19381b = function1;
    }

    public final boolean test(Object obj) {
        return CinemaWorker.n(this.f19381b, obj);
    }
}
