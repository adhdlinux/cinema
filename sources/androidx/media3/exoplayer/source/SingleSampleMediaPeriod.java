package androidx.media3.exoplayer.source;

import androidx.media3.common.Format;
import androidx.media3.common.MimeTypes;
import androidx.media3.common.TrackGroup;
import androidx.media3.common.util.Assertions;
import androidx.media3.common.util.Log;
import androidx.media3.common.util.Util;
import androidx.media3.datasource.DataSource;
import androidx.media3.datasource.DataSourceUtil;
import androidx.media3.datasource.DataSpec;
import androidx.media3.datasource.StatsDataSource;
import androidx.media3.datasource.TransferListener;
import androidx.media3.decoder.DecoderInputBuffer;
import androidx.media3.exoplayer.FormatHolder;
import androidx.media3.exoplayer.LoadingInfo;
import androidx.media3.exoplayer.SeekParameters;
import androidx.media3.exoplayer.source.MediaPeriod;
import androidx.media3.exoplayer.source.MediaSourceEventListener;
import androidx.media3.exoplayer.trackselection.ExoTrackSelection;
import androidx.media3.exoplayer.upstream.LoadErrorHandlingPolicy;
import androidx.media3.exoplayer.upstream.Loader;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Arrays;

final class SingleSampleMediaPeriod implements MediaPeriod, Loader.Callback<SourceLoadable> {

    /* renamed from: b  reason: collision with root package name */
    private final DataSpec f7132b;

    /* renamed from: c  reason: collision with root package name */
    private final DataSource.Factory f7133c;

    /* renamed from: d  reason: collision with root package name */
    private final TransferListener f7134d;

    /* renamed from: e  reason: collision with root package name */
    private final LoadErrorHandlingPolicy f7135e;
    /* access modifiers changed from: private */

    /* renamed from: f  reason: collision with root package name */
    public final MediaSourceEventListener.EventDispatcher f7136f;

    /* renamed from: g  reason: collision with root package name */
    private final TrackGroupArray f7137g;

    /* renamed from: h  reason: collision with root package name */
    private final ArrayList<SampleStreamImpl> f7138h = new ArrayList<>();

    /* renamed from: i  reason: collision with root package name */
    private final long f7139i;

    /* renamed from: j  reason: collision with root package name */
    final Loader f7140j = new Loader("SingleSampleMediaPeriod");

    /* renamed from: k  reason: collision with root package name */
    final Format f7141k;

    /* renamed from: l  reason: collision with root package name */
    final boolean f7142l;

    /* renamed from: m  reason: collision with root package name */
    boolean f7143m;

    /* renamed from: n  reason: collision with root package name */
    byte[] f7144n;

    /* renamed from: o  reason: collision with root package name */
    int f7145o;

    private final class SampleStreamImpl implements SampleStream {

        /* renamed from: b  reason: collision with root package name */
        private int f7146b;

        /* renamed from: c  reason: collision with root package name */
        private boolean f7147c;

        private SampleStreamImpl() {
        }

        private void b() {
            if (!this.f7147c) {
                SingleSampleMediaPeriod.this.f7136f.h(MimeTypes.k(SingleSampleMediaPeriod.this.f7141k.f4015n), SingleSampleMediaPeriod.this.f7141k, 0, (Object) null, 0);
                this.f7147c = true;
            }
        }

        public void a() throws IOException {
            SingleSampleMediaPeriod singleSampleMediaPeriod = SingleSampleMediaPeriod.this;
            if (!singleSampleMediaPeriod.f7142l) {
                singleSampleMediaPeriod.f7140j.a();
            }
        }

        public void c() {
            if (this.f7146b == 2) {
                this.f7146b = 1;
            }
        }

        public int d(long j2) {
            b();
            if (j2 <= 0 || this.f7146b == 2) {
                return 0;
            }
            this.f7146b = 2;
            return 1;
        }

        public boolean isReady() {
            return SingleSampleMediaPeriod.this.f7143m;
        }

        public int m(FormatHolder formatHolder, DecoderInputBuffer decoderInputBuffer, int i2) {
            b();
            SingleSampleMediaPeriod singleSampleMediaPeriod = SingleSampleMediaPeriod.this;
            boolean z2 = singleSampleMediaPeriod.f7143m;
            if (z2 && singleSampleMediaPeriod.f7144n == null) {
                this.f7146b = 2;
            }
            int i3 = this.f7146b;
            if (i3 == 2) {
                decoderInputBuffer.addFlag(4);
                return -4;
            } else if ((i2 & 2) != 0 || i3 == 0) {
                formatHolder.f5385b = singleSampleMediaPeriod.f7141k;
                this.f7146b = 1;
                return -5;
            } else if (!z2) {
                return -3;
            } else {
                Assertions.f(singleSampleMediaPeriod.f7144n);
                decoderInputBuffer.addFlag(1);
                decoderInputBuffer.f5069f = 0;
                if ((i2 & 4) == 0) {
                    decoderInputBuffer.f(SingleSampleMediaPeriod.this.f7145o);
                    ByteBuffer byteBuffer = decoderInputBuffer.f5067d;
                    SingleSampleMediaPeriod singleSampleMediaPeriod2 = SingleSampleMediaPeriod.this;
                    byteBuffer.put(singleSampleMediaPeriod2.f7144n, 0, singleSampleMediaPeriod2.f7145o);
                }
                if ((i2 & 1) == 0) {
                    this.f7146b = 2;
                }
                return -4;
            }
        }
    }

    static final class SourceLoadable implements Loader.Loadable {

        /* renamed from: a  reason: collision with root package name */
        public final long f7149a = LoadEventInfo.a();

        /* renamed from: b  reason: collision with root package name */
        public final DataSpec f7150b;
        /* access modifiers changed from: private */

        /* renamed from: c  reason: collision with root package name */
        public final StatsDataSource f7151c;
        /* access modifiers changed from: private */

        /* renamed from: d  reason: collision with root package name */
        public byte[] f7152d;

        public SourceLoadable(DataSpec dataSpec, DataSource dataSource) {
            this.f7150b = dataSpec;
            this.f7151c = new StatsDataSource(dataSource);
        }

        public void a() throws IOException {
            this.f7151c.r();
            try {
                this.f7151c.i(this.f7150b);
                int i2 = 0;
                while (i2 != -1) {
                    int o2 = (int) this.f7151c.o();
                    byte[] bArr = this.f7152d;
                    if (bArr == null) {
                        this.f7152d = new byte[1024];
                    } else if (o2 == bArr.length) {
                        this.f7152d = Arrays.copyOf(bArr, bArr.length * 2);
                    }
                    StatsDataSource statsDataSource = this.f7151c;
                    byte[] bArr2 = this.f7152d;
                    i2 = statsDataSource.read(bArr2, o2, bArr2.length - o2);
                }
            } finally {
                DataSourceUtil.a(this.f7151c);
            }
        }

        public void b() {
        }
    }

    public SingleSampleMediaPeriod(DataSpec dataSpec, DataSource.Factory factory, TransferListener transferListener, Format format, long j2, LoadErrorHandlingPolicy loadErrorHandlingPolicy, MediaSourceEventListener.EventDispatcher eventDispatcher, boolean z2) {
        this.f7132b = dataSpec;
        this.f7133c = factory;
        this.f7134d = transferListener;
        this.f7141k = format;
        this.f7139i = j2;
        this.f7135e = loadErrorHandlingPolicy;
        this.f7136f = eventDispatcher;
        this.f7142l = z2;
        this.f7137g = new TrackGroupArray(new TrackGroup(format));
    }

    public long b() {
        return (this.f7143m || this.f7140j.j()) ? Long.MIN_VALUE : 0;
    }

    public boolean c() {
        return this.f7140j.j();
    }

    /* renamed from: d */
    public void u(SourceLoadable sourceLoadable, long j2, long j3, boolean z2) {
        SourceLoadable sourceLoadable2 = sourceLoadable;
        StatsDataSource c2 = sourceLoadable.f7151c;
        LoadEventInfo loadEventInfo = new LoadEventInfo(sourceLoadable2.f7149a, sourceLoadable2.f7150b, c2.p(), c2.q(), j2, j3, c2.o());
        this.f7135e.b(sourceLoadable2.f7149a);
        this.f7136f.q(loadEventInfo, 1, -1, (Format) null, 0, (Object) null, 0, this.f7139i);
    }

    public long e() {
        return this.f7143m ? Long.MIN_VALUE : 0;
    }

    public void f(long j2) {
    }

    public boolean g(LoadingInfo loadingInfo) {
        if (this.f7143m || this.f7140j.j() || this.f7140j.i()) {
            return false;
        }
        DataSource a2 = this.f7133c.a();
        TransferListener transferListener = this.f7134d;
        if (transferListener != null) {
            a2.n(transferListener);
        }
        SourceLoadable sourceLoadable = new SourceLoadable(this.f7132b, a2);
        this.f7136f.z(new LoadEventInfo(sourceLoadable.f7149a, this.f7132b, this.f7140j.n(sourceLoadable, this, this.f7135e.a(1))), 1, -1, this.f7141k, 0, (Object) null, 0, this.f7139i);
        return true;
    }

    public long h(long j2, SeekParameters seekParameters) {
        return j2;
    }

    public long i(long j2) {
        for (int i2 = 0; i2 < this.f7138h.size(); i2++) {
            this.f7138h.get(i2).c();
        }
        return j2;
    }

    public long j() {
        return -9223372036854775807L;
    }

    /* renamed from: k */
    public void t(SourceLoadable sourceLoadable, long j2, long j3) {
        SourceLoadable sourceLoadable2 = sourceLoadable;
        this.f7145o = (int) sourceLoadable.f7151c.o();
        this.f7144n = (byte[]) Assertions.f(sourceLoadable.f7152d);
        this.f7143m = true;
        StatsDataSource c2 = sourceLoadable.f7151c;
        LoadEventInfo loadEventInfo = new LoadEventInfo(sourceLoadable2.f7149a, sourceLoadable2.f7150b, c2.p(), c2.q(), j2, j3, (long) this.f7145o);
        this.f7135e.b(sourceLoadable2.f7149a);
        this.f7136f.t(loadEventInfo, 1, -1, this.f7141k, 0, (Object) null, 0, this.f7139i);
    }

    public void l() {
    }

    /* renamed from: m */
    public Loader.LoadErrorAction p(SourceLoadable sourceLoadable, long j2, long j3, IOException iOException, int i2) {
        boolean z2;
        Loader.LoadErrorAction loadErrorAction;
        SourceLoadable sourceLoadable2 = sourceLoadable;
        IOException iOException2 = iOException;
        int i3 = i2;
        StatsDataSource c2 = sourceLoadable.f7151c;
        LoadEventInfo loadEventInfo = new LoadEventInfo(sourceLoadable2.f7149a, sourceLoadable2.f7150b, c2.p(), c2.q(), j2, j3, c2.o());
        long c3 = this.f7135e.c(new LoadErrorHandlingPolicy.LoadErrorInfo(loadEventInfo, new MediaLoadData(1, -1, this.f7141k, 0, (Object) null, 0, Util.t1(this.f7139i)), iOException2, i3));
        int i4 = (c3 > -9223372036854775807L ? 1 : (c3 == -9223372036854775807L ? 0 : -1));
        if (i4 == 0 || i3 >= this.f7135e.a(1)) {
            z2 = true;
        } else {
            z2 = false;
        }
        if (this.f7142l && z2) {
            Log.i("SingleSampleMediaPeriod", "Loading failed, treating as end-of-stream.", iOException2);
            this.f7143m = true;
            loadErrorAction = Loader.f7534f;
        } else if (i4 != 0) {
            loadErrorAction = Loader.h(false, c3);
        } else {
            loadErrorAction = Loader.f7535g;
        }
        Loader.LoadErrorAction loadErrorAction2 = loadErrorAction;
        boolean z3 = !loadErrorAction2.c();
        this.f7136f.v(loadEventInfo, 1, -1, this.f7141k, 0, (Object) null, 0, this.f7139i, iOException, z3);
        if (z3) {
            this.f7135e.b(sourceLoadable2.f7149a);
        }
        return loadErrorAction2;
    }

    public TrackGroupArray n() {
        return this.f7137g;
    }

    public void o(long j2, boolean z2) {
    }

    public long q(ExoTrackSelection[] exoTrackSelectionArr, boolean[] zArr, SampleStream[] sampleStreamArr, boolean[] zArr2, long j2) {
        for (int i2 = 0; i2 < exoTrackSelectionArr.length; i2++) {
            SampleStream sampleStream = sampleStreamArr[i2];
            if (sampleStream != null && (exoTrackSelectionArr[i2] == null || !zArr[i2])) {
                this.f7138h.remove(sampleStream);
                sampleStreamArr[i2] = null;
            }
            if (sampleStreamArr[i2] == null && exoTrackSelectionArr[i2] != null) {
                SampleStreamImpl sampleStreamImpl = new SampleStreamImpl();
                this.f7138h.add(sampleStreamImpl);
                sampleStreamArr[i2] = sampleStreamImpl;
                zArr2[i2] = true;
            }
        }
        return j2;
    }

    public void r() {
        this.f7140j.l();
    }

    public void s(MediaPeriod.Callback callback, long j2) {
        callback.m(this);
    }
}
