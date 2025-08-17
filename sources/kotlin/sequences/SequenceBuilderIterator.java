package kotlin.sequences;

import java.util.Iterator;
import java.util.NoSuchElementException;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.markers.KMappedMarker;

final class SequenceBuilderIterator<T> extends SequenceScope<T> implements Iterator<T>, Continuation<Unit>, KMappedMarker {

    /* renamed from: b  reason: collision with root package name */
    private int f40501b;

    /* renamed from: c  reason: collision with root package name */
    private T f40502c;

    /* renamed from: d  reason: collision with root package name */
    private Iterator<? extends T> f40503d;

    /* renamed from: e  reason: collision with root package name */
    private Continuation<? super Unit> f40504e;

    private final Throwable j() {
        int i2 = this.f40501b;
        if (i2 == 4) {
            return new NoSuchElementException();
        }
        if (i2 == 5) {
            return new IllegalStateException("Iterator has failed.");
        }
        return new IllegalStateException("Unexpected state of the iterator: " + this.f40501b);
    }

    private final T k() {
        if (hasNext()) {
            return next();
        }
        throw new NoSuchElementException();
    }

    public Object a(T t2, Continuation<? super Unit> continuation) {
        this.f40502c = t2;
        this.f40501b = 3;
        this.f40504e = continuation;
        Object e2 = IntrinsicsKt__IntrinsicsKt.e();
        if (e2 == IntrinsicsKt__IntrinsicsKt.e()) {
            DebugProbesKt.c(continuation);
        }
        if (e2 == IntrinsicsKt__IntrinsicsKt.e()) {
            return e2;
        }
        return Unit.f40298a;
    }

    public Object f(Iterator<? extends T> it2, Continuation<? super Unit> continuation) {
        if (!it2.hasNext()) {
            return Unit.f40298a;
        }
        this.f40503d = it2;
        this.f40501b = 2;
        this.f40504e = continuation;
        Object e2 = IntrinsicsKt__IntrinsicsKt.e();
        if (e2 == IntrinsicsKt__IntrinsicsKt.e()) {
            DebugProbesKt.c(continuation);
        }
        if (e2 == IntrinsicsKt__IntrinsicsKt.e()) {
            return e2;
        }
        return Unit.f40298a;
    }

    public CoroutineContext getContext() {
        return EmptyCoroutineContext.f40358b;
    }

    public boolean hasNext() {
        while (true) {
            int i2 = this.f40501b;
            if (i2 != 0) {
                if (i2 == 1) {
                    Iterator<? extends T> it2 = this.f40503d;
                    Intrinsics.c(it2);
                    if (it2.hasNext()) {
                        this.f40501b = 2;
                        return true;
                    }
                    this.f40503d = null;
                } else if (i2 == 2 || i2 == 3) {
                    return true;
                } else {
                    if (i2 == 4) {
                        return false;
                    }
                    throw j();
                }
            }
            this.f40501b = 5;
            Continuation<? super Unit> continuation = this.f40504e;
            Intrinsics.c(continuation);
            this.f40504e = null;
            Result.Companion companion = Result.f40263c;
            continuation.resumeWith(Result.b(Unit.f40298a));
        }
    }

    public final void l(Continuation<? super Unit> continuation) {
        this.f40504e = continuation;
    }

    public T next() {
        int i2 = this.f40501b;
        if (i2 == 0 || i2 == 1) {
            return k();
        }
        if (i2 == 2) {
            this.f40501b = 1;
            Iterator<? extends T> it2 = this.f40503d;
            Intrinsics.c(it2);
            return it2.next();
        } else if (i2 == 3) {
            this.f40501b = 0;
            T t2 = this.f40502c;
            this.f40502c = null;
            return t2;
        } else {
            throw j();
        }
    }

    public void remove() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public void resumeWith(Object obj) {
        ResultKt.b(obj);
        this.f40501b = 4;
    }
}
