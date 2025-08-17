package androidx.media3.exoplayer.source.chunk;

import androidx.media3.common.Format;
import androidx.media3.common.util.Assertions;
import androidx.media3.common.util.Util;
import androidx.media3.decoder.DecoderInputBuffer;
import androidx.media3.exoplayer.FormatHolder;
import androidx.media3.exoplayer.LoadingInfo;
import androidx.media3.exoplayer.SeekParameters;
import androidx.media3.exoplayer.drm.DrmSessionEventListener;
import androidx.media3.exoplayer.drm.DrmSessionManager;
import androidx.media3.exoplayer.source.LoadEventInfo;
import androidx.media3.exoplayer.source.MediaSourceEventListener;
import androidx.media3.exoplayer.source.SampleQueue;
import androidx.media3.exoplayer.source.SampleStream;
import androidx.media3.exoplayer.source.SequenceableLoader;
import androidx.media3.exoplayer.source.chunk.ChunkSource;
import androidx.media3.exoplayer.upstream.Allocator;
import androidx.media3.exoplayer.upstream.LoadErrorHandlingPolicy;
import androidx.media3.exoplayer.upstream.Loader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ChunkSampleStream<T extends ChunkSource> implements SampleStream, SequenceableLoader, Loader.Callback<Chunk>, Loader.ReleaseCallback {

    /* renamed from: b  reason: collision with root package name */
    public final int f7228b;
    /* access modifiers changed from: private */

    /* renamed from: c  reason: collision with root package name */
    public final int[] f7229c;
    /* access modifiers changed from: private */

    /* renamed from: d  reason: collision with root package name */
    public final Format[] f7230d;
    /* access modifiers changed from: private */

    /* renamed from: e  reason: collision with root package name */
    public final boolean[] f7231e;

    /* renamed from: f  reason: collision with root package name */
    private final T f7232f;

    /* renamed from: g  reason: collision with root package name */
    private final SequenceableLoader.Callback<ChunkSampleStream<T>> f7233g;
    /* access modifiers changed from: private */

    /* renamed from: h  reason: collision with root package name */
    public final MediaSourceEventListener.EventDispatcher f7234h;

    /* renamed from: i  reason: collision with root package name */
    private final LoadErrorHandlingPolicy f7235i;

    /* renamed from: j  reason: collision with root package name */
    private final Loader f7236j;

    /* renamed from: k  reason: collision with root package name */
    private final ChunkHolder f7237k;

    /* renamed from: l  reason: collision with root package name */
    private final ArrayList<BaseMediaChunk> f7238l;

    /* renamed from: m  reason: collision with root package name */
    private final List<BaseMediaChunk> f7239m;

    /* renamed from: n  reason: collision with root package name */
    private final SampleQueue f7240n;

    /* renamed from: o  reason: collision with root package name */
    private final SampleQueue[] f7241o;

    /* renamed from: p  reason: collision with root package name */
    private final BaseMediaChunkOutput f7242p;

    /* renamed from: q  reason: collision with root package name */
    private Chunk f7243q;

    /* renamed from: r  reason: collision with root package name */
    private Format f7244r;

    /* renamed from: s  reason: collision with root package name */
    private ReleaseCallback<T> f7245s;

    /* renamed from: t  reason: collision with root package name */
    private long f7246t;
    /* access modifiers changed from: private */

    /* renamed from: u  reason: collision with root package name */
    public long f7247u;

    /* renamed from: v  reason: collision with root package name */
    private int f7248v;
    /* access modifiers changed from: private */

    /* renamed from: w  reason: collision with root package name */
    public BaseMediaChunk f7249w;

    /* renamed from: x  reason: collision with root package name */
    boolean f7250x;

    public final class EmbeddedSampleStream implements SampleStream {

        /* renamed from: b  reason: collision with root package name */
        public final ChunkSampleStream<T> f7251b;

        /* renamed from: c  reason: collision with root package name */
        private final SampleQueue f7252c;

        /* renamed from: d  reason: collision with root package name */
        private final int f7253d;

        /* renamed from: e  reason: collision with root package name */
        private boolean f7254e;

        public EmbeddedSampleStream(ChunkSampleStream<T> chunkSampleStream, SampleQueue sampleQueue, int i2) {
            this.f7251b = chunkSampleStream;
            this.f7252c = sampleQueue;
            this.f7253d = i2;
        }

        private void b() {
            if (!this.f7254e) {
                ChunkSampleStream.this.f7234h.h(ChunkSampleStream.this.f7229c[this.f7253d], ChunkSampleStream.this.f7230d[this.f7253d], 0, (Object) null, ChunkSampleStream.this.f7247u);
                this.f7254e = true;
            }
        }

        public void a() {
        }

        public void c() {
            Assertions.h(ChunkSampleStream.this.f7231e[this.f7253d]);
            ChunkSampleStream.this.f7231e[this.f7253d] = false;
        }

        public int d(long j2) {
            if (ChunkSampleStream.this.H()) {
                return 0;
            }
            int F = this.f7252c.F(j2, ChunkSampleStream.this.f7250x);
            if (ChunkSampleStream.this.f7249w != null) {
                F = Math.min(F, ChunkSampleStream.this.f7249w.i(this.f7253d + 1) - this.f7252c.D());
            }
            this.f7252c.f0(F);
            if (F > 0) {
                b();
            }
            return F;
        }

        public boolean isReady() {
            return !ChunkSampleStream.this.H() && this.f7252c.L(ChunkSampleStream.this.f7250x);
        }

        public int m(FormatHolder formatHolder, DecoderInputBuffer decoderInputBuffer, int i2) {
            if (ChunkSampleStream.this.H()) {
                return -3;
            }
            if (ChunkSampleStream.this.f7249w != null && ChunkSampleStream.this.f7249w.i(this.f7253d + 1) <= this.f7252c.D()) {
                return -3;
            }
            b();
            return this.f7252c.T(formatHolder, decoderInputBuffer, i2, ChunkSampleStream.this.f7250x);
        }
    }

    public interface ReleaseCallback<T extends ChunkSource> {
        void d(ChunkSampleStream<T> chunkSampleStream);
    }

    public ChunkSampleStream(int i2, int[] iArr, Format[] formatArr, T t2, SequenceableLoader.Callback<ChunkSampleStream<T>> callback, Allocator allocator, long j2, DrmSessionManager drmSessionManager, DrmSessionEventListener.EventDispatcher eventDispatcher, LoadErrorHandlingPolicy loadErrorHandlingPolicy, MediaSourceEventListener.EventDispatcher eventDispatcher2) {
        this.f7228b = i2;
        int i3 = 0;
        iArr = iArr == null ? new int[0] : iArr;
        this.f7229c = iArr;
        this.f7230d = formatArr == null ? new Format[0] : formatArr;
        this.f7232f = t2;
        this.f7233g = callback;
        this.f7234h = eventDispatcher2;
        this.f7235i = loadErrorHandlingPolicy;
        this.f7236j = new Loader("ChunkSampleStream");
        this.f7237k = new ChunkHolder();
        ArrayList<BaseMediaChunk> arrayList = new ArrayList<>();
        this.f7238l = arrayList;
        this.f7239m = Collections.unmodifiableList(arrayList);
        int length = iArr.length;
        this.f7241o = new SampleQueue[length];
        this.f7231e = new boolean[length];
        int i4 = length + 1;
        int[] iArr2 = new int[i4];
        SampleQueue[] sampleQueueArr = new SampleQueue[i4];
        SampleQueue k2 = SampleQueue.k(allocator, drmSessionManager, eventDispatcher);
        this.f7240n = k2;
        iArr2[0] = i2;
        sampleQueueArr[0] = k2;
        while (i3 < length) {
            SampleQueue l2 = SampleQueue.l(allocator);
            this.f7241o[i3] = l2;
            int i5 = i3 + 1;
            sampleQueueArr[i5] = l2;
            iArr2[i5] = this.f7229c[i3];
            i3 = i5;
        }
        this.f7242p = new BaseMediaChunkOutput(iArr2, sampleQueueArr);
        this.f7246t = j2;
        this.f7247u = j2;
    }

    private void A(int i2) {
        int min = Math.min(N(i2, 0), this.f7248v);
        if (min > 0) {
            Util.a1(this.f7238l, 0, min);
            this.f7248v -= min;
        }
    }

    private void B(int i2) {
        Assertions.h(!this.f7236j.j());
        int size = this.f7238l.size();
        while (true) {
            if (i2 >= size) {
                i2 = -1;
                break;
            } else if (!F(i2)) {
                break;
            } else {
                i2++;
            }
        }
        if (i2 != -1) {
            long j2 = E().f7224h;
            BaseMediaChunk C = C(i2);
            if (this.f7238l.isEmpty()) {
                this.f7246t = this.f7247u;
            }
            this.f7250x = false;
            this.f7234h.C(this.f7228b, C.f7223g, j2);
        }
    }

    private BaseMediaChunk C(int i2) {
        BaseMediaChunk baseMediaChunk = this.f7238l.get(i2);
        ArrayList<BaseMediaChunk> arrayList = this.f7238l;
        Util.a1(arrayList, i2, arrayList.size());
        this.f7248v = Math.max(this.f7248v, this.f7238l.size());
        int i3 = 0;
        this.f7240n.u(baseMediaChunk.i(0));
        while (true) {
            SampleQueue[] sampleQueueArr = this.f7241o;
            if (i3 >= sampleQueueArr.length) {
                return baseMediaChunk;
            }
            SampleQueue sampleQueue = sampleQueueArr[i3];
            i3++;
            sampleQueue.u(baseMediaChunk.i(i3));
        }
    }

    private BaseMediaChunk E() {
        ArrayList<BaseMediaChunk> arrayList = this.f7238l;
        return arrayList.get(arrayList.size() - 1);
    }

    private boolean F(int i2) {
        int D;
        BaseMediaChunk baseMediaChunk = this.f7238l.get(i2);
        if (this.f7240n.D() > baseMediaChunk.i(0)) {
            return true;
        }
        int i3 = 0;
        do {
            SampleQueue[] sampleQueueArr = this.f7241o;
            if (i3 >= sampleQueueArr.length) {
                return false;
            }
            D = sampleQueueArr[i3].D();
            i3++;
        } while (D <= baseMediaChunk.i(i3));
        return true;
    }

    private boolean G(Chunk chunk) {
        return chunk instanceof BaseMediaChunk;
    }

    private void I() {
        int N = N(this.f7240n.D(), this.f7248v - 1);
        while (true) {
            int i2 = this.f7248v;
            if (i2 <= N) {
                this.f7248v = i2 + 1;
                J(i2);
            } else {
                return;
            }
        }
    }

    private void J(int i2) {
        BaseMediaChunk baseMediaChunk = this.f7238l.get(i2);
        Format format = baseMediaChunk.f7220d;
        if (!format.equals(this.f7244r)) {
            this.f7234h.h(this.f7228b, format, baseMediaChunk.f7221e, baseMediaChunk.f7222f, baseMediaChunk.f7223g);
        }
        this.f7244r = format;
    }

    private int N(int i2, int i3) {
        do {
            i3++;
            if (i3 >= this.f7238l.size()) {
                return this.f7238l.size() - 1;
            }
        } while (this.f7238l.get(i3).i(0) <= i2);
        return i3 - 1;
    }

    private void P() {
        this.f7240n.W();
        for (SampleQueue W : this.f7241o) {
            W.W();
        }
    }

    public T D() {
        return this.f7232f;
    }

    /* access modifiers changed from: package-private */
    public boolean H() {
        return this.f7246t != -9223372036854775807L;
    }

    /* renamed from: K */
    public void u(Chunk chunk, long j2, long j3, boolean z2) {
        Chunk chunk2 = chunk;
        this.f7243q = null;
        this.f7249w = null;
        LoadEventInfo loadEventInfo = new LoadEventInfo(chunk2.f7217a, chunk2.f7218b, chunk.f(), chunk.e(), j2, j3, chunk.c());
        this.f7235i.b(chunk2.f7217a);
        this.f7234h.q(loadEventInfo, chunk2.f7219c, this.f7228b, chunk2.f7220d, chunk2.f7221e, chunk2.f7222f, chunk2.f7223g, chunk2.f7224h);
        if (!z2) {
            if (H()) {
                P();
            } else if (G(chunk)) {
                C(this.f7238l.size() - 1);
                if (this.f7238l.isEmpty()) {
                    this.f7246t = this.f7247u;
                }
            }
            this.f7233g.p(this);
        }
    }

    /* renamed from: L */
    public void t(Chunk chunk, long j2, long j3) {
        Chunk chunk2 = chunk;
        this.f7243q = null;
        this.f7232f.f(chunk2);
        LoadEventInfo loadEventInfo = new LoadEventInfo(chunk2.f7217a, chunk2.f7218b, chunk.f(), chunk.e(), j2, j3, chunk.c());
        this.f7235i.b(chunk2.f7217a);
        this.f7234h.t(loadEventInfo, chunk2.f7219c, this.f7228b, chunk2.f7220d, chunk2.f7221e, chunk2.f7222f, chunk2.f7223g, chunk2.f7224h);
        this.f7233g.p(this);
    }

    /* JADX WARNING: Removed duplicated region for block: B:22:0x00a9  */
    /* JADX WARNING: Removed duplicated region for block: B:28:0x00f1  */
    /* renamed from: M */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public androidx.media3.exoplayer.upstream.Loader.LoadErrorAction p(androidx.media3.exoplayer.source.chunk.Chunk r31, long r32, long r34, java.io.IOException r36, int r37) {
        /*
            r30 = this;
            r0 = r30
            r1 = r31
            long r12 = r31.c()
            boolean r14 = r30.G(r31)
            java.util.ArrayList<androidx.media3.exoplayer.source.chunk.BaseMediaChunk> r2 = r0.f7238l
            int r2 = r2.size()
            r15 = 1
            int r10 = r2 + -1
            r2 = 0
            r11 = 0
            int r4 = (r12 > r2 ? 1 : (r12 == r2 ? 0 : -1))
            if (r4 == 0) goto L_0x0027
            if (r14 == 0) goto L_0x0027
            boolean r2 = r0.F(r10)
            if (r2 != 0) goto L_0x0025
            goto L_0x0027
        L_0x0025:
            r8 = 0
            goto L_0x0028
        L_0x0027:
            r8 = 1
        L_0x0028:
            androidx.media3.exoplayer.source.LoadEventInfo r9 = new androidx.media3.exoplayer.source.LoadEventInfo
            long r3 = r1.f7217a
            androidx.media3.datasource.DataSpec r5 = r1.f7218b
            android.net.Uri r6 = r31.f()
            java.util.Map r7 = r31.e()
            r2 = r9
            r15 = r8
            r17 = r14
            r14 = r9
            r8 = r32
            r29 = r10
            r10 = r34
            r2.<init>(r3, r5, r6, r7, r8, r10, r12)
            androidx.media3.exoplayer.source.MediaLoadData r2 = new androidx.media3.exoplayer.source.MediaLoadData
            int r3 = r1.f7219c
            int r4 = r0.f7228b
            androidx.media3.common.Format r5 = r1.f7220d
            int r6 = r1.f7221e
            java.lang.Object r7 = r1.f7222f
            long r8 = r1.f7223g
            long r24 = androidx.media3.common.util.Util.t1(r8)
            long r8 = r1.f7224h
            long r26 = androidx.media3.common.util.Util.t1(r8)
            r18 = r2
            r19 = r3
            r20 = r4
            r21 = r5
            r22 = r6
            r23 = r7
            r18.<init>(r19, r20, r21, r22, r23, r24, r26)
            androidx.media3.exoplayer.upstream.LoadErrorHandlingPolicy$LoadErrorInfo r3 = new androidx.media3.exoplayer.upstream.LoadErrorHandlingPolicy$LoadErrorInfo
            r4 = r36
            r5 = r37
            r3.<init>(r14, r2, r4, r5)
            T r2 = r0.f7232f
            androidx.media3.exoplayer.upstream.LoadErrorHandlingPolicy r5 = r0.f7235i
            boolean r2 = r2.d(r1, r15, r3, r5)
            if (r2 == 0) goto L_0x00a6
            if (r15 == 0) goto L_0x009f
            androidx.media3.exoplayer.upstream.Loader$LoadErrorAction r2 = androidx.media3.exoplayer.upstream.Loader.f7534f
            if (r17 == 0) goto L_0x00a7
            r6 = r29
            androidx.media3.exoplayer.source.chunk.BaseMediaChunk r6 = r0.C(r6)
            if (r6 != r1) goto L_0x008e
            r11 = 1
            goto L_0x008f
        L_0x008e:
            r11 = 0
        L_0x008f:
            androidx.media3.common.util.Assertions.h(r11)
            java.util.ArrayList<androidx.media3.exoplayer.source.chunk.BaseMediaChunk> r6 = r0.f7238l
            boolean r6 = r6.isEmpty()
            if (r6 == 0) goto L_0x00a7
            long r6 = r0.f7247u
            r0.f7246t = r6
            goto L_0x00a7
        L_0x009f:
            java.lang.String r2 = "ChunkSampleStream"
            java.lang.String r6 = "Ignoring attempt to cancel non-cancelable load."
            androidx.media3.common.util.Log.h(r2, r6)
        L_0x00a6:
            r2 = 0
        L_0x00a7:
            if (r2 != 0) goto L_0x00c0
            androidx.media3.exoplayer.upstream.LoadErrorHandlingPolicy r2 = r0.f7235i
            long r2 = r2.c(r3)
            r6 = -9223372036854775807(0x8000000000000001, double:-4.9E-324)
            int r8 = (r2 > r6 ? 1 : (r2 == r6 ? 0 : -1))
            if (r8 == 0) goto L_0x00be
            r6 = 0
            androidx.media3.exoplayer.upstream.Loader$LoadErrorAction r2 = androidx.media3.exoplayer.upstream.Loader.h(r6, r2)
            goto L_0x00c0
        L_0x00be:
            androidx.media3.exoplayer.upstream.Loader$LoadErrorAction r2 = androidx.media3.exoplayer.upstream.Loader.f7535g
        L_0x00c0:
            boolean r3 = r2.c()
            r6 = 1
            r3 = r3 ^ r6
            androidx.media3.exoplayer.source.MediaSourceEventListener$EventDispatcher r6 = r0.f7234h
            int r7 = r1.f7219c
            int r8 = r0.f7228b
            androidx.media3.common.Format r9 = r1.f7220d
            int r10 = r1.f7221e
            java.lang.Object r11 = r1.f7222f
            long r12 = r1.f7223g
            long r4 = r1.f7224h
            r16 = r6
            r17 = r14
            r18 = r7
            r19 = r8
            r20 = r9
            r21 = r10
            r22 = r11
            r23 = r12
            r25 = r4
            r27 = r36
            r28 = r3
            r16.v(r17, r18, r19, r20, r21, r22, r23, r25, r27, r28)
            if (r3 == 0) goto L_0x0100
            r3 = 0
            r0.f7243q = r3
            androidx.media3.exoplayer.upstream.LoadErrorHandlingPolicy r3 = r0.f7235i
            long r4 = r1.f7217a
            r3.b(r4)
            androidx.media3.exoplayer.source.SequenceableLoader$Callback<androidx.media3.exoplayer.source.chunk.ChunkSampleStream<T>> r1 = r0.f7233g
            r1.p(r0)
        L_0x0100:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.media3.exoplayer.source.chunk.ChunkSampleStream.p(androidx.media3.exoplayer.source.chunk.Chunk, long, long, java.io.IOException, int):androidx.media3.exoplayer.upstream.Loader$LoadErrorAction");
    }

    public void O(ReleaseCallback<T> releaseCallback) {
        this.f7245s = releaseCallback;
        this.f7240n.S();
        for (SampleQueue S : this.f7241o) {
            S.S();
        }
        this.f7236j.m(this);
    }

    public void Q(long j2) {
        BaseMediaChunk baseMediaChunk;
        boolean z2;
        boolean z3;
        this.f7247u = j2;
        if (H()) {
            this.f7246t = j2;
            return;
        }
        int i2 = 0;
        int i3 = 0;
        while (true) {
            if (i3 >= this.f7238l.size()) {
                break;
            }
            baseMediaChunk = this.f7238l.get(i3);
            int i4 = (baseMediaChunk.f7223g > j2 ? 1 : (baseMediaChunk.f7223g == j2 ? 0 : -1));
            if (i4 == 0 && baseMediaChunk.f7188k == -9223372036854775807L) {
                break;
            } else if (i4 > 0) {
                break;
            } else {
                i3++;
            }
        }
        baseMediaChunk = null;
        if (baseMediaChunk != null) {
            z2 = this.f7240n.Z(baseMediaChunk.i(0));
        } else {
            SampleQueue sampleQueue = this.f7240n;
            if (j2 < b()) {
                z3 = true;
            } else {
                z3 = false;
            }
            z2 = sampleQueue.a0(j2, z3);
        }
        if (z2) {
            this.f7248v = N(this.f7240n.D(), 0);
            SampleQueue[] sampleQueueArr = this.f7241o;
            int length = sampleQueueArr.length;
            while (i2 < length) {
                sampleQueueArr[i2].a0(j2, true);
                i2++;
            }
            return;
        }
        this.f7246t = j2;
        this.f7250x = false;
        this.f7238l.clear();
        this.f7248v = 0;
        if (this.f7236j.j()) {
            this.f7240n.r();
            SampleQueue[] sampleQueueArr2 = this.f7241o;
            int length2 = sampleQueueArr2.length;
            while (i2 < length2) {
                sampleQueueArr2[i2].r();
                i2++;
            }
            this.f7236j.f();
            return;
        }
        this.f7236j.g();
        P();
    }

    public ChunkSampleStream<T>.EmbeddedSampleStream R(long j2, int i2) {
        for (int i3 = 0; i3 < this.f7241o.length; i3++) {
            if (this.f7229c[i3] == i2) {
                Assertions.h(!this.f7231e[i3]);
                this.f7231e[i3] = true;
                this.f7241o[i3].a0(j2, true);
                return new EmbeddedSampleStream(this, this.f7241o[i3], i3);
            }
        }
        throw new IllegalStateException();
    }

    public void a() throws IOException {
        this.f7236j.a();
        this.f7240n.O();
        if (!this.f7236j.j()) {
            this.f7232f.a();
        }
    }

    public long b() {
        if (H()) {
            return this.f7246t;
        }
        if (this.f7250x) {
            return Long.MIN_VALUE;
        }
        return E().f7224h;
    }

    public boolean c() {
        return this.f7236j.j();
    }

    public int d(long j2) {
        if (H()) {
            return 0;
        }
        int F = this.f7240n.F(j2, this.f7250x);
        BaseMediaChunk baseMediaChunk = this.f7249w;
        if (baseMediaChunk != null) {
            F = Math.min(F, baseMediaChunk.i(0) - this.f7240n.D());
        }
        this.f7240n.f0(F);
        I();
        return F;
    }

    public long e() {
        if (this.f7250x) {
            return Long.MIN_VALUE;
        }
        if (H()) {
            return this.f7246t;
        }
        long j2 = this.f7247u;
        BaseMediaChunk E = E();
        if (!E.h()) {
            if (this.f7238l.size() > 1) {
                ArrayList<BaseMediaChunk> arrayList = this.f7238l;
                E = arrayList.get(arrayList.size() - 2);
            } else {
                E = null;
            }
        }
        if (E != null) {
            j2 = Math.max(j2, E.f7224h);
        }
        return Math.max(j2, this.f7240n.A());
    }

    public void f(long j2) {
        if (!this.f7236j.i() && !H()) {
            if (this.f7236j.j()) {
                Chunk chunk = (Chunk) Assertions.f(this.f7243q);
                if ((!G(chunk) || !F(this.f7238l.size() - 1)) && this.f7232f.e(j2, chunk, this.f7239m)) {
                    this.f7236j.f();
                    if (G(chunk)) {
                        this.f7249w = (BaseMediaChunk) chunk;
                        return;
                    }
                    return;
                }
                return;
            }
            int c2 = this.f7232f.c(j2, this.f7239m);
            if (c2 < this.f7238l.size()) {
                B(c2);
            }
        }
    }

    public boolean g(LoadingInfo loadingInfo) {
        long j2;
        List<BaseMediaChunk> list;
        if (this.f7250x || this.f7236j.j() || this.f7236j.i()) {
            return false;
        }
        boolean H = H();
        if (H) {
            list = Collections.emptyList();
            j2 = this.f7246t;
        } else {
            list = this.f7239m;
            j2 = E().f7224h;
        }
        this.f7232f.g(loadingInfo, j2, list, this.f7237k);
        ChunkHolder chunkHolder = this.f7237k;
        boolean z2 = chunkHolder.f7227b;
        Chunk chunk = chunkHolder.f7226a;
        chunkHolder.a();
        if (z2) {
            this.f7246t = -9223372036854775807L;
            this.f7250x = true;
            return true;
        } else if (chunk == null) {
            return false;
        } else {
            this.f7243q = chunk;
            if (G(chunk)) {
                BaseMediaChunk baseMediaChunk = (BaseMediaChunk) chunk;
                if (H) {
                    long j3 = baseMediaChunk.f7223g;
                    long j4 = this.f7246t;
                    if (j3 != j4) {
                        this.f7240n.c0(j4);
                        for (SampleQueue c02 : this.f7241o) {
                            c02.c0(this.f7246t);
                        }
                    }
                    this.f7246t = -9223372036854775807L;
                }
                baseMediaChunk.k(this.f7242p);
                this.f7238l.add(baseMediaChunk);
            } else if (chunk instanceof InitializationChunk) {
                ((InitializationChunk) chunk).g(this.f7242p);
            }
            this.f7234h.z(new LoadEventInfo(chunk.f7217a, chunk.f7218b, this.f7236j.n(chunk, this, this.f7235i.a(chunk.f7219c))), chunk.f7219c, this.f7228b, chunk.f7220d, chunk.f7221e, chunk.f7222f, chunk.f7223g, chunk.f7224h);
            return true;
        }
    }

    public long h(long j2, SeekParameters seekParameters) {
        return this.f7232f.h(j2, seekParameters);
    }

    public boolean isReady() {
        return !H() && this.f7240n.L(this.f7250x);
    }

    public void k() {
        this.f7240n.U();
        for (SampleQueue U : this.f7241o) {
            U.U();
        }
        this.f7232f.release();
        ReleaseCallback<T> releaseCallback = this.f7245s;
        if (releaseCallback != null) {
            releaseCallback.d(this);
        }
    }

    public int m(FormatHolder formatHolder, DecoderInputBuffer decoderInputBuffer, int i2) {
        if (H()) {
            return -3;
        }
        BaseMediaChunk baseMediaChunk = this.f7249w;
        if (baseMediaChunk != null && baseMediaChunk.i(0) <= this.f7240n.D()) {
            return -3;
        }
        I();
        return this.f7240n.T(formatHolder, decoderInputBuffer, i2, this.f7250x);
    }

    public void o(long j2, boolean z2) {
        if (!H()) {
            int y2 = this.f7240n.y();
            this.f7240n.q(j2, z2, true);
            int y3 = this.f7240n.y();
            if (y3 > y2) {
                long z3 = this.f7240n.z();
                int i2 = 0;
                while (true) {
                    SampleQueue[] sampleQueueArr = this.f7241o;
                    if (i2 >= sampleQueueArr.length) {
                        break;
                    }
                    sampleQueueArr[i2].q(z3, z2, this.f7231e[i2]);
                    i2++;
                }
            }
            A(y3);
        }
    }
}
