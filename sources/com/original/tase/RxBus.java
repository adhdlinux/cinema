package com.original.tase;

import io.reactivex.Observable;
import io.reactivex.subjects.PublishSubject;

public class RxBus {

    /* renamed from: b  reason: collision with root package name */
    private static volatile RxBus f33769b;

    /* renamed from: a  reason: collision with root package name */
    private PublishSubject<Object> f33770a = PublishSubject.d();

    public static RxBus a() {
        RxBus rxBus = f33769b;
        if (rxBus == null) {
            synchronized (RxBus.class) {
                rxBus = f33769b;
                if (rxBus == null) {
                    rxBus = new RxBus();
                    f33769b = rxBus;
                }
            }
        }
        return rxBus;
    }

    public void b(Object obj) {
        this.f33770a.onNext(obj);
    }

    public Observable<Object> c() {
        return this.f33770a;
    }
}
