package com.google.android.exoplayer2.decoder;

import com.google.android.exoplayer2.decoder.DecoderException;
import com.google.android.exoplayer2.decoder.DecoderInputBuffer;
import com.google.android.exoplayer2.decoder.DecoderOutputBuffer;
import com.google.android.exoplayer2.util.Assertions;
import java.util.ArrayDeque;

public abstract class SimpleDecoder<I extends DecoderInputBuffer, O extends DecoderOutputBuffer, E extends DecoderException> implements Decoder<I, O, E> {

    /* renamed from: a  reason: collision with root package name */
    private final Thread f23976a;

    /* renamed from: b  reason: collision with root package name */
    private final Object f23977b = new Object();

    /* renamed from: c  reason: collision with root package name */
    private final ArrayDeque<I> f23978c = new ArrayDeque<>();

    /* renamed from: d  reason: collision with root package name */
    private final ArrayDeque<O> f23979d = new ArrayDeque<>();

    /* renamed from: e  reason: collision with root package name */
    private final I[] f23980e;

    /* renamed from: f  reason: collision with root package name */
    private final O[] f23981f;

    /* renamed from: g  reason: collision with root package name */
    private int f23982g;

    /* renamed from: h  reason: collision with root package name */
    private int f23983h;

    /* renamed from: i  reason: collision with root package name */
    private I f23984i;

    /* renamed from: j  reason: collision with root package name */
    private E f23985j;

    /* renamed from: k  reason: collision with root package name */
    private boolean f23986k;

    /* renamed from: l  reason: collision with root package name */
    private boolean f23987l;

    /* renamed from: m  reason: collision with root package name */
    private int f23988m;

    protected SimpleDecoder(I[] iArr, O[] oArr) {
        this.f23980e = iArr;
        this.f23982g = iArr.length;
        for (int i2 = 0; i2 < this.f23982g; i2++) {
            this.f23980e[i2] = g();
        }
        this.f23981f = oArr;
        this.f23983h = oArr.length;
        for (int i3 = 0; i3 < this.f23983h; i3++) {
            this.f23981f[i3] = h();
        }
        AnonymousClass1 r4 = new Thread("ExoPlayer:SimpleDecoder") {
            public void run() {
                SimpleDecoder.this.t();
            }
        };
        this.f23976a = r4;
        r4.start();
    }

    private boolean f() {
        return !this.f23978c.isEmpty() && this.f23983h > 0;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:15:0x0035, code lost:
        if (r1.k() == false) goto L_0x003c;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:16:0x0037, code lost:
        r3.e(4);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:18:0x0040, code lost:
        if (r1.j() == false) goto L_0x0047;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:19:0x0042, code lost:
        r3.e(Integer.MIN_VALUE);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:21:0x004b, code lost:
        if (r1.l() == false) goto L_0x0052;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:22:0x004d, code lost:
        r3.e(134217728);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:24:?, code lost:
        r0 = j(r1, r3, r4);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:25:0x0057, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:26:0x0058, code lost:
        r0 = i(r0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:27:0x005d, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:28:0x005e, code lost:
        r0 = i(r0);
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private boolean k() throws java.lang.InterruptedException {
        /*
            r6 = this;
            java.lang.Object r0 = r6.f23977b
            monitor-enter(r0)
        L_0x0003:
            boolean r1 = r6.f23987l     // Catch:{ all -> 0x009b }
            if (r1 != 0) goto L_0x0013
            boolean r1 = r6.f()     // Catch:{ all -> 0x009b }
            if (r1 != 0) goto L_0x0013
            java.lang.Object r1 = r6.f23977b     // Catch:{ all -> 0x009b }
            r1.wait()     // Catch:{ all -> 0x009b }
            goto L_0x0003
        L_0x0013:
            boolean r1 = r6.f23987l     // Catch:{ all -> 0x009b }
            r2 = 0
            if (r1 == 0) goto L_0x001a
            monitor-exit(r0)     // Catch:{ all -> 0x009b }
            return r2
        L_0x001a:
            java.util.ArrayDeque<I> r1 = r6.f23978c     // Catch:{ all -> 0x009b }
            java.lang.Object r1 = r1.removeFirst()     // Catch:{ all -> 0x009b }
            com.google.android.exoplayer2.decoder.DecoderInputBuffer r1 = (com.google.android.exoplayer2.decoder.DecoderInputBuffer) r1     // Catch:{ all -> 0x009b }
            O[] r3 = r6.f23981f     // Catch:{ all -> 0x009b }
            int r4 = r6.f23983h     // Catch:{ all -> 0x009b }
            r5 = 1
            int r4 = r4 - r5
            r6.f23983h = r4     // Catch:{ all -> 0x009b }
            r3 = r3[r4]     // Catch:{ all -> 0x009b }
            boolean r4 = r6.f23986k     // Catch:{ all -> 0x009b }
            r6.f23986k = r2     // Catch:{ all -> 0x009b }
            monitor-exit(r0)     // Catch:{ all -> 0x009b }
            boolean r0 = r1.k()
            if (r0 == 0) goto L_0x003c
            r0 = 4
            r3.e(r0)
            goto L_0x006e
        L_0x003c:
            boolean r0 = r1.j()
            if (r0 == 0) goto L_0x0047
            r0 = -2147483648(0xffffffff80000000, float:-0.0)
            r3.e(r0)
        L_0x0047:
            boolean r0 = r1.l()
            if (r0 == 0) goto L_0x0052
            r0 = 134217728(0x8000000, float:3.85186E-34)
            r3.e(r0)
        L_0x0052:
            com.google.android.exoplayer2.decoder.DecoderException r0 = r6.j(r1, r3, r4)     // Catch:{ RuntimeException -> 0x005d, OutOfMemoryError -> 0x0057 }
            goto L_0x0062
        L_0x0057:
            r0 = move-exception
            com.google.android.exoplayer2.decoder.DecoderException r0 = r6.i(r0)
            goto L_0x0062
        L_0x005d:
            r0 = move-exception
            com.google.android.exoplayer2.decoder.DecoderException r0 = r6.i(r0)
        L_0x0062:
            if (r0 == 0) goto L_0x006e
            java.lang.Object r4 = r6.f23977b
            monitor-enter(r4)
            r6.f23985j = r0     // Catch:{ all -> 0x006b }
            monitor-exit(r4)     // Catch:{ all -> 0x006b }
            return r2
        L_0x006b:
            r0 = move-exception
            monitor-exit(r4)     // Catch:{ all -> 0x006b }
            throw r0
        L_0x006e:
            java.lang.Object r4 = r6.f23977b
            monitor-enter(r4)
            boolean r0 = r6.f23986k     // Catch:{ all -> 0x0098 }
            if (r0 == 0) goto L_0x0079
            r3.p()     // Catch:{ all -> 0x0098 }
            goto L_0x0093
        L_0x0079:
            boolean r0 = r3.j()     // Catch:{ all -> 0x0098 }
            if (r0 == 0) goto L_0x0088
            int r0 = r6.f23988m     // Catch:{ all -> 0x0098 }
            int r0 = r0 + r5
            r6.f23988m = r0     // Catch:{ all -> 0x0098 }
            r3.p()     // Catch:{ all -> 0x0098 }
            goto L_0x0093
        L_0x0088:
            int r0 = r6.f23988m     // Catch:{ all -> 0x0098 }
            r3.f23970d = r0     // Catch:{ all -> 0x0098 }
            r6.f23988m = r2     // Catch:{ all -> 0x0098 }
            java.util.ArrayDeque<O> r0 = r6.f23979d     // Catch:{ all -> 0x0098 }
            r0.addLast(r3)     // Catch:{ all -> 0x0098 }
        L_0x0093:
            r6.q(r1)     // Catch:{ all -> 0x0098 }
            monitor-exit(r4)     // Catch:{ all -> 0x0098 }
            return r5
        L_0x0098:
            r0 = move-exception
            monitor-exit(r4)     // Catch:{ all -> 0x0098 }
            throw r0
        L_0x009b:
            r1 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x009b }
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.decoder.SimpleDecoder.k():boolean");
    }

    private void n() {
        if (f()) {
            this.f23977b.notify();
        }
    }

    private void o() throws DecoderException {
        E e2 = this.f23985j;
        if (e2 != null) {
            throw e2;
        }
    }

    private void q(I i2) {
        i2.f();
        I[] iArr = this.f23980e;
        int i3 = this.f23982g;
        this.f23982g = i3 + 1;
        iArr[i3] = i2;
    }

    private void s(O o2) {
        o2.f();
        O[] oArr = this.f23981f;
        int i2 = this.f23983h;
        this.f23983h = i2 + 1;
        oArr[i2] = o2;
    }

    /* access modifiers changed from: private */
    public void t() {
        do {
            try {
            } catch (InterruptedException e2) {
                throw new IllegalStateException(e2);
            }
        } while (k());
    }

    public final void flush() {
        synchronized (this.f23977b) {
            this.f23986k = true;
            this.f23988m = 0;
            I i2 = this.f23984i;
            if (i2 != null) {
                q(i2);
                this.f23984i = null;
            }
            while (!this.f23978c.isEmpty()) {
                q((DecoderInputBuffer) this.f23978c.removeFirst());
            }
            while (!this.f23979d.isEmpty()) {
                ((DecoderOutputBuffer) this.f23979d.removeFirst()).p();
            }
        }
    }

    /* access modifiers changed from: protected */
    public abstract I g();

    /* access modifiers changed from: protected */
    public abstract O h();

    /* access modifiers changed from: protected */
    public abstract E i(Throwable th);

    /* access modifiers changed from: protected */
    public abstract E j(I i2, O o2, boolean z2);

    /* renamed from: l */
    public final I d() throws DecoderException {
        boolean z2;
        I i2;
        synchronized (this.f23977b) {
            o();
            if (this.f23984i == null) {
                z2 = true;
            } else {
                z2 = false;
            }
            Assertions.g(z2);
            int i3 = this.f23982g;
            if (i3 == 0) {
                i2 = null;
            } else {
                I[] iArr = this.f23980e;
                int i4 = i3 - 1;
                this.f23982g = i4;
                i2 = iArr[i4];
            }
            this.f23984i = i2;
        }
        return i2;
    }

    /* renamed from: m */
    public final O a() throws DecoderException {
        synchronized (this.f23977b) {
            o();
            if (this.f23979d.isEmpty()) {
                return null;
            }
            O o2 = (DecoderOutputBuffer) this.f23979d.removeFirst();
            return o2;
        }
    }

    /* renamed from: p */
    public final void c(I i2) throws DecoderException {
        boolean z2;
        synchronized (this.f23977b) {
            o();
            if (i2 == this.f23984i) {
                z2 = true;
            } else {
                z2 = false;
            }
            Assertions.a(z2);
            this.f23978c.addLast(i2);
            n();
            this.f23984i = null;
        }
    }

    /* access modifiers changed from: protected */
    public void r(O o2) {
        synchronized (this.f23977b) {
            s(o2);
            n();
        }
    }

    public void release() {
        synchronized (this.f23977b) {
            this.f23987l = true;
            this.f23977b.notify();
        }
        try {
            this.f23976a.join();
        } catch (InterruptedException unused) {
            Thread.currentThread().interrupt();
        }
    }

    /* access modifiers changed from: protected */
    public final void u(int i2) {
        boolean z2;
        if (this.f23982g == this.f23980e.length) {
            z2 = true;
        } else {
            z2 = false;
        }
        Assertions.g(z2);
        for (I q2 : this.f23980e) {
            q2.q(i2);
        }
    }
}
