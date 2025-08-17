package io.reactivex.internal.operators.observable;

import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.Function;
import io.reactivex.internal.disposables.EmptyDisposable;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.observers.BasicFuseableObserver;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.Collection;
import java.util.concurrent.Callable;

public final class ObservableDistinct<T, K> extends AbstractObservableWithUpstream<T, T> {

    /* renamed from: c  reason: collision with root package name */
    final Function<? super T, K> f38934c;

    /* renamed from: d  reason: collision with root package name */
    final Callable<? extends Collection<? super K>> f38935d;

    static final class DistinctObserver<T, K> extends BasicFuseableObserver<T, T> {

        /* renamed from: g  reason: collision with root package name */
        final Collection<? super K> f38936g;

        /* renamed from: h  reason: collision with root package name */
        final Function<? super T, K> f38937h;

        DistinctObserver(Observer<? super T> observer, Function<? super T, K> function, Collection<? super K> collection) {
            super(observer);
            this.f38937h = function;
            this.f38936g = collection;
        }

        public int b(int i2) {
            return e(i2);
        }

        public void clear() {
            this.f38936g.clear();
            super.clear();
        }

        public void onComplete() {
            if (!this.f38379e) {
                this.f38379e = true;
                this.f38936g.clear();
                this.f38376b.onComplete();
            }
        }

        public void onError(Throwable th) {
            if (this.f38379e) {
                RxJavaPlugins.s(th);
                return;
            }
            this.f38379e = true;
            this.f38936g.clear();
            this.f38376b.onError(th);
        }

        public void onNext(T t2) {
            if (!this.f38379e) {
                if (this.f38380f == 0) {
                    try {
                        if (this.f38936g.add(ObjectHelper.e(this.f38937h.apply(t2), "The keySelector returned a null key"))) {
                            this.f38376b.onNext(t2);
                        }
                    } catch (Throwable th) {
                        d(th);
                    }
                } else {
                    this.f38376b.onNext(null);
                }
            }
        }

        /*  JADX ERROR: StackOverflow in pass: RegionMakerVisitor
            jadx.core.utils.exceptions.JadxOverflowException: 
            	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:47)
            	at jadx.core.utils.ErrorsCounter.methodError(ErrorsCounter.java:81)
            */
        public T poll() throws java.lang.Exception {
            /*
                r4 = this;
            L_0x0000:
                io.reactivex.internal.fuseable.QueueDisposable<T> r0 = r4.f38378d
                java.lang.Object r0 = r0.poll()
                if (r0 == 0) goto L_0x001c
                java.util.Collection<? super K> r1 = r4.f38936g
                io.reactivex.functions.Function<? super T, K> r2 = r4.f38937h
                java.lang.Object r2 = r2.apply(r0)
                java.lang.String r3 = "The keySelector returned a null key"
                java.lang.Object r2 = io.reactivex.internal.functions.ObjectHelper.e(r2, r3)
                boolean r1 = r1.add(r2)
                if (r1 == 0) goto L_0x0000
            L_0x001c:
                return r0
            */
            throw new UnsupportedOperationException("Method not decompiled: io.reactivex.internal.operators.observable.ObservableDistinct.DistinctObserver.poll():java.lang.Object");
        }
    }

    public ObservableDistinct(ObservableSource<T> observableSource, Function<? super T, K> function, Callable<? extends Collection<? super K>> callable) {
        super(observableSource);
        this.f38934c = function;
        this.f38935d = callable;
    }

    /* access modifiers changed from: protected */
    public void subscribeActual(Observer<? super T> observer) {
        try {
            this.f38612b.subscribe(new DistinctObserver(observer, this.f38934c, (Collection) ObjectHelper.e(this.f38935d.call(), "The collectionSupplier returned a null collection. Null values are generally not allowed in 2.x operators and sources.")));
        } catch (Throwable th) {
            Exceptions.b(th);
            EmptyDisposable.e(th, observer);
        }
    }
}
