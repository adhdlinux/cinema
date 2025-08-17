package io.reactivex.internal.operators.observable;

import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.functions.Function;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.observers.BasicFuseableObserver;

public final class ObservableMap<T, U> extends AbstractObservableWithUpstream<T, U> {

    /* renamed from: c  reason: collision with root package name */
    final Function<? super T, ? extends U> f39231c;

    static final class MapObserver<T, U> extends BasicFuseableObserver<T, U> {

        /* renamed from: g  reason: collision with root package name */
        final Function<? super T, ? extends U> f39232g;

        MapObserver(Observer<? super U> observer, Function<? super T, ? extends U> function) {
            super(observer);
            this.f39232g = function;
        }

        public int b(int i2) {
            return e(i2);
        }

        public void onNext(T t2) {
            if (!this.f38379e) {
                if (this.f38380f != 0) {
                    this.f38376b.onNext(null);
                    return;
                }
                try {
                    this.f38376b.onNext(ObjectHelper.e(this.f39232g.apply(t2), "The mapper function returned a null value."));
                } catch (Throwable th) {
                    d(th);
                }
            }
        }

        public U poll() throws Exception {
            T poll = this.f38378d.poll();
            if (poll != null) {
                return ObjectHelper.e(this.f39232g.apply(poll), "The mapper function returned a null value.");
            }
            return null;
        }
    }

    public ObservableMap(ObservableSource<T> observableSource, Function<? super T, ? extends U> function) {
        super(observableSource);
        this.f39231c = function;
    }

    public void subscribeActual(Observer<? super U> observer) {
        this.f38612b.subscribe(new MapObserver(observer, this.f39231c));
    }
}
