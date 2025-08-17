package io.reactivex.internal.operators.observable;

import io.reactivex.ObservableSource;
import io.reactivex.internal.util.ExceptionHelper;
import io.reactivex.internal.util.NotificationLite;
import io.reactivex.observers.DefaultObserver;
import java.util.Iterator;
import java.util.NoSuchElementException;

public final class BlockingObservableMostRecent<T> implements Iterable<T> {

    /* renamed from: b  reason: collision with root package name */
    final ObservableSource<T> f38624b;

    /* renamed from: c  reason: collision with root package name */
    final T f38625c;

    static final class MostRecentObserver<T> extends DefaultObserver<T> {

        /* renamed from: c  reason: collision with root package name */
        volatile Object f38626c;

        final class Iterator implements java.util.Iterator<T> {

            /* renamed from: b  reason: collision with root package name */
            private Object f38627b;

            Iterator() {
            }

            public boolean hasNext() {
                Object obj = MostRecentObserver.this.f38626c;
                this.f38627b = obj;
                return !NotificationLite.h(obj);
            }

            public T next() {
                Object obj = null;
                try {
                    if (this.f38627b == null) {
                        obj = MostRecentObserver.this.f38626c;
                    }
                    if (NotificationLite.h(this.f38627b)) {
                        throw new NoSuchElementException();
                    } else if (!NotificationLite.i(this.f38627b)) {
                        T g2 = NotificationLite.g(this.f38627b);
                        this.f38627b = obj;
                        return g2;
                    } else {
                        throw ExceptionHelper.d(NotificationLite.f(this.f38627b));
                    }
                } finally {
                    this.f38627b = obj;
                }
            }

            public void remove() {
                throw new UnsupportedOperationException("Read only iterator");
            }
        }

        MostRecentObserver(T t2) {
            this.f38626c = NotificationLite.j(t2);
        }

        public MostRecentObserver<T>.Iterator b() {
            return new Iterator();
        }

        public void onComplete() {
            this.f38626c = NotificationLite.c();
        }

        public void onError(Throwable th) {
            this.f38626c = NotificationLite.e(th);
        }

        public void onNext(T t2) {
            this.f38626c = NotificationLite.j(t2);
        }
    }

    public BlockingObservableMostRecent(ObservableSource<T> observableSource, T t2) {
        this.f38624b = observableSource;
        this.f38625c = t2;
    }

    public Iterator<T> iterator() {
        MostRecentObserver mostRecentObserver = new MostRecentObserver(this.f38625c);
        this.f38624b.subscribe(mostRecentObserver);
        return mostRecentObserver.b();
    }
}
