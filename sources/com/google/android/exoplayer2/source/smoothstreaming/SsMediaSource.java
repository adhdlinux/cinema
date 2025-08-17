package com.google.android.exoplayer2.source.smoothstreaming;

import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import com.facebook.common.time.Clock;
import com.google.android.exoplayer2.ExoPlayerLibraryInfo;
import com.google.android.exoplayer2.MediaItem;
import com.google.android.exoplayer2.drm.DefaultDrmSessionManagerProvider;
import com.google.android.exoplayer2.drm.DrmSessionManager;
import com.google.android.exoplayer2.drm.DrmSessionManagerProvider;
import com.google.android.exoplayer2.offline.FilteringManifestParser;
import com.google.android.exoplayer2.offline.StreamKey;
import com.google.android.exoplayer2.source.BaseMediaSource;
import com.google.android.exoplayer2.source.CompositeSequenceableLoaderFactory;
import com.google.android.exoplayer2.source.DefaultCompositeSequenceableLoaderFactory;
import com.google.android.exoplayer2.source.LoadEventInfo;
import com.google.android.exoplayer2.source.MediaLoadData;
import com.google.android.exoplayer2.source.MediaPeriod;
import com.google.android.exoplayer2.source.MediaSource;
import com.google.android.exoplayer2.source.MediaSourceEventListener;
import com.google.android.exoplayer2.source.SinglePeriodTimeline;
import com.google.android.exoplayer2.source.smoothstreaming.DefaultSsChunkSource;
import com.google.android.exoplayer2.source.smoothstreaming.SsChunkSource;
import com.google.android.exoplayer2.source.smoothstreaming.manifest.SsManifest;
import com.google.android.exoplayer2.source.smoothstreaming.manifest.SsManifestParser;
import com.google.android.exoplayer2.upstream.Allocator;
import com.google.android.exoplayer2.upstream.DataSource;
import com.google.android.exoplayer2.upstream.DefaultLoadErrorHandlingPolicy;
import com.google.android.exoplayer2.upstream.LoadErrorHandlingPolicy;
import com.google.android.exoplayer2.upstream.Loader;
import com.google.android.exoplayer2.upstream.LoaderErrorThrower;
import com.google.android.exoplayer2.upstream.ParsingLoadable;
import com.google.android.exoplayer2.upstream.TransferListener;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.Util;
import com.google.android.gms.cast.framework.media.NotificationOptions;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import r0.a;

public final class SsMediaSource extends BaseMediaSource implements Loader.Callback<ParsingLoadable<SsManifest>> {
    private SsManifest A;
    private Handler B;

    /* renamed from: i  reason: collision with root package name */
    private final boolean f27109i;

    /* renamed from: j  reason: collision with root package name */
    private final Uri f27110j;

    /* renamed from: k  reason: collision with root package name */
    private final MediaItem.LocalConfiguration f27111k;

    /* renamed from: l  reason: collision with root package name */
    private final MediaItem f27112l;

    /* renamed from: m  reason: collision with root package name */
    private final DataSource.Factory f27113m;

    /* renamed from: n  reason: collision with root package name */
    private final SsChunkSource.Factory f27114n;

    /* renamed from: o  reason: collision with root package name */
    private final CompositeSequenceableLoaderFactory f27115o;

    /* renamed from: p  reason: collision with root package name */
    private final DrmSessionManager f27116p;

    /* renamed from: q  reason: collision with root package name */
    private final LoadErrorHandlingPolicy f27117q;

    /* renamed from: r  reason: collision with root package name */
    private final long f27118r;

    /* renamed from: s  reason: collision with root package name */
    private final MediaSourceEventListener.EventDispatcher f27119s;

    /* renamed from: t  reason: collision with root package name */
    private final ParsingLoadable.Parser<? extends SsManifest> f27120t;

    /* renamed from: u  reason: collision with root package name */
    private final ArrayList<SsMediaPeriod> f27121u;

    /* renamed from: v  reason: collision with root package name */
    private DataSource f27122v;

    /* renamed from: w  reason: collision with root package name */
    private Loader f27123w;

    /* renamed from: x  reason: collision with root package name */
    private LoaderErrorThrower f27124x;

    /* renamed from: y  reason: collision with root package name */
    private TransferListener f27125y;

    /* renamed from: z  reason: collision with root package name */
    private long f27126z;

    public static final class Factory implements MediaSource.Factory {

        /* renamed from: a  reason: collision with root package name */
        private final SsChunkSource.Factory f27127a;

        /* renamed from: b  reason: collision with root package name */
        private final DataSource.Factory f27128b;

        /* renamed from: c  reason: collision with root package name */
        private CompositeSequenceableLoaderFactory f27129c;

        /* renamed from: d  reason: collision with root package name */
        private DrmSessionManagerProvider f27130d;

        /* renamed from: e  reason: collision with root package name */
        private LoadErrorHandlingPolicy f27131e;

        /* renamed from: f  reason: collision with root package name */
        private long f27132f;

        /* renamed from: g  reason: collision with root package name */
        private ParsingLoadable.Parser<? extends SsManifest> f27133g;

        public Factory(DataSource.Factory factory) {
            this(new DefaultSsChunkSource.Factory(factory), factory);
        }

        /* renamed from: d */
        public SsMediaSource a(MediaItem mediaItem) {
            FilteringManifestParser filteringManifestParser;
            Assertions.e(mediaItem.f23129c);
            ParsingLoadable.Parser parser = this.f27133g;
            if (parser == null) {
                parser = new SsManifestParser();
            }
            List<StreamKey> list = mediaItem.f23129c.f23205d;
            if (!list.isEmpty()) {
                filteringManifestParser = new FilteringManifestParser(parser, list);
            } else {
                filteringManifestParser = parser;
            }
            return new SsMediaSource(mediaItem, (SsManifest) null, this.f27128b, filteringManifestParser, this.f27127a, this.f27129c, this.f27130d.a(mediaItem), this.f27131e, this.f27132f);
        }

        /* renamed from: e */
        public Factory b(DrmSessionManagerProvider drmSessionManagerProvider) {
            this.f27130d = (DrmSessionManagerProvider) Assertions.f(drmSessionManagerProvider, "MediaSource.Factory#setDrmSessionManagerProvider no longer handles null by instantiating a new DefaultDrmSessionManagerProvider. Explicitly construct and pass an instance in order to retain the old behavior.");
            return this;
        }

        /* renamed from: f */
        public Factory c(LoadErrorHandlingPolicy loadErrorHandlingPolicy) {
            this.f27131e = (LoadErrorHandlingPolicy) Assertions.f(loadErrorHandlingPolicy, "MediaSource.Factory#setLoadErrorHandlingPolicy no longer handles null by instantiating a new DefaultLoadErrorHandlingPolicy. Explicitly construct and pass an instance in order to retain the old behavior.");
            return this;
        }

        public Factory(SsChunkSource.Factory factory, DataSource.Factory factory2) {
            this.f27127a = (SsChunkSource.Factory) Assertions.e(factory);
            this.f27128b = factory2;
            this.f27130d = new DefaultDrmSessionManagerProvider();
            this.f27131e = new DefaultLoadErrorHandlingPolicy();
            this.f27132f = NotificationOptions.SKIP_STEP_THIRTY_SECONDS_IN_MS;
            this.f27129c = new DefaultCompositeSequenceableLoaderFactory();
        }
    }

    static {
        ExoPlayerLibraryInfo.a("goog.exo.smoothstreaming");
    }

    private void J() {
        SinglePeriodTimeline singlePeriodTimeline;
        long j2;
        long j3;
        for (int i2 = 0; i2 < this.f27121u.size(); i2++) {
            this.f27121u.get(i2).w(this.A);
        }
        long j4 = Long.MIN_VALUE;
        long j5 = Long.MAX_VALUE;
        for (SsManifest.StreamElement streamElement : this.A.f27139f) {
            if (streamElement.f27155k > 0) {
                j5 = Math.min(j5, streamElement.e(0));
                j4 = Math.max(j4, streamElement.e(streamElement.f27155k - 1) + streamElement.c(streamElement.f27155k - 1));
            }
        }
        if (j5 == Clock.MAX_TIME) {
            if (this.A.f27137d) {
                j3 = -9223372036854775807L;
            } else {
                j3 = 0;
            }
            SsManifest ssManifest = this.A;
            boolean z2 = ssManifest.f27137d;
            singlePeriodTimeline = new SinglePeriodTimeline(j3, 0, 0, 0, true, z2, z2, ssManifest, this.f27112l);
        } else {
            SsManifest ssManifest2 = this.A;
            if (ssManifest2.f27137d) {
                long j6 = ssManifest2.f27141h;
                if (j6 != -9223372036854775807L && j6 > 0) {
                    j5 = Math.max(j5, j4 - j6);
                }
                long j7 = j5;
                long j8 = j4 - j7;
                long F0 = j8 - Util.F0(this.f27118r);
                if (F0 < 5000000) {
                    F0 = Math.min(5000000, j8 / 2);
                }
                singlePeriodTimeline = new SinglePeriodTimeline(-9223372036854775807L, j8, j7, F0, true, true, true, this.A, this.f27112l);
            } else {
                long j9 = ssManifest2.f27140g;
                if (j9 != -9223372036854775807L) {
                    j2 = j9;
                } else {
                    j2 = j4 - j5;
                }
                singlePeriodTimeline = new SinglePeriodTimeline(j5 + j2, j2, j5, 0, true, false, false, this.A, this.f27112l);
            }
        }
        D(singlePeriodTimeline);
    }

    private void K() {
        if (this.A.f27137d) {
            this.B.postDelayed(new a(this), Math.max(0, (this.f27126z + 5000) - SystemClock.elapsedRealtime()));
        }
    }

    /* access modifiers changed from: private */
    public void L() {
        if (!this.f27123w.i()) {
            ParsingLoadable parsingLoadable = new ParsingLoadable(this.f27122v, this.f27110j, 4, this.f27120t);
            this.f27119s.z(new LoadEventInfo(parsingLoadable.f28482a, parsingLoadable.f28483b, this.f27123w.n(parsingLoadable, this, this.f27117q.a(parsingLoadable.f28484c))), parsingLoadable.f28484c);
        }
    }

    /* access modifiers changed from: protected */
    public void C(TransferListener transferListener) {
        this.f27125y = transferListener;
        this.f27116p.b(Looper.myLooper(), A());
        this.f27116p.prepare();
        if (this.f27109i) {
            this.f27124x = new LoaderErrorThrower.Dummy();
            J();
            return;
        }
        this.f27122v = this.f27113m.a();
        Loader loader = new Loader("SsMediaSource");
        this.f27123w = loader;
        this.f27124x = loader;
        this.B = Util.w();
        L();
    }

    /* access modifiers changed from: protected */
    public void E() {
        SsManifest ssManifest;
        if (this.f27109i) {
            ssManifest = this.A;
        } else {
            ssManifest = null;
        }
        this.A = ssManifest;
        this.f27122v = null;
        this.f27126z = 0;
        Loader loader = this.f27123w;
        if (loader != null) {
            loader.l();
            this.f27123w = null;
        }
        Handler handler = this.B;
        if (handler != null) {
            handler.removeCallbacksAndMessages((Object) null);
            this.B = null;
        }
        this.f27116p.release();
    }

    /* renamed from: G */
    public void p(ParsingLoadable<SsManifest> parsingLoadable, long j2, long j3, boolean z2) {
        ParsingLoadable<SsManifest> parsingLoadable2 = parsingLoadable;
        LoadEventInfo loadEventInfo = new LoadEventInfo(parsingLoadable2.f28482a, parsingLoadable2.f28483b, parsingLoadable.f(), parsingLoadable.d(), j2, j3, parsingLoadable.c());
        this.f27117q.b(parsingLoadable2.f28482a);
        this.f27119s.q(loadEventInfo, parsingLoadable2.f28484c);
    }

    /* renamed from: H */
    public void q(ParsingLoadable<SsManifest> parsingLoadable, long j2, long j3) {
        ParsingLoadable<SsManifest> parsingLoadable2 = parsingLoadable;
        LoadEventInfo loadEventInfo = new LoadEventInfo(parsingLoadable2.f28482a, parsingLoadable2.f28483b, parsingLoadable.f(), parsingLoadable.d(), j2, j3, parsingLoadable.c());
        this.f27117q.b(parsingLoadable2.f28482a);
        this.f27119s.t(loadEventInfo, parsingLoadable2.f28484c);
        this.A = parsingLoadable.e();
        this.f27126z = j2 - j3;
        J();
        K();
    }

    /* renamed from: I */
    public Loader.LoadErrorAction t(ParsingLoadable<SsManifest> parsingLoadable, long j2, long j3, IOException iOException, int i2) {
        Loader.LoadErrorAction loadErrorAction;
        ParsingLoadable<SsManifest> parsingLoadable2 = parsingLoadable;
        IOException iOException2 = iOException;
        LoadEventInfo loadEventInfo = new LoadEventInfo(parsingLoadable2.f28482a, parsingLoadable2.f28483b, parsingLoadable.f(), parsingLoadable.d(), j2, j3, parsingLoadable.c());
        long c2 = this.f27117q.c(new LoadErrorHandlingPolicy.LoadErrorInfo(loadEventInfo, new MediaLoadData(parsingLoadable2.f28484c), iOException2, i2));
        if (c2 == -9223372036854775807L) {
            loadErrorAction = Loader.f28465g;
        } else {
            loadErrorAction = Loader.h(false, c2);
        }
        boolean z2 = !loadErrorAction.c();
        this.f27119s.x(loadEventInfo, parsingLoadable2.f28484c, iOException2, z2);
        if (z2) {
            this.f27117q.b(parsingLoadable2.f28482a);
        }
        return loadErrorAction;
    }

    public MediaItem a() {
        return this.f27112l;
    }

    public void c() throws IOException {
        this.f27124x.a();
    }

    public MediaPeriod f(MediaSource.MediaPeriodId mediaPeriodId, Allocator allocator, long j2) {
        MediaSourceEventListener.EventDispatcher w2 = w(mediaPeriodId);
        SsMediaPeriod ssMediaPeriod = new SsMediaPeriod(this.A, this.f27114n, this.f27125y, this.f27115o, this.f27116p, u(mediaPeriodId), this.f27117q, w2, this.f27124x, allocator);
        this.f27121u.add(ssMediaPeriod);
        return ssMediaPeriod;
    }

    public void l(MediaPeriod mediaPeriod) {
        ((SsMediaPeriod) mediaPeriod).v();
        this.f27121u.remove(mediaPeriod);
    }

    private SsMediaSource(MediaItem mediaItem, SsManifest ssManifest, DataSource.Factory factory, ParsingLoadable.Parser<? extends SsManifest> parser, SsChunkSource.Factory factory2, CompositeSequenceableLoaderFactory compositeSequenceableLoaderFactory, DrmSessionManager drmSessionManager, LoadErrorHandlingPolicy loadErrorHandlingPolicy, long j2) {
        Uri uri;
        boolean z2 = false;
        Assertions.g(ssManifest == null || !ssManifest.f27137d);
        this.f27112l = mediaItem;
        MediaItem.LocalConfiguration localConfiguration = (MediaItem.LocalConfiguration) Assertions.e(mediaItem.f23129c);
        this.f27111k = localConfiguration;
        this.A = ssManifest;
        if (localConfiguration.f23202a.equals(Uri.EMPTY)) {
            uri = null;
        } else {
            uri = Util.B(localConfiguration.f23202a);
        }
        this.f27110j = uri;
        this.f27113m = factory;
        this.f27120t = parser;
        this.f27114n = factory2;
        this.f27115o = compositeSequenceableLoaderFactory;
        this.f27116p = drmSessionManager;
        this.f27117q = loadErrorHandlingPolicy;
        this.f27118r = j2;
        this.f27119s = w((MediaSource.MediaPeriodId) null);
        this.f27109i = ssManifest != null ? true : z2;
        this.f27121u = new ArrayList<>();
    }
}
