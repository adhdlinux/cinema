package androidx.media3.decoder;

import androidx.media3.common.util.Assertions;
import androidx.media3.decoder.DecoderException;
import androidx.media3.decoder.DecoderInputBuffer;
import androidx.media3.decoder.DecoderOutputBuffer;
import java.util.ArrayDeque;

public abstract class SimpleDecoder<I extends DecoderInputBuffer, O extends DecoderOutputBuffer, E extends DecoderException> implements Decoder<I, O, E> {

    /* renamed from: a  reason: collision with root package name */
    private final Thread f5075a;

    /* renamed from: b  reason: collision with root package name */
    private final Object f5076b = new Object();

    /* renamed from: c  reason: collision with root package name */
    private final ArrayDeque<I> f5077c = new ArrayDeque<>();

    /* renamed from: d  reason: collision with root package name */
    private final ArrayDeque<O> f5078d = new ArrayDeque<>();

    /* renamed from: e  reason: collision with root package name */
    private final I[] f5079e;

    /* renamed from: f  reason: collision with root package name */
    private final O[] f5080f;

    /* renamed from: g  reason: collision with root package name */
    private int f5081g;

    /* renamed from: h  reason: collision with root package name */
    private int f5082h;

    /* renamed from: i  reason: collision with root package name */
    private I f5083i;

    /* renamed from: j  reason: collision with root package name */
    private E f5084j;

    /* renamed from: k  reason: collision with root package name */
    private boolean f5085k;

    /* renamed from: l  reason: collision with root package name */
    private boolean f5086l;

    /* renamed from: m  reason: collision with root package name */
    private int f5087m;

    /* renamed from: n  reason: collision with root package name */
    private long f5088n = -9223372036854775807L;

    protected SimpleDecoder(I[] iArr, O[] oArr) {
        this.f5079e = iArr;
        this.f5081g = iArr.length;
        for (int i2 = 0; i2 < this.f5081g; i2++) {
            this.f5079e[i2] = i();
        }
        this.f5080f = oArr;
        this.f5082h = oArr.length;
        for (int i3 = 0; i3 < this.f5082h; i3++) {
            this.f5080f[i3] = j();
        }
        AnonymousClass1 r4 = new Thread("ExoPlayer:SimpleDecoder") {
            public void run() {
                SimpleDecoder.this.v();
            }
        };
        this.f5075a = r4;
        r4.start();
    }

    private boolean h() {
        return !this.f5077c.isEmpty() && this.f5082h > 0;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:15:0x0035, code lost:
        if (r1.isEndOfStream() == false) goto L_0x003c;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:16:0x0037, code lost:
        r3.addFlag(4);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:17:0x003c, code lost:
        r3.timeUs = r1.f5069f;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:18:0x0044, code lost:
        if (r1.isFirstSample() == false) goto L_0x004b;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:19:0x0046, code lost:
        r3.addFlag(134217728);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:21:0x0051, code lost:
        if (p(r1.f5069f) != false) goto L_0x0055;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:22:0x0053, code lost:
        r3.shouldBeSkipped = true;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:24:?, code lost:
        r0 = l(r1, r3, r4);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:25:0x005a, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:26:0x005b, code lost:
        r0 = k(r0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:27:0x0060, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:28:0x0061, code lost:
        r0 = k(r0);
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private boolean m() throws java.lang.InterruptedException {
        /*
            r8 = this;
            java.lang.Object r0 = r8.f5076b
            monitor-enter(r0)
        L_0x0003:
            boolean r1 = r8.f5086l     // Catch:{ all -> 0x009c }
            if (r1 != 0) goto L_0x0013
            boolean r1 = r8.h()     // Catch:{ all -> 0x009c }
            if (r1 != 0) goto L_0x0013
            java.lang.Object r1 = r8.f5076b     // Catch:{ all -> 0x009c }
            r1.wait()     // Catch:{ all -> 0x009c }
            goto L_0x0003
        L_0x0013:
            boolean r1 = r8.f5086l     // Catch:{ all -> 0x009c }
            r2 = 0
            if (r1 == 0) goto L_0x001a
            monitor-exit(r0)     // Catch:{ all -> 0x009c }
            return r2
        L_0x001a:
            java.util.ArrayDeque<I> r1 = r8.f5077c     // Catch:{ all -> 0x009c }
            java.lang.Object r1 = r1.removeFirst()     // Catch:{ all -> 0x009c }
            androidx.media3.decoder.DecoderInputBuffer r1 = (androidx.media3.decoder.DecoderInputBuffer) r1     // Catch:{ all -> 0x009c }
            O[] r3 = r8.f5080f     // Catch:{ all -> 0x009c }
            int r4 = r8.f5082h     // Catch:{ all -> 0x009c }
            r5 = 1
            int r4 = r4 - r5
            r8.f5082h = r4     // Catch:{ all -> 0x009c }
            r3 = r3[r4]     // Catch:{ all -> 0x009c }
            boolean r4 = r8.f5085k     // Catch:{ all -> 0x009c }
            r8.f5085k = r2     // Catch:{ all -> 0x009c }
            monitor-exit(r0)     // Catch:{ all -> 0x009c }
            boolean r0 = r1.isEndOfStream()
            if (r0 == 0) goto L_0x003c
            r0 = 4
            r3.addFlag(r0)
            goto L_0x0071
        L_0x003c:
            long r6 = r1.f5069f
            r3.timeUs = r6
            boolean r0 = r1.isFirstSample()
            if (r0 == 0) goto L_0x004b
            r0 = 134217728(0x8000000, float:3.85186E-34)
            r3.addFlag(r0)
        L_0x004b:
            long r6 = r1.f5069f
            boolean r0 = r8.p(r6)
            if (r0 != 0) goto L_0x0055
            r3.shouldBeSkipped = r5
        L_0x0055:
            androidx.media3.decoder.DecoderException r0 = r8.l(r1, r3, r4)     // Catch:{ RuntimeException -> 0x0060, OutOfMemoryError -> 0x005a }
            goto L_0x0065
        L_0x005a:
            r0 = move-exception
            androidx.media3.decoder.DecoderException r0 = r8.k(r0)
            goto L_0x0065
        L_0x0060:
            r0 = move-exception
            androidx.media3.decoder.DecoderException r0 = r8.k(r0)
        L_0x0065:
            if (r0 == 0) goto L_0x0071
            java.lang.Object r4 = r8.f5076b
            monitor-enter(r4)
            r8.f5084j = r0     // Catch:{ all -> 0x006e }
            monitor-exit(r4)     // Catch:{ all -> 0x006e }
            return r2
        L_0x006e:
            r0 = move-exception
            monitor-exit(r4)     // Catch:{ all -> 0x006e }
            throw r0
        L_0x0071:
            java.lang.Object r4 = r8.f5076b
            monitor-enter(r4)
            boolean r0 = r8.f5085k     // Catch:{ all -> 0x0099 }
            if (r0 == 0) goto L_0x007c
            r3.release()     // Catch:{ all -> 0x0099 }
            goto L_0x0094
        L_0x007c:
            boolean r0 = r3.shouldBeSkipped     // Catch:{ all -> 0x0099 }
            if (r0 == 0) goto L_0x0089
            int r0 = r8.f5087m     // Catch:{ all -> 0x0099 }
            int r0 = r0 + r5
            r8.f5087m = r0     // Catch:{ all -> 0x0099 }
            r3.release()     // Catch:{ all -> 0x0099 }
            goto L_0x0094
        L_0x0089:
            int r0 = r8.f5087m     // Catch:{ all -> 0x0099 }
            r3.skippedOutputBufferCount = r0     // Catch:{ all -> 0x0099 }
            r8.f5087m = r2     // Catch:{ all -> 0x0099 }
            java.util.ArrayDeque<O> r0 = r8.f5078d     // Catch:{ all -> 0x0099 }
            r0.addLast(r3)     // Catch:{ all -> 0x0099 }
        L_0x0094:
            r8.s(r1)     // Catch:{ all -> 0x0099 }
            monitor-exit(r4)     // Catch:{ all -> 0x0099 }
            return r5
        L_0x0099:
            r0 = move-exception
            monitor-exit(r4)     // Catch:{ all -> 0x0099 }
            throw r0
        L_0x009c:
            r1 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x009c }
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.media3.decoder.SimpleDecoder.m():boolean");
    }

    private void q() {
        if (h()) {
            this.f5076b.notify();
        }
    }

    private void r() throws DecoderException {
        E e2 = this.f5084j;
        if (e2 != null) {
            throw e2;
        }
    }

    private void s(I i2) {
        i2.clear();
        I[] iArr = this.f5079e;
        int i3 = this.f5081g;
        this.f5081g = i3 + 1;
        iArr[i3] = i2;
    }

    private void u(O o2) {
        o2.clear();
        O[] oArr = this.f5080f;
        int i2 = this.f5082h;
        this.f5082h = i2 + 1;
        oArr[i2] = o2;
    }

    /* access modifiers changed from: private */
    public void v() {
        do {
            try {
            } catch (InterruptedException e2) {
                throw new IllegalStateException(e2);
            }
        } while (m());
    }

    public final void e(long j2) {
        boolean z2;
        synchronized (this.f5076b) {
            if (this.f5081g != this.f5079e.length) {
                if (!this.f5085k) {
                    z2 = false;
                    Assertions.h(z2);
                    this.f5088n = j2;
                }
            }
            z2 = true;
            Assertions.h(z2);
            this.f5088n = j2;
        }
    }

    /* renamed from: f */
    public final void c(I i2) throws DecoderException {
        boolean z2;
        synchronized (this.f5076b) {
            r();
            if (i2 == this.f5083i) {
                z2 = true;
            } else {
                z2 = false;
            }
            Assertions.a(z2);
            this.f5077c.addLast(i2);
            q();
            this.f5083i = null;
        }
    }

    public final void flush() {
        synchronized (this.f5076b) {
            this.f5085k = true;
            this.f5087m = 0;
            I i2 = this.f5083i;
            if (i2 != null) {
                s(i2);
                this.f5083i = null;
            }
            while (!this.f5077c.isEmpty()) {
                s((DecoderInputBuffer) this.f5077c.removeFirst());
            }
            while (!this.f5078d.isEmpty()) {
                ((DecoderOutputBuffer) this.f5078d.removeFirst()).release();
            }
        }
    }

    /* access modifiers changed from: protected */
    public abstract I i();

    /* access modifiers changed from: protected */
    public abstract O j();

    /* access modifiers changed from: protected */
    public abstract E k(Throwable th);

    /* access modifiers changed from: protected */
    public abstract E l(I i2, O o2, boolean z2);

    /* renamed from: n */
    public final I d() throws DecoderException {
        boolean z2;
        I i2;
        synchronized (this.f5076b) {
            r();
            if (this.f5083i == null) {
                z2 = true;
            } else {
                z2 = false;
            }
            Assertions.h(z2);
            int i3 = this.f5081g;
            if (i3 == 0) {
                i2 = null;
            } else {
                I[] iArr = this.f5079e;
                int i4 = i3 - 1;
                this.f5081g = i4;
                i2 = iArr[i4];
            }
            this.f5083i = i2;
        }
        return i2;
    }

    /* renamed from: o */
    public final O a() throws DecoderException {
        synchronized (this.f5076b) {
            r();
            if (this.f5078d.isEmpty()) {
                return null;
            }
            O o2 = (DecoderOutputBuffer) this.f5078d.removeFirst();
            return o2;
        }
    }

    /* access modifiers changed from: protected */
    public final boolean p(long j2) {
        boolean z2;
        synchronized (this.f5076b) {
            long j3 = this.f5088n;
            if (j3 != -9223372036854775807L) {
                if (j2 < j3) {
                    z2 = false;
                }
            }
            z2 = true;
        }
        return z2;
    }

    public void release() {
        synchronized (this.f5076b) {
            this.f5086l = true;
            this.f5076b.notify();
        }
        try {
            this.f5075a.join();
        } catch (InterruptedException unused) {
            Thread.currentThread().interrupt();
        }
    }

    /* access modifiers changed from: protected */
    public void t(O o2) {
        synchronized (this.f5076b) {
            u(o2);
            q();
        }
    }

    /* access modifiers changed from: protected */
    public final void w(int i2) {
        boolean z2;
        if (this.f5081g == this.f5079e.length) {
            z2 = true;
        } else {
            z2 = false;
        }
        Assertions.h(z2);
        for (I f2 : this.f5079e) {
            f2.f(i2);
        }
    }
}
