package io.reactivex.internal.operators.mixed;

import androidx.media3.exoplayer.mediacodec.f;
import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.SingleObserver;
import io.reactivex.SingleSource;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.Function;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.util.AtomicThrowable;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

public final class ObservableSwitchMapSingle<T, R> extends Observable<R> {

    /* renamed from: b  reason: collision with root package name */
    final Observable<T> f38598b;

    /* renamed from: c  reason: collision with root package name */
    final Function<? super T, ? extends SingleSource<? extends R>> f38599c;

    /* renamed from: d  reason: collision with root package name */
    final boolean f38600d;

    static final class SwitchMapSingleMainObserver<T, R> extends AtomicInteger implements Observer<T>, Disposable {

        /* renamed from: j  reason: collision with root package name */
        static final SwitchMapSingleObserver<Object> f38601j = new SwitchMapSingleObserver<>((SwitchMapSingleMainObserver) null);

        /* renamed from: b  reason: collision with root package name */
        final Observer<? super R> f38602b;

        /* renamed from: c  reason: collision with root package name */
        final Function<? super T, ? extends SingleSource<? extends R>> f38603c;

        /* renamed from: d  reason: collision with root package name */
        final boolean f38604d;

        /* renamed from: e  reason: collision with root package name */
        final AtomicThrowable f38605e = new AtomicThrowable();

        /* renamed from: f  reason: collision with root package name */
        final AtomicReference<SwitchMapSingleObserver<R>> f38606f = new AtomicReference<>();

        /* renamed from: g  reason: collision with root package name */
        Disposable f38607g;

        /* renamed from: h  reason: collision with root package name */
        volatile boolean f38608h;

        /* renamed from: i  reason: collision with root package name */
        volatile boolean f38609i;

        static final class SwitchMapSingleObserver<R> extends AtomicReference<Disposable> implements SingleObserver<R> {

            /* renamed from: b  reason: collision with root package name */
            final SwitchMapSingleMainObserver<?, R> f38610b;

            /* renamed from: c  reason: collision with root package name */
            volatile R f38611c;

            SwitchMapSingleObserver(SwitchMapSingleMainObserver<?, R> switchMapSingleMainObserver) {
                this.f38610b = switchMapSingleMainObserver;
            }

            /* access modifiers changed from: package-private */
            public void a() {
                DisposableHelper.a(this);
            }

            public void onError(Throwable th) {
                this.f38610b.c(this, th);
            }

            public void onSubscribe(Disposable disposable) {
                DisposableHelper.f(this, disposable);
            }

            public void onSuccess(R r2) {
                this.f38611c = r2;
                this.f38610b.b();
            }
        }

        SwitchMapSingleMainObserver(Observer<? super R> observer, Function<? super T, ? extends SingleSource<? extends R>> function, boolean z2) {
            this.f38602b = observer;
            this.f38603c = function;
            this.f38604d = z2;
        }

        /* access modifiers changed from: package-private */
        public void a() {
            AtomicReference<SwitchMapSingleObserver<R>> atomicReference = this.f38606f;
            SwitchMapSingleObserver<Object> switchMapSingleObserver = f38601j;
            SwitchMapSingleObserver<Object> andSet = atomicReference.getAndSet(switchMapSingleObserver);
            if (andSet != null && andSet != switchMapSingleObserver) {
                andSet.a();
            }
        }

        /* access modifiers changed from: package-private */
        public void b() {
            boolean z2;
            if (getAndIncrement() == 0) {
                Observer<? super R> observer = this.f38602b;
                AtomicThrowable atomicThrowable = this.f38605e;
                AtomicReference<SwitchMapSingleObserver<R>> atomicReference = this.f38606f;
                int i2 = 1;
                while (!this.f38609i) {
                    if (atomicThrowable.get() == null || this.f38604d) {
                        boolean z3 = this.f38608h;
                        SwitchMapSingleObserver switchMapSingleObserver = atomicReference.get();
                        if (switchMapSingleObserver == null) {
                            z2 = true;
                        } else {
                            z2 = false;
                        }
                        if (z3 && z2) {
                            Throwable b2 = atomicThrowable.b();
                            if (b2 != null) {
                                observer.onError(b2);
                                return;
                            } else {
                                observer.onComplete();
                                return;
                            }
                        } else if (z2 || switchMapSingleObserver.f38611c == null) {
                            i2 = addAndGet(-i2);
                            if (i2 == 0) {
                                return;
                            }
                        } else {
                            f.a(atomicReference, switchMapSingleObserver, (Object) null);
                            observer.onNext(switchMapSingleObserver.f38611c);
                        }
                    } else {
                        observer.onError(atomicThrowable.b());
                        return;
                    }
                }
            }
        }

        /* access modifiers changed from: package-private */
        public void c(SwitchMapSingleObserver<R> switchMapSingleObserver, Throwable th) {
            if (!f.a(this.f38606f, switchMapSingleObserver, (Object) null) || !this.f38605e.a(th)) {
                RxJavaPlugins.s(th);
                return;
            }
            if (!this.f38604d) {
                this.f38607g.dispose();
                a();
            }
            b();
        }

        public void dispose() {
            this.f38609i = true;
            this.f38607g.dispose();
            a();
        }

        public boolean isDisposed() {
            return this.f38609i;
        }

        public void onComplete() {
            this.f38608h = true;
            b();
        }

        public void onError(Throwable th) {
            if (this.f38605e.a(th)) {
                if (!this.f38604d) {
                    a();
                }
                this.f38608h = true;
                b();
                return;
            }
            RxJavaPlugins.s(th);
        }

        public void onNext(T t2) {
            SwitchMapSingleObserver<Object> switchMapSingleObserver;
            SwitchMapSingleObserver switchMapSingleObserver2 = this.f38606f.get();
            if (switchMapSingleObserver2 != null) {
                switchMapSingleObserver2.a();
            }
            try {
                SingleSource singleSource = (SingleSource) ObjectHelper.e(this.f38603c.apply(t2), "The mapper returned a null SingleSource");
                SwitchMapSingleObserver switchMapSingleObserver3 = new SwitchMapSingleObserver(this);
                do {
                    switchMapSingleObserver = this.f38606f.get();
                    if (switchMapSingleObserver == f38601j) {
                        return;
                    }
                } while (!f.a(this.f38606f, switchMapSingleObserver, switchMapSingleObserver3));
                singleSource.a(switchMapSingleObserver3);
            } catch (Throwable th) {
                Exceptions.b(th);
                this.f38607g.dispose();
                this.f38606f.getAndSet(f38601j);
                onError(th);
            }
        }

        public void onSubscribe(Disposable disposable) {
            if (DisposableHelper.h(this.f38607g, disposable)) {
                this.f38607g = disposable;
                this.f38602b.onSubscribe(this);
            }
        }
    }

    public ObservableSwitchMapSingle(Observable<T> observable, Function<? super T, ? extends SingleSource<? extends R>> function, boolean z2) {
        this.f38598b = observable;
        this.f38599c = function;
        this.f38600d = z2;
    }

    /* access modifiers changed from: protected */
    public void subscribeActual(Observer<? super R> observer) {
        if (!ScalarXMapZHelper.c(this.f38598b, this.f38599c, observer)) {
            this.f38598b.subscribe(new SwitchMapSingleMainObserver(observer, this.f38599c, this.f38600d));
        }
    }
}
