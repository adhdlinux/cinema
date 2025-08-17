package com.google.android.exoplayer2.source.chunk;

import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.FormatHolder;
import com.google.android.exoplayer2.SeekParameters;
import com.google.android.exoplayer2.decoder.DecoderInputBuffer;
import com.google.android.exoplayer2.drm.DrmSessionEventListener;
import com.google.android.exoplayer2.drm.DrmSessionManager;
import com.google.android.exoplayer2.source.LoadEventInfo;
import com.google.android.exoplayer2.source.MediaSourceEventListener;
import com.google.android.exoplayer2.source.SampleQueue;
import com.google.android.exoplayer2.source.SampleStream;
import com.google.android.exoplayer2.source.SequenceableLoader;
import com.google.android.exoplayer2.source.chunk.ChunkSource;
import com.google.android.exoplayer2.upstream.Allocator;
import com.google.android.exoplayer2.upstream.LoadErrorHandlingPolicy;
import com.google.android.exoplayer2.upstream.Loader;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.Util;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ChunkSampleStream<T extends ChunkSource> implements SampleStream, SequenceableLoader, Loader.Callback<Chunk>, Loader.ReleaseCallback {

    /* renamed from: b  reason: collision with root package name */
    public final int f26089b;
    /* access modifiers changed from: private */

    /* renamed from: c  reason: collision with root package name */
    public final int[] f26090c;
    /* access modifiers changed from: private */

    /* renamed from: d  reason: collision with root package name */
    public final Format[] f26091d;
    /* access modifiers changed from: private */

    /* renamed from: e  reason: collision with root package name */
    public final boolean[] f26092e;

    /* renamed from: f  reason: collision with root package name */
    private final T f26093f;

    /* renamed from: g  reason: collision with root package name */
    private final SequenceableLoader.Callback<ChunkSampleStream<T>> f26094g;
    /* access modifiers changed from: private */

    /* renamed from: h  reason: collision with root package name */
    public final MediaSourceEventListener.EventDispatcher f26095h;

    /* renamed from: i  reason: collision with root package name */
    private final LoadErrorHandlingPolicy f26096i;

    /* renamed from: j  reason: collision with root package name */
    private final Loader f26097j;

    /* renamed from: k  reason: collision with root package name */
    private final ChunkHolder f26098k;

    /* renamed from: l  reason: collision with root package name */
    private final ArrayList<BaseMediaChunk> f26099l;

    /* renamed from: m  reason: collision with root package name */
    private final List<BaseMediaChunk> f26100m;

    /* renamed from: n  reason: collision with root package name */
    private final SampleQueue f26101n;

    /* renamed from: o  reason: collision with root package name */
    private final SampleQueue[] f26102o;

    /* renamed from: p  reason: collision with root package name */
    private final BaseMediaChunkOutput f26103p;

    /* renamed from: q  reason: collision with root package name */
    private Chunk f26104q;

    /* renamed from: r  reason: collision with root package name */
    private Format f26105r;

    /* renamed from: s  reason: collision with root package name */
    private ReleaseCallback<T> f26106s;

    /* renamed from: t  reason: collision with root package name */
    private long f26107t;
    /* access modifiers changed from: private */

    /* renamed from: u  reason: collision with root package name */
    public long f26108u;

    /* renamed from: v  reason: collision with root package name */
    private int f26109v;
    /* access modifiers changed from: private */

    /* renamed from: w  reason: collision with root package name */
    public BaseMediaChunk f26110w;

    /* renamed from: x  reason: collision with root package name */
    boolean f26111x;

    public final class EmbeddedSampleStream implements SampleStream {

        /* renamed from: b  reason: collision with root package name */
        public final ChunkSampleStream<T> f26112b;

        /* renamed from: c  reason: collision with root package name */
        private final SampleQueue f26113c;

        /* renamed from: d  reason: collision with root package name */
        private final int f26114d;

        /* renamed from: e  reason: collision with root package name */
        private boolean f26115e;

        public EmbeddedSampleStream(ChunkSampleStream<T> chunkSampleStream, SampleQueue sampleQueue, int i2) {
            this.f26112b = chunkSampleStream;
            this.f26113c = sampleQueue;
            this.f26114d = i2;
        }

        private void b() {
            if (!this.f26115e) {
                ChunkSampleStream.this.f26095h.i(ChunkSampleStream.this.f26090c[this.f26114d], ChunkSampleStream.this.f26091d[this.f26114d], 0, (Object) null, ChunkSampleStream.this.f26108u);
                this.f26115e = true;
            }
        }

        public void a() {
        }

        public void c() {
            Assertions.g(ChunkSampleStream.this.f26092e[this.f26114d]);
            ChunkSampleStream.this.f26092e[this.f26114d] = false;
        }

        public int d(long j2) {
            if (ChunkSampleStream.this.H()) {
                return 0;
            }
            int E = this.f26113c.E(j2, ChunkSampleStream.this.f26111x);
            if (ChunkSampleStream.this.f26110w != null) {
                E = Math.min(E, ChunkSampleStream.this.f26110w.i(this.f26114d + 1) - this.f26113c.C());
            }
            this.f26113c.e0(E);
            if (E > 0) {
                b();
            }
            return E;
        }

        public boolean isReady() {
            return !ChunkSampleStream.this.H() && this.f26113c.K(ChunkSampleStream.this.f26111x);
        }

        public int m(FormatHolder formatHolder, DecoderInputBuffer decoderInputBuffer, int i2) {
            if (ChunkSampleStream.this.H()) {
                return -3;
            }
            if (ChunkSampleStream.this.f26110w != null && ChunkSampleStream.this.f26110w.i(this.f26114d + 1) <= this.f26113c.C()) {
                return -3;
            }
            b();
            return this.f26113c.S(formatHolder, decoderInputBuffer, i2, ChunkSampleStream.this.f26111x);
        }
    }

    public interface ReleaseCallback<T extends ChunkSource> {
        void m(ChunkSampleStream<T> chunkSampleStream);
    }

    public ChunkSampleStream(int i2, int[] iArr, Format[] formatArr, T t2, SequenceableLoader.Callback<ChunkSampleStream<T>> callback, Allocator allocator, long j2, DrmSessionManager drmSessionManager, DrmSessionEventListener.EventDispatcher eventDispatcher, LoadErrorHandlingPolicy loadErrorHandlingPolicy, MediaSourceEventListener.EventDispatcher eventDispatcher2) {
        this.f26089b = i2;
        int i3 = 0;
        iArr = iArr == null ? new int[0] : iArr;
        this.f26090c = iArr;
        this.f26091d = formatArr == null ? new Format[0] : formatArr;
        this.f26093f = t2;
        this.f26094g = callback;
        this.f26095h = eventDispatcher2;
        this.f26096i = loadErrorHandlingPolicy;
        this.f26097j = new Loader("ChunkSampleStream");
        this.f26098k = new ChunkHolder();
        ArrayList<BaseMediaChunk> arrayList = new ArrayList<>();
        this.f26099l = arrayList;
        this.f26100m = Collections.unmodifiableList(arrayList);
        int length = iArr.length;
        this.f26102o = new SampleQueue[length];
        this.f26092e = new boolean[length];
        int i4 = length + 1;
        int[] iArr2 = new int[i4];
        SampleQueue[] sampleQueueArr = new SampleQueue[i4];
        SampleQueue k2 = SampleQueue.k(allocator, drmSessionManager, eventDispatcher);
        this.f26101n = k2;
        iArr2[0] = i2;
        sampleQueueArr[0] = k2;
        while (i3 < length) {
            SampleQueue l2 = SampleQueue.l(allocator);
            this.f26102o[i3] = l2;
            int i5 = i3 + 1;
            sampleQueueArr[i5] = l2;
            iArr2[i5] = this.f26090c[i3];
            i3 = i5;
        }
        this.f26103p = new BaseMediaChunkOutput(iArr2, sampleQueueArr);
        this.f26107t = j2;
        this.f26108u = j2;
    }

    private void A(int i2) {
        int min = Math.min(N(i2, 0), this.f26109v);
        if (min > 0) {
            Util.Q0(this.f26099l, 0, min);
            this.f26109v -= min;
        }
    }

    private void B(int i2) {
        Assertions.g(!this.f26097j.j());
        int size = this.f26099l.size();
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
            long j2 = E().f26085h;
            BaseMediaChunk C = C(i2);
            if (this.f26099l.isEmpty()) {
                this.f26107t = this.f26108u;
            }
            this.f26111x = false;
            this.f26095h.D(this.f26089b, C.f26084g, j2);
        }
    }

    private BaseMediaChunk C(int i2) {
        BaseMediaChunk baseMediaChunk = this.f26099l.get(i2);
        ArrayList<BaseMediaChunk> arrayList = this.f26099l;
        Util.Q0(arrayList, i2, arrayList.size());
        this.f26109v = Math.max(this.f26109v, this.f26099l.size());
        int i3 = 0;
        this.f26101n.u(baseMediaChunk.i(0));
        while (true) {
            SampleQueue[] sampleQueueArr = this.f26102o;
            if (i3 >= sampleQueueArr.length) {
                return baseMediaChunk;
            }
            SampleQueue sampleQueue = sampleQueueArr[i3];
            i3++;
            sampleQueue.u(baseMediaChunk.i(i3));
        }
    }

    private BaseMediaChunk E() {
        ArrayList<BaseMediaChunk> arrayList = this.f26099l;
        return arrayList.get(arrayList.size() - 1);
    }

    private boolean F(int i2) {
        int C;
        BaseMediaChunk baseMediaChunk = this.f26099l.get(i2);
        if (this.f26101n.C() > baseMediaChunk.i(0)) {
            return true;
        }
        int i3 = 0;
        do {
            SampleQueue[] sampleQueueArr = this.f26102o;
            if (i3 >= sampleQueueArr.length) {
                return false;
            }
            C = sampleQueueArr[i3].C();
            i3++;
        } while (C <= baseMediaChunk.i(i3));
        return true;
    }

    private boolean G(Chunk chunk) {
        return chunk instanceof BaseMediaChunk;
    }

    private void I() {
        int N = N(this.f26101n.C(), this.f26109v - 1);
        while (true) {
            int i2 = this.f26109v;
            if (i2 <= N) {
                this.f26109v = i2 + 1;
                J(i2);
            } else {
                return;
            }
        }
    }

    private void J(int i2) {
        BaseMediaChunk baseMediaChunk = this.f26099l.get(i2);
        Format format = baseMediaChunk.f26081d;
        if (!format.equals(this.f26105r)) {
            this.f26095h.i(this.f26089b, format, baseMediaChunk.f26082e, baseMediaChunk.f26083f, baseMediaChunk.f26084g);
        }
        this.f26105r = format;
    }

    private int N(int i2, int i3) {
        do {
            i3++;
            if (i3 >= this.f26099l.size()) {
                return this.f26099l.size() - 1;
            }
        } while (this.f26099l.get(i3).i(0) <= i2);
        return i3 - 1;
    }

    private void Q() {
        this.f26101n.V();
        for (SampleQueue V : this.f26102o) {
            V.V();
        }
    }

    public T D() {
        return this.f26093f;
    }

    /* access modifiers changed from: package-private */
    public boolean H() {
        return this.f26107t != -9223372036854775807L;
    }

    /* renamed from: K */
    public void p(Chunk chunk, long j2, long j3, boolean z2) {
        Chunk chunk2 = chunk;
        this.f26104q = null;
        this.f26110w = null;
        LoadEventInfo loadEventInfo = new LoadEventInfo(chunk2.f26078a, chunk2.f26079b, chunk.f(), chunk.e(), j2, j3, chunk.c());
        this.f26096i.b(chunk2.f26078a);
        this.f26095h.r(loadEventInfo, chunk2.f26080c, this.f26089b, chunk2.f26081d, chunk2.f26082e, chunk2.f26083f, chunk2.f26084g, chunk2.f26085h);
        if (!z2) {
            if (H()) {
                Q();
            } else if (G(chunk)) {
                C(this.f26099l.size() - 1);
                if (this.f26099l.isEmpty()) {
                    this.f26107t = this.f26108u;
                }
            }
            this.f26094g.d(this);
        }
    }

    /* renamed from: L */
    public void q(Chunk chunk, long j2, long j3) {
        Chunk chunk2 = chunk;
        this.f26104q = null;
        this.f26093f.f(chunk2);
        LoadEventInfo loadEventInfo = new LoadEventInfo(chunk2.f26078a, chunk2.f26079b, chunk.f(), chunk.e(), j2, j3, chunk.c());
        this.f26096i.b(chunk2.f26078a);
        this.f26095h.u(loadEventInfo, chunk2.f26080c, this.f26089b, chunk2.f26081d, chunk2.f26082e, chunk2.f26083f, chunk2.f26084g, chunk2.f26085h);
        this.f26094g.d(this);
    }

    /* JADX WARNING: Removed duplicated region for block: B:22:0x00a9  */
    /* JADX WARNING: Removed duplicated region for block: B:28:0x00f1  */
    /* renamed from: M */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public com.google.android.exoplayer2.upstream.Loader.LoadErrorAction t(com.google.android.exoplayer2.source.chunk.Chunk r31, long r32, long r34, java.io.IOException r36, int r37) {
        /*
            r30 = this;
            r0 = r30
            r1 = r31
            long r12 = r31.c()
            boolean r14 = r30.G(r31)
            java.util.ArrayList<com.google.android.exoplayer2.source.chunk.BaseMediaChunk> r2 = r0.f26099l
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
            com.google.android.exoplayer2.source.LoadEventInfo r9 = new com.google.android.exoplayer2.source.LoadEventInfo
            long r3 = r1.f26078a
            com.google.android.exoplayer2.upstream.DataSpec r5 = r1.f26079b
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
            com.google.android.exoplayer2.source.MediaLoadData r2 = new com.google.android.exoplayer2.source.MediaLoadData
            int r3 = r1.f26080c
            int r4 = r0.f26089b
            com.google.android.exoplayer2.Format r5 = r1.f26081d
            int r6 = r1.f26082e
            java.lang.Object r7 = r1.f26083f
            long r8 = r1.f26084g
            long r24 = com.google.android.exoplayer2.util.Util.i1(r8)
            long r8 = r1.f26085h
            long r26 = com.google.android.exoplayer2.util.Util.i1(r8)
            r18 = r2
            r19 = r3
            r20 = r4
            r21 = r5
            r22 = r6
            r23 = r7
            r18.<init>(r19, r20, r21, r22, r23, r24, r26)
            com.google.android.exoplayer2.upstream.LoadErrorHandlingPolicy$LoadErrorInfo r3 = new com.google.android.exoplayer2.upstream.LoadErrorHandlingPolicy$LoadErrorInfo
            r4 = r36
            r5 = r37
            r3.<init>(r14, r2, r4, r5)
            T r2 = r0.f26093f
            com.google.android.exoplayer2.upstream.LoadErrorHandlingPolicy r5 = r0.f26096i
            boolean r2 = r2.h(r1, r15, r3, r5)
            if (r2 == 0) goto L_0x00a6
            if (r15 == 0) goto L_0x009f
            com.google.android.exoplayer2.upstream.Loader$LoadErrorAction r2 = com.google.android.exoplayer2.upstream.Loader.f28464f
            if (r17 == 0) goto L_0x00a7
            r6 = r29
            com.google.android.exoplayer2.source.chunk.BaseMediaChunk r6 = r0.C(r6)
            if (r6 != r1) goto L_0x008e
            r11 = 1
            goto L_0x008f
        L_0x008e:
            r11 = 0
        L_0x008f:
            com.google.android.exoplayer2.util.Assertions.g(r11)
            java.util.ArrayList<com.google.android.exoplayer2.source.chunk.BaseMediaChunk> r6 = r0.f26099l
            boolean r6 = r6.isEmpty()
            if (r6 == 0) goto L_0x00a7
            long r6 = r0.f26108u
            r0.f26107t = r6
            goto L_0x00a7
        L_0x009f:
            java.lang.String r2 = "ChunkSampleStream"
            java.lang.String r6 = "Ignoring attempt to cancel non-cancelable load."
            com.google.android.exoplayer2.util.Log.i(r2, r6)
        L_0x00a6:
            r2 = 0
        L_0x00a7:
            if (r2 != 0) goto L_0x00c0
            com.google.android.exoplayer2.upstream.LoadErrorHandlingPolicy r2 = r0.f26096i
            long r2 = r2.c(r3)
            r6 = -9223372036854775807(0x8000000000000001, double:-4.9E-324)
            int r8 = (r2 > r6 ? 1 : (r2 == r6 ? 0 : -1))
            if (r8 == 0) goto L_0x00be
            r6 = 0
            com.google.android.exoplayer2.upstream.Loader$LoadErrorAction r2 = com.google.android.exoplayer2.upstream.Loader.h(r6, r2)
            goto L_0x00c0
        L_0x00be:
            com.google.android.exoplayer2.upstream.Loader$LoadErrorAction r2 = com.google.android.exoplayer2.upstream.Loader.f28465g
        L_0x00c0:
            boolean r3 = r2.c()
            r6 = 1
            r3 = r3 ^ r6
            com.google.android.exoplayer2.source.MediaSourceEventListener$EventDispatcher r6 = r0.f26095h
            int r7 = r1.f26080c
            int r8 = r0.f26089b
            com.google.android.exoplayer2.Format r9 = r1.f26081d
            int r10 = r1.f26082e
            java.lang.Object r11 = r1.f26083f
            long r12 = r1.f26084g
            long r4 = r1.f26085h
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
            r16.w(r17, r18, r19, r20, r21, r22, r23, r25, r27, r28)
            if (r3 == 0) goto L_0x0100
            r3 = 0
            r0.f26104q = r3
            com.google.android.exoplayer2.upstream.LoadErrorHandlingPolicy r3 = r0.f26096i
            long r4 = r1.f26078a
            r3.b(r4)
            com.google.android.exoplayer2.source.SequenceableLoader$Callback<com.google.android.exoplayer2.source.chunk.ChunkSampleStream<T>> r1 = r0.f26094g
            r1.d(r0)
        L_0x0100:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.source.chunk.ChunkSampleStream.t(com.google.android.exoplayer2.source.chunk.Chunk, long, long, java.io.IOException, int):com.google.android.exoplayer2.upstream.Loader$LoadErrorAction");
    }

    public void O() {
        P((ReleaseCallback) null);
    }

    public void P(ReleaseCallback<T> releaseCallback) {
        this.f26106s = releaseCallback;
        this.f26101n.R();
        for (SampleQueue R : this.f26102o) {
            R.R();
        }
        this.f26097j.m(this);
    }

    public void R(long j2) {
        BaseMediaChunk baseMediaChunk;
        boolean z2;
        boolean z3;
        this.f26108u = j2;
        if (H()) {
            this.f26107t = j2;
            return;
        }
        int i2 = 0;
        int i3 = 0;
        while (true) {
            if (i3 >= this.f26099l.size()) {
                break;
            }
            baseMediaChunk = this.f26099l.get(i3);
            int i4 = (baseMediaChunk.f26084g > j2 ? 1 : (baseMediaChunk.f26084g == j2 ? 0 : -1));
            if (i4 == 0 && baseMediaChunk.f26051k == -9223372036854775807L) {
                break;
            } else if (i4 > 0) {
                break;
            } else {
                i3++;
            }
        }
        baseMediaChunk = null;
        if (baseMediaChunk != null) {
            z2 = this.f26101n.Y(baseMediaChunk.i(0));
        } else {
            SampleQueue sampleQueue = this.f26101n;
            if (j2 < b()) {
                z3 = true;
            } else {
                z3 = false;
            }
            z2 = sampleQueue.Z(j2, z3);
        }
        if (z2) {
            this.f26109v = N(this.f26101n.C(), 0);
            SampleQueue[] sampleQueueArr = this.f26102o;
            int length = sampleQueueArr.length;
            while (i2 < length) {
                sampleQueueArr[i2].Z(j2, true);
                i2++;
            }
            return;
        }
        this.f26107t = j2;
        this.f26111x = false;
        this.f26099l.clear();
        this.f26109v = 0;
        if (this.f26097j.j()) {
            this.f26101n.r();
            SampleQueue[] sampleQueueArr2 = this.f26102o;
            int length2 = sampleQueueArr2.length;
            while (i2 < length2) {
                sampleQueueArr2[i2].r();
                i2++;
            }
            this.f26097j.f();
            return;
        }
        this.f26097j.g();
        Q();
    }

    public ChunkSampleStream<T>.EmbeddedSampleStream S(long j2, int i2) {
        for (int i3 = 0; i3 < this.f26102o.length; i3++) {
            if (this.f26090c[i3] == i2) {
                Assertions.g(!this.f26092e[i3]);
                this.f26092e[i3] = true;
                this.f26102o[i3].Z(j2, true);
                return new EmbeddedSampleStream(this, this.f26102o[i3], i3);
            }
        }
        throw new IllegalStateException();
    }

    public void a() throws IOException {
        this.f26097j.a();
        this.f26101n.N();
        if (!this.f26097j.j()) {
            this.f26093f.a();
        }
    }

    public long b() {
        if (H()) {
            return this.f26107t;
        }
        if (this.f26111x) {
            return Long.MIN_VALUE;
        }
        return E().f26085h;
    }

    public boolean c() {
        return this.f26097j.j();
    }

    public int d(long j2) {
        if (H()) {
            return 0;
        }
        int E = this.f26101n.E(j2, this.f26111x);
        BaseMediaChunk baseMediaChunk = this.f26110w;
        if (baseMediaChunk != null) {
            E = Math.min(E, baseMediaChunk.i(0) - this.f26101n.C());
        }
        this.f26101n.e0(E);
        I();
        return E;
    }

    public long e() {
        if (this.f26111x) {
            return Long.MIN_VALUE;
        }
        if (H()) {
            return this.f26107t;
        }
        long j2 = this.f26108u;
        BaseMediaChunk E = E();
        if (!E.h()) {
            if (this.f26099l.size() > 1) {
                ArrayList<BaseMediaChunk> arrayList = this.f26099l;
                E = arrayList.get(arrayList.size() - 2);
            } else {
                E = null;
            }
        }
        if (E != null) {
            j2 = Math.max(j2, E.f26085h);
        }
        return Math.max(j2, this.f26101n.z());
    }

    public void f(long j2) {
        if (!this.f26097j.i() && !H()) {
            if (this.f26097j.j()) {
                Chunk chunk = (Chunk) Assertions.e(this.f26104q);
                if ((!G(chunk) || !F(this.f26099l.size() - 1)) && this.f26093f.d(j2, chunk, this.f26100m)) {
                    this.f26097j.f();
                    if (G(chunk)) {
                        this.f26110w = (BaseMediaChunk) chunk;
                        return;
                    }
                    return;
                }
                return;
            }
            int c2 = this.f26093f.c(j2, this.f26100m);
            if (c2 < this.f26099l.size()) {
                B(c2);
            }
        }
    }

    public long g(long j2, SeekParameters seekParameters) {
        return this.f26093f.g(j2, seekParameters);
    }

    public boolean h(long j2) {
        long j3;
        List<BaseMediaChunk> list;
        if (this.f26111x || this.f26097j.j() || this.f26097j.i()) {
            return false;
        }
        boolean H = H();
        if (H) {
            list = Collections.emptyList();
            j3 = this.f26107t;
        } else {
            list = this.f26100m;
            j3 = E().f26085h;
        }
        this.f26093f.j(j2, j3, list, this.f26098k);
        ChunkHolder chunkHolder = this.f26098k;
        boolean z2 = chunkHolder.f26088b;
        Chunk chunk = chunkHolder.f26087a;
        chunkHolder.a();
        if (z2) {
            this.f26107t = -9223372036854775807L;
            this.f26111x = true;
            return true;
        } else if (chunk == null) {
            return false;
        } else {
            this.f26104q = chunk;
            if (G(chunk)) {
                BaseMediaChunk baseMediaChunk = (BaseMediaChunk) chunk;
                if (H) {
                    long j4 = baseMediaChunk.f26084g;
                    long j5 = this.f26107t;
                    if (j4 != j5) {
                        this.f26101n.b0(j5);
                        for (SampleQueue b02 : this.f26102o) {
                            b02.b0(this.f26107t);
                        }
                    }
                    this.f26107t = -9223372036854775807L;
                }
                baseMediaChunk.k(this.f26103p);
                this.f26099l.add(baseMediaChunk);
            } else if (chunk instanceof InitializationChunk) {
                ((InitializationChunk) chunk).g(this.f26103p);
            }
            this.f26095h.A(new LoadEventInfo(chunk.f26078a, chunk.f26079b, this.f26097j.n(chunk, this, this.f26096i.a(chunk.f26080c))), chunk.f26080c, this.f26089b, chunk.f26081d, chunk.f26082e, chunk.f26083f, chunk.f26084g, chunk.f26085h);
            return true;
        }
    }

    public boolean isReady() {
        return !H() && this.f26101n.K(this.f26111x);
    }

    public void k() {
        this.f26101n.T();
        for (SampleQueue T : this.f26102o) {
            T.T();
        }
        this.f26093f.release();
        ReleaseCallback<T> releaseCallback = this.f26106s;
        if (releaseCallback != null) {
            releaseCallback.m(this);
        }
    }

    public int m(FormatHolder formatHolder, DecoderInputBuffer decoderInputBuffer, int i2) {
        if (H()) {
            return -3;
        }
        BaseMediaChunk baseMediaChunk = this.f26110w;
        if (baseMediaChunk != null && baseMediaChunk.i(0) <= this.f26101n.C()) {
            return -3;
        }
        I();
        return this.f26101n.S(formatHolder, decoderInputBuffer, i2, this.f26111x);
    }

    public void o(long j2, boolean z2) {
        if (!H()) {
            int x2 = this.f26101n.x();
            this.f26101n.q(j2, z2, true);
            int x3 = this.f26101n.x();
            if (x3 > x2) {
                long y2 = this.f26101n.y();
                int i2 = 0;
                while (true) {
                    SampleQueue[] sampleQueueArr = this.f26102o;
                    if (i2 >= sampleQueueArr.length) {
                        break;
                    }
                    sampleQueueArr[i2].q(y2, z2, this.f26092e[i2]);
                    i2++;
                }
            }
            A(x3);
        }
    }
}
