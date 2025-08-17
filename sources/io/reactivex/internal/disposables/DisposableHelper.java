package io.reactivex.internal.disposables;

import androidx.media3.exoplayer.mediacodec.f;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.ProtocolViolationException;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.concurrent.atomic.AtomicReference;

public enum DisposableHelper implements Disposable {
    DISPOSED;

    public static boolean a(AtomicReference<Disposable> atomicReference) {
        Disposable andSet;
        Disposable disposable = atomicReference.get();
        DisposableHelper disposableHelper = DISPOSED;
        if (disposable == disposableHelper || (andSet = atomicReference.getAndSet(disposableHelper)) == disposableHelper) {
            return false;
        }
        if (andSet == null) {
            return true;
        }
        andSet.dispose();
        return true;
    }

    public static boolean b(Disposable disposable) {
        return disposable == DISPOSED;
    }

    public static boolean c(AtomicReference<Disposable> atomicReference, Disposable disposable) {
        Disposable disposable2;
        do {
            disposable2 = atomicReference.get();
            if (disposable2 == DISPOSED) {
                if (disposable == null) {
                    return false;
                }
                disposable.dispose();
                return false;
            }
        } while (!f.a(atomicReference, disposable2, disposable));
        return true;
    }

    public static void d() {
        RxJavaPlugins.s(new ProtocolViolationException("Disposable already set!"));
    }

    public static boolean e(AtomicReference<Disposable> atomicReference, Disposable disposable) {
        Disposable disposable2;
        do {
            disposable2 = atomicReference.get();
            if (disposable2 == DISPOSED) {
                if (disposable == null) {
                    return false;
                }
                disposable.dispose();
                return false;
            }
        } while (!f.a(atomicReference, disposable2, disposable));
        if (disposable2 == null) {
            return true;
        }
        disposable2.dispose();
        return true;
    }

    public static boolean f(AtomicReference<Disposable> atomicReference, Disposable disposable) {
        ObjectHelper.e(disposable, "d is null");
        if (f.a(atomicReference, (Object) null, disposable)) {
            return true;
        }
        disposable.dispose();
        if (atomicReference.get() == DISPOSED) {
            return false;
        }
        d();
        return false;
    }

    public static boolean g(AtomicReference<Disposable> atomicReference, Disposable disposable) {
        if (f.a(atomicReference, (Object) null, disposable)) {
            return true;
        }
        if (atomicReference.get() != DISPOSED) {
            return false;
        }
        disposable.dispose();
        return false;
    }

    public static boolean h(Disposable disposable, Disposable disposable2) {
        if (disposable2 == null) {
            RxJavaPlugins.s(new NullPointerException("next is null"));
            return false;
        } else if (disposable == null) {
            return true;
        } else {
            disposable2.dispose();
            d();
            return false;
        }
    }

    public void dispose() {
    }

    public boolean isDisposed() {
        return true;
    }
}
