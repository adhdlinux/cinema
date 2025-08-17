package io.reactivex.internal.operators.observable;

import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.functions.Consumer;
import io.reactivex.internal.observers.BasicFuseableObserver;

public final class ObservableDoAfterNext<T> extends AbstractObservableWithUpstream<T, T> {

    /* renamed from: c  reason: collision with root package name */
    final Consumer<? super T> f38944c;

    static final class DoAfterObserver<T> extends BasicFuseableObserver<T, T> {

        /* renamed from: g  reason: collision with root package name */
        final Consumer<? super T> f38945g;

        DoAfterObserver(Observer<? super T> observer, Consumer<? super T> consumer) {
            super(observer);
            this.f38945g = consumer;
        }

        public int b(int i2) {
            return e(i2);
        }

        public void onNext(T t2) {
            this.f38376b.onNext(t2);
            if (this.f38380f == 0) {
                try {
                    this.f38945g.accept(t2);
                } catch (Throwable th) {
                    d(th);
                }
            }
        }

        public T poll() throws Exception {
            T poll = this.f38378d.poll();
            if (poll != null) {
                this.f38945g.accept(poll);
            }
            return poll;
        }
    }

    public ObservableDoAfterNext(ObservableSource<T> observableSource, Consumer<? super T> consumer) {
        super(observableSource);
        this.f38944c = consumer;
    }

    /* access modifiers changed from: protected */
    public void subscribeActual(Observer<? super T> observer) {
        this.f38612b.subscribe(new DoAfterObserver(observer, this.f38944c));
    }
}
