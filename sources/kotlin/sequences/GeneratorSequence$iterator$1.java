package kotlin.sequences;

import java.util.Iterator;
import java.util.NoSuchElementException;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.markers.KMappedMarker;

public final class GeneratorSequence$iterator$1 implements Iterator<T>, KMappedMarker {

    /* renamed from: b  reason: collision with root package name */
    private T f40498b;

    /* renamed from: c  reason: collision with root package name */
    private int f40499c = -2;

    /* renamed from: d  reason: collision with root package name */
    final /* synthetic */ GeneratorSequence<T> f40500d;

    GeneratorSequence$iterator$1(GeneratorSequence<T> generatorSequence) {
        this.f40500d = generatorSequence;
    }

    private final void a() {
        T t2;
        int i2;
        if (this.f40499c == -2) {
            t2 = this.f40500d.f40496a.invoke();
        } else {
            Function1 c2 = this.f40500d.f40497b;
            T t3 = this.f40498b;
            Intrinsics.c(t3);
            t2 = c2.invoke(t3);
        }
        this.f40498b = t2;
        if (t2 == null) {
            i2 = 0;
        } else {
            i2 = 1;
        }
        this.f40499c = i2;
    }

    public boolean hasNext() {
        if (this.f40499c < 0) {
            a();
        }
        if (this.f40499c == 1) {
            return true;
        }
        return false;
    }

    public T next() {
        if (this.f40499c < 0) {
            a();
        }
        if (this.f40499c != 0) {
            T t2 = this.f40498b;
            Intrinsics.d(t2, "null cannot be cast to non-null type T of kotlin.sequences.GeneratorSequence");
            this.f40499c = -1;
            return t2;
        }
        throw new NoSuchElementException();
    }

    public void remove() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }
}
