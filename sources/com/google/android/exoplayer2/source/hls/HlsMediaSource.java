package com.google.android.exoplayer2.source.hls;

import android.os.Looper;
import com.google.android.exoplayer2.ExoPlayerLibraryInfo;
import com.google.android.exoplayer2.MediaItem;
import com.google.android.exoplayer2.drm.DefaultDrmSessionManagerProvider;
import com.google.android.exoplayer2.drm.DrmSessionManager;
import com.google.android.exoplayer2.drm.DrmSessionManagerProvider;
import com.google.android.exoplayer2.offline.StreamKey;
import com.google.android.exoplayer2.source.BaseMediaSource;
import com.google.android.exoplayer2.source.CompositeSequenceableLoaderFactory;
import com.google.android.exoplayer2.source.DefaultCompositeSequenceableLoaderFactory;
import com.google.android.exoplayer2.source.MediaPeriod;
import com.google.android.exoplayer2.source.MediaSource;
import com.google.android.exoplayer2.source.MediaSourceEventListener;
import com.google.android.exoplayer2.source.SinglePeriodTimeline;
import com.google.android.exoplayer2.source.hls.playlist.DefaultHlsPlaylistParserFactory;
import com.google.android.exoplayer2.source.hls.playlist.DefaultHlsPlaylistTracker;
import com.google.android.exoplayer2.source.hls.playlist.FilteringHlsPlaylistParserFactory;
import com.google.android.exoplayer2.source.hls.playlist.HlsMediaPlaylist;
import com.google.android.exoplayer2.source.hls.playlist.HlsMultivariantPlaylist;
import com.google.android.exoplayer2.source.hls.playlist.HlsPlaylistParserFactory;
import com.google.android.exoplayer2.source.hls.playlist.HlsPlaylistTracker;
import com.google.android.exoplayer2.upstream.Allocator;
import com.google.android.exoplayer2.upstream.DataSource;
import com.google.android.exoplayer2.upstream.DefaultLoadErrorHandlingPolicy;
import com.google.android.exoplayer2.upstream.LoadErrorHandlingPolicy;
import com.google.android.exoplayer2.upstream.TransferListener;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.Util;
import java.io.IOException;
import java.util.List;

public final class HlsMediaSource extends BaseMediaSource implements HlsPlaylistTracker.PrimaryPlaylistListener {

    /* renamed from: i  reason: collision with root package name */
    private final HlsExtractorFactory f26470i;

    /* renamed from: j  reason: collision with root package name */
    private final MediaItem.LocalConfiguration f26471j;

    /* renamed from: k  reason: collision with root package name */
    private final HlsDataSourceFactory f26472k;

    /* renamed from: l  reason: collision with root package name */
    private final CompositeSequenceableLoaderFactory f26473l;

    /* renamed from: m  reason: collision with root package name */
    private final DrmSessionManager f26474m;

    /* renamed from: n  reason: collision with root package name */
    private final LoadErrorHandlingPolicy f26475n;

    /* renamed from: o  reason: collision with root package name */
    private final boolean f26476o;

    /* renamed from: p  reason: collision with root package name */
    private final int f26477p;

    /* renamed from: q  reason: collision with root package name */
    private final boolean f26478q;

    /* renamed from: r  reason: collision with root package name */
    private final HlsPlaylistTracker f26479r;

    /* renamed from: s  reason: collision with root package name */
    private final long f26480s;

    /* renamed from: t  reason: collision with root package name */
    private final MediaItem f26481t;

    /* renamed from: u  reason: collision with root package name */
    private MediaItem.LiveConfiguration f26482u;

    /* renamed from: v  reason: collision with root package name */
    private TransferListener f26483v;

    public static final class Factory implements MediaSource.Factory {

        /* renamed from: a  reason: collision with root package name */
        private final HlsDataSourceFactory f26484a;

        /* renamed from: b  reason: collision with root package name */
        private HlsExtractorFactory f26485b;

        /* renamed from: c  reason: collision with root package name */
        private HlsPlaylistParserFactory f26486c;

        /* renamed from: d  reason: collision with root package name */
        private HlsPlaylistTracker.Factory f26487d;

        /* renamed from: e  reason: collision with root package name */
        private CompositeSequenceableLoaderFactory f26488e;

        /* renamed from: f  reason: collision with root package name */
        private DrmSessionManagerProvider f26489f;

        /* renamed from: g  reason: collision with root package name */
        private LoadErrorHandlingPolicy f26490g;

        /* renamed from: h  reason: collision with root package name */
        private boolean f26491h;

        /* renamed from: i  reason: collision with root package name */
        private int f26492i;

        /* renamed from: j  reason: collision with root package name */
        private boolean f26493j;

        /* renamed from: k  reason: collision with root package name */
        private long f26494k;

        public Factory(DataSource.Factory factory) {
            this((HlsDataSourceFactory) new DefaultHlsDataSourceFactory(factory));
        }

        /* renamed from: d */
        public HlsMediaSource a(MediaItem mediaItem) {
            MediaItem mediaItem2 = mediaItem;
            Assertions.e(mediaItem2.f23129c);
            HlsPlaylistParserFactory hlsPlaylistParserFactory = this.f26486c;
            List<StreamKey> list = mediaItem2.f23129c.f23205d;
            if (!list.isEmpty()) {
                hlsPlaylistParserFactory = new FilteringHlsPlaylistParserFactory(hlsPlaylistParserFactory, list);
            }
            HlsDataSourceFactory hlsDataSourceFactory = this.f26484a;
            HlsExtractorFactory hlsExtractorFactory = this.f26485b;
            CompositeSequenceableLoaderFactory compositeSequenceableLoaderFactory = this.f26488e;
            DrmSessionManager a2 = this.f26489f.a(mediaItem2);
            LoadErrorHandlingPolicy loadErrorHandlingPolicy = this.f26490g;
            return new HlsMediaSource(mediaItem, hlsDataSourceFactory, hlsExtractorFactory, compositeSequenceableLoaderFactory, a2, loadErrorHandlingPolicy, this.f26487d.a(this.f26484a, loadErrorHandlingPolicy, hlsPlaylistParserFactory), this.f26494k, this.f26491h, this.f26492i, this.f26493j);
        }

        /* renamed from: e */
        public Factory b(DrmSessionManagerProvider drmSessionManagerProvider) {
            this.f26489f = (DrmSessionManagerProvider) Assertions.f(drmSessionManagerProvider, "MediaSource.Factory#setDrmSessionManagerProvider no longer handles null by instantiating a new DefaultDrmSessionManagerProvider. Explicitly construct and pass an instance in order to retain the old behavior.");
            return this;
        }

        /* renamed from: f */
        public Factory c(LoadErrorHandlingPolicy loadErrorHandlingPolicy) {
            this.f26490g = (LoadErrorHandlingPolicy) Assertions.f(loadErrorHandlingPolicy, "MediaSource.Factory#setLoadErrorHandlingPolicy no longer handles null by instantiating a new DefaultLoadErrorHandlingPolicy. Explicitly construct and pass an instance in order to retain the old behavior.");
            return this;
        }

        public Factory(HlsDataSourceFactory hlsDataSourceFactory) {
            this.f26484a = (HlsDataSourceFactory) Assertions.e(hlsDataSourceFactory);
            this.f26489f = new DefaultDrmSessionManagerProvider();
            this.f26486c = new DefaultHlsPlaylistParserFactory();
            this.f26487d = DefaultHlsPlaylistTracker.f26552q;
            this.f26485b = HlsExtractorFactory.f26424a;
            this.f26490g = new DefaultLoadErrorHandlingPolicy();
            this.f26488e = new DefaultCompositeSequenceableLoaderFactory();
            this.f26492i = 1;
            this.f26494k = -9223372036854775807L;
            this.f26491h = true;
        }
    }

    static {
        ExoPlayerLibraryInfo.a("goog.exo.hls");
    }

    private SinglePeriodTimeline F(HlsMediaPlaylist hlsMediaPlaylist, long j2, long j3, HlsManifest hlsManifest) {
        long j4;
        long j5;
        boolean z2;
        HlsMediaPlaylist hlsMediaPlaylist2 = hlsMediaPlaylist;
        long b2 = hlsMediaPlaylist2.f26586h - this.f26479r.b();
        if (hlsMediaPlaylist2.f26593o) {
            j4 = b2 + hlsMediaPlaylist2.f26599u;
        } else {
            j4 = -9223372036854775807L;
        }
        long J = J(hlsMediaPlaylist);
        long j6 = this.f26482u.f23192b;
        if (j6 != -9223372036854775807L) {
            j5 = Util.F0(j6);
        } else {
            j5 = L(hlsMediaPlaylist2, J);
        }
        M(hlsMediaPlaylist2, Util.r(j5, J, hlsMediaPlaylist2.f26599u + J));
        long K = K(hlsMediaPlaylist2, J);
        if (hlsMediaPlaylist2.f26582d != 2 || !hlsMediaPlaylist2.f26584f) {
            z2 = false;
        } else {
            z2 = true;
        }
        return new SinglePeriodTimeline(j2, j3, -9223372036854775807L, j4, hlsMediaPlaylist2.f26599u, b2, K, true, !hlsMediaPlaylist2.f26593o, z2, hlsManifest, this.f26481t, this.f26482u);
    }

    private SinglePeriodTimeline G(HlsMediaPlaylist hlsMediaPlaylist, long j2, long j3, HlsManifest hlsManifest) {
        long j4;
        HlsMediaPlaylist hlsMediaPlaylist2 = hlsMediaPlaylist;
        if (hlsMediaPlaylist2.f26583e == -9223372036854775807L || hlsMediaPlaylist2.f26596r.isEmpty()) {
            j4 = 0;
        } else {
            if (!hlsMediaPlaylist2.f26585g) {
                long j5 = hlsMediaPlaylist2.f26583e;
                if (j5 != hlsMediaPlaylist2.f26599u) {
                    j4 = I(hlsMediaPlaylist2.f26596r, j5).f26612f;
                }
            }
            j4 = hlsMediaPlaylist2.f26583e;
        }
        long j6 = hlsMediaPlaylist2.f26599u;
        return new SinglePeriodTimeline(j2, j3, -9223372036854775807L, j6, j6, 0, j4, true, false, true, hlsManifest, this.f26481t, (MediaItem.LiveConfiguration) null);
    }

    private static HlsMediaPlaylist.Part H(List<HlsMediaPlaylist.Part> list, long j2) {
        HlsMediaPlaylist.Part part = null;
        for (int i2 = 0; i2 < list.size(); i2++) {
            HlsMediaPlaylist.Part part2 = list.get(i2);
            long j3 = part2.f26612f;
            if (j3 <= j2 && part2.f26601m) {
                part = part2;
            } else if (j3 > j2) {
                break;
            }
        }
        return part;
    }

    private static HlsMediaPlaylist.Segment I(List<HlsMediaPlaylist.Segment> list, long j2) {
        return list.get(Util.g(list, Long.valueOf(j2), true, true));
    }

    private long J(HlsMediaPlaylist hlsMediaPlaylist) {
        if (hlsMediaPlaylist.f26594p) {
            return Util.F0(Util.c0(this.f26480s)) - hlsMediaPlaylist.e();
        }
        return 0;
    }

    private long K(HlsMediaPlaylist hlsMediaPlaylist, long j2) {
        long j3 = hlsMediaPlaylist.f26583e;
        if (j3 == -9223372036854775807L) {
            j3 = (hlsMediaPlaylist.f26599u + j2) - Util.F0(this.f26482u.f23192b);
        }
        if (hlsMediaPlaylist.f26585g) {
            return j3;
        }
        HlsMediaPlaylist.Part H = H(hlsMediaPlaylist.f26597s, j3);
        if (H != null) {
            return H.f26612f;
        }
        if (hlsMediaPlaylist.f26596r.isEmpty()) {
            return 0;
        }
        HlsMediaPlaylist.Segment I = I(hlsMediaPlaylist.f26596r, j3);
        HlsMediaPlaylist.Part H2 = H(I.f26607n, j3);
        if (H2 != null) {
            return H2.f26612f;
        }
        return I.f26612f;
    }

    private static long L(HlsMediaPlaylist hlsMediaPlaylist, long j2) {
        long j3;
        HlsMediaPlaylist.ServerControl serverControl = hlsMediaPlaylist.f26600v;
        long j4 = hlsMediaPlaylist.f26583e;
        if (j4 != -9223372036854775807L) {
            j3 = hlsMediaPlaylist.f26599u - j4;
        } else {
            long j5 = serverControl.f26622d;
            if (j5 == -9223372036854775807L || hlsMediaPlaylist.f26592n == -9223372036854775807L) {
                long j6 = serverControl.f26621c;
                if (j6 != -9223372036854775807L) {
                    j3 = j6;
                } else {
                    j3 = hlsMediaPlaylist.f26591m * 3;
                }
            } else {
                j3 = j5;
            }
        }
        return j3 + j2;
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x003a  */
    /* JADX WARNING: Removed duplicated region for block: B:13:0x003d  */
    /* JADX WARNING: Removed duplicated region for block: B:16:0x0048  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void M(com.google.android.exoplayer2.source.hls.playlist.HlsMediaPlaylist r6, long r7) {
        /*
            r5 = this;
            com.google.android.exoplayer2.MediaItem r0 = r5.f26481t
            com.google.android.exoplayer2.MediaItem$LiveConfiguration r0 = r0.f23131e
            float r1 = r0.f23195e
            r2 = -8388609(0xffffffffff7fffff, float:-3.4028235E38)
            int r1 = (r1 > r2 ? 1 : (r1 == r2 ? 0 : -1))
            if (r1 != 0) goto L_0x0028
            float r0 = r0.f23196f
            int r0 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r0 != 0) goto L_0x0028
            com.google.android.exoplayer2.source.hls.playlist.HlsMediaPlaylist$ServerControl r6 = r6.f26600v
            long r0 = r6.f26621c
            r2 = -9223372036854775807(0x8000000000000001, double:-4.9E-324)
            int r4 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r4 != 0) goto L_0x0028
            long r0 = r6.f26622d
            int r6 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r6 != 0) goto L_0x0028
            r6 = 1
            goto L_0x0029
        L_0x0028:
            r6 = 0
        L_0x0029:
            com.google.android.exoplayer2.MediaItem$LiveConfiguration$Builder r0 = new com.google.android.exoplayer2.MediaItem$LiveConfiguration$Builder
            r0.<init>()
            long r7 = com.google.android.exoplayer2.util.Util.i1(r7)
            com.google.android.exoplayer2.MediaItem$LiveConfiguration$Builder r7 = r0.k(r7)
            r8 = 1065353216(0x3f800000, float:1.0)
            if (r6 == 0) goto L_0x003d
            r0 = 1065353216(0x3f800000, float:1.0)
            goto L_0x0041
        L_0x003d:
            com.google.android.exoplayer2.MediaItem$LiveConfiguration r0 = r5.f26482u
            float r0 = r0.f23195e
        L_0x0041:
            com.google.android.exoplayer2.MediaItem$LiveConfiguration$Builder r7 = r7.j(r0)
            if (r6 == 0) goto L_0x0048
            goto L_0x004c
        L_0x0048:
            com.google.android.exoplayer2.MediaItem$LiveConfiguration r6 = r5.f26482u
            float r8 = r6.f23196f
        L_0x004c:
            com.google.android.exoplayer2.MediaItem$LiveConfiguration$Builder r6 = r7.h(r8)
            com.google.android.exoplayer2.MediaItem$LiveConfiguration r6 = r6.f()
            r5.f26482u = r6
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.source.hls.HlsMediaSource.M(com.google.android.exoplayer2.source.hls.playlist.HlsMediaPlaylist, long):void");
    }

    /* access modifiers changed from: protected */
    public void C(TransferListener transferListener) {
        this.f26483v = transferListener;
        this.f26474m.b((Looper) Assertions.e(Looper.myLooper()), A());
        this.f26474m.prepare();
        this.f26479r.k(this.f26471j.f23202a, w((MediaSource.MediaPeriodId) null), this);
    }

    /* access modifiers changed from: protected */
    public void E() {
        this.f26479r.stop();
        this.f26474m.release();
    }

    public MediaItem a() {
        return this.f26481t;
    }

    public void c() throws IOException {
        this.f26479r.g();
    }

    public MediaPeriod f(MediaSource.MediaPeriodId mediaPeriodId, Allocator allocator, long j2) {
        MediaSourceEventListener.EventDispatcher w2 = w(mediaPeriodId);
        return new HlsMediaPeriod(this.f26470i, this.f26479r, this.f26472k, this.f26483v, this.f26474m, u(mediaPeriodId), this.f26475n, w2, allocator, this.f26473l, this.f26476o, this.f26477p, this.f26478q, A());
    }

    public void h(HlsMediaPlaylist hlsMediaPlaylist) {
        long j2;
        long j3;
        SinglePeriodTimeline singlePeriodTimeline;
        if (hlsMediaPlaylist.f26594p) {
            j2 = Util.i1(hlsMediaPlaylist.f26586h);
        } else {
            j2 = -9223372036854775807L;
        }
        int i2 = hlsMediaPlaylist.f26582d;
        if (i2 == 2 || i2 == 1) {
            j3 = j2;
        } else {
            j3 = -9223372036854775807L;
        }
        HlsManifest hlsManifest = new HlsManifest((HlsMultivariantPlaylist) Assertions.e(this.f26479r.c()), hlsMediaPlaylist);
        if (this.f26479r.isLive()) {
            singlePeriodTimeline = F(hlsMediaPlaylist, j3, j2, hlsManifest);
        } else {
            singlePeriodTimeline = G(hlsMediaPlaylist, j3, j2, hlsManifest);
        }
        D(singlePeriodTimeline);
    }

    public void l(MediaPeriod mediaPeriod) {
        ((HlsMediaPeriod) mediaPeriod).B();
    }

    private HlsMediaSource(MediaItem mediaItem, HlsDataSourceFactory hlsDataSourceFactory, HlsExtractorFactory hlsExtractorFactory, CompositeSequenceableLoaderFactory compositeSequenceableLoaderFactory, DrmSessionManager drmSessionManager, LoadErrorHandlingPolicy loadErrorHandlingPolicy, HlsPlaylistTracker hlsPlaylistTracker, long j2, boolean z2, int i2, boolean z3) {
        this.f26471j = (MediaItem.LocalConfiguration) Assertions.e(mediaItem.f23129c);
        this.f26481t = mediaItem;
        this.f26482u = mediaItem.f23131e;
        this.f26472k = hlsDataSourceFactory;
        this.f26470i = hlsExtractorFactory;
        this.f26473l = compositeSequenceableLoaderFactory;
        this.f26474m = drmSessionManager;
        this.f26475n = loadErrorHandlingPolicy;
        this.f26479r = hlsPlaylistTracker;
        this.f26480s = j2;
        this.f26476o = z2;
        this.f26477p = i2;
        this.f26478q = z3;
    }
}
