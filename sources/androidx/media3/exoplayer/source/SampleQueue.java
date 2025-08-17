package androidx.media3.exoplayer.source;

import androidx.media3.common.DataReader;
import androidx.media3.common.DrmInitData;
import androidx.media3.common.Format;
import androidx.media3.common.MimeTypes;
import androidx.media3.common.util.Assertions;
import androidx.media3.common.util.ParsableByteArray;
import androidx.media3.common.util.Util;
import androidx.media3.decoder.DecoderInputBuffer;
import androidx.media3.exoplayer.FormatHolder;
import androidx.media3.exoplayer.drm.DrmSession;
import androidx.media3.exoplayer.drm.DrmSessionEventListener;
import androidx.media3.exoplayer.drm.DrmSessionManager;
import androidx.media3.exoplayer.upstream.Allocator;
import androidx.media3.extractor.TrackOutput;
import androidx.media3.extractor.g;
import com.facebook.common.time.Clock;
import java.io.IOException;

public class SampleQueue implements TrackOutput {
    private Format A;
    private Format B;
    private long C;
    private boolean D = true;
    private boolean E;
    private long F;
    private boolean G;

    /* renamed from: a  reason: collision with root package name */
    private final SampleDataQueue f7083a;

    /* renamed from: b  reason: collision with root package name */
    private final SampleExtrasHolder f7084b = new SampleExtrasHolder();

    /* renamed from: c  reason: collision with root package name */
    private final SpannedData<SharedSampleMetadata> f7085c = new SpannedData<>(new x());

    /* renamed from: d  reason: collision with root package name */
    private final DrmSessionManager f7086d;

    /* renamed from: e  reason: collision with root package name */
    private final DrmSessionEventListener.EventDispatcher f7087e;

    /* renamed from: f  reason: collision with root package name */
    private UpstreamFormatChangedListener f7088f;

    /* renamed from: g  reason: collision with root package name */
    private Format f7089g;

    /* renamed from: h  reason: collision with root package name */
    private DrmSession f7090h;

    /* renamed from: i  reason: collision with root package name */
    private int f7091i = 1000;

    /* renamed from: j  reason: collision with root package name */
    private long[] f7092j = new long[1000];

    /* renamed from: k  reason: collision with root package name */
    private long[] f7093k = new long[1000];

    /* renamed from: l  reason: collision with root package name */
    private int[] f7094l = new int[1000];

    /* renamed from: m  reason: collision with root package name */
    private int[] f7095m = new int[1000];

    /* renamed from: n  reason: collision with root package name */
    private long[] f7096n = new long[1000];

    /* renamed from: o  reason: collision with root package name */
    private TrackOutput.CryptoData[] f7097o = new TrackOutput.CryptoData[1000];

    /* renamed from: p  reason: collision with root package name */
    private int f7098p;

    /* renamed from: q  reason: collision with root package name */
    private int f7099q;

    /* renamed from: r  reason: collision with root package name */
    private int f7100r;

    /* renamed from: s  reason: collision with root package name */
    private int f7101s;

    /* renamed from: t  reason: collision with root package name */
    private long f7102t = Long.MIN_VALUE;

    /* renamed from: u  reason: collision with root package name */
    private long f7103u = Long.MIN_VALUE;

    /* renamed from: v  reason: collision with root package name */
    private long f7104v = Long.MIN_VALUE;

    /* renamed from: w  reason: collision with root package name */
    private boolean f7105w;

    /* renamed from: x  reason: collision with root package name */
    private boolean f7106x = true;

    /* renamed from: y  reason: collision with root package name */
    private boolean f7107y = true;

    /* renamed from: z  reason: collision with root package name */
    private boolean f7108z;

    static final class SampleExtrasHolder {

        /* renamed from: a  reason: collision with root package name */
        public int f7109a;

        /* renamed from: b  reason: collision with root package name */
        public long f7110b;

        /* renamed from: c  reason: collision with root package name */
        public TrackOutput.CryptoData f7111c;

        SampleExtrasHolder() {
        }
    }

    private static final class SharedSampleMetadata {

        /* renamed from: a  reason: collision with root package name */
        public final Format f7112a;

        /* renamed from: b  reason: collision with root package name */
        public final DrmSessionManager.DrmSessionReference f7113b;

        private SharedSampleMetadata(Format format, DrmSessionManager.DrmSessionReference drmSessionReference) {
            this.f7112a = format;
            this.f7113b = drmSessionReference;
        }
    }

    public interface UpstreamFormatChangedListener {
        void a(Format format);
    }

    protected SampleQueue(Allocator allocator, DrmSessionManager drmSessionManager, DrmSessionEventListener.EventDispatcher eventDispatcher) {
        this.f7086d = drmSessionManager;
        this.f7087e = eventDispatcher;
        this.f7083a = new SampleDataQueue(allocator);
    }

    private long C(int i2) {
        long j2 = Long.MIN_VALUE;
        if (i2 == 0) {
            return Long.MIN_VALUE;
        }
        int E2 = E(i2 - 1);
        for (int i3 = 0; i3 < i2; i3++) {
            j2 = Math.max(j2, this.f7096n[E2]);
            if ((this.f7095m[E2] & 1) != 0) {
                break;
            }
            E2--;
            if (E2 == -1) {
                E2 = this.f7091i - 1;
            }
        }
        return j2;
    }

    private int E(int i2) {
        int i3 = this.f7100r + i2;
        int i4 = this.f7091i;
        if (i3 < i4) {
            return i3;
        }
        return i3 - i4;
    }

    private boolean I() {
        return this.f7101s != this.f7098p;
    }

    private boolean N(int i2) {
        DrmSession drmSession = this.f7090h;
        if (drmSession == null || drmSession.getState() == 4 || ((this.f7095m[i2] & 1073741824) == 0 && this.f7090h.b())) {
            return true;
        }
        return false;
    }

    private void P(Format format, FormatHolder formatHolder) {
        boolean z2;
        DrmInitData drmInitData;
        Format format2;
        Format format3 = this.f7089g;
        if (format3 == null) {
            z2 = true;
        } else {
            z2 = false;
        }
        if (format3 == null) {
            drmInitData = null;
        } else {
            drmInitData = format3.f4019r;
        }
        this.f7089g = format;
        DrmInitData drmInitData2 = format.f4019r;
        DrmSessionManager drmSessionManager = this.f7086d;
        if (drmSessionManager != null) {
            format2 = format.b(drmSessionManager.c(format));
        } else {
            format2 = format;
        }
        formatHolder.f5385b = format2;
        formatHolder.f5384a = this.f7090h;
        if (this.f7086d != null) {
            if (z2 || !Util.c(drmInitData, drmInitData2)) {
                DrmSession drmSession = this.f7090h;
                DrmSession b2 = this.f7086d.b(this.f7087e, format);
                this.f7090h = b2;
                formatHolder.f5384a = b2;
                if (drmSession != null) {
                    drmSession.g(this.f7087e);
                }
            }
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:18:0x002a, code lost:
        return -3;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private synchronized int Q(androidx.media3.exoplayer.FormatHolder r6, androidx.media3.decoder.DecoderInputBuffer r7, boolean r8, boolean r9, androidx.media3.exoplayer.source.SampleQueue.SampleExtrasHolder r10) {
        /*
            r5 = this;
            monitor-enter(r5)
            r0 = 0
            r7.f5068e = r0     // Catch:{ all -> 0x0093 }
            boolean r0 = r5.I()     // Catch:{ all -> 0x0093 }
            r1 = -5
            r2 = -3
            r3 = -4
            if (r0 != 0) goto L_0x0035
            if (r9 != 0) goto L_0x002b
            boolean r9 = r5.f7105w     // Catch:{ all -> 0x0093 }
            if (r9 == 0) goto L_0x0014
            goto L_0x002b
        L_0x0014:
            androidx.media3.common.Format r7 = r5.B     // Catch:{ all -> 0x0093 }
            if (r7 == 0) goto L_0x0029
            if (r8 != 0) goto L_0x001e
            androidx.media3.common.Format r8 = r5.f7089g     // Catch:{ all -> 0x0093 }
            if (r7 == r8) goto L_0x0029
        L_0x001e:
            java.lang.Object r7 = androidx.media3.common.util.Assertions.f(r7)     // Catch:{ all -> 0x0093 }
            androidx.media3.common.Format r7 = (androidx.media3.common.Format) r7     // Catch:{ all -> 0x0093 }
            r5.P(r7, r6)     // Catch:{ all -> 0x0093 }
            monitor-exit(r5)
            return r1
        L_0x0029:
            monitor-exit(r5)
            return r2
        L_0x002b:
            r6 = 4
            r7.setFlags(r6)     // Catch:{ all -> 0x0093 }
            r8 = -9223372036854775808
            r7.f5069f = r8     // Catch:{ all -> 0x0093 }
            monitor-exit(r5)
            return r3
        L_0x0035:
            androidx.media3.exoplayer.source.SpannedData<androidx.media3.exoplayer.source.SampleQueue$SharedSampleMetadata> r0 = r5.f7085c     // Catch:{ all -> 0x0093 }
            int r4 = r5.D()     // Catch:{ all -> 0x0093 }
            java.lang.Object r0 = r0.f(r4)     // Catch:{ all -> 0x0093 }
            androidx.media3.exoplayer.source.SampleQueue$SharedSampleMetadata r0 = (androidx.media3.exoplayer.source.SampleQueue.SharedSampleMetadata) r0     // Catch:{ all -> 0x0093 }
            androidx.media3.common.Format r0 = r0.f7112a     // Catch:{ all -> 0x0093 }
            if (r8 != 0) goto L_0x008e
            androidx.media3.common.Format r8 = r5.f7089g     // Catch:{ all -> 0x0093 }
            if (r0 == r8) goto L_0x004a
            goto L_0x008e
        L_0x004a:
            int r6 = r5.f7101s     // Catch:{ all -> 0x0093 }
            int r6 = r5.E(r6)     // Catch:{ all -> 0x0093 }
            boolean r8 = r5.N(r6)     // Catch:{ all -> 0x0093 }
            r0 = 1
            if (r8 != 0) goto L_0x005b
            r7.f5068e = r0     // Catch:{ all -> 0x0093 }
            monitor-exit(r5)
            return r2
        L_0x005b:
            int[] r8 = r5.f7095m     // Catch:{ all -> 0x0093 }
            r8 = r8[r6]     // Catch:{ all -> 0x0093 }
            r7.setFlags(r8)     // Catch:{ all -> 0x0093 }
            int r8 = r5.f7101s     // Catch:{ all -> 0x0093 }
            int r1 = r5.f7098p     // Catch:{ all -> 0x0093 }
            int r1 = r1 - r0
            if (r8 != r1) goto L_0x0074
            if (r9 != 0) goto L_0x006f
            boolean r8 = r5.f7105w     // Catch:{ all -> 0x0093 }
            if (r8 == 0) goto L_0x0074
        L_0x006f:
            r8 = 536870912(0x20000000, float:1.0842022E-19)
            r7.addFlag(r8)     // Catch:{ all -> 0x0093 }
        L_0x0074:
            long[] r8 = r5.f7096n     // Catch:{ all -> 0x0093 }
            r0 = r8[r6]     // Catch:{ all -> 0x0093 }
            r7.f5069f = r0     // Catch:{ all -> 0x0093 }
            int[] r7 = r5.f7094l     // Catch:{ all -> 0x0093 }
            r7 = r7[r6]     // Catch:{ all -> 0x0093 }
            r10.f7109a = r7     // Catch:{ all -> 0x0093 }
            long[] r7 = r5.f7093k     // Catch:{ all -> 0x0093 }
            r8 = r7[r6]     // Catch:{ all -> 0x0093 }
            r10.f7110b = r8     // Catch:{ all -> 0x0093 }
            androidx.media3.extractor.TrackOutput$CryptoData[] r7 = r5.f7097o     // Catch:{ all -> 0x0093 }
            r6 = r7[r6]     // Catch:{ all -> 0x0093 }
            r10.f7111c = r6     // Catch:{ all -> 0x0093 }
            monitor-exit(r5)
            return r3
        L_0x008e:
            r5.P(r0, r6)     // Catch:{ all -> 0x0093 }
            monitor-exit(r5)
            return r1
        L_0x0093:
            r6 = move-exception
            monitor-exit(r5)
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.media3.exoplayer.source.SampleQueue.Q(androidx.media3.exoplayer.FormatHolder, androidx.media3.decoder.DecoderInputBuffer, boolean, boolean, androidx.media3.exoplayer.source.SampleQueue$SampleExtrasHolder):int");
    }

    private void V() {
        DrmSession drmSession = this.f7090h;
        if (drmSession != null) {
            drmSession.g(this.f7087e);
            this.f7090h = null;
            this.f7089g = null;
        }
    }

    private synchronized void Y() {
        this.f7101s = 0;
        this.f7083a.o();
    }

    private synchronized boolean d0(Format format) {
        this.f7107y = false;
        if (Util.c(format, this.B)) {
            return false;
        }
        if (this.f7085c.h() || !this.f7085c.g().f7112a.equals(format)) {
            this.B = format;
        } else {
            this.B = this.f7085c.g().f7112a;
        }
        boolean z2 = this.D;
        Format format2 = this.B;
        this.D = z2 & MimeTypes.a(format2.f4015n, format2.f4011j);
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
            int r0 = r5.f7098p     // Catch:{ all -> 0x0027 }
            r1 = 1
            r2 = 0
            if (r0 != 0) goto L_0x0011
            long r3 = r5.f7103u     // Catch:{ all -> 0x0027 }
            int r0 = (r6 > r3 ? 1 : (r6 == r3 ? 0 : -1))
            if (r0 <= 0) goto L_0x000e
            goto L_0x000f
        L_0x000e:
            r1 = 0
        L_0x000f:
            monitor-exit(r5)
            return r1
        L_0x0011:
            long r3 = r5.B()     // Catch:{ all -> 0x0027 }
            int r0 = (r3 > r6 ? 1 : (r3 == r6 ? 0 : -1))
            if (r0 < 0) goto L_0x001b
            monitor-exit(r5)
            return r2
        L_0x001b:
            int r6 = r5.j(r6)     // Catch:{ all -> 0x0027 }
            int r7 = r5.f7099q     // Catch:{ all -> 0x0027 }
            int r7 = r7 + r6
            r5.t(r7)     // Catch:{ all -> 0x0027 }
            monitor-exit(r5)
            return r1
        L_0x0027:
            r6 = move-exception
            monitor-exit(r5)
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.media3.exoplayer.source.SampleQueue.h(long):boolean");
    }

    private synchronized void i(long j2, int i2, long j3, int i3, TrackOutput.CryptoData cryptoData) {
        boolean z2;
        DrmSessionManager.DrmSessionReference drmSessionReference;
        boolean z3;
        int i4 = this.f7098p;
        if (i4 > 0) {
            int E2 = E(i4 - 1);
            if (this.f7093k[E2] + ((long) this.f7094l[E2]) <= j3) {
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
        this.f7105w = z2;
        this.f7104v = Math.max(this.f7104v, j2);
        int E3 = E(this.f7098p);
        this.f7096n[E3] = j2;
        this.f7093k[E3] = j3;
        this.f7094l[E3] = i3;
        this.f7095m[E3] = i2;
        this.f7097o[E3] = cryptoData;
        this.f7092j[E3] = this.C;
        if (this.f7085c.h() || !this.f7085c.g().f7112a.equals(this.B)) {
            Format format = (Format) Assertions.f(this.B);
            DrmSessionManager drmSessionManager = this.f7086d;
            if (drmSessionManager != null) {
                drmSessionReference = drmSessionManager.d(this.f7087e, format);
            } else {
                drmSessionReference = DrmSessionManager.DrmSessionReference.f6228a;
            }
            this.f7085c.b(H(), new SharedSampleMetadata(format, drmSessionReference));
        }
        int i5 = this.f7098p + 1;
        this.f7098p = i5;
        int i6 = this.f7091i;
        if (i5 == i6) {
            int i7 = i6 + 1000;
            long[] jArr = new long[i7];
            long[] jArr2 = new long[i7];
            long[] jArr3 = new long[i7];
            int[] iArr = new int[i7];
            int[] iArr2 = new int[i7];
            TrackOutput.CryptoData[] cryptoDataArr = new TrackOutput.CryptoData[i7];
            int i8 = this.f7100r;
            int i9 = i6 - i8;
            System.arraycopy(this.f7093k, i8, jArr2, 0, i9);
            System.arraycopy(this.f7096n, this.f7100r, jArr3, 0, i9);
            System.arraycopy(this.f7095m, this.f7100r, iArr, 0, i9);
            System.arraycopy(this.f7094l, this.f7100r, iArr2, 0, i9);
            System.arraycopy(this.f7097o, this.f7100r, cryptoDataArr, 0, i9);
            System.arraycopy(this.f7092j, this.f7100r, jArr, 0, i9);
            int i10 = this.f7100r;
            System.arraycopy(this.f7093k, 0, jArr2, i9, i10);
            System.arraycopy(this.f7096n, 0, jArr3, i9, i10);
            System.arraycopy(this.f7095m, 0, iArr, i9, i10);
            System.arraycopy(this.f7094l, 0, iArr2, i9, i10);
            System.arraycopy(this.f7097o, 0, cryptoDataArr, i9, i10);
            System.arraycopy(this.f7092j, 0, jArr, i9, i10);
            this.f7093k = jArr2;
            this.f7096n = jArr3;
            this.f7095m = iArr;
            this.f7094l = iArr2;
            this.f7097o = cryptoDataArr;
            this.f7092j = jArr;
            this.f7100r = 0;
            this.f7091i = i7;
        }
    }

    private int j(long j2) {
        int i2 = this.f7098p;
        int E2 = E(i2 - 1);
        while (i2 > this.f7101s && this.f7096n[E2] >= j2) {
            i2--;
            E2--;
            if (E2 == -1) {
                E2 = this.f7091i - 1;
            }
        }
        return i2;
    }

    public static SampleQueue k(Allocator allocator, DrmSessionManager drmSessionManager, DrmSessionEventListener.EventDispatcher eventDispatcher) {
        return new SampleQueue(allocator, (DrmSessionManager) Assertions.f(drmSessionManager), (DrmSessionEventListener.EventDispatcher) Assertions.f(eventDispatcher));
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
            int r0 = r10.f7098p     // Catch:{ all -> 0x002f }
            r1 = -1
            if (r0 == 0) goto L_0x002d
            long[] r3 = r10.f7096n     // Catch:{ all -> 0x002f }
            int r5 = r10.f7100r     // Catch:{ all -> 0x002f }
            r6 = r3[r5]     // Catch:{ all -> 0x002f }
            int r3 = (r11 > r6 ? 1 : (r11 == r6 ? 0 : -1))
            if (r3 >= 0) goto L_0x0012
            goto L_0x002d
        L_0x0012:
            if (r14 == 0) goto L_0x001a
            int r14 = r10.f7101s     // Catch:{ all -> 0x002f }
            if (r14 == r0) goto L_0x001a
            int r0 = r14 + 1
        L_0x001a:
            r6 = r0
            r4 = r10
            r7 = r11
            r9 = r13
            int r11 = r4.w(r5, r6, r7, r9)     // Catch:{ all -> 0x002f }
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
        throw new UnsupportedOperationException("Method not decompiled: androidx.media3.exoplayer.source.SampleQueue.m(long, boolean, boolean):long");
    }

    private synchronized long n() {
        int i2 = this.f7098p;
        if (i2 == 0) {
            return -1;
        }
        return p(i2);
    }

    private long p(int i2) {
        this.f7103u = Math.max(this.f7103u, C(i2));
        this.f7098p -= i2;
        int i3 = this.f7099q + i2;
        this.f7099q = i3;
        int i4 = this.f7100r + i2;
        this.f7100r = i4;
        int i5 = this.f7091i;
        if (i4 >= i5) {
            this.f7100r = i4 - i5;
        }
        int i6 = this.f7101s - i2;
        this.f7101s = i6;
        if (i6 < 0) {
            this.f7101s = 0;
        }
        this.f7085c.e(i3);
        if (this.f7098p != 0) {
            return this.f7093k[this.f7100r];
        }
        int i7 = this.f7100r;
        if (i7 == 0) {
            i7 = this.f7091i;
        }
        int i8 = i7 - 1;
        return this.f7093k[i8] + ((long) this.f7094l[i8]);
    }

    private long t(int i2) {
        boolean z2;
        int H = H() - i2;
        boolean z3 = false;
        if (H < 0 || H > this.f7098p - this.f7101s) {
            z2 = false;
        } else {
            z2 = true;
        }
        Assertions.a(z2);
        int i3 = this.f7098p - H;
        this.f7098p = i3;
        this.f7104v = Math.max(this.f7103u, C(i3));
        if (H == 0 && this.f7105w) {
            z3 = true;
        }
        this.f7105w = z3;
        this.f7085c.d(i2);
        int i4 = this.f7098p;
        if (i4 == 0) {
            return 0;
        }
        int E2 = E(i4 - 1);
        return this.f7093k[E2] + ((long) this.f7094l[E2]);
    }

    private int v(int i2, int i3, long j2, boolean z2) {
        for (int i4 = 0; i4 < i3; i4++) {
            if (this.f7096n[i2] >= j2) {
                return i4;
            }
            i2++;
            if (i2 == this.f7091i) {
                i2 = 0;
            }
        }
        if (z2) {
            return i3;
        }
        return -1;
    }

    private int w(int i2, int i3, long j2, boolean z2) {
        int i4 = -1;
        for (int i5 = 0; i5 < i3; i5++) {
            long j3 = this.f7096n[i2];
            if (j3 > j2) {
                return i4;
            }
            if (!z2 || (this.f7095m[i2] & 1) != 0) {
                if (j3 == j2) {
                    return i5;
                }
                i4 = i5;
            }
            i2++;
            if (i2 == this.f7091i) {
                i2 = 0;
            }
        }
        return i4;
    }

    public final synchronized long A() {
        return this.f7104v;
    }

    public final synchronized long B() {
        return Math.max(this.f7103u, C(this.f7101s));
    }

    public final int D() {
        return this.f7099q + this.f7101s;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:23:0x003b, code lost:
        return 0;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final synchronized int F(long r9, boolean r11) {
        /*
            r8 = this;
            monitor-enter(r8)
            int r0 = r8.f7101s     // Catch:{ all -> 0x003c }
            int r2 = r8.E(r0)     // Catch:{ all -> 0x003c }
            boolean r0 = r8.I()     // Catch:{ all -> 0x003c }
            r7 = 0
            if (r0 == 0) goto L_0x003a
            long[] r0 = r8.f7096n     // Catch:{ all -> 0x003c }
            r3 = r0[r2]     // Catch:{ all -> 0x003c }
            int r0 = (r9 > r3 ? 1 : (r9 == r3 ? 0 : -1))
            if (r0 >= 0) goto L_0x0017
            goto L_0x003a
        L_0x0017:
            long r0 = r8.f7104v     // Catch:{ all -> 0x003c }
            int r3 = (r9 > r0 ? 1 : (r9 == r0 ? 0 : -1))
            if (r3 <= 0) goto L_0x0026
            if (r11 == 0) goto L_0x0026
            int r9 = r8.f7098p     // Catch:{ all -> 0x003c }
            int r10 = r8.f7101s     // Catch:{ all -> 0x003c }
            int r9 = r9 - r10
            monitor-exit(r8)
            return r9
        L_0x0026:
            int r11 = r8.f7098p     // Catch:{ all -> 0x003c }
            int r0 = r8.f7101s     // Catch:{ all -> 0x003c }
            int r3 = r11 - r0
            r6 = 1
            r1 = r8
            r4 = r9
            int r9 = r1.w(r2, r3, r4, r6)     // Catch:{ all -> 0x003c }
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
        throw new UnsupportedOperationException("Method not decompiled: androidx.media3.exoplayer.source.SampleQueue.F(long, boolean):int");
    }

    public final synchronized Format G() {
        Format format;
        if (this.f7107y) {
            format = null;
        } else {
            format = this.B;
        }
        return format;
    }

    public final int H() {
        return this.f7099q + this.f7098p;
    }

    /* access modifiers changed from: protected */
    public final void J() {
        this.f7108z = true;
    }

    public final synchronized boolean K() {
        return this.f7105w;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:13:0x0019, code lost:
        return r1;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized boolean L(boolean r3) {
        /*
            r2 = this;
            monitor-enter(r2)
            boolean r0 = r2.I()     // Catch:{ all -> 0x003a }
            r1 = 1
            if (r0 != 0) goto L_0x001a
            if (r3 != 0) goto L_0x0018
            boolean r3 = r2.f7105w     // Catch:{ all -> 0x003a }
            if (r3 != 0) goto L_0x0018
            androidx.media3.common.Format r3 = r2.B     // Catch:{ all -> 0x003a }
            if (r3 == 0) goto L_0x0017
            androidx.media3.common.Format r0 = r2.f7089g     // Catch:{ all -> 0x003a }
            if (r3 == r0) goto L_0x0017
            goto L_0x0018
        L_0x0017:
            r1 = 0
        L_0x0018:
            monitor-exit(r2)
            return r1
        L_0x001a:
            androidx.media3.exoplayer.source.SpannedData<androidx.media3.exoplayer.source.SampleQueue$SharedSampleMetadata> r3 = r2.f7085c     // Catch:{ all -> 0x003a }
            int r0 = r2.D()     // Catch:{ all -> 0x003a }
            java.lang.Object r3 = r3.f(r0)     // Catch:{ all -> 0x003a }
            androidx.media3.exoplayer.source.SampleQueue$SharedSampleMetadata r3 = (androidx.media3.exoplayer.source.SampleQueue.SharedSampleMetadata) r3     // Catch:{ all -> 0x003a }
            androidx.media3.common.Format r3 = r3.f7112a     // Catch:{ all -> 0x003a }
            androidx.media3.common.Format r0 = r2.f7089g     // Catch:{ all -> 0x003a }
            if (r3 == r0) goto L_0x002e
            monitor-exit(r2)
            return r1
        L_0x002e:
            int r3 = r2.f7101s     // Catch:{ all -> 0x003a }
            int r3 = r2.E(r3)     // Catch:{ all -> 0x003a }
            boolean r3 = r2.N(r3)     // Catch:{ all -> 0x003a }
            monitor-exit(r2)
            return r3
        L_0x003a:
            r3 = move-exception
            monitor-exit(r2)
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.media3.exoplayer.source.SampleQueue.L(boolean):boolean");
    }

    public void O() throws IOException {
        DrmSession drmSession = this.f7090h;
        if (drmSession != null && drmSession.getState() == 1) {
            throw ((DrmSession.DrmSessionException) Assertions.f(this.f7090h.getError()));
        }
    }

    public final synchronized long R() {
        long j2;
        int E2 = E(this.f7101s);
        if (I()) {
            j2 = this.f7092j[E2];
        } else {
            j2 = this.C;
        }
        return j2;
    }

    public void S() {
        r();
        V();
    }

    public int T(FormatHolder formatHolder, DecoderInputBuffer decoderInputBuffer, int i2, boolean z2) {
        boolean z3;
        boolean z4 = false;
        if ((i2 & 2) != 0) {
            z3 = true;
        } else {
            z3 = false;
        }
        int Q = Q(formatHolder, decoderInputBuffer, z3, z2, this.f7084b);
        if (Q == -4 && !decoderInputBuffer.isEndOfStream()) {
            if ((i2 & 1) != 0) {
                z4 = true;
            }
            if ((i2 & 4) == 0) {
                if (z4) {
                    this.f7083a.f(decoderInputBuffer, this.f7084b);
                } else {
                    this.f7083a.m(decoderInputBuffer, this.f7084b);
                }
            }
            if (!z4) {
                this.f7101s++;
            }
        }
        return Q;
    }

    public void U() {
        X(true);
        V();
    }

    public final void W() {
        X(false);
    }

    public void X(boolean z2) {
        this.f7083a.n();
        this.f7098p = 0;
        this.f7099q = 0;
        this.f7100r = 0;
        this.f7101s = 0;
        this.f7106x = true;
        this.f7102t = Long.MIN_VALUE;
        this.f7103u = Long.MIN_VALUE;
        this.f7104v = Long.MIN_VALUE;
        this.f7105w = false;
        this.f7085c.c();
        if (z2) {
            this.A = null;
            this.B = null;
            this.f7107y = true;
            this.D = true;
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:11:0x0019, code lost:
        return false;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final synchronized boolean Z(int r4) {
        /*
            r3 = this;
            monitor-enter(r3)
            r3.Y()     // Catch:{ all -> 0x001b }
            int r0 = r3.f7099q     // Catch:{ all -> 0x001b }
            if (r4 < r0) goto L_0x0018
            int r1 = r3.f7098p     // Catch:{ all -> 0x001b }
            int r1 = r1 + r0
            if (r4 <= r1) goto L_0x000e
            goto L_0x0018
        L_0x000e:
            r1 = -9223372036854775808
            r3.f7102t = r1     // Catch:{ all -> 0x001b }
            int r4 = r4 - r0
            r3.f7101s = r4     // Catch:{ all -> 0x001b }
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
        throw new UnsupportedOperationException("Method not decompiled: androidx.media3.exoplayer.source.SampleQueue.Z(int):boolean");
    }

    public final void a(ParsableByteArray parsableByteArray, int i2, int i3) {
        this.f7083a.q(parsableByteArray, i2);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:23:0x0051, code lost:
        return false;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final synchronized boolean a0(long r9, boolean r11) {
        /*
            r8 = this;
            monitor-enter(r8)
            r8.Y()     // Catch:{ all -> 0x0052 }
            int r0 = r8.f7101s     // Catch:{ all -> 0x0052 }
            int r2 = r8.E(r0)     // Catch:{ all -> 0x0052 }
            boolean r0 = r8.I()     // Catch:{ all -> 0x0052 }
            r7 = 0
            if (r0 == 0) goto L_0x0050
            long[] r0 = r8.f7096n     // Catch:{ all -> 0x0052 }
            r3 = r0[r2]     // Catch:{ all -> 0x0052 }
            int r0 = (r9 > r3 ? 1 : (r9 == r3 ? 0 : -1))
            if (r0 < 0) goto L_0x0050
            long r0 = r8.f7104v     // Catch:{ all -> 0x0052 }
            int r3 = (r9 > r0 ? 1 : (r9 == r0 ? 0 : -1))
            if (r3 <= 0) goto L_0x0022
            if (r11 != 0) goto L_0x0022
            goto L_0x0050
        L_0x0022:
            boolean r0 = r8.D     // Catch:{ all -> 0x0052 }
            if (r0 == 0) goto L_0x0034
            int r0 = r8.f7098p     // Catch:{ all -> 0x0052 }
            int r1 = r8.f7101s     // Catch:{ all -> 0x0052 }
            int r3 = r0 - r1
            r1 = r8
            r4 = r9
            r6 = r11
            int r11 = r1.v(r2, r3, r4, r6)     // Catch:{ all -> 0x0052 }
            goto L_0x0041
        L_0x0034:
            int r11 = r8.f7098p     // Catch:{ all -> 0x0052 }
            int r0 = r8.f7101s     // Catch:{ all -> 0x0052 }
            int r3 = r11 - r0
            r6 = 1
            r1 = r8
            r4 = r9
            int r11 = r1.w(r2, r3, r4, r6)     // Catch:{ all -> 0x0052 }
        L_0x0041:
            r0 = -1
            if (r11 != r0) goto L_0x0046
            monitor-exit(r8)
            return r7
        L_0x0046:
            r8.f7102t = r9     // Catch:{ all -> 0x0052 }
            int r9 = r8.f7101s     // Catch:{ all -> 0x0052 }
            int r9 = r9 + r11
            r8.f7101s = r9     // Catch:{ all -> 0x0052 }
            monitor-exit(r8)
            r9 = 1
            return r9
        L_0x0050:
            monitor-exit(r8)
            return r7
        L_0x0052:
            r9 = move-exception
            monitor-exit(r8)
            throw r9
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.media3.exoplayer.source.SampleQueue.a0(long, boolean):boolean");
    }

    public /* synthetic */ void b(ParsableByteArray parsableByteArray, int i2) {
        g.b(this, parsableByteArray, i2);
    }

    public final void b0(long j2) {
        if (this.F != j2) {
            this.F = j2;
            J();
        }
    }

    public final void c(Format format) {
        Format x2 = x(format);
        this.f7108z = false;
        this.A = format;
        boolean d02 = d0(x2);
        UpstreamFormatChangedListener upstreamFormatChangedListener = this.f7088f;
        if (upstreamFormatChangedListener != null && d02) {
            upstreamFormatChangedListener.a(x2);
        }
    }

    public final void c0(long j2) {
        this.f7102t = j2;
    }

    public /* synthetic */ int d(DataReader dataReader, int i2, boolean z2) {
        return g.a(this, dataReader, i2, z2);
    }

    public final int e(DataReader dataReader, int i2, boolean z2, int i3) throws IOException {
        return this.f7083a.p(dataReader, i2, z2);
    }

    public final void e0(UpstreamFormatChangedListener upstreamFormatChangedListener) {
        this.f7088f = upstreamFormatChangedListener;
    }

    /* JADX WARNING: Removed duplicated region for block: B:25:0x0059  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void f(long r12, int r14, int r15, int r16, androidx.media3.extractor.TrackOutput.CryptoData r17) {
        /*
            r11 = this;
            r8 = r11
            boolean r0 = r8.f7108z
            if (r0 == 0) goto L_0x0010
            androidx.media3.common.Format r0 = r8.A
            java.lang.Object r0 = androidx.media3.common.util.Assertions.j(r0)
            androidx.media3.common.Format r0 = (androidx.media3.common.Format) r0
            r11.c(r0)
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
            boolean r4 = r8.f7106x
            if (r4 == 0) goto L_0x0022
            if (r3 != 0) goto L_0x0020
            return
        L_0x0020:
            r8.f7106x = r1
        L_0x0022:
            long r4 = r8.F
            long r4 = r4 + r12
            boolean r6 = r8.D
            if (r6 == 0) goto L_0x0054
            long r6 = r8.f7102t
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
            androidx.media3.common.Format r6 = r8.B
            r0.append(r6)
            java.lang.String r0 = r0.toString()
            java.lang.String r6 = "SampleQueue"
            androidx.media3.common.util.Log.h(r6, r0)
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
            androidx.media3.exoplayer.source.SampleDataQueue r0 = r8.f7083a
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
        throw new UnsupportedOperationException("Method not decompiled: androidx.media3.exoplayer.source.SampleQueue.f(long, int, int, int, androidx.media3.extractor.TrackOutput$CryptoData):void");
    }

    public final synchronized void f0(int i2) {
        boolean z2;
        if (i2 >= 0) {
            try {
                if (this.f7101s + i2 <= this.f7098p) {
                    z2 = true;
                    Assertions.a(z2);
                    this.f7101s += i2;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        z2 = false;
        Assertions.a(z2);
        this.f7101s += i2;
    }

    public final void g0(long j2) {
        this.C = j2;
    }

    public final void h0() {
        this.G = true;
    }

    public synchronized long o() {
        int i2 = this.f7101s;
        if (i2 == 0) {
            return -1;
        }
        return p(i2);
    }

    public final void q(long j2, boolean z2, boolean z3) {
        this.f7083a.b(m(j2, z2, z3));
    }

    public final void r() {
        this.f7083a.b(n());
    }

    public final void s() {
        this.f7083a.b(o());
    }

    public final void u(int i2) {
        this.f7083a.c(t(i2));
    }

    /* access modifiers changed from: protected */
    public Format x(Format format) {
        if (this.F == 0 || format.f4020s == Clock.MAX_TIME) {
            return format;
        }
        return format.a().s0(format.f4020s + this.F).K();
    }

    public final int y() {
        return this.f7099q;
    }

    public final synchronized long z() {
        long j2;
        if (this.f7098p == 0) {
            j2 = Long.MIN_VALUE;
        } else {
            j2 = this.f7096n[this.f7100r];
        }
        return j2;
    }
}
