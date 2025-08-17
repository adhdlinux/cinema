package io.reactivex.internal.operators.observable;

import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.Function;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.disposables.EmptyDisposable;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.util.AtomicThrowable;
import io.reactivex.internal.util.HalfSerializer;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.Arrays;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;
import java.util.concurrent.atomic.AtomicReferenceArray;

public final class ObservableWithLatestFromMany<T, R> extends AbstractObservableWithUpstream<T, R> {

    /* renamed from: c  reason: collision with root package name */
    final ObservableSource<?>[] f39853c;

    /* renamed from: d  reason: collision with root package name */
    final Iterable<? extends ObservableSource<?>> f39854d;

    /* renamed from: e  reason: collision with root package name */
    final Function<? super Object[], R> f39855e;

    final class SingletonArrayFunc implements Function<T, R> {
        SingletonArrayFunc() {
        }

        public R apply(T t2) throws Exception {
            return ObjectHelper.e(ObservableWithLatestFromMany.this.f39855e.apply(new Object[]{t2}), "The combiner returned a null value");
        }
    }

    static final class WithLatestFromObserver<T, R> extends AtomicInteger implements Observer<T>, Disposable {

        /* renamed from: b  reason: collision with root package name */
        final Observer<? super R> f39857b;

        /* renamed from: c  reason: collision with root package name */
        final Function<? super Object[], R> f39858c;

        /* renamed from: d  reason: collision with root package name */
        final WithLatestInnerObserver[] f39859d;

        /* renamed from: e  reason: collision with root package name */
        final AtomicReferenceArray<Object> f39860e;

        /* renamed from: f  reason: collision with root package name */
        final AtomicReference<Disposable> f39861f;

        /* renamed from: g  reason: collision with root package name */
        final AtomicThrowable f39862g;

        /* renamed from: h  reason: collision with root package name */
        volatile boolean f39863h;

        WithLatestFromObserver(Observer<? super R> observer, Function<? super Object[], R> function, int i2) {
            this.f39857b = observer;
            this.f39858c = function;
            WithLatestInnerObserver[] withLatestInnerObserverArr = new WithLatestInnerObserver[i2];
            for (int i3 = 0; i3 < i2; i3++) {
                withLatestInnerObserverArr[i3] = new WithLatestInnerObserver(this, i3);
            }
            this.f39859d = withLatestInnerObserverArr;
            this.f39860e = new AtomicReferenceArray<>(i2);
            this.f39861f = new AtomicReference<>();
            this.f39862g = new AtomicThrowable();
        }

        /* access modifiers changed from: package-private */
        public void a(int i2) {
            WithLatestInnerObserver[] withLatestInnerObserverArr = this.f39859d;
            for (int i3 = 0; i3 < withLatestInnerObserverArr.length; i3++) {
                if (i3 != i2) {
                    withLatestInnerObserverArr[i3].a();
                }
            }
        }

        /* access modifiers changed from: package-private */
        public void b(int i2, boolean z2) {
            if (!z2) {
                this.f39863h = true;
                a(i2);
                HalfSerializer.a(this.f39857b, this, this.f39862g);
            }
        }

        /* access modifiers changed from: package-private */
        public void c(int i2, Throwable th) {
            this.f39863h = true;
            DisposableHelper.a(this.f39861f);
            a(i2);
            HalfSerializer.c(this.f39857b, th, this, this.f39862g);
        }

        /* access modifiers changed from: package-private */
        public void d(int i2, Object obj) {
            this.f39860e.set(i2, obj);
        }

        public void dispose() {
            DisposableHelper.a(this.f39861f);
            for (WithLatestInnerObserver a2 : this.f39859d) {
                a2.a();
            }
        }

        /* access modifiers changed from: package-private */
        public void e(ObservableSource<?>[] observableSourceArr, int i2) {
            WithLatestInnerObserver[] withLatestInnerObserverArr = this.f39859d;
            AtomicReference<Disposable> atomicReference = this.f39861f;
            for (int i3 = 0; i3 < i2 && !DisposableHelper.b(atomicReference.get()) && !this.f39863h; i3++) {
                observableSourceArr[i3].subscribe(withLatestInnerObserverArr[i3]);
            }
        }

        public boolean isDisposed() {
            return DisposableHelper.b(this.f39861f.get());
        }

        public void onComplete() {
            if (!this.f39863h) {
                this.f39863h = true;
                a(-1);
                HalfSerializer.a(this.f39857b, this, this.f39862g);
            }
        }

        public void onError(Throwable th) {
            if (this.f39863h) {
                RxJavaPlugins.s(th);
                return;
            }
            this.f39863h = true;
            a(-1);
            HalfSerializer.c(this.f39857b, th, this, this.f39862g);
        }

        public void onNext(T t2) {
            if (!this.f39863h) {
                AtomicReferenceArray<Object> atomicReferenceArray = this.f39860e;
                int length = atomicReferenceArray.length();
                Object[] objArr = new Object[(length + 1)];
                int i2 = 0;
                objArr[0] = t2;
                while (i2 < length) {
                    Object obj = atomicReferenceArray.get(i2);
                    if (obj != null) {
                        i2++;
                        objArr[i2] = obj;
                    } else {
                        return;
                    }
                }
                try {
                    HalfSerializer.e(this.f39857b, ObjectHelper.e(this.f39858c.apply(objArr), "combiner returned a null value"), this, this.f39862g);
                } catch (Throwable th) {
                    Exceptions.b(th);
                    dispose();
                    onError(th);
                }
            }
        }

        public void onSubscribe(Disposable disposable) {
            DisposableHelper.f(this.f39861f, disposable);
        }
    }

    static final class WithLatestInnerObserver extends AtomicReference<Disposable> implements Observer<Object> {

        /* renamed from: b  reason: collision with root package name */
        final WithLatestFromObserver<?, ?> f39864b;

        /* renamed from: c  reason: collision with root package name */
        final int f39865c;

        /* renamed from: d  reason: collision with root package name */
        boolean f39866d;

        WithLatestInnerObserver(WithLatestFromObserver<?, ?> withLatestFromObserver, int i2) {
            this.f39864b = withLatestFromObserver;
            this.f39865c = i2;
        }

        public void a() {
            DisposableHelper.a(this);
        }

        public void onComplete() {
            this.f39864b.b(this.f39865c, this.f39866d);
        }

        public void onError(Throwable th) {
            this.f39864b.c(this.f39865c, th);
        }

        public void onNext(Object obj) {
            if (!this.f39866d) {
                this.f39866d = true;
            }
            this.f39864b.d(this.f39865c, obj);
        }

        public void onSubscribe(Disposable disposable) {
            DisposableHelper.f(this, disposable);
        }
    }

    public ObservableWithLatestFromMany(ObservableSource<T> observableSource, ObservableSource<?>[] observableSourceArr, Function<? super Object[], R> function) {
        super(observableSource);
        this.f39853c = observableSourceArr;
        this.f39854d = null;
        this.f39855e = function;
    }

    /* access modifiers changed from: protected */
    public void subscribeActual(Observer<? super R> observer) {
        int i2;
        ObservableSource<?>[] observableSourceArr = this.f39853c;
        if (observableSourceArr == null) {
            observableSourceArr = new ObservableSource[8];
            try {
                i2 = 0;
                for (ObservableSource<?> observableSource : this.f39854d) {
                    if (i2 == observableSourceArr.length) {
                        observableSourceArr = (ObservableSource[]) Arrays.copyOf(observableSourceArr, (i2 >> 1) + i2);
                    }
                    int i3 = i2 + 1;
                    observableSourceArr[i2] = observableSource;
                    i2 = i3;
                }
            } catch (Throwable th) {
                Exceptions.b(th);
                EmptyDisposable.e(th, observer);
                return;
            }
        } else {
            i2 = observableSourceArr.length;
        }
        if (i2 == 0) {
            new ObservableMap(this.f38612b, new SingletonArrayFunc()).subscribeActual(observer);
            return;
        }
        WithLatestFromObserver withLatestFromObserver = new WithLatestFromObserver(observer, this.f39855e, i2);
        observer.onSubscribe(withLatestFromObserver);
        withLatestFromObserver.e(observableSourceArr, i2);
        this.f38612b.subscribe(withLatestFromObserver);
    }

    public ObservableWithLatestFromMany(ObservableSource<T> observableSource, Iterable<? extends ObservableSource<?>> iterable, Function<? super Object[], R> function) {
        super(observableSource);
        this.f39853c = null;
        this.f39854d = iterable;
        this.f39855e = function;
    }
}
