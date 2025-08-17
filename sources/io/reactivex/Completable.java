package io.reactivex;

import io.reactivex.exceptions.Exceptions;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.plugins.RxJavaPlugins;

public abstract class Completable implements CompletableSource {
    private static NullPointerException d(Throwable th) {
        NullPointerException nullPointerException = new NullPointerException("Actually not, but can't pass out an exception otherwise...");
        nullPointerException.initCause(th);
        return nullPointerException;
    }

    public final void a(CompletableObserver completableObserver) {
        ObjectHelper.e(completableObserver, "observer is null");
        try {
            CompletableObserver w2 = RxJavaPlugins.w(this, completableObserver);
            ObjectHelper.e(w2, "The RxJavaPlugins.onSubscribe hook returned a null CompletableObserver. Please check the handler provided to RxJavaPlugins.setOnCompletableSubscribe for invalid null returns. Further reading: https://github.com/ReactiveX/RxJava/wiki/Plugins");
            c(w2);
        } catch (NullPointerException e2) {
            throw e2;
        } catch (Throwable th) {
            Exceptions.b(th);
            RxJavaPlugins.s(th);
            throw d(th);
        }
    }

    /* access modifiers changed from: protected */
    public abstract void c(CompletableObserver completableObserver);
}
