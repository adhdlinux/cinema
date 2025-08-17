package androidx.media3.exoplayer.source;

import android.net.Uri;
import android.os.Handler;
import androidx.media3.common.DataReader;
import androidx.media3.common.Format;
import androidx.media3.common.Metadata;
import androidx.media3.common.MimeTypes;
import androidx.media3.common.ParserException;
import androidx.media3.common.TrackGroup;
import androidx.media3.common.util.Assertions;
import androidx.media3.common.util.ConditionVariable;
import androidx.media3.common.util.Log;
import androidx.media3.common.util.ParsableByteArray;
import androidx.media3.common.util.Util;
import androidx.media3.datasource.DataSource;
import androidx.media3.datasource.DataSourceUtil;
import androidx.media3.datasource.DataSpec;
import androidx.media3.datasource.StatsDataSource;
import androidx.media3.decoder.DecoderInputBuffer;
import androidx.media3.exoplayer.FormatHolder;
import androidx.media3.exoplayer.LoadingInfo;
import androidx.media3.exoplayer.SeekParameters;
import androidx.media3.exoplayer.drm.DrmSessionEventListener;
import androidx.media3.exoplayer.drm.DrmSessionManager;
import androidx.media3.exoplayer.source.IcyDataSource;
import androidx.media3.exoplayer.source.MediaPeriod;
import androidx.media3.exoplayer.source.MediaSourceEventListener;
import androidx.media3.exoplayer.source.SampleQueue;
import androidx.media3.exoplayer.trackselection.ExoTrackSelection;
import androidx.media3.exoplayer.upstream.Allocator;
import androidx.media3.exoplayer.upstream.LoadErrorHandlingPolicy;
import androidx.media3.exoplayer.upstream.Loader;
import androidx.media3.extractor.DiscardingTrackOutput;
import androidx.media3.extractor.ExtractorOutput;
import androidx.media3.extractor.ForwardingSeekMap;
import androidx.media3.extractor.PositionHolder;
import androidx.media3.extractor.SeekMap;
import androidx.media3.extractor.TrackOutput;
import androidx.media3.extractor.metadata.icy.IcyHeaders;
import com.facebook.common.time.Clock;
import com.google.android.gms.cast.framework.media.NotificationOptions;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import org.checkerframework.checker.nullness.qual.EnsuresNonNull;

final class ProgressiveMediaPeriod implements MediaPeriod, ExtractorOutput, Loader.Callback<ExtractingLoadable>, Loader.ReleaseCallback, SampleQueue.UpstreamFormatChangedListener {
    /* access modifiers changed from: private */
    public static final Map<String, String> P = M();
    /* access modifiers changed from: private */
    public static final Format Q = new Format.Builder().a0("icy").o0("application/x-icy").K();
    private TrackState A;
    private SeekMap B;
    /* access modifiers changed from: private */
    public long C;
    private boolean D;
    private int E;
    private boolean F;
    private boolean G;
    private int H;
    private boolean I;
    private long J;
    private long K;
    private boolean L;
    private int M;
    private boolean N;
    private boolean O;

    /* renamed from: b  reason: collision with root package name */
    private final Uri f7007b;

    /* renamed from: c  reason: collision with root package name */
    private final DataSource f7008c;

    /* renamed from: d  reason: collision with root package name */
    private final DrmSessionManager f7009d;

    /* renamed from: e  reason: collision with root package name */
    private final LoadErrorHandlingPolicy f7010e;

    /* renamed from: f  reason: collision with root package name */
    private final MediaSourceEventListener.EventDispatcher f7011f;

    /* renamed from: g  reason: collision with root package name */
    private final DrmSessionEventListener.EventDispatcher f7012g;

    /* renamed from: h  reason: collision with root package name */
    private final Listener f7013h;

    /* renamed from: i  reason: collision with root package name */
    private final Allocator f7014i;
    /* access modifiers changed from: private */

    /* renamed from: j  reason: collision with root package name */
    public final String f7015j;
    /* access modifiers changed from: private */

    /* renamed from: k  reason: collision with root package name */
    public final long f7016k;

    /* renamed from: l  reason: collision with root package name */
    private final long f7017l;

    /* renamed from: m  reason: collision with root package name */
    private final Loader f7018m = new Loader("ProgressiveMediaPeriod");

    /* renamed from: n  reason: collision with root package name */
    private final ProgressiveMediaExtractor f7019n;

    /* renamed from: o  reason: collision with root package name */
    private final ConditionVariable f7020o;

    /* renamed from: p  reason: collision with root package name */
    private final Runnable f7021p;
    /* access modifiers changed from: private */

    /* renamed from: q  reason: collision with root package name */
    public final Runnable f7022q;
    /* access modifiers changed from: private */

    /* renamed from: r  reason: collision with root package name */
    public final Handler f7023r;

    /* renamed from: s  reason: collision with root package name */
    private MediaPeriod.Callback f7024s;
    /* access modifiers changed from: private */

    /* renamed from: t  reason: collision with root package name */
    public IcyHeaders f7025t;

    /* renamed from: u  reason: collision with root package name */
    private SampleQueue[] f7026u;

    /* renamed from: v  reason: collision with root package name */
    private TrackId[] f7027v;

    /* renamed from: w  reason: collision with root package name */
    private boolean f7028w;

    /* renamed from: x  reason: collision with root package name */
    private boolean f7029x;

    /* renamed from: y  reason: collision with root package name */
    private boolean f7030y;

    /* renamed from: z  reason: collision with root package name */
    private boolean f7031z;

    final class ExtractingLoadable implements Loader.Loadable, IcyDataSource.Listener {
        /* access modifiers changed from: private */

        /* renamed from: a  reason: collision with root package name */
        public final long f7033a = LoadEventInfo.a();

        /* renamed from: b  reason: collision with root package name */
        private final Uri f7034b;
        /* access modifiers changed from: private */

        /* renamed from: c  reason: collision with root package name */
        public final StatsDataSource f7035c;

        /* renamed from: d  reason: collision with root package name */
        private final ProgressiveMediaExtractor f7036d;

        /* renamed from: e  reason: collision with root package name */
        private final ExtractorOutput f7037e;

        /* renamed from: f  reason: collision with root package name */
        private final ConditionVariable f7038f;

        /* renamed from: g  reason: collision with root package name */
        private final PositionHolder f7039g = new PositionHolder();

        /* renamed from: h  reason: collision with root package name */
        private volatile boolean f7040h;

        /* renamed from: i  reason: collision with root package name */
        private boolean f7041i = true;
        /* access modifiers changed from: private */

        /* renamed from: j  reason: collision with root package name */
        public long f7042j;
        /* access modifiers changed from: private */

        /* renamed from: k  reason: collision with root package name */
        public DataSpec f7043k = i(0);

        /* renamed from: l  reason: collision with root package name */
        private TrackOutput f7044l;

        /* renamed from: m  reason: collision with root package name */
        private boolean f7045m;

        public ExtractingLoadable(Uri uri, DataSource dataSource, ProgressiveMediaExtractor progressiveMediaExtractor, ExtractorOutput extractorOutput, ConditionVariable conditionVariable) {
            this.f7034b = uri;
            this.f7035c = new StatsDataSource(dataSource);
            this.f7036d = progressiveMediaExtractor;
            this.f7037e = extractorOutput;
            this.f7038f = conditionVariable;
        }

        private DataSpec i(long j2) {
            return new DataSpec.Builder().i(this.f7034b).h(j2).f(ProgressiveMediaPeriod.this.f7015j).b(6).e(ProgressiveMediaPeriod.P).a();
        }

        /* access modifiers changed from: private */
        public void j(long j2, long j3) {
            this.f7039g.f8069a = j2;
            this.f7042j = j3;
            this.f7041i = true;
            this.f7045m = false;
        }

        public void a() throws IOException {
            int i2 = 0;
            while (i2 == 0 && !this.f7040h) {
                try {
                    long j2 = this.f7039g.f8069a;
                    DataSpec i3 = i(j2);
                    this.f7043k = i3;
                    long i4 = this.f7035c.i(i3);
                    if (this.f7040h) {
                        if (!(i2 == 1 || this.f7036d.c() == -1)) {
                            this.f7039g.f8069a = this.f7036d.c();
                        }
                        DataSourceUtil.a(this.f7035c);
                        return;
                    }
                    if (i4 != -1) {
                        i4 += j2;
                        ProgressiveMediaPeriod.this.a0();
                    }
                    long j3 = i4;
                    IcyHeaders unused = ProgressiveMediaPeriod.this.f7025t = IcyHeaders.b(this.f7035c.d());
                    DataReader dataReader = this.f7035c;
                    if (!(ProgressiveMediaPeriod.this.f7025t == null || ProgressiveMediaPeriod.this.f7025t.f8296g == -1)) {
                        dataReader = new IcyDataSource(this.f7035c, ProgressiveMediaPeriod.this.f7025t.f8296g, this);
                        TrackOutput P = ProgressiveMediaPeriod.this.P();
                        this.f7044l = P;
                        P.c(ProgressiveMediaPeriod.Q);
                    }
                    long j4 = j2;
                    this.f7036d.d(dataReader, this.f7034b, this.f7035c.d(), j2, j3, this.f7037e);
                    if (ProgressiveMediaPeriod.this.f7025t != null) {
                        this.f7036d.b();
                    }
                    if (this.f7041i) {
                        this.f7036d.a(j4, this.f7042j);
                        this.f7041i = false;
                    }
                    while (true) {
                        long j5 = j4;
                        while (i2 == 0 && !this.f7040h) {
                            this.f7038f.a();
                            i2 = this.f7036d.e(this.f7039g);
                            j4 = this.f7036d.c();
                            if (j4 > ProgressiveMediaPeriod.this.f7016k + j5) {
                                this.f7038f.c();
                                ProgressiveMediaPeriod.this.f7023r.post(ProgressiveMediaPeriod.this.f7022q);
                            }
                        }
                    }
                    if (i2 == 1) {
                        i2 = 0;
                    } else if (this.f7036d.c() != -1) {
                        this.f7039g.f8069a = this.f7036d.c();
                    }
                    DataSourceUtil.a(this.f7035c);
                } catch (InterruptedException unused2) {
                    throw new InterruptedIOException();
                } catch (Throwable th) {
                    if (!(i2 == 1 || this.f7036d.c() == -1)) {
                        this.f7039g.f8069a = this.f7036d.c();
                    }
                    DataSourceUtil.a(this.f7035c);
                    throw th;
                }
            }
        }

        public void b() {
            this.f7040h = true;
        }

        public void c(ParsableByteArray parsableByteArray) {
            long j2;
            if (!this.f7045m) {
                j2 = this.f7042j;
            } else {
                j2 = Math.max(ProgressiveMediaPeriod.this.O(true), this.f7042j);
            }
            int a2 = parsableByteArray.a();
            TrackOutput trackOutput = (TrackOutput) Assertions.f(this.f7044l);
            trackOutput.b(parsableByteArray, a2);
            trackOutput.f(j2, 1, a2, 0, (TrackOutput.CryptoData) null);
            this.f7045m = true;
        }
    }

    interface Listener {
        void b(long j2, boolean z2, boolean z3);
    }

    private final class SampleStreamImpl implements SampleStream {
        /* access modifiers changed from: private */

        /* renamed from: b  reason: collision with root package name */
        public final int f7047b;

        public SampleStreamImpl(int i2) {
            this.f7047b = i2;
        }

        public void a() throws IOException {
            ProgressiveMediaPeriod.this.Z(this.f7047b);
        }

        public int d(long j2) {
            return ProgressiveMediaPeriod.this.j0(this.f7047b, j2);
        }

        public boolean isReady() {
            return ProgressiveMediaPeriod.this.R(this.f7047b);
        }

        public int m(FormatHolder formatHolder, DecoderInputBuffer decoderInputBuffer, int i2) {
            return ProgressiveMediaPeriod.this.f0(this.f7047b, formatHolder, decoderInputBuffer, i2);
        }
    }

    private static final class TrackId {

        /* renamed from: a  reason: collision with root package name */
        public final int f7049a;

        /* renamed from: b  reason: collision with root package name */
        public final boolean f7050b;

        public TrackId(int i2, boolean z2) {
            this.f7049a = i2;
            this.f7050b = z2;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || TrackId.class != obj.getClass()) {
                return false;
            }
            TrackId trackId = (TrackId) obj;
            if (this.f7049a == trackId.f7049a && this.f7050b == trackId.f7050b) {
                return true;
            }
            return false;
        }

        public int hashCode() {
            return (this.f7049a * 31) + (this.f7050b ? 1 : 0);
        }
    }

    private static final class TrackState {

        /* renamed from: a  reason: collision with root package name */
        public final TrackGroupArray f7051a;

        /* renamed from: b  reason: collision with root package name */
        public final boolean[] f7052b;

        /* renamed from: c  reason: collision with root package name */
        public final boolean[] f7053c;

        /* renamed from: d  reason: collision with root package name */
        public final boolean[] f7054d;

        public TrackState(TrackGroupArray trackGroupArray, boolean[] zArr) {
            this.f7051a = trackGroupArray;
            this.f7052b = zArr;
            int i2 = trackGroupArray.f7178a;
            this.f7053c = new boolean[i2];
            this.f7054d = new boolean[i2];
        }
    }

    public ProgressiveMediaPeriod(Uri uri, DataSource dataSource, ProgressiveMediaExtractor progressiveMediaExtractor, DrmSessionManager drmSessionManager, DrmSessionEventListener.EventDispatcher eventDispatcher, LoadErrorHandlingPolicy loadErrorHandlingPolicy, MediaSourceEventListener.EventDispatcher eventDispatcher2, Listener listener, Allocator allocator, String str, int i2, long j2) {
        this.f7007b = uri;
        this.f7008c = dataSource;
        this.f7009d = drmSessionManager;
        this.f7012g = eventDispatcher;
        this.f7010e = loadErrorHandlingPolicy;
        this.f7011f = eventDispatcher2;
        this.f7013h = listener;
        this.f7014i = allocator;
        this.f7015j = str;
        this.f7016k = (long) i2;
        this.f7019n = progressiveMediaExtractor;
        this.f7017l = j2;
        this.f7020o = new ConditionVariable();
        this.f7021p = new s(this);
        this.f7022q = new t(this);
        this.f7023r = Util.A();
        this.f7027v = new TrackId[0];
        this.f7026u = new SampleQueue[0];
        this.K = -9223372036854775807L;
        this.E = 1;
    }

    @EnsuresNonNull({"trackState", "seekMap"})
    private void K() {
        Assertions.h(this.f7029x);
        Assertions.f(this.A);
        Assertions.f(this.B);
    }

    private boolean L(ExtractingLoadable extractingLoadable, int i2) {
        SeekMap seekMap;
        if (this.I || !((seekMap = this.B) == null || seekMap.h() == -9223372036854775807L)) {
            this.M = i2;
            return true;
        }
        if (!this.f7029x || l0()) {
            this.G = this.f7029x;
            this.J = 0;
            this.M = 0;
            for (SampleQueue W : this.f7026u) {
                W.W();
            }
            extractingLoadable.j(0, 0);
            return true;
        }
        this.L = true;
        return false;
    }

    private static Map<String, String> M() {
        HashMap hashMap = new HashMap();
        hashMap.put("Icy-MetaData", "1");
        return Collections.unmodifiableMap(hashMap);
    }

    private int N() {
        int i2 = 0;
        for (SampleQueue H2 : this.f7026u) {
            i2 += H2.H();
        }
        return i2;
    }

    /* access modifiers changed from: private */
    public long O(boolean z2) {
        long j2 = Long.MIN_VALUE;
        for (int i2 = 0; i2 < this.f7026u.length; i2++) {
            if (z2 || ((TrackState) Assertions.f(this.A)).f7053c[i2]) {
                j2 = Math.max(j2, this.f7026u[i2].A());
            }
        }
        return j2;
    }

    private boolean Q() {
        return this.K != -9223372036854775807L;
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void S() {
        if (!this.O) {
            ((MediaPeriod.Callback) Assertions.f(this.f7024s)).p(this);
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void T() {
        this.I = true;
    }

    /* access modifiers changed from: private */
    public void V() {
        boolean z2;
        boolean z3;
        Metadata metadata;
        if (!this.O && !this.f7029x && this.f7028w && this.B != null) {
            SampleQueue[] sampleQueueArr = this.f7026u;
            int length = sampleQueueArr.length;
            int i2 = 0;
            while (i2 < length) {
                if (sampleQueueArr[i2].G() != null) {
                    i2++;
                } else {
                    return;
                }
            }
            this.f7020o.c();
            int length2 = this.f7026u.length;
            TrackGroup[] trackGroupArr = new TrackGroup[length2];
            boolean[] zArr = new boolean[length2];
            for (int i3 = 0; i3 < length2; i3++) {
                Format format = (Format) Assertions.f(this.f7026u[i3].G());
                String str = format.f4015n;
                boolean o2 = MimeTypes.o(str);
                if (o2 || MimeTypes.s(str)) {
                    z2 = true;
                } else {
                    z2 = false;
                }
                zArr[i3] = z2;
                this.f7030y = z2 | this.f7030y;
                boolean p2 = MimeTypes.p(str);
                if (this.f7017l == -9223372036854775807L || length2 != 1 || !p2) {
                    z3 = false;
                } else {
                    z3 = true;
                }
                this.f7031z = z3;
                IcyHeaders icyHeaders = this.f7025t;
                if (icyHeaders != null) {
                    if (o2 || this.f7027v[i3].f7050b) {
                        Metadata metadata2 = format.f4012k;
                        if (metadata2 == null) {
                            metadata = new Metadata(icyHeaders);
                        } else {
                            metadata = metadata2.b(icyHeaders);
                        }
                        format = format.a().h0(metadata).K();
                    }
                    if (o2 && format.f4008g == -1 && format.f4009h == -1 && icyHeaders.f8291b != -1) {
                        format = format.a().M(icyHeaders.f8291b).K();
                    }
                }
                Format b2 = format.b(this.f7009d.c(format));
                trackGroupArr[i3] = new TrackGroup(Integer.toString(i3), b2);
            }
            this.A = new TrackState(new TrackGroupArray(trackGroupArr), zArr);
            if (this.f7031z && this.C == -9223372036854775807L) {
                this.C = this.f7017l;
                this.B = new ForwardingSeekMap(this.B) {
                    public long h() {
                        return ProgressiveMediaPeriod.this.C;
                    }
                };
            }
            this.f7013h.b(this.C, this.B.f(), this.D);
            this.f7029x = true;
            ((MediaPeriod.Callback) Assertions.f(this.f7024s)).m(this);
        }
    }

    private void W(int i2) {
        K();
        TrackState trackState = this.A;
        boolean[] zArr = trackState.f7054d;
        if (!zArr[i2]) {
            Format a2 = trackState.f7051a.b(i2).a(0);
            this.f7011f.h(MimeTypes.k(a2.f4015n), a2, 0, (Object) null, this.J);
            zArr[i2] = true;
        }
    }

    private void X(int i2) {
        K();
        boolean[] zArr = this.A.f7052b;
        if (this.L && zArr[i2]) {
            if (!this.f7026u[i2].L(false)) {
                this.K = 0;
                this.L = false;
                this.G = true;
                this.J = 0;
                this.M = 0;
                for (SampleQueue W : this.f7026u) {
                    W.W();
                }
                ((MediaPeriod.Callback) Assertions.f(this.f7024s)).p(this);
            }
        }
    }

    /* access modifiers changed from: private */
    public void a0() {
        this.f7023r.post(new u(this));
    }

    private TrackOutput e0(TrackId trackId) {
        int length = this.f7026u.length;
        for (int i2 = 0; i2 < length; i2++) {
            if (trackId.equals(this.f7027v[i2])) {
                return this.f7026u[i2];
            }
        }
        if (this.f7028w) {
            Log.h("ProgressiveMediaPeriod", "Extractor added new track (id=" + trackId.f7049a + ") after finishing tracks.");
            return new DiscardingTrackOutput();
        }
        SampleQueue k2 = SampleQueue.k(this.f7014i, this.f7009d, this.f7012g);
        k2.e0(this);
        int i3 = length + 1;
        TrackId[] trackIdArr = (TrackId[]) Arrays.copyOf(this.f7027v, i3);
        trackIdArr[length] = trackId;
        this.f7027v = (TrackId[]) Util.j(trackIdArr);
        SampleQueue[] sampleQueueArr = (SampleQueue[]) Arrays.copyOf(this.f7026u, i3);
        sampleQueueArr[length] = k2;
        this.f7026u = (SampleQueue[]) Util.j(sampleQueueArr);
        return k2;
    }

    private boolean h0(boolean[] zArr, long j2) {
        boolean z2;
        int length = this.f7026u.length;
        for (int i2 = 0; i2 < length; i2++) {
            SampleQueue sampleQueue = this.f7026u[i2];
            if (this.f7031z) {
                z2 = sampleQueue.Z(sampleQueue.y());
            } else {
                z2 = sampleQueue.a0(j2, false);
            }
            if (!z2 && (zArr[i2] || !this.f7030y)) {
                return false;
            }
        }
        return true;
    }

    /* access modifiers changed from: private */
    /* renamed from: i0 */
    public void U(SeekMap seekMap) {
        SeekMap seekMap2;
        boolean z2;
        if (this.f7025t == null) {
            seekMap2 = seekMap;
        } else {
            seekMap2 = new SeekMap.Unseekable(-9223372036854775807L);
        }
        this.B = seekMap2;
        this.C = seekMap.h();
        int i2 = 1;
        if (this.I || seekMap.h() != -9223372036854775807L) {
            z2 = false;
        } else {
            z2 = true;
        }
        this.D = z2;
        if (z2) {
            i2 = 7;
        }
        this.E = i2;
        if (this.f7029x) {
            this.f7013h.b(this.C, seekMap.f(), this.D);
        } else {
            V();
        }
    }

    private void k0() {
        ExtractingLoadable extractingLoadable = new ExtractingLoadable(this.f7007b, this.f7008c, this.f7019n, this, this.f7020o);
        if (this.f7029x) {
            Assertions.h(Q());
            long j2 = this.C;
            if (j2 == -9223372036854775807L || this.K <= j2) {
                extractingLoadable.j(((SeekMap) Assertions.f(this.B)).d(this.K).f8070a.f8076b, this.K);
                for (SampleQueue c02 : this.f7026u) {
                    c02.c0(this.K);
                }
                this.K = -9223372036854775807L;
            } else {
                this.N = true;
                this.K = -9223372036854775807L;
                return;
            }
        }
        this.M = N();
        this.f7011f.z(new LoadEventInfo(extractingLoadable.f7033a, extractingLoadable.f7043k, this.f7018m.n(extractingLoadable, this, this.f7010e.a(this.E))), 1, -1, (Format) null, 0, (Object) null, extractingLoadable.f7042j, this.C);
    }

    private boolean l0() {
        return this.G || Q();
    }

    /* access modifiers changed from: package-private */
    public TrackOutput P() {
        return e0(new TrackId(0, true));
    }

    /* access modifiers changed from: package-private */
    public boolean R(int i2) {
        return !l0() && this.f7026u[i2].L(this.N);
    }

    /* access modifiers changed from: package-private */
    public void Y() throws IOException {
        this.f7018m.k(this.f7010e.a(this.E));
    }

    /* access modifiers changed from: package-private */
    public void Z(int i2) throws IOException {
        this.f7026u[i2].O();
        Y();
    }

    public void a(Format format) {
        this.f7023r.post(this.f7021p);
    }

    public long b() {
        return e();
    }

    /* renamed from: b0 */
    public void u(ExtractingLoadable extractingLoadable, long j2, long j3, boolean z2) {
        StatsDataSource d2 = extractingLoadable.f7035c;
        LoadEventInfo loadEventInfo = new LoadEventInfo(extractingLoadable.f7033a, extractingLoadable.f7043k, d2.p(), d2.q(), j2, j3, d2.o());
        this.f7010e.b(extractingLoadable.f7033a);
        this.f7011f.q(loadEventInfo, 1, -1, (Format) null, 0, (Object) null, extractingLoadable.f7042j, this.C);
        if (!z2) {
            for (SampleQueue W : this.f7026u) {
                W.W();
            }
            if (this.H > 0) {
                ((MediaPeriod.Callback) Assertions.f(this.f7024s)).p(this);
            }
        }
    }

    public boolean c() {
        return this.f7018m.j() && this.f7020o.d();
    }

    /* renamed from: c0 */
    public void t(ExtractingLoadable extractingLoadable, long j2, long j3) {
        SeekMap seekMap;
        long j4;
        if (this.C == -9223372036854775807L && (seekMap = this.B) != null) {
            boolean f2 = seekMap.f();
            long O2 = O(true);
            if (O2 == Long.MIN_VALUE) {
                j4 = 0;
            } else {
                j4 = O2 + NotificationOptions.SKIP_STEP_TEN_SECONDS_IN_MS;
            }
            this.C = j4;
            this.f7013h.b(j4, f2, this.D);
        }
        StatsDataSource d2 = extractingLoadable.f7035c;
        LoadEventInfo loadEventInfo = new LoadEventInfo(extractingLoadable.f7033a, extractingLoadable.f7043k, d2.p(), d2.q(), j2, j3, d2.o());
        this.f7010e.b(extractingLoadable.f7033a);
        this.f7011f.t(loadEventInfo, 1, -1, (Format) null, 0, (Object) null, extractingLoadable.f7042j, this.C);
        this.N = true;
        ((MediaPeriod.Callback) Assertions.f(this.f7024s)).p(this);
    }

    public TrackOutput d(int i2, int i3) {
        return e0(new TrackId(i2, false));
    }

    /* renamed from: d0 */
    public Loader.LoadErrorAction p(ExtractingLoadable extractingLoadable, long j2, long j3, IOException iOException, int i2) {
        Loader.LoadErrorAction loadErrorAction;
        ExtractingLoadable extractingLoadable2;
        boolean z2;
        StatsDataSource d2 = extractingLoadable.f7035c;
        LoadEventInfo loadEventInfo = new LoadEventInfo(extractingLoadable.f7033a, extractingLoadable.f7043k, d2.p(), d2.q(), j2, j3, d2.o());
        long c2 = this.f7010e.c(new LoadErrorHandlingPolicy.LoadErrorInfo(loadEventInfo, new MediaLoadData(1, -1, (Format) null, 0, (Object) null, Util.t1(extractingLoadable.f7042j), Util.t1(this.C)), iOException, i2));
        if (c2 == -9223372036854775807L) {
            loadErrorAction = Loader.f7535g;
            ExtractingLoadable extractingLoadable3 = extractingLoadable;
        } else {
            int N2 = N();
            if (N2 > this.M) {
                extractingLoadable2 = extractingLoadable;
                z2 = true;
            } else {
                z2 = false;
                extractingLoadable2 = extractingLoadable;
            }
            if (L(extractingLoadable2, N2)) {
                loadErrorAction = Loader.h(z2, c2);
            } else {
                loadErrorAction = Loader.f7534f;
            }
        }
        boolean z3 = !loadErrorAction.c();
        this.f7011f.v(loadEventInfo, 1, -1, (Format) null, 0, (Object) null, extractingLoadable.f7042j, this.C, iOException, z3);
        if (z3) {
            this.f7010e.b(extractingLoadable.f7033a);
        }
        return loadErrorAction;
    }

    public long e() {
        long j2;
        K();
        if (this.N || this.H == 0) {
            return Long.MIN_VALUE;
        }
        if (Q()) {
            return this.K;
        }
        if (this.f7030y) {
            int length = this.f7026u.length;
            j2 = Long.MAX_VALUE;
            for (int i2 = 0; i2 < length; i2++) {
                TrackState trackState = this.A;
                if (trackState.f7052b[i2] && trackState.f7053c[i2] && !this.f7026u[i2].K()) {
                    j2 = Math.min(j2, this.f7026u[i2].A());
                }
            }
        } else {
            j2 = Long.MAX_VALUE;
        }
        if (j2 == Clock.MAX_TIME) {
            j2 = O(false);
        }
        if (j2 == Long.MIN_VALUE) {
            return this.J;
        }
        return j2;
    }

    public void f(long j2) {
    }

    /* access modifiers changed from: package-private */
    public int f0(int i2, FormatHolder formatHolder, DecoderInputBuffer decoderInputBuffer, int i3) {
        if (l0()) {
            return -3;
        }
        W(i2);
        int T = this.f7026u[i2].T(formatHolder, decoderInputBuffer, i3, this.N);
        if (T == -3) {
            X(i2);
        }
        return T;
    }

    public boolean g(LoadingInfo loadingInfo) {
        if (this.N || this.f7018m.i() || this.L) {
            return false;
        }
        if (this.f7029x && this.H == 0) {
            return false;
        }
        boolean e2 = this.f7020o.e();
        if (this.f7018m.j()) {
            return e2;
        }
        k0();
        return true;
    }

    public void g0() {
        if (this.f7029x) {
            for (SampleQueue S : this.f7026u) {
                S.S();
            }
        }
        this.f7018m.m(this);
        this.f7023r.removeCallbacksAndMessages((Object) null);
        this.f7024s = null;
        this.O = true;
    }

    public long h(long j2, SeekParameters seekParameters) {
        K();
        if (!this.B.f()) {
            return 0;
        }
        SeekMap.SeekPoints d2 = this.B.d(j2);
        return seekParameters.a(j2, d2.f8070a.f8075a, d2.f8071b.f8075a);
    }

    public long i(long j2) {
        K();
        boolean[] zArr = this.A.f7052b;
        if (!this.B.f()) {
            j2 = 0;
        }
        int i2 = 0;
        this.G = false;
        this.J = j2;
        if (Q()) {
            this.K = j2;
            return j2;
        } else if (this.E != 7 && ((this.N || this.f7018m.j()) && h0(zArr, j2))) {
            return j2;
        } else {
            this.L = false;
            this.K = j2;
            this.N = false;
            if (this.f7018m.j()) {
                SampleQueue[] sampleQueueArr = this.f7026u;
                int length = sampleQueueArr.length;
                while (i2 < length) {
                    sampleQueueArr[i2].r();
                    i2++;
                }
                this.f7018m.f();
            } else {
                this.f7018m.g();
                SampleQueue[] sampleQueueArr2 = this.f7026u;
                int length2 = sampleQueueArr2.length;
                while (i2 < length2) {
                    sampleQueueArr2[i2].W();
                    i2++;
                }
            }
            return j2;
        }
    }

    public long j() {
        if (!this.G) {
            return -9223372036854775807L;
        }
        if (!this.N && N() <= this.M) {
            return -9223372036854775807L;
        }
        this.G = false;
        return this.J;
    }

    /* access modifiers changed from: package-private */
    public int j0(int i2, long j2) {
        if (l0()) {
            return 0;
        }
        W(i2);
        SampleQueue sampleQueue = this.f7026u[i2];
        int F2 = sampleQueue.F(j2, this.N);
        sampleQueue.f0(F2);
        if (F2 == 0) {
            X(i2);
        }
        return F2;
    }

    public void k() {
        for (SampleQueue U : this.f7026u) {
            U.U();
        }
        this.f7019n.release();
    }

    public void l() throws IOException {
        Y();
        if (this.N && !this.f7029x) {
            throw ParserException.a("Loading finished before preparation is complete.", (Throwable) null);
        }
    }

    public void m() {
        this.f7028w = true;
        this.f7023r.post(this.f7021p);
    }

    public TrackGroupArray n() {
        K();
        return this.A.f7051a;
    }

    public void o(long j2, boolean z2) {
        if (!this.f7031z) {
            K();
            if (!Q()) {
                boolean[] zArr = this.A.f7053c;
                int length = this.f7026u.length;
                for (int i2 = 0; i2 < length; i2++) {
                    this.f7026u[i2].q(j2, z2, zArr[i2]);
                }
            }
        }
    }

    public long q(ExoTrackSelection[] exoTrackSelectionArr, boolean[] zArr, SampleStream[] sampleStreamArr, boolean[] zArr2, long j2) {
        boolean z2;
        ExoTrackSelection exoTrackSelection;
        boolean z3;
        boolean z4;
        K();
        TrackState trackState = this.A;
        TrackGroupArray trackGroupArray = trackState.f7051a;
        boolean[] zArr3 = trackState.f7053c;
        int i2 = this.H;
        int i3 = 0;
        for (int i4 = 0; i4 < exoTrackSelectionArr.length; i4++) {
            SampleStreamImpl sampleStreamImpl = sampleStreamArr[i4];
            if (sampleStreamImpl != null && (exoTrackSelectionArr[i4] == null || !zArr[i4])) {
                int b2 = sampleStreamImpl.f7047b;
                Assertions.h(zArr3[b2]);
                this.H--;
                zArr3[b2] = false;
                sampleStreamArr[i4] = null;
            }
        }
        if (!this.F ? j2 == 0 || this.f7031z : i2 != 0) {
            z2 = false;
        } else {
            z2 = true;
        }
        for (int i5 = 0; i5 < exoTrackSelectionArr.length; i5++) {
            if (sampleStreamArr[i5] == null && (exoTrackSelection = exoTrackSelectionArr[i5]) != null) {
                if (exoTrackSelection.length() == 1) {
                    z3 = true;
                } else {
                    z3 = false;
                }
                Assertions.h(z3);
                if (exoTrackSelection.c(0) == 0) {
                    z4 = true;
                } else {
                    z4 = false;
                }
                Assertions.h(z4);
                int d2 = trackGroupArray.d(exoTrackSelection.h());
                Assertions.h(!zArr3[d2]);
                this.H++;
                zArr3[d2] = true;
                sampleStreamArr[i5] = new SampleStreamImpl(d2);
                zArr2[i5] = true;
                if (!z2) {
                    SampleQueue sampleQueue = this.f7026u[d2];
                    if (sampleQueue.D() == 0 || sampleQueue.a0(j2, true)) {
                        z2 = false;
                    } else {
                        z2 = true;
                    }
                }
            }
        }
        if (this.H == 0) {
            this.L = false;
            this.G = false;
            if (this.f7018m.j()) {
                SampleQueue[] sampleQueueArr = this.f7026u;
                int length = sampleQueueArr.length;
                while (i3 < length) {
                    sampleQueueArr[i3].r();
                    i3++;
                }
                this.f7018m.f();
            } else {
                this.N = false;
                SampleQueue[] sampleQueueArr2 = this.f7026u;
                int length2 = sampleQueueArr2.length;
                while (i3 < length2) {
                    sampleQueueArr2[i3].W();
                    i3++;
                }
            }
        } else if (z2) {
            j2 = i(j2);
            while (i3 < sampleStreamArr.length) {
                if (sampleStreamArr[i3] != null) {
                    zArr2[i3] = true;
                }
                i3++;
            }
        }
        this.F = true;
        return j2;
    }

    public void r(SeekMap seekMap) {
        this.f7023r.post(new v(this, seekMap));
    }

    public void s(MediaPeriod.Callback callback, long j2) {
        this.f7024s = callback;
        this.f7020o.e();
        k0();
    }
}
