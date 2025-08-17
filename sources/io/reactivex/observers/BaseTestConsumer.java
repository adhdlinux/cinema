package io.reactivex.observers;

import io.reactivex.disposables.Disposable;
import io.reactivex.internal.util.VolatileSizeArrayList;
import io.reactivex.observers.BaseTestConsumer;
import java.util.List;
import java.util.concurrent.CountDownLatch;

public abstract class BaseTestConsumer<T, U extends BaseTestConsumer<T, U>> implements Disposable {

    /* renamed from: b  reason: collision with root package name */
    protected final CountDownLatch f40080b = new CountDownLatch(1);

    /* renamed from: c  reason: collision with root package name */
    protected final List<T> f40081c = new VolatileSizeArrayList();

    /* renamed from: d  reason: collision with root package name */
    protected final List<Throwable> f40082d = new VolatileSizeArrayList();

    /* renamed from: e  reason: collision with root package name */
    protected long f40083e;

    /* renamed from: f  reason: collision with root package name */
    protected Thread f40084f;

    /* renamed from: g  reason: collision with root package name */
    protected boolean f40085g;

    /* renamed from: h  reason: collision with root package name */
    protected int f40086h;

    /* renamed from: i  reason: collision with root package name */
    protected int f40087i;
}
