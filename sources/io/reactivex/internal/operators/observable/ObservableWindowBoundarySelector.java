package io.reactivex.internal.operators.observable;

import androidx.media3.exoplayer.mediacodec.f;
import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.Function;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.observers.QueueDrainObserver;
import io.reactivex.internal.queue.MpscLinkedQueue;
import io.reactivex.internal.util.NotificationLite;
import io.reactivex.observers.DisposableObserver;
import io.reactivex.observers.SerializedObserver;
import io.reactivex.plugins.RxJavaPlugins;
import io.reactivex.subjects.UnicastSubject;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;

public final class ObservableWindowBoundarySelector<T, B, V> extends AbstractObservableWithUpstream<T, Observable<T>> {

    /* renamed from: c  reason: collision with root package name */
    final ObservableSource<B> f39767c;

    /* renamed from: d  reason: collision with root package name */
    final Function<? super B, ? extends ObservableSource<V>> f39768d;

    /* renamed from: e  reason: collision with root package name */
    final int f39769e;

    static final class OperatorWindowBoundaryCloseObserver<T, V> extends DisposableObserver<V> {

        /* renamed from: c  reason: collision with root package name */
        final WindowBoundaryMainObserver<T, ?, V> f39770c;

        /* renamed from: d  reason: collision with root package name */
        final UnicastSubject<T> f39771d;

        /* renamed from: e  reason: collision with root package name */
        boolean f39772e;

        OperatorWindowBoundaryCloseObserver(WindowBoundaryMainObserver<T, ?, V> windowBoundaryMainObserver, UnicastSubject<T> unicastSubject) {
            this.f39770c = windowBoundaryMainObserver;
            this.f39771d = unicastSubject;
        }

        public void onComplete() {
            if (!this.f39772e) {
                this.f39772e = true;
                this.f39770c.j(this);
            }
        }

        public void onError(Throwable th) {
            if (this.f39772e) {
                RxJavaPlugins.s(th);
                return;
            }
            this.f39772e = true;
            this.f39770c.m(th);
        }

        public void onNext(V v2) {
            dispose();
            onComplete();
        }
    }

    static final class OperatorWindowBoundaryOpenObserver<T, B> extends DisposableObserver<B> {

        /* renamed from: c  reason: collision with root package name */
        final WindowBoundaryMainObserver<T, B, ?> f39773c;

        OperatorWindowBoundaryOpenObserver(WindowBoundaryMainObserver<T, B, ?> windowBoundaryMainObserver) {
            this.f39773c = windowBoundaryMainObserver;
        }

        public void onComplete() {
            this.f39773c.onComplete();
        }

        public void onError(Throwable th) {
            this.f39773c.m(th);
        }

        public void onNext(B b2) {
            this.f39773c.n(b2);
        }
    }

    static final class WindowBoundaryMainObserver<T, B, V> extends QueueDrainObserver<T, Object, Observable<T>> implements Disposable {

        /* renamed from: h  reason: collision with root package name */
        final ObservableSource<B> f39774h;

        /* renamed from: i  reason: collision with root package name */
        final Function<? super B, ? extends ObservableSource<V>> f39775i;

        /* renamed from: j  reason: collision with root package name */
        final int f39776j;

        /* renamed from: k  reason: collision with root package name */
        final CompositeDisposable f39777k;

        /* renamed from: l  reason: collision with root package name */
        Disposable f39778l;

        /* renamed from: m  reason: collision with root package name */
        final AtomicReference<Disposable> f39779m = new AtomicReference<>();

        /* renamed from: n  reason: collision with root package name */
        final List<UnicastSubject<T>> f39780n;

        /* renamed from: o  reason: collision with root package name */
        final AtomicLong f39781o;

        /* renamed from: p  reason: collision with root package name */
        final AtomicBoolean f39782p;

        WindowBoundaryMainObserver(Observer<? super Observable<T>> observer, ObservableSource<B> observableSource, Function<? super B, ? extends ObservableSource<V>> function, int i2) {
            super(observer, new MpscLinkedQueue());
            AtomicLong atomicLong = new AtomicLong();
            this.f39781o = atomicLong;
            this.f39782p = new AtomicBoolean();
            this.f39774h = observableSource;
            this.f39775i = function;
            this.f39776j = i2;
            this.f39777k = new CompositeDisposable();
            this.f39780n = new ArrayList();
            atomicLong.lazySet(1);
        }

        public void a(Observer<? super Observable<T>> observer, Object obj) {
        }

        public void dispose() {
            if (this.f39782p.compareAndSet(false, true)) {
                DisposableHelper.a(this.f39779m);
                if (this.f39781o.decrementAndGet() == 0) {
                    this.f39778l.dispose();
                }
            }
        }

        public boolean isDisposed() {
            return this.f39782p.get();
        }

        /* access modifiers changed from: package-private */
        public void j(OperatorWindowBoundaryCloseObserver<T, V> operatorWindowBoundaryCloseObserver) {
            this.f39777k.c(operatorWindowBoundaryCloseObserver);
            this.f38416d.offer(new WindowOperation(operatorWindowBoundaryCloseObserver.f39771d, null));
            if (f()) {
                l();
            }
        }

        /* access modifiers changed from: package-private */
        public void k() {
            this.f39777k.dispose();
            DisposableHelper.a(this.f39779m);
        }

        /* access modifiers changed from: package-private */
        public void l() {
            boolean z2;
            MpscLinkedQueue mpscLinkedQueue = (MpscLinkedQueue) this.f38416d;
            Observer<? super V> observer = this.f38415c;
            List<UnicastSubject<T>> list = this.f39780n;
            int i2 = 1;
            while (true) {
                boolean z3 = this.f38418f;
                Object poll = mpscLinkedQueue.poll();
                if (poll == null) {
                    z2 = true;
                } else {
                    z2 = false;
                }
                if (z3 && z2) {
                    k();
                    Throwable th = this.f38419g;
                    if (th != null) {
                        for (UnicastSubject<T> onError : list) {
                            onError.onError(th);
                        }
                    } else {
                        for (UnicastSubject<T> onComplete : list) {
                            onComplete.onComplete();
                        }
                    }
                    list.clear();
                    return;
                } else if (z2) {
                    i2 = b(-i2);
                    if (i2 == 0) {
                        return;
                    }
                } else if (poll instanceof WindowOperation) {
                    WindowOperation windowOperation = (WindowOperation) poll;
                    UnicastSubject<T> unicastSubject = windowOperation.f39783a;
                    if (unicastSubject != null) {
                        if (list.remove(unicastSubject)) {
                            windowOperation.f39783a.onComplete();
                            if (this.f39781o.decrementAndGet() == 0) {
                                k();
                                return;
                            }
                        } else {
                            continue;
                        }
                    } else if (!this.f39782p.get()) {
                        UnicastSubject d2 = UnicastSubject.d(this.f39776j);
                        list.add(d2);
                        observer.onNext(d2);
                        try {
                            ObservableSource observableSource = (ObservableSource) ObjectHelper.e(this.f39775i.apply(windowOperation.f39784b), "The ObservableSource supplied is null");
                            OperatorWindowBoundaryCloseObserver operatorWindowBoundaryCloseObserver = new OperatorWindowBoundaryCloseObserver(this, d2);
                            if (this.f39777k.b(operatorWindowBoundaryCloseObserver)) {
                                this.f39781o.getAndIncrement();
                                observableSource.subscribe(operatorWindowBoundaryCloseObserver);
                            }
                        } catch (Throwable th2) {
                            Exceptions.b(th2);
                            this.f39782p.set(true);
                            observer.onError(th2);
                        }
                    }
                } else {
                    for (UnicastSubject<T> onNext : list) {
                        onNext.onNext(NotificationLite.g(poll));
                    }
                }
            }
        }

        /* access modifiers changed from: package-private */
        public void m(Throwable th) {
            this.f39778l.dispose();
            this.f39777k.dispose();
            onError(th);
        }

        /* access modifiers changed from: package-private */
        public void n(B b2) {
            this.f38416d.offer(new WindowOperation((UnicastSubject) null, b2));
            if (f()) {
                l();
            }
        }

        public void onComplete() {
            if (!this.f38418f) {
                this.f38418f = true;
                if (f()) {
                    l();
                }
                if (this.f39781o.decrementAndGet() == 0) {
                    this.f39777k.dispose();
                }
                this.f38415c.onComplete();
            }
        }

        public void onError(Throwable th) {
            if (this.f38418f) {
                RxJavaPlugins.s(th);
                return;
            }
            this.f38419g = th;
            this.f38418f = true;
            if (f()) {
                l();
            }
            if (this.f39781o.decrementAndGet() == 0) {
                this.f39777k.dispose();
            }
            this.f38415c.onError(th);
        }

        public void onNext(T t2) {
            if (g()) {
                for (UnicastSubject<T> onNext : this.f39780n) {
                    onNext.onNext(t2);
                }
                if (b(-1) == 0) {
                    return;
                }
            } else {
                this.f38416d.offer(NotificationLite.j(t2));
                if (!f()) {
                    return;
                }
            }
            l();
        }

        public void onSubscribe(Disposable disposable) {
            if (DisposableHelper.h(this.f39778l, disposable)) {
                this.f39778l = disposable;
                this.f38415c.onSubscribe(this);
                if (!this.f39782p.get()) {
                    OperatorWindowBoundaryOpenObserver operatorWindowBoundaryOpenObserver = new OperatorWindowBoundaryOpenObserver(this);
                    if (f.a(this.f39779m, (Object) null, operatorWindowBoundaryOpenObserver)) {
                        this.f39774h.subscribe(operatorWindowBoundaryOpenObserver);
                    }
                }
            }
        }
    }

    static final class WindowOperation<T, B> {

        /* renamed from: a  reason: collision with root package name */
        final UnicastSubject<T> f39783a;

        /* renamed from: b  reason: collision with root package name */
        final B f39784b;

        WindowOperation(UnicastSubject<T> unicastSubject, B b2) {
            this.f39783a = unicastSubject;
            this.f39784b = b2;
        }
    }

    public ObservableWindowBoundarySelector(ObservableSource<T> observableSource, ObservableSource<B> observableSource2, Function<? super B, ? extends ObservableSource<V>> function, int i2) {
        super(observableSource);
        this.f39767c = observableSource2;
        this.f39768d = function;
        this.f39769e = i2;
    }

    public void subscribeActual(Observer<? super Observable<T>> observer) {
        this.f38612b.subscribe(new WindowBoundaryMainObserver(new SerializedObserver(observer), this.f39767c, this.f39768d, this.f39769e));
    }
}
