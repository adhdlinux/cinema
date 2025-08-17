package io.reactivex.internal.operators.observable;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.internal.disposables.EmptyDisposable;
import io.reactivex.internal.fuseable.ScalarCallable;

public final class ObservableEmpty extends Observable<Object> implements ScalarCallable<Object> {

    /* renamed from: b  reason: collision with root package name */
    public static final Observable<Object> f38991b = new ObservableEmpty();

    private ObservableEmpty() {
    }

    public Object call() {
        return null;
    }

    /* access modifiers changed from: protected */
    public void subscribeActual(Observer<? super Object> observer) {
        EmptyDisposable.c(observer);
    }
}
