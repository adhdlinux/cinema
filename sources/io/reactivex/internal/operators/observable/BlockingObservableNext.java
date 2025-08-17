package io.reactivex.internal.operators.observable;

import io.reactivex.Notification;
import io.reactivex.ObservableSource;
import io.reactivex.internal.util.BlockingHelper;
import io.reactivex.internal.util.ExceptionHelper;
import io.reactivex.observers.DisposableObserver;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.atomic.AtomicInteger;

public final class BlockingObservableNext<T> implements Iterable<T> {

    /* renamed from: b  reason: collision with root package name */
    final ObservableSource<T> f38629b;

    static final class NextIterator<T> implements Iterator<T> {

        /* renamed from: b  reason: collision with root package name */
        private final NextObserver<T> f38630b;

        /* renamed from: c  reason: collision with root package name */
        private final ObservableSource<T> f38631c;

        /* renamed from: d  reason: collision with root package name */
        private T f38632d;

        /* renamed from: e  reason: collision with root package name */
        private boolean f38633e = true;

        /* renamed from: f  reason: collision with root package name */
        private boolean f38634f = true;

        /* renamed from: g  reason: collision with root package name */
        private Throwable f38635g;

        /* renamed from: h  reason: collision with root package name */
        private boolean f38636h;

        NextIterator(ObservableSource<T> observableSource, NextObserver<T> nextObserver) {
            this.f38631c = observableSource;
            this.f38630b = nextObserver;
        }

        private boolean a() {
            if (!this.f38636h) {
                this.f38636h = true;
                this.f38630b.c();
                new ObservableMaterialize(this.f38631c).subscribe(this.f38630b);
            }
            try {
                Notification<T> d2 = this.f38630b.d();
                if (d2.h()) {
                    this.f38634f = false;
                    this.f38632d = d2.e();
                    return true;
                }
                this.f38633e = false;
                if (d2.f()) {
                    return false;
                }
                Throwable d3 = d2.d();
                this.f38635g = d3;
                throw ExceptionHelper.d(d3);
            } catch (InterruptedException e2) {
                this.f38630b.dispose();
                this.f38635g = e2;
                throw ExceptionHelper.d(e2);
            }
        }

        public boolean hasNext() {
            Throwable th = this.f38635g;
            if (th != null) {
                throw ExceptionHelper.d(th);
            } else if (!this.f38633e) {
                return false;
            } else {
                if (!this.f38634f || a()) {
                    return true;
                }
                return false;
            }
        }

        public T next() {
            Throwable th = this.f38635g;
            if (th != null) {
                throw ExceptionHelper.d(th);
            } else if (hasNext()) {
                this.f38634f = true;
                return this.f38632d;
            } else {
                throw new NoSuchElementException("No more elements");
            }
        }

        public void remove() {
            throw new UnsupportedOperationException("Read only iterator");
        }
    }

    static final class NextObserver<T> extends DisposableObserver<Notification<T>> {

        /* renamed from: c  reason: collision with root package name */
        private final BlockingQueue<Notification<T>> f38637c = new ArrayBlockingQueue(1);

        /* renamed from: d  reason: collision with root package name */
        final AtomicInteger f38638d = new AtomicInteger();

        NextObserver() {
        }

        /* renamed from: b */
        public void onNext(Notification<T> notification) {
            if (this.f38638d.getAndSet(0) == 1 || !notification.h()) {
                while (!this.f38637c.offer(notification)) {
                    Notification<T> poll = this.f38637c.poll();
                    if (poll != null && !poll.h()) {
                        notification = poll;
                    }
                }
            }
        }

        /* access modifiers changed from: package-private */
        public void c() {
            this.f38638d.set(1);
        }

        public Notification<T> d() throws InterruptedException {
            c();
            BlockingHelper.b();
            return this.f38637c.take();
        }

        public void onComplete() {
        }

        public void onError(Throwable th) {
            RxJavaPlugins.s(th);
        }
    }

    public BlockingObservableNext(ObservableSource<T> observableSource) {
        this.f38629b = observableSource;
    }

    public Iterator<T> iterator() {
        return new NextIterator(this.f38629b, new NextObserver());
    }
}
