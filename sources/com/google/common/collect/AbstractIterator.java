package com.google.common.collect;

import com.google.common.base.Preconditions;
import java.util.NoSuchElementException;

public abstract class AbstractIterator<T> extends UnmodifiableIterator<T> {

    /* renamed from: b  reason: collision with root package name */
    private State f30426b = State.NOT_READY;

    /* renamed from: c  reason: collision with root package name */
    private T f30427c;

    /* renamed from: com.google.common.collect.AbstractIterator$1  reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f30428a;

        /* JADX WARNING: Can't wrap try/catch for region: R(6:0|1|2|3|4|6) */
        /* JADX WARNING: Code restructure failed: missing block: B:7:?, code lost:
            return;
         */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        static {
            /*
                com.google.common.collect.AbstractIterator$State[] r0 = com.google.common.collect.AbstractIterator.State.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                f30428a = r0
                com.google.common.collect.AbstractIterator$State r1 = com.google.common.collect.AbstractIterator.State.DONE     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = f30428a     // Catch:{ NoSuchFieldError -> 0x001d }
                com.google.common.collect.AbstractIterator$State r1 = com.google.common.collect.AbstractIterator.State.READY     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.common.collect.AbstractIterator.AnonymousClass1.<clinit>():void");
        }
    }

    private enum State {
        READY,
        NOT_READY,
        DONE,
        FAILED
    }

    protected AbstractIterator() {
    }

    private boolean c() {
        this.f30426b = State.FAILED;
        this.f30427c = a();
        if (this.f30426b == State.DONE) {
            return false;
        }
        this.f30426b = State.READY;
        return true;
    }

    /* access modifiers changed from: protected */
    public abstract T a();

    /* access modifiers changed from: protected */
    public final T b() {
        this.f30426b = State.DONE;
        return null;
    }

    public final boolean hasNext() {
        boolean z2;
        if (this.f30426b != State.FAILED) {
            z2 = true;
        } else {
            z2 = false;
        }
        Preconditions.q(z2);
        int i2 = AnonymousClass1.f30428a[this.f30426b.ordinal()];
        if (i2 == 1) {
            return false;
        }
        if (i2 != 2) {
            return c();
        }
        return true;
    }

    public final T next() {
        if (hasNext()) {
            this.f30426b = State.NOT_READY;
            T a2 = NullnessCasts.a(this.f30427c);
            this.f30427c = null;
            return a2;
        }
        throw new NoSuchElementException();
    }
}
