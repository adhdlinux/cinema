package com.google.android.exoplayer2.source.rtsp;

import android.net.Uri;
import android.os.Handler;
import com.facebook.common.time.Clock;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.FormatHolder;
import com.google.android.exoplayer2.SeekParameters;
import com.google.android.exoplayer2.decoder.DecoderInputBuffer;
import com.google.android.exoplayer2.extractor.ExtractorOutput;
import com.google.android.exoplayer2.extractor.SeekMap;
import com.google.android.exoplayer2.extractor.TrackOutput;
import com.google.android.exoplayer2.source.MediaPeriod;
import com.google.android.exoplayer2.source.SampleQueue;
import com.google.android.exoplayer2.source.SampleStream;
import com.google.android.exoplayer2.source.TrackGroup;
import com.google.android.exoplayer2.source.TrackGroupArray;
import com.google.android.exoplayer2.source.rtsp.RtpDataChannel;
import com.google.android.exoplayer2.source.rtsp.RtspClient;
import com.google.android.exoplayer2.source.rtsp.RtspMediaSource;
import com.google.android.exoplayer2.source.rtsp.RtspMessageChannel;
import com.google.android.exoplayer2.trackselection.ExoTrackSelection;
import com.google.android.exoplayer2.upstream.Allocator;
import com.google.android.exoplayer2.upstream.Loader;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.Util;
import com.google.common.collect.ImmutableList;
import java.io.IOException;
import java.net.BindException;
import java.util.ArrayList;
import java.util.List;
import javax.net.SocketFactory;

final class RtspMediaPeriod implements MediaPeriod {
    /* access modifiers changed from: private */

    /* renamed from: b  reason: collision with root package name */
    public final Allocator f26827b;
    /* access modifiers changed from: private */

    /* renamed from: c  reason: collision with root package name */
    public final Handler f26828c = Util.w();
    /* access modifiers changed from: private */

    /* renamed from: d  reason: collision with root package name */
    public final InternalListener f26829d;
    /* access modifiers changed from: private */

    /* renamed from: e  reason: collision with root package name */
    public final RtspClient f26830e;
    /* access modifiers changed from: private */

    /* renamed from: f  reason: collision with root package name */
    public final List<RtspLoaderWrapper> f26831f;
    /* access modifiers changed from: private */

    /* renamed from: g  reason: collision with root package name */
    public final List<RtpLoadInfo> f26832g;
    /* access modifiers changed from: private */

    /* renamed from: h  reason: collision with root package name */
    public final Listener f26833h;
    /* access modifiers changed from: private */

    /* renamed from: i  reason: collision with root package name */
    public final RtpDataChannel.Factory f26834i;

    /* renamed from: j  reason: collision with root package name */
    private MediaPeriod.Callback f26835j;

    /* renamed from: k  reason: collision with root package name */
    private ImmutableList<TrackGroup> f26836k;
    /* access modifiers changed from: private */

    /* renamed from: l  reason: collision with root package name */
    public IOException f26837l;
    /* access modifiers changed from: private */

    /* renamed from: m  reason: collision with root package name */
    public RtspMediaSource.RtspPlaybackException f26838m;
    /* access modifiers changed from: private */

    /* renamed from: n  reason: collision with root package name */
    public long f26839n;
    /* access modifiers changed from: private */

    /* renamed from: o  reason: collision with root package name */
    public long f26840o;
    /* access modifiers changed from: private */

    /* renamed from: p  reason: collision with root package name */
    public long f26841p;

    /* renamed from: q  reason: collision with root package name */
    private boolean f26842q;
    /* access modifiers changed from: private */

    /* renamed from: r  reason: collision with root package name */
    public boolean f26843r;

    /* renamed from: s  reason: collision with root package name */
    private boolean f26844s;
    /* access modifiers changed from: private */

    /* renamed from: t  reason: collision with root package name */
    public boolean f26845t;

    /* renamed from: u  reason: collision with root package name */
    private boolean f26846u;

    /* renamed from: v  reason: collision with root package name */
    private int f26847v;
    /* access modifiers changed from: private */

    /* renamed from: w  reason: collision with root package name */
    public boolean f26848w;

    private final class InternalListener implements ExtractorOutput, Loader.Callback<RtpDataLoadable>, SampleQueue.UpstreamFormatChangedListener, RtspClient.SessionInfoListener, RtspClient.PlaybackEventListener {
        private InternalListener() {
        }

        public void a(Format format) {
            RtspMediaPeriod.this.f26828c.post(new d(RtspMediaPeriod.this));
        }

        public void b(String str, Throwable th) {
            IOException unused = RtspMediaPeriod.this.f26837l = th == null ? new IOException(str) : new IOException(str, th);
        }

        public void c(RtspMediaSource.RtspPlaybackException rtspPlaybackException) {
            if (!(rtspPlaybackException instanceof RtspMediaSource.RtspUdpUnsupportedTransportException) || RtspMediaPeriod.this.f26848w) {
                RtspMediaSource.RtspPlaybackException unused = RtspMediaPeriod.this.f26838m = rtspPlaybackException;
            } else {
                RtspMediaPeriod.this.X();
            }
        }

        public TrackOutput d(int i2, int i3) {
            return ((RtspLoaderWrapper) Assertions.e((RtspLoaderWrapper) RtspMediaPeriod.this.f26831f.get(i2))).f26856c;
        }

        public void e() {
            long j2;
            if (RtspMediaPeriod.this.f26840o != -9223372036854775807L) {
                j2 = Util.i1(RtspMediaPeriod.this.f26840o);
            } else if (RtspMediaPeriod.this.f26841p != -9223372036854775807L) {
                j2 = Util.i1(RtspMediaPeriod.this.f26841p);
            } else {
                j2 = 0;
            }
            RtspMediaPeriod.this.f26830e.N0(j2);
        }

        public void f(long j2, ImmutableList<RtspTrackTiming> immutableList) {
            ArrayList arrayList = new ArrayList(immutableList.size());
            for (int i2 = 0; i2 < immutableList.size(); i2++) {
                arrayList.add((String) Assertions.e(immutableList.get(i2).f26932c.getPath()));
            }
            for (int i3 = 0; i3 < RtspMediaPeriod.this.f26832g.size(); i3++) {
                if (!arrayList.contains(((RtpLoadInfo) RtspMediaPeriod.this.f26832g.get(i3)).c().getPath())) {
                    RtspMediaPeriod.this.f26833h.a();
                    if (RtspMediaPeriod.this.S()) {
                        boolean unused = RtspMediaPeriod.this.f26843r = true;
                        long unused2 = RtspMediaPeriod.this.f26840o = -9223372036854775807L;
                        long unused3 = RtspMediaPeriod.this.f26839n = -9223372036854775807L;
                        long unused4 = RtspMediaPeriod.this.f26841p = -9223372036854775807L;
                    }
                }
            }
            for (int i4 = 0; i4 < immutableList.size(); i4++) {
                RtspTrackTiming rtspTrackTiming = immutableList.get(i4);
                RtpDataLoadable B = RtspMediaPeriod.this.Q(rtspTrackTiming.f26932c);
                if (B != null) {
                    B.h(rtspTrackTiming.f26930a);
                    B.g(rtspTrackTiming.f26931b);
                    if (RtspMediaPeriod.this.S() && RtspMediaPeriod.this.f26840o == RtspMediaPeriod.this.f26839n) {
                        B.f(j2, rtspTrackTiming.f26930a);
                    }
                }
            }
            if (RtspMediaPeriod.this.S()) {
                if (RtspMediaPeriod.this.f26840o == RtspMediaPeriod.this.f26839n) {
                    long unused5 = RtspMediaPeriod.this.f26840o = -9223372036854775807L;
                    long unused6 = RtspMediaPeriod.this.f26839n = -9223372036854775807L;
                    return;
                }
                long unused7 = RtspMediaPeriod.this.f26840o = -9223372036854775807L;
                RtspMediaPeriod rtspMediaPeriod = RtspMediaPeriod.this;
                rtspMediaPeriod.i(rtspMediaPeriod.f26839n);
            } else if (RtspMediaPeriod.this.f26841p != -9223372036854775807L && RtspMediaPeriod.this.f26848w) {
                RtspMediaPeriod rtspMediaPeriod2 = RtspMediaPeriod.this;
                rtspMediaPeriod2.i(rtspMediaPeriod2.f26841p);
                long unused8 = RtspMediaPeriod.this.f26841p = -9223372036854775807L;
            }
        }

        public void g(RtspSessionTiming rtspSessionTiming, ImmutableList<RtspMediaTrack> immutableList) {
            for (int i2 = 0; i2 < immutableList.size(); i2++) {
                RtspMediaPeriod rtspMediaPeriod = RtspMediaPeriod.this;
                RtspLoaderWrapper rtspLoaderWrapper = new RtspLoaderWrapper(immutableList.get(i2), i2, rtspMediaPeriod.f26834i);
                RtspMediaPeriod.this.f26831f.add(rtspLoaderWrapper);
                rtspLoaderWrapper.j();
            }
            RtspMediaPeriod.this.f26833h.b(rtspSessionTiming);
        }

        /* renamed from: l */
        public void p(RtpDataLoadable rtpDataLoadable, long j2, long j3, boolean z2) {
        }

        public void m() {
            RtspMediaPeriod.this.f26828c.post(new e(RtspMediaPeriod.this));
        }

        /* renamed from: n */
        public void q(RtpDataLoadable rtpDataLoadable, long j2, long j3) {
            if (RtspMediaPeriod.this.e() != 0) {
                for (int i2 = 0; i2 < RtspMediaPeriod.this.f26831f.size(); i2++) {
                    RtspLoaderWrapper rtspLoaderWrapper = (RtspLoaderWrapper) RtspMediaPeriod.this.f26831f.get(i2);
                    if (rtspLoaderWrapper.f26854a.f26851b == rtpDataLoadable) {
                        rtspLoaderWrapper.c();
                        return;
                    }
                }
            } else if (!RtspMediaPeriod.this.f26848w) {
                RtspMediaPeriod.this.X();
            }
        }

        /* renamed from: o */
        public Loader.LoadErrorAction t(RtpDataLoadable rtpDataLoadable, long j2, long j3, IOException iOException, int i2) {
            if (!RtspMediaPeriod.this.f26845t) {
                IOException unused = RtspMediaPeriod.this.f26837l = iOException;
            } else if (!(iOException.getCause() instanceof BindException)) {
                RtspMediaSource.RtspPlaybackException unused2 = RtspMediaPeriod.this.f26838m = new RtspMediaSource.RtspPlaybackException(rtpDataLoadable.f26737b.f26879b.toString(), iOException);
            } else if (RtspMediaPeriod.a(RtspMediaPeriod.this) < 3) {
                return Loader.f28462d;
            }
            return Loader.f28464f;
        }

        public void u(SeekMap seekMap) {
        }
    }

    interface Listener {
        void a();

        void b(RtspSessionTiming rtspSessionTiming);
    }

    final class RtpLoadInfo {

        /* renamed from: a  reason: collision with root package name */
        public final RtspMediaTrack f26850a;
        /* access modifiers changed from: private */

        /* renamed from: b  reason: collision with root package name */
        public final RtpDataLoadable f26851b;

        /* renamed from: c  reason: collision with root package name */
        private String f26852c;

        public RtpLoadInfo(RtspMediaTrack rtspMediaTrack, int i2, RtpDataChannel.Factory factory) {
            this.f26850a = rtspMediaTrack;
            this.f26851b = new RtpDataLoadable(i2, rtspMediaTrack, new f(this), RtspMediaPeriod.this.f26829d, factory);
        }

        /* access modifiers changed from: private */
        public /* synthetic */ void f(String str, RtpDataChannel rtpDataChannel) {
            this.f26852c = str;
            RtspMessageChannel.InterleavedBinaryDataListener r2 = rtpDataChannel.r();
            if (r2 != null) {
                RtspMediaPeriod.this.f26830e.H0(rtpDataChannel.o(), r2);
                boolean unused = RtspMediaPeriod.this.f26848w = true;
            }
            RtspMediaPeriod.this.U();
        }

        public Uri c() {
            return this.f26851b.f26737b.f26879b;
        }

        public String d() {
            Assertions.i(this.f26852c);
            return this.f26852c;
        }

        public boolean e() {
            return this.f26852c != null;
        }
    }

    private final class RtspLoaderWrapper {

        /* renamed from: a  reason: collision with root package name */
        public final RtpLoadInfo f26854a;

        /* renamed from: b  reason: collision with root package name */
        private final Loader f26855b;
        /* access modifiers changed from: private */

        /* renamed from: c  reason: collision with root package name */
        public final SampleQueue f26856c;
        /* access modifiers changed from: private */

        /* renamed from: d  reason: collision with root package name */
        public boolean f26857d;

        /* renamed from: e  reason: collision with root package name */
        private boolean f26858e;

        public RtspLoaderWrapper(RtspMediaTrack rtspMediaTrack, int i2, RtpDataChannel.Factory factory) {
            this.f26854a = new RtpLoadInfo(rtspMediaTrack, i2, factory);
            this.f26855b = new Loader("ExoPlayer:RtspMediaPeriod:RtspLoaderWrapper " + i2);
            SampleQueue l2 = SampleQueue.l(RtspMediaPeriod.this.f26827b);
            this.f26856c = l2;
            l2.d0(RtspMediaPeriod.this.f26829d);
        }

        public void c() {
            if (!this.f26857d) {
                this.f26854a.f26851b.b();
                this.f26857d = true;
                RtspMediaPeriod.this.b0();
            }
        }

        public long d() {
            return this.f26856c.z();
        }

        public boolean e() {
            return this.f26856c.K(this.f26857d);
        }

        public int f(FormatHolder formatHolder, DecoderInputBuffer decoderInputBuffer, int i2) {
            return this.f26856c.S(formatHolder, decoderInputBuffer, i2, this.f26857d);
        }

        public void g() {
            if (!this.f26858e) {
                this.f26855b.l();
                this.f26856c.T();
                this.f26858e = true;
            }
        }

        public void h(long j2) {
            if (!this.f26857d) {
                this.f26854a.f26851b.e();
                this.f26856c.V();
                this.f26856c.b0(j2);
            }
        }

        public int i(long j2) {
            int E = this.f26856c.E(j2, this.f26857d);
            this.f26856c.e0(E);
            return E;
        }

        public void j() {
            this.f26855b.n(this.f26854a.f26851b, RtspMediaPeriod.this.f26829d, 0);
        }
    }

    private final class SampleStreamImpl implements SampleStream {

        /* renamed from: b  reason: collision with root package name */
        private final int f26860b;

        public SampleStreamImpl(int i2) {
            this.f26860b = i2;
        }

        public void a() throws RtspMediaSource.RtspPlaybackException {
            if (RtspMediaPeriod.this.f26838m != null) {
                throw RtspMediaPeriod.this.f26838m;
            }
        }

        public int d(long j2) {
            return RtspMediaPeriod.this.Z(this.f26860b, j2);
        }

        public boolean isReady() {
            return RtspMediaPeriod.this.R(this.f26860b);
        }

        public int m(FormatHolder formatHolder, DecoderInputBuffer decoderInputBuffer, int i2) {
            return RtspMediaPeriod.this.V(this.f26860b, formatHolder, decoderInputBuffer, i2);
        }
    }

    public RtspMediaPeriod(Allocator allocator, RtpDataChannel.Factory factory, Uri uri, Listener listener, String str, SocketFactory socketFactory, boolean z2) {
        this.f26827b = allocator;
        this.f26834i = factory;
        this.f26833h = listener;
        InternalListener internalListener = new InternalListener();
        this.f26829d = internalListener;
        this.f26830e = new RtspClient(internalListener, internalListener, str, uri, socketFactory, z2);
        this.f26831f = new ArrayList();
        this.f26832g = new ArrayList();
        this.f26840o = -9223372036854775807L;
        this.f26839n = -9223372036854775807L;
        this.f26841p = -9223372036854775807L;
    }

    private static ImmutableList<TrackGroup> P(ImmutableList<RtspLoaderWrapper> immutableList) {
        ImmutableList.Builder builder = new ImmutableList.Builder();
        for (int i2 = 0; i2 < immutableList.size(); i2++) {
            SampleQueue b2 = immutableList.get(i2).f26856c;
            builder.d(new TrackGroup(Integer.toString(i2), (Format) Assertions.e(b2.F())));
        }
        return builder.k();
    }

    /* access modifiers changed from: private */
    public RtpDataLoadable Q(Uri uri) {
        for (int i2 = 0; i2 < this.f26831f.size(); i2++) {
            if (!this.f26831f.get(i2).f26857d) {
                RtpLoadInfo rtpLoadInfo = this.f26831f.get(i2).f26854a;
                if (rtpLoadInfo.c().equals(uri)) {
                    return rtpLoadInfo.f26851b;
                }
            }
        }
        return null;
    }

    /* access modifiers changed from: private */
    public boolean S() {
        return this.f26840o != -9223372036854775807L;
    }

    /* access modifiers changed from: private */
    public void T() {
        if (!this.f26844s && !this.f26845t) {
            int i2 = 0;
            while (i2 < this.f26831f.size()) {
                if (this.f26831f.get(i2).f26856c.F() != null) {
                    i2++;
                } else {
                    return;
                }
            }
            this.f26845t = true;
            this.f26836k = P(ImmutableList.n(this.f26831f));
            ((MediaPeriod.Callback) Assertions.e(this.f26835j)).p(this);
        }
    }

    /* access modifiers changed from: private */
    public void U() {
        boolean z2 = true;
        for (int i2 = 0; i2 < this.f26832g.size(); i2++) {
            z2 &= this.f26832g.get(i2).e();
        }
        if (z2 && this.f26846u) {
            this.f26830e.L0(this.f26832g);
        }
    }

    /* access modifiers changed from: private */
    public void X() {
        this.f26848w = true;
        this.f26830e.I0();
        RtpDataChannel.Factory b2 = this.f26834i.b();
        if (b2 == null) {
            this.f26838m = new RtspMediaSource.RtspPlaybackException("No fallback data channel factory for TCP retry");
            return;
        }
        ArrayList arrayList = new ArrayList(this.f26831f.size());
        ArrayList arrayList2 = new ArrayList(this.f26832g.size());
        for (int i2 = 0; i2 < this.f26831f.size(); i2++) {
            RtspLoaderWrapper rtspLoaderWrapper = this.f26831f.get(i2);
            if (!rtspLoaderWrapper.f26857d) {
                RtspLoaderWrapper rtspLoaderWrapper2 = new RtspLoaderWrapper(rtspLoaderWrapper.f26854a.f26850a, i2, b2);
                arrayList.add(rtspLoaderWrapper2);
                rtspLoaderWrapper2.j();
                if (this.f26832g.contains(rtspLoaderWrapper.f26854a)) {
                    arrayList2.add(rtspLoaderWrapper2.f26854a);
                }
            } else {
                arrayList.add(rtspLoaderWrapper);
            }
        }
        ImmutableList<RtspLoaderWrapper> n2 = ImmutableList.n(this.f26831f);
        this.f26831f.clear();
        this.f26831f.addAll(arrayList);
        this.f26832g.clear();
        this.f26832g.addAll(arrayList2);
        for (int i3 = 0; i3 < n2.size(); i3++) {
            n2.get(i3).c();
        }
    }

    private boolean Y(long j2) {
        for (int i2 = 0; i2 < this.f26831f.size(); i2++) {
            if (!this.f26831f.get(i2).f26856c.Z(j2, false)) {
                return false;
            }
        }
        return true;
    }

    static /* synthetic */ int a(RtspMediaPeriod rtspMediaPeriod) {
        int i2 = rtspMediaPeriod.f26847v;
        rtspMediaPeriod.f26847v = i2 + 1;
        return i2;
    }

    private boolean a0() {
        return this.f26843r;
    }

    /* access modifiers changed from: private */
    public void b0() {
        this.f26842q = true;
        for (int i2 = 0; i2 < this.f26831f.size(); i2++) {
            this.f26842q &= this.f26831f.get(i2).f26857d;
        }
    }

    /* access modifiers changed from: package-private */
    public boolean R(int i2) {
        return !a0() && this.f26831f.get(i2).e();
    }

    /* access modifiers changed from: package-private */
    public int V(int i2, FormatHolder formatHolder, DecoderInputBuffer decoderInputBuffer, int i3) {
        if (a0()) {
            return -3;
        }
        return this.f26831f.get(i2).f(formatHolder, decoderInputBuffer, i3);
    }

    public void W() {
        for (int i2 = 0; i2 < this.f26831f.size(); i2++) {
            this.f26831f.get(i2).g();
        }
        Util.n(this.f26830e);
        this.f26844s = true;
    }

    /* access modifiers changed from: package-private */
    public int Z(int i2, long j2) {
        if (a0()) {
            return -3;
        }
        return this.f26831f.get(i2).i(j2);
    }

    public long b() {
        return e();
    }

    public boolean c() {
        return !this.f26842q;
    }

    public long e() {
        if (this.f26842q || this.f26831f.isEmpty()) {
            return Long.MIN_VALUE;
        }
        long j2 = this.f26839n;
        if (j2 != -9223372036854775807L) {
            return j2;
        }
        boolean z2 = true;
        long j3 = Clock.MAX_TIME;
        for (int i2 = 0; i2 < this.f26831f.size(); i2++) {
            RtspLoaderWrapper rtspLoaderWrapper = this.f26831f.get(i2);
            if (!rtspLoaderWrapper.f26857d) {
                j3 = Math.min(j3, rtspLoaderWrapper.d());
                z2 = false;
            }
        }
        if (z2 || j3 == Long.MIN_VALUE) {
            return 0;
        }
        return j3;
    }

    public void f(long j2) {
    }

    public long g(long j2, SeekParameters seekParameters) {
        return j2;
    }

    public boolean h(long j2) {
        return c();
    }

    public long i(long j2) {
        if (e() != 0 || this.f26848w) {
            o(j2, false);
            this.f26839n = j2;
            if (S()) {
                int F0 = this.f26830e.F0();
                if (F0 == 1) {
                    return j2;
                }
                if (F0 == 2) {
                    this.f26840o = j2;
                    this.f26830e.J0(j2);
                    return j2;
                }
                throw new IllegalStateException();
            } else if (Y(j2)) {
                return j2;
            } else {
                this.f26840o = j2;
                this.f26830e.J0(j2);
                for (int i2 = 0; i2 < this.f26831f.size(); i2++) {
                    this.f26831f.get(i2).h(j2);
                }
                return j2;
            }
        } else {
            this.f26841p = j2;
            return j2;
        }
    }

    public long j() {
        if (!this.f26843r) {
            return -9223372036854775807L;
        }
        this.f26843r = false;
        return 0;
    }

    public void l() throws IOException {
        IOException iOException = this.f26837l;
        if (iOException != null) {
            throw iOException;
        }
    }

    public TrackGroupArray n() {
        Assertions.g(this.f26845t);
        return new TrackGroupArray((TrackGroup[]) ((ImmutableList) Assertions.e(this.f26836k)).toArray(new TrackGroup[0]));
    }

    public void o(long j2, boolean z2) {
        if (!S()) {
            for (int i2 = 0; i2 < this.f26831f.size(); i2++) {
                RtspLoaderWrapper rtspLoaderWrapper = this.f26831f.get(i2);
                if (!rtspLoaderWrapper.f26857d) {
                    rtspLoaderWrapper.f26856c.q(j2, z2, true);
                }
            }
        }
    }

    public void r(MediaPeriod.Callback callback, long j2) {
        this.f26835j = callback;
        try {
            this.f26830e.M0();
        } catch (IOException e2) {
            this.f26837l = e2;
            Util.n(this.f26830e);
        }
    }

    public long s(ExoTrackSelection[] exoTrackSelectionArr, boolean[] zArr, SampleStream[] sampleStreamArr, boolean[] zArr2, long j2) {
        for (int i2 = 0; i2 < exoTrackSelectionArr.length; i2++) {
            if (sampleStreamArr[i2] != null && (exoTrackSelectionArr[i2] == null || !zArr[i2])) {
                sampleStreamArr[i2] = null;
            }
        }
        this.f26832g.clear();
        for (int i3 = 0; i3 < exoTrackSelectionArr.length; i3++) {
            ExoTrackSelection exoTrackSelection = exoTrackSelectionArr[i3];
            if (exoTrackSelection != null) {
                TrackGroup h2 = exoTrackSelection.h();
                int indexOf = ((ImmutableList) Assertions.e(this.f26836k)).indexOf(h2);
                this.f26832g.add(((RtspLoaderWrapper) Assertions.e(this.f26831f.get(indexOf))).f26854a);
                if (this.f26836k.contains(h2) && sampleStreamArr[i3] == null) {
                    sampleStreamArr[i3] = new SampleStreamImpl(indexOf);
                    zArr2[i3] = true;
                }
            }
        }
        for (int i4 = 0; i4 < this.f26831f.size(); i4++) {
            RtspLoaderWrapper rtspLoaderWrapper = this.f26831f.get(i4);
            if (!this.f26832g.contains(rtspLoaderWrapper.f26854a)) {
                rtspLoaderWrapper.c();
            }
        }
        this.f26846u = true;
        if (j2 != 0) {
            this.f26839n = j2;
            this.f26840o = j2;
            this.f26841p = j2;
        }
        U();
        return j2;
    }
}
