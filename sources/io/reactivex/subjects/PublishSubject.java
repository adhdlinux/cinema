package io.reactivex.subjects;

import androidx.media3.exoplayer.mediacodec.f;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;

public final class PublishSubject<T> extends Subject<T> {

    /* renamed from: d  reason: collision with root package name */
    static final PublishDisposable[] f40156d = new PublishDisposable[0];

    /* renamed from: e  reason: collision with root package name */
    static final PublishDisposable[] f40157e = new PublishDisposable[0];

    /* renamed from: b  reason: collision with root package name */
    final AtomicReference<PublishDisposable<T>[]> f40158b = new AtomicReference<>(f40157e);

    /* renamed from: c  reason: collision with root package name */
    Throwable f40159c;

    static final class PublishDisposable<T> extends AtomicBoolean implements Disposable {

        /* renamed from: b  reason: collision with root package name */
        final Observer<? super T> f40160b;

        /* renamed from: c  reason: collision with root package name */
        final PublishSubject<T> f40161c;

        PublishDisposable(Observer<? super T> observer, PublishSubject<T> publishSubject) {
            this.f40160b = observer;
            this.f40161c = publishSubject;
        }

        public void a() {
            if (!get()) {
                this.f40160b.onComplete();
            }
        }

        public void b(Throwable th) {
            if (get()) {
                RxJavaPlugins.s(th);
            } else {
                this.f40160b.onError(th);
            }
        }

        public void c(T t2) {
            if (!get()) {
                this.f40160b.onNext(t2);
            }
        }

        public void dispose() {
            if (compareAndSet(false, true)) {
                this.f40161c.e(this);
            }
        }

        public boolean isDisposed() {
            return get();
        }
    }

    PublishSubject() {
    }

    public static <T> PublishSubject<T> d() {
        return new PublishSubject<>();
    }

    /* access modifiers changed from: package-private */
    public boolean c(PublishDisposable<T> publishDisposable) {
        PublishDisposable[] publishDisposableArr;
        PublishDisposable[] publishDisposableArr2;
        do {
            publishDisposableArr = (PublishDisposable[]) this.f40158b.get();
            if (publishDisposableArr == f40156d) {
                return false;
            }
            int length = publishDisposableArr.length;
            publishDisposableArr2 = new PublishDisposable[(length + 1)];
            System.arraycopy(publishDisposableArr, 0, publishDisposableArr2, 0, length);
            publishDisposableArr2[length] = publishDisposable;
        } while (!f.a(this.f40158b, publishDisposableArr, publishDisposableArr2));
        return true;
    }

    /* access modifiers changed from: package-private */
    public void e(PublishDisposable<T> publishDisposable) {
        PublishDisposable<T>[] publishDisposableArr;
        PublishDisposable[] publishDisposableArr2;
        do {
            publishDisposableArr = (PublishDisposable[]) this.f40158b.get();
            if (publishDisposableArr != f40156d && publishDisposableArr != f40157e) {
                int length = publishDisposableArr.length;
                int i2 = 0;
                while (true) {
                    if (i2 >= length) {
                        i2 = -1;
                        break;
                    } else if (publishDisposableArr[i2] == publishDisposable) {
                        break;
                    } else {
                        i2++;
                    }
                }
                if (i2 >= 0) {
                    if (length == 1) {
                        publishDisposableArr2 = f40157e;
                    } else {
                        PublishDisposable[] publishDisposableArr3 = new PublishDisposable[(length - 1)];
                        System.arraycopy(publishDisposableArr, 0, publishDisposableArr3, 0, i2);
                        System.arraycopy(publishDisposableArr, i2 + 1, publishDisposableArr3, i2, (length - i2) - 1);
                        publishDisposableArr2 = publishDisposableArr3;
                    }
                } else {
                    return;
                }
            } else {
                return;
            }
        } while (!f.a(this.f40158b, publishDisposableArr, publishDisposableArr2));
    }

    public void onComplete() {
        PublishDisposable<T>[] publishDisposableArr = this.f40158b.get();
        PublishDisposable<T>[] publishDisposableArr2 = f40156d;
        if (publishDisposableArr != publishDisposableArr2) {
            for (PublishDisposable a2 : (PublishDisposable[]) this.f40158b.getAndSet(publishDisposableArr2)) {
                a2.a();
            }
        }
    }

    public void onError(Throwable th) {
        ObjectHelper.e(th, "onError called with null. Null values are generally not allowed in 2.x operators and sources.");
        PublishDisposable<T>[] publishDisposableArr = this.f40158b.get();
        PublishDisposable<T>[] publishDisposableArr2 = f40156d;
        if (publishDisposableArr == publishDisposableArr2) {
            RxJavaPlugins.s(th);
            return;
        }
        this.f40159c = th;
        for (PublishDisposable b2 : (PublishDisposable[]) this.f40158b.getAndSet(publishDisposableArr2)) {
            b2.b(th);
        }
    }

    public void onNext(T t2) {
        ObjectHelper.e(t2, "onNext called with null. Null values are generally not allowed in 2.x operators and sources.");
        for (PublishDisposable c2 : (PublishDisposable[]) this.f40158b.get()) {
            c2.c(t2);
        }
    }

    public void onSubscribe(Disposable disposable) {
        if (this.f40158b.get() == f40156d) {
            disposable.dispose();
        }
    }

    /* access modifiers changed from: protected */
    public void subscribeActual(Observer<? super T> observer) {
        PublishDisposable publishDisposable = new PublishDisposable(observer, this);
        observer.onSubscribe(publishDisposable);
        if (!c(publishDisposable)) {
            Throwable th = this.f40159c;
            if (th != null) {
                observer.onError(th);
            } else {
                observer.onComplete();
            }
        } else if (publishDisposable.isDisposed()) {
            e(publishDisposable);
        }
    }
}
