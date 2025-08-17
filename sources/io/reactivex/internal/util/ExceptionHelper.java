package io.reactivex.internal.util;

import androidx.media3.exoplayer.mediacodec.f;
import io.reactivex.exceptions.CompositeException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;

public final class ExceptionHelper {

    /* renamed from: a  reason: collision with root package name */
    public static final Throwable f40066a = new Termination();

    static final class Termination extends Throwable {
        Termination() {
            super("No further exceptions");
        }

        public Throwable fillInStackTrace() {
            return this;
        }
    }

    private ExceptionHelper() {
        throw new IllegalStateException("No instances!");
    }

    public static <T> boolean a(AtomicReference<Throwable> atomicReference, Throwable th) {
        Throwable th2;
        Throwable th3;
        do {
            th2 = atomicReference.get();
            if (th2 == f40066a) {
                return false;
            }
            if (th2 == null) {
                th3 = th;
            } else {
                th3 = new CompositeException(th2, th);
            }
        } while (!f.a(atomicReference, th2, th3));
        return true;
    }

    public static <T> Throwable b(AtomicReference<Throwable> atomicReference) {
        Throwable th = atomicReference.get();
        Throwable th2 = f40066a;
        if (th != th2) {
            return atomicReference.getAndSet(th2);
        }
        return th;
    }

    public static String c(long j2, TimeUnit timeUnit) {
        return "The source did not signal an event for " + j2 + " " + timeUnit.toString().toLowerCase() + " and has been terminated.";
    }

    public static RuntimeException d(Throwable th) {
        if (th instanceof Error) {
            throw ((Error) th);
        } else if (th instanceof RuntimeException) {
            return (RuntimeException) th;
        } else {
            return new RuntimeException(th);
        }
    }
}
