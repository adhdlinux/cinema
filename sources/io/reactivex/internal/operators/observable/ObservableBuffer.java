package io.reactivex.internal.operators.observable;

import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.disposables.EmptyDisposable;
import io.reactivex.internal.functions.ObjectHelper;
import java.util.ArrayDeque;
import java.util.Collection;
import java.util.Iterator;
import java.util.concurrent.Callable;
import java.util.concurrent.atomic.AtomicBoolean;

public final class ObservableBuffer<T, U extends Collection<? super T>> extends AbstractObservableWithUpstream<T, U> {

    /* renamed from: c  reason: collision with root package name */
    final int f38670c;

    /* renamed from: d  reason: collision with root package name */
    final int f38671d;

    /* renamed from: e  reason: collision with root package name */
    final Callable<U> f38672e;

    static final class BufferExactObserver<T, U extends Collection<? super T>> implements Observer<T>, Disposable {

        /* renamed from: b  reason: collision with root package name */
        final Observer<? super U> f38673b;

        /* renamed from: c  reason: collision with root package name */
        final int f38674c;

        /* renamed from: d  reason: collision with root package name */
        final Callable<U> f38675d;

        /* renamed from: e  reason: collision with root package name */
        U f38676e;

        /* renamed from: f  reason: collision with root package name */
        int f38677f;

        /* renamed from: g  reason: collision with root package name */
        Disposable f38678g;

        BufferExactObserver(Observer<? super U> observer, int i2, Callable<U> callable) {
            this.f38673b = observer;
            this.f38674c = i2;
            this.f38675d = callable;
        }

        /* access modifiers changed from: package-private */
        public boolean a() {
            try {
                this.f38676e = (Collection) ObjectHelper.e(this.f38675d.call(), "Empty buffer supplied");
                return true;
            } catch (Throwable th) {
                Exceptions.b(th);
                this.f38676e = null;
                Disposable disposable = this.f38678g;
                if (disposable == null) {
                    EmptyDisposable.e(th, this.f38673b);
                    return false;
                }
                disposable.dispose();
                this.f38673b.onError(th);
                return false;
            }
        }

        public void dispose() {
            this.f38678g.dispose();
        }

        public boolean isDisposed() {
            return this.f38678g.isDisposed();
        }

        public void onComplete() {
            U u2 = this.f38676e;
            if (u2 != null) {
                this.f38676e = null;
                if (!u2.isEmpty()) {
                    this.f38673b.onNext(u2);
                }
                this.f38673b.onComplete();
            }
        }

        public void onError(Throwable th) {
            this.f38676e = null;
            this.f38673b.onError(th);
        }

        public void onNext(T t2) {
            U u2 = this.f38676e;
            if (u2 != null) {
                u2.add(t2);
                int i2 = this.f38677f + 1;
                this.f38677f = i2;
                if (i2 >= this.f38674c) {
                    this.f38673b.onNext(u2);
                    this.f38677f = 0;
                    a();
                }
            }
        }

        public void onSubscribe(Disposable disposable) {
            if (DisposableHelper.h(this.f38678g, disposable)) {
                this.f38678g = disposable;
                this.f38673b.onSubscribe(this);
            }
        }
    }

    static final class BufferSkipObserver<T, U extends Collection<? super T>> extends AtomicBoolean implements Observer<T>, Disposable {

        /* renamed from: b  reason: collision with root package name */
        final Observer<? super U> f38679b;

        /* renamed from: c  reason: collision with root package name */
        final int f38680c;

        /* renamed from: d  reason: collision with root package name */
        final int f38681d;

        /* renamed from: e  reason: collision with root package name */
        final Callable<U> f38682e;

        /* renamed from: f  reason: collision with root package name */
        Disposable f38683f;

        /* renamed from: g  reason: collision with root package name */
        final ArrayDeque<U> f38684g = new ArrayDeque<>();

        /* renamed from: h  reason: collision with root package name */
        long f38685h;

        BufferSkipObserver(Observer<? super U> observer, int i2, int i3, Callable<U> callable) {
            this.f38679b = observer;
            this.f38680c = i2;
            this.f38681d = i3;
            this.f38682e = callable;
        }

        public void dispose() {
            this.f38683f.dispose();
        }

        public boolean isDisposed() {
            return this.f38683f.isDisposed();
        }

        public void onComplete() {
            while (!this.f38684g.isEmpty()) {
                this.f38679b.onNext(this.f38684g.poll());
            }
            this.f38679b.onComplete();
        }

        public void onError(Throwable th) {
            this.f38684g.clear();
            this.f38679b.onError(th);
        }

        public void onNext(T t2) {
            long j2 = this.f38685h;
            this.f38685h = 1 + j2;
            if (j2 % ((long) this.f38681d) == 0) {
                try {
                    this.f38684g.offer((Collection) ObjectHelper.e(this.f38682e.call(), "The bufferSupplier returned a null collection. Null values are generally not allowed in 2.x operators and sources."));
                } catch (Throwable th) {
                    this.f38684g.clear();
                    this.f38683f.dispose();
                    this.f38679b.onError(th);
                    return;
                }
            }
            Iterator<U> it2 = this.f38684g.iterator();
            while (it2.hasNext()) {
                Collection collection = (Collection) it2.next();
                collection.add(t2);
                if (this.f38680c <= collection.size()) {
                    it2.remove();
                    this.f38679b.onNext(collection);
                }
            }
        }

        public void onSubscribe(Disposable disposable) {
            if (DisposableHelper.h(this.f38683f, disposable)) {
                this.f38683f = disposable;
                this.f38679b.onSubscribe(this);
            }
        }
    }

    public ObservableBuffer(ObservableSource<T> observableSource, int i2, int i3, Callable<U> callable) {
        super(observableSource);
        this.f38670c = i2;
        this.f38671d = i3;
        this.f38672e = callable;
    }

    /* access modifiers changed from: protected */
    public void subscribeActual(Observer<? super U> observer) {
        int i2 = this.f38671d;
        int i3 = this.f38670c;
        if (i2 == i3) {
            BufferExactObserver bufferExactObserver = new BufferExactObserver(observer, i3, this.f38672e);
            if (bufferExactObserver.a()) {
                this.f38612b.subscribe(bufferExactObserver);
                return;
            }
            return;
        }
        this.f38612b.subscribe(new BufferSkipObserver(observer, this.f38670c, this.f38671d, this.f38672e));
    }
}
