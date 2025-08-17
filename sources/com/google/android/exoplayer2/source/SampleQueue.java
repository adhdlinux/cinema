package com.google.android.exoplayer2.source;

import com.facebook.common.time.Clock;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.FormatHolder;
import com.google.android.exoplayer2.decoder.DecoderInputBuffer;
import com.google.android.exoplayer2.drm.DrmInitData;
import com.google.android.exoplayer2.drm.DrmSession;
import com.google.android.exoplayer2.drm.DrmSessionEventListener;
import com.google.android.exoplayer2.drm.DrmSessionManager;
import com.google.android.exoplayer2.extractor.TrackOutput;
import com.google.android.exoplayer2.extractor.f;
import com.google.android.exoplayer2.upstream.Allocator;
import com.google.android.exoplayer2.upstream.DataReader;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.MimeTypes;
import com.google.android.exoplayer2.util.ParsableByteArray;
import com.google.android.exoplayer2.util.Util;
import java.io.IOException;

public class SampleQueue implements TrackOutput {
    private Format A;
    private Format B;
    private int C;
    private boolean D;
    private boolean E;
    private long F;
    private boolean G;

    /* renamed from: a  reason: collision with root package name */
    private final SampleDataQueue f25912a;

    /* renamed from: b  reason: collision with root package name */
    private final SampleExtrasHolder f25913b = new SampleExtrasHolder();

    /* renamed from: c  reason: collision with root package name */
    private final SpannedData<SharedSampleMetadata> f25914c = new SpannedData<>(new t());

    /* renamed from: d  reason: collision with root package name */
    private final DrmSessionManager f25915d;

    /* renamed from: e  reason: collision with root package name */
    private final DrmSessionEventListener.EventDispatcher f25916e;

    /* renamed from: f  reason: collision with root package name */
    private UpstreamFormatChangedListener f25917f;

    /* renamed from: g  reason: collision with root package name */
    private Format f25918g;

    /* renamed from: h  reason: collision with root package name */
    private DrmSession f25919h;

    /* renamed from: i  reason: collision with root package name */
    private int f25920i = 1000;

    /* renamed from: j  reason: collision with root package name */
    private int[] f25921j = new int[1000];

    /* renamed from: k  reason: collision with root package name */
    private long[] f25922k = new long[1000];

    /* renamed from: l  reason: collision with root package name */
    private int[] f25923l = new int[1000];

    /* renamed from: m  reason: collision with root package name */
    private int[] f25924m = new int[1000];

    /* renamed from: n  reason: collision with root package name */
    private long[] f25925n = new long[1000];

    /* renamed from: o  reason: collision with root package name */
    private TrackOutput.CryptoData[] f25926o = new TrackOutput.CryptoData[1000];

    /* renamed from: p  reason: collision with root package name */
    private int f25927p;

    /* renamed from: q  reason: collision with root package name */
    private int f25928q;

    /* renamed from: r  reason: collision with root package name */
    private int f25929r;

    /* renamed from: s  reason: collision with root package name */
    private int f25930s;

    /* renamed from: t  reason: collision with root package name */
    private long f25931t = Long.MIN_VALUE;

    /* renamed from: u  reason: collision with root package name */
    private long f25932u = Long.MIN_VALUE;

    /* renamed from: v  reason: collision with root package name */
    private long f25933v = Long.MIN_VALUE;

    /* renamed from: w  reason: collision with root package name */
    private boolean f25934w;

    /* renamed from: x  reason: collision with root package name */
    private boolean f25935x = true;

    /* renamed from: y  reason: collision with root package name */
    private boolean f25936y = true;

    /* renamed from: z  reason: collision with root package name */
    private boolean f25937z;

    static final class SampleExtrasHolder {

        /* renamed from: a  reason: collision with root package name */
        public int f25938a;

        /* renamed from: b  reason: collision with root package name */
        public long f25939b;

        /* renamed from: c  reason: collision with root package name */
        public TrackOutput.CryptoData f25940c;

        SampleExtrasHolder() {
        }
    }

    private static final class SharedSampleMetadata {

        /* renamed from: a  reason: collision with root package name */
        public final Format f25941a;

        /* renamed from: b  reason: collision with root package name */
        public final DrmSessionManager.DrmSessionReference f25942b;

        private SharedSampleMetadata(Format format, DrmSessionManager.DrmSessionReference drmSessionReference) {
            this.f25941a = format;
            this.f25942b = drmSessionReference;
        }
    }

    public interface UpstreamFormatChangedListener {
        void a(Format format);
    }

    protected SampleQueue(Allocator allocator, DrmSessionManager drmSessionManager, DrmSessionEventListener.EventDispatcher eventDispatcher) {
        this.f25915d = drmSessionManager;
        this.f25916e = eventDispatcher;
        this.f25912a = new SampleDataQueue(allocator);
    }

    private long B(int i2) {
        long j2 = Long.MIN_VALUE;
        if (i2 == 0) {
            return Long.MIN_VALUE;
        }
        int D2 = D(i2 - 1);
        for (int i3 = 0; i3 < i2; i3++) {
            j2 = Math.max(j2, this.f25925n[D2]);
            if ((this.f25924m[D2] & 1) != 0) {
                break;
            }
            D2--;
            if (D2 == -1) {
                D2 = this.f25920i - 1;
            }
        }
        return j2;
    }

    private int D(int i2) {
        int i3 = this.f25929r + i2;
        int i4 = this.f25920i;
        if (i3 < i4) {
            return i3;
        }
        return i3 - i4;
    }

    private boolean H() {
        return this.f25930s != this.f25927p;
    }

    private boolean M(int i2) {
        DrmSession drmSession = this.f25919h;
        if (drmSession == null || drmSession.getState() == 4 || ((this.f25924m[i2] & 1073741824) == 0 && this.f25919h.b())) {
            return true;
        }
        return false;
    }

    private void O(Format format, FormatHolder formatHolder) {
        boolean z2;
        DrmInitData drmInitData;
        Format format2;
        Format format3 = this.f25918g;
        if (format3 == null) {
            z2 = true;
        } else {
            z2 = false;
        }
        if (z2) {
            drmInitData = null;
        } else {
            drmInitData = format3.f23074p;
        }
        this.f25918g = format;
        DrmInitData drmInitData2 = format.f23074p;
        DrmSessionManager drmSessionManager = this.f25915d;
        if (drmSessionManager != null) {
            format2 = format.c(drmSessionManager.a(format));
        } else {
            format2 = format;
        }
        formatHolder.f23112b = format2;
        formatHolder.f23111a = this.f25919h;
        if (this.f25915d != null) {
            if (z2 || !Util.c(drmInitData, drmInitData2)) {
                DrmSession drmSession = this.f25919h;
                DrmSession c2 = this.f25915d.c(this.f25916e, format);
                this.f25919h = c2;
                formatHolder.f23111a = c2;
                if (drmSession != null) {
                    drmSession.g(this.f25916e);
                }
            }
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:18:0x002a, code lost:
        return -3;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private synchronized int P(com.google.android.exoplayer2.FormatHolder r6, com.google.android.exoplayer2.decoder.DecoderInputBuffer r7, boolean r8, boolean r9, com.google.android.exoplayer2.source.SampleQueue.SampleExtrasHolder r10) {
        /*
            r5 = this;
            monitor-enter(r5)
            r0 = 0
            r7.f23962e = r0     // Catch:{ all -> 0x009a }
            boolean r0 = r5.H()     // Catch:{ all -> 0x009a }
            r1 = -5
            r2 = -3
            r3 = -4
            if (r0 != 0) goto L_0x0031
            if (r9 != 0) goto L_0x002b
            boolean r9 = r5.f25934w     // Catch:{ all -> 0x009a }
            if (r9 == 0) goto L_0x0014
            goto L_0x002b
        L_0x0014:
            com.google.android.exoplayer2.Format r7 = r5.B     // Catch:{ all -> 0x009a }
            if (r7 == 0) goto L_0x0029
            if (r8 != 0) goto L_0x001e
            com.google.android.exoplayer2.Format r8 = r5.f25918g     // Catch:{ all -> 0x009a }
            if (r7 == r8) goto L_0x0029
        L_0x001e:
            java.lang.Object r7 = com.google.android.exoplayer2.util.Assertions.e(r7)     // Catch:{ all -> 0x009a }
            com.google.android.exoplayer2.Format r7 = (com.google.android.exoplayer2.Format) r7     // Catch:{ all -> 0x009a }
            r5.O(r7, r6)     // Catch:{ all -> 0x009a }
            monitor-exit(r5)
            return r1
        L_0x0029:
            monitor-exit(r5)
            return r2
        L_0x002b:
            r6 = 4
            r7.o(r6)     // Catch:{ all -> 0x009a }
            monitor-exit(r5)
            return r3
        L_0x0031:
            com.google.android.exoplayer2.source.SpannedData<com.google.android.exoplayer2.source.SampleQueue$SharedSampleMetadata> r0 = r5.f25914c     // Catch:{ all -> 0x009a }
            int r4 = r5.C()     // Catch:{ all -> 0x009a }
            java.lang.Object r0 = r0.f(r4)     // Catch:{ all -> 0x009a }
            com.google.android.exoplayer2.source.SampleQueue$SharedSampleMetadata r0 = (com.google.android.exoplayer2.source.SampleQueue.SharedSampleMetadata) r0     // Catch:{ all -> 0x009a }
            com.google.android.exoplayer2.Format r0 = r0.f25941a     // Catch:{ all -> 0x009a }
            if (r8 != 0) goto L_0x0095
            com.google.android.exoplayer2.Format r8 = r5.f25918g     // Catch:{ all -> 0x009a }
            if (r0 == r8) goto L_0x0046
            goto L_0x0095
        L_0x0046:
            int r6 = r5.f25930s     // Catch:{ all -> 0x009a }
            int r6 = r5.D(r6)     // Catch:{ all -> 0x009a }
            boolean r8 = r5.M(r6)     // Catch:{ all -> 0x009a }
            r0 = 1
            if (r8 != 0) goto L_0x0057
            r7.f23962e = r0     // Catch:{ all -> 0x009a }
            monitor-exit(r5)
            return r2
        L_0x0057:
            int[] r8 = r5.f25924m     // Catch:{ all -> 0x009a }
            r8 = r8[r6]     // Catch:{ all -> 0x009a }
            r7.o(r8)     // Catch:{ all -> 0x009a }
            int r8 = r5.f25930s     // Catch:{ all -> 0x009a }
            int r1 = r5.f25927p     // Catch:{ all -> 0x009a }
            int r1 = r1 - r0
            if (r8 != r1) goto L_0x0070
            if (r9 != 0) goto L_0x006b
            boolean r8 = r5.f25934w     // Catch:{ all -> 0x009a }
            if (r8 == 0) goto L_0x0070
        L_0x006b:
            r8 = 536870912(0x20000000, float:1.0842022E-19)
            r7.e(r8)     // Catch:{ all -> 0x009a }
        L_0x0070:
            long[] r8 = r5.f25925n     // Catch:{ all -> 0x009a }
            r0 = r8[r6]     // Catch:{ all -> 0x009a }
            r7.f23963f = r0     // Catch:{ all -> 0x009a }
            long r8 = r5.f25931t     // Catch:{ all -> 0x009a }
            int r2 = (r0 > r8 ? 1 : (r0 == r8 ? 0 : -1))
            if (r2 >= 0) goto L_0x0081
            r8 = -2147483648(0xffffffff80000000, float:-0.0)
            r7.e(r8)     // Catch:{ all -> 0x009a }
        L_0x0081:
            int[] r7 = r5.f25923l     // Catch:{ all -> 0x009a }
            r7 = r7[r6]     // Catch:{ all -> 0x009a }
            r10.f25938a = r7     // Catch:{ all -> 0x009a }
            long[] r7 = r5.f25922k     // Catch:{ all -> 0x009a }
            r8 = r7[r6]     // Catch:{ all -> 0x009a }
            r10.f25939b = r8     // Catch:{ all -> 0x009a }
            com.google.android.exoplayer2.extractor.TrackOutput$CryptoData[] r7 = r5.f25926o     // Catch:{ all -> 0x009a }
            r6 = r7[r6]     // Catch:{ all -> 0x009a }
            r10.f25940c = r6     // Catch:{ all -> 0x009a }
            monitor-exit(r5)
            return r3
        L_0x0095:
            r5.O(r0, r6)     // Catch:{ all -> 0x009a }
            monitor-exit(r5)
            return r1
        L_0x009a:
            r6 = move-exception
            monitor-exit(r5)
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.source.SampleQueue.P(com.google.android.exoplayer2.FormatHolder, com.google.android.exoplayer2.decoder.DecoderInputBuffer, boolean, boolean, com.google.android.exoplayer2.source.SampleQueue$SampleExtrasHolder):int");
    }

    private void U() {
        DrmSession drmSession = this.f25919h;
        if (drmSession != null) {
            drmSession.g(this.f25916e);
            this.f25919h = null;
            this.f25918g = null;
        }
    }

    private synchronized void X() {
        this.f25930s = 0;
        this.f25912a.o();
    }

    private synchronized boolean c0(Format format) {
        this.f25936y = false;
        if (Util.c(format, this.B)) {
            return false;
        }
        if (this.f25914c.h() || !this.f25914c.g().f25941a.equals(format)) {
            this.B = format;
        } else {
            this.B = this.f25914c.g().f25941a;
        }
        Format format2 = this.B;
        this.D = MimeTypes.a(format2.f23071m, format2.f23068j);
        this.E = false;
        return true;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:9:0x0010, code lost:
        return r1;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private synchronized boolean h(long r6) {
        /*
            r5 = this;
            monitor-enter(r5)
            int r0 = r5.f25927p     // Catch:{ all -> 0x0027 }
            r1 = 1
            r2 = 0
            if (r0 != 0) goto L_0x0011
            long r3 = r5.f25932u     // Catch:{ all -> 0x0027 }
            int r0 = (r6 > r3 ? 1 : (r6 == r3 ? 0 : -1))
            if (r0 <= 0) goto L_0x000e
            goto L_0x000f
        L_0x000e:
            r1 = 0
        L_0x000f:
            monitor-exit(r5)
            return r1
        L_0x0011:
            long r3 = r5.A()     // Catch:{ all -> 0x0027 }
            int r0 = (r3 > r6 ? 1 : (r3 == r6 ? 0 : -1))
            if (r0 < 0) goto L_0x001b
            monitor-exit(r5)
            return r2
        L_0x001b:
            int r6 = r5.j(r6)     // Catch:{ all -> 0x0027 }
            int r7 = r5.f25928q     // Catch:{ all -> 0x0027 }
            int r7 = r7 + r6
            r5.t(r7)     // Catch:{ all -> 0x0027 }
            monitor-exit(r5)
            return r1
        L_0x0027:
            r6 = move-exception
            monitor-exit(r5)
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.source.SampleQueue.h(long):boolean");
    }

    private synchronized void i(long j2, int i2, long j3, int i3, TrackOutput.CryptoData cryptoData) {
        boolean z2;
        DrmSessionManager.DrmSessionReference drmSessionReference;
        boolean z3;
        int i4 = this.f25927p;
        if (i4 > 0) {
            int D2 = D(i4 - 1);
            if (this.f25922k[D2] + ((long) this.f25923l[D2]) <= j3) {
                z3 = true;
            } else {
                z3 = false;
            }
            Assertions.a(z3);
        }
        if ((536870912 & i2) != 0) {
            z2 = true;
        } else {
            z2 = false;
        }
        this.f25934w = z2;
        this.f25933v = Math.max(this.f25933v, j2);
        int D3 = D(this.f25927p);
        this.f25925n[D3] = j2;
        this.f25922k[D3] = j3;
        this.f25923l[D3] = i3;
        this.f25924m[D3] = i2;
        this.f25926o[D3] = cryptoData;
        this.f25921j[D3] = this.C;
        if (this.f25914c.h() || !this.f25914c.g().f25941a.equals(this.B)) {
            DrmSessionManager drmSessionManager = this.f25915d;
            if (drmSessionManager != null) {
                drmSessionReference = drmSessionManager.d(this.f25916e, this.B);
            } else {
                drmSessionReference = DrmSessionManager.DrmSessionReference.f24092a;
            }
            this.f25914c.b(G(), new SharedSampleMetadata((Format) Assertions.e(this.B), drmSessionReference));
        }
        int i5 = this.f25927p + 1;
        this.f25927p = i5;
        int i6 = this.f25920i;
        if (i5 == i6) {
            int i7 = i6 + 1000;
            int[] iArr = new int[i7];
            long[] jArr = new long[i7];
            long[] jArr2 = new long[i7];
            int[] iArr2 = new int[i7];
            int[] iArr3 = new int[i7];
            TrackOutput.CryptoData[] cryptoDataArr = new TrackOutput.CryptoData[i7];
            int i8 = this.f25929r;
            int i9 = i6 - i8;
            System.arraycopy(this.f25922k, i8, jArr, 0, i9);
            System.arraycopy(this.f25925n, this.f25929r, jArr2, 0, i9);
            System.arraycopy(this.f25924m, this.f25929r, iArr2, 0, i9);
            System.arraycopy(this.f25923l, this.f25929r, iArr3, 0, i9);
            System.arraycopy(this.f25926o, this.f25929r, cryptoDataArr, 0, i9);
            System.arraycopy(this.f25921j, this.f25929r, iArr, 0, i9);
            int i10 = this.f25929r;
            System.arraycopy(this.f25922k, 0, jArr, i9, i10);
            System.arraycopy(this.f25925n, 0, jArr2, i9, i10);
            System.arraycopy(this.f25924m, 0, iArr2, i9, i10);
            System.arraycopy(this.f25923l, 0, iArr3, i9, i10);
            System.arraycopy(this.f25926o, 0, cryptoDataArr, i9, i10);
            System.arraycopy(this.f25921j, 0, iArr, i9, i10);
            this.f25922k = jArr;
            this.f25925n = jArr2;
            this.f25924m = iArr2;
            this.f25923l = iArr3;
            this.f25926o = cryptoDataArr;
            this.f25921j = iArr;
            this.f25929r = 0;
            this.f25920i = i7;
        }
    }

    private int j(long j2) {
        int i2 = this.f25927p;
        int D2 = D(i2 - 1);
        while (i2 > this.f25930s && this.f25925n[D2] >= j2) {
            i2--;
            D2--;
            if (D2 == -1) {
                D2 = this.f25920i - 1;
            }
        }
        return i2;
    }

    public static SampleQueue k(Allocator allocator, DrmSessionManager drmSessionManager, DrmSessionEventListener.EventDispatcher eventDispatcher) {
        return new SampleQueue(allocator, (DrmSessionManager) Assertions.e(drmSessionManager), (DrmSessionEventListener.EventDispatcher) Assertions.e(eventDispatcher));
    }

    public static SampleQueue l(Allocator allocator) {
        return new SampleQueue(allocator, (DrmSessionManager) null, (DrmSessionEventListener.EventDispatcher) null);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:21:0x002e, code lost:
        return -1;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private synchronized long m(long r11, boolean r13, boolean r14) {
        /*
            r10 = this;
            monitor-enter(r10)
            int r0 = r10.f25927p     // Catch:{ all -> 0x002f }
            r1 = -1
            if (r0 == 0) goto L_0x002d
            long[] r3 = r10.f25925n     // Catch:{ all -> 0x002f }
            int r5 = r10.f25929r     // Catch:{ all -> 0x002f }
            r6 = r3[r5]     // Catch:{ all -> 0x002f }
            int r3 = (r11 > r6 ? 1 : (r11 == r6 ? 0 : -1))
            if (r3 >= 0) goto L_0x0012
            goto L_0x002d
        L_0x0012:
            if (r14 == 0) goto L_0x001a
            int r14 = r10.f25930s     // Catch:{ all -> 0x002f }
            if (r14 == r0) goto L_0x001a
            int r0 = r14 + 1
        L_0x001a:
            r6 = r0
            r4 = r10
            r7 = r11
            r9 = r13
            int r11 = r4.v(r5, r6, r7, r9)     // Catch:{ all -> 0x002f }
            r12 = -1
            if (r11 != r12) goto L_0x0027
            monitor-exit(r10)
            return r1
        L_0x0027:
            long r11 = r10.p(r11)     // Catch:{ all -> 0x002f }
            monitor-exit(r10)
            return r11
        L_0x002d:
            monitor-exit(r10)
            return r1
        L_0x002f:
            r11 = move-exception
            monitor-exit(r10)
            throw r11
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.source.SampleQueue.m(long, boolean, boolean):long");
    }

    private synchronized long n() {
        int i2 = this.f25927p;
        if (i2 == 0) {
            return -1;
        }
        return p(i2);
    }

    private long p(int i2) {
        this.f25932u = Math.max(this.f25932u, B(i2));
        this.f25927p -= i2;
        int i3 = this.f25928q + i2;
        this.f25928q = i3;
        int i4 = this.f25929r + i2;
        this.f25929r = i4;
        int i5 = this.f25920i;
        if (i4 >= i5) {
            this.f25929r = i4 - i5;
        }
        int i6 = this.f25930s - i2;
        this.f25930s = i6;
        if (i6 < 0) {
            this.f25930s = 0;
        }
        this.f25914c.e(i3);
        if (this.f25927p != 0) {
            return this.f25922k[this.f25929r];
        }
        int i7 = this.f25929r;
        if (i7 == 0) {
            i7 = this.f25920i;
        }
        int i8 = i7 - 1;
        return this.f25922k[i8] + ((long) this.f25923l[i8]);
    }

    private long t(int i2) {
        boolean z2;
        int G2 = G() - i2;
        boolean z3 = false;
        if (G2 < 0 || G2 > this.f25927p - this.f25930s) {
            z2 = false;
        } else {
            z2 = true;
        }
        Assertions.a(z2);
        int i3 = this.f25927p - G2;
        this.f25927p = i3;
        this.f25933v = Math.max(this.f25932u, B(i3));
        if (G2 == 0 && this.f25934w) {
            z3 = true;
        }
        this.f25934w = z3;
        this.f25914c.d(i2);
        int i4 = this.f25927p;
        if (i4 == 0) {
            return 0;
        }
        int D2 = D(i4 - 1);
        return this.f25922k[D2] + ((long) this.f25923l[D2]);
    }

    private int v(int i2, int i3, long j2, boolean z2) {
        int i4 = -1;
        for (int i5 = 0; i5 < i3; i5++) {
            long j3 = this.f25925n[i2];
            if (j3 > j2) {
                return i4;
            }
            if (!z2 || (this.f25924m[i2] & 1) != 0) {
                if (j3 == j2) {
                    return i5;
                }
                i4 = i5;
            }
            i2++;
            if (i2 == this.f25920i) {
                i2 = 0;
            }
        }
        return i4;
    }

    public final synchronized long A() {
        return Math.max(this.f25932u, B(this.f25930s));
    }

    public final int C() {
        return this.f25928q + this.f25930s;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:23:0x003b, code lost:
        return 0;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final synchronized int E(long r9, boolean r11) {
        /*
            r8 = this;
            monitor-enter(r8)
            int r0 = r8.f25930s     // Catch:{ all -> 0x003c }
            int r2 = r8.D(r0)     // Catch:{ all -> 0x003c }
            boolean r0 = r8.H()     // Catch:{ all -> 0x003c }
            r7 = 0
            if (r0 == 0) goto L_0x003a
            long[] r0 = r8.f25925n     // Catch:{ all -> 0x003c }
            r3 = r0[r2]     // Catch:{ all -> 0x003c }
            int r0 = (r9 > r3 ? 1 : (r9 == r3 ? 0 : -1))
            if (r0 >= 0) goto L_0x0017
            goto L_0x003a
        L_0x0017:
            long r0 = r8.f25933v     // Catch:{ all -> 0x003c }
            int r3 = (r9 > r0 ? 1 : (r9 == r0 ? 0 : -1))
            if (r3 <= 0) goto L_0x0026
            if (r11 == 0) goto L_0x0026
            int r9 = r8.f25927p     // Catch:{ all -> 0x003c }
            int r10 = r8.f25930s     // Catch:{ all -> 0x003c }
            int r9 = r9 - r10
            monitor-exit(r8)
            return r9
        L_0x0026:
            int r11 = r8.f25927p     // Catch:{ all -> 0x003c }
            int r0 = r8.f25930s     // Catch:{ all -> 0x003c }
            int r3 = r11 - r0
            r6 = 1
            r1 = r8
            r4 = r9
            int r9 = r1.v(r2, r3, r4, r6)     // Catch:{ all -> 0x003c }
            r10 = -1
            if (r9 != r10) goto L_0x0038
            monitor-exit(r8)
            return r7
        L_0x0038:
            monitor-exit(r8)
            return r9
        L_0x003a:
            monitor-exit(r8)
            return r7
        L_0x003c:
            r9 = move-exception
            monitor-exit(r8)
            throw r9
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.source.SampleQueue.E(long, boolean):int");
    }

    public final synchronized Format F() {
        Format format;
        if (this.f25936y) {
            format = null;
        } else {
            format = this.B;
        }
        return format;
    }

    public final int G() {
        return this.f25928q + this.f25927p;
    }

    /* access modifiers changed from: protected */
    public final void I() {
        this.f25937z = true;
    }

    public final synchronized boolean J() {
        return this.f25934w;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:13:0x0019, code lost:
        return r1;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized boolean K(boolean r3) {
        /*
            r2 = this;
            monitor-enter(r2)
            boolean r0 = r2.H()     // Catch:{ all -> 0x003a }
            r1 = 1
            if (r0 != 0) goto L_0x001a
            if (r3 != 0) goto L_0x0018
            boolean r3 = r2.f25934w     // Catch:{ all -> 0x003a }
            if (r3 != 0) goto L_0x0018
            com.google.android.exoplayer2.Format r3 = r2.B     // Catch:{ all -> 0x003a }
            if (r3 == 0) goto L_0x0017
            com.google.android.exoplayer2.Format r0 = r2.f25918g     // Catch:{ all -> 0x003a }
            if (r3 == r0) goto L_0x0017
            goto L_0x0018
        L_0x0017:
            r1 = 0
        L_0x0018:
            monitor-exit(r2)
            return r1
        L_0x001a:
            com.google.android.exoplayer2.source.SpannedData<com.google.android.exoplayer2.source.SampleQueue$SharedSampleMetadata> r3 = r2.f25914c     // Catch:{ all -> 0x003a }
            int r0 = r2.C()     // Catch:{ all -> 0x003a }
            java.lang.Object r3 = r3.f(r0)     // Catch:{ all -> 0x003a }
            com.google.android.exoplayer2.source.SampleQueue$SharedSampleMetadata r3 = (com.google.android.exoplayer2.source.SampleQueue.SharedSampleMetadata) r3     // Catch:{ all -> 0x003a }
            com.google.android.exoplayer2.Format r3 = r3.f25941a     // Catch:{ all -> 0x003a }
            com.google.android.exoplayer2.Format r0 = r2.f25918g     // Catch:{ all -> 0x003a }
            if (r3 == r0) goto L_0x002e
            monitor-exit(r2)
            return r1
        L_0x002e:
            int r3 = r2.f25930s     // Catch:{ all -> 0x003a }
            int r3 = r2.D(r3)     // Catch:{ all -> 0x003a }
            boolean r3 = r2.M(r3)     // Catch:{ all -> 0x003a }
            monitor-exit(r2)
            return r3
        L_0x003a:
            r3 = move-exception
            monitor-exit(r2)
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.source.SampleQueue.K(boolean):boolean");
    }

    public void N() throws IOException {
        DrmSession drmSession = this.f25919h;
        if (drmSession != null && drmSession.getState() == 1) {
            throw ((DrmSession.DrmSessionException) Assertions.e(this.f25919h.getError()));
        }
    }

    public final synchronized int Q() {
        int i2;
        int D2 = D(this.f25930s);
        if (H()) {
            i2 = this.f25921j[D2];
        } else {
            i2 = this.C;
        }
        return i2;
    }

    public void R() {
        r();
        U();
    }

    public int S(FormatHolder formatHolder, DecoderInputBuffer decoderInputBuffer, int i2, boolean z2) {
        boolean z3;
        boolean z4 = false;
        if ((i2 & 2) != 0) {
            z3 = true;
        } else {
            z3 = false;
        }
        int P = P(formatHolder, decoderInputBuffer, z3, z2, this.f25913b);
        if (P == -4 && !decoderInputBuffer.k()) {
            if ((i2 & 1) != 0) {
                z4 = true;
            }
            if ((i2 & 4) == 0) {
                if (z4) {
                    this.f25912a.f(decoderInputBuffer, this.f25913b);
                } else {
                    this.f25912a.m(decoderInputBuffer, this.f25913b);
                }
            }
            if (!z4) {
                this.f25930s++;
            }
        }
        return P;
    }

    public void T() {
        W(true);
        U();
    }

    public final void V() {
        W(false);
    }

    public void W(boolean z2) {
        this.f25912a.n();
        this.f25927p = 0;
        this.f25928q = 0;
        this.f25929r = 0;
        this.f25930s = 0;
        this.f25935x = true;
        this.f25931t = Long.MIN_VALUE;
        this.f25932u = Long.MIN_VALUE;
        this.f25933v = Long.MIN_VALUE;
        this.f25934w = false;
        this.f25914c.c();
        if (z2) {
            this.A = null;
            this.B = null;
            this.f25936y = true;
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:11:0x0019, code lost:
        return false;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final synchronized boolean Y(int r4) {
        /*
            r3 = this;
            monitor-enter(r3)
            r3.X()     // Catch:{ all -> 0x001b }
            int r0 = r3.f25928q     // Catch:{ all -> 0x001b }
            if (r4 < r0) goto L_0x0018
            int r1 = r3.f25927p     // Catch:{ all -> 0x001b }
            int r1 = r1 + r0
            if (r4 <= r1) goto L_0x000e
            goto L_0x0018
        L_0x000e:
            r1 = -9223372036854775808
            r3.f25931t = r1     // Catch:{ all -> 0x001b }
            int r4 = r4 - r0
            r3.f25930s = r4     // Catch:{ all -> 0x001b }
            monitor-exit(r3)
            r4 = 1
            return r4
        L_0x0018:
            monitor-exit(r3)
            r4 = 0
            return r4
        L_0x001b:
            r4 = move-exception
            monitor-exit(r3)
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.source.SampleQueue.Y(int):boolean");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:20:0x003f, code lost:
        return false;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final synchronized boolean Z(long r9, boolean r11) {
        /*
            r8 = this;
            monitor-enter(r8)
            r8.X()     // Catch:{ all -> 0x0040 }
            int r0 = r8.f25930s     // Catch:{ all -> 0x0040 }
            int r2 = r8.D(r0)     // Catch:{ all -> 0x0040 }
            boolean r0 = r8.H()     // Catch:{ all -> 0x0040 }
            r7 = 0
            if (r0 == 0) goto L_0x003e
            long[] r0 = r8.f25925n     // Catch:{ all -> 0x0040 }
            r3 = r0[r2]     // Catch:{ all -> 0x0040 }
            int r0 = (r9 > r3 ? 1 : (r9 == r3 ? 0 : -1))
            if (r0 < 0) goto L_0x003e
            long r0 = r8.f25933v     // Catch:{ all -> 0x0040 }
            int r3 = (r9 > r0 ? 1 : (r9 == r0 ? 0 : -1))
            if (r3 <= 0) goto L_0x0022
            if (r11 != 0) goto L_0x0022
            goto L_0x003e
        L_0x0022:
            int r11 = r8.f25927p     // Catch:{ all -> 0x0040 }
            int r0 = r8.f25930s     // Catch:{ all -> 0x0040 }
            int r3 = r11 - r0
            r6 = 1
            r1 = r8
            r4 = r9
            int r11 = r1.v(r2, r3, r4, r6)     // Catch:{ all -> 0x0040 }
            r0 = -1
            if (r11 != r0) goto L_0x0034
            monitor-exit(r8)
            return r7
        L_0x0034:
            r8.f25931t = r9     // Catch:{ all -> 0x0040 }
            int r9 = r8.f25930s     // Catch:{ all -> 0x0040 }
            int r9 = r9 + r11
            r8.f25930s = r9     // Catch:{ all -> 0x0040 }
            monitor-exit(r8)
            r9 = 1
            return r9
        L_0x003e:
            monitor-exit(r8)
            return r7
        L_0x0040:
            r9 = move-exception
            monitor-exit(r8)
            throw r9
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.source.SampleQueue.Z(long, boolean):boolean");
    }

    public final int a(DataReader dataReader, int i2, boolean z2, int i3) throws IOException {
        return this.f25912a.p(dataReader, i2, z2);
    }

    public final void a0(long j2) {
        if (this.F != j2) {
            this.F = j2;
            I();
        }
    }

    public /* synthetic */ int b(DataReader dataReader, int i2, boolean z2) {
        return f.a(this, dataReader, i2, z2);
    }

    public final void b0(long j2) {
        this.f25931t = j2;
    }

    public /* synthetic */ void c(ParsableByteArray parsableByteArray, int i2) {
        f.b(this, parsableByteArray, i2);
    }

    public final void d(Format format) {
        Format w2 = w(format);
        this.f25937z = false;
        this.A = format;
        boolean c02 = c0(w2);
        UpstreamFormatChangedListener upstreamFormatChangedListener = this.f25917f;
        if (upstreamFormatChangedListener != null && c02) {
            upstreamFormatChangedListener.a(w2);
        }
    }

    public final void d0(UpstreamFormatChangedListener upstreamFormatChangedListener) {
        this.f25917f = upstreamFormatChangedListener;
    }

    /* JADX WARNING: Removed duplicated region for block: B:25:0x0059  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void e(long r12, int r14, int r15, int r16, com.google.android.exoplayer2.extractor.TrackOutput.CryptoData r17) {
        /*
            r11 = this;
            r8 = r11
            boolean r0 = r8.f25937z
            if (r0 == 0) goto L_0x0010
            com.google.android.exoplayer2.Format r0 = r8.A
            java.lang.Object r0 = com.google.android.exoplayer2.util.Assertions.i(r0)
            com.google.android.exoplayer2.Format r0 = (com.google.android.exoplayer2.Format) r0
            r11.d(r0)
        L_0x0010:
            r0 = r14 & 1
            r1 = 0
            r2 = 1
            if (r0 == 0) goto L_0x0018
            r3 = 1
            goto L_0x0019
        L_0x0018:
            r3 = 0
        L_0x0019:
            boolean r4 = r8.f25935x
            if (r4 == 0) goto L_0x0022
            if (r3 != 0) goto L_0x0020
            return
        L_0x0020:
            r8.f25935x = r1
        L_0x0022:
            long r4 = r8.F
            long r4 = r4 + r12
            boolean r6 = r8.D
            if (r6 == 0) goto L_0x0054
            long r6 = r8.f25931t
            int r9 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1))
            if (r9 >= 0) goto L_0x0030
            return
        L_0x0030:
            if (r0 != 0) goto L_0x0054
            boolean r0 = r8.E
            if (r0 != 0) goto L_0x0050
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r6 = "Overriding unexpected non-sync sample for format: "
            r0.append(r6)
            com.google.android.exoplayer2.Format r6 = r8.B
            r0.append(r6)
            java.lang.String r0 = r0.toString()
            java.lang.String r6 = "SampleQueue"
            com.google.android.exoplayer2.util.Log.i(r6, r0)
            r8.E = r2
        L_0x0050:
            r0 = r14 | 1
            r6 = r0
            goto L_0x0055
        L_0x0054:
            r6 = r14
        L_0x0055:
            boolean r0 = r8.G
            if (r0 == 0) goto L_0x0066
            if (r3 == 0) goto L_0x0065
            boolean r0 = r11.h(r4)
            if (r0 != 0) goto L_0x0062
            goto L_0x0065
        L_0x0062:
            r8.G = r1
            goto L_0x0066
        L_0x0065:
            return
        L_0x0066:
            com.google.android.exoplayer2.source.SampleDataQueue r0 = r8.f25912a
            long r0 = r0.e()
            r7 = r15
            long r2 = (long) r7
            long r0 = r0 - r2
            r2 = r16
            long r2 = (long) r2
            long r9 = r0 - r2
            r0 = r11
            r1 = r4
            r3 = r6
            r4 = r9
            r6 = r15
            r7 = r17
            r0.i(r1, r3, r4, r6, r7)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.source.SampleQueue.e(long, int, int, int, com.google.android.exoplayer2.extractor.TrackOutput$CryptoData):void");
    }

    public final synchronized void e0(int i2) {
        boolean z2;
        if (i2 >= 0) {
            try {
                if (this.f25930s + i2 <= this.f25927p) {
                    z2 = true;
                    Assertions.a(z2);
                    this.f25930s += i2;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        z2 = false;
        Assertions.a(z2);
        this.f25930s += i2;
    }

    public final void f(ParsableByteArray parsableByteArray, int i2, int i3) {
        this.f25912a.q(parsableByteArray, i2);
    }

    public final void f0(int i2) {
        this.C = i2;
    }

    public final void g0() {
        this.G = true;
    }

    public synchronized long o() {
        int i2 = this.f25930s;
        if (i2 == 0) {
            return -1;
        }
        return p(i2);
    }

    public final void q(long j2, boolean z2, boolean z3) {
        this.f25912a.b(m(j2, z2, z3));
    }

    public final void r() {
        this.f25912a.b(n());
    }

    public final void s() {
        this.f25912a.b(o());
    }

    public final void u(int i2) {
        this.f25912a.c(t(i2));
    }

    /* access modifiers changed from: protected */
    public Format w(Format format) {
        if (this.F == 0 || format.f23075q == Clock.MAX_TIME) {
            return format;
        }
        return format.b().k0(format.f23075q + this.F).G();
    }

    public final int x() {
        return this.f25928q;
    }

    public final synchronized long y() {
        long j2;
        if (this.f25927p == 0) {
            j2 = Long.MIN_VALUE;
        } else {
            j2 = this.f25925n[this.f25929r];
        }
        return j2;
    }

    public final synchronized long z() {
        return this.f25933v;
    }
}
