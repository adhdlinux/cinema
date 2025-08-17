package io.reactivex.internal.operators.flowable;

import io.reactivex.Flowable;
import io.reactivex.internal.functions.ObjectHelper;

abstract class AbstractFlowableWithUpstream<T, R> extends Flowable<R> {

    /* renamed from: c  reason: collision with root package name */
    protected final Flowable<T> f38421c;

    AbstractFlowableWithUpstream(Flowable<T> flowable) {
        this.f38421c = (Flowable) ObjectHelper.e(flowable, "source is null");
    }
}
