package io.reactivex.internal.operators.mixed;

import io.reactivex.CompletableObserver;
import io.reactivex.CompletableSource;
import io.reactivex.MaybeSource;
import io.reactivex.Observer;
import io.reactivex.SingleSource;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.Function;
import io.reactivex.internal.disposables.EmptyDisposable;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.operators.maybe.MaybeToObservable;
import io.reactivex.internal.operators.single.SingleToObservable;
import java.util.concurrent.Callable;

final class ScalarXMapZHelper {
    private ScalarXMapZHelper() {
        throw new IllegalStateException("No instances!");
    }

    static <T> boolean a(Object obj, Function<? super T, ? extends CompletableSource> function, CompletableObserver completableObserver) {
        CompletableSource completableSource;
        if (!(obj instanceof Callable)) {
            return false;
        }
        try {
            Object call = ((Callable) obj).call();
            if (call != null) {
                completableSource = (CompletableSource) ObjectHelper.e(function.apply(call), "The mapper returned a null CompletableSource");
            } else {
                completableSource = null;
            }
            if (completableSource == null) {
                EmptyDisposable.a(completableObserver);
            } else {
                completableSource.a(completableObserver);
            }
            return true;
        } catch (Throwable th) {
            Exceptions.b(th);
            EmptyDisposable.d(th, completableObserver);
            return true;
        }
    }

    static <T, R> boolean b(Object obj, Function<? super T, ? extends MaybeSource<? extends R>> function, Observer<? super R> observer) {
        MaybeSource maybeSource;
        if (!(obj instanceof Callable)) {
            return false;
        }
        try {
            Object call = ((Callable) obj).call();
            if (call != null) {
                maybeSource = (MaybeSource) ObjectHelper.e(function.apply(call), "The mapper returned a null MaybeSource");
            } else {
                maybeSource = null;
            }
            if (maybeSource == null) {
                EmptyDisposable.c(observer);
            } else {
                maybeSource.a(MaybeToObservable.b(observer));
            }
            return true;
        } catch (Throwable th) {
            Exceptions.b(th);
            EmptyDisposable.e(th, observer);
            return true;
        }
    }

    static <T, R> boolean c(Object obj, Function<? super T, ? extends SingleSource<? extends R>> function, Observer<? super R> observer) {
        SingleSource singleSource;
        if (!(obj instanceof Callable)) {
            return false;
        }
        try {
            Object call = ((Callable) obj).call();
            if (call != null) {
                singleSource = (SingleSource) ObjectHelper.e(function.apply(call), "The mapper returned a null SingleSource");
            } else {
                singleSource = null;
            }
            if (singleSource == null) {
                EmptyDisposable.c(observer);
            } else {
                singleSource.a(SingleToObservable.b(observer));
            }
            return true;
        } catch (Throwable th) {
            Exceptions.b(th);
            EmptyDisposable.e(th, observer);
            return true;
        }
    }
}
