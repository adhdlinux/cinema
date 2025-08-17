package io.reactivex.internal.operators.observable;

import io.reactivex.Notification;
import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.internal.util.BlockingHelper;
import io.reactivex.internal.util.ExceptionHelper;
import io.reactivex.observers.DisposableObserver;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.concurrent.Semaphore;
import java.util.concurrent.atomic.AtomicReference;

public final class BlockingObservableLatest<T> implements Iterable<T> {

    /* renamed from: b  reason: collision with root package name */
    final ObservableSource<T> f38620b;

    static final class BlockingObservableLatestIterator<T> extends DisposableObserver<Notification<T>> implements Iterator<T> {

        /* renamed from: c  reason: collision with root package name */
        Notification<T> f38621c;

        /* renamed from: d  reason: collision with root package name */
        final Semaphore f38622d = new Semaphore(0);

        /* renamed from: e  reason: collision with root package name */
        final AtomicReference<Notification<T>> f38623e = new AtomicReference<>();

        BlockingObservableLatestIterator() {
        }

        /* renamed from: b */
        public void onNext(Notification<T> notification) {
            boolean z2;
            if (this.f38623e.getAndSet(notification) == null) {
                z2 = true;
            } else {
                z2 = false;
            }
            if (z2) {
                this.f38622d.release();
            }
        }

        public boolean hasNext() {
            Notification<T> notification = this.f38621c;
            if (notification == null || !notification.g()) {
                if (this.f38621c == null) {
                    try {
                        BlockingHelper.b();
                        this.f38622d.acquire();
                        Notification<T> andSet = this.f38623e.getAndSet((Object) null);
                        this.f38621c = andSet;
                        if (andSet.g()) {
                            throw ExceptionHelper.d(andSet.d());
                        }
                    } catch (InterruptedException e2) {
                        dispose();
                        this.f38621c = Notification.b(e2);
                        throw ExceptionHelper.d(e2);
                    }
                }
                return this.f38621c.h();
            }
            throw ExceptionHelper.d(this.f38621c.d());
        }

        public T next() {
            if (hasNext()) {
                T e2 = this.f38621c.e();
                this.f38621c = null;
                return e2;
            }
            throw new NoSuchElementException();
        }

        public void onComplete() {
        }

        public void onError(Throwable th) {
            RxJavaPlugins.s(th);
        }

        public void remove() {
            throw new UnsupportedOperationException("Read-only iterator.");
        }
    }

    public BlockingObservableLatest(ObservableSource<T> observableSource) {
        this.f38620b = observableSource;
    }

    public Iterator<T> iterator() {
        BlockingObservableLatestIterator blockingObservableLatestIterator = new BlockingObservableLatestIterator();
        Observable.wrap(this.f38620b).materialize().subscribe(blockingObservableLatestIterator);
        return blockingObservableLatestIterator;
    }
}
