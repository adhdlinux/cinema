package io.reactivex.internal.operators.observable;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.internal.observers.BasicIntQueueDisposable;

public final class ObservableRangeLong extends Observable<Long> {

    /* renamed from: b  reason: collision with root package name */
    private final long f39322b;

    /* renamed from: c  reason: collision with root package name */
    private final long f39323c;

    static final class RangeDisposable extends BasicIntQueueDisposable<Long> {

        /* renamed from: b  reason: collision with root package name */
        final Observer<? super Long> f39324b;

        /* renamed from: c  reason: collision with root package name */
        final long f39325c;

        /* renamed from: d  reason: collision with root package name */
        long f39326d;

        /* renamed from: e  reason: collision with root package name */
        boolean f39327e;

        RangeDisposable(Observer<? super Long> observer, long j2, long j3) {
            this.f39324b = observer;
            this.f39326d = j2;
            this.f39325c = j3;
        }

        /* renamed from: a */
        public Long poll() throws Exception {
            long j2 = this.f39326d;
            if (j2 != this.f39325c) {
                this.f39326d = 1 + j2;
                return Long.valueOf(j2);
            }
            lazySet(1);
            return null;
        }

        public int b(int i2) {
            if ((i2 & 1) == 0) {
                return 0;
            }
            this.f39327e = true;
            return 1;
        }

        public void clear() {
            this.f39326d = this.f39325c;
            lazySet(1);
        }

        public void dispose() {
            set(1);
        }

        public boolean isDisposed() {
            return get() != 0;
        }

        public boolean isEmpty() {
            return this.f39326d == this.f39325c;
        }

        /* access modifiers changed from: package-private */
        public void run() {
            if (!this.f39327e) {
                Observer<? super Long> observer = this.f39324b;
                long j2 = this.f39325c;
                for (long j3 = this.f39326d; j3 != j2 && get() == 0; j3++) {
                    observer.onNext(Long.valueOf(j3));
                }
                if (get() == 0) {
                    lazySet(1);
                    observer.onComplete();
                }
            }
        }
    }

    public ObservableRangeLong(long j2, long j3) {
        this.f39322b = j2;
        this.f39323c = j3;
    }

    /* access modifiers changed from: protected */
    public void subscribeActual(Observer<? super Long> observer) {
        long j2 = this.f39322b;
        RangeDisposable rangeDisposable = new RangeDisposable(observer, j2, j2 + this.f39323c);
        observer.onSubscribe(rangeDisposable);
        rangeDisposable.run();
    }
}
