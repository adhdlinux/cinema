package androidx.media3.exoplayer.source;

import android.os.Looper;
import androidx.media3.common.MediaItem;
import androidx.media3.common.util.Assertions;
import androidx.media3.common.util.Util;
import androidx.media3.datasource.DataSource;
import androidx.media3.datasource.TransferListener;
import androidx.media3.exoplayer.analytics.PlayerId;
import androidx.media3.exoplayer.drm.DefaultDrmSessionManagerProvider;
import androidx.media3.exoplayer.drm.DrmSessionManager;
import androidx.media3.exoplayer.drm.DrmSessionManagerProvider;
import androidx.media3.exoplayer.source.MediaSource;
import androidx.media3.exoplayer.source.ProgressiveMediaExtractor;
import androidx.media3.exoplayer.source.ProgressiveMediaPeriod;
import androidx.media3.exoplayer.upstream.Allocator;
import androidx.media3.exoplayer.upstream.CmcdConfiguration;
import androidx.media3.exoplayer.upstream.DefaultLoadErrorHandlingPolicy;
import androidx.media3.exoplayer.upstream.LoadErrorHandlingPolicy;
import androidx.media3.extractor.ExtractorsFactory;
import androidx.media3.extractor.text.SubtitleParser;

public final class ProgressiveMediaSource extends BaseMediaSource implements ProgressiveMediaPeriod.Listener {

    /* renamed from: h  reason: collision with root package name */
    private final DataSource.Factory f7055h;

    /* renamed from: i  reason: collision with root package name */
    private final ProgressiveMediaExtractor.Factory f7056i;

    /* renamed from: j  reason: collision with root package name */
    private final DrmSessionManager f7057j;

    /* renamed from: k  reason: collision with root package name */
    private final LoadErrorHandlingPolicy f7058k;

    /* renamed from: l  reason: collision with root package name */
    private final int f7059l;

    /* renamed from: m  reason: collision with root package name */
    private boolean f7060m;

    /* renamed from: n  reason: collision with root package name */
    private long f7061n;

    /* renamed from: o  reason: collision with root package name */
    private boolean f7062o;

    /* renamed from: p  reason: collision with root package name */
    private boolean f7063p;

    /* renamed from: q  reason: collision with root package name */
    private TransferListener f7064q;

    /* renamed from: r  reason: collision with root package name */
    private MediaItem f7065r;

    public static final class Factory implements MediaSource.Factory {

        /* renamed from: a  reason: collision with root package name */
        private final DataSource.Factory f7067a;

        /* renamed from: b  reason: collision with root package name */
        private ProgressiveMediaExtractor.Factory f7068b;

        /* renamed from: c  reason: collision with root package name */
        private DrmSessionManagerProvider f7069c;

        /* renamed from: d  reason: collision with root package name */
        private LoadErrorHandlingPolicy f7070d;

        /* renamed from: e  reason: collision with root package name */
        private int f7071e;

        public Factory(DataSource.Factory factory, ExtractorsFactory extractorsFactory) {
            this(factory, (ProgressiveMediaExtractor.Factory) new w(extractorsFactory));
        }

        /* access modifiers changed from: private */
        public static /* synthetic */ ProgressiveMediaExtractor i(ExtractorsFactory extractorsFactory, PlayerId playerId) {
            return new BundledExtractorsAdapter(extractorsFactory);
        }

        public /* synthetic */ MediaSource.Factory a(SubtitleParser.Factory factory) {
            return k.c(this, factory);
        }

        public /* synthetic */ MediaSource.Factory b(boolean z2) {
            return k.a(this, z2);
        }

        public /* synthetic */ MediaSource.Factory f(CmcdConfiguration.Factory factory) {
            return k.b(this, factory);
        }

        /* renamed from: h */
        public ProgressiveMediaSource c(MediaItem mediaItem) {
            Assertions.f(mediaItem.f4079b);
            return new ProgressiveMediaSource(mediaItem, this.f7067a, this.f7068b, this.f7069c.a(mediaItem), this.f7070d, this.f7071e);
        }

        /* renamed from: j */
        public Factory d(DrmSessionManagerProvider drmSessionManagerProvider) {
            this.f7069c = (DrmSessionManagerProvider) Assertions.g(drmSessionManagerProvider, "MediaSource.Factory#setDrmSessionManagerProvider no longer handles null by instantiating a new DefaultDrmSessionManagerProvider. Explicitly construct and pass an instance in order to retain the old behavior.");
            return this;
        }

        /* renamed from: k */
        public Factory e(LoadErrorHandlingPolicy loadErrorHandlingPolicy) {
            this.f7070d = (LoadErrorHandlingPolicy) Assertions.g(loadErrorHandlingPolicy, "MediaSource.Factory#setLoadErrorHandlingPolicy no longer handles null by instantiating a new DefaultLoadErrorHandlingPolicy. Explicitly construct and pass an instance in order to retain the old behavior.");
            return this;
        }

        public Factory(DataSource.Factory factory, ProgressiveMediaExtractor.Factory factory2) {
            this(factory, factory2, new DefaultDrmSessionManagerProvider(), new DefaultLoadErrorHandlingPolicy(), 1048576);
        }

        public Factory(DataSource.Factory factory, ProgressiveMediaExtractor.Factory factory2, DrmSessionManagerProvider drmSessionManagerProvider, LoadErrorHandlingPolicy loadErrorHandlingPolicy, int i2) {
            this.f7067a = factory;
            this.f7068b = factory2;
            this.f7069c = drmSessionManagerProvider;
            this.f7070d = loadErrorHandlingPolicy;
            this.f7071e = i2;
        }
    }

    private MediaItem.LocalConfiguration C() {
        return (MediaItem.LocalConfiguration) Assertions.f(a().f4079b);
    }

    /* JADX WARNING: type inference failed for: r0v2, types: [androidx.media3.exoplayer.source.ProgressiveMediaSource$1] */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void D() {
        /*
            r9 = this;
            androidx.media3.exoplayer.source.SinglePeriodTimeline r8 = new androidx.media3.exoplayer.source.SinglePeriodTimeline
            long r1 = r9.f7061n
            boolean r3 = r9.f7062o
            r4 = 0
            boolean r5 = r9.f7063p
            r6 = 0
            androidx.media3.common.MediaItem r7 = r9.a()
            r0 = r8
            r0.<init>(r1, r3, r4, r5, r6, r7)
            boolean r0 = r9.f7060m
            if (r0 == 0) goto L_0x001c
            androidx.media3.exoplayer.source.ProgressiveMediaSource$1 r0 = new androidx.media3.exoplayer.source.ProgressiveMediaSource$1
            r0.<init>(r8)
            r8 = r0
        L_0x001c:
            r9.A(r8)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.media3.exoplayer.source.ProgressiveMediaSource.D():void");
    }

    /* access modifiers changed from: protected */
    public void B() {
        this.f7057j.release();
    }

    public synchronized MediaItem a() {
        return this.f7065r;
    }

    public void b(long j2, boolean z2, boolean z3) {
        if (j2 == -9223372036854775807L) {
            j2 = this.f7061n;
        }
        if (this.f7060m || this.f7061n != j2 || this.f7062o != z2 || this.f7063p != z3) {
            this.f7061n = j2;
            this.f7062o = z2;
            this.f7063p = z3;
            this.f7060m = false;
            D();
        }
    }

    public void c() {
    }

    public MediaPeriod i(MediaSource.MediaPeriodId mediaPeriodId, Allocator allocator, long j2) {
        DataSource a2 = this.f7055h.a();
        TransferListener transferListener = this.f7064q;
        if (transferListener != null) {
            a2.n(transferListener);
        }
        MediaItem.LocalConfiguration C = C();
        return new ProgressiveMediaPeriod(C.f4171a, a2, this.f7056i.a(x()), this.f7057j, s(mediaPeriodId), this.f7058k, u(mediaPeriodId), this, allocator, C.f4175e, this.f7059l, Util.P0(C.f4179i));
    }

    public void l(MediaPeriod mediaPeriod) {
        ((ProgressiveMediaPeriod) mediaPeriod).g0();
    }

    public synchronized void o(MediaItem mediaItem) {
        this.f7065r = mediaItem;
    }

    /* access modifiers changed from: protected */
    public void z(TransferListener transferListener) {
        this.f7064q = transferListener;
        this.f7057j.a((Looper) Assertions.f(Looper.myLooper()), x());
        this.f7057j.prepare();
        D();
    }

    private ProgressiveMediaSource(MediaItem mediaItem, DataSource.Factory factory, ProgressiveMediaExtractor.Factory factory2, DrmSessionManager drmSessionManager, LoadErrorHandlingPolicy loadErrorHandlingPolicy, int i2) {
        this.f7065r = mediaItem;
        this.f7055h = factory;
        this.f7056i = factory2;
        this.f7057j = drmSessionManager;
        this.f7058k = loadErrorHandlingPolicy;
        this.f7059l = i2;
        this.f7060m = true;
        this.f7061n = -9223372036854775807L;
    }
}
