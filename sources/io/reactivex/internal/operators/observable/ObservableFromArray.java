package io.reactivex.internal.operators.observable;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.observers.BasicQueueDisposable;

public final class ObservableFromArray<T> extends Observable<T> {

    /* renamed from: b  reason: collision with root package name */
    final T[] f39071b;

    static final class FromArrayDisposable<T> extends BasicQueueDisposable<T> {

        /* renamed from: b  reason: collision with root package name */
        final Observer<? super T> f39072b;

        /* renamed from: c  reason: collision with root package name */
        final T[] f39073c;

        /* renamed from: d  reason: collision with root package name */
        int f39074d;

        /* renamed from: e  reason: collision with root package name */
        boolean f39075e;

        /* renamed from: f  reason: collision with root package name */
        volatile boolean f39076f;

        FromArrayDisposable(Observer<? super T> observer, T[] tArr) {
            this.f39072b = observer;
            this.f39073c = tArr;
        }

        /* access modifiers changed from: package-private */
        public void a() {
            T[] tArr = this.f39073c;
            int length = tArr.length;
            for (int i2 = 0; i2 < length && !isDisposed(); i2++) {
                T t2 = tArr[i2];
                if (t2 == null) {
                    Observer<? super T> observer = this.f39072b;
                    observer.onError(new NullPointerException("The element at index " + i2 + " is null"));
                    return;
                }
                this.f39072b.onNext(t2);
            }
            if (!isDisposed()) {
                this.f39072b.onComplete();
            }
        }

        public int b(int i2) {
            if ((i2 & 1) == 0) {
                return 0;
            }
            this.f39075e = true;
            return 1;
        }

        public void clear() {
            this.f39074d = this.f39073c.length;
        }

        public void dispose() {
            this.f39076f = true;
        }

        public boolean isDisposed() {
            return this.f39076f;
        }

        public boolean isEmpty() {
            return this.f39074d == this.f39073c.length;
        }

        public T poll() {
            int i2 = this.f39074d;
            T[] tArr = this.f39073c;
            if (i2 == tArr.length) {
                return null;
            }
            this.f39074d = i2 + 1;
            return ObjectHelper.e(tArr[i2], "The array element is null");
        }
    }

    public ObservableFromArray(T[] tArr) {
        this.f39071b = tArr;
    }

    public void subscribeActual(Observer<? super T> observer) {
        FromArrayDisposable fromArrayDisposable = new FromArrayDisposable(observer, this.f39071b);
        observer.onSubscribe(fromArrayDisposable);
        if (!fromArrayDisposable.f39075e) {
            fromArrayDisposable.a();
        }
    }
}
