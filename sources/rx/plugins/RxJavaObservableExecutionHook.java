package rx.plugins;

import rx.Observable;

public abstract class RxJavaObservableExecutionHook {
    public <T> Observable.OnSubscribe<T> a(Observable.OnSubscribe<T> onSubscribe) {
        return onSubscribe;
    }
}
