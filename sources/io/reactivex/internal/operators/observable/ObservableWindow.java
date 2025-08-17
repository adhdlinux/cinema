package io.reactivex.internal.operators.observable;

import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.subjects.UnicastSubject;
import java.util.ArrayDeque;
import java.util.Iterator;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;

public final class ObservableWindow<T> extends AbstractObservableWithUpstream<T, Observable<T>> {

    /* renamed from: c  reason: collision with root package name */
    final long f39732c;

    /* renamed from: d  reason: collision with root package name */
    final long f39733d;

    /* renamed from: e  reason: collision with root package name */
    final int f39734e;

    static final class WindowExactObserver<T> extends AtomicInteger implements Observer<T>, Disposable, Runnable {

        /* renamed from: b  reason: collision with root package name */
        final Observer<? super Observable<T>> f39735b;

        /* renamed from: c  reason: collision with root package name */
        final long f39736c;

        /* renamed from: d  reason: collision with root package name */
        final int f39737d;

        /* renamed from: e  reason: collision with root package name */
        long f39738e;

        /* renamed from: f  reason: collision with root package name */
        Disposable f39739f;

        /* renamed from: g  reason: collision with root package name */
        UnicastSubject<T> f39740g;

        /* renamed from: h  reason: collision with root package name */
        volatile boolean f39741h;

        WindowExactObserver(Observer<? super Observable<T>> observer, long j2, int i2) {
            this.f39735b = observer;
            this.f39736c = j2;
            this.f39737d = i2;
        }

        public void dispose() {
            this.f39741h = true;
        }

        public boolean isDisposed() {
            return this.f39741h;
        }

        public void onComplete() {
            UnicastSubject<T> unicastSubject = this.f39740g;
            if (unicastSubject != null) {
                this.f39740g = null;
                unicastSubject.onComplete();
            }
            this.f39735b.onComplete();
        }

        public void onError(Throwable th) {
            UnicastSubject<T> unicastSubject = this.f39740g;
            if (unicastSubject != null) {
                this.f39740g = null;
                unicastSubject.onError(th);
            }
            this.f39735b.onError(th);
        }

        public void onNext(T t2) {
            UnicastSubject<T> unicastSubject = this.f39740g;
            if (unicastSubject == null && !this.f39741h) {
                unicastSubject = UnicastSubject.e(this.f39737d, this);
                this.f39740g = unicastSubject;
                this.f39735b.onNext(unicastSubject);
            }
            if (unicastSubject != null) {
                unicastSubject.onNext(t2);
                long j2 = this.f39738e + 1;
                this.f39738e = j2;
                if (j2 >= this.f39736c) {
                    this.f39738e = 0;
                    this.f39740g = null;
                    unicastSubject.onComplete();
                    if (this.f39741h) {
                        this.f39739f.dispose();
                    }
                }
            }
        }

        public void onSubscribe(Disposable disposable) {
            if (DisposableHelper.h(this.f39739f, disposable)) {
                this.f39739f = disposable;
                this.f39735b.onSubscribe(this);
            }
        }

        public void run() {
            if (this.f39741h) {
                this.f39739f.dispose();
            }
        }
    }

    static final class WindowSkipObserver<T> extends AtomicBoolean implements Observer<T>, Disposable, Runnable {

        /* renamed from: b  reason: collision with root package name */
        final Observer<? super Observable<T>> f39742b;

        /* renamed from: c  reason: collision with root package name */
        final long f39743c;

        /* renamed from: d  reason: collision with root package name */
        final long f39744d;

        /* renamed from: e  reason: collision with root package name */
        final int f39745e;

        /* renamed from: f  reason: collision with root package name */
        final ArrayDeque<UnicastSubject<T>> f39746f;

        /* renamed from: g  reason: collision with root package name */
        long f39747g;

        /* renamed from: h  reason: collision with root package name */
        volatile boolean f39748h;

        /* renamed from: i  reason: collision with root package name */
        long f39749i;

        /* renamed from: j  reason: collision with root package name */
        Disposable f39750j;

        /* renamed from: k  reason: collision with root package name */
        final AtomicInteger f39751k = new AtomicInteger();

        WindowSkipObserver(Observer<? super Observable<T>> observer, long j2, long j3, int i2) {
            this.f39742b = observer;
            this.f39743c = j2;
            this.f39744d = j3;
            this.f39745e = i2;
            this.f39746f = new ArrayDeque<>();
        }

        public void dispose() {
            this.f39748h = true;
        }

        public boolean isDisposed() {
            return this.f39748h;
        }

        public void onComplete() {
            ArrayDeque<UnicastSubject<T>> arrayDeque = this.f39746f;
            while (!arrayDeque.isEmpty()) {
                arrayDeque.poll().onComplete();
            }
            this.f39742b.onComplete();
        }

        public void onError(Throwable th) {
            ArrayDeque<UnicastSubject<T>> arrayDeque = this.f39746f;
            while (!arrayDeque.isEmpty()) {
                arrayDeque.poll().onError(th);
            }
            this.f39742b.onError(th);
        }

        public void onNext(T t2) {
            ArrayDeque<UnicastSubject<T>> arrayDeque = this.f39746f;
            long j2 = this.f39747g;
            long j3 = this.f39744d;
            if (j2 % j3 == 0 && !this.f39748h) {
                this.f39751k.getAndIncrement();
                UnicastSubject e2 = UnicastSubject.e(this.f39745e, this);
                arrayDeque.offer(e2);
                this.f39742b.onNext(e2);
            }
            long j4 = this.f39749i + 1;
            Iterator<UnicastSubject<T>> it2 = arrayDeque.iterator();
            while (it2.hasNext()) {
                it2.next().onNext(t2);
            }
            if (j4 >= this.f39743c) {
                arrayDeque.poll().onComplete();
                if (!arrayDeque.isEmpty() || !this.f39748h) {
                    this.f39749i = j4 - j3;
                } else {
                    this.f39750j.dispose();
                    return;
                }
            } else {
                this.f39749i = j4;
            }
            this.f39747g = j2 + 1;
        }

        public void onSubscribe(Disposable disposable) {
            if (DisposableHelper.h(this.f39750j, disposable)) {
                this.f39750j = disposable;
                this.f39742b.onSubscribe(this);
            }
        }

        public void run() {
            if (this.f39751k.decrementAndGet() == 0 && this.f39748h) {
                this.f39750j.dispose();
            }
        }
    }

    public ObservableWindow(ObservableSource<T> observableSource, long j2, long j3, int i2) {
        super(observableSource);
        this.f39732c = j2;
        this.f39733d = j3;
        this.f39734e = i2;
    }

    public void subscribeActual(Observer<? super Observable<T>> observer) {
        if (this.f39732c == this.f39733d) {
            this.f38612b.subscribe(new WindowExactObserver(observer, this.f39732c, this.f39734e));
            return;
        }
        this.f38612b.subscribe(new WindowSkipObserver(observer, this.f39732c, this.f39733d, this.f39734e));
    }
}
