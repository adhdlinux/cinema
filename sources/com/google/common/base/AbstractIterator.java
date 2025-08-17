package com.google.common.base;

import java.util.Iterator;
import java.util.NoSuchElementException;

abstract class AbstractIterator<T> implements Iterator<T> {

    /* renamed from: b  reason: collision with root package name */
    private State f30377b = State.NOT_READY;

    /* renamed from: c  reason: collision with root package name */
    private T f30378c;

    /* renamed from: com.google.common.base.AbstractIterator$1  reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f30379a;

        /* JADX WARNING: Can't wrap try/catch for region: R(6:0|1|2|3|4|6) */
        /* JADX WARNING: Code restructure failed: missing block: B:7:?, code lost:
            return;
         */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        static {
            /*
                com.google.common.base.AbstractIterator$State[] r0 = com.google.common.base.AbstractIterator.State.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                f30379a = r0
                com.google.common.base.AbstractIterator$State r1 = com.google.common.base.AbstractIterator.State.DONE     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = f30379a     // Catch:{ NoSuchFieldError -> 0x001d }
                com.google.common.base.AbstractIterator$State r1 = com.google.common.base.AbstractIterator.State.READY     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.common.base.AbstractIterator.AnonymousClass1.<clinit>():void");
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
        this.f30377b = State.FAILED;
        this.f30378c = a();
        if (this.f30377b == State.DONE) {
            return false;
        }
        this.f30377b = State.READY;
        return true;
    }

    /* access modifiers changed from: protected */
    public abstract T a();

    /* access modifiers changed from: protected */
    public final T b() {
        this.f30377b = State.DONE;
        return null;
    }

    public final boolean hasNext() {
        boolean z2;
        if (this.f30377b != State.FAILED) {
            z2 = true;
        } else {
            z2 = false;
        }
        Preconditions.q(z2);
        int i2 = AnonymousClass1.f30379a[this.f30377b.ordinal()];
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
            this.f30377b = State.NOT_READY;
            T a2 = NullnessCasts.a(this.f30378c);
            this.f30378c = null;
            return a2;
        }
        throw new NoSuchElementException();
    }

    public final void remove() {
        throw new UnsupportedOperationException();
    }
}
