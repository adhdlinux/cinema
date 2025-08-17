package io.reactivex.internal.operators.observable;

import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.concurrent.atomic.AtomicReference;

public final class ObservableCreate<T> extends Observable<T> {

    /* renamed from: b  reason: collision with root package name */
    final ObservableOnSubscribe<T> f38875b;

    static final class CreateEmitter<T> extends AtomicReference<Disposable> implements ObservableEmitter<T>, Disposable {

        /* renamed from: b  reason: collision with root package name */
        final Observer<? super T> f38876b;

        CreateEmitter(Observer<? super T> observer) {
            this.f38876b = observer;
        }

        public void b(Throwable th) {
            if (!c(th)) {
                RxJavaPlugins.s(th);
            }
        }

        /* JADX INFO: finally extract failed */
        public boolean c(Throwable th) {
            if (th == null) {
                th = new NullPointerException("onError called with null. Null values are generally not allowed in 2.x operators and sources.");
            }
            if (isDisposed()) {
                return false;
            }
            try {
                this.f38876b.onError(th);
                dispose();
                return true;
            } catch (Throwable th2) {
                dispose();
                throw th2;
            }
        }

        public void dispose() {
            DisposableHelper.a(this);
        }

        public boolean isDisposed() {
            return DisposableHelper.b((Disposable) get());
        }

        public void onComplete() {
            if (!isDisposed()) {
                try {
                    this.f38876b.onComplete();
                } finally {
                    dispose();
                }
            }
        }

        public void onNext(T t2) {
            if (t2 == null) {
                b(new NullPointerException("onNext called with null. Null values are generally not allowed in 2.x operators and sources."));
            } else if (!isDisposed()) {
                this.f38876b.onNext(t2);
            }
        }

        public String toString() {
            return String.format("%s{%s}", new Object[]{CreateEmitter.class.getSimpleName(), super.toString()});
        }
    }

    public ObservableCreate(ObservableOnSubscribe<T> observableOnSubscribe) {
        this.f38875b = observableOnSubscribe;
    }

    /* access modifiers changed from: protected */
    public void subscribeActual(Observer<? super T> observer) {
        CreateEmitter createEmitter = new CreateEmitter(observer);
        observer.onSubscribe(createEmitter);
        try {
            this.f38875b.subscribe(createEmitter);
        } catch (Throwable th) {
            Exceptions.b(th);
            createEmitter.b(th);
        }
    }
}
