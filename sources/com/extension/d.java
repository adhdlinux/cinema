package com.extension;

import io.reactivex.functions.Consumer;
import kotlin.jvm.functions.Function1;

public final /* synthetic */ class d implements Consumer {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Function1 f19384b;

    public /* synthetic */ d(Function1 function1) {
        this.f19384b = function1;
    }

    public final void accept(Object obj) {
        CinemaWorker.q(this.f19384b, obj);
    }
}
