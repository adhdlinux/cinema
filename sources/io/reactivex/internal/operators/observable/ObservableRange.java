package io.reactivex.internal.operators.observable;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.internal.observers.BasicIntQueueDisposable;

public final class ObservableRange extends Observable<Integer> {

    /* renamed from: b  reason: collision with root package name */
    private final int f39316b;

    /* renamed from: c  reason: collision with root package name */
    private final long f39317c;

    static final class RangeDisposable extends BasicIntQueueDisposable<Integer> {

        /* renamed from: b  reason: collision with root package name */
        final Observer<? super Integer> f39318b;

        /* renamed from: c  reason: collision with root package name */
        final long f39319c;

        /* renamed from: d  reason: collision with root package name */
        long f39320d;

        /* renamed from: e  reason: collision with root package name */
        boolean f39321e;

        RangeDisposable(Observer<? super Integer> observer, long j2, long j3) {
            this.f39318b = observer;
            this.f39320d = j2;
            this.f39319c = j3;
        }

        /* renamed from: a */
        public Integer poll() throws Exception {
            long j2 = this.f39320d;
            if (j2 != this.f39319c) {
                this.f39320d = 1 + j2;
                return Integer.valueOf((int) j2);
            }
            lazySet(1);
            return null;
        }

        public int b(int i2) {
            if ((i2 & 1) == 0) {
                return 0;
            }
            this.f39321e = true;
            return 1;
        }

        public void clear() {
            this.f39320d = this.f39319c;
            lazySet(1);
        }

        public void dispose() {
            set(1);
        }

        public boolean isDisposed() {
            return get() != 0;
        }

        public boolean isEmpty() {
            return this.f39320d == this.f39319c;
        }

        /* access modifiers changed from: package-private */
        public void run() {
            if (!this.f39321e) {
                Observer<? super Integer> observer = this.f39318b;
                long j2 = this.f39319c;
                for (long j3 = this.f39320d; j3 != j2 && get() == 0; j3++) {
                    observer.onNext(Integer.valueOf((int) j3));
                }
                if (get() == 0) {
                    lazySet(1);
                    observer.onComplete();
                }
            }
        }
    }

    public ObservableRange(int i2, int i3) {
        this.f39316b = i2;
        this.f39317c = ((long) i2) + ((long) i3);
    }

    /* access modifiers changed from: protected */
    public void subscribeActual(Observer<? super Integer> observer) {
        RangeDisposable rangeDisposable = new RangeDisposable(observer, (long) this.f39316b, this.f39317c);
        observer.onSubscribe(rangeDisposable);
        rangeDisposable.run();
    }
}
