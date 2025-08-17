package io.reactivex.internal.operators.mixed;

import androidx.media3.exoplayer.mediacodec.f;
import io.reactivex.MaybeObserver;
import io.reactivex.MaybeSource;
import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.Function;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.util.AtomicThrowable;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

public final class ObservableSwitchMapMaybe<T, R> extends Observable<R> {

    /* renamed from: b  reason: collision with root package name */
    final Observable<T> f38584b;

    /* renamed from: c  reason: collision with root package name */
    final Function<? super T, ? extends MaybeSource<? extends R>> f38585c;

    /* renamed from: d  reason: collision with root package name */
    final boolean f38586d;

    static final class SwitchMapMaybeMainObserver<T, R> extends AtomicInteger implements Observer<T>, Disposable {

        /* renamed from: j  reason: collision with root package name */
        static final SwitchMapMaybeObserver<Object> f38587j = new SwitchMapMaybeObserver<>((SwitchMapMaybeMainObserver) null);

        /* renamed from: b  reason: collision with root package name */
        final Observer<? super R> f38588b;

        /* renamed from: c  reason: collision with root package name */
        final Function<? super T, ? extends MaybeSource<? extends R>> f38589c;

        /* renamed from: d  reason: collision with root package name */
        final boolean f38590d;

        /* renamed from: e  reason: collision with root package name */
        final AtomicThrowable f38591e = new AtomicThrowable();

        /* renamed from: f  reason: collision with root package name */
        final AtomicReference<SwitchMapMaybeObserver<R>> f38592f = new AtomicReference<>();

        /* renamed from: g  reason: collision with root package name */
        Disposable f38593g;

        /* renamed from: h  reason: collision with root package name */
        volatile boolean f38594h;

        /* renamed from: i  reason: collision with root package name */
        volatile boolean f38595i;

        static final class SwitchMapMaybeObserver<R> extends AtomicReference<Disposable> implements MaybeObserver<R> {

            /* renamed from: b  reason: collision with root package name */
            final SwitchMapMaybeMainObserver<?, R> f38596b;

            /* renamed from: c  reason: collision with root package name */
            volatile R f38597c;

            SwitchMapMaybeObserver(SwitchMapMaybeMainObserver<?, R> switchMapMaybeMainObserver) {
                this.f38596b = switchMapMaybeMainObserver;
            }

            /* access modifiers changed from: package-private */
            public void a() {
                DisposableHelper.a(this);
            }

            public void onComplete() {
                this.f38596b.c(this);
            }

            public void onError(Throwable th) {
                this.f38596b.d(this, th);
            }

            public void onSubscribe(Disposable disposable) {
                DisposableHelper.f(this, disposable);
            }

            public void onSuccess(R r2) {
                this.f38597c = r2;
                this.f38596b.b();
            }
        }

        SwitchMapMaybeMainObserver(Observer<? super R> observer, Function<? super T, ? extends MaybeSource<? extends R>> function, boolean z2) {
            this.f38588b = observer;
            this.f38589c = function;
            this.f38590d = z2;
        }

        /* access modifiers changed from: package-private */
        public void a() {
            AtomicReference<SwitchMapMaybeObserver<R>> atomicReference = this.f38592f;
            SwitchMapMaybeObserver<Object> switchMapMaybeObserver = f38587j;
            SwitchMapMaybeObserver<Object> andSet = atomicReference.getAndSet(switchMapMaybeObserver);
            if (andSet != null && andSet != switchMapMaybeObserver) {
                andSet.a();
            }
        }

        /* access modifiers changed from: package-private */
        public void b() {
            boolean z2;
            if (getAndIncrement() == 0) {
                Observer<? super R> observer = this.f38588b;
                AtomicThrowable atomicThrowable = this.f38591e;
                AtomicReference<SwitchMapMaybeObserver<R>> atomicReference = this.f38592f;
                int i2 = 1;
                while (!this.f38595i) {
                    if (atomicThrowable.get() == null || this.f38590d) {
                        boolean z3 = this.f38594h;
                        SwitchMapMaybeObserver switchMapMaybeObserver = atomicReference.get();
                        if (switchMapMaybeObserver == null) {
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
                        } else if (z2 || switchMapMaybeObserver.f38597c == null) {
                            i2 = addAndGet(-i2);
                            if (i2 == 0) {
                                return;
                            }
                        } else {
                            f.a(atomicReference, switchMapMaybeObserver, (Object) null);
                            observer.onNext(switchMapMaybeObserver.f38597c);
                        }
                    } else {
                        observer.onError(atomicThrowable.b());
                        return;
                    }
                }
            }
        }

        /* access modifiers changed from: package-private */
        public void c(SwitchMapMaybeObserver<R> switchMapMaybeObserver) {
            if (f.a(this.f38592f, switchMapMaybeObserver, (Object) null)) {
                b();
            }
        }

        /* access modifiers changed from: package-private */
        public void d(SwitchMapMaybeObserver<R> switchMapMaybeObserver, Throwable th) {
            if (!f.a(this.f38592f, switchMapMaybeObserver, (Object) null) || !this.f38591e.a(th)) {
                RxJavaPlugins.s(th);
                return;
            }
            if (!this.f38590d) {
                this.f38593g.dispose();
                a();
            }
            b();
        }

        public void dispose() {
            this.f38595i = true;
            this.f38593g.dispose();
            a();
        }

        public boolean isDisposed() {
            return this.f38595i;
        }

        public void onComplete() {
            this.f38594h = true;
            b();
        }

        public void onError(Throwable th) {
            if (this.f38591e.a(th)) {
                if (!this.f38590d) {
                    a();
                }
                this.f38594h = true;
                b();
                return;
            }
            RxJavaPlugins.s(th);
        }

        public void onNext(T t2) {
            SwitchMapMaybeObserver<Object> switchMapMaybeObserver;
            SwitchMapMaybeObserver switchMapMaybeObserver2 = this.f38592f.get();
            if (switchMapMaybeObserver2 != null) {
                switchMapMaybeObserver2.a();
            }
            try {
                MaybeSource maybeSource = (MaybeSource) ObjectHelper.e(this.f38589c.apply(t2), "The mapper returned a null MaybeSource");
                SwitchMapMaybeObserver switchMapMaybeObserver3 = new SwitchMapMaybeObserver(this);
                do {
                    switchMapMaybeObserver = this.f38592f.get();
                    if (switchMapMaybeObserver == f38587j) {
                        return;
                    }
                } while (!f.a(this.f38592f, switchMapMaybeObserver, switchMapMaybeObserver3));
                maybeSource.a(switchMapMaybeObserver3);
            } catch (Throwable th) {
                Exceptions.b(th);
                this.f38593g.dispose();
                this.f38592f.getAndSet(f38587j);
                onError(th);
            }
        }

        public void onSubscribe(Disposable disposable) {
            if (DisposableHelper.h(this.f38593g, disposable)) {
                this.f38593g = disposable;
                this.f38588b.onSubscribe(this);
            }
        }
    }

    public ObservableSwitchMapMaybe(Observable<T> observable, Function<? super T, ? extends MaybeSource<? extends R>> function, boolean z2) {
        this.f38584b = observable;
        this.f38585c = function;
        this.f38586d = z2;
    }

    /* access modifiers changed from: protected */
    public void subscribeActual(Observer<? super R> observer) {
        if (!ScalarXMapZHelper.b(this.f38584b, this.f38585c, observer)) {
            this.f38584b.subscribe(new SwitchMapMaybeMainObserver(observer, this.f38585c, this.f38586d));
        }
    }
}
