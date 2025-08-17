package io.reactivex.internal.operators.observable;

import androidx.media3.exoplayer.mediacodec.f;
import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.observables.ConnectableObservable;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;

public final class ObservablePublish<T> extends ConnectableObservable<T> {

    /* renamed from: b  reason: collision with root package name */
    final ObservableSource<T> f39300b;

    /* renamed from: c  reason: collision with root package name */
    final AtomicReference<PublishObserver<T>> f39301c;

    /* renamed from: d  reason: collision with root package name */
    final ObservableSource<T> f39302d;

    static final class InnerDisposable<T> extends AtomicReference<Object> implements Disposable {

        /* renamed from: b  reason: collision with root package name */
        final Observer<? super T> f39303b;

        InnerDisposable(Observer<? super T> observer) {
            this.f39303b = observer;
        }

        /* access modifiers changed from: package-private */
        public void a(PublishObserver<T> publishObserver) {
            if (!compareAndSet((Object) null, publishObserver)) {
                publishObserver.b(this);
            }
        }

        public void dispose() {
            Object andSet = getAndSet(this);
            if (andSet != null && andSet != this) {
                ((PublishObserver) andSet).b(this);
            }
        }

        public boolean isDisposed() {
            return get() == this;
        }
    }

    static final class PublishObserver<T> implements Observer<T>, Disposable {

        /* renamed from: f  reason: collision with root package name */
        static final InnerDisposable[] f39304f = new InnerDisposable[0];

        /* renamed from: g  reason: collision with root package name */
        static final InnerDisposable[] f39305g = new InnerDisposable[0];

        /* renamed from: b  reason: collision with root package name */
        final AtomicReference<PublishObserver<T>> f39306b;

        /* renamed from: c  reason: collision with root package name */
        final AtomicReference<InnerDisposable<T>[]> f39307c = new AtomicReference<>(f39304f);

        /* renamed from: d  reason: collision with root package name */
        final AtomicBoolean f39308d;

        /* renamed from: e  reason: collision with root package name */
        final AtomicReference<Disposable> f39309e = new AtomicReference<>();

        PublishObserver(AtomicReference<PublishObserver<T>> atomicReference) {
            this.f39306b = atomicReference;
            this.f39308d = new AtomicBoolean();
        }

        /* access modifiers changed from: package-private */
        public boolean a(InnerDisposable<T> innerDisposable) {
            InnerDisposable[] innerDisposableArr;
            InnerDisposable[] innerDisposableArr2;
            do {
                innerDisposableArr = (InnerDisposable[]) this.f39307c.get();
                if (innerDisposableArr == f39305g) {
                    return false;
                }
                int length = innerDisposableArr.length;
                innerDisposableArr2 = new InnerDisposable[(length + 1)];
                System.arraycopy(innerDisposableArr, 0, innerDisposableArr2, 0, length);
                innerDisposableArr2[length] = innerDisposable;
            } while (!f.a(this.f39307c, innerDisposableArr, innerDisposableArr2));
            return true;
        }

        /* access modifiers changed from: package-private */
        public void b(InnerDisposable<T> innerDisposable) {
            InnerDisposable[] innerDisposableArr;
            InnerDisposable[] innerDisposableArr2;
            do {
                innerDisposableArr = (InnerDisposable[]) this.f39307c.get();
                int length = innerDisposableArr.length;
                if (length != 0) {
                    int i2 = 0;
                    while (true) {
                        if (i2 >= length) {
                            i2 = -1;
                            break;
                        } else if (innerDisposableArr[i2].equals(innerDisposable)) {
                            break;
                        } else {
                            i2++;
                        }
                    }
                    if (i2 >= 0) {
                        if (length == 1) {
                            innerDisposableArr2 = f39304f;
                        } else {
                            InnerDisposable[] innerDisposableArr3 = new InnerDisposable[(length - 1)];
                            System.arraycopy(innerDisposableArr, 0, innerDisposableArr3, 0, i2);
                            System.arraycopy(innerDisposableArr, i2 + 1, innerDisposableArr3, i2, (length - i2) - 1);
                            innerDisposableArr2 = innerDisposableArr3;
                        }
                    } else {
                        return;
                    }
                } else {
                    return;
                }
            } while (!f.a(this.f39307c, innerDisposableArr, innerDisposableArr2));
        }

        public void dispose() {
            AtomicReference<InnerDisposable<T>[]> atomicReference = this.f39307c;
            InnerDisposable[] innerDisposableArr = f39305g;
            if (((InnerDisposable[]) atomicReference.getAndSet(innerDisposableArr)) != innerDisposableArr) {
                f.a(this.f39306b, this, (Object) null);
                DisposableHelper.a(this.f39309e);
            }
        }

        public boolean isDisposed() {
            return this.f39307c.get() == f39305g;
        }

        public void onComplete() {
            f.a(this.f39306b, this, (Object) null);
            for (InnerDisposable innerDisposable : (InnerDisposable[]) this.f39307c.getAndSet(f39305g)) {
                innerDisposable.f39303b.onComplete();
            }
        }

        public void onError(Throwable th) {
            f.a(this.f39306b, this, (Object) null);
            InnerDisposable[] innerDisposableArr = (InnerDisposable[]) this.f39307c.getAndSet(f39305g);
            if (innerDisposableArr.length != 0) {
                for (InnerDisposable innerDisposable : innerDisposableArr) {
                    innerDisposable.f39303b.onError(th);
                }
                return;
            }
            RxJavaPlugins.s(th);
        }

        public void onNext(T t2) {
            for (InnerDisposable innerDisposable : (InnerDisposable[]) this.f39307c.get()) {
                innerDisposable.f39303b.onNext(t2);
            }
        }

        public void onSubscribe(Disposable disposable) {
            DisposableHelper.f(this.f39309e, disposable);
        }
    }

    static final class PublishSource<T> implements ObservableSource<T> {

        /* renamed from: b  reason: collision with root package name */
        private final AtomicReference<PublishObserver<T>> f39310b;

        PublishSource(AtomicReference<PublishObserver<T>> atomicReference) {
            this.f39310b = atomicReference;
        }

        public void subscribe(Observer<? super T> observer) {
            InnerDisposable innerDisposable = new InnerDisposable(observer);
            observer.onSubscribe(innerDisposable);
            while (true) {
                PublishObserver publishObserver = this.f39310b.get();
                if (publishObserver == null || publishObserver.isDisposed()) {
                    PublishObserver publishObserver2 = new PublishObserver(this.f39310b);
                    if (!f.a(this.f39310b, publishObserver, publishObserver2)) {
                        continue;
                    } else {
                        publishObserver = publishObserver2;
                    }
                }
                if (publishObserver.a(innerDisposable)) {
                    innerDisposable.a(publishObserver);
                    return;
                }
            }
        }
    }

    private ObservablePublish(ObservableSource<T> observableSource, ObservableSource<T> observableSource2, AtomicReference<PublishObserver<T>> atomicReference) {
        this.f39302d = observableSource;
        this.f39300b = observableSource2;
        this.f39301c = atomicReference;
    }

    public static <T> ConnectableObservable<T> d(ObservableSource<T> observableSource) {
        AtomicReference atomicReference = new AtomicReference();
        return RxJavaPlugins.p(new ObservablePublish(new PublishSource(atomicReference), observableSource, atomicReference));
    }

    /* JADX WARNING: Removed duplicated region for block: B:0:0x0000 A[LOOP_START, MTH_ENTER_BLOCK] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void b(io.reactivex.functions.Consumer<? super io.reactivex.disposables.Disposable> r5) {
        /*
            r4 = this;
        L_0x0000:
            java.util.concurrent.atomic.AtomicReference<io.reactivex.internal.operators.observable.ObservablePublish$PublishObserver<T>> r0 = r4.f39301c
            java.lang.Object r0 = r0.get()
            io.reactivex.internal.operators.observable.ObservablePublish$PublishObserver r0 = (io.reactivex.internal.operators.observable.ObservablePublish.PublishObserver) r0
            if (r0 == 0) goto L_0x0010
            boolean r1 = r0.isDisposed()
            if (r1 == 0) goto L_0x0021
        L_0x0010:
            io.reactivex.internal.operators.observable.ObservablePublish$PublishObserver r1 = new io.reactivex.internal.operators.observable.ObservablePublish$PublishObserver
            java.util.concurrent.atomic.AtomicReference<io.reactivex.internal.operators.observable.ObservablePublish$PublishObserver<T>> r2 = r4.f39301c
            r1.<init>(r2)
            java.util.concurrent.atomic.AtomicReference<io.reactivex.internal.operators.observable.ObservablePublish$PublishObserver<T>> r2 = r4.f39301c
            boolean r0 = androidx.media3.exoplayer.mediacodec.f.a(r2, r0, r1)
            if (r0 != 0) goto L_0x0020
            goto L_0x0000
        L_0x0020:
            r0 = r1
        L_0x0021:
            java.util.concurrent.atomic.AtomicBoolean r1 = r0.f39308d
            boolean r1 = r1.get()
            r2 = 0
            if (r1 != 0) goto L_0x0034
            java.util.concurrent.atomic.AtomicBoolean r1 = r0.f39308d
            r3 = 1
            boolean r1 = r1.compareAndSet(r2, r3)
            if (r1 == 0) goto L_0x0034
            r2 = 1
        L_0x0034:
            r5.accept(r0)     // Catch:{ all -> 0x003f }
            if (r2 == 0) goto L_0x003e
            io.reactivex.ObservableSource<T> r5 = r4.f39300b
            r5.subscribe(r0)
        L_0x003e:
            return
        L_0x003f:
            r5 = move-exception
            io.reactivex.exceptions.Exceptions.b(r5)
            java.lang.RuntimeException r5 = io.reactivex.internal.util.ExceptionHelper.d(r5)
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: io.reactivex.internal.operators.observable.ObservablePublish.b(io.reactivex.functions.Consumer):void");
    }

    /* access modifiers changed from: protected */
    public void subscribeActual(Observer<? super T> observer) {
        this.f39302d.subscribe(observer);
    }
}
