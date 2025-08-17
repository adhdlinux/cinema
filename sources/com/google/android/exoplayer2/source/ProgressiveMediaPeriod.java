package com.google.android.exoplayer2.source;

import android.net.Uri;
import android.os.Handler;
import com.facebook.common.time.Clock;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.FormatHolder;
import com.google.android.exoplayer2.ParserException;
import com.google.android.exoplayer2.SeekParameters;
import com.google.android.exoplayer2.decoder.DecoderInputBuffer;
import com.google.android.exoplayer2.drm.DrmSessionEventListener;
import com.google.android.exoplayer2.drm.DrmSessionManager;
import com.google.android.exoplayer2.extractor.ExtractorOutput;
import com.google.android.exoplayer2.extractor.PositionHolder;
import com.google.android.exoplayer2.extractor.SeekMap;
import com.google.android.exoplayer2.extractor.TrackOutput;
import com.google.android.exoplayer2.metadata.Metadata;
import com.google.android.exoplayer2.metadata.icy.IcyHeaders;
import com.google.android.exoplayer2.source.IcyDataSource;
import com.google.android.exoplayer2.source.MediaPeriod;
import com.google.android.exoplayer2.source.MediaSourceEventListener;
import com.google.android.exoplayer2.source.SampleQueue;
import com.google.android.exoplayer2.trackselection.ExoTrackSelection;
import com.google.android.exoplayer2.upstream.Allocator;
import com.google.android.exoplayer2.upstream.DataReader;
import com.google.android.exoplayer2.upstream.DataSource;
import com.google.android.exoplayer2.upstream.DataSourceUtil;
import com.google.android.exoplayer2.upstream.DataSpec;
import com.google.android.exoplayer2.upstream.LoadErrorHandlingPolicy;
import com.google.android.exoplayer2.upstream.Loader;
import com.google.android.exoplayer2.upstream.StatsDataSource;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.ConditionVariable;
import com.google.android.exoplayer2.util.MimeTypes;
import com.google.android.exoplayer2.util.ParsableByteArray;
import com.google.android.exoplayer2.util.Util;
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
    public static final Map<String, String> N = L();
    /* access modifiers changed from: private */
    public static final Format O = new Format.Builder().U("icy").g0("application/x-icy").G();
    private long A;
    private boolean B;
    private int C;
    private boolean D;
    private boolean E;
    private int F;
    private boolean G;
    private long H;
    private long I;
    private boolean J;
    private int K;
    private boolean L;
    private boolean M;

    /* renamed from: b  reason: collision with root package name */
    private final Uri f25835b;

    /* renamed from: c  reason: collision with root package name */
    private final DataSource f25836c;

    /* renamed from: d  reason: collision with root package name */
    private final DrmSessionManager f25837d;

    /* renamed from: e  reason: collision with root package name */
    private final LoadErrorHandlingPolicy f25838e;

    /* renamed from: f  reason: collision with root package name */
    private final MediaSourceEventListener.EventDispatcher f25839f;

    /* renamed from: g  reason: collision with root package name */
    private final DrmSessionEventListener.EventDispatcher f25840g;

    /* renamed from: h  reason: collision with root package name */
    private final Listener f25841h;

    /* renamed from: i  reason: collision with root package name */
    private final Allocator f25842i;
    /* access modifiers changed from: private */

    /* renamed from: j  reason: collision with root package name */
    public final String f25843j;
    /* access modifiers changed from: private */

    /* renamed from: k  reason: collision with root package name */
    public final long f25844k;

    /* renamed from: l  reason: collision with root package name */
    private final Loader f25845l = new Loader("ProgressiveMediaPeriod");

    /* renamed from: m  reason: collision with root package name */
    private final ProgressiveMediaExtractor f25846m;

    /* renamed from: n  reason: collision with root package name */
    private final ConditionVariable f25847n;

    /* renamed from: o  reason: collision with root package name */
    private final Runnable f25848o;
    /* access modifiers changed from: private */

    /* renamed from: p  reason: collision with root package name */
    public final Runnable f25849p;
    /* access modifiers changed from: private */

    /* renamed from: q  reason: collision with root package name */
    public final Handler f25850q;

    /* renamed from: r  reason: collision with root package name */
    private MediaPeriod.Callback f25851r;
    /* access modifiers changed from: private */

    /* renamed from: s  reason: collision with root package name */
    public IcyHeaders f25852s;

    /* renamed from: t  reason: collision with root package name */
    private SampleQueue[] f25853t;

    /* renamed from: u  reason: collision with root package name */
    private TrackId[] f25854u;

    /* renamed from: v  reason: collision with root package name */
    private boolean f25855v;

    /* renamed from: w  reason: collision with root package name */
    private boolean f25856w;

    /* renamed from: x  reason: collision with root package name */
    private boolean f25857x;

    /* renamed from: y  reason: collision with root package name */
    private TrackState f25858y;

    /* renamed from: z  reason: collision with root package name */
    private SeekMap f25859z;

    final class ExtractingLoadable implements Loader.Loadable, IcyDataSource.Listener {
        /* access modifiers changed from: private */

        /* renamed from: a  reason: collision with root package name */
        public final long f25860a = LoadEventInfo.a();

        /* renamed from: b  reason: collision with root package name */
        private final Uri f25861b;
        /* access modifiers changed from: private */

        /* renamed from: c  reason: collision with root package name */
        public final StatsDataSource f25862c;

        /* renamed from: d  reason: collision with root package name */
        private final ProgressiveMediaExtractor f25863d;

        /* renamed from: e  reason: collision with root package name */
        private final ExtractorOutput f25864e;

        /* renamed from: f  reason: collision with root package name */
        private final ConditionVariable f25865f;

        /* renamed from: g  reason: collision with root package name */
        private final PositionHolder f25866g = new PositionHolder();

        /* renamed from: h  reason: collision with root package name */
        private volatile boolean f25867h;

        /* renamed from: i  reason: collision with root package name */
        private boolean f25868i = true;
        /* access modifiers changed from: private */

        /* renamed from: j  reason: collision with root package name */
        public long f25869j;
        /* access modifiers changed from: private */

        /* renamed from: k  reason: collision with root package name */
        public DataSpec f25870k = i(0);

        /* renamed from: l  reason: collision with root package name */
        private TrackOutput f25871l;

        /* renamed from: m  reason: collision with root package name */
        private boolean f25872m;

        public ExtractingLoadable(Uri uri, DataSource dataSource, ProgressiveMediaExtractor progressiveMediaExtractor, ExtractorOutput extractorOutput, ConditionVariable conditionVariable) {
            this.f25861b = uri;
            this.f25862c = new StatsDataSource(dataSource);
            this.f25863d = progressiveMediaExtractor;
            this.f25864e = extractorOutput;
            this.f25865f = conditionVariable;
        }

        private DataSpec i(long j2) {
            return new DataSpec.Builder().i(this.f25861b).h(j2).f(ProgressiveMediaPeriod.this.f25843j).b(6).e(ProgressiveMediaPeriod.N).a();
        }

        /* access modifiers changed from: private */
        public void j(long j2, long j3) {
            this.f25866g.f24231a = j2;
            this.f25869j = j3;
            this.f25868i = true;
            this.f25872m = false;
        }

        public void a() throws IOException {
            int i2 = 0;
            while (i2 == 0 && !this.f25867h) {
                try {
                    long j2 = this.f25866g.f24231a;
                    DataSpec i3 = i(j2);
                    this.f25870k = i3;
                    long i4 = this.f25862c.i(i3);
                    if (i4 != -1) {
                        i4 += j2;
                        ProgressiveMediaPeriod.this.Z();
                    }
                    long j3 = i4;
                    IcyHeaders unused = ProgressiveMediaPeriod.this.f25852s = IcyHeaders.b(this.f25862c.d());
                    DataReader dataReader = this.f25862c;
                    if (!(ProgressiveMediaPeriod.this.f25852s == null || ProgressiveMediaPeriod.this.f25852s.f25396g == -1)) {
                        dataReader = new IcyDataSource(this.f25862c, ProgressiveMediaPeriod.this.f25852s.f25396g, this);
                        TrackOutput O = ProgressiveMediaPeriod.this.O();
                        this.f25871l = O;
                        O.d(ProgressiveMediaPeriod.O);
                    }
                    long j4 = j2;
                    this.f25863d.e(dataReader, this.f25861b, this.f25862c.d(), j2, j3, this.f25864e);
                    if (ProgressiveMediaPeriod.this.f25852s != null) {
                        this.f25863d.b();
                    }
                    if (this.f25868i) {
                        this.f25863d.a(j4, this.f25869j);
                        this.f25868i = false;
                    }
                    while (true) {
                        long j5 = j4;
                        while (i2 == 0 && !this.f25867h) {
                            this.f25865f.a();
                            i2 = this.f25863d.d(this.f25866g);
                            j4 = this.f25863d.c();
                            if (j4 > ProgressiveMediaPeriod.this.f25844k + j5) {
                                this.f25865f.d();
                                ProgressiveMediaPeriod.this.f25850q.post(ProgressiveMediaPeriod.this.f25849p);
                            }
                        }
                    }
                    if (i2 == 1) {
                        i2 = 0;
                    } else if (this.f25863d.c() != -1) {
                        this.f25866g.f24231a = this.f25863d.c();
                    }
                    DataSourceUtil.a(this.f25862c);
                } catch (InterruptedException unused2) {
                    throw new InterruptedIOException();
                } catch (Throwable th) {
                    if (!(i2 == 1 || this.f25863d.c() == -1)) {
                        this.f25866g.f24231a = this.f25863d.c();
                    }
                    DataSourceUtil.a(this.f25862c);
                    throw th;
                }
            }
        }

        public void b() {
            this.f25867h = true;
        }

        public void c(ParsableByteArray parsableByteArray) {
            long j2;
            if (!this.f25872m) {
                j2 = this.f25869j;
            } else {
                j2 = Math.max(ProgressiveMediaPeriod.this.N(true), this.f25869j);
            }
            int a2 = parsableByteArray.a();
            TrackOutput trackOutput = (TrackOutput) Assertions.e(this.f25871l);
            trackOutput.c(parsableByteArray, a2);
            trackOutput.e(j2, 1, a2, 0, (TrackOutput.CryptoData) null);
            this.f25872m = true;
        }
    }

    interface Listener {
        void b(long j2, boolean z2, boolean z3);
    }

    private final class SampleStreamImpl implements SampleStream {
        /* access modifiers changed from: private */

        /* renamed from: b  reason: collision with root package name */
        public final int f25874b;

        public SampleStreamImpl(int i2) {
            this.f25874b = i2;
        }

        public void a() throws IOException {
            ProgressiveMediaPeriod.this.Y(this.f25874b);
        }

        public int d(long j2) {
            return ProgressiveMediaPeriod.this.i0(this.f25874b, j2);
        }

        public boolean isReady() {
            return ProgressiveMediaPeriod.this.Q(this.f25874b);
        }

        public int m(FormatHolder formatHolder, DecoderInputBuffer decoderInputBuffer, int i2) {
            return ProgressiveMediaPeriod.this.e0(this.f25874b, formatHolder, decoderInputBuffer, i2);
        }
    }

    private static final class TrackId {

        /* renamed from: a  reason: collision with root package name */
        public final int f25876a;

        /* renamed from: b  reason: collision with root package name */
        public final boolean f25877b;

        public TrackId(int i2, boolean z2) {
            this.f25876a = i2;
            this.f25877b = z2;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || TrackId.class != obj.getClass()) {
                return false;
            }
            TrackId trackId = (TrackId) obj;
            if (this.f25876a == trackId.f25876a && this.f25877b == trackId.f25877b) {
                return true;
            }
            return false;
        }

        public int hashCode() {
            return (this.f25876a * 31) + (this.f25877b ? 1 : 0);
        }
    }

    private static final class TrackState {

        /* renamed from: a  reason: collision with root package name */
        public final TrackGroupArray f25878a;

        /* renamed from: b  reason: collision with root package name */
        public final boolean[] f25879b;

        /* renamed from: c  reason: collision with root package name */
        public final boolean[] f25880c;

        /* renamed from: d  reason: collision with root package name */
        public final boolean[] f25881d;

        public TrackState(TrackGroupArray trackGroupArray, boolean[] zArr) {
            this.f25878a = trackGroupArray;
            this.f25879b = zArr;
            int i2 = trackGroupArray.f26010b;
            this.f25880c = new boolean[i2];
            this.f25881d = new boolean[i2];
        }
    }

    public ProgressiveMediaPeriod(Uri uri, DataSource dataSource, ProgressiveMediaExtractor progressiveMediaExtractor, DrmSessionManager drmSessionManager, DrmSessionEventListener.EventDispatcher eventDispatcher, LoadErrorHandlingPolicy loadErrorHandlingPolicy, MediaSourceEventListener.EventDispatcher eventDispatcher2, Listener listener, Allocator allocator, String str, int i2) {
        this.f25835b = uri;
        this.f25836c = dataSource;
        this.f25837d = drmSessionManager;
        this.f25840g = eventDispatcher;
        this.f25838e = loadErrorHandlingPolicy;
        this.f25839f = eventDispatcher2;
        this.f25841h = listener;
        this.f25842i = allocator;
        this.f25843j = str;
        this.f25844k = (long) i2;
        this.f25846m = progressiveMediaExtractor;
        this.f25847n = new ConditionVariable();
        this.f25848o = new o(this);
        this.f25849p = new p(this);
        this.f25850q = Util.w();
        this.f25854u = new TrackId[0];
        this.f25853t = new SampleQueue[0];
        this.I = -9223372036854775807L;
        this.A = -9223372036854775807L;
        this.C = 1;
    }

    @EnsuresNonNull({"trackState", "seekMap"})
    private void J() {
        Assertions.g(this.f25856w);
        Assertions.e(this.f25858y);
        Assertions.e(this.f25859z);
    }

    private boolean K(ExtractingLoadable extractingLoadable, int i2) {
        SeekMap seekMap;
        if (this.G || !((seekMap = this.f25859z) == null || seekMap.h() == -9223372036854775807L)) {
            this.K = i2;
            return true;
        }
        if (!this.f25856w || k0()) {
            this.E = this.f25856w;
            this.H = 0;
            this.K = 0;
            for (SampleQueue V : this.f25853t) {
                V.V();
            }
            extractingLoadable.j(0, 0);
            return true;
        }
        this.J = true;
        return false;
    }

    private static Map<String, String> L() {
        HashMap hashMap = new HashMap();
        hashMap.put("Icy-MetaData", "1");
        return Collections.unmodifiableMap(hashMap);
    }

    private int M() {
        int i2 = 0;
        for (SampleQueue G2 : this.f25853t) {
            i2 += G2.G();
        }
        return i2;
    }

    /* access modifiers changed from: private */
    public long N(boolean z2) {
        long j2 = Long.MIN_VALUE;
        for (int i2 = 0; i2 < this.f25853t.length; i2++) {
            if (z2 || ((TrackState) Assertions.e(this.f25858y)).f25880c[i2]) {
                j2 = Math.max(j2, this.f25853t[i2].z());
            }
        }
        return j2;
    }

    private boolean P() {
        return this.I != -9223372036854775807L;
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void R() {
        if (!this.M) {
            ((MediaPeriod.Callback) Assertions.e(this.f25851r)).d(this);
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void S() {
        this.G = true;
    }

    /* access modifiers changed from: private */
    public void U() {
        boolean z2;
        Metadata metadata;
        if (!this.M && !this.f25856w && this.f25855v && this.f25859z != null) {
            SampleQueue[] sampleQueueArr = this.f25853t;
            int length = sampleQueueArr.length;
            int i2 = 0;
            while (i2 < length) {
                if (sampleQueueArr[i2].F() != null) {
                    i2++;
                } else {
                    return;
                }
            }
            this.f25847n.d();
            int length2 = this.f25853t.length;
            TrackGroup[] trackGroupArr = new TrackGroup[length2];
            boolean[] zArr = new boolean[length2];
            for (int i3 = 0; i3 < length2; i3++) {
                Format format = (Format) Assertions.e(this.f25853t[i3].F());
                String str = format.f23071m;
                boolean o2 = MimeTypes.o(str);
                if (o2 || MimeTypes.s(str)) {
                    z2 = true;
                } else {
                    z2 = false;
                }
                zArr[i3] = z2;
                this.f25857x = z2 | this.f25857x;
                IcyHeaders icyHeaders = this.f25852s;
                if (icyHeaders != null) {
                    if (o2 || this.f25854u[i3].f25877b) {
                        Metadata metadata2 = format.f23069k;
                        if (metadata2 == null) {
                            metadata = new Metadata(icyHeaders);
                        } else {
                            metadata = metadata2.b(icyHeaders);
                        }
                        format = format.b().Z(metadata).G();
                    }
                    if (o2 && format.f23065g == -1 && format.f23066h == -1 && icyHeaders.f25391b != -1) {
                        format = format.b().I(icyHeaders.f25391b).G();
                    }
                }
                Format c2 = format.c(this.f25837d.a(format));
                trackGroupArr[i3] = new TrackGroup(Integer.toString(i3), c2);
            }
            this.f25858y = new TrackState(new TrackGroupArray(trackGroupArr), zArr);
            this.f25856w = true;
            ((MediaPeriod.Callback) Assertions.e(this.f25851r)).p(this);
        }
    }

    private void V(int i2) {
        J();
        TrackState trackState = this.f25858y;
        boolean[] zArr = trackState.f25881d;
        if (!zArr[i2]) {
            Format c2 = trackState.f25878a.b(i2).c(0);
            this.f25839f.i(MimeTypes.k(c2.f23071m), c2, 0, (Object) null, this.H);
            zArr[i2] = true;
        }
    }

    private void W(int i2) {
        J();
        boolean[] zArr = this.f25858y.f25879b;
        if (this.J && zArr[i2]) {
            if (!this.f25853t[i2].K(false)) {
                this.I = 0;
                this.J = false;
                this.E = true;
                this.H = 0;
                this.K = 0;
                for (SampleQueue V : this.f25853t) {
                    V.V();
                }
                ((MediaPeriod.Callback) Assertions.e(this.f25851r)).d(this);
            }
        }
    }

    /* access modifiers changed from: private */
    public void Z() {
        this.f25850q.post(new q(this));
    }

    private TrackOutput d0(TrackId trackId) {
        int length = this.f25853t.length;
        for (int i2 = 0; i2 < length; i2++) {
            if (trackId.equals(this.f25854u[i2])) {
                return this.f25853t[i2];
            }
        }
        SampleQueue k2 = SampleQueue.k(this.f25842i, this.f25837d, this.f25840g);
        k2.d0(this);
        int i3 = length + 1;
        TrackId[] trackIdArr = (TrackId[]) Arrays.copyOf(this.f25854u, i3);
        trackIdArr[length] = trackId;
        this.f25854u = (TrackId[]) Util.k(trackIdArr);
        SampleQueue[] sampleQueueArr = (SampleQueue[]) Arrays.copyOf(this.f25853t, i3);
        sampleQueueArr[length] = k2;
        this.f25853t = (SampleQueue[]) Util.k(sampleQueueArr);
        return k2;
    }

    private boolean g0(boolean[] zArr, long j2) {
        int length = this.f25853t.length;
        for (int i2 = 0; i2 < length; i2++) {
            if (!this.f25853t[i2].Z(j2, false) && (zArr[i2] || !this.f25857x)) {
                return false;
            }
        }
        return true;
    }

    /* access modifiers changed from: private */
    /* renamed from: h0 */
    public void T(SeekMap seekMap) {
        SeekMap seekMap2;
        boolean z2;
        if (this.f25852s == null) {
            seekMap2 = seekMap;
        } else {
            seekMap2 = new SeekMap.Unseekable(-9223372036854775807L);
        }
        this.f25859z = seekMap2;
        this.A = seekMap.h();
        int i2 = 1;
        if (this.G || seekMap.h() != -9223372036854775807L) {
            z2 = false;
        } else {
            z2 = true;
        }
        this.B = z2;
        if (z2) {
            i2 = 7;
        }
        this.C = i2;
        this.f25841h.b(this.A, seekMap.f(), this.B);
        if (!this.f25856w) {
            U();
        }
    }

    private void j0() {
        ExtractingLoadable extractingLoadable = new ExtractingLoadable(this.f25835b, this.f25836c, this.f25846m, this, this.f25847n);
        if (this.f25856w) {
            Assertions.g(P());
            long j2 = this.A;
            if (j2 == -9223372036854775807L || this.I <= j2) {
                extractingLoadable.j(((SeekMap) Assertions.e(this.f25859z)).d(this.I).f24232a.f24238b, this.I);
                for (SampleQueue b02 : this.f25853t) {
                    b02.b0(this.I);
                }
                this.I = -9223372036854775807L;
            } else {
                this.L = true;
                this.I = -9223372036854775807L;
                return;
            }
        }
        this.K = M();
        this.f25839f.A(new LoadEventInfo(extractingLoadable.f25860a, extractingLoadable.f25870k, this.f25845l.n(extractingLoadable, this, this.f25838e.a(this.C))), 1, -1, (Format) null, 0, (Object) null, extractingLoadable.f25869j, this.A);
    }

    private boolean k0() {
        return this.E || P();
    }

    /* access modifiers changed from: package-private */
    public TrackOutput O() {
        return d0(new TrackId(0, true));
    }

    /* access modifiers changed from: package-private */
    public boolean Q(int i2) {
        return !k0() && this.f25853t[i2].K(this.L);
    }

    /* access modifiers changed from: package-private */
    public void X() throws IOException {
        this.f25845l.k(this.f25838e.a(this.C));
    }

    /* access modifiers changed from: package-private */
    public void Y(int i2) throws IOException {
        this.f25853t[i2].N();
        X();
    }

    public void a(Format format) {
        this.f25850q.post(this.f25848o);
    }

    /* renamed from: a0 */
    public void p(ExtractingLoadable extractingLoadable, long j2, long j3, boolean z2) {
        StatsDataSource d2 = extractingLoadable.f25862c;
        LoadEventInfo loadEventInfo = new LoadEventInfo(extractingLoadable.f25860a, extractingLoadable.f25870k, d2.s(), d2.t(), j2, j3, d2.q());
        this.f25838e.b(extractingLoadable.f25860a);
        this.f25839f.r(loadEventInfo, 1, -1, (Format) null, 0, (Object) null, extractingLoadable.f25869j, this.A);
        if (!z2) {
            for (SampleQueue V : this.f25853t) {
                V.V();
            }
            if (this.F > 0) {
                ((MediaPeriod.Callback) Assertions.e(this.f25851r)).d(this);
            }
        }
    }

    public long b() {
        return e();
    }

    /* renamed from: b0 */
    public void q(ExtractingLoadable extractingLoadable, long j2, long j3) {
        SeekMap seekMap;
        long j4;
        if (this.A == -9223372036854775807L && (seekMap = this.f25859z) != null) {
            boolean f2 = seekMap.f();
            long N2 = N(true);
            if (N2 == Long.MIN_VALUE) {
                j4 = 0;
            } else {
                j4 = N2 + NotificationOptions.SKIP_STEP_TEN_SECONDS_IN_MS;
            }
            this.A = j4;
            this.f25841h.b(j4, f2, this.B);
        }
        StatsDataSource d2 = extractingLoadable.f25862c;
        LoadEventInfo loadEventInfo = new LoadEventInfo(extractingLoadable.f25860a, extractingLoadable.f25870k, d2.s(), d2.t(), j2, j3, d2.q());
        this.f25838e.b(extractingLoadable.f25860a);
        this.f25839f.u(loadEventInfo, 1, -1, (Format) null, 0, (Object) null, extractingLoadable.f25869j, this.A);
        this.L = true;
        ((MediaPeriod.Callback) Assertions.e(this.f25851r)).d(this);
    }

    public boolean c() {
        return this.f25845l.j() && this.f25847n.e();
    }

    /* renamed from: c0 */
    public Loader.LoadErrorAction t(ExtractingLoadable extractingLoadable, long j2, long j3, IOException iOException, int i2) {
        Loader.LoadErrorAction loadErrorAction;
        ExtractingLoadable extractingLoadable2;
        boolean z2;
        StatsDataSource d2 = extractingLoadable.f25862c;
        LoadEventInfo loadEventInfo = new LoadEventInfo(extractingLoadable.f25860a, extractingLoadable.f25870k, d2.s(), d2.t(), j2, j3, d2.q());
        long c2 = this.f25838e.c(new LoadErrorHandlingPolicy.LoadErrorInfo(loadEventInfo, new MediaLoadData(1, -1, (Format) null, 0, (Object) null, Util.i1(extractingLoadable.f25869j), Util.i1(this.A)), iOException, i2));
        if (c2 == -9223372036854775807L) {
            loadErrorAction = Loader.f28465g;
            ExtractingLoadable extractingLoadable3 = extractingLoadable;
        } else {
            int M2 = M();
            if (M2 > this.K) {
                extractingLoadable2 = extractingLoadable;
                z2 = true;
            } else {
                z2 = false;
                extractingLoadable2 = extractingLoadable;
            }
            if (K(extractingLoadable2, M2)) {
                loadErrorAction = Loader.h(z2, c2);
            } else {
                loadErrorAction = Loader.f28464f;
            }
        }
        boolean z3 = !loadErrorAction.c();
        this.f25839f.w(loadEventInfo, 1, -1, (Format) null, 0, (Object) null, extractingLoadable.f25869j, this.A, iOException, z3);
        if (z3) {
            this.f25838e.b(extractingLoadable.f25860a);
        }
        return loadErrorAction;
    }

    public TrackOutput d(int i2, int i3) {
        return d0(new TrackId(i2, false));
    }

    public long e() {
        long j2;
        J();
        if (this.L || this.F == 0) {
            return Long.MIN_VALUE;
        }
        if (P()) {
            return this.I;
        }
        if (this.f25857x) {
            int length = this.f25853t.length;
            j2 = Long.MAX_VALUE;
            for (int i2 = 0; i2 < length; i2++) {
                TrackState trackState = this.f25858y;
                if (trackState.f25879b[i2] && trackState.f25880c[i2] && !this.f25853t[i2].J()) {
                    j2 = Math.min(j2, this.f25853t[i2].z());
                }
            }
        } else {
            j2 = Long.MAX_VALUE;
        }
        if (j2 == Clock.MAX_TIME) {
            j2 = N(false);
        }
        if (j2 == Long.MIN_VALUE) {
            return this.H;
        }
        return j2;
    }

    /* access modifiers changed from: package-private */
    public int e0(int i2, FormatHolder formatHolder, DecoderInputBuffer decoderInputBuffer, int i3) {
        if (k0()) {
            return -3;
        }
        V(i2);
        int S = this.f25853t[i2].S(formatHolder, decoderInputBuffer, i3, this.L);
        if (S == -3) {
            W(i2);
        }
        return S;
    }

    public void f(long j2) {
    }

    public void f0() {
        if (this.f25856w) {
            for (SampleQueue R : this.f25853t) {
                R.R();
            }
        }
        this.f25845l.m(this);
        this.f25850q.removeCallbacksAndMessages((Object) null);
        this.f25851r = null;
        this.M = true;
    }

    public long g(long j2, SeekParameters seekParameters) {
        J();
        if (!this.f25859z.f()) {
            return 0;
        }
        SeekMap.SeekPoints d2 = this.f25859z.d(j2);
        return seekParameters.a(j2, d2.f24232a.f24237a, d2.f24233b.f24237a);
    }

    public boolean h(long j2) {
        if (this.L || this.f25845l.i() || this.J) {
            return false;
        }
        if (this.f25856w && this.F == 0) {
            return false;
        }
        boolean f2 = this.f25847n.f();
        if (this.f25845l.j()) {
            return f2;
        }
        j0();
        return true;
    }

    public long i(long j2) {
        J();
        boolean[] zArr = this.f25858y.f25879b;
        if (!this.f25859z.f()) {
            j2 = 0;
        }
        int i2 = 0;
        this.E = false;
        this.H = j2;
        if (P()) {
            this.I = j2;
            return j2;
        } else if (this.C != 7 && g0(zArr, j2)) {
            return j2;
        } else {
            this.J = false;
            this.I = j2;
            this.L = false;
            if (this.f25845l.j()) {
                SampleQueue[] sampleQueueArr = this.f25853t;
                int length = sampleQueueArr.length;
                while (i2 < length) {
                    sampleQueueArr[i2].r();
                    i2++;
                }
                this.f25845l.f();
            } else {
                this.f25845l.g();
                SampleQueue[] sampleQueueArr2 = this.f25853t;
                int length2 = sampleQueueArr2.length;
                while (i2 < length2) {
                    sampleQueueArr2[i2].V();
                    i2++;
                }
            }
            return j2;
        }
    }

    /* access modifiers changed from: package-private */
    public int i0(int i2, long j2) {
        if (k0()) {
            return 0;
        }
        V(i2);
        SampleQueue sampleQueue = this.f25853t[i2];
        int E2 = sampleQueue.E(j2, this.L);
        sampleQueue.e0(E2);
        if (E2 == 0) {
            W(i2);
        }
        return E2;
    }

    public long j() {
        if (!this.E) {
            return -9223372036854775807L;
        }
        if (!this.L && M() <= this.K) {
            return -9223372036854775807L;
        }
        this.E = false;
        return this.H;
    }

    public void k() {
        for (SampleQueue T : this.f25853t) {
            T.T();
        }
        this.f25846m.release();
    }

    public void l() throws IOException {
        X();
        if (this.L && !this.f25856w) {
            throw ParserException.a("Loading finished before preparation is complete.", (Throwable) null);
        }
    }

    public void m() {
        this.f25855v = true;
        this.f25850q.post(this.f25848o);
    }

    public TrackGroupArray n() {
        J();
        return this.f25858y.f25878a;
    }

    public void o(long j2, boolean z2) {
        J();
        if (!P()) {
            boolean[] zArr = this.f25858y.f25880c;
            int length = this.f25853t.length;
            for (int i2 = 0; i2 < length; i2++) {
                this.f25853t[i2].q(j2, z2, zArr[i2]);
            }
        }
    }

    public void r(MediaPeriod.Callback callback, long j2) {
        this.f25851r = callback;
        this.f25847n.f();
        j0();
    }

    public long s(ExoTrackSelection[] exoTrackSelectionArr, boolean[] zArr, SampleStream[] sampleStreamArr, boolean[] zArr2, long j2) {
        boolean z2;
        ExoTrackSelection exoTrackSelection;
        boolean z3;
        boolean z4;
        J();
        TrackState trackState = this.f25858y;
        TrackGroupArray trackGroupArray = trackState.f25878a;
        boolean[] zArr3 = trackState.f25880c;
        int i2 = this.F;
        int i3 = 0;
        for (int i4 = 0; i4 < exoTrackSelectionArr.length; i4++) {
            SampleStreamImpl sampleStreamImpl = sampleStreamArr[i4];
            if (sampleStreamImpl != null && (exoTrackSelectionArr[i4] == null || !zArr[i4])) {
                int b2 = sampleStreamImpl.f25874b;
                Assertions.g(zArr3[b2]);
                this.F--;
                zArr3[b2] = false;
                sampleStreamArr[i4] = null;
            }
        }
        if (!this.D ? j2 == 0 : i2 != 0) {
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
                Assertions.g(z3);
                if (exoTrackSelection.c(0) == 0) {
                    z4 = true;
                } else {
                    z4 = false;
                }
                Assertions.g(z4);
                int c2 = trackGroupArray.c(exoTrackSelection.h());
                Assertions.g(!zArr3[c2]);
                this.F++;
                zArr3[c2] = true;
                sampleStreamArr[i5] = new SampleStreamImpl(c2);
                zArr2[i5] = true;
                if (!z2) {
                    SampleQueue sampleQueue = this.f25853t[c2];
                    if (sampleQueue.Z(j2, true) || sampleQueue.C() == 0) {
                        z2 = false;
                    } else {
                        z2 = true;
                    }
                }
            }
        }
        if (this.F == 0) {
            this.J = false;
            this.E = false;
            if (this.f25845l.j()) {
                SampleQueue[] sampleQueueArr = this.f25853t;
                int length = sampleQueueArr.length;
                while (i3 < length) {
                    sampleQueueArr[i3].r();
                    i3++;
                }
                this.f25845l.f();
            } else {
                SampleQueue[] sampleQueueArr2 = this.f25853t;
                int length2 = sampleQueueArr2.length;
                while (i3 < length2) {
                    sampleQueueArr2[i3].V();
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
        this.D = true;
        return j2;
    }

    public void u(SeekMap seekMap) {
        this.f25850q.post(new r(this, seekMap));
    }
}
