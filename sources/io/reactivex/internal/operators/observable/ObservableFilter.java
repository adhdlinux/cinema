package io.reactivex.internal.operators.observable;

import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.functions.Predicate;
import io.reactivex.internal.observers.BasicFuseableObserver;

public final class ObservableFilter<T> extends AbstractObservableWithUpstream<T, T> {

    /* renamed from: c  reason: collision with root package name */
    final Predicate<? super T> f38993c;

    static final class FilterObserver<T> extends BasicFuseableObserver<T, T> {

        /* renamed from: g  reason: collision with root package name */
        final Predicate<? super T> f38994g;

        FilterObserver(Observer<? super T> observer, Predicate<? super T> predicate) {
            super(observer);
            this.f38994g = predicate;
        }

        public int b(int i2) {
            return e(i2);
        }

        public void onNext(T t2) {
            if (this.f38380f == 0) {
                try {
                    if (this.f38994g.test(t2)) {
                        this.f38376b.onNext(t2);
                    }
                } catch (Throwable th) {
                    d(th);
                }
            } else {
                this.f38376b.onNext(null);
            }
        }

        /*  JADX ERROR: StackOverflow in pass: RegionMakerVisitor
            jadx.core.utils.exceptions.JadxOverflowException: 
            	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:47)
            	at jadx.core.utils.ErrorsCounter.methodError(ErrorsCounter.java:81)
            */
        public T poll() throws java.lang.Exception {
            /*
                r2 = this;
            L_0x0000:
                io.reactivex.internal.fuseable.QueueDisposable<T> r0 = r2.f38378d
                java.lang.Object r0 = r0.poll()
                if (r0 == 0) goto L_0x0010
                io.reactivex.functions.Predicate<? super T> r1 = r2.f38994g
                boolean r1 = r1.test(r0)
                if (r1 == 0) goto L_0x0000
            L_0x0010:
                return r0
            */
            throw new UnsupportedOperationException("Method not decompiled: io.reactivex.internal.operators.observable.ObservableFilter.FilterObserver.poll():java.lang.Object");
        }
    }

    public ObservableFilter(ObservableSource<T> observableSource, Predicate<? super T> predicate) {
        super(observableSource);
        this.f38993c = predicate;
    }

    public void subscribeActual(Observer<? super T> observer) {
        this.f38612b.subscribe(new FilterObserver(observer, this.f38993c));
    }
}
