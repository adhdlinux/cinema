package io.reactivex.disposables;

import io.reactivex.functions.Action;
import io.reactivex.internal.disposables.EmptyDisposable;
import io.reactivex.internal.functions.Functions;
import io.reactivex.internal.functions.ObjectHelper;

public final class Disposables {
    private Disposables() {
        throw new IllegalStateException("No instances!");
    }

    public static Disposable a() {
        return EmptyDisposable.INSTANCE;
    }

    public static Disposable b() {
        return d(Functions.f38341b);
    }

    public static Disposable c(Action action) {
        ObjectHelper.e(action, "run is null");
        return new ActionDisposable(action);
    }

    public static Disposable d(Runnable runnable) {
        ObjectHelper.e(runnable, "run is null");
        return new RunnableDisposable(runnable);
    }
}
