package com.google.android.exoplayer2.source;

import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.FormatHolder;
import com.google.android.exoplayer2.SeekParameters;
import com.google.android.exoplayer2.decoder.DecoderInputBuffer;
import com.google.android.exoplayer2.source.MediaPeriod;
import com.google.android.exoplayer2.source.MediaSourceEventListener;
import com.google.android.exoplayer2.trackselection.ExoTrackSelection;
import com.google.android.exoplayer2.upstream.DataSource;
import com.google.android.exoplayer2.upstream.DataSourceUtil;
import com.google.android.exoplayer2.upstream.DataSpec;
import com.google.android.exoplayer2.upstream.LoadErrorHandlingPolicy;
import com.google.android.exoplayer2.upstream.Loader;
import com.google.android.exoplayer2.upstream.StatsDataSource;
import com.google.android.exoplayer2.upstream.TransferListener;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.Log;
import com.google.android.exoplayer2.util.MimeTypes;
import com.google.android.exoplayer2.util.Util;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Arrays;

final class SingleSampleMediaPeriod implements MediaPeriod, Loader.Callback<SourceLoadable> {

    /* renamed from: b  reason: collision with root package name */
    private final DataSpec f25961b;

    /* renamed from: c  reason: collision with root package name */
    private final DataSource.Factory f25962c;

    /* renamed from: d  reason: collision with root package name */
    private final TransferListener f25963d;

    /* renamed from: e  reason: collision with root package name */
    private final LoadErrorHandlingPolicy f25964e;
    /* access modifiers changed from: private */

    /* renamed from: f  reason: collision with root package name */
    public final MediaSourceEventListener.EventDispatcher f25965f;

    /* renamed from: g  reason: collision with root package name */
    private final TrackGroupArray f25966g;

    /* renamed from: h  reason: collision with root package name */
    private final ArrayList<SampleStreamImpl> f25967h = new ArrayList<>();

    /* renamed from: i  reason: collision with root package name */
    private final long f25968i;

    /* renamed from: j  reason: collision with root package name */
    final Loader f25969j = new Loader("SingleSampleMediaPeriod");

    /* renamed from: k  reason: collision with root package name */
    final Format f25970k;

    /* renamed from: l  reason: collision with root package name */
    final boolean f25971l;

    /* renamed from: m  reason: collision with root package name */
    boolean f25972m;

    /* renamed from: n  reason: collision with root package name */
    byte[] f25973n;

    /* renamed from: o  reason: collision with root package name */
    int f25974o;

    private final class SampleStreamImpl implements SampleStream {

        /* renamed from: b  reason: collision with root package name */
        private int f25975b;

        /* renamed from: c  reason: collision with root package name */
        private boolean f25976c;

        private SampleStreamImpl() {
        }

        private void b() {
            if (!this.f25976c) {
                SingleSampleMediaPeriod.this.f25965f.i(MimeTypes.k(SingleSampleMediaPeriod.this.f25970k.f23071m), SingleSampleMediaPeriod.this.f25970k, 0, (Object) null, 0);
                this.f25976c = true;
            }
        }

        public void a() throws IOException {
            SingleSampleMediaPeriod singleSampleMediaPeriod = SingleSampleMediaPeriod.this;
            if (!singleSampleMediaPeriod.f25971l) {
                singleSampleMediaPeriod.f25969j.a();
            }
        }

        public void c() {
            if (this.f25975b == 2) {
                this.f25975b = 1;
            }
        }

        public int d(long j2) {
            b();
            if (j2 <= 0 || this.f25975b == 2) {
                return 0;
            }
            this.f25975b = 2;
            return 1;
        }

        public boolean isReady() {
            return SingleSampleMediaPeriod.this.f25972m;
        }

        public int m(FormatHolder formatHolder, DecoderInputBuffer decoderInputBuffer, int i2) {
            b();
            SingleSampleMediaPeriod singleSampleMediaPeriod = SingleSampleMediaPeriod.this;
            boolean z2 = singleSampleMediaPeriod.f25972m;
            if (z2 && singleSampleMediaPeriod.f25973n == null) {
                this.f25975b = 2;
            }
            int i3 = this.f25975b;
            if (i3 == 2) {
                decoderInputBuffer.e(4);
                return -4;
            } else if ((i2 & 2) != 0 || i3 == 0) {
                formatHolder.f23112b = singleSampleMediaPeriod.f25970k;
                this.f25975b = 1;
                return -5;
            } else if (!z2) {
                return -3;
            } else {
                Assertions.e(singleSampleMediaPeriod.f25973n);
                decoderInputBuffer.e(1);
                decoderInputBuffer.f23963f = 0;
                if ((i2 & 4) == 0) {
                    decoderInputBuffer.q(SingleSampleMediaPeriod.this.f25974o);
                    ByteBuffer byteBuffer = decoderInputBuffer.f23961d;
                    SingleSampleMediaPeriod singleSampleMediaPeriod2 = SingleSampleMediaPeriod.this;
                    byteBuffer.put(singleSampleMediaPeriod2.f25973n, 0, singleSampleMediaPeriod2.f25974o);
                }
                if ((i2 & 1) == 0) {
                    this.f25975b = 2;
                }
                return -4;
            }
        }
    }

    static final class SourceLoadable implements Loader.Loadable {

        /* renamed from: a  reason: collision with root package name */
        public final long f25978a = LoadEventInfo.a();

        /* renamed from: b  reason: collision with root package name */
        public final DataSpec f25979b;
        /* access modifiers changed from: private */

        /* renamed from: c  reason: collision with root package name */
        public final StatsDataSource f25980c;
        /* access modifiers changed from: private */

        /* renamed from: d  reason: collision with root package name */
        public byte[] f25981d;

        public SourceLoadable(DataSpec dataSpec, DataSource dataSource) {
            this.f25979b = dataSpec;
            this.f25980c = new StatsDataSource(dataSource);
        }

        public void a() throws IOException {
            this.f25980c.u();
            try {
                this.f25980c.i(this.f25979b);
                int i2 = 0;
                while (i2 != -1) {
                    int q2 = (int) this.f25980c.q();
                    byte[] bArr = this.f25981d;
                    if (bArr == null) {
                        this.f25981d = new byte[1024];
                    } else if (q2 == bArr.length) {
                        this.f25981d = Arrays.copyOf(bArr, bArr.length * 2);
                    }
                    StatsDataSource statsDataSource = this.f25980c;
                    byte[] bArr2 = this.f25981d;
                    i2 = statsDataSource.read(bArr2, q2, bArr2.length - q2);
                }
            } finally {
                DataSourceUtil.a(this.f25980c);
            }
        }

        public void b() {
        }
    }

    public SingleSampleMediaPeriod(DataSpec dataSpec, DataSource.Factory factory, TransferListener transferListener, Format format, long j2, LoadErrorHandlingPolicy loadErrorHandlingPolicy, MediaSourceEventListener.EventDispatcher eventDispatcher, boolean z2) {
        this.f25961b = dataSpec;
        this.f25962c = factory;
        this.f25963d = transferListener;
        this.f25970k = format;
        this.f25968i = j2;
        this.f25964e = loadErrorHandlingPolicy;
        this.f25965f = eventDispatcher;
        this.f25971l = z2;
        this.f25966g = new TrackGroupArray(new TrackGroup(format));
    }

    public long b() {
        return (this.f25972m || this.f25969j.j()) ? Long.MIN_VALUE : 0;
    }

    public boolean c() {
        return this.f25969j.j();
    }

    /* renamed from: d */
    public void p(SourceLoadable sourceLoadable, long j2, long j3, boolean z2) {
        SourceLoadable sourceLoadable2 = sourceLoadable;
        StatsDataSource c2 = sourceLoadable.f25980c;
        LoadEventInfo loadEventInfo = new LoadEventInfo(sourceLoadable2.f25978a, sourceLoadable2.f25979b, c2.s(), c2.t(), j2, j3, c2.q());
        this.f25964e.b(sourceLoadable2.f25978a);
        this.f25965f.r(loadEventInfo, 1, -1, (Format) null, 0, (Object) null, 0, this.f25968i);
    }

    public long e() {
        return this.f25972m ? Long.MIN_VALUE : 0;
    }

    public void f(long j2) {
    }

    public long g(long j2, SeekParameters seekParameters) {
        return j2;
    }

    public boolean h(long j2) {
        if (this.f25972m || this.f25969j.j() || this.f25969j.i()) {
            return false;
        }
        DataSource a2 = this.f25962c.a();
        TransferListener transferListener = this.f25963d;
        if (transferListener != null) {
            a2.p(transferListener);
        }
        SourceLoadable sourceLoadable = new SourceLoadable(this.f25961b, a2);
        this.f25965f.A(new LoadEventInfo(sourceLoadable.f25978a, this.f25961b, this.f25969j.n(sourceLoadable, this, this.f25964e.a(1))), 1, -1, this.f25970k, 0, (Object) null, 0, this.f25968i);
        return true;
    }

    public long i(long j2) {
        for (int i2 = 0; i2 < this.f25967h.size(); i2++) {
            this.f25967h.get(i2).c();
        }
        return j2;
    }

    public long j() {
        return -9223372036854775807L;
    }

    /* renamed from: k */
    public void q(SourceLoadable sourceLoadable, long j2, long j3) {
        SourceLoadable sourceLoadable2 = sourceLoadable;
        this.f25974o = (int) sourceLoadable.f25980c.q();
        this.f25973n = (byte[]) Assertions.e(sourceLoadable.f25981d);
        this.f25972m = true;
        StatsDataSource c2 = sourceLoadable.f25980c;
        LoadEventInfo loadEventInfo = new LoadEventInfo(sourceLoadable2.f25978a, sourceLoadable2.f25979b, c2.s(), c2.t(), j2, j3, (long) this.f25974o);
        this.f25964e.b(sourceLoadable2.f25978a);
        this.f25965f.u(loadEventInfo, 1, -1, this.f25970k, 0, (Object) null, 0, this.f25968i);
    }

    public void l() {
    }

    /* renamed from: m */
    public Loader.LoadErrorAction t(SourceLoadable sourceLoadable, long j2, long j3, IOException iOException, int i2) {
        boolean z2;
        Loader.LoadErrorAction loadErrorAction;
        SourceLoadable sourceLoadable2 = sourceLoadable;
        IOException iOException2 = iOException;
        int i3 = i2;
        StatsDataSource c2 = sourceLoadable.f25980c;
        LoadEventInfo loadEventInfo = new LoadEventInfo(sourceLoadable2.f25978a, sourceLoadable2.f25979b, c2.s(), c2.t(), j2, j3, c2.q());
        long c3 = this.f25964e.c(new LoadErrorHandlingPolicy.LoadErrorInfo(loadEventInfo, new MediaLoadData(1, -1, this.f25970k, 0, (Object) null, 0, Util.i1(this.f25968i)), iOException2, i3));
        int i4 = (c3 > -9223372036854775807L ? 1 : (c3 == -9223372036854775807L ? 0 : -1));
        if (i4 == 0 || i3 >= this.f25964e.a(1)) {
            z2 = true;
        } else {
            z2 = false;
        }
        if (this.f25971l && z2) {
            Log.j("SingleSampleMediaPeriod", "Loading failed, treating as end-of-stream.", iOException2);
            this.f25972m = true;
            loadErrorAction = Loader.f28464f;
        } else if (i4 != 0) {
            loadErrorAction = Loader.h(false, c3);
        } else {
            loadErrorAction = Loader.f28465g;
        }
        Loader.LoadErrorAction loadErrorAction2 = loadErrorAction;
        boolean z3 = !loadErrorAction2.c();
        this.f25965f.w(loadEventInfo, 1, -1, this.f25970k, 0, (Object) null, 0, this.f25968i, iOException, z3);
        if (z3) {
            this.f25964e.b(sourceLoadable2.f25978a);
        }
        return loadErrorAction2;
    }

    public TrackGroupArray n() {
        return this.f25966g;
    }

    public void o(long j2, boolean z2) {
    }

    public void r(MediaPeriod.Callback callback, long j2) {
        callback.p(this);
    }

    public long s(ExoTrackSelection[] exoTrackSelectionArr, boolean[] zArr, SampleStream[] sampleStreamArr, boolean[] zArr2, long j2) {
        for (int i2 = 0; i2 < exoTrackSelectionArr.length; i2++) {
            SampleStream sampleStream = sampleStreamArr[i2];
            if (sampleStream != null && (exoTrackSelectionArr[i2] == null || !zArr[i2])) {
                this.f25967h.remove(sampleStream);
                sampleStreamArr[i2] = null;
            }
            if (sampleStreamArr[i2] == null && exoTrackSelectionArr[i2] != null) {
                SampleStreamImpl sampleStreamImpl = new SampleStreamImpl();
                this.f25967h.add(sampleStreamImpl);
                sampleStreamArr[i2] = sampleStreamImpl;
                zArr2[i2] = true;
            }
        }
        return j2;
    }

    public void u() {
        this.f25969j.l();
    }
}
