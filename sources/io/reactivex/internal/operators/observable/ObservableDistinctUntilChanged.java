package io.reactivex.internal.operators.observable;

import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.functions.BiPredicate;
import io.reactivex.functions.Function;
import io.reactivex.internal.observers.BasicFuseableObserver;

public final class ObservableDistinctUntilChanged<T, K> extends AbstractObservableWithUpstream<T, T> {

    /* renamed from: c  reason: collision with root package name */
    final Function<? super T, K> f38938c;

    /* renamed from: d  reason: collision with root package name */
    final BiPredicate<? super K, ? super K> f38939d;

    static final class DistinctUntilChangedObserver<T, K> extends BasicFuseableObserver<T, T> {

        /* renamed from: g  reason: collision with root package name */
        final Function<? super T, K> f38940g;

        /* renamed from: h  reason: collision with root package name */
        final BiPredicate<? super K, ? super K> f38941h;

        /* renamed from: i  reason: collision with root package name */
        K f38942i;

        /* renamed from: j  reason: collision with root package name */
        boolean f38943j;

        DistinctUntilChangedObserver(Observer<? super T> observer, Function<? super T, K> function, BiPredicate<? super K, ? super K> biPredicate) {
            super(observer);
            this.f38940g = function;
            this.f38941h = biPredicate;
        }

        public int b(int i2) {
            return e(i2);
        }

        public void onNext(T t2) {
            if (!this.f38379e) {
                if (this.f38380f != 0) {
                    this.f38376b.onNext(t2);
                    return;
                }
                try {
                    K apply = this.f38940g.apply(t2);
                    if (this.f38943j) {
                        boolean test = this.f38941h.test(this.f38942i, apply);
                        this.f38942i = apply;
                        if (test) {
                            return;
                        }
                    } else {
                        this.f38943j = true;
                        this.f38942i = apply;
                    }
                    this.f38376b.onNext(t2);
                } catch (Throwable th) {
                    d(th);
                }
            }
        }

        public T poll() throws Exception {
            while (true) {
                T poll = this.f38378d.poll();
                if (poll == null) {
                    return null;
                }
                K apply = this.f38940g.apply(poll);
                if (!this.f38943j) {
                    this.f38943j = true;
                    this.f38942i = apply;
                    return poll;
                } else if (!this.f38941h.test(this.f38942i, apply)) {
                    this.f38942i = apply;
                    return poll;
                } else {
                    this.f38942i = apply;
                }
            }
        }
    }

    public ObservableDistinctUntilChanged(ObservableSource<T> observableSource, Function<? super T, K> function, BiPredicate<? super K, ? super K> biPredicate) {
        super(observableSource);
        this.f38938c = function;
        this.f38939d = biPredicate;
    }

    /* access modifiers changed from: protected */
    public void subscribeActual(Observer<? super T> observer) {
        this.f38612b.subscribe(new DistinctUntilChangedObserver(observer, this.f38938c, this.f38939d));
    }
}
