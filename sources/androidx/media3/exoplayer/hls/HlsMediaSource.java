package androidx.media3.exoplayer.hls;

import android.os.Looper;
import androidx.media3.common.MediaItem;
import androidx.media3.common.MediaLibraryInfo;
import androidx.media3.common.StreamKey;
import androidx.media3.common.util.Assertions;
import androidx.media3.common.util.Util;
import androidx.media3.datasource.DataSource;
import androidx.media3.datasource.TransferListener;
import androidx.media3.exoplayer.drm.DefaultDrmSessionManagerProvider;
import androidx.media3.exoplayer.drm.DrmSessionEventListener;
import androidx.media3.exoplayer.drm.DrmSessionManager;
import androidx.media3.exoplayer.drm.DrmSessionManagerProvider;
import androidx.media3.exoplayer.hls.playlist.DefaultHlsPlaylistParserFactory;
import androidx.media3.exoplayer.hls.playlist.DefaultHlsPlaylistTracker;
import androidx.media3.exoplayer.hls.playlist.FilteringHlsPlaylistParserFactory;
import androidx.media3.exoplayer.hls.playlist.HlsMediaPlaylist;
import androidx.media3.exoplayer.hls.playlist.HlsMultivariantPlaylist;
import androidx.media3.exoplayer.hls.playlist.HlsPlaylistParserFactory;
import androidx.media3.exoplayer.hls.playlist.HlsPlaylistTracker;
import androidx.media3.exoplayer.source.BaseMediaSource;
import androidx.media3.exoplayer.source.CompositeSequenceableLoaderFactory;
import androidx.media3.exoplayer.source.DefaultCompositeSequenceableLoaderFactory;
import androidx.media3.exoplayer.source.MediaPeriod;
import androidx.media3.exoplayer.source.MediaSource;
import androidx.media3.exoplayer.source.MediaSourceEventListener;
import androidx.media3.exoplayer.source.SinglePeriodTimeline;
import androidx.media3.exoplayer.upstream.Allocator;
import androidx.media3.exoplayer.upstream.CmcdConfiguration;
import androidx.media3.exoplayer.upstream.DefaultLoadErrorHandlingPolicy;
import androidx.media3.exoplayer.upstream.LoadErrorHandlingPolicy;
import androidx.media3.extractor.text.SubtitleParser;
import java.io.IOException;
import java.util.List;

public final class HlsMediaSource extends BaseMediaSource implements HlsPlaylistTracker.PrimaryPlaylistListener {

    /* renamed from: h  reason: collision with root package name */
    private final HlsExtractorFactory f6380h;

    /* renamed from: i  reason: collision with root package name */
    private final HlsDataSourceFactory f6381i;

    /* renamed from: j  reason: collision with root package name */
    private final CompositeSequenceableLoaderFactory f6382j;

    /* renamed from: k  reason: collision with root package name */
    private final DrmSessionManager f6383k;

    /* renamed from: l  reason: collision with root package name */
    private final LoadErrorHandlingPolicy f6384l;

    /* renamed from: m  reason: collision with root package name */
    private final boolean f6385m;

    /* renamed from: n  reason: collision with root package name */
    private final int f6386n;

    /* renamed from: o  reason: collision with root package name */
    private final boolean f6387o;

    /* renamed from: p  reason: collision with root package name */
    private final HlsPlaylistTracker f6388p;

    /* renamed from: q  reason: collision with root package name */
    private final long f6389q;

    /* renamed from: r  reason: collision with root package name */
    private final long f6390r;

    /* renamed from: s  reason: collision with root package name */
    private MediaItem.LiveConfiguration f6391s;

    /* renamed from: t  reason: collision with root package name */
    private TransferListener f6392t;

    /* renamed from: u  reason: collision with root package name */
    private MediaItem f6393u;

    public static final class Factory implements MediaSource.Factory {

        /* renamed from: a  reason: collision with root package name */
        private final HlsDataSourceFactory f6394a;

        /* renamed from: b  reason: collision with root package name */
        private HlsExtractorFactory f6395b;

        /* renamed from: c  reason: collision with root package name */
        private HlsPlaylistParserFactory f6396c;

        /* renamed from: d  reason: collision with root package name */
        private HlsPlaylistTracker.Factory f6397d;

        /* renamed from: e  reason: collision with root package name */
        private CompositeSequenceableLoaderFactory f6398e;

        /* renamed from: f  reason: collision with root package name */
        private CmcdConfiguration.Factory f6399f;

        /* renamed from: g  reason: collision with root package name */
        private DrmSessionManagerProvider f6400g;

        /* renamed from: h  reason: collision with root package name */
        private LoadErrorHandlingPolicy f6401h;

        /* renamed from: i  reason: collision with root package name */
        private boolean f6402i;

        /* renamed from: j  reason: collision with root package name */
        private int f6403j;

        /* renamed from: k  reason: collision with root package name */
        private boolean f6404k;

        /* renamed from: l  reason: collision with root package name */
        private long f6405l;

        /* renamed from: m  reason: collision with root package name */
        private long f6406m;

        public Factory(DataSource.Factory factory) {
            this((HlsDataSourceFactory) new DefaultHlsDataSourceFactory(factory));
        }

        /* renamed from: g */
        public HlsMediaSource c(MediaItem mediaItem) {
            FilteringHlsPlaylistParserFactory filteringHlsPlaylistParserFactory;
            MediaItem mediaItem2 = mediaItem;
            Assertions.f(mediaItem2.f4079b);
            HlsPlaylistParserFactory hlsPlaylistParserFactory = this.f6396c;
            List<StreamKey> list = mediaItem2.f4079b.f4174d;
            if (!list.isEmpty()) {
                filteringHlsPlaylistParserFactory = new FilteringHlsPlaylistParserFactory(hlsPlaylistParserFactory, list);
            } else {
                filteringHlsPlaylistParserFactory = hlsPlaylistParserFactory;
            }
            CmcdConfiguration.Factory factory = this.f6399f;
            if (factory != null) {
                factory.a(mediaItem2);
            }
            HlsDataSourceFactory hlsDataSourceFactory = this.f6394a;
            HlsExtractorFactory hlsExtractorFactory = this.f6395b;
            CompositeSequenceableLoaderFactory compositeSequenceableLoaderFactory = this.f6398e;
            DrmSessionManager a2 = this.f6400g.a(mediaItem2);
            LoadErrorHandlingPolicy loadErrorHandlingPolicy = this.f6401h;
            return new HlsMediaSource(mediaItem, hlsDataSourceFactory, hlsExtractorFactory, compositeSequenceableLoaderFactory, (CmcdConfiguration) null, a2, loadErrorHandlingPolicy, this.f6397d.a(this.f6394a, loadErrorHandlingPolicy, filteringHlsPlaylistParserFactory), this.f6405l, this.f6402i, this.f6403j, this.f6404k, this.f6406m);
        }

        @Deprecated
        /* renamed from: h */
        public Factory b(boolean z2) {
            this.f6395b.b(z2);
            return this;
        }

        /* renamed from: i */
        public Factory f(CmcdConfiguration.Factory factory) {
            this.f6399f = (CmcdConfiguration.Factory) Assertions.f(factory);
            return this;
        }

        /* renamed from: j */
        public Factory d(DrmSessionManagerProvider drmSessionManagerProvider) {
            this.f6400g = (DrmSessionManagerProvider) Assertions.g(drmSessionManagerProvider, "MediaSource.Factory#setDrmSessionManagerProvider no longer handles null by instantiating a new DefaultDrmSessionManagerProvider. Explicitly construct and pass an instance in order to retain the old behavior.");
            return this;
        }

        /* renamed from: k */
        public Factory e(LoadErrorHandlingPolicy loadErrorHandlingPolicy) {
            this.f6401h = (LoadErrorHandlingPolicy) Assertions.g(loadErrorHandlingPolicy, "MediaSource.Factory#setLoadErrorHandlingPolicy no longer handles null by instantiating a new DefaultLoadErrorHandlingPolicy. Explicitly construct and pass an instance in order to retain the old behavior.");
            return this;
        }

        /* renamed from: l */
        public Factory a(SubtitleParser.Factory factory) {
            this.f6395b.a((SubtitleParser.Factory) Assertions.f(factory));
            return this;
        }

        public Factory(HlsDataSourceFactory hlsDataSourceFactory) {
            this.f6394a = (HlsDataSourceFactory) Assertions.f(hlsDataSourceFactory);
            this.f6400g = new DefaultDrmSessionManagerProvider();
            this.f6396c = new DefaultHlsPlaylistParserFactory();
            this.f6397d = DefaultHlsPlaylistTracker.f6468q;
            this.f6395b = HlsExtractorFactory.f6335a;
            this.f6401h = new DefaultLoadErrorHandlingPolicy();
            this.f6398e = new DefaultCompositeSequenceableLoaderFactory();
            this.f6403j = 1;
            this.f6405l = -9223372036854775807L;
            this.f6402i = true;
            b(true);
        }
    }

    static {
        MediaLibraryInfo.a("media3.exoplayer.hls");
    }

    private SinglePeriodTimeline C(HlsMediaPlaylist hlsMediaPlaylist, long j2, long j3, HlsManifest hlsManifest) {
        long j4;
        long j5;
        boolean z2;
        HlsMediaPlaylist hlsMediaPlaylist2 = hlsMediaPlaylist;
        long b2 = hlsMediaPlaylist2.f6503h - this.f6388p.b();
        if (hlsMediaPlaylist2.f6510o) {
            j4 = b2 + hlsMediaPlaylist2.f6516u;
        } else {
            j4 = -9223372036854775807L;
        }
        long G = G(hlsMediaPlaylist);
        long j6 = this.f6391s.f4153a;
        if (j6 != -9223372036854775807L) {
            j5 = Util.P0(j6);
        } else {
            j5 = I(hlsMediaPlaylist2, G);
        }
        J(hlsMediaPlaylist2, Util.q(j5, G, hlsMediaPlaylist2.f6516u + G));
        long H = H(hlsMediaPlaylist2, G);
        if (hlsMediaPlaylist2.f6499d != 2 || !hlsMediaPlaylist2.f6501f) {
            z2 = false;
        } else {
            z2 = true;
        }
        return new SinglePeriodTimeline(j2, j3, -9223372036854775807L, j4, hlsMediaPlaylist2.f6516u, b2, H, true, !hlsMediaPlaylist2.f6510o, z2, hlsManifest, a(), this.f6391s);
    }

    private SinglePeriodTimeline D(HlsMediaPlaylist hlsMediaPlaylist, long j2, long j3, HlsManifest hlsManifest) {
        long j4;
        HlsMediaPlaylist hlsMediaPlaylist2 = hlsMediaPlaylist;
        if (hlsMediaPlaylist2.f6500e == -9223372036854775807L || hlsMediaPlaylist2.f6513r.isEmpty()) {
            j4 = 0;
        } else {
            if (!hlsMediaPlaylist2.f6502g) {
                long j5 = hlsMediaPlaylist2.f6500e;
                if (j5 != hlsMediaPlaylist2.f6516u) {
                    j4 = F(hlsMediaPlaylist2.f6513r, j5).f6529f;
                }
            }
            j4 = hlsMediaPlaylist2.f6500e;
        }
        long j6 = hlsMediaPlaylist2.f6516u;
        return new SinglePeriodTimeline(j2, j3, -9223372036854775807L, j6, j6, 0, j4, true, false, true, hlsManifest, a(), (MediaItem.LiveConfiguration) null);
    }

    private static HlsMediaPlaylist.Part E(List<HlsMediaPlaylist.Part> list, long j2) {
        HlsMediaPlaylist.Part part = null;
        for (int i2 = 0; i2 < list.size(); i2++) {
            HlsMediaPlaylist.Part part2 = list.get(i2);
            long j3 = part2.f6529f;
            if (j3 <= j2 && part2.f6518m) {
                part = part2;
            } else if (j3 > j2) {
                break;
            }
        }
        return part;
    }

    private static HlsMediaPlaylist.Segment F(List<HlsMediaPlaylist.Segment> list, long j2) {
        return list.get(Util.f(list, Long.valueOf(j2), true, true));
    }

    private long G(HlsMediaPlaylist hlsMediaPlaylist) {
        if (hlsMediaPlaylist.f6511p) {
            return Util.P0(Util.f0(this.f6389q)) - hlsMediaPlaylist.e();
        }
        return 0;
    }

    private long H(HlsMediaPlaylist hlsMediaPlaylist, long j2) {
        long j3 = hlsMediaPlaylist.f6500e;
        if (j3 == -9223372036854775807L) {
            j3 = (hlsMediaPlaylist.f6516u + j2) - Util.P0(this.f6391s.f4153a);
        }
        if (hlsMediaPlaylist.f6502g) {
            return j3;
        }
        HlsMediaPlaylist.Part E = E(hlsMediaPlaylist.f6514s, j3);
        if (E != null) {
            return E.f6529f;
        }
        if (hlsMediaPlaylist.f6513r.isEmpty()) {
            return 0;
        }
        HlsMediaPlaylist.Segment F = F(hlsMediaPlaylist.f6513r, j3);
        HlsMediaPlaylist.Part E2 = E(F.f6524n, j3);
        if (E2 != null) {
            return E2.f6529f;
        }
        return F.f6529f;
    }

    private static long I(HlsMediaPlaylist hlsMediaPlaylist, long j2) {
        long j3;
        HlsMediaPlaylist.ServerControl serverControl = hlsMediaPlaylist.f6517v;
        long j4 = hlsMediaPlaylist.f6500e;
        if (j4 != -9223372036854775807L) {
            j3 = hlsMediaPlaylist.f6516u - j4;
        } else {
            long j5 = serverControl.f6539d;
            if (j5 == -9223372036854775807L || hlsMediaPlaylist.f6509n == -9223372036854775807L) {
                long j6 = serverControl.f6538c;
                if (j6 != -9223372036854775807L) {
                    j3 = j6;
                } else {
                    j3 = hlsMediaPlaylist.f6508m * 3;
                }
            } else {
                j3 = j5;
            }
        }
        return j3 + j2;
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x003c  */
    /* JADX WARNING: Removed duplicated region for block: B:13:0x003f  */
    /* JADX WARNING: Removed duplicated region for block: B:16:0x004a  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void J(androidx.media3.exoplayer.hls.playlist.HlsMediaPlaylist r6, long r7) {
        /*
            r5 = this;
            androidx.media3.common.MediaItem r0 = r5.a()
            androidx.media3.common.MediaItem$LiveConfiguration r0 = r0.f4081d
            float r1 = r0.f4156d
            r2 = -8388609(0xffffffffff7fffff, float:-3.4028235E38)
            int r1 = (r1 > r2 ? 1 : (r1 == r2 ? 0 : -1))
            if (r1 != 0) goto L_0x002a
            float r0 = r0.f4157e
            int r0 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r0 != 0) goto L_0x002a
            androidx.media3.exoplayer.hls.playlist.HlsMediaPlaylist$ServerControl r6 = r6.f6517v
            long r0 = r6.f6538c
            r2 = -9223372036854775807(0x8000000000000001, double:-4.9E-324)
            int r4 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r4 != 0) goto L_0x002a
            long r0 = r6.f6539d
            int r6 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r6 != 0) goto L_0x002a
            r6 = 1
            goto L_0x002b
        L_0x002a:
            r6 = 0
        L_0x002b:
            androidx.media3.common.MediaItem$LiveConfiguration$Builder r0 = new androidx.media3.common.MediaItem$LiveConfiguration$Builder
            r0.<init>()
            long r7 = androidx.media3.common.util.Util.t1(r7)
            androidx.media3.common.MediaItem$LiveConfiguration$Builder r7 = r0.k(r7)
            r8 = 1065353216(0x3f800000, float:1.0)
            if (r6 == 0) goto L_0x003f
            r0 = 1065353216(0x3f800000, float:1.0)
            goto L_0x0043
        L_0x003f:
            androidx.media3.common.MediaItem$LiveConfiguration r0 = r5.f6391s
            float r0 = r0.f4156d
        L_0x0043:
            androidx.media3.common.MediaItem$LiveConfiguration$Builder r7 = r7.j(r0)
            if (r6 == 0) goto L_0x004a
            goto L_0x004e
        L_0x004a:
            androidx.media3.common.MediaItem$LiveConfiguration r6 = r5.f6391s
            float r8 = r6.f4157e
        L_0x004e:
            androidx.media3.common.MediaItem$LiveConfiguration$Builder r6 = r7.h(r8)
            androidx.media3.common.MediaItem$LiveConfiguration r6 = r6.f()
            r5.f6391s = r6
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.media3.exoplayer.hls.HlsMediaSource.J(androidx.media3.exoplayer.hls.playlist.HlsMediaPlaylist, long):void");
    }

    /* access modifiers changed from: protected */
    public void B() {
        this.f6388p.stop();
        this.f6383k.release();
    }

    public synchronized MediaItem a() {
        return this.f6393u;
    }

    public void c() throws IOException {
        this.f6388p.g();
    }

    public void h(HlsMediaPlaylist hlsMediaPlaylist) {
        long j2;
        long j3;
        SinglePeriodTimeline singlePeriodTimeline;
        if (hlsMediaPlaylist.f6511p) {
            j2 = Util.t1(hlsMediaPlaylist.f6503h);
        } else {
            j2 = -9223372036854775807L;
        }
        int i2 = hlsMediaPlaylist.f6499d;
        if (i2 == 2 || i2 == 1) {
            j3 = j2;
        } else {
            j3 = -9223372036854775807L;
        }
        HlsManifest hlsManifest = new HlsManifest((HlsMultivariantPlaylist) Assertions.f(this.f6388p.c()), hlsMediaPlaylist);
        if (this.f6388p.isLive()) {
            singlePeriodTimeline = C(hlsMediaPlaylist, j3, j2, hlsManifest);
        } else {
            singlePeriodTimeline = D(hlsMediaPlaylist, j3, j2, hlsManifest);
        }
        A(singlePeriodTimeline);
    }

    public MediaPeriod i(MediaSource.MediaPeriodId mediaPeriodId, Allocator allocator, long j2) {
        MediaSourceEventListener.EventDispatcher u2 = u(mediaPeriodId);
        DrmSessionEventListener.EventDispatcher s2 = s(mediaPeriodId);
        HlsExtractorFactory hlsExtractorFactory = this.f6380h;
        return new HlsMediaPeriod(hlsExtractorFactory, this.f6388p, this.f6381i, this.f6392t, (CmcdConfiguration) null, this.f6383k, s2, this.f6384l, u2, allocator, this.f6382j, this.f6385m, this.f6386n, this.f6387o, x(), this.f6390r);
    }

    public void l(MediaPeriod mediaPeriod) {
        ((HlsMediaPeriod) mediaPeriod).D();
    }

    public synchronized void o(MediaItem mediaItem) {
        this.f6393u = mediaItem;
    }

    /* access modifiers changed from: protected */
    public void z(TransferListener transferListener) {
        this.f6392t = transferListener;
        this.f6383k.a((Looper) Assertions.f(Looper.myLooper()), x());
        this.f6383k.prepare();
        this.f6388p.i(((MediaItem.LocalConfiguration) Assertions.f(a().f4079b)).f4171a, u((MediaSource.MediaPeriodId) null), this);
    }

    private HlsMediaSource(MediaItem mediaItem, HlsDataSourceFactory hlsDataSourceFactory, HlsExtractorFactory hlsExtractorFactory, CompositeSequenceableLoaderFactory compositeSequenceableLoaderFactory, CmcdConfiguration cmcdConfiguration, DrmSessionManager drmSessionManager, LoadErrorHandlingPolicy loadErrorHandlingPolicy, HlsPlaylistTracker hlsPlaylistTracker, long j2, boolean z2, int i2, boolean z3, long j3) {
        this.f6393u = mediaItem;
        this.f6391s = mediaItem.f4081d;
        this.f6381i = hlsDataSourceFactory;
        this.f6380h = hlsExtractorFactory;
        this.f6382j = compositeSequenceableLoaderFactory;
        this.f6383k = drmSessionManager;
        this.f6384l = loadErrorHandlingPolicy;
        this.f6388p = hlsPlaylistTracker;
        this.f6389q = j2;
        this.f6385m = z2;
        this.f6386n = i2;
        this.f6387o = z3;
        this.f6390r = j3;
    }
}
