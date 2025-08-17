package com.extension;

import io.reactivex.functions.Consumer;
import kotlin.jvm.functions.Function1;

public final /* synthetic */ class c implements Consumer {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Function1 f19383b;

    public /* synthetic */ c(Function1 function1) {
        this.f19383b = function1;
    }

    public final void accept(Object obj) {
        CinemaWorker.p(this.f19383b, obj);
    }
}
