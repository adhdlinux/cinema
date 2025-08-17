package io.reactivex.internal.operators.observable;

import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.queue.SpscLinkedArrayQueue;
import io.reactivex.internal.util.BlockingHelper;
import io.reactivex.internal.util.ExceptionHelper;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.concurrent.atomic.AtomicReference;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public final class BlockingObservableIterable<T> implements Iterable<T> {

    /* renamed from: b  reason: collision with root package name */
    final ObservableSource<? extends T> f38613b;

    /* renamed from: c  reason: collision with root package name */
    final int f38614c;

    static final class BlockingObservableIterator<T> extends AtomicReference<Disposable> implements Observer<T>, Iterator<T>, Disposable {

        /* renamed from: b  reason: collision with root package name */
        final SpscLinkedArrayQueue<T> f38615b;

        /* renamed from: c  reason: collision with root package name */
        final Lock f38616c;

        /* renamed from: d  reason: collision with root package name */
        final Condition f38617d;

        /* renamed from: e  reason: collision with root package name */
        volatile boolean f38618e;

        /* renamed from: f  reason: collision with root package name */
        Throwable f38619f;

        BlockingObservableIterator(int i2) {
            this.f38615b = new SpscLinkedArrayQueue<>(i2);
            ReentrantLock reentrantLock = new ReentrantLock();
            this.f38616c = reentrantLock;
            this.f38617d = reentrantLock.newCondition();
        }

        /* access modifiers changed from: package-private */
        public void a() {
            this.f38616c.lock();
            try {
                this.f38617d.signalAll();
            } finally {
                this.f38616c.unlock();
            }
        }

        public void dispose() {
            DisposableHelper.a(this);
        }

        public boolean hasNext() {
            while (true) {
                boolean z2 = this.f38618e;
                boolean isEmpty = this.f38615b.isEmpty();
                if (z2) {
                    Throwable th = this.f38619f;
                    if (th != null) {
                        throw ExceptionHelper.d(th);
                    } else if (isEmpty) {
                        return false;
                    }
                }
                if (!isEmpty) {
                    return true;
                }
                BlockingHelper.b();
                this.f38616c.lock();
                while (!this.f38618e && this.f38615b.isEmpty()) {
                    try {
                        this.f38617d.await();
                    } catch (InterruptedException e2) {
                        DisposableHelper.a(this);
                        a();
                        throw ExceptionHelper.d(e2);
                    } catch (Throwable th2) {
                        this.f38616c.unlock();
                        throw th2;
                    }
                }
                this.f38616c.unlock();
            }
        }

        public boolean isDisposed() {
            return DisposableHelper.b((Disposable) get());
        }

        public T next() {
            if (hasNext()) {
                return this.f38615b.poll();
            }
            throw new NoSuchElementException();
        }

        public void onComplete() {
            this.f38618e = true;
            a();
        }

        public void onError(Throwable th) {
            this.f38619f = th;
            this.f38618e = true;
            a();
        }

        public void onNext(T t2) {
            this.f38615b.offer(t2);
            a();
        }

        public void onSubscribe(Disposable disposable) {
            DisposableHelper.f(this, disposable);
        }

        public void remove() {
            throw new UnsupportedOperationException("remove");
        }
    }

    public BlockingObservableIterable(ObservableSource<? extends T> observableSource, int i2) {
        this.f38613b = observableSource;
        this.f38614c = i2;
    }

    public Iterator<T> iterator() {
        BlockingObservableIterator blockingObservableIterator = new BlockingObservableIterator(this.f38614c);
        this.f38613b.subscribe(blockingObservableIterator);
        return blockingObservableIterator;
    }
}
